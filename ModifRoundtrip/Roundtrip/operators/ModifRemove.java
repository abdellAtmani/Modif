/**
 * 
 *  Operator to remove ecore elements.
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

import org.eclipse.emf.ecore.util.*;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifRemove implements ModifElementVisitor {


	/**
	 * Remove ecore elements.
	 * @param rm The root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){

		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();

		// visitor call for root package
		root.accept(this);

		// remove EReferences without referenced type
		// because of the EClasses removed by the previous remove operation
		ModifCleanReferences cleanReferences = new ModifCleanReferences();
		cleanReferences.VisitRoot(rm);
	}


	/**
	 * Remove ecore packages.
	 * @param pm Package.
	 */
	public void Visit(EpackageModif pm) {

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

		if (pm.getEcore()!=null && pm.getModif()!=null){		
			// remove if necessary EAnnotations
			if (pm.getModif().isRemoveEAnnotations()){				
				pm.getEcore().getEAnnotations().clear();	
			}
			// remove if necessary the EPackage
			if (pm.getModif().isRemove()){			
				EcoreUtil.delete(pm.getEcore());
				pm.setEcore(null);
			}
		}
	}


	/**
	 * Remove ecore classes.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){

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

		if (cm.getEcore()!=null && cm.getModif()!=null){
			// remove all EOperations
			cm.getEcore().getEOperations().clear();	
			// remove if necessary EAnnotations
			if (cm.getModif().isRemoveEAnnotations()){ cm.getEcore().getEAnnotations().clear();	}
			// remove if necessary the EClass
			if (cm.getModif().isRemove()){	
				EcoreUtil.delete(cm.getEcore());
				cm.setEcore(null);
			}

			// remove if necessary (only) the EClass
			if (cm.isMerged()){	EcoreUtil.delete(cm.getEcore()); }
		}
	}


	/**
	 * Remove ecore references.
	 * @param rm Reference.
	 */
	public void Visit(EreferenceModif rm){
		if (rm.getEcore()!=null && rm.getModif()!=null){
			// remove if necessary EAnnotations
			if (rm.getModif().isRemoveEAnnotations()){ rm.getEcore().getEAnnotations().clear();	}
			// remove if necessary EOpposite
			if (rm.getModif().isRemoveOpposite() && rm.getModif().getAddOpposite()!=null){ rm.getEcore().setEOpposite(null); }
			// remove if necessary the EReference
			if (rm.getModif().isRemove()){			
				EcoreUtil.delete(rm.getEcore());	
				rm.setEcore(null);
			}
		}
	}


	/**
	 * Remove ecore attributes.
	 * @param am Attribute.
	 */
	public void Visit(EattributeModif am){
		if (am.getEcore()!=null && am.getModif()!=null){
			// remove if necessary EAnnotations
			if (am.getModif().isRemoveEAnnotations()){	am.getEcore().getEAnnotations().clear(); }	
			// remove if necessary the EAttribute
			if (am.getModif().isRemove()){			
				EcoreUtil.delete(am.getEcore());
				am.setEcore(null);
			}		
		}
	}


	/**
	 * Remove ecore datat types.
	 * @param dtm DataType.
	 */
	public void Visit(EdataTypeModif dtm) {
		if (dtm.getEcore()!=null && dtm.getModif()!=null){
			// remove if necessary EAnnotations
			if (dtm.getModif().isRemoveEAnnotations()){	dtm.getEcore().getEAnnotations().clear(); }	
			// remove if necessary the EDataType
			if (dtm.getModif().isRemove()){			
				EcoreUtil.delete(dtm.getEcore());
				dtm.setEcore(null);
			}		
		}		
	}


	/**
	 * Remove ecore enumerations.
	 * @param enm Enumeration.
	 */
	public void Visit(EnumModif enm){		

		// for each subEnumLiteral	
		for (EnumLiteralModif subEnumLit : enm.getEnumLiteralModif()) {
			//  visitor call for each subenum
			((EnumLiteralModifImpl) subEnumLit).accept(this);			
		}

		if (enm.getEcore()!=null && enm.getModif()!=null){
			// remove if necessary EAnnotations
			if (enm.getModif().isRemoveEAnnotations()){	enm.getEcore().getEAnnotations().clear(); }	
			// remove if necessary the EENum
			if (enm.getModif().isRemove()){			
				EcoreUtil.delete(enm.getEcore());
				enm.setEcore(null);
			}		
		}
	}


	/**
	 * Remove ecore enum literals.
	 * @param elm EnumLiteral.
	 */
	public void Visit(EnumLiteralModif elm){	

		if (elm.getEcore()!=null && elm.getModif()!=null){
			// remove if necessary EAnnotations
			if (elm.getModif().isRemoveEAnnotations()){	elm.getEcore().getEAnnotations().clear(); }
			// remove if necessary the ENumLiteral
			if (elm.getModif().isRemove()){			
				EcoreUtil.delete(elm.getEcore());
				elm.setEcore(null);
			}		
		}	
	}
}
