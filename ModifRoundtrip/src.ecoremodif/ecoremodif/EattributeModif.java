package ecoremodif;

import modif.AddDerivedAttribute;
import modif.AttributeModification;
import org.eclipse.emf.ecore.EAttribute;

/**
 *  interface for EattributeModif 
 *  getter and setter of ecore part (EAttribute) and modif part (AttributeModification)
 *  getter and setter of specific EattributeModif features
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public interface EattributeModif {

	/**  Return the ecore part of EattributeModif: EAttribute. */
	EAttribute getEcore();

	/** Set the ecore part of EattributeModif: EAttribute value. */
	void setEcore(EAttribute value);

	/** Return the modif part of EattributeModif: AttributeModification. */
	AttributeModification getModif();

	/** Set the modif part of EattributeModif: AttributeModification value. */
	void setModif(AttributeModification value);

	/** Return the container of the attribute: EclassModif. */
	EclassModif getClassModif();

	/** Set the EnumModif type if it exists: EnumModif value. */
	void setEnumModif(EnumModif value);

	/** Get the EnumModif type if it exists: EnumModif. */
	EnumModif getEnumModif();

	/** Return true if is EattributeModif is added. */
	boolean isAdded();

	/** Set the isAdded property. */
	void setIsAdded(boolean value);

	/** Return true if this EattributeModif is derived. */
	boolean isDerived();

	/** Return Modif derived part. */
	public AddDerivedAttribute getDerived();

	/** Set the isDerived property. */
	void setIsDerived(boolean value, AddDerivedAttribute ada);


}  // EattributeModif