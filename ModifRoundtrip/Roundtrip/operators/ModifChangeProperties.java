/**
 * 
 * Operator to change properties of ecore elements.
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

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifChangeProperties implements ModifElementVisitor {


	/**
	 * Visit the root Ecore+Modif in order to change properties of ecore elements.
	 * @param rm root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){
		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();

		// visitor call for root package
		root.accept(this);
	}


	/**
	 * Visit a package in order to change properties of ecore elements.
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
	}


	/**
	 * Visit a class in order to change properties of ecore elements.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){
		if (cm.getEcore()!=null && cm.getModif()!=null){
			if (cm.getModif().isChangeAbstract()) {
				cm.getEcore().setAbstract(! cm.getEcore().isAbstract());
			}	
		}

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
	 * Change properties of a reference.
	 * @param rm Reference.
	 */
	public void Visit(EreferenceModif rm){
		if (rm.getEcore()!=null && rm.getModif()!=null ){
			// modification (if necessary) of containment property
			if (rm.getModif().isChangeContainement()) {
				rm.getEcore().setContainment(! rm.getEcore().isContainment());
			}	
			// modifications of bounds
			rm.getEcore().setLowerBound(rm.getModif().getChangeBounds().getNewLower());	
			rm.getEcore().setUpperBound(rm.getModif().getChangeBounds().getNewUpper());

			// add (if necessary) an EOpposite reference
			// if no eopposite exists, or if eopposite exist and remove it 
			if ((rm.getEcore().getEOpposite()==null && rm.getModif().getAddOpposite()!=null) 
					|| (rm.getEcore().getEOpposite()!=null && rm.getModif().isRemoveOpposite() && rm.getModif().getAddOpposite()!=null)	) {

				// the reference is not removed and not reified
				if (! rm.getModif().isRemove() && rm.getModif().getReify()== null) {
					// if the opposite name already exists
					EreferenceModif orm = ((EclassModifImpl) rm.getTo()).containsNewNameReference(rm.getModif().getAddOpposite().getOppositeName());
					if (orm != null) {
						// set the EOpposite property
						rm.getEcore().setEOpposite(orm.getEcore());					
					} else {
						// create a new EReference and then a new EreferenceModif
						EcoreFactory aFactory = new EcoreFactoryImpl();
						EReference aRef = aFactory.createEReference();
						// set the attributes of the EReference
						if (rm.getModif().getAddOpposite().getOppositeName() == "_") { aRef.setName("opp_"+rm.getModif().getNewName()); } 
						else { aRef.setName(rm.getModif().getAddOpposite().getOppositeName());	}
						aRef.setLowerBound(rm.getModif().getAddOpposite().getOppositeLower());
						aRef.setUpperBound(rm.getModif().getAddOpposite().getOppositeUpper());
						aRef.setContainment(false);
						aRef.setEType(rm.getFrom().getEcore());
						// add the EReference to the referenced EClass
						rm.getTo().getEcore().getEStructuralFeatures().add(aRef);
						// set the EOpposite property
						rm.getEcore().setEOpposite(aRef);
						aRef.setEOpposite(rm.getEcore());
						// create the corresponding EreferenceModif
						EreferenceModif oppRef = new EreferenceModifImpl(aRef,null,rm.getTo());
						oppRef.setTo(rm.getFrom());
					}
				}
			}
		}
	}


	/**
	 * Change properties of an attribute.
	 * @param am Attribute.
	 */
	public void Visit(EattributeModif am){
		if (am.getEcore()!=null && am.getModif()!=null) {
			am.getEcore().setLowerBound(am.getModif().getChangeBounds().getNewLower());	
			am.getEcore().setUpperBound(am.getModif().getChangeBounds().getNewUpper());	

			if (am.getModif().isChangeType() && am.getModif().getNewType()!=null) {
				switch(am.getModif().getNewType().getValue()) {
				case 0: am.getEcore().setEType(EcorePackage.Literals.EINT); break;
				case 1: am.getEcore().setEType(EcorePackage.Literals.ESTRING); break;
				case 2: am.getEcore().setEType(EcorePackage.Literals.EBOOLEAN); break;
				case 3: am.getEcore().setEType(EcorePackage.Literals.ECHAR); break;
				case 4: am.getEcore().setEType(EcorePackage.Literals.EFLOAT);
				default : am.getEcore().setEType(EcorePackage.Literals.EINT);
				}
			}
		}
	}

	public void Visit(EdataTypeModif dtm){	}


	/**
	 * Change properties of an enumeration.
	 * @param enm Enumeration.
	 */
	public void Visit(EnumModif enm){	

		// for each subEnumLiteral	
		for (EnumLiteralModif subEnumLit : enm.getEnumLiteralModif()) {
			//  visitor call for each subenum
			((EnumLiteralModifImpl) subEnumLit).accept(this);			
		}
	}


	/**
	 * Change properties of an enumeration literal.
	 * @param elm EnumerationLiteral.
	 */
	public void Visit(EnumLiteralModif elm){	

		if (elm.getEcore()!=null && elm.getModif()!=null){
			elm.getEcore().setValue(elm.getModif().getNewValue());	
			elm.getEcore().setLiteral(elm.getModif().getNewLiteral());
		}		
	}

}
