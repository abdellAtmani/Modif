package ecoremodif.impl;

import ecoremodif.*;
import modif.*;

import org.eclipse.emf.ecore.*;

import utils.UtilsFeatureModif;


/**
 *  implementation for EreferenceModif 
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public class EreferenceModifImpl implements EreferenceModif, ModifElement {

	protected EclassModif from;
	protected EclassModif to;
	protected EReference current;
	protected ReferenceModification modif;
	protected boolean isAdded;
	protected boolean isDerived;
	protected boolean wasContainment;
	protected AddDerivedReference derived;

	public EreferenceModifImpl(EReference ereference, ReferenceModification modifReference, EclassModif cm) {
		current = ereference;
		modif = modifReference;
		from = cm;
		isDerived = false;
		isAdded = false;
		derived = null;
		wasContainment = current.isContainment();

		UtilsFeatureModif myUtils = new UtilsFeatureModif();
		if (modif == null) modif = myUtils.Create(ereference);

		myUtils.complete(current,modif);

	}


	/** Return the ecore part of EreferenceModif: EReference. */ 	
	public EReference getEcore() {
		return current;
	}


	/** Set the ecore part of EreferenceModif: EReference value. */
	public void setEcore(EReference newCurrent) {
		current = newCurrent;
	}


	/** Return the modif part of EreferenceModif: ReferenceModification/ */ 	
	public ReferenceModification getModif() {
		return modif;
	}


	/** Set the modif part of EreferenceModif: ReferenceModification value. */
	public void setModif(ReferenceModification newModif) {
		modif = newModif;
	}


	/** Return the container of the reference: EclassModif. */
	public EclassModif getFrom() {
		return from;
	}


	/** Set the referenced EclassModif. */
	public void setTo(EclassModif cm) {
		to = cm;
	}


	/** Return the referenced EclassModif. */
	public EclassModif getTo() {
		return to;
	}


	/** Return true if this EattributeModif is added. */
	public boolean isAdded() {
		return isAdded;
	}


	/** Set the isAdded property. */
	public void setIsAdded(boolean value) {
		isAdded = value;
	}


	/** Return true if this EreferenceModif is derived. */ 
	public boolean isDerived() {
		return isDerived;
	}


	/** Return Modif derived part. */ 
	public AddDerivedReference getDerived() {
		return derived;
	}


	/** Set the isDerived property. */
	public void setIsDerived(boolean value, AddDerivedReference adr) {
		isDerived = value;
		derived = adr;
	}


	/** Return true if this Ecore part is containment before refactoring. */
	public boolean wasContainment() {
		return wasContainment;
	}


	public void accept(ModifElementVisitor visitor) { 
		visitor.Visit(this);
	}

} //EclassModifImpl
