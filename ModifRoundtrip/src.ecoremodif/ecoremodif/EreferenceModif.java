package ecoremodif;

import modif.*;
import org.eclipse.emf.ecore.EReference;


/**
 *  interface for EreferenceModif 
 *  getter and setter of ecore part (EReference) and modif part (ReferenceModification)
 *  getter and setter of specific EreferenceModif features
 *  
 *  EreferenceModif is compounded of an ecore part (EReference) and a modif part (ReferenceModification).
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public interface EreferenceModif {

	/** Return the ecore part of EreferenceModif: EReference. */ 	
	EReference getEcore();

	/** Set the ecore part of EreferenceModif: EReference value. */
	void setEcore(EReference value);

	/** Return the modif part of EreferenceModif: ReferenceModification/ */ 	
	ReferenceModification getModif();

	/** Set the modif part of EreferenceModif: ReferenceModification value. */
	void setModif(ReferenceModification value);

	/** Return the container of the reference: EclassModif. */
	EclassModif getFrom();

	/** Set the referenced EclassModif. */
	void setTo(EclassModif cm);

	/** Return the referenced EclassModif. */
	EclassModif getTo();

	/** Return true if this EattributeModif is added. */
	boolean isAdded();

	/** Set the isAdded property. */
	void setIsAdded(boolean value);

	/** Return true if this EreferenceModif is derived. */ 
	boolean isDerived();

	/** Return Modif derived part. */ 
	public AddDerivedReference getDerived();

	/** Set the isDerived property. */
	void setIsDerived(boolean value, AddDerivedReference adr);

	/** Return true if this Ecore part is containment before refactoring. */
	boolean wasContainment();	

} // EreferenceModif
