package ecoremodif.utils;

import modif.AddNameClass;
import ecoremodif.*;
import ecoremodif.impl.*;

/**
 *  class to valid RootEcoreModif object 
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */
public class ValidModif {


	/**
	 * Verifies that there is not a class with the same name of the new named class.
	 * @param rm The root EcoreModif.
	 * @return valid True if the name of the new name class is not the name of an existing class; false otherwise.
	 */
	public boolean isValid(RootEcoreModif rm){
		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();

		boolean valid = true;

		if (rm.getModifications().getAddRootClass()!=null && rm.getModifications().getAddNameClass()!=null)  {
			if (rm.getModifications().getAddRootClass().getName().equals(rm.getModifications().getAddNameClass().getName())) {
				valid = false;
				System.out.println("Error : the new root class and the new Named Class cannot have the same name");
			}	
		}
		AddNameClass anc = rm.getModifications().getAddNameClass();
		if ( (anc!=null) && (rm.existClassModification(anc.getName()) ) ) {
			rm.getModifications().setAddNameClass(null);
			System.out.println(" Warning : it already exists a class with the same name as the new Named Class");
		}

		// visitor call for root package
		valid = valid && isValid(root);

		return valid;
	}


	/**
	 * Verifies if the package and all its conteined elements are valid.
	 * @param pm EpackageModif to be validated.
	 * @return valid True is the packages is well formed, False otherwise.
	 */
	public boolean isValid(EpackageModif pm) {

		boolean valid = true;

		// for each  subpackage	
		for (EpackageModif subPackage : pm.getPackageModif()) {
			//  visitor call for each subpackage
			valid = valid && isValid(subPackage);
		}
		// for each subclass	
		for (EclassModif subClass : pm.getClassModif()) {
			//  visitor call for each subclass
			valid = valid && isValid(subClass);			
		}
		// for each subDataType	
		for (EdataTypeModif subDataType : pm.getDataTypeModif()) {
			//  visitor call for each subclass
			valid = valid && isValid(subDataType);			
		}
		// for each subEnum	
		for (EnumModif subEnum : pm.getEnumModif()) {
			//  visitor call for each subclass
			valid = valid && isValid(subEnum);			
		}
		return valid;
	}


	/**
	 * Verifies if the EclassModif and all its features (EattributeModif and EreferenceModif) are well formed.
	 * @param cm EclassModif to be validated
	 * @return valid True if valid, False otherwise.
	 */
	public boolean isValid(EclassModif cm){
		// TODO complete validation
		boolean valid = true;

		// for each attribute	
		for (EattributeModif att : cm.getAttributeModif()) {
			//  visitor call for attribute
			valid = valid && isValid(att);		
		}
		// for each reference	
		for (EreferenceModif ref : cm.getReferenceModif()) {
			//  visitor call for reference
			valid = valid && isValid(ref);			
		}
		return valid;
	}


	/**
	 * Verifies if the EattributeModif is well formed.
	 * @param am EattributeModif to be validated.
	 * @return valid True.
	 */
	public  boolean isValid(EattributeModif am){
		boolean valid = true;
		return valid;
	}


	/**
	 * Verifies if the EreferenceModif is well formed.
	 * @param rm EreferenceModif to be validated.
	 * @return valid True
	 */
	public boolean isValid(EreferenceModif rm){
		// TODO complete validation
		boolean valid = true;
		return valid;
	}


	/**
	 * Verifies if the EdataTypeModif is well formed.
	 * @param dtm EdataTypeModif to validate.
	 * @return valid True
	 */
	public boolean isValid(EdataTypeModif dtm){	
		// TODO complete validation
		boolean valid = true;
		return valid;
	}


	/**
	 * Verifies if the EnumModif is well formed.
	 * @param enm EnumModif to validate.
	 * @return valid True if it is well formed, False otherwise.
	 */
	public boolean isValid(EnumModif enm){	
		// TODO complete validation
		boolean valid = true;

		// for each subEnumLiteral	
		for  (EnumLiteralModif subEnumLit : enm.getEnumLiteralModif()) {
			//  visitor call for each subEnumLiteral
			valid = valid && isValid(subEnumLit);			
		}
		return valid;				
	}


	/**
	 * Verifies the EnumLiteralModif is well formed.
	 * 
	 * @param elm EnumLiteralModif to validate.
	 * @return valid True
	 */
	public boolean isValid(EnumLiteralModif elm){	
		// TODO complete validation
		boolean valid = true;
		return valid;
	}

}

