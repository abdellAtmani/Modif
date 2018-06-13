package migrationRoundtrip;

import java.io.IOException;
import java.util.*;

import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.EcoreUtil;

import utils.UtilEMF;
import migration.*;
import dependency.*;

/**
 * This class enables a complete migration rountrip step by step from an input source
 * model to an output rewrited model. <p>
 * This roundtrip aims at enabling the reuse of a rewriting tool defined on a target metamodel
 * different from the metamodel of the input source model.
 * <ul> 
 * <li> The first step called onward migration enables the migration of the input
 * source model to a new model conforming to the target metamodel.</li> 
 * <li> The second step called reverse migration enables the migration of a given model
 * to a new model conforming to the source metamodel. This given model typically is
 * a rewrited version of the migrated model.</li> 
 * <li> The third step called recontextualization by keys makes it possible to put back the
 * original context on the reverse migrated model.</li> 
 * <li> The fourth and last step called recontextualization by graphs enables a more precise 
 * recontextualization thanks to a dependency graph. This graph relates the rewrited
 * instances to the input instances that have been used to compute them.</li> 
 * </ul>
 * @author M. Kerboeuf
 */
public class MigrationRoundtrip {

	// PRIVATE Attributes************************************************************************

	private String UUIDtimeStamp;

	private EPackage metamodelSource;
	private EPackage metamodelTarget;

	private EObject model1SInit;
	private EObject model2TMigrated;
	private EObject model3TToolProcessed;
	private EObject model4SReverseMigrated;
	private EObject model5SRecontextualizedByKeys;
	private EObject model6SRecontextualizedByGraph;

	Map<String, EObject> instances = new HashMap<String, EObject>();
	Map<String, String> hide = new HashMap<String, String>();
	Map<String, Map<String, ArrayList<Object>>> addDerivedReferencesMap = new HashMap<String, Map<String,ArrayList<Object>>>();
	Map<String, Map<String, ArrayList<Object>>> hiddenReferencesMap = new HashMap<String, Map<String,ArrayList<Object>>>();

	private String model2TMigratedFilePath;

	private DeletedLinks deletedLinks;
	//	private HiddenLinks hiddenLinks;
	private Triplet<Object, EStructuralFeature, Object> unrecoveredLinks;

	// PRIVATE **********************************************************************************

	private Object resolveTarget(Object target, Map<String, EObject> mapUUIDmodel, EObject instance, EReference r) {
		String targetUUID = UtilEMF.getUUID(target);
		if (targetUUID != null) target = mapUUIDmodel.get(targetUUID);
		if (target     != null) return target; // resolved target
		// The target is unresolved:
		String instanceUUID = UtilEMF.getUUID(instance); // UUID of the containing instance
		if (instanceUUID==null) this.unrecoveredLinks.put(instance,     r, targetUUID);
		else                    this.unrecoveredLinks.put(instanceUUID, r, targetUUID);
		return null;
	}

	private void removeUnresolvedReferences(EObject root) {
		// Instances dictionary:
		Map<String, EObject> mapUUIDmodel = UtilEMF.createUUIDMap(root);
		// Scan of instances:
		for (EObject instance : UtilEMF.getAllInstances(root))
			for (EReference r : instance.eClass().getEAllReferences()) // reference to scan
				if (!r.isContainment() && !r.isContainer() && instance.eIsSet(r)) { // non-part of composite reference
					Object target = instance.eGet(r);
					if (r.isMany()) { 
						EList<Object> listOfUpdatedReferencedInstances = new BasicEList<Object>();
						for (Object targetElement : (Collection<?>)target) {
							Object resolvedTarget = this.resolveTarget(targetElement, mapUUIDmodel, instance, r);
							if (resolvedTarget != null) listOfUpdatedReferencedInstances.add(resolvedTarget);
						}
						instance.eSet(r, listOfUpdatedReferencedInstances);
					}
					else instance.eSet(r, this.resolveTarget(target, mapUUIDmodel, instance, r));
				}
	}

	/**
	 * Update of references thanks to a denpendency graph.
	 * @param reversedDependencyGraph The reverse dependency graph.
	 * @param mapUUIDmodelSInitCopy UUID dictionary of initial model.
	 * @return true if the model has been updated.
	 */
	@SuppressWarnings("unchecked")
	private boolean updateReferencesWithDependencies(ReversedDependency reversedDependencyGraph, Map<String, EObject> mapUUIDmodelSInitCopy) {
		boolean update=false;
		Map<String, EObject> mapUUIDmodelRecontextualized = UtilEMF.createUUIDMap(this.model6SRecontextualizedByGraph);
		// Scan of unrecovered links:
		for (Object sourceUUID : this.unrecoveredLinks.key1Set()) {
			List<EObject> sourceCandidates = new ArrayList<EObject>();
			EObject matchingSource = mapUUIDmodelRecontextualized.get(sourceUUID);
			if (matchingSource!=null) sourceCandidates.add(matchingSource); // there is an exact source candidate
			else {
				Set<String> replacement = reversedDependencyGraph.getDependentUUIDs(sourceUUID);
				if (replacement!=null)
					for (String sourceReplacementUUID : replacement) {
						matchingSource = mapUUIDmodelRecontextualized.get(sourceReplacementUUID);
						if (matchingSource!=null) sourceCandidates.add(matchingSource);
					}
			}
			for (EStructuralFeature esf : this.unrecoveredLinks.key2Set(sourceUUID)) {
				for (Object target : this.unrecoveredLinks.get(sourceUUID, esf)) {
					List<Object> targetCandidates = new ArrayList<Object>();
					if (esf instanceof EAttribute || !(target instanceof String)) targetCandidates.add(target); // there is an exact target candidate
					else { // esf is an EReference and target is a String
						Object matchingTarget = mapUUIDmodelRecontextualized.get(target);
						if (matchingTarget==null) matchingTarget = mapUUIDmodelSInitCopy.get(target);
						if (matchingTarget!=null && ((EReference) esf).isContainment()) targetCandidates.add(matchingTarget); // there is an exact target candidate
						else {
							Set<String> replacement = reversedDependencyGraph.getDependentUUIDs(target);
							if (replacement!=null)
								for (String targetReplacementUUID : replacement) {
									matchingTarget = mapUUIDmodelRecontextualized.get(targetReplacementUUID);
									if (matchingTarget==null && ((EReference) esf).isContainment()) matchingTarget = mapUUIDmodelSInitCopy.get(targetReplacementUUID);
									if (matchingTarget!=null) targetCandidates.add(matchingTarget);
								}
						}
					}
					boolean notFound=true;
					for (int i=0; i<sourceCandidates.size() && notFound; i++) {
						EObject s = sourceCandidates.get(i);
						for (int j=0; j<targetCandidates.size() && notFound; j++) {
							Object o = targetCandidates.get(j);
							if (esf.isMany() || !s.eIsSet(esf)) {				
								try {
									if (esf.isMany()) ((Collection<Object>)s.eGet(esf)).add(o);
									else s.eSet(esf, o);
									this.unrecoveredLinks.remove(sourceUUID, esf, target);
									notFound=false;
									update=true;
								}
								catch (Exception e) {}
							}
						}
					}
				}
			}				
		}			
		return update;
	}

	// PUBLIC ***********************************************************************************

	/**
	 * Unique constructor of a migration roundtrip from a migration specification.
	 * @param migration Input migration specification. 
	 */
	public MigrationRoundtrip(Migration migration) {
		// Extraction of URIs:
		URI inputModelFile      = URI.createURI(migration.getInputModelURI()     );
		URI inputMetamodelFile  = URI.createURI(migration.getInputMetamodelURI() );
		URI outputFile          = URI.createURI(migration.getOutputModelURI()    );
		URI outputMetamodelFile = URI.createURI(migration.getOutputMetamodelURI());
		// Initialisation of metamodels and of the input model:	
		this.metamodelSource = UtilEMF.loadMetamodel(inputMetamodelFile);
				
		this.metamodelTarget = UtilEMF.loadMetamodel(outputMetamodelFile);
				
		//this.model1SInit     = UtilEMF.loadModel(inputModelFile, this.metamodelSource);
		this.model1SInit 	= migration.getInputModel();

		// Get timestamp for the initial model
		for(EAttribute attribute : this.model1SInit.eClass().getEAllAttributes()){
			if(attribute.getName().contains("UUID")){
				UUIDtimeStamp = attribute.getName();
				break;
			}
		}
		// Initialisation of migrated model file path (the migrated model is not created here):
		this.model2TMigratedFilePath = outputFile.path();
		// Extraction of deleted links:
		this.deletedLinks = new DeletedLinks(this.model1SInit, migration, UUIDtimeStamp);
		//this.hiddenReferencesMap = this.deletedLinks.buildReferencesMap();
	}
	
	public MigrationRoundtrip(Migration migration, EPackage targetMetamodel) {
		// Extraction of URIs:
		URI inputModelFile      = URI.createURI(migration.getInputModelURI()     );
		URI inputMetamodelFile  = URI.createURI(migration.getInputMetamodelURI());
		URI outputFile          = URI.createURI(migration.getOutputModelURI()    );
		URI outputMetamodelFile = URI.createURI(migration.getOutputMetamodelURI());
		// Initialisation of metamodels and of the input model:	
		this.metamodelSource = UtilEMF.loadMetamodel(inputMetamodelFile);
				
		this.metamodelTarget = targetMetamodel;
				
		//this.model1SInit     = UtilEMF.loadModel(inputModelFile, this.metamodelSource);
		this.model1SInit 	= migration.getInputModel();

		// Get timestamp for the initial model
		for(EAttribute attribute : this.model1SInit.eClass().getEAllAttributes()){
			if(attribute.getName().contains("UUID")){
				UUIDtimeStamp = attribute.getName();
				break;
			}
		}
		// Initialisation of migrated model file path (the migrated model is not created here):
		this.model2TMigratedFilePath = outputFile.path();
		// Extraction of deleted links:
		this.deletedLinks = new DeletedLinks(this.model1SInit, migration, UUIDtimeStamp);
		//this.hiddenReferencesMap = this.deletedLinks.buildReferencesMap();
	}

	
	public MigrationRoundtrip(Migration migration, EPackage sourceMetamodel, EPackage targetMetamodel) {
		// Extraction of URIs:
		URI inputModelFile      = URI.createURI(migration.getInputModelURI());
		URI inputMetamodelFile  = URI.createURI(migration.getInputMetamodelURI());
		URI outputFile          = URI.createURI(migration.getOutputModelURI());
		URI outputMetamodelFile = URI.createURI(migration.getOutputMetamodelURI());
		// Initialisation of metamodels and of the input model:	
		this.metamodelSource = sourceMetamodel;
				
		this.metamodelTarget = targetMetamodel;
				
		//this.model1SInit     = UtilEMF.loadModel(inputModelFile, this.metamodelSource);
		this.model1SInit 	= migration.getInputModel();

		// Get timestamp for the initial model
		for(EAttribute attribute : this.model1SInit.eClass().getEAllAttributes()){
			if(attribute.getName().contains("UUID")){
				UUIDtimeStamp = attribute.getName();
				break;
			}
		}
		// Initialisation of migrated model file path (the migrated model is not created here):
		this.model2TMigratedFilePath = outputFile.path();
		// Extraction of deleted links:
		this.deletedLinks = new DeletedLinks(this.model1SInit, migration, UUIDtimeStamp);
		//this.hiddenReferencesMap = this.deletedLinks.buildReferencesMap();
	}
	
	/**
	 * Handles onwardMigration when there is rename in the modif specification
	 * 
	 * @param renameMap 
	 * @return A copy of the migrated model.
	 */
	public EObject onwardMigration() {
		// Copy of initial model:
		EObject model1SInitCopy = EcoreUtil.copy(this.model1SInit);
		// Instance dictionary from this copy:
		Map<String, EObject> mapUUIDmodelSInitCopy = UtilEMF.createUUIDMap(model1SInitCopy, UUIDtimeStamp);
		// Scan of deleted links:
		for (String s : this.deletedLinks.getSourceUUIDs()){
			for (EStructuralFeature esf : this.deletedLinks.getDeletedFeatures(s)){
				for (Object o : this.deletedLinks.getDeletedFeatureValues(s, esf)) {
					EObject sourceInstance = mapUUIDmodelSInitCopy.get(s);
					if(sourceInstance != null){
						if (esf instanceof EReference && o instanceof String) o = mapUUIDmodelSInitCopy.get(o);
						if (esf.isMany()) ((Collection<?>)sourceInstance.eGet(esf)).remove(o);
						else sourceInstance.eUnset(esf);
					}
				}
			}
		}
		
		System.out.println(" +++ targetMetamodelUUID : --- "+ this.metamodelTarget.getName());
		for(EClassifier ec: this.metamodelTarget.getEClassifiers()){
			System.out.print(ec.getName()+ " : ");
			for(EObject ea : ec.eContents()){
				if(ea instanceof EAttribute){
					System.out.println(((EAttribute) ea).getName());
				}
			}
		}

		
		
		// Metamodel update:		
		this.model2TMigrated = UtilEMF.changeMetamodel(model1SInitCopy, this.metamodelTarget);
		return this.model2TMigrated;
	}


	public EObject onwardMigrationRename(Map<String, Map<String, Map<String, String>>> renameMap) {
		// Copy of initial model:
		EObject model1SInitCopy = EcoreUtil.copy(this.model1SInit);
		// Instance dictionary from this copy:
		Map<String, EObject> mapUUIDmodelSInitCopy = UtilEMF.createUUIDMap(model1SInitCopy);
		// Scan of deleted links:
		for (String s : this.deletedLinks.getSourceUUIDs()){
			for (EStructuralFeature esf : this.deletedLinks.getDeletedFeatures(s)){
				for (Object o : this.deletedLinks.getDeletedFeatureValues(s, esf)) {
					EObject sourceInstance = mapUUIDmodelSInitCopy.get(s);
					if (esf instanceof EReference && o instanceof String) o = mapUUIDmodelSInitCopy.get(o);
					if (esf.isMany()) ((Collection<?>)sourceInstance.eGet(esf)).remove(o);
					else sourceInstance.eUnset(esf);
				}
			}
		}
		// Metamodel update:
		this.model2TMigrated = UtilEMF.changeMetamodel(model1SInitCopy, this.metamodelTarget, renameMap);
		return this.model2TMigrated;
	}


	public boolean isHidden(EObject model1SInitCopy, Migration migration, Instance searchedInstance){
		boolean isHidden = false;
		EObject searched = null;

		for(Instance instance : migration.getInstances()){
			for(EObject object : model1SInitCopy.eContents()){
				if(object.eGet(object.eClass().getEStructuralFeature("UUID")).toString().equals(instance.getUUID())){
					searched = object;
					break;
				}
			}
		}
		for(Instance instance : migration.getInstances()){
			if(instance.getDerived() != null){
				for(EObject object : model1SInitCopy.eContents()){
					if(object.eContainmentFeature().getName().equals(searched.eContainmentFeature().getName())){
						isHidden = true;
						break;
					}
				}
			}
		}
		return isHidden;
	}


	/**
	 * Handles onwardMigration when there is hide in the modif specification
	 * 
	 * @param renameMap
	 * @param hideMap
	 * @return a copy of the migrated model
	 */
	public EObject onwardMigrationHide(Migration migrationHide, Map<String,String> newReferencesNameMap, Map<String, Map<String, Map<String, String>>> renameMap) {
		boolean deleted = false;
		// Copy of initial model:
		EObject model1SInitCopy = EcoreUtil.copy(this.model1SInit);
		EObject model1SInitCopy2 = EcoreUtil.copy(this.model1SInit);
		// Instance dictionary from this copy:
		Map<String, EObject> mapUUIDmodelSInitCopy = UtilEMF.createUUIDMap(model1SInitCopy);
		// Scan of deleted links:
		for (String s : this.deletedLinks.getSourceUUIDs()){
			deleted = true;		
			EList<DerivedReference> derivedReferences = hasAddDerived(s, migrationHide);
			if(derivedReferences != null){
				Map<String, ArrayList<Object>> newReferencesMap = new HashMap<String, ArrayList<Object>>();
				Map<String, ArrayList<Object>> oldReferencesMap = new HashMap<String, ArrayList<Object>>();
				for(DerivedReference derived : derivedReferences){	
					for (EStructuralFeature esf : this.deletedLinks.getDeletedFeatures(s)){
						ArrayList<Object> newObjects = new ArrayList<Object>();
						for (Object o : this.deletedLinks.getDeletedFeatureValues(s, esf)) {
							EObject sourceInstance = mapUUIDmodelSInitCopy.get(s);
							for (String ss : this.deletedLinks.getSourceUUIDs()){
								if(ss.equals(o.toString())){
									for (EStructuralFeature esf2 : this.deletedLinks.getDeletedFeatures(ss)){
										for (Object o2 : this.deletedLinks.getDeletedFeatureValues(ss, esf2)) {
											newObjects.add(o2);
											newReferencesMap.put(derived.getNewReferenceName(), newObjects);
											oldReferencesMap.put(derived.getNewReferenceName(), newObjects);
										}
									}
								}
							}
							if (esf instanceof EReference && o instanceof String){ o = mapUUIDmodelSInitCopy.get(o); }
							if (esf.isMany()){ ((Collection<?>) sourceInstance.eGet(esf)).remove(o); }
							else{ sourceInstance.eUnset(esf); }
						}
					}
				}
				this.addDerivedReferencesMap.put(s, newReferencesMap);
			}else{
				for (EStructuralFeature esf : this.deletedLinks.getDeletedFeatures(s)){
					for (Object o : this.deletedLinks.getDeletedFeatureValues(s, esf)) {
						EObject sourceInstance = mapUUIDmodelSInitCopy.get(s);
						if (esf instanceof EReference && o instanceof String){ o = mapUUIDmodelSInitCopy.get(o); }
						if (esf.isMany()){ ((Collection<?>)sourceInstance.eGet(esf)).remove(o); }
						else{ sourceInstance.eUnset(esf); }
					}
				}
			}
		}
		// flatten and hide
		if(!deleted){
			for(Instance i : migrationHide.getInstances()){
				if(!i.getDerived().isEmpty()){
					addDerivedReferencesMap = UtilEMF.buildMapDerived();
				}
			}
		}
		// Metamodel update:
		this.model2TMigrated = UtilEMF.changeMetamodel(model1SInitCopy, model1SInitCopy2, this.metamodelTarget, migrationHide, 
				this.addDerivedReferencesMap, this.hiddenReferencesMap, newReferencesNameMap, renameMap);
		return this.model2TMigrated;
	}





	public EList<DerivedReference> hasAddDerived(String instance, Migration migration){
		EList<DerivedReference> derivedReference = null;
		for(Instance inst : migration.getInstances()){
			if(inst.getUUID().equals(instance)){
				if(!inst.getDerived().isEmpty()){
					derivedReference = inst.getDerived();
					break;
				}
			}
		}
		return derivedReference;
	}

	/*if(!hiddenInstancesList.contains(s)){

				for (EStructuralFeature esf : this.deletedLinks.getDeletedFeatures(s)){
					for(Instance instance : migrationHide.getInstances()){
						if(hiddenInstancesList.contains(instance.getUUID())){
							if(!s.equals(instance.getUUID())){
								if(isHidden(model1SInitCopy, migrationHide, instance)){
									for (Object o : this.deletedLinks.getDeletedFeatureValues(s, esf)) {
										EObject sourceInstance = mapUUIDmodelSInitCopy.get(s);
										if (esf instanceof EReference && o instanceof String){ 
											o = mapUUIDmodelSInitCopy.get(o);
										}
										if (esf.isMany()){ 
											if(!esf.getName().equals("places") || !esf.getName().equals("neighborhoods")){

												((Collection<?>)sourceInstance.eGet(esf)).remove(o);
											}
										}else{
											sourceInstance.eUnset(esf);
										}
									}
								}else{
									for (Object o : this.deletedLinks.getDeletedFeatureValues(s, esf)) {
										EObject sourceInstance = mapUUIDmodelSInitCopy.get(s);
										if (esf instanceof EReference && o instanceof String){ 
											o = mapUUIDmodelSInitCopy.get(o);
										}
										if (esf instanceof EReference && o instanceof String){ 
											o = mapUUIDmodelSInitCopy.get(o);
										}
										if (esf.isMany()){ 
											if(!esf.getName().equals("places") || !esf.getName().equals("neighborhoods")){
												((Collection<?>)sourceInstance.eGet(esf)).remove(o);
											}
										}else{
											sourceInstance.eUnset(esf);
										}
									}
								}
							}
						}
					}
				}
			}*/
	//}
	//}


	public EObject onwardMigration(Map<String, Map<String, Map<String ,String>>> renameMap, Map<String, Map<String, ArrayList<ArrayList<String>>>> hideMap) {
		long start = System.nanoTime();
		// Copy of initial model:
		EObject model1SInitCopy = EcoreUtil.copy(this.model1SInit);
		EObject model1SInitCopy2 = EcoreUtil.copy(this.model1SInit);

		// Instance dictionary from this copy:
		Map<String, EObject> mapUUIDmodelSInitCopy = UtilEMF.createUUIDMap(model1SInitCopy);
		// Scan of deleted links:
		for (String s : this.deletedLinks.getSourceUUIDs()){		
			for (EStructuralFeature esf : this.deletedLinks.getDeletedFeatures(s)){
				for (Object o : this.deletedLinks.getDeletedFeatureValues(s, esf)) {
					EObject sourceInstance = mapUUIDmodelSInitCopy.get(s);
					if (esf instanceof EReference && o instanceof String){ 
						o = mapUUIDmodelSInitCopy.get(o);}
					if (esf.isMany()){ ((Collection<?>)sourceInstance.eGet(esf)).remove(o); }
					else { sourceInstance.eUnset(esf); }
				}
			}
		}
		// migrated model
		//	this.model2TMigrated = UtilEMF.changeMetamodel(model1SInitCopy2, model1SInitCopy, this.metamodelTarget, renameMap, hideMap, false);
		System.out.print("Ok ("+(System.nanoTime()-start)/1000000.0+" ms).");
		return this.model2TMigrated;
	}


	/**
	 * Serialization of the migrated model.
	 * This action cannot be performed before the onward migration.
	 * @throws IOException Thrown if the output file cannot be created.
	 */
	public void serializeMigratedModel() throws IOException {	
		if (this.model2TMigrated==null) // The input model has not been migrated yet.
			throw new IllegalStateException("The migrated model cannot be serialized before the onward migration.");
		UtilEMF.saveModel(this.model2TMigrated, this.model2TMigratedFilePath);
	}




	public String getmodel2TMigratedFilePath(){
		return this.model2TMigratedFilePath;
	}

	/**
	 * Second step: reverse migration.
	 * This action cannot be performed before the onward migration.
	 * @param tModel3ToolProcessed Model to be reverse migrated (typically a rewrited version
	 * of the migrated model).
	 * @return The reverse migrated model.
	 */
	public EObject reverseMigration(EObject tModel3ToolProcessed) {
		if (this.model2TMigrated==null) // The input model has not been migrated yet.
			throw new IllegalStateException("The reverse migration cannot be performed before the onward migration.");
		this.model3TToolProcessed           = EcoreUtil.copy(tModel3ToolProcessed);
		this.model4SReverseMigrated         = UtilEMF.changeMetamodel(null, this.model3TToolProcessed, this.metamodelSource);
		return this.model4SReverseMigrated;
	}

	public EObject reverseMigration(EObject tModel3ToolProcessed, Map<String, Map<String, Map<String ,String>>> renameMap) {
		if (this.model2TMigrated==null) // The input model has not been migrated yet.
			throw new IllegalStateException("The reverse migration cannot be performed before the onward migration.");
		this.model3TToolProcessed           = EcoreUtil.copy(tModel3ToolProcessed);
		this.model4SReverseMigrated         = UtilEMF.changeMetamodel(this.model3TToolProcessed, this.metamodelSource);
		return this.model4SReverseMigrated;
	}

	public EObject reverseMigration(EObject tModel3ToolProcessed, Map<String, Map<String, Map<String ,String>>> renameMap, Migration migrationHide) {
		if (this.model2TMigrated==null) // The input model has not been migrated yet.
			throw new IllegalStateException("The reverse migration cannot be performed before the onward migration.");
		this.model3TToolProcessed           = EcoreUtil.copy(tModel3ToolProcessed);
		this.model4SReverseMigrated         = UtilEMF.changeMetamodel(null, this.model3TToolProcessed, this.metamodelSource, renameMap, migrationHide, true);
		return this.model4SReverseMigrated;
	}	

	/**
	 * Third step: recontextualization by keys (UUIDs).
	 * This action cannot be performed before the onward migration.
	 * It implies the reverse migration.
	 * @param tModel3ToolProcessed Model to be reverse migrated and then recontextualized
	 * (typically a rewrited version of the migrated model).
	 * @return The recontextualized model.
	 */
	public EObject recontextualizationKey(EObject tModel3ToolProcessed) {
		this.reverseMigration(tModel3ToolProcessed);
		return recontextualizationKey();
	}

	/**
	 * Third step: recontextualization by keys (UUIDs).
	 * This action cannot be performed before the reverse migration.
	 * @return The recontextualized model.
	 */
	@SuppressWarnings("unchecked")
	public EObject recontextualizationKey() {
		if (this.model4SReverseMigrated==null) // The input model has not been reverse migrated yet.
			throw new IllegalStateException("The recontextualization by keys cannot be performed before a reverse migration.");
		// We start from a copy of the reverse migrated model:
		this.model5SRecontextualizedByKeys = EcoreUtil.copy(this.model4SReverseMigrated);
		System.out.println("[K Recontextualization of "+this.metamodelSource.getName()+"."+this.model5SRecontextualizedByKeys.eClass().getName()+" ("+UtilEMF.getUUID(this.model5SRecontextualizedByKeys)+")]");
		// UUIDs dictionaries:
		Map<String, EObject> mapUUIDmodelRecontextualized = UtilEMF.createUUIDMap(this.model5SRecontextualizedByKeys);
		Map<String, EObject> mapUUIDmodelSInitCopy        = UtilEMF.createUUIDMap(EcoreUtil.copy(this.model1SInit));
		// Set of unrecovered links:
		this.unrecoveredLinks = new Triplet<Object, EStructuralFeature, Object>();
		// Scan of deleted links:
		for (String s : this.deletedLinks.getSourceUUIDs())
			for (EStructuralFeature esf : this.deletedLinks.getDeletedFeatures(s))
				for (Object o : this.deletedLinks.getDeletedFeatureValues(s, esf)) {
					EObject sourceInstance = mapUUIDmodelRecontextualized.get(s);
					if (sourceInstance!=null) { // The source link is still in the model
						if (esf instanceof EReference && o instanceof String) o = mapUUIDmodelSInitCopy.get(o);
						if (esf.isMany()) ((Collection<Object>)sourceInstance.eGet(esf)).add(o);
						else if (!sourceInstance.eIsSet(esf)) sourceInstance.eSet(esf, o);
					}
					else this.unrecoveredLinks.put(s, esf, o);
				}
		// Resolution of external references:
		this.removeUnresolvedReferences(this.model5SRecontextualizedByKeys);
		// Display of unrecovered links:
		for(Object source : this.unrecoveredLinks.key1Set())
			for (EStructuralFeature esf : this.unrecoveredLinks.key2Set(source))
				for (Object target : this.unrecoveredLinks.get(source, esf))
					System.out.println("   Unrecoverable link ("+source+")."+esf.getName()+" -> ("+target+")");	
		// Final version of the updated reverse migrated model:
		return this.model5SRecontextualizedByKeys;
	}

	/**
	 * Third step: recontextualization by keys (UUIDs).
	 * This action cannot be performed before the reverse migration.
	 * @return The recontextualized model.
	 */
	@SuppressWarnings("unchecked")
	public EObject recontextualizationKeyHide() {
		if (this.model4SReverseMigrated==null) // The input model has not been reverse migrated yet.
			throw new IllegalStateException("The recontextualization by keys cannot be performed before a reverse migration.");
		// We start from a copy of the reverse migrated model:
		this.model5SRecontextualizedByKeys = EcoreUtil.copy(this.model4SReverseMigrated);
		System.out.println("[K Recontextualization of "+this.metamodelSource.getName()+"."+this.model5SRecontextualizedByKeys.eClass().getName()+" ("+UtilEMF.getUUID(this.model5SRecontextualizedByKeys)+")]");
		// UUIDs dictionaries:
		Map<String, EObject> mapUUIDmodelRecontextualized = UtilEMF.createUUIDMap(this.model5SRecontextualizedByKeys);
		Map<String, EObject> mapUUIDmodelSInitCopy        = UtilEMF.createUUIDMap(EcoreUtil.copy(this.model1SInit));
		// Set of unrecovered links:
		this.unrecoveredLinks = new Triplet<Object, EStructuralFeature, Object>();
		// Scan of deleted links:
		for (String s : this.deletedLinks.getSourceUUIDs()){
			for (EStructuralFeature esf : this.deletedLinks.getDeletedFeatures(s)){
				if(esf.getName().equals("ref_F") || esf.getName().equals("att_b") ){
					for (Object o : this.deletedLinks.getDeletedFeatureValues(s, esf)) {
						EObject sourceInstance = mapUUIDmodelRecontextualized.get(s);
						if (sourceInstance!=null) { // The source link is still in the model
							if (esf instanceof EReference && o instanceof String){
								o = mapUUIDmodelSInitCopy.get(o);
							}
							if (esf.isMany()){
								((Collection<Object>)sourceInstance.eGet(esf)).add(o);
							}
							else if (!sourceInstance.eIsSet(esf)){
								sourceInstance.eSet(esf, o);
							}
						}
						else this.unrecoveredLinks.put(s, esf, o);
					}
				}else if(esf.getName().equals("ref_B")){
					for (Object o : this.deletedLinks.getDeletedFeatureValues("1", esf)) {

						EObject sourceInstance = mapUUIDmodelRecontextualized.get("1");
						if (sourceInstance!=null) {
							if (esf instanceof EReference && o instanceof String){
								o = mapUUIDmodelSInitCopy.get(o);
							}
							if (esf.isMany()){
								((Collection<Object>)sourceInstance.eGet(esf)).add(o);
							}
							else if (!sourceInstance.eIsSet(esf)){
								sourceInstance.eSet(esf, o);
							}
						}
					}
				}
			}
		}
		// Resolution of external references:
		this.removeUnresolvedReferences(this.model5SRecontextualizedByKeys);
		// Display of unrecovered links:
		for(Object source : this.unrecoveredLinks.key1Set())
			for (EStructuralFeature esf : this.unrecoveredLinks.key2Set(source))
				for (Object target : this.unrecoveredLinks.get(source, esf))
					System.out.println("   Unrecoverable link ("+source+")."+esf.getName()+" -> ("+target+")");	
		// Final version of the updated reverse migrated model:
		return this.model5SRecontextualizedByKeys;
	}


	/**
	 * Forth and last step: recontextualization by graph.
	 * This action cannot be performed before the onward migration.
	 * It implies the reverse migration and then the recontextualization by keys.
	 * @param tModel3ToolProcessed Model to be reverse migrated, then recontextualized by keys,
	 * and then recontextualized by graph (typically a rewrited version of the migrated model).
	 * @param graph Dependency graph provided by the rewriting tool.
	 * It relates output instances to the input instances that have been used to copute them.
	 * @return The recontextualized model.
	 */
	public EObject recontextualizationGraph(EObject tModel3ToolProcessed, Graph graph) {
		this.reverseMigration(tModel3ToolProcessed);
		return recontextualizationGraph(graph);
	}

	/**
	 * Forth and last step: recontextualization by graph.
	 * This action cannot be performed before the recontextualization by keys.
	 * @param graph Dependency graph provided by the rewriting tool.
	 * It relates output instances to the input instances that have been used to copute them.
	 * @return The recontextualized model.
	 */
	public EObject recontextualizationGraph(Graph graph) {
		if (this.model5SRecontextualizedByKeys==null) // The input model has not been recontextualized by keys yet.
			throw new IllegalStateException("The recontextualization by graph cannot be performed before a recontextualization by keys.");
		// We start from a copy of the recontextualized model:
		this.model6SRecontextualizedByGraph = EcoreUtil.copy(this.model5SRecontextualizedByKeys);
		System.out.println("[G Recontextualization of "+this.metamodelSource.getName()+"."+this.model6SRecontextualizedByGraph.eClass().getName()+" ("+UtilEMF.getUUID(this.model6SRecontextualizedByGraph)+")]");
		// Extraction of the reversed dependency graph: 
		ReversedDependency reversedDependencyGraph = new ReversedDependency(graph);
		// UUIDs dictionaries:
		Map<String, EObject> mapUUIDmodelSInitCopy = UtilEMF.createUUIDMap(EcoreUtil.copy(this.model1SInit));
		// Recovering of unrecovered links by means of dependency graph:
		boolean update;
		do update = this.updateReferencesWithDependencies(reversedDependencyGraph, mapUUIDmodelSInitCopy); while(update);
		// Display of unrecovered links:
		for(Object source : this.unrecoveredLinks.key1Set())
			for (EStructuralFeature esf : this.unrecoveredLinks.key2Set(source))
				for (Object target : this.unrecoveredLinks.get(source, esf))
					System.out.println("   Unrecoverable link ("+source+")."+esf.getName()+" -> ("+target+")");	
		// Final version of the updated recontextualized model:
		return this.model6SRecontextualizedByGraph;
	}

}
