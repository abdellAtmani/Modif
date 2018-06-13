/**
 * 
 *  Operator to flatten classes.
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

import modif.AttributeModification;
import modif.ReferenceModification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

import utils.UtilsFeatureModif;
import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifFlattenClass implements ModifElementVisitor {


	/**
	 * Visit the root Ecore+Modif in order to flatten classes.
	 * @param rm Root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){

		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();

		// visitor call for root package
		root.accept(this);
	}


	/**
	 * Visit a package in order to flatten classes.
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
	 * Flatten classes.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){

		if (cm.getEcore()!=null && cm.getModif()!=null){

			// for a (not remove and flatten) EClass
			if (cm.getModif().isFlatten() && ! cm.getModif().isRemove() && ! cm.getModif().isFlattenAll()){			

				// for each sub EClasses (inherits from cm)
				for (EclassModif scm : cm.getSubTypes()) {
					EclassModifImpl subClass = (EclassModifImpl) scm;

					if (subClass.getEcore()!=null && ! subClass.getModif().isRemove() ) {
						// add a copy of all not removed EAttribute
						// usage of EcoreUtil to clone the EStructuralFeature
						for (EattributeModif eam : cm.getAttributeModif()) {
							if (! eam.getModif().isRemove()	&& ! subClass.containsAttribute(eam.getEcore())) {
								EAttribute attEcore = EcoreUtil.copy(eam.getEcore());
								subClass.getEcore().getEStructuralFeatures().add(attEcore);

								UtilsFeatureModif modifUtils = new UtilsFeatureModif();
								AttributeModification attModif = modifUtils.Copy(eam.getModif());

								EattributeModif attEcoreModif = new EattributeModifImpl(attEcore,attModif, subClass);
								subClass.getAttributeModif().add(attEcoreModif);
							}						
						}
						// add a copy of all not removed EReference
						for (EreferenceModif erm : cm.getReferenceModif()) {
							if (! erm.getModif().isRemove()	&& ! subClass.containsReference(erm.getEcore())) {
								EReference refEcore = EcoreUtil.copy(erm.getEcore());
								refEcore.setEOpposite(null);
								subClass.getEcore().getEStructuralFeatures().add(refEcore);

								UtilsFeatureModif modifUtils = new UtilsFeatureModif();
								ReferenceModification refModif = modifUtils.Copy(erm.getModif());

								EreferenceModif refEcoreModif = new EreferenceModifImpl(refEcore,refModif, subClass);
								refEcoreModif.setTo(erm.getTo());
								subClass.getReferenceModif().add(refEcoreModif);	
							}
						}
						// add a copy of all EReference to the EClass
						for (EreferenceModif trm :  cm.getTo()) {
							if (! trm.getModif().isRemove() && ! trm.getFrom().getModif().isRemove()) {
								EReference refEcore = EcoreUtil.copy(trm.getEcore());
								refEcore.setEOpposite(null);	
								// modify lower bound of the ereference
								trm.getModif().getChangeBounds().setNewLower(0);
								trm.getEcore().setLowerBound(0);

								refEcore.setName(trm.getModif().getNewName()+"_"+subClass.getModif().getNewName());
								refEcore.setEType(subClass.getEcore());
								refEcore.setLowerBound(0);
								trm.getFrom().getEcore().getEStructuralFeatures().add(refEcore);

								UtilsFeatureModif modifUtils = new UtilsFeatureModif();
								ReferenceModification refModif = modifUtils.Copy(trm.getModif());
								refModif.setNewName(trm.getModif().getNewName()+"_"+subClass.getModif().getNewName());

								EreferenceModif refEcoreModif = new EreferenceModifImpl(refEcore,refModif, trm.getFrom());
								refEcoreModif.setIsAdded(true);
								refEcoreModif.setTo(subClass);
								trm.getFrom().getReferenceModif().add(refEcoreModif);		
							}
						}

						// remove the inheritance relationship between subClass and cm
						subClass.getEcore().getESuperTypes().remove(cm.getEcore());
						// add the supertypes of cm as supertype of subClass 
						subClass.getEcore().getESuperTypes().addAll(cm.getEcore().getESuperTypes());
					}
				}	
			}
		}
	}


	public void Visit(EreferenceModif rm)  {	}
	public void Visit(EattributeModif am)  {    }
	public void Visit(EdataTypeModif dtm)  {	}
	public void Visit(EnumModif enm)	   {	}
	public void Visit(EnumLiteralModif elm){    }

}
