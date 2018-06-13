package ecoremodif.impl;

import ecoremodif.*;
import modif.*;

import org.eclipse.emf.ecore.*;

import utils.UtilsFeatureModif;

/**
 *  implementation for EattributeModif 
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public class EattributeModifImpl implements EattributeModif, ModifElement {
	protected EAttribute current;
	protected AttributeModification modif;
	protected EclassModif container;
	protected EnumModif enumModif;
	protected boolean isAdded;
	protected boolean isDerived;
	protected AddDerivedAttribute derived;	

	public EattributeModifImpl(EAttribute eattribute, AttributeModification modifAttribute, EclassModif cm) {
		current = eattribute;
		modif = modifAttribute;
		container = cm;
		enumModif = null;
		isAdded = false;
		derived = null;
		isDerived = false;

		UtilsFeatureModif myUtils = new UtilsFeatureModif();
		if (modif == null) modif = myUtils.Create(eattribute);

		myUtils.complete(current,modif);

	}


	/**  Return the ecore part of EattributeModif: EAttribute. */
	public EAttribute getEcore() {
		return current;
	}


	/** Set the ecore part of EattributeModif: EAttribute value. */
	public void setEcore(EAttribute newCurrent) {
		current = newCurrent;
	}


	/** Return the modif part of EattributeModif: AttributeModification. */
	public AttributeModification getModif() {
		return modif;
	}


	/** Set the modif part of EattributeModif: AttributeModification value. */
	public void setModif(AttributeModification newModif) {
		modif = newModif;
	}


	/** Return the container of the attribute: EclassModif. */
	public EclassModif getClassModif() {
		return container;
	}


	/** Set the EnumModif type if it exists: EnumModif */
	public void setEnumModif(EnumModif value){
		enumModif = value;
	}


	/** Set the EnumModif type if it exists: EnumModif value. */
	public EnumModif getEnumModif(){
		return enumModif;
	}


	/** Return true if is EattributeModif is added. */
	public boolean isAdded() {
		return isAdded;
	}


	/** Set the isAdded property. */
	public void setIsAdded(boolean value) {
		isAdded = value;
	}


	/** Return true if this EattributeModif is derived. */
	public boolean isDerived() {
		return isDerived;
	}

	/** Return Modif derived part */
	public AddDerivedAttribute getDerived() {
		return derived;
	}


	/** Set the isDerived property. */
	public void setIsDerived(boolean value, AddDerivedAttribute ada) {
		isDerived = value;
		derived = ada;
	}


	public void accept(ModifElementVisitor visitor) { 
		visitor.Visit(this);
	}

} //EattributeModifImpl
