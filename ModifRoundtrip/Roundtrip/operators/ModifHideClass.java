/**
 * 
 *  Operator to hide classes.
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

import java.util.*;

import modif.*;
import modif.impl.*;
import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifHideClass implements ModifElementVisitor {

	protected List<EreferenceModif> from = new ArrayList<EreferenceModif>();


	/**
	 * Visit the root Ecore+Modif in order to hide classes.
	 * @param rm Root Ecore+Modif.
	 */
	public void VisitRoot(RootEcoreModif rm){

		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();

		// visitor call for root package
		root.accept(this);

		// remove the hide EClasses
		ModifCleanHidedClasses cleanClasses = new ModifCleanHidedClasses();
		cleanClasses.VisitRoot(rm);	
		// remove EReferences without referenced type (the EClass removed by the previous operation)
		ModifCleanReferences cleanReferences = new ModifCleanReferences();
		cleanReferences.VisitRoot(rm);
	}


	/**
	 * Visit a package in order to hide classes.
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
	 * Hide the class.
	 * @param cm Class.
	 */
	public void Visit(EclassModif cm){

		if (cm.getEcore()!=null && cm.getModif()!=null){
			// by-path inheritance relationship, masking hided classes
			// if hided class
			if (! cm.getModif().isRemove() && cm.getModif().isHide()){	
				// for each not hided subclass
				for (EclassModif subClass : this.getNotHideSubTypes(cm)) {
					if (subClass.getEcore()!=null) {
						// add all the supertypes of class to the subclass
						subClass.getEcore().getESuperTypes().addAll(cm.getEcore().getESuperTypes());
						// remove the class from the supertypes of subclass
						subClass.getEcore().getESuperTypes().remove(cm.getEcore());
					}
				}
			}

			// build implicit references from cm	
			List<List<EreferenceModif>> theImplicitPathes = new ArrayList<List<EreferenceModif>>();
			List<EreferenceModif> aPath = new ArrayList<EreferenceModif>();
			this.buildImplicitEReferences(theImplicitPathes, aPath, cm);

			// create a derived reference for each implicit reference path
			for (List<EreferenceModif> lrm : theImplicitPathes) {
				ModifFactory myFactory = new ModifFactoryImpl();
				AddDerivedReference adr = myFactory.createAddDerivedReference();
				String theName = new String("");
				List<String> theNames = new ArrayList<String>();
				for (EreferenceModif erm : lrm) {
					// the name is a concatenation of all EReferences' names
					theName+=erm.getModif().getNewName()+"_";	
					theNames.add(erm.getModif().getOldName());
				}			
				adr.setNewName(theName);
				adr.getReferenceName().addAll(theNames);
				cm.getModif().getAddDeriveds().add(adr);		
			}
		}
	}

	/**
	 * Return list of references, masking hided and classes and removed references.
	 * @param set List of References.
	 * @param lrm List of removed references.
	 * @param cm Class.
	 */
	protected void buildImplicitEReferences(List<List<EreferenceModif>> set, List<EreferenceModif> lrm, EclassModif cm) {

		// build transitive closure of references (viewed as edges), using a recursive algorithm
		// set : set of references' pathes
		// lrm : current path (empty at the beginning)
		// cm the considered class (node in the graph)

		// for each reference ref of cm
		for (EreferenceModif ref : cm.getReferenceModif()) {
			// classModif : class referenced by ref (node)
			EclassModif classModif = ref.getTo();

			if (classModif!=null && ! ref.getModif().isRemove()) {
				// the transitive closure concerns only references to hided classes
				if (classModif.getModif().isHide() && ! classModif.getModif().isRemove()) {
					// a reference is considered once 
					if (! lrm.contains(ref)) {
						// when ref is linked to an hided class, a new path is added, and the algorithm continue
						List<EreferenceModif> newReferencePath = new ArrayList<EreferenceModif>();
						newReferencePath.addAll(lrm);
						newReferencePath.add(ref);		
						buildImplicitEReferences(set,newReferencePath,classModif);
					}
				} else {				
					// when ref is linked to a not hided and not removed class and the current path is not empty, a new path is added
					// and the algorithm is finished
					if (! lrm.isEmpty() && ! classModif.getModif().isRemove()) {				
						List<EreferenceModif> newReferencePath = new ArrayList<EreferenceModif>();
						newReferencePath.addAll(lrm);
						newReferencePath.add(ref);		
						set.add(newReferencePath);
					}
				}
			}
		}
	}	


	/**
	 * Return not Hide Classes that inherits from cm.
	 * @param cm Class
	 * @return notHideSubtypes List of non hidden classes that inherit from cm.
	 */
	protected List<EclassModif> getNotHideSubTypes(EclassModif cm) {
		List<EclassModif> notHideSubtypes = new ArrayList<EclassModif>();

		for (EclassModif subType : cm.getSubTypes()) {
			if (subType.getModif().isHide()) { notHideSubtypes.addAll(this.getNotHideSubTypes(subType)); }
			else { notHideSubtypes.add(subType); }
		}
		return notHideSubtypes;
	}


	public void Visit(EreferenceModif rm)  {	}
	public void Visit(EattributeModif am)  {    }
	public void Visit(EdataTypeModif dtm)  {	}
	public void Visit(EnumModif enm)	   {	}
	public void Visit(EnumLiteralModif elm){    }

}
