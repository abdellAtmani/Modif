package ecoremodif.impl;

import java.util.List;

import ecoremodif.*;

import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.util.EcoreUtil;

import modif.*;

/**
 *  implementation for RootEcoreModif 
 *  
 *  Copyright (C) 2013 JIDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public class RootEcoreModifImpl implements RootEcoreModif, ModifElement {

	protected EpackageModif rootPackageModif;
	protected Modifications modif;
	protected List<EclassModif> allEclassModif;

	public RootEcoreModifImpl( EPackage rootPackage, Modifications rootModif) {

		rootPackageModif = new EpackageModifImpl(rootPackage,rootModif.getRootPackageModification(),null, this);
		modif = rootModif;

		// build the list of all eclassModif
		allEclassModif = rootPackageModif.getAllClassModif();

		// initialize all the EreferenceModif (the "to" property )		
		for (EclassModif ecm1 : allEclassModif) {
			for (EreferenceModif erm : ecm1.getReferenceModif()) {				
				for (EclassModif ecm2 : allEclassModif) {
					if (EcoreUtil.equals(ecm2.getEcore(), erm.getEcore().getEReferenceType())) { erm.setTo(ecm2); }
				}
			}
		}

		// initialize the EnumModif property of EattributeModif (if necessary )
		for (EclassModif ecm1 : allEclassModif) {
			for (EattributeModif eam : ecm1.getAttributeModif()) {							
				for (EnumModif enm : EnumModifImpl.getAllEnumModif()) {
					if (EcoreUtil.equals(enm.getEcore(), eam.getEcore().getEType())) { eam.setEnumModif(enm); }
				}
			}
		}
	}


	/** Return the root EpackageModif. */
	public EpackageModif getRoot() {
		return rootPackageModif;
	}


	/**  Set the root EpackageModif to EpackageModif value. */
	public void setRoot(EpackageModif newRoot) {
		rootPackageModif = newRoot;
	}


	/** Return the Modifications elements. */ 
	public Modifications getModifications() {
		return modif;
	}


	/** Set the Modifications elements. */
	public void setModifications(Modifications value) {
		modif = value;
	}


	/** Return the list of all EclassModif elements. */
	public List<EclassModif> getAllClassModifications() {
		return allEclassModif;
	}	


	/**  Return true if a class with the same name exists after modification. */
	public boolean existClassModification(String name) {

		boolean exist = false;
		for (EclassModif ecm: allEclassModif) {
			if (ecm.getModif().getNewName().equals(name) && ! ecm.getModif().isRemove() && ! ecm.getModif().isHide()) { exist = true; }
		}
		return exist;
	}


	public void accept(ModifElementVisitor visitor) { 
		visitor.VisitRoot(this);
	}

} //RootImpl
