package ecoremodif;

import java.util.List;

import modif.ClassModification;

import org.eclipse.emf.ecore.EClass;

/**
 *  interface for EclassModif 
 *  getter and setter of ecore part (EClass) and modif part (ClassModification)
 *  getter and setter of specific EclassModif features
 *  
 *  EclassModif is compounded of an ecore part (EClass) and a modif part (ClassModification).
 *  It also contains the corresponding EattributeModif and EreferenceModif objects. 
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public interface EclassModif {

	/** Return the ecore part of EclassModif: EClass. */	
	EClass getEcore();

	/** Set the ecore part of EclassModif: EClass value. */
	void setEcore(EClass value);

	/** Return the modif part of EclassModif: ClassModification. */	
	ClassModification getModif();

	/** Set the modif part of EclassModif: ClassModification value. */
	void setModif(ClassModification value);

	/** Return the modif part of EclassModif: ClassModification. */	
	EpackageModif getParent();

	/** Return the long name of ecore part before modification. */
	String getOldLongName();

	/** Return the long name of ecore part after modification. */
	String getNewLongName();

	/** Return a list of EclassModif: objects containing EClass which inherits from ecore part. */ 	
	List<EclassModif> getSubTypes();

	/** Return a list of EclassModif: objects containing EClass which inherit directly. Or implicitly from ecore part. */
	List<EclassModif> getAllSubTypes();

	/** Return a list of EclassModif: objects containing a supertype of ecore part. */	
	List<EclassModif> getAllSuperTypes();

	/** Return a list of EreferenceModif: list of references to the class. */
	List<EreferenceModif> getTo();	

	/** Return a list of EreferenceModif: list of references to the class. Or to a superClass. */
	List<EreferenceModif> getAllTo();

	/** Get attributes. */
	List<EattributeModif> getAttributeModif();	

	/** Get attributes and inherited attributes. */
	List<EattributeModif> getAllAttributes();

	/** Get references and inherited references. */
	List<EreferenceModif> getAllReferences();

	/** Return true if this EclassModif is added. */
	boolean isAdded();

	/** Set the isAdded property. */
	void setIsAdded(boolean value);

	/** Return true if this EclassModif is merged. */
	boolean isMerged();

	/** Set the isMerged property. */
	void setIsMerged(boolean value);

	/** Return true if this EclassModif inherits from a class whose name is NameClass. */
	boolean inheritsFromNameClass();

	/** Set if EclassModif inherits from a classe whose name is NameClass. */
	void setInheritsFromNameClass(boolean value);

	/** Add an attribute. */
	void add(EattributeModif value);

	/** Get a list of modif references. */
	List<EreferenceModif> getReferenceModif();	

	/** Add a reference. */
	void add(EreferenceModif value);

}  // EclassModif