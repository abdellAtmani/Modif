/**
 * class to build by-default modif model from ecore model
 *  
 * Copyright (C) 2013 IDL 
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  @date 16 déc. 2013
 */
package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.*;

import modif.*;
import modif.impl.ModifFactoryImpl;
import uiModif.ihmController;


public class NoModifFactory {

	protected ModifFactory myFactory;
	

	public NoModifFactory() {
		myFactory = new ModifFactoryImpl();
	}
	
	public Modifications generateModif(EPackage epackage, boolean withKey) {

		Modifications modifModel = myFactory.createModifications();

		modifModel.setRemoveAllEStringAttributes(false);
		modifModel.setRemoveAllOperations(false);
		modifModel.setRemoveAllOpposites(false);
		modifModel.setAddAllOpposite(false);
		modifModel.setRemoveAllAnnotations(false);
		modifModel.setAddRootClass(null);
		modifModel.setAddNameClass(null);
		

		modifModel.setRootPackageModification(generateModifPack (epackage, withKey));

		return modifModel;
	}

	public Modifications generateModif(EPackage epackage) {

		Modifications modifModel = myFactory.createModifications();

		modifModel.setRemoveAllEStringAttributes(false);
		modifModel.setRemoveAllOperations(false);
		modifModel.setRemoveAllOpposites(false);
		modifModel.setAddAllOpposite(false);
		modifModel.setRemoveAllAnnotations(false);
		modifModel.setAddRootClass(null);
		modifModel.setAddNameClass(null);

		modifModel.setRootPackageModification(generateModifPack (epackage));

		return modifModel;
	}
	
	public static List<String> listEClassNames(EPackage epackage) {
	
		//PackageModification modifModel =myFactory.createPackageModification();
		List <String> classNames = new ArrayList<String>()  ;
		List <EClass> eclass ;
		
		for (EClassifier subClassifier : epackage.getEClassifiers()) {
			if (subClassifier instanceof EClass) {
				//modifModel.getClassModification().add(generateModifClass((EClass) subClassifier));
				classNames.add(subClassifier.getName());
				
			}
		
	}
		return classNames;
	}

	private PackageModification generateModifPack(EPackage epackage) {

		PackageModification modifModel = myFactory.createPackageModification();
		String newName;
		String newPrefix;
		String newUri;
		newName = epackage.getName()+"2";
		newPrefix = epackage.getNsPrefix()+"2";
		newUri = epackage.getNsURI()+"2";		
		/*if(epackage.getNsURI().toLowerCase().contains((epackage.getName()+".ecore").toLowerCase())){
			newUri = epackage.getNsURI().toLowerCase().replace(epackage.getName()+"ecore", epackage.getName()+"2.ecore");
		}*/
		/*if(epackage.getNsURI().toLowerCase().contains(".ecore")){
			newUri = epackage.getNsURI().toLowerCase().replace(".ecore", "2.ecore");
		}*/

		modifModel.setOldName(epackage.getName());
		modifModel.setNewName(newName);
		modifModel.setRemoveEAnnotations(false);
		modifModel.setRemove(false);		

		modifModel.setOldPrefixName(epackage.getNsPrefix());
		modifModel.setNewPrefixName(newPrefix);
		modifModel.setOldURIName(epackage.getNsURI());
		modifModel.setNewURIName(newUri);
		modifModel.setHide(false);

		for (EPackage subPackage : epackage.getESubpackages()) {
			modifModel.getPackageModification().add(generateModifPack(subPackage));
		}
		for (EClassifier subClassifier : epackage.getEClassifiers()) {
			if (subClassifier instanceof EClass) {
				modifModel.getClassModification().add(generateModifClass((EClass) subClassifier));
				
			}
			if (subClassifier instanceof EEnum) {
				modifModel.getEnumModification().add(generateModifEnum((EEnum) subClassifier));
			} else if (subClassifier instanceof EDataType) {
				modifModel.getDataTypeModification().add(generateModifDataType((EDataType) subClassifier));
			}
		}
		for (EAnnotation eannot : epackage.getEAnnotations()) {
			modifModel.getAnnotationModification().add(generateModifAnnotation(eannot));
		}

		return modifModel;
	}
	
	private PackageModification generateModifPack(EPackage epackage, boolean withUUID) {
		PackageModification modifModel = myFactory.createPackageModification();
		String newName;
		String newPrefix;
		String newUri = null;

		if(!withUUID){
			newName = epackage.getName()+'2';
			newPrefix = epackage.getNsPrefix()+'2';			
			newUri = epackage.getNsURI().toLowerCase().replace(epackage.getName()+".ecore", epackage.getName()+"2.ecore");

		}else{
			newName = epackage.getName()+"2UUID";
			newPrefix = epackage.getNsPrefix()+"2UUID";
			newUri = epackage.getNsURI();	

			if(epackage.getNsURI().toLowerCase().contains((epackage.getName()+"UUID.ecore").toLowerCase())){
				newUri = epackage.getNsURI().toLowerCase().replace((epackage.getName()+"UUID.ecore").toLowerCase(), epackage.getName()+"2UUID.ecore");
			}
		}

		modifModel.setOldName(epackage.getName());
		modifModel.setNewName(newName);
		modifModel.setRemoveEAnnotations(false);
		modifModel.setRemove(false);		

		modifModel.setOldPrefixName(epackage.getNsPrefix());
		modifModel.setNewPrefixName(newPrefix);
		modifModel.setOldURIName(epackage.getNsURI());
		modifModel.setNewURIName(newUri);
		modifModel.setHide(false);
		
		for (EPackage subPackage : epackage.getESubpackages()) {
			modifModel.getPackageModification().add(generateModifPack(subPackage, withUUID));
		}
		for (EClassifier subClassifier : epackage.getEClassifiers()) {
			if (subClassifier instanceof EClass) {
				modifModel.getClassModification().add(generateModifClass((EClass) subClassifier));	
			}
			if (subClassifier instanceof EEnum) {
				modifModel.getEnumModification().add(generateModifEnum((EEnum) subClassifier));
			} else if (subClassifier instanceof EDataType) {
				modifModel.getDataTypeModification().add(generateModifDataType((EDataType) subClassifier));
			}
		}
		for (EAnnotation eannot : epackage.getEAnnotations()) {
			modifModel.getAnnotationModification().add(generateModifAnnotation(eannot));
		}

		return modifModel;
	}

	private ClassModification generateModifClass(EClass eclass) {
	
		ClassModification modifModel = myFactory.createClassModification();
	
		eclass.getEAllSuperTypes();
		modifModel.setOldName(eclass.getName());
		modifModel.setNewName(eclass.getName());
		modifModel.setRemove(false);
		modifModel.setRemoveEAnnotations(false);
		modifModel.setChangeAbstract(false);
		modifModel.setHide(false);
		modifModel.setFlatten(false);

		modifModel.setFlattenAll(false);
		modifModel.setEnumerate(null);
	
		for (EStructuralFeature esf : eclass.getEStructuralFeatures()) {
			if (esf instanceof EAttribute) {
				modifModel.getFeatureModification().add(generateModifAttribute((EAttribute) esf));
			}
			if (esf instanceof EReference) {
				modifModel.getFeatureModification().add(generateModifReference((EReference) esf));
			}
		}
		for (EAnnotation eannot : eclass.getEAnnotations()) {
			modifModel.getAnnotationModification().add(generateModifAnnotation(eannot));
		}
	
		return modifModel;
	}
	public ClassModification generateModifClass2(EClass eclass) {
		
		ClassModification modifModel = myFactory.createClassModification();
	
		eclass.getEAllSuperTypes();
		modifModel.setOldName(eclass.getName());
		modifModel.setNewName(eclass.getName());
		modifModel.setRemove(false);
		modifModel.setRemoveEAnnotations(false);
		modifModel.setChangeAbstract(false);
		modifModel.setHide(false);
		modifModel.setFlatten(false);

		modifModel.setFlattenAll(false);
		modifModel.setEnumerate(null);
	
		for (EStructuralFeature esf : eclass.getEStructuralFeatures()) {
			if (esf instanceof EAttribute) {
				modifModel.getFeatureModification().add(generateModifAttribute((EAttribute) esf));
			}
			if (esf instanceof EReference) {
				modifModel.getFeatureModification().add(generateModifReference((EReference) esf));
			}
		}
		for (EAnnotation eannot : eclass.getEAnnotations()) {
			modifModel.getAnnotationModification().add(generateModifAnnotation(eannot));
		}
	
		return modifModel;
	}

	private AttributeModification generateModifAttribute(EAttribute eatt) {
		AttributeModification modifModel = myFactory.createAttributeModification();
	
		modifModel.setOldName(eatt.getName());
		modifModel.setNewName(eatt.getName());
		modifModel.setRemove(false);
		modifModel.setRemoveEAnnotations(false);

	
		ChangeBounds cb = myFactory.createChangeBounds();
	
		cb.setOldLower(eatt.getLowerBound());
		cb.setNewLower(eatt.getLowerBound());
		cb.setOldUpper(eatt.getUpperBound());
		cb.setNewUpper(eatt.getUpperBound());
	
		modifModel.setChangeBounds(cb);
		
		modifModel.setChangeType(false);
	
		for (EAnnotation eannot : eatt.getEAnnotations()) {
			modifModel.getAnnotationModification().add(generateModifAnnotation(eannot));
		}
	
		return modifModel;
	}

	private ReferenceModification generateModifReference(EReference eref) {
		ReferenceModification modifModel = myFactory.createReferenceModification();
	
		modifModel.setOldName(eref.getName());
		modifModel.setNewName(eref.getName());
		modifModel.setRemove(false);
		modifModel.setRemoveEAnnotations(false);

		ChangeBounds cb = myFactory.createChangeBounds();
	
		cb.setOldLower(eref.getLowerBound());
		cb.setNewLower(eref.getLowerBound());
		cb.setOldUpper(eref.getUpperBound());
		cb.setNewUpper(eref.getUpperBound());
	
		modifModel.setChangeBounds(cb);
	
		modifModel.setChangeContainement(false);
		modifModel.setRemoveOpposite(false);
		modifModel.setAddOpposite(null);
		modifModel.setReify(null);
	
		for (EAnnotation eannot : eref.getEAnnotations()) {
			modifModel.getAnnotationModification().add(generateModifAnnotation(eannot));
		}
	
		return modifModel;
	}

	private DataTypeModification generateModifDataType(EDataType edt) {
		DataTypeModification modifModel = myFactory.createDataTypeModification();
	
		modifModel.setOldName(edt.getName());
		modifModel.setNewName(edt.getName());
		modifModel.setRemove(false);
		modifModel.setRemoveEAnnotations(false);
	
		modifModel.setOldInstanceTypeName(edt.getInstanceTypeName());
		modifModel.setNewInstanceTypeName(edt.getInstanceTypeName());
	
		for (EAnnotation eannot : edt.getEAnnotations()) {
			modifModel.getAnnotationModification().add(generateModifAnnotation(eannot));
		}
	
		return modifModel;
	}

	private EnumModification generateModifEnum(EEnum enm) {
		EnumModification modifModel = myFactory.createEnumModification();
	
		modifModel.setOldName(enm.getName());
		modifModel.setNewName(enm.getName());
		modifModel.setRemove(false);
		modifModel.setRemoveEAnnotations(false);
	

		modifModel.setReify(false);
	
		for (EEnumLiteral enml : enm.getELiterals()) {
			modifModel.getEnumLiteralModification().add(generateModifEnumLiteral(enml));
		}				
		for (EAnnotation eannot : enm.getEAnnotations()) {
			modifModel.getAnnotationModification().add(generateModifAnnotation(eannot));
		}
	
		return modifModel;
	}

	private EnumLiteralModification generateModifEnumLiteral(EEnumLiteral enml) {
		EnumLiteralModification modifModel = myFactory.createEnumLiteralModification();
	
		modifModel.setOldName(enml.getName());
		modifModel.setNewName(enml.getName());
		modifModel.setRemove(false);
		modifModel.setRemoveEAnnotations(false);
	
		modifModel.setOldLiteral(enml.getLiteral());
		modifModel.setNewLiteral(enml.getLiteral());
		modifModel.setOldValue(enml.getValue());
		modifModel.setNewValue(enml.getValue());
	
		for (EAnnotation eannot : enml.getEAnnotations()) {
			modifModel.getAnnotationModification().add(generateModifAnnotation(eannot));
		}
	
		return modifModel;
	}

	private AnnotationModification generateModifAnnotation(EAnnotation eann) {
		AnnotationModification modifModel = myFactory.createAnnotationModification();
	
		modifModel.setOldSource(eann.getSource());
		modifModel.setNewSource(eann.getSource());
		modifModel.setRemove(false);
		modifModel.setRemoveEAnnotations(false);
	
		for ( Entry<String, String> detent : eann.getDetails()) {
			modifModel.getDetailsEntryModification().add(generateModifDetailsEntry(detent));
		}		
		for (EAnnotation eannot : eann.getEAnnotations()) {
			modifModel.getAnnotationModification().add(generateModifAnnotation(eannot));
		}
	
		return modifModel;
	}

	private DetailsEntryModification generateModifDetailsEntry(Entry<String, String> detent) {
		DetailsEntryModification modifModel = myFactory.createDetailsEntryModification();
	
		modifModel.setOldKey(detent.getKey());
		modifModel.setNewKey(detent.getKey());
		modifModel.setOldValue(detent.getValue());
		modifModel.setNewValue(detent.getValue());
		modifModel.setRemove(false);
	
		return modifModel;
	}

}
