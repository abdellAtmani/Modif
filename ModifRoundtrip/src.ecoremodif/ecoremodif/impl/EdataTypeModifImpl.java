package ecoremodif.impl;

import ecoremodif.*;
import modif.*;

import org.eclipse.emf.ecore.*;

import utils.UtilsDataTypeModif;

/**
 *  implementation for EdataTypeModif 
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public class EdataTypeModifImpl implements EdataTypeModif, ModifElement {
	protected EDataType current;
	protected DataTypeModification modif;


	public EdataTypeModifImpl(EDataType edataType, DataTypeModification modifDataType, PackageModification pm) {
		current = edataType;
		modif = modifDataType;

		UtilsDataTypeModif myUtils = new UtilsDataTypeModif();
		if (modif == null) modif = myUtils.Create(edataType);

		myUtils.complete(current,modif);

	}

	/** Return the ecore part of EdataTypeModif: EDataType. */	
	public EDataType getEcore() {
		return current;
	}


	/** Set the ecore part of EdataTypeModif: EDataType value. */
	public void setEcore(EDataType newCurrent) {
		current = newCurrent;
	}


	/** Return the modif part of EdataTypeModif: DataTypeModification. */
	public DataTypeModification getModif() {
		return modif;
	}


	/** Set the modif part of EdataTypeModif: DataTypeModification value. */
	public void setModif(DataTypeModification newModif) {
		modif = newModif;
	}

	public void accept(ModifElementVisitor visitor) { 
		visitor.Visit(this);
	}

} //EdataTypeModifImpl
