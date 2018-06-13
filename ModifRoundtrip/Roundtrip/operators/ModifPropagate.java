/**
 * 
 * Transform macro Modif operators to basic Modif operators.
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

import modif.AddOpposite;
import modif.ModifFactory;
import modif.impl.ModifFactoryImpl;

import org.eclipse.emf.ecore.EcorePackage;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifPropagate implements ModifElementVisitor {

	private boolean removeAllAnnotations;
	private boolean removeAllOpposites;
	private boolean removeAllEStringAttributes;
	private boolean addAllOpposites;


	/**
	 * Visit the root Ecore+Modif in order to transform macro Modif operators to basic Modif operators.
	 * @param rm The root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){

		removeAllAnnotations = rm.getModifications().isRemoveAllAnnotations();
		removeAllOpposites	= rm.getModifications().isRemoveAllOpposites();
		removeAllEStringAttributes = rm.getModifications().isRemoveAllEStringAttributes();
		addAllOpposites	= rm.getModifications().isAddAllOpposite();

		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();

		// visitor call for root package
		root.accept(this);
		// re-call of visitor : in case of multiple packages and enum has been removed 
		root.accept(this);
	}


	/**
	 * Transform macro Modif operators to basic Modif operators.
	 * @param pm Package.
	 */
	public void Visit(EpackageModif pm) {

		// for each  subpackage	
		for (EpackageModif subPackage : pm.getPackageModif()) {
			// propagate remove
			if (pm.getModif().isRemove()) { subPackage.getModif().setRemove(true); }
			//  visitor call for each subpackage
			((EpackageModifImpl) subPackage).accept(this);
		}

		// for each subDataType	
		for (EdataTypeModif subDataType : pm.getDataTypeModif()) {
			// propagate remove
			if (pm.getModif().isRemove()) { subDataType.getModif().setRemove(true); }
			//  visitor call for each subclass
			((EdataTypeModifImpl) subDataType).accept(this);
		}

		// for each subEnum	
		for (EnumModif subEnum : pm.getEnumModif()) {
			// propagate remove
			if (pm.getModif().isRemove()) { subEnum.getModif().setRemove(true); }
			//  visitor call for each subclass
			((EnumModifImpl) subEnum).accept(this);			
		}

		// for each subclass	
		for (EclassModif subClass: pm.getClassModif()) {
			// propagate remove
			if (pm.getModif().isRemove()) { subClass.getModif().setRemove(true); }			
			//  visitor call for each subclass
			((EclassModifImpl)subClass).accept(this);			
		}

		// propagate remove annotations
		if (pm.getModif()!=null && removeAllAnnotations) { pm.getModif().setRemoveEAnnotations(true); }
	}


	/**
	 * Transform macro Modif operators to basic Modif operators.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){

		// for each attribute	
		for (EattributeModif att: cm.getAttributeModif()) {
			// propagate remove
			if (cm.getModif().isRemove()) { att.getModif().setRemove(true); }
			//  visitor call for each attribute
			((EattributeModifImpl)att).accept(this);		
		}

		// for each reference	
		for (EreferenceModif ref: cm.getReferenceModif()) {
			// propagate remove
			if (cm.getModif().isRemove()) { ref.getModif().setRemove(true); }
			//  visitor call for each reference
			((EreferenceModifImpl)ref).accept(this);		
		}

		// propagate remove annotations
		if (cm.getModif()!=null && removeAllAnnotations) { cm.getModif().setRemoveEAnnotations(true); }
	}


	/**
	 * Transform macro Modif operators to basic Modif operators.
	 * @param rm Reference.
	 */
	public void Visit(EreferenceModif rm){
		// propagate remove annotations
		if (rm.getModif()!=null && removeAllAnnotations) { rm.getModif().setRemoveEAnnotations(true); }
		// propagate remove opposites
		if (rm.getModif()!=null && removeAllOpposites) { rm.getModif().setRemoveOpposite(true); }
		// propagate add opposites
		if (rm.getModif()!=null && addAllOpposites) {
			if (! rm.getModif().isRemove() && rm.getModif().getAddOpposite()==null && rm.getModif().getReify()==null) {
				ModifFactory fact = new ModifFactoryImpl();
				AddOpposite addOpp = fact.createAddOpposite();
				addOpp.setOppositeName("opp_"+rm.getModif().getNewName());
				addOpp.setOppositeLower(0);
				addOpp.setOppositeUpper(-1);
				rm.getModif().setAddOpposite(addOpp);
			}
		}		
	}


	/**
	 * Transform macro Modif operators to basic Modif operators.
	 * @param am Attribute.
	 */
	public void Visit(EattributeModif am){
		// propagate remove annotations
		if (am.getModif()!=null && removeAllAnnotations) { am.getModif().setRemoveEAnnotations(true); }
		// propagate remove all EString attributes
		if (am.getEcore()!=null && am.getModif()!=null){
			if (am.getEcore().getEType().equals(EcorePackage.Literals.ESTRING) && removeAllEStringAttributes){ am.getModif().setRemove(true); }
		}
		// propagate remove if enumModif is remove
		if (am.getEnumModif()!=null) { am.getModif().setRemove(am.getModif().isRemove()||am.getEnumModif().getModif().isRemove()); }
	}


	/**
	 * Transform macro Modif operators to basic Modif operators.
	 * @param dtm DataType.
	 */
	public void Visit(EdataTypeModif dtm) {
		// propagate remove annotations
		if (dtm.getModif()!=null && removeAllAnnotations) { dtm.getModif().setRemoveEAnnotations(true); }	
	}


	/**
	 * Transform macro Modif operators to basic Modif operators.
	 * @param enm Enumeration.
	 */
	public void Visit(EnumModif enm){		

		boolean allSubIsRemoved = true;

		// for each subEnumLiteral	
		for (EnumLiteralModif subEnumLit : enm.getEnumLiteralModif()) {
			// evaluate global remove of enm if all remove of enumliteral are set to true
			allSubIsRemoved = allSubIsRemoved && subEnumLit.getModif().isRemove();
			// propagate remove
			if (enm.getModif().isRemove()) { subEnumLit.getModif().setRemove(true); }
			//  visitor call for each subenum
			((EnumLiteralModifImpl) subEnumLit).accept(this);			
		}

		// propagate remove if all remove of enumliteral are set to true		
		enm.getModif().setRemove(enm.getModif().isRemove()||allSubIsRemoved);

		// propagate remove annotations
		if (enm.getModif()!=null && removeAllAnnotations) { enm.getModif().setRemoveEAnnotations(true); }
	}


	/**
	 * Transform macro Modif operators to basic Modif operators.
	 * @param elm EnumLiteral.
	 */
	public void Visit(EnumLiteralModif elm){	
		// propagate remove annotations
		if (elm.getModif()!=null && removeAllAnnotations) {
			elm.getModif().setRemoveEAnnotations(true);
		}
	}
}
