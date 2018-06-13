package ecoremodif;

import java.util.List;

import modif.EnumModification;

import org.eclipse.emf.ecore.EEnum;

/**
 *  interface for EnumModif 
 *  getter and setter of ecore part (EEnum) and modif part (EnumModification)
 *  
 *  EnumModif is compounded of an ecore part (EEnum) and a modif part (EnumModification).
 *  It also contains the corresponding EnumLiteralModif objects.
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public interface EnumModif {

	/** Return the ecore part of EnumModif: EEnum. */
	EEnum getEcore();

	/** Set the ecore part of EnumModif: EEnum value. */
	void setEcore(EEnum value);

	/** Return the modif part of EnumModif: EnumModification. */ 	
	EnumModification getModif();

	/** Set the modif part of EnumModif: EnumModification value. */
	void setModif(EnumModification value);

	/** Get a list of of EnumLiteralModif. */
	List<EnumLiteralModif> getEnumLiteralModif();	

	/** Add an of EnumLiteralModif.*/
	void add(EnumLiteralModif value);

}  // EnumModif