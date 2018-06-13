/**
 * 
 *  Operator to merge (same name) classes.
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

import java.util.ArrayList;
import java.util.List;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifMergeClasses implements ModifElementVisitor{

	// list of merged classes
	protected List<List<EclassModif>> theMerged = new ArrayList<List<EclassModif>>();
	protected List<Integer> selectMerged = new ArrayList<Integer>();


	/**
	 * Visit the root Ecore+Modif in order to merge classes with the same name.
	 * @param rm Root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){

		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();

		// initialize the list of merged classes (same new name)
		for (int i1=0; i1 < root.getClassModif().size()-1; i1++) {
			boolean newMerge = false;
			List<EclassModif> merged = new ArrayList<EclassModif>();
			if ( ! root.getClassModif().get(i1).getModif().isRemove() && !root.getClassModif().get(i1).getModif().isHide() ) {
				for (int i2=i1+1; i2 < root.getClassModif().size(); i2++) {
					if ( ! root.getClassModif().get(i2).getModif().isRemove() && !root.getClassModif().get(i2).getModif().isHide() ) {				
						if (root.getClassModif().get(i2).getModif().getNewName().equals(root.getClassModif().get(i1).getModif().getNewName())) {
							newMerge = true;
							merged.add(root.getClassModif().get(i2));
						}
					}
				}
			}
			if (newMerge) { 
				merged.add(root.getClassModif().get(i1));
				theMerged.add(merged);
				selectMerged.add(0);
			}
		}

		// find the resulting class for each list of merged classes
		for (int l1=0; l1 < theMerged.size(); l1++) {
			for (int e1=1; e1 < theMerged.get(l1).size(); e1++) {
				if (moreThan(theMerged.get(l1).get(e1),theMerged.get(l1).get(selectMerged.get(l1)))) {
					selectMerged.set(l1, e1);
				}
			}	
		}		
		// visitor call for root package
		root.accept(this);
	}


	/**
	 * Visit the a package in order to merge classes with the same name.
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
	 * Merge classes with the same name.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm) {	
		// find if cm is a merged classes
		for (int lc1=0; lc1 < theMerged.size(); lc1++) {
			for (int c1=0; c1 < theMerged.get(lc1).size(); c1++) {
				if (cm == theMerged.get(lc1).get(c1)) {
					// cm is a merged class	
					if ( c1 !=selectMerged.get(lc1)) {
						// cm is not the resulting class
						cm.setIsMerged(true);
					}
				}
			}			
		}
	}

	public void Visit(EreferenceModif rm) {	}

	public void Visit(EattributeModif am) {	}

	public void Visit(EdataTypeModif dtm) {	}

	public void Visit(EnumModif enm) {	}

	public void Visit(EnumLiteralModif elm) { }


	/**
	 * Evaluate if a cm1 class has more properties than a class cm2.
	 * @param cm1 Class.
	 * @param cm2 Class.
	 * @return True if cm1 had more elements than cm2. False otherwise.
	 */
	protected boolean moreThan (EclassModif cm1, EclassModif cm2) {
		// evaluate if cm1 has more properties than cm2
		boolean isMore = false;

		// evaluate if cm1 has more attributes than cm2
		for ( EattributeModif eam1 : cm1.getAllAttributes()) {
			if (! eam1.getModif().isRemove()) {
				boolean find = false;
				for (EattributeModif eam2 : cm2.getAllAttributes()) {		
					if (!eam2.getModif().isRemove()) {
						if (eam2.getModif().getNewName().equals(eam1.getModif().getNewName())) { find = true; }
					}
				}
				isMore = isMore || (!find);
			}
		}

		// evaluate if cm1 has more references than cm2
		for (EreferenceModif erm1 : cm1.getAllReferences()) {
			if (! erm1.getModif().isRemove()) {
				boolean find = false;
				for (EreferenceModif erm2 : cm2.getAllReferences()) {
					if (!erm2.getModif().isRemove()) {
						if (erm2.getModif().getNewName().equals(erm1.getModif().getNewName())) { find = true; }
					}
				}
				isMore = isMore || (!find);
			}
		}
		return isMore;
	}

}
