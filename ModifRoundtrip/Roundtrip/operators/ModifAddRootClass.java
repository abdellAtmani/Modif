/**
 * 
 * Operator to add a Root class.
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

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifAddRootClass implements ModifElementVisitor {
	
	protected EClass rootClass;
	
	
	/**
	 * Visit the root Ecore+Modif in order to add a Root class.
	 * @param rm Root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){
		
		if (rm.getModifications().getAddRootClass()!=null) {
			// access to the root package 
			EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();
			
			// initialize to the root class 
			EcoreFactory theFactory = new EcoreFactoryImpl();
			rootClass = theFactory.createEClass();
			
			rootClass.setAbstract(false);	
			rootClass.setName(rm.getModifications().getAddRootClass().getName());		

			// if there is no existing class with the same name
			
			if ( ! rm.existClassModification(rootClass.getName()) ) {
				// add this new  class to the root package
				root.getEcore().getEClassifiers().add(rootClass);
			
				// visitor call for root package
				root.accept(this);		
			}
		}
	}
	
	
	/**
	 * Visit a package in order to add a Root class.
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
	 * Add a root class.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){
		if (cm.getEcore()!=null && !cm.getModif().isRemove() && !cm.getModif().isHide() && cm.getEcore().getESuperTypes().isEmpty()){
		
			EcoreFactory theFactory = new EcoreFactoryImpl();
			EReference rootRef = theFactory.createEReference();
		
			rootRef.setName("the"+cm.getEcore().getName()+"s");
			rootRef.setContainment(true);
			rootRef.setLowerBound(0);
			rootRef.setUpperBound(-1);
			
			rootRef.setEType(cm.getEcore());

			rootClass.getEStructuralFeatures().add(rootRef);
		}
		// for each reference	
		for (EreferenceModif ref: cm.getReferenceModif()) {
			//  visitor call for each reference
			((EreferenceModifImpl)ref).accept(this);		
		}
	}
	
	
	/**
	 * Set containment to false.
	 * @param rm Reference. 
	 */
	public void Visit(EreferenceModif rm){	
		if (rm.getEcore()!=null && !rm.getModif().isRemove() ) {
			if (rm.getEcore().isContainment()) {
				rm.getEcore().setContainment(false);
			}
		}
	}
	
	
	public void Visit(EattributeModif am){	}
	public void Visit(EdataTypeModif dtm) {	}
	public void Visit(EnumModif enm){		}
	public void Visit(EnumLiteralModif elm){	}
	
}
