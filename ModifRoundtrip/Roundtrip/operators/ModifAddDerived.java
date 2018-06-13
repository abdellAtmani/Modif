/**
 * 
 * Operator to add derived attributes and references.
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

import modif.AddDerived;
import modif.AddDerivedAttribute;
import modif.AddDerivedReference;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifAddDerived implements ModifElementVisitor {

	protected EpackageModifImpl root;


	/**
	 * Visit the root Ecore+Modif in order to add derived attributes and references.
	 * @param rm Root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){

		// access to the root package 
		root = (EpackageModifImpl) rm.getRoot();

		// visitor call for root package
		root.accept(this);
	}


	/**
	 * Visit a package in order to add derived attributes and references.
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
	 * Add derived attributes and references to a class.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){

		if (cm.getEcore()!=null && cm.getModif()!=null){
			if (cm.getModif().getAddDeriveds()!=null && !cm.getModif().isRemove()){
				// for each derived feature
				for (AddDerived add : cm.getModif().getAddDeriveds()) {
					// verify if the derived list of references is correct
					EList<String> names = add.getReferenceName();
					boolean namesAreOk = true;
					EclassModifImpl rcm = (EclassModifImpl) cm;
					EreferenceModif rrm = null;
					int lowerBound = 1;
					int upperBound = 1;
					boolean isContainment = true;
					boolean opp = false;
					for (int j = 0; j < names.size() && namesAreOk; j++) {
						rrm = rcm.containsOldNameReference(names.get(j));
						if (rrm!=null) {
							rcm = (EclassModifImpl) rrm.getTo();
							// lowerBound is the product of all EReferences' lowerBound, -1 if one is equals to -1
							if ( (lowerBound>=0) && (rrm.getModif().getChangeBounds().getOldLower()>=0) )
							{	lowerBound = lowerBound * rrm.getModif().getChangeBounds().getOldLower(); }
							else 
							{ lowerBound = -1;	}
							// upperBound is the product of all EReferences' upperBound, -1 if one is equals to -1
							if ( (upperBound >=0) && (rrm.getModif().getChangeBounds().getOldUpper()>=0) )
							{	upperBound = upperBound * rrm.getModif().getChangeBounds().getOldUpper(); }
							else 
							{ upperBound = -1;	}
							// containment is true if all EReferences' containment are true
							isContainment = isContainment && rrm.wasContainment();
							opp = false;
						}
						else {
							for (EclassModif rocm : root.getAllClassModif()) {
								EreferenceModif rorm = ((EclassModifImpl)rocm).containsOldNameReference(names.get(j));
								if (rorm!=null) {
									if (rorm.getTo()==rcm) {
										rrm = rorm;
										isContainment = false;
										upperBound = -1;
										lowerBound = 0;
										opp = true;
										rcm = (EclassModifImpl) rocm;
									}
								}
							}
							if (rrm == null) { namesAreOk = false; }
						}
					}	
					if (rrm != null && rrm.getEcore()==null) { namesAreOk = false;}

					if (namesAreOk) {
						EcoreFactory theFactory = new EcoreFactoryImpl();
						// in case of an add derived reference, add the reference to ecore
						if (add instanceof AddDerivedReference) {
							AddDerivedReference adr = (AddDerivedReference) add;
							// create a new EReference and then a new EreferenceModif
							EReference refEcore = theFactory.createEReference();
							if (opp) { refEcore.setEType(rrm.getEcore().getEContainingClass()); } 
							else { refEcore.setEType(rrm.getEcore().getEType()); }
							refEcore.setEOpposite(null);
							// set the attributes of the EReference
							refEcore.setName(adr.getNewName());					
							refEcore.setLowerBound(lowerBound);
							refEcore.setUpperBound(upperBound);
							refEcore.setContainment(isContainment);
							// add the EReference to the EClass
							cm.getEcore().getEStructuralFeatures().add(refEcore);
							// create the corresponding EreferenceModif
							EreferenceModif dRef = new EreferenceModifImpl(refEcore,null,cm);
							dRef.setTo(rcm);
							dRef.setIsDerived(true,adr);
							cm.getReferenceModif().add(dRef);
						}
						// in case of an add derived attribute, check the name of the attribute
						if ((add instanceof AddDerivedAttribute) && ! rcm.getModif().isRemove()) {
							AddDerivedAttribute ada = (AddDerivedAttribute) add;
							EattributeModif arm = rcm.containsOldNameAttribute(ada.getAttributeName());						
							if (arm != null) {
								// create a new EAttribute and then a new EreferenceModif
								EAttribute attEcore = EcoreUtil.copy(arm.getEcore());
								// set the attributes of the EReference
								attEcore.setName(ada.getNewName());					
								if ( (lowerBound>=0) && (arm.getEcore().getLowerBound()>=0) ) {	lowerBound = lowerBound * arm.getEcore().getLowerBound(); }
								else { lowerBound = -1;	}
								attEcore.setLowerBound(lowerBound);
								if ( (upperBound >=0) && (arm.getEcore().getUpperBound()>=0) ) { upperBound = upperBound * arm.getEcore().getUpperBound(); }
								else { upperBound = -1;	}							
								attEcore.setUpperBound(upperBound);
								// add the EAttribute to the EClass
								cm.getEcore().getEStructuralFeatures().add(attEcore);
								// create the corresponding EattributeModif
								EattributeModif dAtt = new EattributeModifImpl(attEcore,null,cm);
								dAtt.setIsDerived(true,ada);
								cm.getAttributeModif().add(dAtt);						
							}
						}
					}	
				}					
			}
		}
	}

	public void Visit(EreferenceModif rm){}
	public void Visit(EattributeModif am){}
	public void Visit(EdataTypeModif dtm) {}
	public void Visit(EnumModif enm) {}
	public void Visit(EnumLiteralModif elm){}
}
