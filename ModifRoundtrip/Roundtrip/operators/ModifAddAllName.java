/**
 * 
 * Operator to add a NamedClass
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
import org.eclipse.emf.ecore.impl.*;

import utils.UtilsFeatureModif;
import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifAddAllName implements ModifElementVisitor {
	
	protected UtilsFeatureModif utilFeatures = new UtilsFeatureModif();
	protected String nameNameAttribute;
	protected EClass nameClass;
	
	
	/**
	 * Visit Root object in order to add a NamedClass.
	 * @param rm Root Ecore+modif.
	 */
	public void VisitRoot(RootEcoreModif rm){
		
		if (rm.getModifications().getAddNameClass()!=null) {
			// access to the root package 
			EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();
			
			// initialize to the root class 
			EcoreFactory theFactory = new EcoreFactoryImpl();
			
			// Build an abstract class namedElement with an EString Attribute name
			nameClass = theFactory.createEClass();			
			nameClass.setAbstract(true);
			nameClass.setName(rm.getModifications().getAddNameClass().getName());			
			EAttribute nameAttribute = theFactory.createEAttribute();					
			nameAttribute.setName(rm.getModifications().getAddNameClass().getNameName());	
			nameNameAttribute = nameAttribute.getName(); 
			nameAttribute.setLowerBound(1);
			nameAttribute.setUpperBound(1);
			nameAttribute.setEType(EcorePackage.Literals.ESTRING);
			nameAttribute.setDefaultValueLiteral("JP");
			nameClass.getEStructuralFeatures().add(nameAttribute);

			// add this new abstract class to the root package
			root.getEcore().getEClassifiers().add(nameClass);
			
			// visitor call for root package
			root.accept(this);
		}
	}
	
	
	/**
	 * Visit a package in order to add a NamedClass.
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
	 * Add a NamedClass to the class cm.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){
		if (cm.getEcore()!=null && !cm.getModif().isRemove() && !cm.getModif().isHide() ){
			
			// if there is no existing attribute with the same name of the attribute of the NamedClass
			boolean exist = false;
			for ( EattributeModif atm : cm.getAllAttributes()) {
				if (atm.getModif().getNewName().equals(nameNameAttribute) && ! atm.getModif().isRemove()) { exist = true; }
			}
			if (!exist) {
				cm.getEcore().getESuperTypes().add(nameClass);
				cm.setInheritsFromNameClass(true);
				}
		}	
	}
	
	public void Visit(EreferenceModif rm){	}
	public void Visit(EattributeModif am){	}
	public void Visit(EdataTypeModif dtm) {	}
	public void Visit(EnumModif enm){		}
	public void Visit(EnumLiteralModif elm){	}
}
