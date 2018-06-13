/**
 * comment
 *  
 * Copyright (C) 2014 IDL 
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Paola Vallejo
 *  @date 20/03/2014
 */
package migrationRoundtrip;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import utils.UtilEMF;
import ecoremodif.EclassModif;
import ecoremodif.EreferenceModif;
import ecoremodif.RootEcoreModif;
import migration.DeletedAttribute;
import migration.DeletedReference;
import migration.Deletion;
import migration.DerivedReference;
import migration.Instance;
import migration.Migration;
import migration.ReferencePath;
import migration.impl.MigrationFactoryImpl;
import modif.AttributeModification;
import modif.Modifications;
import modif.ReferenceModification;
import modif.StructuralFeatureModification;

public class MigrationSpecificationGenerator {
	/* *************************************************************** */
	/* ****   ATTRIBUTS                                           **** */
	/* *************************************************************** */

	// root object of ecoreModif object
	protected RootEcoreModif rootEcoreModif;
	protected RootEcoreModif rootEcoreModifCopy;
	protected Map<String, ArrayList<String>> superTypesMap;
	protected Map<String, Map<String,ArrayList<String>>> referencesToClassMap;
	protected ArrayList<String> hideClassesList;
	protected ArrayList<String> flattenClassesList;
	protected Map<String, ArrayList<String>> attributesMap;
	protected Modifications rootModif;
	protected String inputModelFile;
	protected String outputModelFile;
	protected String migrationFile;
	// folder for generated code
	private String sourceFolder;
	EObject rootObject;
	EObject sourceModel;

	MigrationFactoryImpl factory = new MigrationFactoryImpl();
	List<Instance> allInstances = new ArrayList<Instance>();

	Map<String, String> newReferenceNameHide = new HashMap<String, String>();
	ArrayList<String> hideMap = new ArrayList<String>();

	/**
	 * Constructor of the Migration Specification Generator
	 * 
	 * @param rootECM root EcoreModif
	 * @param rootModif root Modif
	 * @param sourceFolderGen source folder
	 * @param inputModel input model
	 * @param outputModel output model
	 */
	public MigrationSpecificationGenerator(Map<String, ArrayList<String>> superTypes, Map<String, ArrayList<String>> attributes,  RootEcoreModif rootECM, RootEcoreModif rootEMC, 
			Modifications rootModif, String sourceFolderGen, String inputModel, String outputModel, ArrayList<String> hideClasses, ArrayList<String> flattenClasses){
		// object rootEcoreModif creation 
		this.superTypesMap = superTypes;
		this.attributesMap = attributes;
		this.rootEcoreModif = rootECM;
		this.rootEcoreModifCopy = rootEMC;
		this.rootModif = rootModif;
		this.inputModelFile = inputModel;
		this.outputModelFile = outputModel;
		this.hideClassesList = hideClasses;
		this.flattenClassesList = flattenClasses;
		// directory for source code generation
		this.sourceFolder = sourceFolderGen;	
		Migration migrationspecification = this.createMigrationSpecification();
		try {
			URI.createURI(rootEcoreModif.getRoot().getModif().getOldURIName()).path();
			EPackage rootPackage = UtilEMF.loadMetamodel(URI.createURI(rootEcoreModif.getRoot().getModif().getOldURIName()).path());
			rootObject = UtilEMF.loadModel(inputModelFile, rootPackage);
			Migration migrationresult = this.migrationRoot(migrationspecification, rootObject);
			buildMapReferencesToInstance(migrationspecification, rootObject);
			this.migrationFile = sourceFolder+"/migration/"+rootModif.getRootPackageModification().getOldName()+"to"+rootModif.getRootPackageModification().getNewName()+".migration.xmi";
			UtilEMF.saveModel((EObject)migrationresult,this.migrationFile);
			System.out.println("[saving] file "+this.migrationFile+": ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param rootECM
	 * @param sourceFolderGen
	 * @param inputModel
	 * @param outputModel
	 */
	public MigrationSpecificationGenerator(RootEcoreModif rootECM, String sourceFolderGen, String inputModel, String outputModel){
		// object rootEcoreModif creation 
		this.rootEcoreModif = rootECM;
		this.inputModelFile = inputModel;
		this.outputModelFile = outputModel;
		// directory for source code generation
		this.sourceFolder = sourceFolderGen;	
		Migration migrationspecification = this.createMigrationSpecification();
		EPackage rootPackage = UtilEMF.loadMetamodel(URI.createURI(rootEcoreModif.getRoot().getModif().getOldURIName()).path());
		rootObject = UtilEMF.loadModel(inputModelFile, rootPackage);
		Migration migrationresult = this.migrationRoot(migrationspecification, rootObject);
		this.migrationFile = sourceFolder+"/migration/"+rootEcoreModif.getModifications().getRootPackageModification().getOldName()+"to"+rootEcoreModif.getModifications().getRootPackageModification().getNewName()+".migration.xmi";
		try {
			UtilEMF.saveModel((EObject)migrationresult,this.migrationFile);
			System.out.println("[saving] file "+this.migrationFile+": ok");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public MigrationSpecificationGenerator(){}

	public String getMigrationFileName(){
		return this.migrationFile;
	}

	/**
	 * 
	 * Create the migration specification 
	 * @return migration object
	 */
	private Migration createMigrationSpecification(){
		Migration migration = factory.createMigration();
		migration.setInputMetamodelURI(this.rootEcoreModif.getRoot().getModif().getOldURIName());
		migration.setInputModelURI(URI.createFileURI(new File(this.inputModelFile).getAbsolutePath()).toString());
		migration.setInputModel(sourceModel);
		migration.setOutputMetamodelURI(this.rootEcoreModif.getRoot().getModif().getNewURIName());
		migration.setOutputModelURI(URI.createFileURI(new File(this.outputModelFile).getAbsolutePath()).toString());
		return migration;
	}

	/**
	 * 
	 * @param migration empty migration specification
	 * @param rootObject input model
	 * @return migration migration specification with instances
	 */
	public Migration migrationRoot(Migration migration, EObject rootObject){
		Migration result = migration;
		Instance rootinstance = factory.createInstance();
		String rootuuid = (String) rootObject.eGet(rootObject.eClass().getEStructuralFeature("UUID"));
		rootinstance.setUUID(rootuuid);
		allInstances.add(rootinstance);
		if(!rootObject.eContents().isEmpty()){
			for(EObject object : rootObject.eContents()){ this.createInstance(object); }
		}
		migration.getInstances().addAll(allInstances);
		result = this.addMigrationDeletion(migration, rootObject);
		result = this.addMigrationHide(migration, rootObject);
		return result;
	}

	/**
	 * Return the object identified with UUID
	 * @param UUID
	 * @param root
	 * @return
	 */
	public EObject getObjectByUUID(String UUID, EObject root){
		EObject result = null;
		for(EObject ob : root.eContents()){	
			if(ob.eGet(ob.eClass().getEStructuralFeature("UUID")).equals(UUID)){
				result = ob;
				break;
			}
		}
		return result;
	}

	/**
	 * Add deletions to the migration specification
	 * @param migration
	 * @param root
	 * @return
	 */
	public Migration addMigrationDeletion(Migration migration, EObject root){
		// Each instance of the migration specification
		for(Instance instance : migration.getInstances()){
			if(root.eGet(root.eClass().getEStructuralFeature("UUID")).toString().equals(instance.getUUID())){
				if(!hasDeletion(instance)){
					Deletion deletion = this.createDeletion(root);
					instance.setDeletion(deletion);
				}else{
				}
			}else{
				for(EObject object: root.eContents()){
					addDeletion(instance, object);
				}
			}
		}
		return migration;
	}

	public Migration addMigrationHide(Migration migration, EObject root){
		Map<String, EObject> mapUUIDmodel = UtilEMF.createUUIDMap(root);
		for(Instance instance : migration.getInstances()){
			if(root.eGet(root.eClass().getEStructuralFeature("UUID")).toString().equals(instance.getUUID())){ addHideRoot(instance, root, mapUUIDmodel); }
			else{ 
				for(EObject object: root.eContents()){ 
					addRemoveHide(root, instance, object);
					addHide(root, instance, object); 
				} 
			}
		}
		return migration;
	}

	ArrayList<String> hideInstances = new ArrayList<String>();

	public ArrayList<String> getHideInstances(){
		return hideInstances;
	}

	public void addHideRoot(Instance instance, EObject root, Map<String, EObject> mapUUIDmodel){
		ArrayList<String> hideClass = new ArrayList<String>();
		if(root.eGet(root.eClass().getEStructuralFeature("UUID")).toString().equals(instance.getUUID())){
			ArrayList<ReferencePath> referencesPath = new ArrayList<ReferencePath>();
			for(EObject reference1 : root.eClass().getEAllReferences()){
				EClassifier eclass2 = ((EStructuralFeature)reference1).getEType();	
				String eclassName2 = eclass2.eGet(eclass2.eClass().getEStructuralFeature("name")).toString();
				EclassModif ecm2 = searchInModif(eclassName2);
				if(ecm2.getModif().isHide() && ecm2.getModif().isFlatten()){

				}else if(ecm2.getModif().isHide()){
					hideClass.add(eclassName2);
					for(EObject object2: root.eContents()){
						if(hideClass.contains(object2.eClass().getName())){
							hideInstances.add(object2.eGet(object2.eClass().getEStructuralFeature("UUID")).toString());
						}
						String eclassName3 = object2.eClass().getName();
						if(eclassName2.equals(eclassName3)){
							for(EObject reference2 : object2.eClass().getEAllReferences()){
								ReferencePath referencePath = createReferencePath(reference1.eGet(reference1.eClass().getEStructuralFeature("name")).toString());
								ReferencePath referencePath2 = createReferencePath(reference2.eGet(reference2.eClass().getEStructuralFeature("name")).toString());
								referencesPath.add(referencePath);
								referencesPath.add(referencePath2);
								DerivedReference derived = createDerivedReference(reference1.eGet(reference1.eClass().getEStructuralFeature("name"))+"_"+reference2.eGet(reference2.eClass().getEStructuralFeature("name"))+"_");
								derived.getPath().addAll(referencesPath);
								instance.getDerived().add(derived);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Add remove because the supertype of the object class is hide
	 */
	public void addRemoveHide(EObject root, Instance instance, EObject object){
		ArrayList<String> supertypesObject = superTypesMap.get(object.eClass().getName());
		if(object.eGet(object.eClass().getEStructuralFeature("UUID")).toString().equals(instance.getUUID())){
			for(String supertypeObjectName : supertypesObject){
				if(this.hideClassesList.contains(supertypeObjectName)){
					if(this.flattenClassesList.contains(supertypeObjectName)){
					}else{
						for(EObject reference : object.eClass().getEAllReferences()){
							DeletedReference deletedreference = createReference((reference.eGet(reference.eClass().getEStructuralFeature("name"))).toString());
							Deletion deletion = instance.getDeletion();
							deletion.getDeletedReferences().add(deletedreference);
						}
					}
				}
			}
		}
	}

	/**
	 * Add Hide for affected instances
	 * @param root 
	 * @param instance
	 * @param object
	 */
	public void addHide(EObject root, Instance instance, EObject object){
		if(object.eGet(object.eClass().getEStructuralFeature("UUID")).toString().equals(instance.getUUID())){	
			for(EObject reference1 : object.eClass().getEAllReferences()){
				EClassifier eclass2 = ((EStructuralFeature)reference1).getEType();	
				String eclassName2 = eclass2.eGet(eclass2.eClass().getEStructuralFeature("name")).toString();
				EclassModif ecm2 = searchInModif(eclassName2);
				if(ecm2.getModif().isHide()){
					this.hideClassesList.add(eclassName2);
					for(EObject object2: root.eContents()){
						if(this.hideClassesList.contains(object2.eClass().getName())){
							hideInstances.add(object2.eGet(object2.eClass().getEStructuralFeature("UUID")).toString());
							String eclassName3 = object2.eClass().getName();
							if(eclassName2.equals(eclassName3)){
								for(EObject reference2 : object2.eClass().getEAllReferences()){
									ReferencePath referencePath = createReferencePath(reference1.eGet(reference1.eClass().getEStructuralFeature("name")).toString());
									ReferencePath referencePath2 = createReferencePath(reference2.eGet(reference2.eClass().getEStructuralFeature("name")).toString());
									DerivedReference derived = createDerivedReference(reference1.eGet(reference1.eClass().getEStructuralFeature("name"))+"_"+reference2.eGet(reference2.eClass().getEStructuralFeature("name"))+"_");
									instance.getDerived().add(derived);
								}
							}
						}else{
							ArrayList<String> supertypes = superTypesMap.get(object2.eClass().getName());
							for(String supertypeName : supertypes){
								if(this.hideClassesList.contains(supertypeName) && this.flattenClassesList.contains(supertypeName)){
									newReferenceNameHide.put(reference1.eGet(reference1.eClass().getEStructuralFeature("name")).toString(), reference1.eGet(reference1.eClass().getEStructuralFeature("name"))+"_"+object2.eClass().getName());
									DerivedReference derived = null; 
									for(EObject reference2 : object2.eClass().getEAllReferences()){
										ReferencePath referencePath = createReferencePath(reference1.eGet(reference1.eClass().getEStructuralFeature("name")).toString());
										ReferencePath referencePath2 = createReferencePath(reference2.eGet(reference2.eClass().getEStructuralFeature("name")).toString());
										derived = createDerivedReference(reference1.eGet(reference1.eClass().getEStructuralFeature("name"))+"_"+reference2.eGet(reference2.eClass().getEStructuralFeature("name"))+"_");
										derived.getPath().add(referencePath);
										derived.getPath().add(referencePath2);
										DeletedReference reference = createReference((reference1.eGet(reference1.eClass().getEStructuralFeature("name"))).toString());
										Deletion deletion = instance.getDeletion();
										if(instance.getDerived().isEmpty()){
											instance.getDerived().add(derived);
										}else{
											for(DerivedReference addDer : instance.getDerived()){
												if(!addDer.getNewReferenceName().equals(derived.getNewReferenceName())){ instance.getDerived().add(derived);
												}
											}
										}
									}
								}else if(this.hideClassesList.contains(supertypeName)){
									DerivedReference derived = null; 
									for(EObject reference2 : object2.eClass().getEAllReferences()){
										ReferencePath referencePath = createReferencePath(reference1.eGet(reference1.eClass().getEStructuralFeature("name")).toString());
										ReferencePath referencePath2 = createReferencePath(reference2.eGet(reference2.eClass().getEStructuralFeature("name")).toString());
										derived = createDerivedReference(reference1.eGet(reference1.eClass().getEStructuralFeature("name"))+"_"+reference2.eGet(reference2.eClass().getEStructuralFeature("name"))+"_");
										derived.getPath().add(referencePath);
										derived.getPath().add(referencePath2);
										DeletedReference reference = createReference((reference1.eGet(reference1.eClass().getEStructuralFeature("name"))).toString());
										Deletion deletion = instance.getDeletion();
										if(deletion.getDeletedReferences().isEmpty()){
											deletion.getDeletedReferences().add(reference);
										}else{
											for(DeletedReference delRef : deletion.getDeletedReferences()){
												if(!delRef.getName().equals(reference.getName())){
													deletion.getDeletedReferences().add(reference);
												}
											}
										}
										if(instance.getDerived().isEmpty()){
											instance.getDerived().add(derived);
										}else{
											for(DerivedReference addDer : instance.getDerived()){
												if(!addDer.getNewReferenceName().equals(derived.getNewReferenceName())){
													instance.getDerived().add(derived);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		/*ArrayList<String> supertypes = superTypesMap.get(object.eClass().getName());
			ArrayList<String> attributes;
			for(String supertypeName : supertypes){
				EclassModif supertype = searchInModif(supertypeName);
				if(supertype.getEcore() == null){
					attributes = attributesMap.get(supertypeName);
					for( String a : attributes){
						if(!a.equals("UUID")){
							DeletedAttribute attribute = createAttribute(a);
							Deletion deletion = instance.getDeletion();
							deletion.getDeletedAttributes().add(attribute);
						}
					}
				}
			}*/
	}

	public Map<String, Map<String, ArrayList<String>>> getReferencesToClassMap(){
		return this.referencesToClassMap;
	}

	public Map<String, String> getNewReferencesName (){
		return this.newReferenceNameHide;
	}

	public void addHide2(EObject root, Instance instance, EObject object, Map<String, EObject> mapUUIDmodel){
		if(object.eGet(object.eClass().getEStructuralFeature("UUID")).toString().equals(instance.getUUID())){
			EclassModif eclassmodif = null;
			String idObject2;
			for(EObject object2: root.eContents()){
				idObject2 = object2.eGet(object2.eClass().getEStructuralFeature("UUID")).toString();
				for(EObject cl : root.eContents()){
					for(EObject reference : cl.eClass().getEAllReferences()){
						EClassifier eclass2 = ((EStructuralFeature)reference).getEType();
						String eclassName2 = eclass2.eGet(eclass2.eClass().getEStructuralFeature("name")).toString();
						EclassModif ecm2 = searchInModif(eclassName2);
						if(ecm2.getModif().isHide() && ecm2.getModif().isFlatten()){
							eclassmodif = ecm2;
						}else {
							for(EObject object3: root.eContents()){
								ArrayList<String> supertypes = superTypesMap.get(object3.eClass().getName());
								for(String supertypeName2 : supertypes){
									EclassModif ecm3 = searchInModif(supertypeName2);
									if(ecm3.getModif().isHide()){
										if(object.eGet(object.eClass().getEStructuralFeature("UUID")).toString().equals(object3.eGet(object3.eClass().getEStructuralFeature("UUID")).toString())){
											for( EObject c : root.eContents()){
												for (EReference r : c.eClass().getEAllReferences()){
													if(r.getName().equals(reference.eGet(reference.eClass().getEStructuralFeature("name")))){
														Instance source = searchInstance(object2.eGet(object2.eClass().getEStructuralFeature("UUID")).toString());
														String newName = r.getName()+"_"+object3.eClass().getName();
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if(eclassmodif != null){
				for (EreferenceModif r3 : eclassmodif.getAllReferences()){
					if(r3.getModif().isRemove()){
						DeletedReference ref = createReference(r3.getModif().getNewName());
						Deletion deletion = instance.getDeletion();
						deletion.getDeletedReferences().add(ref);
					}													
				}
			}
			ArrayList<String> supertypes = superTypesMap.get(object.eClass().getName());
			ArrayList<String> attributes;
			for(String supertypeName : supertypes){
				EclassModif supertype = searchInModif(supertypeName);
				if(supertype.getEcore() == null){
					attributes = attributesMap.get(supertypeName);
					for( String a : attributes){
						if(!a.equals("UUID")){
							DeletedAttribute attribute = createAttribute(a);
							Deletion deletion = instance.getDeletion();
							deletion.getDeletedAttributes().add(attribute);
						}
					}
				}
			}

		}
	}

	public ArrayList<ArrayList<String>> getReferencesPath(EObject object, EclassModif ecm, EObject reference){
		String secondReferenceName = null;
		String referenceName = reference.eGet(reference.eClass().getEStructuralFeature("name")).toString();
		ArrayList<ArrayList<String>> referencesPath = new ArrayList<ArrayList<String>>();
		EObject secondInstance = (EObject) object.eGet(object.eClass().getEStructuralFeature(((EStructuralFeature) reference).getName()));
		String idSecondInstance = (String) secondInstance.eGet(secondInstance.eClass().getEStructuralFeature("UUID"));
		ArrayList<String> derived = new ArrayList<String>();
		derived.add(referenceName);
		derived.add(idSecondInstance);
		referencesPath.add(derived);

		for(EObject secondReference : secondInstance.eClass().getEAllReferences()){
			secondReferenceName = secondReference.eGet(secondReference.eClass().getEStructuralFeature("name")).toString();
			EObject thirdInstance = (EObject) secondInstance.eGet(secondInstance.eClass().getEStructuralFeature(((EStructuralFeature) secondReference).getName()));
			String idThirdInstance = (String) thirdInstance.eGet(thirdInstance.eClass().getEStructuralFeature("UUID"));
			ArrayList<String> derived2 = new ArrayList<String>();
			derived2.add(secondReferenceName);
			derived2.add(idThirdInstance);
			referencesPath.add(derived2);

			DeletedReference ref = createReference(secondReferenceName);
			Instance instance = searchInstance(idSecondInstance);
			Deletion deletion = instance.getDeletion();
			deletion.getDeletedReferences().add(ref);
		}
		return referencesPath;
	}

	public String getNewName(EObject object, EclassModif ecm, EObject reference){
		String newName;
		String secondReferenceName = null;
		String referenceName = reference.eGet(reference.eClass().getEStructuralFeature("name")).toString();
		EObject secondInstance = (EObject) object.eGet(object.eClass().getEStructuralFeature(((EStructuralFeature) reference).getName()));
		String idSecondInstance = (String) secondInstance.eGet(secondInstance.eClass().getEStructuralFeature("UUID"));
		for(EObject secondReference : secondInstance.eClass().getEAllReferences()){
			secondReferenceName = secondReference.eGet(secondReference.eClass().getEStructuralFeature("name")).toString();
			EObject thirdInstance = (EObject) secondInstance.eGet(secondInstance.eClass().getEStructuralFeature(((EStructuralFeature) secondReference).getName()));
			String idThirdInstance = (String) thirdInstance.eGet(thirdInstance.eClass().getEStructuralFeature("UUID"));
		}
		newName = referenceName+"_"+secondReferenceName+"_";
		return newName;
	}

	public boolean hasDeletion(Instance instance){
		if(instance.getDeletion() != null){
			return true;
		}else{
			return false;
		}
	}

	public void addDeletion(Instance instance, EObject object){
		if(object.eGet(object.eClass().getEStructuralFeature("UUID")).toString().equals(instance.getUUID())){
			if(!hasDeletion(instance)){
				Deletion deletion = this.createDeletion(object);
				instance.setDeletion(deletion);
			}else{
			}
		}else{
			for(EObject obj: object.eContents()){
				addDeletion(instance, obj);
			}
		}
	}

	/* Migration addMigrationValues(Migration migration, EObject root){
		// Instances dictionary:
		Map<String, EObject> mapUUIDmodel = UtilEMF.createUUIDMap(root);
		addValues(migration, root);
		return migration;
	}*/

	/*public void addVal(Map<String, ArrayList<String>> superTypesMap, Instance instance, EObject object){
		for(EObject ob : object.eContents()){
			if(ob.eGet(ob.eClass().getEStructuralFeature("UUID")).toString().equals(instance.getUUID())){
				Deletion deletion = this.createDeletion(object);
				instance.setDeletion(deletion);
			}else{
				addVal(superTypesMap, instance, ob);
			}
		}
	}*/

	/*public void addValues(Migration migration, EObject object){
		for(Instance instance : migration.getInstances()){
			if(object.eGet(object.eClass().getEStructuralFeature("UUID")).toString().equals(instance.getUUID())){
				Deletion deletion = this.createDeletion(object);
				instance.setDeletion(deletion);

			}else{
				addVal(superTypesMap, instance, object);
			}
		}

	}*/


	/**
	 * Creates an instance from the object
	 * @param object instance to be created
	 */
	public void createInstance(EObject object){
		Instance instance = factory.createInstance();
		String instanceuuid = (String) object.eGet(object.eClass().getEStructuralFeature("UUID"));
		instance.setUUID(instanceuuid);
		allInstances.add(instance);
		if(!object.eContents().isEmpty()){
			for(EObject contobject : object.eContents()){ this.createInstance(contobject); 	}
		}
	}

	/**
	 * Creates the deletion corresponding to the object
	 * @param object an instance of the input model
	 * @return
	 */
	public Deletion createDeletion(EObject object){
		List<String> attributes = new ArrayList<String>();
		List<String> references = new ArrayList<String>();
		String name = object.eClass().getName();
		Deletion deletion = factory.createDeletion();
		EclassModif ecm = searchInModif(name);
		if(ecm.getModif().isRemove()){ deletion.setDeleteInstance(true); }
		else if(ecm.getModif().isHide()){ deletion.setDeleteInstance(true); }
		else{
			deletion.setDeleteInstance(false);
			for(StructuralFeatureModification  feature : ecm.getModif().getFeatureModification()){
				if (feature instanceof AttributeModification && feature.isRemove()){
					if(!feature.getNewName().equals("UUID")){ attributes.add(feature.getOldName()); }
				}else if(feature instanceof ReferenceModification && feature.isRemove()){ references.add(feature.getOldName()); }
			}
			// search for the feature in the superclasses
			for(EClass supereclass : object.eClass().getEAllSuperTypes()){
				EclassModif superecm = searchInModif(supereclass.getName());
				if(superecm.getModif().isRemove()){  }
				else{
					for(StructuralFeatureModification  superfeature : superecm.getModif().getFeatureModification()){
						if (superfeature instanceof AttributeModification && superfeature.isRemove()){ }
						else if(superfeature instanceof ReferenceModification && superfeature.isRemove()){ references.add(superfeature.getOldName()); }
					}
				}
			}
		}
		if(ecm.getEcore() != null){
			for(EClass eclass : ecm.getEcore().getEAllSuperTypes()){
				EclassModif supecm = searchInModif(eclass.getName());
				if(supecm != null){
					for(StructuralFeatureModification feature : supecm.getModif().getFeatureModification()){
						if (feature instanceof AttributeModification && feature.isRemove()){ attributes.add(feature.getOldName()); }
						else if (feature instanceof ReferenceModification && feature.isRemove()){ references.add(feature.getOldName()); }
					}
				}
			}
		}
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
	 * Give a map with each references and the target instances of the reference
	 * @param migration
	 * @param rootObject
	 * @return
	 */
	public void buildMapReferencesToInstance(Migration migration, EObject rootObject){
		this.referencesToClassMap = new HashMap<String, Map<String,ArrayList<String>>>();
		Map<String, ArrayList<String>> referenceToMap = new HashMap<String, ArrayList<String>>();
		String idRootObject = (String) rootObject.eGet(rootObject.eClass().getEStructuralFeature("UUID"));
		for(EReference rootReference : rootObject.eClass().getEAllReferences()){
			ArrayList<String> instances = new ArrayList<String>();
			String rootReferenceName = rootReference.getName();
			EClassifier rootReferenceType = rootReference.getEType();
			for(EObject object : rootObject.eContents()){
				String idObject = (String) object.eGet(object.eClass().getEStructuralFeature("UUID"));
				if(object.eClass().getName().equals(rootReferenceType.getName())){ instances.add(idObject); }
				else{
					for(EClass superClass : object.eClass().getEAllSuperTypes()){ 
						if(superClass.getName().equals(rootReferenceType.getName())){ instances.add(idObject); 	}
					}
				}
			}
			referenceToMap.put(rootReferenceName, instances);
		}
		referencesToClassMap.put(idRootObject, referenceToMap);
		for(EObject object : rootObject.eContents()){
			String idObject = (String) object.eGet(object.eClass().getEStructuralFeature("UUID"));
			for(EReference reference : object.eClass().getEAllReferences()){
				String referenceName = reference.getName();
				EClassifier referenceType = reference.getEType();
				for(EObject test : object.eCrossReferences()){
				}
				//Object test = object.eGet(reference);
				//Object ref = object.eGet(object.eClass().getEStructuralFeature("referenceName"));
			}
		}


		/*for(EObject object : rootObject.eContents()){
			String idObject = (String) object.eGet(object.eClass().getEStructuralFeature("UUID"));
			for(EReference reference : object.eClass().getEAllReferences()){
				ArrayList<String> instances = new ArrayList<String>();
				String referenceName = reference.getName();
				EClassifier referenceType = reference.getEType();
				for(EObject inObject : rootObject.eContents()){
					String idInObject = (String) inObject.eGet(inObject.eClass().getEStructuralFeature("UUID"));
					if(inObject.eClass().getName().equals(referenceType.getName())){
						instances.add(idInObject);
					}else{
						for(EClass superClass : inObject.eClass().getEAllSuperTypes()){
							if(superClass.getName().equals(referenceType.getName())){
								instances.add(idInObject);
							}
						}
					}
				}
				referencesToClassMap.put(referenceName, instances);
			}
		}*/
	}


	/*public void buildMapReferencesToInstance(Migration migration, EObject rootObject){
		this.referencesToClassMap = new HashMap<String, ArrayList<String>>();
		//String idRootObject = (String) rootObject.eGet(rootObject.eClass().getEStructuralFeature("UUID"));
		for(EReference rootReference : rootObject.eClass().getEAllReferences()){
			ArrayList<String> instances = new ArrayList<String>();
			String rootReferenceName = rootReference.getName();
			EClassifier rootReferenceType = rootReference.getEType();
			for(EObject object : rootObject.eContents()){
				String idObject = (String) object.eGet(object.eClass().getEStructuralFeature("UUID"));
				if(object.eClass().getName().equals(rootReferenceType.getName())){ instances.add(idObject); }
				else{
					for(EClass superClass : object.eClass().getEAllSuperTypes()){
						if(superClass.getName().equals(rootReferenceType.getName())){ instances.add(idObject); 	}
					}
				}
			}
			referencesToClassMap.put(rootReferenceName, instances);
		}
		for(EObject object : rootObject.eContents()){
			String idObject = (String) object.eGet(object.eClass().getEStructuralFeature("UUID"));
			for(EReference reference : object.eClass().getEAllReferences()){
				ArrayList<String> instances = new ArrayList<String>();
				String referenceName = reference.getName();
				EClassifier referenceType = reference.getEType();
				for(EObject inObject : rootObject.eContents()){
					String idInObject = (String) inObject.eGet(inObject.eClass().getEStructuralFeature("UUID"));
					if(inObject.eClass().getName().equals(referenceType.getName())){
						instances.add(idInObject);
					}else{
						for(EClass superClass : inObject.eClass().getEAllSuperTypes()){
							if(superClass.getName().equals(referenceType.getName())){
								instances.add(idInObject);
							}
						}
					}
				}
				referencesToClassMap.put(referenceName, instances);
			}
		}
	}*/


	/**
	 * Update the migration specification
	 * @param instanceUUID instance whose value of deletion has to be modified
	 * @param value value of deletion
	 * @throws IOException
	 */

	// TODO : don't add deleteReference if it is deletedInstance
	public Migration  modifyInstance(String instanceUUID, boolean value, Migration migration) throws IOException{
		//references going to the instance
		/*for(EObject object : rootObject.eContents()){
			String objectId = object.eGet(object.eClass().getEStructuralFeature("UUID")).toString();
			for(EReference reference : object.eClass().getEAllReferences()){
				String referenceName = reference.getName();
				EClassifier referenceType = reference.getEType();

			}
		}*/

		/*for(EObject object : rootObject.eContents()){
			Map<EObject, EObject> map = null;
			String objectuuid = (String) object.eGet(object.eClass().getEStructuralFeature("UUID"));
			if(objectuuid.equals("Person:pv123")){
				ArrayList<String> supertypes = superTypesMap.get(object.eClass().getName());
				for (EStructuralFeature reference : object.eClass().getEAllStructuralFeatures()){
					if(reference.getName().equals("autos")){
						Object sourceFeatureValue = object.eGet(reference);
						for(EObject object2 : rootObject.eContents()){
							String objectuuid2 = (String) object2.eGet(object2.eClass().getEStructuralFeature("UUID"));
							if(objectuuid2.equals("Car:car1")){
								if(object2 == sourceFeatureValue){
								}
							}
						}

						for(EObject instance : migration.eContents()){
							String instanceuuid = (String) instance.eGet(instance.eClass().getEStructuralFeature("UUID"));
							if(sourceFeatureValue.equals(instanceuuid)){
							}
						}*/

		/*EstructutalFeature refName = reference.eGet(reference.eClass().getEStructuralFeature("name"));
				Object target = reference.eGet(reference.eClass().getEStructuralFeature(refName));
				EClassifier eclass = ((EStructuralFeature)reference).getEType();	
				String eclassName = eclass.eGet(eclass.eClass().getEStructuralFeature("name")).toString();
				EclassModif ecm = searchInModif(eclassName);*/
		/*if(!ecm.getModif().isRemove()){

				}*/
		//}
		//}*/

		//}

		//}

		for(EObject instance : migration.eContents()){
			String instanceuuid = (String) instance.eGet(instance.eClass().getEStructuralFeature("UUID"));
			if(instanceuuid.equals(instanceUUID)){
				for(EObject deletion : instance.eContents()){					
					deletion.eSet(deletion.eClass().getEStructuralFeature("deleteInstance"), value);
				}
			}
		}
		return migration;
	}

	/**
	 * Add other deletedReferences
	 * @param migration
	 */
	public void addDeleteReferences(Migration migration){
		for(EObject object : rootObject.eContents()){
			String objectuuid = (String) object.eGet(object.eClass().getEStructuralFeature("UUID"));
			for(EReference reference : object.eClass().getEAllReferences()){
				String referenceName = reference.getName();
				for(EObject ref : object.eCrossReferences()){
					String refId = (String) ref.eGet(ref.eClass().getEStructuralFeature("UUID"));
					for(Instance instance: migration.getInstances()){
						String instanceuuid = instance.getUUID();
						Deletion deletion = instance.getDeletion();
						if(deletion.isDeleteInstance()){
							if(instanceuuid.equals(refId)){
								Deletion deletion2 = null ;
								ArrayList<DeletedReference> toAdd = null;
								for(Instance instance2 : migration.getInstances()){
									String instanceuuid2 = instance2.getUUID();
									if(instanceuuid2.equals(objectuuid)){
										deletion2 = instance2.getDeletion();
										DeletedReference deletedReference = createReference(referenceName);
										//for(DeletedReference delRef : deletion2.getDeletedReferences()){
										//if(!delRef.getName().equals(deletedReference)){
										deletion2.getDeletedReferences().add(deletedReference);
										//	toAdd.add(delRef);
										//}
										//}
									}
								}
								/*for(DeletedReference add : toAdd){
									deletion2.getDeletedReferences().add(add);
								}*/
							}

						}
					}
				}
			}
		}
	}

	/**
	 * Post-processing of the migration specification. To delete deletedFeatures when there is deletedInstance
	 * @param migration
	 */
	public void cleanMigrationSpecification(Migration migration){
		for(Instance instance : migration.getInstances()){
			ArrayList<DeletedReference> references = new ArrayList<DeletedReference>();
			Deletion deletion =instance.getDeletion();
			if(deletion.isDeleteInstance()){
				for(DeletedReference reference : deletion.getDeletedReferences()){
					references.add(reference);		
				}
			}else{
				/*for(int i = 0; i< allDeletedReference.size(); i++){
					for(int j = i +1 ; j <allDeletedReference.size()-2; j++){
						if(allDeletedReference.get(i).getName().equals(allDeletedReference.get(j).getName())){
							references.add(allDeletedReference.get(j));
						}
					}
				}*/
				for(int i=0; i<deletion.getDeletedReferences().size()-1; i++){
					for(int j=i+1;j<deletion.getDeletedReferences().size();j++){
						if(deletion.getDeletedReferences().get(i).getName()==deletion.getDeletedReferences().get(j).getName()){
							references.add(deletion.getDeletedReferences().get(i));
						}
					}
				}
			}
			for(DeletedReference ref : references){
				EcoreUtil.remove(ref);
			}
		}
	}


	/**
	 * Creates an attribute with the name received
	 * 
	 * @param name reference's name
	 * @return attribute
	 */
	public DeletedAttribute createAttribute(String name){
		DeletedAttribute attribute = factory.createDeletedAttribute();
		attribute.setName(name);
		return attribute;
	}

	/**
	 * Creates a reference with the name received
	 * 
	 * @param name attribute's name
	 * @return reference
	 */
	public DeletedReference createReference(String name){
		DeletedReference reference = factory.createDeletedReference();
		reference.setName(name);
		return reference;
	}

	public DerivedReference createDerivedReference(String name){
		DerivedReference derived = factory.createDerivedReference();
		derived.setNewReferenceName(name);
		return derived;
	}

	public ReferencePath createReferencePath(String referenceName){
		ReferencePath referencePath = factory.createReferencePath();
		referencePath.setReferenceName(referenceName);
		return referencePath;
	}

	/**
	 * Search an Eclassmodif in the Modif specification
	 * @param name Name of the class
	 * @return EClassmodif
	 */
	public EclassModif searchInModif(String name){
		EclassModif modification = null;
		for(EclassModif ecm : rootEcoreModif.getAllClassModifications()){
			if(ecm.getModif().getOldName().equals(name)){
				modification = ecm;
				break;
			}
		}
		return modification;
	}

	/**
	 * Search an Eclassmodif in the Modif specification
	 * @param name Name of the class
	 * @return EClassmodif
	 */
	public boolean isHideClass(String name){
		boolean isHide = false;
		for(EclassModif ecm : rootEcoreModifCopy.getAllClassModifications()){
			if(ecm.getModif().getOldName().equals(name)){
				if(ecm.getModif().isHide()){
					isHide = true;
					break;
				}else{
					for(EclassModif e : rootEcoreModifCopy.getAllClassModifications()){
						for( EClassifier st : e.getEcore().getEAllSuperTypes()){
						}
					}
				}
			}
		}
		return isHide;
	}

	public Instance searchInstance(String uuid){
		Instance instance = null;
		for(Instance i : allInstances){
			if(i.getUUID().equals(uuid)){
				instance = i;
				break;
			}
		}
		return instance;
	}
}
