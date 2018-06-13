/**
 * 
 *  Operator to rename ecore elements.
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  22/11/2013
 */

package operators;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifRename implements ModifElementVisitor {


	/**
	 * Rename ecore elements.
	 * @param rm Root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){

		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();

		// visitor call for root package
		root.accept(this);
	}	


	/**
	 * Rename ecore packages.
	 * @param pm Package.
	 */
	public void Visit(EpackageModif pm) {

		// change the ecore names of the ecore EPackage
		if (pm.getEcore()!=null && pm.getModif()!=null){		
			pm.getEcore().setName(pm.getModif().getNewName());
			pm.getEcore().setNsPrefix(pm.getModif().getNewPrefixName());
			pm.getEcore().setNsURI(pm.getModif().getNewURIName());
		}

		// for each  subpackage	
		for (EpackageModif subPackage : pm.getPackageModif()) {
			//  visitor call for each subpackage
			((EpackageModifImpl) subPackage).accept(this);
		}
		// for each subclass	
		for (EclassModif subClass: pm.getClassModif()) {		
			//  visitor call for each subclass
			((EclassModifImpl)subClass).accept(this);			
		}
		// for each subDataType	
		for (EdataTypeModif subDataType : pm.getDataTypeModif()) {
			//  visitor call for each subclass
			((EdataTypeModifImpl) subDataType).accept(this);
		}
		// for each subEnum	
		for (EnumModif subEnum : pm.getEnumModif()) {
			//  visitor call for each subclass
			((EnumModifImpl) subEnum).accept(this);			
		}
	}


	/**
	 * Rename ecore classes.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){

		// change the ecore name of the ecore EClass
		if (cm.getEcore()!=null && cm.getModif()!=null){ cm.getEcore().setName(cm.getModif().getNewName());	}

		// for each attribute	
		for (EattributeModif att: cm.getAttributeModif()) {
			//  visitor call for each attribute
			((EattributeModifImpl)att).accept(this);		
		}
		// for each reference	
		for (EreferenceModif ref: cm.getReferenceModif()) {
			//  visitor call for each reference
			((EreferenceModifImpl)ref).accept(this);		
		}	
	}


	/**
	 * Rename ecore references.
	 * @param rm Reference.
	 */
	public void Visit(EreferenceModif rm){
		// change the ecore name of the ecore EAttribute
		if (rm.getEcore()!=null && rm.getModif()!=null){ rm.getEcore().setName(rm.getModif().getNewName());	}
	}


	/**
	 * Rename ecore attributes.
	 * @param am Attribute.
	 */
	public void Visit(EattributeModif am){
		// change the ecore name of the ecore EREference
		if (am.getEcore()!=null && am.getModif()!=null){
			am.getEcore().setName(am.getModif().getNewName());			
		}
	}


	/**
	 * Rename ecore data types.
	 * @param dtm DataType.
	 */
	public void Visit(EdataTypeModif dtm) {
		// change the ecore names of the ecore EDataType
		if (dtm.getEcore()!=null && dtm.getModif()!=null){
			dtm.getEcore().setName(dtm.getModif().getNewName());
			dtm.getEcore().setInstanceTypeName(dtm.getModif().getNewInstanceTypeName());
		}		
	}


	/**
	 * Rename ecore enumerations.
	 * @param enm Enumeration.
	 */
	public void Visit(EnumModif enm){	

		if (enm.getEcore()!=null && enm.getModif()!=null){ 	enm.getEcore().setName(enm.getModif().getNewName()); }	

		// for each subEnumLiteral	
		for (EnumLiteralModif subEnumLit : enm.getEnumLiteralModif()) {
			//  visitor call for each subenum
			((EnumLiteralModifImpl) subEnumLit).accept(this);			
		}
	}


	/**
	 * Rename ecore enumeration literals.
	 * @param elm EnumLieral.
	 */
	public void Visit(EnumLiteralModif elm){	

		if (elm.getEcore()!=null && elm.getModif()!=null){
			elm.getEcore().setName(elm.getModif().getNewName());
		}		
	}

}
