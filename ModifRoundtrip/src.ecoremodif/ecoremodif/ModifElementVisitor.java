package ecoremodif;



/**
 *  interface for ecoremodif element visitor
 *  
 *  Standard interface of a visitor class for ecoremodif elements. 
 *  It defines a Visit Method for each element, except for RootEcoreModif, with the VisitRoot method.
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public interface ModifElementVisitor {

	/** Visit EpackageModif.*/
	void Visit(EpackageModif pm);

	/** Visit EclassModif.*/
	void Visit(EclassModif cm);

	/** Visit EattributeModif.*/
	void Visit(EattributeModif am);	

	/** Visit EreferenceModif.*/
	void Visit(EreferenceModif am);	

	/** Visit EdataTypeModif.*/
	void Visit(EdataTypeModif dtm);	

	/** Visit EnumModif.*/
	void Visit(EnumModif enm);		

	/** Visit EnumLiteralModif.*/
	void Visit(EnumLiteralModif elm);	

	/** Visit RootEcoreModif.*/
	void VisitRoot(RootEcoreModif rm);

}
