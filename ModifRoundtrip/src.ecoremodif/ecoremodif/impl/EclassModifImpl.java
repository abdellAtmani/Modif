package ecoremodif.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ecoremodif.*;
import modif.*;

import org.eclipse.emf.ecore.*;

import utils.UtilsClassModif;
import utils.UtilsFeatureModif;

/**
 *  implementation for EclassModif 
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

public class EclassModifImpl implements EclassModif,ModifElement {

	protected EClass current;
	protected ClassModification modif;
	protected List<EattributeModif> subAttributeModif;
	protected List<EreferenceModif> subReferenceModif;
	protected EpackageModif container;
	protected boolean isAdded;
	protected boolean isMerged;
	protected boolean inheritsFromNameClass;
	protected RootEcoreModifImpl rootEcoreModif;

	// by default constructor
	public EclassModifImpl() { }

	public EclassModifImpl(EClass eclass, ClassModification modifClass, EpackageModif pm, RootEcoreModifImpl rootEcoreModifImpl) {
		current = eclass;
		modif = modifClass;
		isAdded = false;
		container = pm;
		rootEcoreModif = rootEcoreModifImpl;
		isMerged = false;
		inheritsFromNameClass = false;

		subAttributeModif = new ArrayList<EattributeModif>();
		subReferenceModif = new ArrayList<EreferenceModif>();

		UtilsClassModif myUtils = new UtilsClassModif();
		if (modif == null) modif = myUtils.Create(eclass);

		myUtils.complete(current,modif);

		// build attributeModif properties of the classModif
		UtilsFeatureModif myUtils2 = new UtilsFeatureModif();		
		for (EAttribute att : eclass.getEAttributes()) {
			AttributeModification attModif = null;
			if (modifClass != null ) { attModif = (AttributeModification) myUtils2.findStructuralFeature(att.getName(), modifClass.getFeatureModification()); } 
			EattributeModif eAttModif = new EattributeModifImpl(att,attModif, this);

			subAttributeModif.add(eAttModif);
		}

		// build referenceModif properties of the classModif
		for (EReference ref : eclass.getEReferences()) {
			ReferenceModification refModif = null;
			if (modifClass != null ) { refModif = (ReferenceModification) myUtils2.findStructuralFeature(ref.getName(), modifClass.getFeatureModification()); } 
			EreferenceModif eRefModif = new EreferenceModifImpl(ref,refModif, this);

			subReferenceModif.add(eRefModif);
		}
	}


	/** Return a list of EclassModif: objects containing EClass which inherits from ecore part. */ 	
	public List<EclassModif> getSubTypes()
	{
		List<EclassModif> subtypes = new ArrayList<EclassModif>();
		for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {
			if (ecm.getEcore() != null) {
				if (ecm.getEcore().getESuperTypes().contains(this.current)) { subtypes.add(ecm); }
			}
		}
		return subtypes;
	}


	/** Return a list of EclassModif: objects containing EClass which inherit directly. Or implicitly from ecore part. */
	public List<EclassModif> getAllSubTypes()
	{
		List<EclassModif> subtypes = new ArrayList<EclassModif>();

		// add the subtypes
		subtypes = this.getSubTypes();
		List<EclassModif> allSubtypes = this.getSubTypes();

		Iterator<EclassModif> it = 	subtypes.iterator();
		// recursively add all the subtypes 
		while(it.hasNext()) {
			EclassModif ecm = it.next();
			allSubtypes.addAll(ecm.getAllSubTypes());
		}
		return allSubtypes;
	}


	/** Return a list of EclassModif: objects containing a supertype of ecore part. */	
	public List<EclassModif> getAllSuperTypes()
	{
		List<EclassModif> supertypes = new ArrayList<EclassModif>();
		if (this.current != null) {
			for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {
				if (this.current.getESuperTypes().contains(ecm.getEcore())) {
					// do not consider hided and removed classes as super class
					if (ecm.getEcore()!=null) { supertypes.add(ecm); }
					// do not consider supertype of remove classes
					if (! ecm.getModif().isRemove()) { supertypes.addAll(ecm.getAllSuperTypes()); }
				}
			}
		}
		return supertypes;
	}


	/** Get attributes and inherited attributes. */
	public List<EattributeModif> getAllAttributes()
	{
		List<EattributeModif> attributes = new ArrayList<EattributeModif>();
		attributes.addAll(subAttributeModif);

		for (EclassModif superClass : this.getAllSuperTypes()) {
			attributes.addAll(superClass.getAttributeModif());
		}
		return attributes;
	}


	/** Get references and inherited references. */
	public List<EreferenceModif> getAllReferences()
	{
		List<EreferenceModif> references = new ArrayList<EreferenceModif>();
		references.addAll(subReferenceModif);

		for (EclassModif superClass : this.getAllSuperTypes()) {
			references.addAll(superClass.getReferenceModif());
		}
		return references;
	}	


	/** Return a list of EreferenceModif: list of references to the class. */
	public List<EreferenceModif> getTo() {
		List<EreferenceModif> refsTo = new ArrayList<EreferenceModif>();;

		for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {
			for (EreferenceModif erm : ecm.getReferenceModif()) {
				//			if (EcoreUtil.equals(rootPackageModif.getAllClassModifications().get(i).getReferenceModif().get(j).getEcore().getEReferenceType(), this.getEcore())) {
				if (erm.getTo()== this) { refsTo.add(erm); }
			}		
		}
		return refsTo;
	}


	/** Return a list of EreferenceModif: list of references to the class. Or to a superClass. */
	public List<EreferenceModif> getAllTo() {
		List<EreferenceModif> refsTo = new ArrayList<EreferenceModif>();;

		for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {
			for (EreferenceModif erm : ecm.getReferenceModif()) {
				if (this.getAllSuperTypes().contains(erm.getTo())) { refsTo.add(erm); }
			}		
		}
		return refsTo;
	}	


	/** Returns true if it exists yet an attribute with the same name. */
	public boolean containsAttribute(EAttribute att) {
		boolean isOk = false;
		for(EAttribute eam : this.getEcore().getEAttributes()) {
			if (eam.getName().equals(att.getName())) { isOk = true; }
		}
		return isOk;
	}


	/** Returns true if it exists yet a reference with the same name. */
	public boolean containsReference(EReference ref) {
		boolean isOk = false;
		for(EReference erm : this.getEcore().getEReferences()) {
			if (erm.getName().equals(ref.getName())) { isOk = true; }
		}
		return isOk;
	}


	/** Returns if it exists the reference with the same old name. */
	public EreferenceModif containsOldNameReference(String name) {
		EreferenceModif ref = null ;
		for(EreferenceModif erm : this.getAllReferences()) {
			if (erm.isAdded()) {
				if (erm.getModif().getNewName().equals(name)) { ref = erm; }				
			} else {
				if (erm.getModif().getOldName().equals(name)) { ref = erm; }				
			}
		}
		return ref;
	}


	/** Returns if it exists the reference with the same old name*/
	public EreferenceModif containsNewNameReference(String name) {
		EreferenceModif ref = null ;
		for(EreferenceModif erm :  this.getReferenceModif()) {
			if (erm.getModif().getNewName().equals(name)) { ref = erm; }
		}
		return ref;
	}


	/** Returns if it exists the attribute with the same name */
	public EattributeModif containsOldNameAttribute(String name) {
		EattributeModif att = null ;
		for(EattributeModif eam :  this.getAllAttributes()) {
			if (eam.getModif().getOldName().equals(name)) { att = eam; }
		}
		return att;
	}


	/** Return the ecore part of EclassModif: EClass. */	
	public EClass getEcore() {
		return current;
	}


	/** Set the ecore part of EclassModif: EClass value. */
	public void setEcore(EClass newCurrent) {
		current = newCurrent;
	}


	/** Return the modif part of EclassModif: ClassModification. */	
	public ClassModification getModif() {
		return modif;
	}


	/** Set the modif part of EclassModif: ClassModification value. */
	public void setModif(ClassModification newModif) {
		modif = newModif;
	}


	/** Return the modif part of EclassModif: ClassModification. */	
	public EpackageModif getParent() {
		return container;
	}


	/** Return the long name of ecore part before modification. */
	public String getOldLongName() {
		return (container.getOldLongName()+modif.getOldName());
	}


	/** Return the long name of ecore part after modification. */
	public String getNewLongName() {
		return (container.getNewLongName()+modif.getNewName());
	}


	/** Get attributes. */
	public List<EattributeModif> getAttributeModif() {
		return subAttributeModif;
	}


	/** Add an attribute. */
	public void add(EattributeModif value) {
		subAttributeModif.add(value);
	}


	/** Get a list of modif references. */
	public List<EreferenceModif> getReferenceModif() {
		return subReferenceModif;
	}


	/** Return true if this EclassModif is added. */
	public boolean isAdded() {
		return isAdded;
	}


	/** Set the isAdded property. */
	public void setIsAdded(boolean value) {
		isAdded = value;
	}


	/** Return true if this EclassModif is merged. */
	public boolean isMerged() {
		return isMerged;
	}


	/** Set the isMerged property. */
	public void setIsMerged(boolean value) {
		isMerged = value;
	}


	/** Set if EclassModif inherits from a classe whose name is NameClass. */
	public boolean inheritsFromNameClass() {
		return inheritsFromNameClass;
	}


	/** Set if EclassModif inherits from a classe whose name is NameClass. */
	public void setInheritsFromNameClass(boolean value) {
		inheritsFromNameClass = value;
	}


	/** Add a reference. */
	public void add(EreferenceModif value) {
		subReferenceModif.add(value);
	}


	public void accept(ModifElementVisitor visitor) { 
		visitor.Visit(this);
	}

} //EclassModifImpl
