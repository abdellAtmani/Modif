package utils;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import migration.DerivedReference;
import migration.Instance;
import migration.Migration;
import migration.ReferencePath;

import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * Utilitary class for EMF models.
 * This class gathers usefull functions to load, save and modify easily
 * EMF models and metamodels.
 * @author M. Kerboeuf
 */
public class UtilEMF {

	// PRIVATE **********************************************************************************

	/**
	 * Private class dedicated to the utilitary function changeMetamodel.
	 * This class maps two sets of instances. The first one corresponds to the instances
	 * of a source model. The second one correponds to the instances of a copy of
	 * the source model conforming to another metamodel.
	 * @author M. Kerboeuf
	 */
	private static class EObjectMap {
		private Map<EObject, EObject> map;
		private Map<EObject, EObject> temporalmap;
		private Map<EObject, EObject> initialmap;
		Map<String, Map<String, Map<String, String>>> renameMap;
		private EObject  modelRootObject;
		private EObject  auxmodelRootObject;
		private EPackage oldMetamodelRootPackage;
		private EPackage newMetamodelRootPackage;

		/**
		 * Provides the package matching with a package path corresponding to a given package list.
		 * @param path The package path.
		 * @param ePackage The parent package from which the search starts.
		 * @return The package at the end of the path if it exists or null.
		 */
		private static EPackage getEndOfEPackagePath(List<EPackage> path, EPackage ePackage) {
			for (int i=1; i<path.size(); i++) {
				ePackage = getSubEPackage(ePackage, path.get(i).getName());
				if (ePackage==null) return null;
			}
			return ePackage;
		}

		/**
		 * Creates the list of the nested packages containing a given package.
		 * If this list contains a given first package, then this
		 * package is the first of the resulting list.
		 * @param p A package to scan.
		 * @param startPackage The start package from which the list is supposed to begin.
		 * @return The list of nested packages including p.
		 */
		private static List<EPackage> getEPackagePath(EPackage p, EPackage startPackage) {
			List<EPackage> path = new ArrayList<EPackage>();
			while (p!=null) {
				path.add(0, p);
				if (p.equals(startPackage)) break;
				p = p.getESuperPackage();
			}
			return path;
		}

		/**
		 * Provides a subpackage identified by a given name.
		 * @param p The parent package.
		 * @param ePackageName The name of the subpackage.
		 * @return The subpackage of p with the given name if it exists or null.
		 */
		private static EPackage getSubEPackage(EPackage p, String ePackageName) {
			for(EPackage subPackage : p.getESubpackages())
				if (subPackage.getName().equals(ePackageName)) return subPackage;
			return null;
		}

		/**
		 * Creates a map between the provided source instances and copies of
		 * this instances in the new metamodel.
		 * @param modelRootObject root instance of the source model.
		 * @param newMetamodelRootPackage root package of the new metamodel.
		 */
		public EObjectMap(EObject modelRootObject, EPackage newMetamodelRootPackage) {
			this.modelRootObject = modelRootObject;
			this.oldMetamodelRootPackage = modelRootObject.eClass().getEPackage();
			this.newMetamodelRootPackage = newMetamodelRootPackage;
			this.map = new HashMap<EObject, EObject>();
			for (EObject eo : getAllInstances(modelRootObject)){ this.map.put(eo, this.createObjectCopy(eo)); }
		}

		/**
		 * Creates a map between the provided source instances and copies of this instances in the new metamodel.
		 * @param modelRootObject  root instance of the source model.
		 * @param newMetamodelRootPackage root package of the new metamodel.
		 * @param renameMap Map of old name and new name of all model elements.
		 */
		public EObjectMap(EObject modelRootObject, EPackage newMetamodelRootPackage, Map<String, Map<String, Map<String, String>>> renamingMap) {
			this.modelRootObject = modelRootObject;
			this.oldMetamodelRootPackage = modelRootObject.eClass().getEPackage();
			this.newMetamodelRootPackage = newMetamodelRootPackage;
			this.map = new HashMap<EObject, EObject>();
			for (EObject eo : getAllInstances(modelRootObject)){ this.map.put(eo, this.createObjectCopy(eo, renamingMap)); }
		}

		/**
		 * Creates a map between the provided source instances and copies of this instances in the new metamodel.
		 * @param modelRootObject root instance of the source model.
		 * @param newMetamodelRootPackage root package of the new metamodel.
		 * @param modelRootObjectCopy A copy of the root instance of the source model.
		 * @param renameMap Map of old name and new name of all model elements.
		 */
		public EObjectMap(EObject modelRootObject, EPackage newMetamodelRootPackage, EObject modelRootObjectCopy, Map<String, Map<String, Map<String, String>>> renameMap) {
			this.modelRootObject = modelRootObject;
			this.oldMetamodelRootPackage = modelRootObject.eClass().getEPackage();
			this.newMetamodelRootPackage = newMetamodelRootPackage;
			this.map = new HashMap<EObject, EObject>();
			this.initialmap = new HashMap<EObject, EObject>();
			for (EObject eo : getAllInstances(modelRootObject)){ this.map.put(eo, this.createObjectCopy(eo, renameMap)); }
			for (EObject eo : getAllInstances(modelRootObjectCopy)){ this.initialmap.put(eo, this.createObjectCopy(eo, renameMap)); }
		}

		/**
		 * Creates a map between the provided source instances and copies of
		 * this instances in the new metamodel.
		 * @param modelRootObject root instance of the source model.
		 * @param newMetamodelRootPackage root package of the new metamodel.
		 */
		public EObjectMap(EObject auxmodelRootObject, EObject modelRootObject, EPackage newMetamodelRootPackage) {
			this.auxmodelRootObject = auxmodelRootObject;
			this.modelRootObject = modelRootObject;
			this.oldMetamodelRootPackage = modelRootObject.eClass().getEPackage();
			this.newMetamodelRootPackage = newMetamodelRootPackage;
			this.map = new HashMap<EObject, EObject>();
			for (EObject eo : getAllInstances(modelRootObject)) { this.map.put(eo, this.createObjectCopy(eo)); 	}		
		}

		/**
		 * Creates a map between the provided source instances and copies of this instances in the new metamodel.
		 * @param auxmodelRootObject A copy of the root instance of the source model.
		 * @param modelRootObject root instance of the source model.
		 * @param newMetamodelRootPackage root package of the new metamodel.
		 * @param renamingMap Map of old name and new name of all model elements.
		 */
		public EObjectMap(EObject auxmodelRootObject, EObject modelRootObject, EPackage newMetamodelRootPackage, Map<String, Map<String,Map<String,String>>> renamingMap) {			
			this.auxmodelRootObject = auxmodelRootObject;
			this.modelRootObject = modelRootObject;
			this.oldMetamodelRootPackage = modelRootObject.eClass().getEPackage();
			this.newMetamodelRootPackage = newMetamodelRootPackage;
			this.map = new HashMap<EObject, EObject>();
			for (EObject eo : getAllInstances(modelRootObject)) { this.map.put(eo, this.createObjectCopy(eo, renamingMap)); }
		}

		/**
		 * Creates the copy the feature values of the source model.
		 */
		@SuppressWarnings("unchecked")
		public void copyFeatures() {
			for (EObject sourceInstance : this.map.keySet()) {
				EObject targetInstance = this.map.get(sourceInstance);
				// Recreation of changeable features (excluding derived features):
				for (EStructuralFeature sourceFeature : sourceInstance.eClass().getEAllStructuralFeatures()){
					if (sourceInstance.eIsSet(sourceFeature)) {
						EStructuralFeature targetFeature = targetInstance.eClass().getEStructuralFeature(sourceFeature.getName());
						if (targetFeature==null) throw new IllegalArgumentException("The source feature "+sourceInstance.eClass().getName()+"."+sourceFeature.getName()+" is not found in the target metamodel.");
						if (targetFeature.isChangeable() // there is something to set in the target...
								&& (!(targetFeature instanceof EReference) || !((EReference)targetFeature).isContainer())) // ...which is not a container
							if (sourceFeature.isMany()) // update of many valued feature
								for (Object sourceFeatureValue : (EList<?>)sourceInstance.eGet(sourceFeature)){
									((EList<Object>) targetInstance.eGet(targetFeature)).add(this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));}
							else { // update of single valued reference
								Object sourceFeatureValue = sourceInstance.eGet(sourceFeature);
								if (sourceFeatureValue!=null) targetInstance.eSet(targetFeature, this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));
							}
					}
				}
			}
		}

		/**
		 * Creates the copy of the feature values of the source model.
		 * @param renameMap Map relating oldName and newName of all features in the model.
		 */
		@SuppressWarnings("unchecked")
		public void copyFeatures(Map<String, Map<String, Map<String, String>>> renameMap) {
			for (EObject sourceInstance : this.map.keySet()) {
				Map<String, Map<String, String>> newName = renameMap.get(sourceInstance.eClass().getName());
				Map<String,String> featuresName = new HashMap<String, String>();
				String newClassName = null;
				for (Entry<String, Map<String, String>> e: newName.entrySet()) {
					newClassName = e.getKey();
					featuresName = e.getValue();
				}
				EObject targetInstance = this.map.get(sourceInstance);
				// Recreation of changeable features (excluding derived features):
				for (EStructuralFeature sourceFeature : sourceInstance.eClass().getEAllStructuralFeatures()){
					if (sourceInstance.eIsSet(sourceFeature)) {
						EStructuralFeature targetFeature = targetInstance.eClass().getEStructuralFeature(featuresName.get(sourceFeature.getName()));
						if (targetFeature==null) throw new IllegalArgumentException("The source feature "+sourceInstance.eClass().getName()+"."+sourceFeature.getName()+" is not found in the target metamodel.");
						if (targetFeature.isChangeable() // there is something to set in the target...
								&& (!(targetFeature instanceof EReference) || !((EReference)targetFeature).isContainer())) // ...which is not a container
							if (sourceFeature.isMany()) // update of many valued feature
								for (Object sourceFeatureValue : (EList<?>)sourceInstance.eGet(sourceFeature)){
									((EList<Object>) targetInstance.eGet(targetFeature)).add(this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));}
							else { // update of single valued reference
								Object sourceFeatureValue = sourceInstance.eGet(sourceFeature);
								if (sourceFeatureValue!=null) targetInstance.eSet(targetFeature, this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));
							}
					}
				}
			}
		}

		/**
		 * Creates the copy of the feature values of the source model.
		 * @param migration Migration specification.
		 * @param mapDerived Map relating the name and the object of derived references 
		 * @param mapHidden Map relating the name and the object of hidden elements of the model.
		 * @param modelRootObject2 A copy of the model.
		 * @param newReferenceNameMap Map relating old name and new name of references in the model.
		 * @param renameMap Map relating oldName and newName of all classes of the metamodel to which the model conforms.
		 */
		@SuppressWarnings("unchecked")
		public void copyFeatures2(Migration migration, Map<String, Map<String, ArrayList<Object>>> mapDerived, 
				Map<String, Map<String, ArrayList<Object>>> mapHidden, EObject modelRootObject2, 
				Map<String,String> newReferenceNameMap, Map<String, Map<String, Map<String, String>>> renameMap) {
			for (EObject sourceInstance : this.map.keySet()) {
				for(Instance instance: migration.getInstances()){
					if(instance.getUUID().equals(sourceInstance.eGet(sourceInstance.eClass().getEStructuralFeature("UUID")).toString())){
						if(!instance.getDerived().isEmpty()){
							EList<DerivedReference> deriveds = instance.getDerived();
							for(DerivedReference derived : deriveds){
								EList<ReferencePath> paths = derived.getPath();
								for(ReferencePath path:paths){
									EObject targetInstance = this.map.get(sourceInstance);
									// Recreation of changeable features (excluding derived features):
									for (EStructuralFeature sourceFeature : sourceInstance.eClass().getEAllStructuralFeatures()){
										if(sourceFeature.getName().equals(path.getReferenceName())){
											//buildMap(migration);
											Map<String, ArrayList<Object>> mapList = mapDerived.get(instance.getUUID());
											if (sourceInstance.eIsSet(sourceFeature)) {
												EStructuralFeature targetFeature = targetInstance.eClass().getEStructuralFeature(sourceFeature.getName());
												if(targetFeature == null){
													for (Entry<EObject, EObject> e: this.map.entrySet()) {
														EObject key = e.getKey();
														String keyid = key.eGet(key.eClass().getEStructuralFeature("UUID")).toString();
														if(keyid.equals(sourceInstance.eGet(sourceInstance.eClass().getEStructuralFeature("UUID")).toString())){
															for (Entry<String, ArrayList<Object>> e2: mapList.entrySet()) {
																String refName =  e2.getKey();
																ArrayList<Object> searched =  e2.getValue();
																targetFeature = targetInstance.eClass().getEStructuralFeature(refName);
																if (targetFeature.isChangeable()
																		&& (!(targetFeature instanceof EReference) || !((EReference)targetFeature).isContainer())){
																	if (sourceFeature.isMany()){
																		for (EObject sourceInstance2 : UtilEMF.getAllInstances(modelRootObject2)){
																			for (Entry<String, Map<String, ArrayList<Object>>> e3: mapHidden.entrySet()) {
																				String key3 = e3.getKey();
																				if(key3.equals(keyid)){
																					Map<String, ArrayList<Object>> val3 = e3.getValue();
																					for(Entry<String, ArrayList<Object>> e4: val3.entrySet()){
																						ArrayList<Object> refList = e4.getValue();
																						for(Object ref : refList){
																							if(ref.equals(sourceInstance2.eGet(sourceInstance2.eClass().getEStructuralFeature("UUID")).toString())){
																								for (EStructuralFeature sourceFeature2 : sourceInstance2.eClass().getEAllStructuralFeatures()){
																									String oldRefName = getReferenceName(mapHidden, ref.toString());
																									if(sourceFeature2.getName().equals(oldRefName)){
																										Object sourceFeatureValue = sourceInstance2.eGet(sourceFeature2);
																										if (sourceFeatureValue!=null){
																											for(Object search : searched){ ((EList<Object>) targetInstance.eGet(targetFeature)).add(this.createFeatureValueCopy2(sourceFeature2, sourceFeatureValue, search.toString()));}
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
															}
														}
													}
												}
											}else{
												EStructuralFeature targetFeature = targetInstance.eClass().getEStructuralFeature(sourceFeature.getName());
												if(targetFeature == null){
													for (Entry<EObject, EObject> e: this.map.entrySet()) {
														EObject key = e.getKey();
														String keyid = key.eGet(key.eClass().getEStructuralFeature("UUID")).toString();
														if(keyid.equals(sourceInstance.eGet(sourceInstance.eClass().getEStructuralFeature("UUID")).toString())){
															for (Entry<String, ArrayList<Object>> e2: mapList.entrySet()) {
																String refName =  e2.getKey();
																ArrayList<Object> searched =  e2.getValue();
																targetFeature = targetInstance.eClass().getEStructuralFeature(refName);
																if (targetFeature.isChangeable()
																		&& (!(targetFeature instanceof EReference) || !((EReference)targetFeature).isContainer())){
																	if (sourceFeature.isMany()){
																		for (EObject sourceInstance2 : UtilEMF.getAllInstances(modelRootObject2)){
																			for (Entry<String, Map<String, ArrayList<Object>>> e3: mapHidden.entrySet()) {
																				String key3 = e3.getKey();
																				if(key3.equals(keyid)){
																					Map<String, ArrayList<Object>> val3 = e3.getValue();
																					for(Entry<String, ArrayList<Object>> e4: val3.entrySet()){
																						ArrayList<Object> refList = e4.getValue();
																						for(Object ref : refList){
																							if(ref.equals(sourceInstance2.eGet(sourceInstance2.eClass().getEStructuralFeature("UUID")).toString())){
																								for (EStructuralFeature sourceFeature2 : sourceInstance2.eClass().getEAllStructuralFeatures()){
																									String oldRefName = getReferenceName(mapHidden, ref.toString());
																									if(sourceFeature2.getName().equals(oldRefName)){
																										Object sourceFeatureValue = sourceInstance2.eGet(sourceFeature2);
																										if (sourceFeatureValue!=null){
																											for(Object search : searched){ ((EList<Object>) targetInstance.eGet(targetFeature)).add(this.createFeatureValueCopy2(sourceFeature2, sourceFeatureValue, search.toString()));}
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
															}
														}
													}
												}
											}
										}else{
											if (sourceInstance.eIsSet(sourceFeature)) {
												EStructuralFeature targetFeature = targetInstance.eClass().getEStructuralFeature(sourceFeature.getName());
												EStructuralFeature targetFeature2 = null;
												if (targetFeature==null){
													targetFeature2 = targetInstance.eClass().getEStructuralFeature(newReferenceNameMap.get(sourceFeature.getName())); // ****
													if(targetFeature2 == null){ throw new IllegalArgumentException("The source feature "+sourceInstance.eClass().getName()+"."+sourceFeature.getName()+" is not found in the target metamodel."); }
												}
												if(targetInstance.eClass().getEStructuralFeature(newReferenceNameMap.get(sourceFeature.getName())) != null){
													if (targetFeature2.isChangeable() // there is something to set in the target...
															&& (!(targetFeature2 instanceof EReference) || !((EReference)targetFeature2).isContainer())){ // ...which is not a container
														if (sourceFeature.isMany()){ // update of many valued feature
															for (Object sourceFeatureValue : (EList<?>)sourceInstance.eGet(sourceFeature)){ ((EList<Object>) targetInstance.eGet(targetFeature2)).add(this.createFeatureValueCopy2(sourceFeature, sourceFeatureValue, "5"));}
														}else { // update of single valued reference
															Object sourceFeatureValue = sourceInstance.eGet(sourceFeature);
															if (sourceFeatureValue!=null) targetInstance.eSet(targetFeature2, this.createFeatureValueCopy2(sourceFeature, sourceFeatureValue,"5"));
														}
													}
												}else 
													if (targetFeature.isChangeable() // there is something to set in the target...
															&& (!(targetFeature instanceof EReference) || !((EReference)targetFeature).isContainer())){ // ...which is not a container
														if (sourceFeature.isMany()){ // update of many valued feature
															for (Object sourceFeatureValue : (EList<?>)sourceInstance.eGet(sourceFeature)){ ((EList<Object>) targetInstance.eGet(targetFeature)).add(this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));}
														}else { // update of single valued reference
															Object sourceFeatureValue = sourceInstance.eGet(sourceFeature);
															if (sourceFeatureValue!=null) targetInstance.eSet(targetFeature, this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));
														}
													}
											}
										}
									}
								}
							}
							// without derived
						}else{
							for (EStructuralFeature sourceFeature : sourceInstance.eClass().getEAllStructuralFeatures()){
								if (sourceInstance.eIsSet(sourceFeature)) {
									EObject targetInstance = this.map.get(sourceInstance);
									EStructuralFeature targetFeature = targetInstance.eClass().getEStructuralFeature(sourceFeature.getName());
									if (targetFeature==null) throw new IllegalArgumentException("The source feature "+sourceInstance.eClass().getName()+"."+sourceFeature.getName()+" is not found in the target metamodel.");
									if (targetFeature.isChangeable() // there is something to set in the target...
											&& (!(targetFeature instanceof EReference) || !((EReference)targetFeature).isContainer())) // ...which is not a container
										if (sourceFeature.isMany()) // update of many valued feature
											for (Object sourceFeatureValue : (EList<?>)sourceInstance.eGet(sourceFeature)){
												((EList<Object>) targetInstance.eGet(targetFeature)).add(this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));
											}
										else { // update of single valued reference
											Object sourceFeatureValue = sourceInstance.eGet(sourceFeature);
											if (sourceFeatureValue!=null) targetInstance.eSet(targetFeature, this.createFeatureValueCopy(sourceFeature, sourceFeatureValue));
										}
								}
							}
						}
					}
				}
			}
		}	

		/**
		 * Creates a copy in the new metamodel of a feature value related to a class
		 * of the source metamodel.
		 * @param sourceFeature Source feature.
		 * @param sourceFeatureValue Source feature value to copy.
		 * @return copy of the source feature value.
		 */
		private Object createFeatureValueCopy(EStructuralFeature sourceFeature, Object sourceFeatureValue) {
			EClassifier sourceAttributeType = sourceFeature.getEType();
			List<EPackage> sourceAttributeTypePackagePath = getEPackagePath(sourceAttributeType.getEPackage(), this.oldMetamodelRootPackage);
			if (!sourceAttributeTypePackagePath.get(0).equals(this.oldMetamodelRootPackage))
				// The type of the feature is not defined within the new package, so we try to keep the current value:
				return sourceFeatureValue;
			EPackage targetPackage = getEndOfEPackagePath(sourceAttributeTypePackagePath, this.newMetamodelRootPackage);
			if (targetPackage==null) throw new IllegalArgumentException("The target EPackage matching with the source EPackage "+sourceAttributeType.getEPackage()+" is not found.");
			if (sourceAttributeType instanceof EDataType) { // the feature is an attribute: data type (including enum)
				EClassifier targetAttributeType = targetPackage.getEClassifier(sourceAttributeType.getName());
				if (targetAttributeType==null) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" does not contain the required data type "+sourceAttributeType.getName());
				if (!(targetAttributeType instanceof EDataType)) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" contains a classifier "+sourceAttributeType.getName()+" which is not a data type (and which sould be)");
				return targetPackage.getEFactoryInstance().createFromString(((EDataType)targetAttributeType), sourceFeatureValue.toString());
			}
			// the feature is a local reference:
			return this.map.get(sourceFeatureValue);
		}

		/**
		 * Creates a copy in the new metamodel of a feature value related to a class of the source metamodel.
		 * @param sourceFeature Source feature.
		 * @param sourceFeatureValue Source feature value to copy.
		 * @param search
		 * @return copy of the source feature value.
		 */
		private Object createFeatureValueCopy2(EStructuralFeature sourceFeature, Object sourceFeatureValue, String search) {
			EClassifier sourceAttributeType = sourceFeature.getEType();
			List<EPackage> sourceAttributeTypePackagePath = getEPackagePath(sourceAttributeType.getEPackage(), this.oldMetamodelRootPackage);
			if (!sourceAttributeTypePackagePath.get(0).equals(this.oldMetamodelRootPackage)){
				// The type of the feature is not defined within the new package, so we try to keep the current value:
				return sourceFeatureValue;
			}
			EPackage targetPackage = getEndOfEPackagePath(sourceAttributeTypePackagePath, this.newMetamodelRootPackage);
			if (targetPackage==null){
				throw new IllegalArgumentException("The target EPackage matching with the source EPackage "+sourceAttributeType.getEPackage()+" is not found.");
			}
			if (sourceAttributeType instanceof EDataType) { // the feature is an attribute: data type (including enum)
				EClassifier targetAttributeType = targetPackage.getEClassifier(sourceAttributeType.getName());
				if (targetAttributeType==null) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" does not contain the required data type "+sourceAttributeType.getName());
				if (!(targetAttributeType instanceof EDataType)) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" contains a classifier "+sourceAttributeType.getName()+" which is not a data type (and which sould be)");
				return targetPackage.getEFactoryInstance().createFromString(((EDataType)targetAttributeType), sourceFeatureValue.toString());
			}
			if(this.map.get(sourceFeatureValue) == null){
				return (Object)getValue(search);
			}else{			
				// the feature is a local reference:
				return this.map.get(sourceFeatureValue);				
			}
		}

		/**
		 * Creates a copy in the new metamodel of an instance conforming to the class
		 * of the source metamodel.
		 * @param source Object to copy.
		 * @return copy of the source object.
		 */
		private EObject createObjectCopy(EObject source) {
			EClass sourceClassType = source.eClass();
			List<EPackage> sourceClassTypePackagePath = getEPackagePath(sourceClassType.getEPackage(), this.oldMetamodelRootPackage);
			if (!sourceClassTypePackagePath.get(0).equals(this.oldMetamodelRootPackage))
				// The type of the object is not defined within the new package, so we try to create a new instance from this object's class:
				return EcoreUtil.create(sourceClassType);
			EPackage targetPackage = getEndOfEPackagePath(sourceClassTypePackagePath, this.newMetamodelRootPackage);
			if (targetPackage==null) throw new IllegalArgumentException("The target EPackage matching with the source EPackage "+sourceClassType.getEPackage()+" is not found.");
			EClassifier copyClass = targetPackage.getEClassifier(sourceClassType.getName());
			if (copyClass==null) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" does not contain the required class "+sourceClassType.getName());
			if (!(copyClass instanceof EClass)) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" contains a classifier "+sourceClassType.getName()+" which is not an EClass (and which sould be)");
			return EcoreUtil.create((EClass)copyClass);
		}

		/**
		 * Creates a copy in the new metamodel of an instance conforming to the class of the source metamodel.
		 * @param source Object to copy.
		 * @param renameMap Map relating old name and new name of elements in the model.
		 * @return copy of the source object.
		 */
		private EObject createObjectCopy(EObject source, Map<String, Map<String,Map<String,String>>> renameMap) {
			EClass sourceClassType = source.eClass();
			Map<String, Map<String,String>> value = renameMap.get(sourceClassType.getName());
			String key = null ;
			Map<String,String> val = new HashMap<String, String>();
			for (Entry<String, Map<String,String>> e: value.entrySet()) {
				key = e.getKey();
				val = e.getValue();
			}
			List<EPackage> sourceClassTypePackagePath = getEPackagePath(sourceClassType.getEPackage(), this.oldMetamodelRootPackage);
			if (!sourceClassTypePackagePath.get(0).equals(this.oldMetamodelRootPackage))
				// The type of the object is not defined within the new package, so we try to create a new instance from this object's class:
				return EcoreUtil.create(sourceClassType);
			EPackage targetPackage = getEndOfEPackagePath(sourceClassTypePackagePath, this.newMetamodelRootPackage);
			if (targetPackage==null) throw new IllegalArgumentException("The target EPackage matching with the source EPackage "+sourceClassType.getEPackage()+" is not found.");
			EClassifier searched = null;
			for(EClassifier tp : targetPackage.getEClassifiers()){
				if(tp.getName().equals(key)){
					searched = tp;
					break;
				}	
			}
			EClassifier copyClass = searched;
			if (copyClass==null) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" does not contain the required class "+sourceClassType.getName());
			if (!(copyClass instanceof EClass)) throw new IllegalArgumentException("The target EPackage "+targetPackage.getName()+" contains a classifier "+sourceClassType.getName()+" which is not an EClass (and which sould be)");
			return EcoreUtil.create((EClass)copyClass);
		}

		/**
		 * Provides the source model copy.
		 * @return the copy of the root instance of the source model.
		 */
		public EObject getRootCopy() {
			return this.map.get(this.modelRootObject);
		}

		/**
		 * Get the name of a reference of the model.
		 * @param mapHidden Map relating name and object of hidden elements.
		 * @param uuid Identifier of the instance containing the reference.
		 * @return result Name of the reference.
		 */
		public String getReferenceName(Map<String, Map<String, ArrayList<Object>>> mapHidden, String uuid){
			String result = null;
			for (Entry<String, Map<String, ArrayList<Object>>> e: mapHidden.entrySet()) {
				String key = e.getKey();
				if(key.equals(uuid)){
					Map<String, ArrayList<Object>> val2 = e.getValue();
					for(Entry<String, ArrayList<Object>> e2: val2.entrySet()){
						result = e2.getKey();
						break;
					}
				}
			}
			return result;		
		}

		/**
		 * Get the instance with the UUID given in parameter.
		 * @param search UUID of the searched instance.
		 * @return result. Instance of the model
		 */
		public EObject getValue(String search){
			EObject result = null;
			for (Entry<EObject, EObject> e: this.map.entrySet()) {
				EObject key = e.getKey();
				String keyid = key.eGet(key.eClass().getEStructuralFeature("UUID")).toString();
				if(keyid.equals(search)){
					result = e.getValue();
					break;
				}
			}
			return result;
		}

		/**
		 * Build a map of migration.
		 * @param migration Migration specification.
		 */
		/*public void buildMap(Migration migration){
			for (Entry<EObject, EObject> e: this.map.entrySet()) {
				EObject key = e.getKey();
				String keyid = key.eGet(key.eClass().getEStructuralFeature("UUID")).toString();
				EObject value = e.getValue();
				String valueid = value.eGet(value.eClass().getEStructuralFeature("UUID")).toString();
			}
			for (EObject sourceInstance : this.map.keySet()) {
				for (EStructuralFeature sourceFeature : sourceInstance.eClass().getEAllStructuralFeatures()){
					if (sourceInstance.eIsSet(sourceFeature)) {
						if (sourceFeature.isChangeable() // there is something to set in the target...
								&& (!(sourceFeature instanceof EReference) || !((EReference)sourceFeature).isContainer())){
							if (sourceFeature.isMany()){
								for (Object sourceFeatureValue : (EList<?>)sourceInstance.eGet(sourceFeature)){
								}
							}else{
								Object r = sourceInstance.eGet(sourceFeature);
								Object sourceFeatureValue = sourceInstance.eGet(sourceFeature);
							}
						}
					}
				}
			}
		}*/
	}


	/**
	 * Relink a package with its external packages.
	 * 
	 * @param packageKeyPackageMap
	 * @param relatedPackages List of external packages related to a package.
	 * @return
	 */
	private Map<EPackage, String> relinkMetamodels(Map<EPackage, EPackage> packageKeyPackageMap, Map<EPackage, ArrayList<EPackage>> relatedPackages){
		ArrayList<EPackage> packageWithUUID = new ArrayList<EPackage>();
		ArrayList<EPackage> packageWithOutUUID = new ArrayList<EPackage>();
		for (Entry<EPackage, ArrayList<EPackage>> e: relatedPackages.entrySet()) {
			EPackage ep = packageKeyPackageMap.get(e.getKey());
			packageWithUUID.add(ep);
			for(TreeIterator<EObject> it = ep.eAllContents(); it.hasNext();){
				EObject next = it.next();
				ArrayList<EClass> toAdd = new ArrayList<EClass>();
				ArrayList<EClass> toRemove = new ArrayList<EClass>();
				if(next instanceof EClass){
					EClass c = (EClass) next;
					for(EClass sc : c.getESuperTypes()){
						EPackage scContainerPackage = (EPackage)(sc.eContainer());
						if(!scContainerPackage.equals(ep)){
							for (Entry<EPackage, EPackage> e2: packageKeyPackageMap.entrySet()) {
								EPackage key = e2.getKey();
								EPackage newContainer = e2.getValue();
								if(scContainerPackage.getNsURI().equals(key.getNsURI())){	
									// get class of package
									EClass relatedClass = getClass(newContainer, sc);
									toAdd.add(relatedClass);
									toRemove.add(sc);
								}
							}
						}
					}
					if(!toAdd.isEmpty()){ c.getESuperTypes().addAll(toAdd); }
					if(!toRemove.isEmpty()){ c.getESuperTypes().removeAll(toRemove); }
					// references dans ecores externes
					for(EReference er : c.getEAllReferences()){
						EPackage containerPackage = (EPackage)(er.getEType().eContainer());
						if(!containerPackage.equals(ep)){
							for (Entry<EPackage, EPackage> e2: packageKeyPackageMap.entrySet()) {
								EPackage key = e2.getKey();
								EPackage newContainer = e2.getValue();
								if(containerPackage.getNsURI().equals(key.getNsURI())){	
									EClass relatedClass = getClass(newContainer, (EClass)er.getEType());
									er.setEType(relatedClass);
								}
							}
						}
					}
				}
			}
		}
		for (Entry<EPackage, String> e: packageLocationMap.entrySet()) {
			if(!packageWithUUID.contains(e.getKey())){ packageWithOutUUID.add(e.getKey()); }	
		}
		for(EPackage p : packageWithOutUUID){ packageLocationMap.remove(p); }
		return packageLocationMap;
	}

	// PRIVATE **********************************************************************************

	private static Map<EPackage, String> packageLocationMap = new HashMap<EPackage, String>();

	/**
	 * Creating an ecore composed of subpackages. Each subpackage correspond to an external ecore.
	 * 
	 * @param relatedPackages Map of the root package and its related metamodels.
	 * @param originalEcoreFilePath Path of the root object of the metamodel.
	 * @param rootPackage Root object of the metamodel.
	 * @return newRootPackage A package containing all external packages.
	 */
	private EPackage createExtendedEcore(Map<EPackage, ArrayList<EPackage>> relatedPackages, String originalEcoreFilePath, EPackage rootPackage){
		String name =  rootPackage.getName()+"Extended";
		EPackage newRootPackage;
		EcoreFactory theCoreFactory = EcoreFactory.eINSTANCE;
		newRootPackage = theCoreFactory.createEPackage();
		newRootPackage.setName(name);
		newRootPackage.setNsPrefix(name);
		newRootPackage.setNsURI("http://"+name+".ecore");
		for (Entry<EPackage, ArrayList<EPackage>> e: relatedPackages.entrySet()) {
			EPackage ep = e.getKey();
			EPackage pack = theCoreFactory.createEPackage();
			if(!isContainedInEcore(newRootPackage, ep)){
				if(!ep.getName().equals("ecore")){
					pack = EcoreUtil.copy(ep);
					pack.setName(pack.getName());
					pack.setNsPrefix(pack.getNsPrefix());
					pack.setNsURI(pack.getNsURI());
					for(EClassifier ec : pack.getEClassifiers()){
						ArrayList<EClass> toRemove = new ArrayList<EClass>();
						if(ec instanceof EClass){
							for(EClass sc : ((EClass) ec).getESuperTypes()){ toRemove.add(sc); }
							if(!toRemove.isEmpty()){ ((EClass) ec).getESuperTypes().removeAll(toRemove); }
							//fake references
							for(EReference er : ((EClass) ec).getEAllReferences()){ er.setEType(ec); }
						}
					}
					newRootPackage.getESubpackages().add(pack);
				}
			}
		}
		// reestablish super classes
		newRootPackage = reestablishSuperClass(newRootPackage, relatedPackages);
		// reestablish references
		newRootPackage = reestablishReference(newRootPackage, relatedPackages);
		// remove annotations
		newRootPackage = removeAnnotation(newRootPackage, relatedPackages);
		return newRootPackage;
	}

	/**
	 * Reestablish super classes in case they have been modified.
	 * @param rootPackage Root object of the metamodel.
	 * @param  relatedPackages
	 * @return A package with all its superclasses.
	 */
	private EPackage reestablishSuperClass(EPackage rootPackage, Map<EPackage, ArrayList<EPackage>> relatedPackages) {
		// recuperer chaque subpackage
		Map <String, ArrayList<EClass>> mapToAdd = new HashMap<String, ArrayList<EClass>>();
		for(EPackage subp : rootPackage.getESubpackages()){
			// recherche du package initial de chaque subpackage
			for (Entry<EPackage, ArrayList<EPackage>> e: relatedPackages.entrySet()) {
				EPackage epackage = e.getKey();
				if(subp.getNsURI().equals(epackage.getNsURI())){
					// parcours des classes
					for(EClassifier eclassk : epackage.getEClassifiers()){
						// class du rootPackage a modifier
						ArrayList<EClass> toAdd = new ArrayList<EClass>();
						EClass c = null;
						for(EClassifier eclass : subp.getEClassifiers()){
							if(eclass instanceof EClass){
								c = (EClass) eclass;
								if(eclass.getName().equals(eclassk.getName())){
									// verifier si la class a des superclasses
									if(!((EClass) eclassk).getESuperTypes().isEmpty()){
										// recupperer les superclasses
										for(EClassifier esuperclassk : ((EClass) eclassk).getESuperTypes()){
											// recuperer le package qui contient la superclass
											EPackage containerPackage = null;
											for(EPackage subpp : rootPackage.getESubpackages()){
												for(EClassifier eclasskk : subpp.getEClassifiers()){
													if(eclasskk.getName().equals(esuperclassk.getName())){
														containerPackage = subpp;
														break;
													}
												}
											}
											// recuperer le package (du ecore extended) dans lequel se trouve la classe
											EClassifier newClass = getClass(containerPackage, (EClass) esuperclassk);
											if(newClass != null){
												toAdd.add((EClass) newClass); 
												mapToAdd.put(eclass.getName(), toAdd);
											}
										}
									}
								}
							}
						}
						rootPackage = addSuperClasses(rootPackage, relatedPackages, mapToAdd);
					}
				}
			}
		}
		return rootPackage;
	}

	/**
	 * Reestablish super classes in case they have been modified.
	 * @param rootPackage Root object of the metamodel.
	 * @param packageKeyPackageMap
	 * @return A package with all its superclasses.
	 */
	private EPackage reestablishSuperClasses(EPackage rootPackage, Map<EPackage, EPackage> packageKeyPackageMap){
		// recuperer chaque subpackage
		Map <String, ArrayList<EClass>> mapToAdd = new HashMap<String, ArrayList<EClass>>();
		for(EPackage subp : rootPackage.getESubpackages()){
			// recherche du package initial de chaque subpackage
			for (Entry<EPackage, EPackage> e: packageKeyPackageMap.entrySet()) {
				EPackage epackagek = e.getValue();
				if(subp.getNsURI().equals(epackagek.getNsURI())){
					// parcours des classes
					for(EClassifier eclassk : epackagek.getEClassifiers()){
						// class du rootPackage a modifier
						ArrayList<EClass> toAdd = new ArrayList<EClass>();
						EClass c = null;
						for(EClassifier eclass : subp.getEClassifiers()){
							if(eclass instanceof EClass){
								c = (EClass) eclass;
								if(eclass.getName().equals(eclassk.getName())){
									// verifier si la class a des superclasses
									if(!((EClass) eclassk).getESuperTypes().isEmpty()){
										// recupperer les superclasses
										for(EClassifier esuperclassk : ((EClass) eclassk).getESuperTypes()){
											// recuperer le package qui contient la superclass
											EPackage containerPackage = null;
											for(EPackage subpp : rootPackage.getESubpackages()){
												for(EClassifier eclasskk : subpp.getEClassifiers()){
													if(eclasskk.getName().equals(esuperclassk.getName())){
														containerPackage = subpp;
														break;
													}
												}
											}
											// recuperer le package (du ecore extended) dans lequel se trouve la classe
											EClassifier newClass = getClass(containerPackage, (EClass) esuperclassk);
											if(newClass != null){
												toAdd.add((EClass) newClass); 
												mapToAdd.put(eclass.getName(), toAdd);
											}
										}
									}
								}
							}
						}
						rootPackage = addSuperTypes(rootPackage, packageKeyPackageMap, mapToAdd);
					}
				}
			}
		}
		return rootPackage;
	}

	/**
	 * Reestablish references if they have been modified.
	 * @param rootPackage Root object of the metamodel.
	 * @param packageKeyPackageMap Map relating a subpackage in the rootPackage and the corresponding external package.
	 * @return A package with all its references to other packages.
	 */
	private EPackage reestablishReferences(EPackage rootPackage, Map<EPackage, EPackage> packageKeyPackageMap){
		// recuperer chaque subpackage
		for(EPackage subp : rootPackage.getESubpackages()){
			// recherche du package initial de chaque subpackage
			for (Entry<EPackage, EPackage> e: packageKeyPackageMap.entrySet()) {
				//EPackage epackage = (EPackage) e.getValue();
				EPackage epackagek = e.getValue();
				if(subp.getNsURI().equals(epackagek.getNsURI())){
					// parcours des classes
					for(EClassifier eclassk : epackagek.getEClassifiers()){
						// class du rootPackage a modifier
						EClass c = null;
						for(EClassifier eclass : subp.getEClassifiers()){
							if(eclass instanceof EClass){
								c = (EClass) eclass;
								if(eclass.getName().equals(eclassk.getName())){
									// verifier si la class a de references vers d'autres packages
									for(EReference er : ((EClass) eclassk).getEAllReferences()){
										// recupperer er du ecore extended
										for(EReference err :  c.getEAllReferences()){
											if(er.getName().equals(err.getName())){
												EClass type = (EClass) er.getEType();
												// recuperer le package qui contient la superclass
												EPackage containerPackage = null;
												for(EPackage subpp : rootPackage.getESubpackages()){
													for(EClassifier eclasskk : subpp.getEClassifiers()){
														if(eclasskk.getName().equals(type.getName())){
															containerPackage = subpp;
															if(containerPackage.getNsURI().equals(((EPackage)type.eContainer()).getNsURI())){
																EClass relatedClass = getClass(containerPackage, (EClass)er.getEType());
																err.setEType(relatedClass);
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
				}
			}
		}
		return rootPackage;
	}


	/**
	 * Reestablish a reference to an external package.
	 * @param rootPackage Root object of the metamodel.
	 * @param relatedPackages Map relating a subpackage in the rootPackage and the corresponding external package.
	 * @return A package with all its references to other packages.
	 */
	private EPackage reestablishReference(EPackage rootPackage, Map<EPackage, ArrayList<EPackage>> relatedPackages){
		// recuperer chaque subpackage
		for(EPackage subp : rootPackage.getESubpackages()){
			// recherche du package initial de chaque subpackage
			for (Entry<EPackage, ArrayList<EPackage>> e: relatedPackages.entrySet()) {
				EPackage epackage = e.getKey();
				if(subp.getNsURI().equals(epackage.getNsURI())){
					// parcours des classes
					for(EClassifier eclass : epackage.getEClassifiers()){
						// class du rootPackage a modifier
						EClass csub = null;
						for(EClassifier eclasssub : subp.getEClassifiers()){
							if(eclasssub instanceof EClass){
								csub = (EClass) eclasssub;
								if(eclasssub.getName().equals(eclass.getName())){
									// verifier si la class a de references vers d'autres packages
									for(EReference er : ((EClass) eclass).getEAllReferences()){
										// recupperer er du ecore extended
										for(EReference ersub :  csub.getEAllReferences()){
											if(er.getName().equals(ersub.getName())){
												EClass type = (EClass) er.getEType();
												// recuperer le package qui contient la superclass
												EPackage containerPackagesub = null;
												for(EPackage subpp : rootPackage.getESubpackages()){
													for(EClassifier subcc : subpp.getEClassifiers()){
														if(subcc.getName().equals(type.getName())){
															containerPackagesub = subpp;
															if(containerPackagesub.getNsURI().equals(((EPackage)type.eContainer()).getNsURI())){
																EClass relatedClass = getClass(containerPackagesub, (EClass)er.getEType());
																ersub.setEType(relatedClass);
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
				}
			}
		}
		return rootPackage;
	}

	/**
	 * Verify if a subpackage is contained in a package.
	 * @param pack Package.
	 * @param subPack Subpackage.
	 * @return True if the subpackage is contained in the package. False otherwise.
	 */
	private boolean isContainedInEcore(EPackage pack, EPackage subPack) {
		boolean result = false;
		for(EPackage p : pack.getESubpackages()){
			if(p.getName().equals(subPack.getName())){
				result= true;
				break;
			}
		}
		return result;
	}

	/**
	 * Return a class contained in a package.
	 * @param ePackage Package in which the class is searched.
	 * @param eClass Class to search in the package.
	 * @return A class of the package.
	 */
	private static EClass getClass(EPackage ePackage, EClass eClass){
		EClass ec = null;
		for(TreeIterator<EObject> it = ePackage.eAllContents(); it.hasNext();){
			EObject next = it.next();
			if(next instanceof EClass){
				EClass c = (EClass) next;
				if(c.getName().equals(eClass.getName())){
					ec = c;
					break;
				}
			}
		}
		return ec;
	}

	/**
	 * Return a class contained in a package.
	 * @param ePackage Package in which the class is searched.
	 * @param eClassName name of the class to search in the package.
	 * @return A class of the package.
	 */
	public static EClass getClass(EPackage ePackage, String eClassName){
		EClass ec = null;
		for(TreeIterator<EObject> it = ePackage.eAllContents(); it.hasNext();){
			EObject next = it.next();
			if(next instanceof EClass){
				EClass c = (EClass) next;
				if(c.getName().equals(eClassName)){
					ec = c;
					break;
				}
			}
		}
		return ec;
	}

	/**
	 * Add super to a package. And associate it to existing classes of the package.
	 * @param rootPackage Root object of the metamodel.
	 * @param packageKeyPackageMap Map relatinf packages with UUIDs and packages without UUIDs.
	 * @param toAddMap
	 * @return rootPackage Root package containing the added super class.
	 */
	private EPackage addSuperTypes(EPackage rootPackage, Map<EPackage, EPackage> packageKeyPackageMap, Map<String, ArrayList<EClass>> toAddMap){
		for(EPackage subp : rootPackage.getESubpackages()){
			for(EClassifier eclass : subp.getEClassifiers()){
				ArrayList<EClass> val = toAddMap.get(eclass.getName());
				if(val != null){ ((EClass) eclass).getESuperTypes().addAll(val); }
			}
		}
		return rootPackage;
	}

	/**
	 * Add super to a package. And associate it to existing classes of the package.
	 * @param rootPackage Root object of the metamodel.
	 * @param relatedPackagesMap
	 * @param toAddMap
	 * @return
	 */
	private EPackage addSuperClasses(EPackage rootPackage, Map<EPackage, ArrayList<EPackage>> relatedPackagesMap, Map<String, ArrayList<EClass>> toAddMap){
		for(EPackage subp : rootPackage.getESubpackages()){
			for(EClassifier eclass : subp.getEClassifiers()){
				ArrayList<EClass> val = toAddMap.get(eclass.getName());
				if(val != null){ ((EClass) eclass).getESuperTypes().addAll(val); }
			}
		}
		return rootPackage;
	}

	/**
	 * Get the external packages related to a package.
	 * 
	 * @param rootPackage Root object of the metamodel.
	 * @param thePackageLocationMap Maps relating package and its path.
	 * @param evaluated. True if the package have been already evaluated.
	 * @return relatedPackagesMap Maps relating package and its path.
	 */
	private Map<EPackage, ArrayList<EPackage>> getRelatedPackages(EPackage rootPackage, Map<EPackage, String> thePackageLocationMap, ArrayList<EPackage> evaluated){
		ArrayList<EPackage> alreadyEvaluated;
		if(evaluated == null || evaluated.isEmpty()){ alreadyEvaluated = new ArrayList<EPackage>(); }
		else{ alreadyEvaluated = evaluated; }
		packageLocationMap = thePackageLocationMap;
		Map<EPackage, ArrayList<EPackage>> relatedPackagesMap = new HashMap<EPackage, ArrayList<EPackage>>();
		ArrayList<EPackage> packagesList = new ArrayList<EPackage>();
		for(TreeIterator<EObject> it = rootPackage.eAllContents(); it.hasNext();){
			EObject next = it.next();
			if(next instanceof EClass){
				EClass c = (EClass) next;
				// look for references to classes contained in external ecore
				for(EReference er : c.getEAllReferences()){
					EPackage containerPackage = (EPackage)(er.getEType().eContainer());
					if(containerPackage != null){
						if(!containerPackage.getNsURI().equals(rootPackage.getNsURI())){
							if(!packagesList.contains(containerPackage)){
								packagesList.add(containerPackage);
								String location = lookForLocation(containerPackage, rootPackage, packageLocationMap);
								packageLocationMap.put(containerPackage, location);
							}
						}
					}
				}
				// look for supertypes in external ecore
				for(EClass supertype : c.getEAllSuperTypes()){
					EPackage containerPackage = (EPackage)(supertype.eContainer());
					if(!containerPackage.getNsURI().equals(rootPackage.getNsURI())){
						if(!packagesList.contains(containerPackage)){
							packagesList.add(containerPackage);
							String location = lookForLocation(containerPackage, rootPackage, packageLocationMap);
							packageLocationMap.put(containerPackage, location);
						}
					}
				}
				relatedPackagesMap.put(rootPackage, packagesList);
			}
		}
		if(!packagesList.isEmpty()){
			for(EPackage p : packagesList){
				if(!alreadyEvaluated.contains(p)){
					alreadyEvaluated.add(p);
					Map<EPackage, ArrayList<EPackage>> temporalMap = new HashMap<EPackage, ArrayList<EPackage>>();
					temporalMap = getRelatedPackages(p, packageLocationMap, alreadyEvaluated);
					relatedPackagesMap.putAll(temporalMap);
				}
			}
		}
		return relatedPackagesMap;
	}

	/**
	 * Look for the path of a package.
	 * 
	 * @param ePackage root package.
	 * @param rootPackage root package.
	 * @param packageLocationMap Maps relating package and its path.
	 * @return Path of a package.
	 */
	private String lookForLocation(EPackage ePackage, EPackage rootPackage, Map<EPackage, String> packageLocationMap){
		String rootLocation = packageLocationMap.get(rootPackage);
		return rootLocation.replace(rootPackage.getName()+".ecore", ePackage.getName()+".ecore");		
	}

	/**
	 * Get container package of a class.
	 * 
	 * @param targetPackage 
	 * @param sourceClassType Class to be searched.
	 * @return subpack Package containning the class.
	 */
	private EPackage getContainer(EPackage targetPackage, EClass sourceClassType){
		EPackage subpack = null;
		for( EPackage subp : targetPackage.getESubpackages()){
			EClassifier copyClass2 = subp.getEClassifier(sourceClassType.getName());
			if(copyClass2!=null)
				subpack = subp;
			break;
		}
		return subpack;
	}

	/**
	 * Get the Map relating package and its path.
	 * 
	 * @return packageLocationMap.
	 */
	private Map<EPackage, String> getPackageLocationMap(){
		return packageLocationMap;
	}

	/**
	 * Get subpackages of a package.
	 * 
	 * @param ep Root package.
	 * @param esp Searched subpackage.
	 * @return subpackage.
	 */
	private EPackage getSubpackage(EPackage ep, EPackage esp){
		EPackage subpackage = null;
		for(EPackage sub : ep.getESubpackages()){
			if(sub.getNsURI().equals(esp.getNsURI())){
				subpackage = sub;
				break;
			}
		}
		return subpackage;
	}

	/**
	 * Get the package with UUIDs associated to a packages without UUIDs
	 * @param newPackage 
	 * @param rootPackage Root package.
	 * @return result Package with UUIDs.
	 */
	private EPackage getKeyPackage(EPackage newPackage, EPackage rootPackage) {
		EPackage result = null;
		for(EPackage p : newPackage.getESubpackages()){
			if(p.getName().equals((rootPackage.getName()+"k").toLowerCase())){
				result = p;
				break;
			}
		}
		return result;
	}


	// PUBLIC ***********************************************************************************


	/**
	 * Creates a copy of a given model conforming to a new metamodel.
	 * The new metamodel must be able to produce all the instances of the given model
	 * with all its features. This function is typically used to replace the metamodel
	 * of a model by a direct copy of its current metamodel. 
	 * @param modelRootObject The source model to be recreated with a new metamodel.
	 * @param newMetamodelRootPackage The new metamodel.
	 * @return The copy of the source model with the given new metamodel.
	 */
	public static EObject changeMetamodel(EObject modelRootObject, EPackage newMetamodelRootPackage) {
		EObjectMap eObjectMap = new EObjectMap(modelRootObject, newMetamodelRootPackage);
		eObjectMap.copyFeatures();
		return eObjectMap.getRootCopy();
	}

	/**
	 * Creates a copy of a given model conforming to a new metamodel.
	 * The new metamodel must be able to produce all the instances of the given model
	 * with all its features. This function is typically used to replace the metamodel
	 * of a model by a direct copy of its current metamodel. 
	 * 
	 * @param modelRootObject The source model to be recreated with a new metamodel.
	 * @param newMetamodelRootPackage The new metamodel.
	 * @param renameMap Map relating old name and new name of elements of the model.
	 * @return The copy of the source model with the given new metamodel.
	 */
	public static EObject changeMetamodel(EObject modelRootObject, EPackage newMetamodelRootPackage, Map<String, Map<String, Map<String, String>>> renameMap) {
		EObjectMap eObjectMap = new EObjectMap(modelRootObject, newMetamodelRootPackage, renameMap);
		eObjectMap.copyFeatures(renameMap);
		return eObjectMap.getRootCopy();
	}

	/**
	 * Creates a copy of a given model conforming to a new metamodel.
	 * The new metamodel must be able to produce all the instances of the given model
	 * with all its features. This function is typically used to replace the metamodel
	 * of a model by a direct copy of its current metamodel. 
	 * 
	 * @param modelRootObject The source model to be recreated with a new metamodel.
	 * @param modelRootObject2 Copy of the source model to be recreated with a new metamodel.
	 * @param newMetamodelRootPackage The new metamodel.
	 * @param migrationHide Migration specification.
	 * @param mapDerivedReferences Map relating name and object of derived references.
	 * @param mapHiddenReferences Map relating name and object of hidden elements.
	 * @param newRefNameMap Map relating old name and new name of references of the model.
	 * @param renameMap Map relating old name and new name of elements of the model.
	 * @return The copy of the source model with the given new metamodel.
	 */
	public static EObject changeMetamodel(EObject modelRootObject, EObject modelRootObject2, EPackage newMetamodelRootPackage, 
			Migration migrationHide, Map<String, Map<String, ArrayList<Object>>> mapDerivedReferences, Map<String, Map<String, 
			ArrayList<Object>>> mapHiddenReferences, Map<String,String> newRefNameMap, Map<String, Map<String, Map<String, String>>> renameMap) {
		EObjectMap eObjectMap = new EObjectMap(modelRootObject, newMetamodelRootPackage, modelRootObject2, renameMap);
		eObjectMap.copyFeatures2(migrationHide, mapDerivedReferences, mapHiddenReferences, modelRootObject2, newRefNameMap, renameMap);
		return eObjectMap.getRootCopy();
	}

	/**
	 * Modification of metamodel.
	 * @param modelRootObject Root object whose metaclass belongs
	 * to the EPackage which is intended to be modified.
	 * @param newMetamodelFilePath File path of the new metamodel. 
	 * @return Updated root object.
	 */
	public static EObject changeMetamodel(EObject modelRootObject, String newMetamodelFilePath) {
		// Metamodel loading:
		EPackage newMetamodelRootPackage = loadMetamodel(newMetamodelFilePath);
		// Model update
		return changeMetamodel(modelRootObject, newMetamodelRootPackage);
	}

	/**
	 * Modification of metamodel.
	 * @param modelRootObject Root object whose metaclass belongs
	 * to the EPackage which is intended to be modified.
	 * @param newMetamodelURI URI of the new metamodel. 
	 * @return Updated root object.
	 */
	public static EObject changeMetamodel(EObject modelRootObject, URI newMetamodelURI) {
		// Metamodel loading:
		EPackage newMetamodelRootPackage = loadMetamodel(newMetamodelURI);
		// Model update
		return changeMetamodel(modelRootObject, newMetamodelRootPackage);
	}

	/**
	 * 
	 * @param modelRootObject
	 * @param newMetamodelRootPackage
	 * @param migrationHide
	 * @return
	 */
	public static EObject changeMetamodel(EObject modelRootObject, 	EPackage newMetamodelRootPackage, Migration migrationHide){
		EObjectMap eObjectMap = new EObjectMap(modelRootObject, newMetamodelRootPackage);
		return eObjectMap.getRootCopy();
	}

	/**
	 * Creates a copy of a given model conforming to a new metamodel.
	 * The new metamodel must be able to produce all the instances of the given model
	 * with all its features. This function is typically used to replace the metamodel
	 * of a model by a direct copy of its current metamodel. 
	 * @param modelRootObject The source model to be recreated with a new metamodel.
	 * @param newMetamodelRootPackage The new metamodel.
	 * @return The copy of the source model with the given new metamodel.
	 */
	public static EObject changeMetamodel(EObject auxmodelRootObject, EObject modelRootObject, EPackage newMetamodelRootPackage) {	
		EObjectMap eObjectMap = new EObjectMap(auxmodelRootObject, modelRootObject, newMetamodelRootPackage);
		eObjectMap.copyFeatures();
		return eObjectMap.getRootCopy();
	}

	/**
	 *Creates a copy of a given model conforming to a new metamodel.
	 * The new metamodel must be able to produce all the instances of the given model
	 * with all its features. This function is typically used to replace the metamodel
	 * of a model by a direct copy of its current metamodel. 
	 * 
	 * @param auxmodelRootObject
	 * @param modelRootObject The source model to be recreated with a new metamodel.
	 * @param newMetamodelRootPackage The new metamodel.
	 * @param renameMap
	 * @param migration
	 * @param reversed
	 * @return The copy of the source model with the given new metamodel.
	 */
	public static EObject changeMetamodel(EObject auxmodelRootObject, EObject modelRootObject, EPackage newMetamodelRootPackage, Map<String, Map<String, Map<String, String>>> renameMap, Migration migration, boolean reversed) {
		EObjectMap eObjectMap = new EObjectMap(auxmodelRootObject, modelRootObject, newMetamodelRootPackage, renameMap);
		if(!reversed){
			//eObjectMap.copyFeatures(renameMap, migration);
			// TODO
		}
		else{
			//eObjectMap.copyFeaturesReversed(renameMap, migration);
			// TODO
		}
		return eObjectMap.getRootCopy();
	}

	/**
	 * Dynamic instanciation of a metaclass.
	 * @param className Name of the metaclass to instanciate.
	 * @param metamodelRootPackage Root package of the metamodel defining the metaclass.
	 * @return A new instance of the provided metaclass if it exists or null.
	 */
	public static EObject createInstance(String className, EPackage metamodelRootPackage) {
		EClassifier classToInstanciate = metamodelRootPackage.getEClassifier(className);
		if (classToInstanciate==null || !(classToInstanciate instanceof EClass)) return null;
		return EcoreUtil.create((EClass)classToInstanciate);
	}

	/**
	 * Dynamic instanciation of a metaclass.
	 * @param className Name of the metaclass to instanciate.
	 * @param metamodelFilePath File path of the metamodel defining the metaclass.
	 * @return A new instance of the provided metaclass.
	 */
	public static EObject createInstance(String className, String metamodelFilePath) {
		return createInstance(className, loadMetamodel(metamodelFilePath));
	}

	/**
	 * Dynamic instanciation of a metaclass.
	 * @param className Name of the metaclass to instanciate.
	 * @param metamodelURI URI of the metamodel defining the metaclass.
	 * @return A new instance of the provided metaclass.
	 */
	public static EObject createInstance(String className, URI metamodelURI) {
		return createInstance(className, loadMetamodel(metamodelURI));
	}

	/**
	 * Creation of a default resource set associated to an EPackage NS_URI
	 * and an instance of this EPackage.
	 * @param nsuri NS_URI of the EPackage.
	 * @param metamodelRootPackage Instance of the EPackage.
	 * @return New resource set which package registry maps nsuri to metamodelRootPackage.
	 */
	public static ResourceSet createResourceSet (String nsuri, Object metamodelRootPackage) {
		ResourceSet resourceSet = new ResourceSetImpl();
		// Default XMI extension:
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		// Register:
		resourceSet.getPackageRegistry().put(nsuri, metamodelRootPackage);
		return resourceSet;
	}

	/**
	 * Metamodel (Ecore model) loading.
	 * @param metamodelFilePath File path of the metamodel to load.
	 * @return Root package of the loaded metamodel.
	 */
	public static EPackage loadMetamodel (String metamodelFilePath) {
		EPackage loadedMetamodel = null;
		File metamodelFile = new File(metamodelFilePath);
		if(metamodelFile.exists()){
			loadedMetamodel = loadMetamodel(URI.createFileURI(new File(metamodelFilePath).getAbsolutePath()));
		}else{
		System.err.println("[Loading] file "+metamodelFilePath+" : file does not exist.");
		System.exit(1);
		}
		
		// Metamodel loading:				
		return loadedMetamodel;
	}

	/**
	 * Metamodel (Ecore model) loading.
	 * @param metamodelURI URI of the metamodel to load.
	 * @return Root package of the loaded metamodel.
	 */
	public static EPackage loadMetamodel (URI metamodelURI) {
		// Model loading:		
		return (EPackage)loadModel(metamodelURI, EcorePackage.eINSTANCE);
	}

	/**
	 * Model loading.
	 * @param inputFilePath File name of the model to load.
	 * @param metamodelRootPackage EPackage expected to be
	 * the container of the metaclass of the model root object.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel(String inputFilePath, EPackage metamodelRootPackage) {
		return loadModel(URI.createFileURI(new File(inputFilePath).getAbsolutePath()), metamodelRootPackage);
	}

	/**
	 * Model loading.
	 * @param modelInputFilePath File name of the model to load.
	 * @param metamodelInputFilePath File name of the corresponding metamodel.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel(String modelInputFilePath, String metamodelInputFilePath) {
		return loadModel(URI.createFileURI(new File(modelInputFilePath).getAbsolutePath()), metamodelInputFilePath);
	}

	/**
	 * Model loading.
	 * @param modeluri URI of the model to load.
	 * @param metamodelRootPackage EPackage expected to be
	 * the container of the metaclass of the model root object.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel (URI modeluri, EPackage metamodelRootPackage) {
		// Creation of a ResourceSet mapping the package ns uri to the package:
		ResourceSet resourceSet = createResourceSet(metamodelRootPackage.getNsURI(), metamodelRootPackage);
		// Creation of a resource linked to the model uri:
		Resource resource = resourceSet.getResource(modeluri, true);
		// First element of the model (root object):
		return resource.getContents().get(0);
	}

	/**
	 * Model loading.
	 * @param modeluri URI of the model to load.
	 * @param metamodelFilePath File name of the corresponding metamodel.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel (URI modeluri, String metamodelFilePath) {
		// Model loading:		
		return loadModel(modeluri, URI.createFileURI(new File(metamodelFilePath).getAbsolutePath()));
	}

	/**
	 * Model loading.
	 * @param modeluri URI of the model to load.
	 * @param metamodelURI URI of the corresponding metamodel.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel (URI modeluri, URI metamodelURI) {
		// Metamodel loading:
		EPackage metamodelRootPackage = loadMetamodel(metamodelURI);
		// Model loading:				
		return loadModel(modeluri, metamodelRootPackage);
	}

	/**
	 * Model loading.
	 * @param inputFilePath File name of the model to load.
	 * @param metamodelURI URI of the corresponding metamodel.
	 * @return The EObject corresponding to the loaded model root object.
	 */
	public static EObject loadModel(String inputFilePath, URI metamodelURI) {
		return loadModel(URI.createFileURI(new File(inputFilePath).getAbsolutePath()), metamodelURI);
	}

	/**
	 * Metamodel saving.
	 * The ressource and NsURI of the package are updated.
	 * The packages corresponding to external dependencies 
	 * can be serialised locally together with the metamodel itself.
	 * @param metaModelRootObject Root object of the metamodel to be serialized.
	 * @param outputFilePath Name of the file to be created or updated.
	 * @param withExternalPackageDependencies States if the external dependencies must but serialized or not.
	 * @throws IOException Thrown if the output file cannot be created.
	 * @return The updated root package.
	 */
	public static EPackage saveMetamodel(EPackage metaModelRootObject, String outputFilePath, boolean withExternalPackageDependencies) throws IOException {
		File metamodelFile = new File(outputFilePath);
		String metamodelFilename  = metamodelFile.getAbsolutePath();
		// New NsURI matching with the new file path:
		metaModelRootObject.setNsURI(URI.createFileURI(metamodelFilename).toString());
		// Request for the serialization of external dependencies:
		if (withExternalPackageDependencies) {
			Map<EPackage, Resource> resourcesBackup = new HashMap<EPackage, Resource>();
			for (EPackage ep : getAllExternalPackages(metaModelRootObject)) {
				String pname = ep.getName()+".ecore";
				pname =  Character.toUpperCase(pname.charAt(0)) + pname.substring(1);
				// backup of current resource before saving (and so update):
				Resource currentResource = ep.eResource();
				if (currentResource!=null) resourcesBackup.put(ep, currentResource);
				saveModel(ep, metamodelFile.getParentFile().getAbsolutePath()+"/"+pname);
			}
			// Metamodel serialization:
			saveModel(metaModelRootObject, metamodelFilename);
			// Restoring the initial resources:
			for (EPackage ep : resourcesBackup.keySet()) resourcesBackup.get(ep).getContents().add(ep);
		}
		else saveModel(metaModelRootObject, metamodelFilename);
		return metaModelRootObject;
	}

	/**
	 * Metamodel saving.
	 * The ressource and NsURI of the package are updated.
	 * The packages corresponding to external dependencies 
	 * are serialised locally together with the metamodel itself.
	 * @param metaModelRootObject Root object of the metamodel to be serialized.
	 * @param outputFilePath Name of the file to be created or updated.
	 * @throws IOException Thrown if the output file cannot be created.
	 * @return The updated root package.
	 */
	public static EPackage saveMetamodel(EPackage metaModelRootObject, String outputFilePath) throws IOException {
		return saveMetamodel(metaModelRootObject, outputFilePath, true);
	}

	/**
	 *  Metamodel saving.
	 * The ressource and NsURI of the package are updated.
	 * The packages corresponding to external dependencies 
	 * are serialised locally together with the metamodel itself.
	 * 
	 * @param metaModelRootObject Root object of the metamodel to be serialized.
	 * @param outputFilePath Name of the file to be created or updated.
	 * @param withExternalPackageDependencies If the root object has references to external packages.
	 * @return The updated root package.
	 * @throws IOException Thrown if the output file cannot be created.
	 */
	public static EPackage saveMetamodel2(EPackage metaModelRootObject, String outputFilePath, boolean withExternalPackageDependencies) throws IOException {
		return saveMetamodel(metaModelRootObject, outputFilePath, withExternalPackageDependencies);
	}

	/**
	 * Model saving.
	 * @param modelRootObject Root object to be serialized.
	 * @param outputFilePath Name of the file to be created or updated.
	 * @throws IOException Thrown if the output file cannot be created.
	 * @return The updated root object.
	 */
	public static EObject saveModel(EObject modelRootObject, String outputFilePath) throws IOException {	
		// Creating the resource set from the metadata of modelRootObject:
		ResourceSet resourceSet = createResourceSet(modelRootObject.eClass().getEPackage().getNsURI(), modelRootObject.eClass().getEPackage());
		// Creating a new resource in this resource set:
		Resource resource = resourceSet.createResource(URI.createFileURI(new File(outputFilePath).getAbsolutePath()));
		// Adding the object in the new resource and saving:
		resource.getContents().add(modelRootObject);	
		resource.save(Collections.EMPTY_MAP);
		return modelRootObject;
	}

	/**
	 * Metamodel processor: removes annotations. 
	 * @param rootPackage object of the updated metamodel (without annotations).
	 * @param relatedPackages
	 * @return
	 */
	public static EPackage removeAnnotation(EPackage rootPackage, Map<EPackage, ArrayList<EPackage>> relatedPackages){
		for(EPackage subp : rootPackage.getESubpackages()){
			removeAnnotations(subp);
		}
		return rootPackage;
	}

	/**
	 * Initialisation of a map relating UUIDs to the corresponding EObjects.
	 * @param root The root instance of the model to scan.
	 * @return The map relating UUIDs to instances of root (root included).
	 */
	public static Map<String, EObject> createUUIDMap(EObject root) {
		Map<String, EObject> map = new HashMap<String, EObject>();
		List<EObject> fifo = new ArrayList<EObject>();
		for(fifo.add(root); !fifo.isEmpty(); ) {
			EObject next = fifo.remove(0);
			String nextUUID = UtilEMF.getUUID(next);
			if (nextUUID!=null) map.put(nextUUID, next);
			fifo.addAll(next.eContents());
		}
		return map;
	}

	/**
	 * Provides the set of external packages definig feature types.
	 * @param root The root package to scan.
	 * @return The set of packages that are not defined within or equal to root, and that
	 * define classifiers used as type of features.
	 */
	public static Set<EPackage> getAllExternalPackages(EPackage root) {
		Set<EPackage> allExternal = new HashSet<EPackage>(); // result: new empty set recursively extended by the subpackages:
		for (EPackage subPackage : root.getESubpackages()) allExternal.addAll(getAllExternalPackages(subPackage));
		// We scan now the direct content of the package:
		for (EClassifier ec : root.getEClassifiers())
			if (ec instanceof EClass)
				for (EStructuralFeature er : ((EClass)ec).getEAllStructuralFeatures()) {
					EPackage refPackage = er.getEType().getEPackage(); // package to check
					boolean inside = false;
					while  (!inside && refPackage!=null) {
						if (refPackage.equals(root)) inside=true;
						refPackage = refPackage.getESuperPackage();
					}
					if (!inside) allExternal.add(er.getEType().getEPackage());
				}		
		return allExternal;
	}

	/**
	 * Creation of a set of instances contained into a root instance, including this root instance.
	 * @param root Root instance.
	 * @return A new set containing all the content of root, including root.
	 */
	public static Set<EObject> getAllInstances(EObject root) {
		Set<EObject> allContent = new HashSet<EObject>();
		allContent.add(root);
		for(TreeIterator<EObject> it = root.eAllContents(); it.hasNext();) allContent.add(it.next());
		return allContent;
	}

	/**
	 * Metamodel processor: removes annotations. 
	 * @param metaModelRootObject Root object of the metamodel to be processed.
	 * @return Root object of the updated metamodel (without annotations).
	 */
	public static EPackage removeAnnotations(EPackage metaModelRootObject) {
		List<EAnnotation> annotToRemove = new ArrayList<EAnnotation>(); // will contain all annotations
		// Scan of metamodel content:
		for (TreeIterator<EObject> it = metaModelRootObject.eAllContents(); it.hasNext(); ) {
			EObject next = it.next();
			String nextEClassName = next.eClass().getName();
			if (nextEClassName.equals("EAnnotation")) annotToRemove.add((EAnnotation)next);
		}
		// Removing references of deleted operation witin annotations:
		for (EAnnotation ea : annotToRemove) EcoreUtil.remove(ea);
		return metaModelRootObject;
	}

	/**
	 * Metamodel processor: removes annotations. 
	 * 
	 * @param rootPackage Root object of the metamodel to be processed.
	 * @param packageKeyPackageMap Map of packages and related packages.
	 * @return Root object of the updated metamodel (without annotations).
	 */
	public static EPackage removeAnnotations(EPackage rootPackage, Map<EPackage, EPackage> packageKeyPackageMap){
		for(EPackage subp : rootPackage.getESubpackages()){
			removeAnnotations(subp);
		}
		return rootPackage;
	}

	/**
	 * Metamodel processor: removes operations. 
	 * @param metaModelRootObject Root object of the metamodel to be processed.
	 * @return Root object of the updated metamodel (without operations).
	 */
	public static EPackage removeOperations(EPackage metaModelRootObject) {
		List<EOperation>  opToRemove     = new ArrayList<EOperation>();  // will contain removed operations
		List<EAnnotation> annotToProcess = new ArrayList<EAnnotation>(); // will contain all annotations
		// Scan of metamodel content:
		for (TreeIterator<EObject> it = metaModelRootObject.eAllContents(); it.hasNext(); ) {
			EObject next = it.next();
			String nextEClassName = next.eClass().getName();
			if      (nextEClassName.equals("EClass"))      opToRemove.addAll(((EClass)next).getEOperations());
			else if (nextEClassName.equals("EAnnotation")) annotToProcess.add((EAnnotation)next);
		}
		// Removing references of deleted operation witin annotations:
		for (EAnnotation ea : annotToProcess) ea.getReferences().removeAll(opToRemove);
		// Removing operations:
		for (EOperation eo : opToRemove) eo.getEContainingClass().getEOperations().remove(eo);
		return metaModelRootObject;
	}

	/**
	 * Metamodel processor: removes opposite feature from all references. 
	 * @param metaModelRootObject Root object of the metamodel to be processed.
	 * @return Root object of the updated metamodel (without opposite references).
	 */
	public static EPackage removeOppositeFeature(EPackage metaModelRootObject) {
		List<EReference> refToUpdate = new ArrayList<EReference>();  // will contain updated references
		// Scan of metamodel content:
		for (TreeIterator<EObject> it = metaModelRootObject.eAllContents(); it.hasNext(); ) {
			EObject next = it.next();
			String nextEClassName = next.eClass().getName();
			if (nextEClassName.equals("EClass")) refToUpdate.addAll(((EClass)next).getEReferences());
		}
		// Updating operations:
		for (EReference er : refToUpdate) er.setEOpposite(null);
		return metaModelRootObject;
	}

	/**
	 * Initialisation of a map relating UUIDs to the corresponding EObjects.
	 * @param root The root instance of the model to scan.
	 * @return The map relating UUIDs to instances of root (root included).
	 */
	public static Map<String, EObject> createUUIDMap(EObject root, String UUIDtimestamp) {
		Map<String, EObject> map = new HashMap<String, EObject>();
		List<EObject> fifo = new ArrayList<EObject>();
		for(fifo.add(root); !fifo.isEmpty(); ) {
			EObject next = fifo.remove(0);
			String nextUUID = UtilEMF.getUUID(next, UUIDtimestamp);			
			if (nextUUID!=null) map.put(nextUUID, next);
			fifo.addAll(next.eContents());
		}
		return map;
	}
	
	/**
	 * Get the String value of UUID if it exists.
	 * @param o Object to scan.
	 * @return The UUID of o if it exists or null.
	 */
	public static String getUUID (Object o) {
		EObject instance = ( (o==null||!(o instanceof EObject)) ? null : (EObject)o );
		EStructuralFeature esfUUID = (instance==null ? null : instance.eClass().getEStructuralFeature("UUID"));
		Object value = (esfUUID==null ? null : instance.eGet(esfUUID));
		return ( (value==null||!(value instanceof String)) ? null : (String)value );
	}

	/**
	 * Get the String value of UUID if it exists.
	 * @param o Object to scan.
	 * @return The UUID of o if it exists or null.
	 */
	public static String getUUID (Object o, String UUIDtimestamp) {
		EObject instance = ( (o==null||!(o instanceof EObject)) ? null : (EObject)o );		
		EStructuralFeature esfUUID;
		if(UUIDtimestamp != null){
			esfUUID = (instance==null ? null : instance.eClass().getEStructuralFeature(UUIDtimestamp));
		}else{
			esfUUID = (instance==null ? null : instance.eClass().getEStructuralFeature("UUID"));
		}
		Object value = (esfUUID==null ? null : instance.eGet(esfUUID));
		return ( (value==null||!(value instanceof String)) ? null : (String)value );
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, Map<String, ArrayList<Object>>> buildMapDerived() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Build the map of references of an instance.
	 * 
	 * @param modelRoot Root object.
	 * @param rootPackage Root package.
	 * @return referencesToInstanceMap Map relating a class and the list of references of the class.
	 */
	public static Map<String, ArrayList<String>> buildMapReferencesToInstance(EObject modelRoot, EPackage rootPackage){
		Map<String, ArrayList<String>> referencesToInstanceMap = new HashMap<String, ArrayList<String>>();
		for(EReference reference : modelRoot.eClass().getEAllReferences()){
			//String referenceName = reference.getName();
			//EClassifier referenceType = reference.getEType();
		}
		return referencesToInstanceMap;
	}
}