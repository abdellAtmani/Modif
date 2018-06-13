/**
 * 
 *  Operator to remove null references.
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  22/11/2013
 */

package operators;

import org.eclipse.emf.ecore.util.*;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifCleanReferences implements ModifElementVisitor {


	/**
	 * Visit the root Ecore+Modif in order to remove null references.
	 * @param rm Root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){
		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();

		// visitor call for root package
		root.accept(this);
	}


	/**
	 * Visit the a package in order to remove null references.
	 * @param pm Package.
	 */
	public void Visit(EpackageModif pm) {

		// for each  subpackage	
		for (EpackageModif subPackage : pm.getPackageModif()) {
			//  visitor call for each subpackage
			((EpackageModifImpl) subPackage).accept(this);
		}
		// for each subclass	
		for (EclassModif subClass: pm.getClassModif()) {		
			//  visitor call for each subclass
			((EclassModifImpl)subClass).accept(this);			
		}
	}


	/**
	 * Visit a class in order to remove null references.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){
		// for each reference	
		for (EreferenceModif ref: cm.getReferenceModif()) {
			//  visitor call for each reference
			((EreferenceModifImpl)ref).accept(this);		
		}
	}


	/**
	 * Remove the reference if it is null.
	 * @param rm Root Ecore+Modif.
	 */
	public void Visit(EreferenceModif rm){
		if (rm.getEcore()!=null ){
			if (rm.getEcore().getEReferenceType()==null ) {			
				EcoreUtil.delete(rm.getEcore());
				rm.setEcore(null);
			}
		}
	}


	public void Visit(EattributeModif am)  {    }
	public void Visit(EdataTypeModif dtm)  {	}
	public void Visit(EnumModif enm)	   {	}
	public void Visit(EnumLiteralModif elm){    }
}
