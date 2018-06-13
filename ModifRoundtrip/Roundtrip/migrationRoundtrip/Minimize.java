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
package migrationRoundtrip;

import java.util.ArrayList;

import modif.*;

public class Minimize {

	private int minimizeType;

	public void accept(Modifications modif) {

		accept(modif.getRootPackageModification());
	}

	/**
	 * Minimize
	 * 
	 * @param modif Modif specification to be simplified.
	 * @param type Type of minimize to be applied. 
	 * 1 = toUpdate.  2 = strong.
	 */
	public void accept(Modifications modif, int type) {
		minimizeType = type;
		accept(modif.getRootPackageModification());
	}

	private void accept(PackageModification modif) {
		for (PackageModification subPackage : modif.getPackageModification()) {
			accept(subPackage);
		}
		for (ClassModification subClass : modif.getClassModification()) {
			accept(subClass);
		}
		for (DataTypeModification dataType : modif.getDataTypeModification()) {
			accept(dataType);
		}					
		for (EnumModification eNum : modif.getEnumModification()) {
			accept(eNum);
		}
	}

	private void accept(ClassModification subClass) {

		if (subClass.isRemove() || subClass.isHide()) {
			subClass.setNewName("");
			//subClass.setNewName(null);

			if (subClass.isRemove() ) {
				subClass.getFeatureModification().clear();
			}

			subClass.getAddFeatures().clear();
			subClass.getAddDeriveds().clear();
			subClass.getAnnotationModification().clear();

			subClass.setRemoveEAnnotations(false);

			subClass.setChangeAbstract(false);

			if (subClass.isRemove()) {
				subClass.setHide(false);			
				subClass.setFlatten(false);
				subClass.setFlattenAll(false);
			}
			subClass.setEnumerate(null);

		} else {

			if (subClass.getOldName().equals(subClass.getNewName())) {
				//subClass.setNewName(null);
				subClass.setNewName("");
			}
			for (StructuralFeatureModification fm : subClass.getFeatureModification()) {
				if (fm instanceof AttributeModification) {
					accept((AttributeModification) fm);
				}
				if (fm instanceof ReferenceModification) {
					accept((ReferenceModification) fm);
				}
			}
		}

	}

	private ArrayList<String> accept(AttributeModification am) {
		ArrayList<String> unchangedAtt = new ArrayList<String>();
		boolean sameName = false;
		boolean sameBounds = false;

		if (am.isRemove()) {
			am.setNewName("");
			am.getAnnotationModification().clear();
			am.setRemoveEAnnotations(false);	
			am.setChangeType(false);
			am.setChangeBounds(null);

		} else {
			if (am.getOldName().equals(am.getNewName())) {
				am.setNewName(null);
				am.setNewName("");
			}
			if(am.getChangeBounds().getOldLower() == am.getChangeBounds().getNewLower() 
					&& am.getChangeBounds().getOldUpper() == am.getChangeBounds().getNewUpper()){
				if(minimizeType == 1) {

				}else {
					sameBounds = true;
					am.setChangeBounds(null);
				}
			}
			if(sameName && sameBounds) {
				unchangedAtt.add(am.getOldName());
			}
		}
		return unchangedAtt;
	}

	private void accept(ReferenceModification fm) {

		if (fm.isRemove()) {
			fm.setNewName("");
			fm.getAnnotationModification().clear();
			fm.setRemoveEAnnotations(false);	
			fm.setChangeContainement(false);
			fm.setRemoveOpposite(false);
			fm.setAddOpposite(null);
			fm.setReify(null);

		} else {
			if (fm.getOldName().equals(fm.getNewName())) {
				fm.setNewName("");
			}
			if(fm.getChangeBounds().getOldLower() == fm.getChangeBounds().getNewLower() 
					&& fm.getChangeBounds().getOldUpper() == fm.getChangeBounds().getNewUpper()){
				if(minimizeType == 1) {

				}else{
					fm.setChangeBounds(null);
				}
			}
		}
	}

	private void accept(DataTypeModification edm) {

		if (edm.isRemove()) {
			edm.setNewName("");
			edm.setOldInstanceTypeName(null);
			edm.setNewInstanceTypeName(null);
			edm.getAnnotationModification().clear();
			edm.setRemoveEAnnotations(false);
		} else {
			if (edm.getOldName().equals(edm.getNewName())) {
				edm.setNewName("");
			}
		}
	}

	private void accept(EnumModification enm) {

		if (enm.isRemove()) {
			//enm.setNewName(null);
			enm.setNewName("");
			//enm.setOldInstanceTypeName(null);
			enm.setOldInstanceTypeName("");
			//enm.setNewInstanceTypeName(null);
			enm.setNewInstanceTypeName("");
			enm.getEnumLiteralModification().clear();
			enm.getAnnotationModification().clear();
			enm.setRemoveEAnnotations(false);			
			enm.setReify(false);	
		} else {
			if (enm.getOldName().equals(enm.getNewName())) {
				//enm.setNewName(null);
				enm.setNewName("");
			}
		}
	}

}
