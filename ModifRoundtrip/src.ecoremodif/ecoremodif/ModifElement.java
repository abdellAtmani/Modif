package ecoremodif;

/**
 *  interface for ecoremodif element 
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public interface ModifElement {

	/** Standard operation to be implemented by an ecoremodif element to be visited. */
	void accept(ModifElementVisitor visitor);

}
