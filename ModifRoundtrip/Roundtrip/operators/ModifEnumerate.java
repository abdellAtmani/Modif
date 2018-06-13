 /**
 * 
 * operator to enumerate EClass (if necessary)
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  15/01/2013
 */

package operators;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import ecoremodif.*;
import ecoremodif.impl.*;
import ecoremodif.utils.UtilsFeatureEcoreModif;

public class ModifEnumerate implements ModifElementVisitor {
	
	public RootEcoreModif root;
	
	public void VisitRoot(RootEcoreModif rm){
		// access to the root package 
		root = rm;
		
		// visitor call for root package
		((EpackageModifImpl) rm.getRoot()).accept(this);
	}
	
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
	
	public void Visit(EclassModif cm){
		
		if (cm.getEcore()!= null && ! cm.getModif().isRemove() && ! cm.getModif().isHide() && cm.getModif().getEnumerate()!=null) {
			
			// initialize to the Enum 
			EcoreFactory theFactory = new EcoreFactoryImpl();
			EEnum eenum = theFactory.createEEnum();
			
			eenum.setName(cm.getModif().getEnumerate().getEnumName());
			eenum.setSerializable(true);
			cm.getEcore().getEPackage().getEClassifiers().add(eenum);
			
			int nbSubClass = 0;
			List<EattributeModif> newEattributeModif = new ArrayList<EattributeModif>();
			List<EreferenceModif> newEreferenceModif = new ArrayList<EreferenceModif>();
			
			for (EclassModif scm : cm.getSubTypes()) {
				
				if (scm.getEcore()!= null && ! scm.getModif().isRemove() && ! scm.getModif().isHide()) {
				
					EEnumLiteral eenumLiteral = theFactory.createEEnumLiteral();
				
					eenumLiteral.setValue(nbSubClass); 
					eenumLiteral.setName(scm.getModif().getNewName());
					eenumLiteral.setLiteral(scm.getModif().getNewName());
				
					eenum.getELiterals().add(eenumLiteral);
				
					UtilsFeatureEcoreModif finder = new UtilsFeatureEcoreModif();
					for (EattributeModif easm : scm.getAttributeModif()) {
						EattributeModif eam = finder.findAttribute(easm, cm.getAttributeModif());
						if (eam == null) {
							EAttribute newAttribute = theFactory.createEAttribute();
							newAttribute.setName(easm.getModif().getNewName());
							if (nbSubClass>0) {
								newAttribute.setLowerBound(0);	
							} else {
								newAttribute.setLowerBound(easm.getModif().getChangeBounds().getNewLower());
							}
							newAttribute.setUpperBound(easm.getModif().getChangeBounds().getNewUpper());
							newAttribute.setEType(easm.getEcore().getEType());
							cm.getEcore().getEStructuralFeatures().add(newAttribute);	
							EattributeModif nAtt = new EattributeModifImpl(newAttribute,null,cm);
							nAtt.setIsAdded(true);
							cm.getAttributeModif().add(nAtt);
							newEattributeModif.add(nAtt);
						}
					}
					
					for (EreferenceModif ersm : scm.getReferenceModif()) {
						EreferenceModif erm = finder.findReference(ersm, cm.getReferenceModif());
						if (erm == null) {
							EReference newReference = theFactory.createEReference();
							newReference.setName(ersm.getModif().getNewName());
							if (nbSubClass>0) {
								newReference.setLowerBound(0);	
							} else {
								newReference.setLowerBound(ersm.getModif().getChangeBounds().getNewLower());
							}
							newReference.setUpperBound(ersm.getModif().getChangeBounds().getNewUpper());
							newReference.setEType(ersm.getEcore().getEType());
							cm.getEcore().getEStructuralFeatures().add(newReference);	
							EreferenceModif nRef = new EreferenceModifImpl(newReference,null,cm);
							nRef.setIsAdded(true);
							cm.getReferenceModif().add(nRef);
							newEreferenceModif.add(nRef);
						}
					}
					
					for (EattributeModif eam : newEattributeModif) {
						if (finder.findAttribute(eam, scm.getAttributeModif())==null) {
							eam.getEcore().setLowerBound(0);
						}
					}
					for (EreferenceModif erm : newEreferenceModif) {
						if (finder.findReference(erm, scm.getReferenceModif())==null) {
							erm.getEcore().setLowerBound(0);
						}
					}
					
					EcoreUtil.delete(scm.getEcore());
					scm.setEcore(null);
					
					nbSubClass ++;
				}
			}
			
			EAttribute newAttribute = theFactory.createEAttribute();
			newAttribute.setName(cm.getModif().getEnumerate().getAttributeName());
			newAttribute.setLowerBound(0);
			newAttribute.setUpperBound(1);
			newAttribute.setEType(eenum);
			cm.getEcore().getEStructuralFeatures().add(newAttribute);
			// create the corresponding EattributeModif
			EattributeModif nAtt = new EattributeModifImpl(newAttribute,null,cm);
			nAtt.setIsAdded(true);
			cm.getAttributeModif().add(nAtt);
		}
	}
	
	public void Visit(EreferenceModif rm)  {	}

	public void Visit(EattributeModif am)  { 	}
	
	public void Visit(EdataTypeModif dtm)  {	}
	
	public void Visit(EnumModif enm)	   {	}
	
	public void Visit(EnumLiteralModif elm){    }
}
