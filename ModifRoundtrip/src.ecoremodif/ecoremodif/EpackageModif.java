package ecoremodif;

import java.util.List;

import modif.PackageModification;

import org.eclipse.emf.ecore.*;

/**
 *  interface for EpackageModif 
 *  getter and setter of ecore part (EPackage) and modif part (PackageModification)
 *  getter and setter of specific EpackageModif features
 *  
 *  EpackageModif is compounded of an ecore part (EPackage) and a modif part (PackageModification). 
 *  It also contains the correspondinf EpackageModif, EclassModif objects, EdataTypeModif and EnumModif.
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public interface EpackageModif  {

	/** Return the ecore part of EpackageModif: EPackage. */	
	EPackage getEcore();

	/** Set the ecore part of EpackageModif: EPackage value. */
	void setEcore(EPackage value);

	/** Return the modif part of EpackageModif: PackageModification.*/ 	
	PackageModification getModif();

	/** Set the modif part of EpackageModif: PackageModification value. */
	void setModif(PackageModification value);

	/** Return the long name of ecore Package before modification. */
	String getOldLongName();

	/** Return the long name of ecore Package after modification. */
	String getNewLongName();

	/** Return the name of ecore Package after modification (or its non null container if null). */
	String getNewName();

	// setters and getters for list of EpackageModif, EclassModif objects, EdataTypeModif and EnumModif

	/** Get a list of EpackageModif. */
	List<EpackageModif> getPackageModif();	

	/** Add an EpackageModif. */
	void add(EpackageModif value);

	/** Get a list of EclassModif. */
	List<EclassModif> getClassModif();	

	/** Return all the EclassModif (including those contained in subpackages). */
	List<EclassModif> getAllClassModif();	

	/** Add an EclassModif. */
	void add(EclassModif value);

	/** Get a list of EdataTypeModif. */
	List<EdataTypeModif> getDataTypeModif();	

	/** Add an EdataTypeModif. */
	void add(EdataTypeModif value);	

	/** Get a list of EnumModif. */
	List<EnumModif> getEnumModif();	

	/** Get the package container of an EpackageModif. */
	EpackageModif getFather();

	/** Add an EnumModif. */
	void add(EnumModif value);	

} // EpackageModif
