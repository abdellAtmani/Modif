/**
 * 
 * Operator to add attributes.
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

import modif.*;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.*;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifAddFeature implements ModifElementVisitor {

	protected EpackageModifImpl root;


	/**
	 * Visit the root Ecore+Modif in order to add an attribute.
	 * @param rm Root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){

		// access to the root package 
		root = (EpackageModifImpl) rm.getRoot();

		// visitor call for root package
		root.accept(this);
	}


	/**
	 * Visit a package in order to add an attribute.
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
	}


	/**
	 * Add an attribute to the class.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){
		if (cm.getEcore()!=null && !cm.getModif().isRemove() && !cm.getModif().isHide() ){
			EcoreFactory theFactory = new EcoreFactoryImpl();
			for (AddFeature adf : cm.getModif().getAddFeatures()) {

				if (adf instanceof AddAttribute) {
					AddAttribute ada = (AddAttribute) adf;

					EAttribute newAttribute = theFactory.createEAttribute();
					newAttribute.setName(ada.getName());
					newAttribute.setLowerBound(ada.getLower());	
					newAttribute.setUpperBound(ada.getUpper());

					switch(ada.getType().getValue()) {
					case 0: newAttribute.setEType(EcorePackage.Literals.EINT); break;
					case 1: newAttribute.setEType(EcorePackage.Literals.ESTRING); break;
					case 2: newAttribute.setEType(EcorePackage.Literals.EBOOLEAN); break;
					case 3: newAttribute.setEType(EcorePackage.Literals.ECHAR); break;
					case 4: newAttribute.setEType(EcorePackage.Literals.EFLOAT);
					default : newAttribute.setEType(EcorePackage.Literals.EINT);
					}
					cm.getEcore().getEStructuralFeatures().add(newAttribute);
					// create the corresponding EattributeModif
					EattributeModif nAtt = new EattributeModifImpl(newAttribute,null,cm);
					nAtt.setIsAdded(true);
					cm.getAttributeModif().add(nAtt);
				} else if (adf instanceof AddReference)
				{
					AddReference adr = (AddReference) adf;

					EReference newReference = theFactory.createEReference();
					newReference.setName(adr.getName());
					newReference.setLowerBound(adr.getLower());	
					newReference.setUpperBound(adr.getUpper());

					EclassModif cmTo = null;
					for (EclassModif ecm : root.getAllClassModif()) {
						if (ecm.getModif().getNewName().equals(adr.getType())) { cmTo = ecm; }
					}
					if (cmTo !=null) {
						newReference.setEType(cmTo.getEcore());
						cm.getEcore().getEStructuralFeatures().add(newReference);
						// create the corresponding EreferenceModif
						EreferenceModif nRef = new EreferenceModifImpl(newReference,null,cm);

						nRef.setIsAdded(true);
						nRef.setTo(cmTo);
						cm.getReferenceModif().add(nRef);
					}				
				}
			}
		}	
	}

	public void Visit(EreferenceModif rm){	}
	public void Visit(EattributeModif am){	}
	public void Visit(EdataTypeModif dtm) {	}
	public void Visit(EnumModif enm){		}
	public void Visit(EnumLiteralModif elm){ }
}
