/**
 * 
 *  Operator to merge (same name) references.
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Paola Vallejo
 *  22/11/2013
 */

package operators;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifMergeReferences implements ModifElementVisitor{


	/**
	 * Visit the root Ecore+Modif in order to merge references with the same name.
	 * @param rm Root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){
		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();

		// visitor call for root package
		root.accept(this);
	}


	/**
	 * Visit a package if in order to merge references with the same name.
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
	 * Merge references with the same name.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm) {	

		List<EreferenceModif> refs;
		refs = cm.getReferenceModif();
		for(int i = 1; i<refs.size(); i++){
			if(refs.get(i)!=refs.get(i-1) && refs.get(i).getEcore() != null && refs.get(i-1).getEcore() != null){
				if(refs.get(i).getEcore().getName().equals(refs.get(i-1).getEcore().getName())){
					if(refs.get(i).getEcore().getEReferenceType() == refs.get(i-1).getEcore().getEReferenceType() && 
							refs.get(i).getEcore().getLowerBound()==refs.get(i-1).getEcore().getLowerBound() &&
							refs.get(i).getEcore().getUpperBound()==refs.get(i-1).getEcore().getUpperBound()){
						EcoreUtil.delete(refs.get(i-1).getEcore());
					}else{ System.out.println("*** ERROR : There may not be many features named "+refs.get(i).getEcore().getName()+" ***"); }
				}
			}
		}
	}


	public void Visit(EreferenceModif rm) {}
	public void Visit(EattributeModif am) {}
	public void Visit(EdataTypeModif dtm) {}
	public void Visit(EnumModif enm) {}
	public void Visit(EnumLiteralModif elm) {}
}
