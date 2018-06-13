/**
 * class to build by-default modif model from ecore model
 *  
 * Copyright (C) 2013 IDL 
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  @date 16 dÃ©c. 2013
 */
package utils;

import java.util.Map.Entry;

import org.eclipse.emf.ecore.*;

import modif.*;
import modif.impl.ModifFactoryImpl;

public class AtomicModifFactory {

	protected ModifFactory myFactory;
	
	

	public AtomicModifFactory() {
		myFactory = new ModifFactoryImpl();
	}

	public Modifications generateModif(EPackage epackage) {

		Modifications modifModel = myFactory.createModifications();

		modifModel.setRemoveAllEStringAttributes(false);
		modifModel.setRemoveAllOperations(false);
		modifModel.setRemoveAllOpposites(false);
		modifModel.setAddAllOpposite(false);
		modifModel.setRemoveAllAnnotations(true);// changed false to true
		modifModel.setAddRootClass(null);
		modifModel.setAddNameClass(null);

		modifModel.setRootPackageModification(generateModifPack (epackage,false));

		return modifModel;
	}
	public Modifications generateModif(EPackage epackage, boolean withKey) {

		Modifications modifModel = myFactory.createModifications();

		modifModel.setRemoveAllEStringAttributes(false);
		modifModel.setRemoveAllOperations(false);
		modifModel.setRemoveAllOpposites(false);
		modifModel.setAddAllOpposite(false);
		modifModel.setRemoveAllAnnotations(true);
		modifModel.setAddRootClass(null);
		modifModel.setAddNameClass(null);
		

		modifModel.setRootPackageModification(generateModifPack (epackage, withKey));

		return modifModel;
	}

	private PackageModification generateModifPack(EPackage epackage, boolean isNotRoot) {

		PackageModification modifModel = myFactory.createPackageModification();
		String newName;
		String newPrefix;
		String newUri;
		newName = epackage.getName()+"2";
		newPrefix = epackage.getNsPrefix()+"2";
		newUri = epackage.getNsURI()+"2";		

		modifModel.setOldName(epackage.getName());
		modifModel.setNewName(newName);
		modifModel.setRemoveEAnnotations(false);
		modifModel.setRemove(false);	
		modifModel.setOldPrefixName(epackage.getNsPrefix());
		modifModel.setNewPrefixName(newPrefix);
		modifModel.setOldURIName(epackage.getNsURI());
		modifModel.setNewURIName(newUri);
		modifModel.setHide(isNotRoot); // j'ai changé l'etat de setHide 

		for (EPackage subPackage : epackage.getESubpackages()) {
			modifModel.getPackageModification().add(generateModifPack(subPackage,true));
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

		modifModel.setOldName(eclass.getName());
		modifModel.setNewName(eclass.getName());
		modifModel.setRemove(false);
		modifModel.setRemoveEAnnotations(false);
		modifModel.setChangeAbstract(false);
		//**** changer l'etat de hide et flatten si eclass isAbstract
		if (eclass.isAbstract())
		{
		modifModel.setHide(true);
		modifModel.setFlatten(true);
		}
		//********
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
		//******** change remove att et ref si attribut est derived
		if(eatt.isDerived())
		{
			modifModel.setRemove(true);
			modifModel.setRemoveEAnnotations(true);
		}
		//********
		//noModifModel.setRemove(false);
		//noModifModel.setRemoveEAnnotations(false);		

		ChangeBounds cb = myFactory.createChangeBounds();

		cb.setOldLower(eatt.getLowerBound());
		cb.setNewLower(eatt.getLowerBound());
		cb.setOldUpper(eatt.getUpperBound());
		cb.setNewUpper(eatt.getUpperBound());

		modifModel.setChangeBounds(cb);
		//		noModifModel.setChangeBounds(null);

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
		//****** j'ai changé l'etat vers true 
		if(eref.isDerived()) {
			modifModel.setRemove(true);
			modifModel.setRemoveEAnnotations(true);
		}
		//*******
		ChangeBounds cb = myFactory.createChangeBounds();

		cb.setOldLower(eref.getLowerBound());
		cb.setNewLower(eref.getLowerBound());
		cb.setOldUpper(eref.getUpperBound());
		cb.setNewUpper(eref.getUpperBound());

		modifModel.setChangeBounds(cb);
		//		noModifModel.setChangeBounds(null);

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

		// noModifModel.setOldInstanceTypeName(enm.getInstanceTypeName());
		// noModifModel.setNewInstanceTypeName(enm.getInstanceTypeName());
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
