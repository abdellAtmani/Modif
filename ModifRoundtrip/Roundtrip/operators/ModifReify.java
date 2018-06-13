/**
 * 
 * Operator to reify EReference and EENum elements (if necessary).
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.util.*;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifReify implements ModifElementVisitor {

	public RootEcoreModif root;


	/**
	 * Reify EReference and EENum elements.
	 * @param rm Root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){
		// access to the root package 
		root = rm;

		// visitor call for root package
		((EpackageModifImpl) rm.getRoot()).accept(this);
	}


	/**
	 * Reify EReference and EENum elements.
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
		// for each subEnum	
		for (EnumModif subEnum : pm.getEnumModif()) {
			//  visitor call for each subclass
			((EnumModifImpl) subEnum).accept(this);			
		}		
	}


	/**
	 * Reify EReference and EENum elements.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){

		if (cm.getEcore()!= null) {
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
	}


	/**
	 * Reify EReference and EENum elements.
	 * @param rm Reference.
	 */
	public void Visit(EreferenceModif rm){
		if (rm.getEcore()!=null ){
			if (rm.getModif().getReify() !=null) {			

				// initialize to the reified EClass 
				EcoreFactory theFactory = new EcoreFactoryImpl();
				EClass refClass = theFactory.createEClass();

				refClass.setAbstract(false);	
				refClass.setName(rm.getModif().getReify().getNameClass());	

				rm.getFrom().getEcore().getEPackage().getEClassifiers().add(refClass);

				// if rm is not a containment reference
				// add the reified EClass in the container of the EClass containing rm
				// create the containment EReference
				if (! rm.getEcore().isContainment()) {
					EReference aRefC = theFactory.createEReference();
					// set the attributes of the EReference
					aRefC.setName("the_"+rm.getModif().getReify().getNameClass());					
					aRefC.setLowerBound(0);
					aRefC.setUpperBound(-1);
					aRefC.setContainment(true);
					aRefC.setEType(refClass);
					// add the containment to the EClass containing rm.getFrom()
					for ( EclassModif ecm :root.getAllClassModifications()) {
						for ( EreferenceModif erm : ecm.getAllReferences()) {
							if (erm.getTo()==rm.getFrom() && erm.getEcore().isContainment()	) { ecm.getEcore().getEStructuralFeatures().add(aRefC); }
						}						
					}
				}
				// create the references to/from the reified EClass 
				EReference toRef = theFactory.createEReference();
				EReference fromRef = theFactory.createEReference();
				// set the attributes of the EReferences
				toRef.setName(rm.getModif().getReify().getNameFirstReference());					
				fromRef.setName(rm.getModif().getReify().getNameSecondReference());					
				toRef.setLowerBound(rm.getModif().getChangeBounds().getNewLower());
				toRef.setUpperBound(rm.getModif().getChangeBounds().getNewUpper());
				fromRef.setLowerBound(1);
				fromRef.setUpperBound(1);
				toRef.setContainment(rm.getEcore().isContainment());
				fromRef.setContainment(rm.getEcore().isContainment());
				toRef.setEType(refClass);
				fromRef.setEType(rm.getEcore().getEType());
				// add the EReferences to the EClasses
				rm.getFrom().getEcore().getEStructuralFeatures().add(toRef);
				refClass.getEStructuralFeatures().add(fromRef);

				// remove the EReference 	
				EcoreUtil.delete(rm.getEcore());
				rm.setEcore(null);
			}
		}
	}


	/**
	 * Reify EReference and EENum elements.
	 * @param am Attribute.
	 */
	public void Visit(EattributeModif am)  {    
		if (am.getEcore()!=null && am.getModif()!=null){
			if (! am.getModif().isRemove() && am.getEnumModif()!=null) {
				if (am.getEnumModif().getModif().isReify()) {
					for (EnumLiteralModif elm : am.getEnumModif().getEnumLiteralModif()) {
						// create to the reified subclasses 
						EcoreFactory theFactory = new EcoreFactoryImpl();
						EClass enumClass = theFactory.createEClass();

						enumClass.setAbstract(am.getClassModif().getEcore().isAbstract());	
						enumClass.setName(am.getClassModif().getModif().getNewName()+"_"+am.getModif().getNewName()+"_"+elm.getModif().getNewName());	
						enumClass.getESuperTypes().add(am.getClassModif().getEcore());

						am.getClassModif().getEcore().getEPackage().getEClassifiers().add(enumClass);
					}
					am.getClassModif().getEcore().setAbstract(true);
					// remove the attribute
					EcoreUtil.delete(am.getEcore());
					am.setEcore(null);
				}
			}
		}
	}


	public void Visit(EdataTypeModif dtm)  {	}


	/**
	 * Reify EReference and EENum elements.
	 * @param enm Enumeration.
	 */
	public void Visit(EnumModif enm)	   {	
		if (enm.getEcore() != null && enm.getModif().isReify() ) {

			// remove each subEnumLiteral	
			for (EnumLiteralModif subEnumLit : enm.getEnumLiteralModif()) {
				//  visitor call for each Literal
				((EnumLiteralModifImpl) subEnumLit).accept(this);			
			}

			// remove enum
			EcoreUtil.delete(enm.getEcore());
			enm.setEcore(null);
		}
	}


	/**
	 * Reify EReference and EENum elements.
	 * @param elm EnumLiteral.
	 */
	public void Visit(EnumLiteralModif elm){    
		if (elm.getEcore() != null) {
			EcoreUtil.delete(elm.getEcore());
			elm.setEcore(null);
		}
	}
}
