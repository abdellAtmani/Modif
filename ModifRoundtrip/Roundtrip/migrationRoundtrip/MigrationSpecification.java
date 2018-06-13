package migrationRoundtrip;

import java.util.ArrayList;
import java.util.List;

import modif.AttributeModification;
import modif.ClassModification;
import modif.Modifications;
import modif.PackageModification;
import modif.ReferenceModification;
import modif.StructuralFeatureModification;
import migration.DeletedAttribute;
import migration.DeletedReference;
import migration.Deletion;
import migration.Instance;
import migration.Migration;
import migration.impl.MigrationFactoryImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import utils.UtilUUID;

/**
 * Utilitary class for handling migration specifications.
 * Source metamodel and source models have UUIDs.
 * A migration specification is produced from a modif specification and a source model.
 * This class gathers useful functions to generate and edit migration specifications.
 * 
 * @author P. Vallejo
 *
 */

public class MigrationSpecification {


	// ATTRIBUTES ****************************************************************************

	public static EPackage sourceMetamodel;
	public static EPackage targetMetamodel;
	public static Modifications modifSpecification;
	public static EObject sourceModel;
	public static Migration migrationSpecification;
	private static MigrationFactoryImpl factory;
	private static List<Instance> allInstances;
	private static String UUIDName;


	// PRIVATE ******************************************************************************

	/**
	 * Add deletion to a specific instance.
	 * @param instance The instance of the migration specification asociated to the model object to be deleted.
	 * @param object The model object to the deleted.
	 */
	private static void addDeletion(Instance instance, EObject object) {
		if(object.eGet(object.eClass().getEStructuralFeature(UUIDName)).toString().equals(instance.getUUID())){
			if(!hasDeletion(instance)){
				Deletion deletion = createDeletion(object);
				instance.setDeletion(deletion);
			}else{
			}
		}else{
			for(EObject obj: object.eContents()){ addDeletion(instance, obj); }
		}
	}

	/**
	 * Add deletion to a migration specification.
	 * @param theMigrationSpecification Migration specification to be updated with deletion.
	 * @param model The source model to be modified.
	 * @return migration Migration specification updated with deletion.
	 */
	private static Migration addMigrationDeletion(Migration theMigrationSpecification, EObject model) {
		Migration migration = theMigrationSpecification;
		for(Instance instance : migration.getInstances()){
			if(model.eGet(model.eClass().getEStructuralFeature(UUIDName)).toString().equals(instance.getUUID())){
				if(!hasDeletion(instance)){
					Deletion deletion = createDeletion(model);
					instance.setDeletion(deletion);
				}
			}else{
				for(EObject object: model.eContents()){ addDeletion(instance, object); }
			}
		}
		return migration;
	}

	/**
	 * Creates an attribute with the name received in parameter.
	 * 
	 * @param name Name of the attribute to be created.
	 * @return attribute Created attribute.
	 */
	private static DeletedAttribute createAttribute(String name){
		DeletedAttribute attribute = factory.createDeletedAttribute();
		attribute.setName(name);
		return attribute;
	}

	/**
	 * Creates the deletion corresponding to the object received in parameter.
	 * @param object An object of the source model.
	 * @return deletion Deletion element of the migration specification.
	 */
	private static Deletion createDeletion(EObject object){
		List<String> attributes = new ArrayList<String>();
		List<String> references = new ArrayList<String>();
		String name = object.eClass().getName();
		System.out.println("name : "+name);
		Deletion deletion = factory.createDeletion();
		ClassModification ecm = searchInModif(name);	
		System.out.println(" --- ecm "+ ecm);
		if(ecm != null){
			if(ecm.isRemove()){ deletion.setDeleteInstance(true); }
			else if(ecm.isHide()){ deletion.setDeleteInstance(true); }
			else{
				deletion.setDeleteInstance(false);
				for(StructuralFeatureModification  feature : ecm.getFeatureModification()){
					if (feature instanceof AttributeModification && feature.isRemove()){
						if(!feature.getNewName().equals(UUIDName)){ attributes.add(feature.getOldName()); }
					}else if(feature instanceof ReferenceModification && feature.isRemove()){ references.add(feature.getOldName()); }
				}
				// search for the feature in the superclasses
				for(EClass supereclass : object.eClass().getEAllSuperTypes()){
					ClassModification superecm = searchInModif(supereclass.getName());
					if(superecm != null) {
						if(!superecm.isRemove()){ 
							for(StructuralFeatureModification  superfeature : superecm.getFeatureModification()){
								if (superfeature instanceof AttributeModification && superfeature.isRemove()){ }
								else if(superfeature instanceof ReferenceModification && superfeature.isRemove()){ references.add(superfeature.getOldName()); }
							}
						}
					}
				}
			}
		}
		// TODO
		/*if(ecm.getEcore() != null){
			for(EClass eclass : ecm.getEcore().getEAllSuperTypes()){
				EclassModif supecm = searchInModif(eclass.getName());
				if(supecm != null){
					for(StructuralFeatureModification feature : supecm.getModif().getFeatureModification()){
						if (feature instanceof AttributeModification && feature.isRemove()){ attributes.add(feature.getOldName()); }
						else if (feature instanceof ReferenceModification && feature.isRemove()){ references.add(feature.getOldName()); }
					}
				}
			}
		}*/
		for(String att : attributes){
			DeletedAttribute attribute = createAttribute(att);
			deletion.getDeletedAttributes().add(attribute);
		}
		for(String ref : references){
			DeletedReference reference = createReference(ref);
			deletion.getDeletedReferences().add(reference);
		}
		return deletion;
	}

	/**
	 * Create an instance of the migration specification.
	 * @param modelObject Model object associated to the instance to be created.
	 */
	private static void createInstance(EObject modelObject) {
		Instance instance = factory.createInstance();
		String instanceUUID = (String) modelObject.eGet(modelObject.eClass().getEStructuralFeature(UUIDName));
		instance.setUUID(instanceUUID);
		allInstances.add(instance);
		if(!modelObject.eContents().isEmpty()){
			for(EObject contObject : modelObject.eContents()){ createInstance(contObject); }
		}
	}

	/**
	 * Create an empty migration specification. 
	 * @return migration. The created migration specification.
	 */
	private static Migration createMigrationSpecification() {

		factory  = new MigrationFactoryImpl();

		Migration migration = factory.createMigration();
		String sourceMetamodelURI = modifSpecification.getRootPackageModification().getOldURIName();
		
		System.out.println("sourceMetamodelURI  "+sourceMetamodelURI);
		String targetMetamodelURI = modifSpecification.getRootPackageModification().getNewURIName();
		String sourceModelURI = "";
		String targetModel = "";

		migration.setInputMetamodelURI(sourceMetamodelURI);
		migration.setOutputMetamodelURI(targetMetamodelURI);
		migration.setInputModelURI(sourceModelURI);
		migration.setInputModel(sourceModel);
		migration.setOutputModelURI(targetModel);

		/* migration.setInputModelURI(URI.createFileURI(new File(this.inputModelFile).getAbsolutePath()).toString()); */

		return migration;

	}

	/**
	 * Creates a reference with the name received in parameter.
	 * 
	 * @param name Name of the reference to be created.
	 * @return reference Created reference.
	 */
	private static DeletedReference createReference(String name){
		DeletedReference reference = factory.createDeletedReference();
		reference.setName(name);
		return reference;
	}

	/**
	 * Verify if an instance is marked to be deleted.
	 * @param instance Instance to be verified.
	 * @return true. If the instance has to be deleted. 
	 * False. If the instance does not have to be deleted.
	 */
	private static boolean hasDeletion(Instance instance) {
		if(instance.getDeletion() != null){ return true; }
		else{ return false; }
	}

	/**
	 * Add deletion and hide to the migration specification.
	 * @param theMigrationSpecification The migration specification to be completed with add and hide.
	 * @param sourceModel The model to me migrated
	 * @return migration The migration specification with remove and hide.
	 */
	private static Migration migrationRoot(Migration theMigrationSpecification, EObject sourceModel) {
		allInstances = new ArrayList<Instance>();
		Migration migration = theMigrationSpecification;
		Instance rootinstance = factory.createInstance();

		for(EAttribute attribute : sourceModel.eClass().getEAllAttributes()){
			if(attribute.getName().toString().contains("UUID")){ UUIDName = attribute.getName(); }
		}

		if(UUIDName != null){
			String rootUUID = (String) sourceModel.eGet(sourceModel.eClass().getEStructuralFeature(UUIDName));
			rootinstance.setUUID(rootUUID);
		}

		allInstances.add(rootinstance);

		if(!sourceModel.eContents().isEmpty()){
			for(EObject object : sourceModel.eContents()){ createInstance(object); }
		}
		theMigrationSpecification.getInstances().addAll(allInstances);
		migration = addMigrationDeletion(theMigrationSpecification, sourceModel);
		//result = this.addMigrationHide(migration, rootObject);
		return migration;
	}

	/**
	 * Search a ClassModification in the Modif specification.
	 * @param name Name of the class to be searched.
	 * @return ClassModification ClassModification with the name.
	 */
	private static ClassModification searchInModif(String name){
		PackageModification epm = modifSpecification.getRootPackageModification();
		ClassModification modification = null;
		for( ClassModification ecm : epm.getClassModification()){
			if(ecm.getOldName().equals(name)){
				modification = ecm;
				break;
			}
		}
		return modification;
	}


	// PUBLIC *******************************************************************************

	/**
	 * Generate a migration specification.
	 * 
	 */
	public static void generateMigrationSpecification() {
		Migration theMigrationSpecification = null;

		// create an empty migration specification
		theMigrationSpecification = createMigrationSpecification();
		Migration migrationresult = migrationRoot(theMigrationSpecification, sourceModel);

		migrationSpecification = migrationresult;
	}

	/**
	 * Get the migration specification
	 * @return migrationSpecification The migration specification.
	 */
	public static Migration getMigrationSpecification() {
		return migrationSpecification;
	}

	/**
	 * Set the modif specification
	 * @param theModifSpecification Modif specification.
	 */
	public static void setModifSpecification(Modifications theModifSpecification) {
		modifSpecification = theModifSpecification;
	}

	/**
	 * Set the source metamodel.
	 * @param theSourceMetamodel Source metamodel.
	 */
	public static void setSourceMetamodel(EPackage theSourceMetamodel) {
		sourceMetamodel = theSourceMetamodel;
	}

	/**
	 * Set the source model.
	 * @param model Source model.
	 */
	public static void setSourceModel(EObject model) {		
		sourceModel = model;
	}

	/**
	 * Set the target metamodel.
	 * @param theTargetMetamodel Target metamodel.
	 */
	public static void setTargetMetamodel(EPackage theTargetMetamodel) {
		targetMetamodel = theTargetMetamodel;
	}

}
