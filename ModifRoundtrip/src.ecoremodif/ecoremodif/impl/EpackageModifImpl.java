package ecoremodif.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ecoremodif.*;

import org.eclipse.emf.ecore.*;

import utils.UtilsClassModif;
import utils.UtilsDataTypeModif;
import utils.UtilsEnumModif;
import utils.UtilsPackageModif;
import modif.*;

/**
 *  implementation for EpackageModif 
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public class EpackageModifImpl implements EpackageModif, ModifElement {

	protected EPackage current;
	protected PackageModification modif;
	protected EpackageModif container;
	protected RootEcoreModifImpl rootEcoreModif;
	protected List<EpackageModif> subPackageModif;
	protected List<EclassModif> subClassModif;
	protected List<EdataTypeModif> subDataTypeModif;
	protected List<EnumModif> subEnumModif;

	public EpackageModifImpl(EPackage epackage, PackageModification modifPackage, EpackageModif pm, RootEcoreModifImpl rootEcoreModifImpl) {

		current = epackage;
		modif = modifPackage;
		container = pm;
		rootEcoreModif = rootEcoreModifImpl;

		subPackageModif = new ArrayList<EpackageModif>();
		subClassModif = new ArrayList<EclassModif>();
		subDataTypeModif = new ArrayList<EdataTypeModif>();
		subEnumModif = new ArrayList<EnumModif>();

		UtilsPackageModif myUtils = new UtilsPackageModif();
		if (modif == null) modif = myUtils.Create(epackage);

		myUtils.complete(current,modif);

		Iterator<EPackage> itr = epackage.getESubpackages().iterator();
		while (itr.hasNext()) {
			EPackage elem1 = itr.next();
			PackageModification elem2 = null;

			if (modifPackage != null ) { elem2 = myUtils.findPackage(elem1.getName(), modifPackage.getPackageModification()); } 
			EpackageModif pack = new EpackageModifImpl(elem1,elem2,this, rootEcoreModifImpl);

			subPackageModif.add(pack);
		}

		UtilsClassModif myUtils2 = new UtilsClassModif();	
		UtilsDataTypeModif myUtils3 = new UtilsDataTypeModif();	
		UtilsEnumModif myUtils4 = new UtilsEnumModif();

		Iterator<EClassifier> itr2 = epackage.getEClassifiers().iterator();

		while (itr2.hasNext()) {
			EClassifier classifier = itr2.next(); 
			if (EClass.class.isInstance(classifier)) {
				ClassModification classModif = null;
				if (modifPackage != null ) { classModif = myUtils2.findClass(classifier.getName(),modifPackage.getClassModification());	} 
				EclassModif class_ = new EclassModifImpl((EClass) classifier,classModif, this, rootEcoreModifImpl);
				subClassModif.add(class_);
			}
			if (EDataType.class.isInstance(classifier)) {
				DataTypeModification dataTypeModif = null;
				if (modifPackage != null ) { dataTypeModif = myUtils3.findDataType(classifier.getName(),modifPackage.getDataTypeModification()); } 
				EdataTypeModif edt = new EdataTypeModifImpl((EDataType) classifier, dataTypeModif, modif);
				subDataTypeModif.add(edt);				
			}
			if (EEnum.class.isInstance(classifier)) {
				EnumModification enumModif = null;
				if (modifPackage != null ) { enumModif = (EnumModification) myUtils4.findEnum(classifier.getName(), modifPackage.getEnumModification()); } 
				EnumModif eNumModif = new EnumModifImpl((EEnum) classifier, enumModif, modif);		
				subEnumModif.add(eNumModif);
			}
		}
	}


	/** Return the ecore part of EpackageModif: EPackage. */	
	public EPackage getEcore() {
		return current;
	}


	/** Set the ecore part of EpackageModif: EPackage value. */
	public void setEcore(EPackage newCurrent) {
		current = newCurrent;
	}


	/** Return the modif part of EpackageModif: PackageModification.*/ 	
	public PackageModification getModif() {
		return modif;
	}


	/** Set the modif part of EpackageModif: PackageModification value. */
	public void setModif(PackageModification newModif) {
		modif = newModif;
	}


	/** Get a list of EpackageModif. */
	public List<EpackageModif> getPackageModif() {
		return subPackageModif;
	}


	/** Return the long name of ecore Package before modification. */
	public String getOldLongName() {
		String oldLongName = modif.getOldName()+ ".";

		EpackageModif father = container;
		while (father != null) {
			oldLongName = father.getModif().getOldName() + "." + oldLongName;
			father = container.getFather();
		}	
		return oldLongName;
	}


	/** Return the long name of ecore Package after modification. */
	public String getNewLongName() {
		String newLongName = "";

		if (current!=null ) { newLongName = modif.getNewName()+ ".";}
		EpackageModif father = container;
		while (father != null) {
			if (father.getEcore()!=null) { newLongName = father.getModif().getNewName() + "." + newLongName; }
			father = container.getFather();
		}
		return newLongName;
	}


	/** Return the name of ecore Package after modification (or its non null container if null). */
	public String getNewName() {

		EpackageModif nonNullPackage= this;

		while (nonNullPackage.getEcore() == null) {
			nonNullPackage = nonNullPackage.getFather();
		}
		return nonNullPackage.getEcore().getName();

	}


	/** Add an EpackageModif. */
	public void add(EpackageModif value) {
		subPackageModif.add(value);
	}


	/** Get a list of EclassModif. */
	public List<EclassModif> getClassModif() {
		return subClassModif;
	}


	/** Return all the EclassModif (including those contained in subpackages). */
	public List<EclassModif> getAllClassModif() {

		List<EclassModif> allClassModif = new ArrayList<EclassModif>();
		allClassModif.addAll(subClassModif);

		// for each  subpackage	
		Iterator<EpackageModif> itr = subPackageModif.iterator();
		while (itr.hasNext()) {
			EpackageModifImpl subPackage = (EpackageModifImpl) itr.next();
			//  visitor call for each subpackage
			allClassModif.addAll(subPackage.getAllClassModif());
		}		
		return allClassModif;
	}


	/** Add an EclassModif. */
	public void add(EclassModif value) {
		subClassModif.add(value);
	}


	/** Get a list of EdataTypeModif. */
	public List<EdataTypeModif> getDataTypeModif() {
		return subDataTypeModif;
	}


	/** Add an EdataTypeModif. */
	public void add(EdataTypeModif value) {
		subDataTypeModif.add(value);
	}


	/** Get a list of EnumModif. */
	public List<EnumModif> getEnumModif() {
		return subEnumModif;
	}


	/** Add an EnumModif. */
	public void add(EnumModif value) {
		subEnumModif.add(value);
	}


	/** Get the package container of an EpackageModif. */
	public EpackageModif getFather() {
		return container;
	}

	public void accept(ModifElementVisitor visitor) { 
		visitor.Visit(this);
	}

} //EpackageModifImpl
