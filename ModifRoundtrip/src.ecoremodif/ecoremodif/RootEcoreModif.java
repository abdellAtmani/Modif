package ecoremodif;

import java.util.List;

import modif.Modifications;

/**
 *  interface for RootEcoreModif 
 *  getter and setter for EpackageModif part 
 *  getter and setter of specific RootEcoreModif features
 *  
 *  This class is the root class for ecoremodif. 
 *  It contains a root EpackageModif.
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public interface RootEcoreModif {

	/** Return the root EpackageModif. */
	EpackageModif getRoot();

	/**  Set the root EpackageModif to EpackageModif value. */
	void setRoot(EpackageModif value);

	/** Return the Modifications elements. */ 
	Modifications getModifications();	

	/** Return the list of all EclassModif elements. */
	List<EclassModif> getAllClassModifications();	

	/** Set the Modifications elements. */
	void setModifications(Modifications value);

	/**  Return true if a class with the same name exists after modification. */
	boolean existClassModification(String name);

} // RootEcoreModif
