/**
 * 
 * Class for generation of migration code
 * a migration code is associated to each concrete input EClass
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  22/11/2013
 */

package codeGeneration;

import java.util.*;

import modif.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EcorePackage;

import ecoremodif.*;
import ecoremodif.impl.EclassModifImpl;

public class MigrationCore {
	/** by-default name of generated parameter of functions in generated code */
	protected String paramName = "val";


	/** constructor */
	protected MigrationCore() { }


	class pRCM {
		public EclassModifImpl rcm;
		public pRCM(EclassModifImpl v) {
			rcm = v;
		}
	}


	/**
	 * Code generation function.
	 * 
	 * @param ecm Class for migration.
	 * @return content List of code lines to generate.
	 */
	protected List<String> generateMigrationCode(EclassModif ecm) {
		List<String> content = new ArrayList<String>();		
		// for a migrated EClass
		if (ecm.getEcore()!=null)  {
			// for a concrete EClass
			if (! ecm.getEcore().isAbstract() && ! ecm.getModif().isChangeAbstract()) {
				// create objects
				String newPackName = ecm.getParent().getNewName();
				String newLongPackName = ecm.getParent().getNewLongName();
				newPackName = Character.toUpperCase(newPackName.charAt(0))+newPackName.substring(1);
				content.add("		"+newLongPackName+newPackName+"Factory myFactory = new "+newLongPackName+"impl."+newPackName+"FactoryImpl();");
				content.add("		"+newLongPackName+ecm.getModif().getNewName()+" result = myFactory.create"+ecm.getModif().getNewName()+"();");
				// add attributes
				content.add("		// add attributes");
				int number = 0;
				for (EattributeModif att : ecm.getAllAttributes()) {
					// for migrated EAttribute, not new and not derived
					if (att.getEcore()!=null && !att.getEcore().isDerived() && !att.isAdded() && !att.isDerived() ) { generateAttributes(content, att); }
					number++;
				}
				content.add("		// add new attributes");
				content.add("		// add derived attributes");
				generateDerivedAttributes(content, ecm);
				// add objects of contained references (containment is true)
				content.add("		// add objects of contained objects");
				number = 0;
				for (EreferenceModif ref : ecm.getAllReferences()) {
					// for migrated EReference (containment true), not new 
					if ((ref.getEcore()!=null && ref.getEcore().isContainment()) || (ref.getTo().isMerged() && ref.wasContainment())) {		
						if (!ref.isDerived()) // not derived
						{
							generateContainedObjects(content, ref.getTo(), ref, number);
							// add objects contained references on inherited objects (containment is true)
							for (EclassModif subCm : ref.getTo().getAllSubTypes()) { generateContainedObjects(content, subCm, ref, number); }
						}
						if (ref.isDerived()) {			// derived
							content.add("		// add derived contained objects");		
							generateDerivedContainedObjects(content, ecm, ref.getTo(), ref, number);
							// add objects contained references on inherited objects (containment is true)
							for (EclassModif subCm : ref.getTo().getAllSubTypes()) { generateDerivedContainedObjects(content, ecm, subCm, ref, number); }
						}
					}
					number ++;
				}
				// save correspondence between objects into sourceTotarget		
				content.add("		sourceToTarget.put("+paramName+", result);");
			}	else  { content.add("		EObject result = null;"); }
		}	else  { content.add("		EObject result = null;"); }
		return content;
	}


	/**
	 * Attributes code generation.
	 * 
	 * @param content Already generated code.
	 * @param att Attribute to be generated.
	 */
	protected void generateAttributes(List<String> content, EattributeModif att) {
		if (att.getEnumModif() == null) {
			// build elements for attribute migration code (copy)
			String oldName = Character.toUpperCase(att.getModif().getOldName().charAt(0))+att.getModif().getOldName().substring(1);
			String newName = Character.toUpperCase(att.getModif().getNewName().charAt(0))+att.getModif().getNewName().substring(1);

			// setter of the new attribute
			// if it is a list of attributes, call the EMF generated get function, else the set function
			String add = "";
			// element to list : add
			// list to list : addAll
			// getter of the old attribute
			// if it is a boolean attribute, EMF generates a is function, else a get function
			String getter = ((att.getEcore().getEType().equals(EcorePackage.Literals.EBOOLEAN))?"is":"get") +oldName+"()";
			// list to element : by default select the first element of the list to set the attribute
		}
		else { generateEnumAttributes(content, att); }
	}


	/**
	 * Enum Attributes code generation.
	 * @param content Already generated code.
	 * @param att Attribute to be generated.
	 */
	protected void generateEnumAttributes(List<String> content, EattributeModif att) {
		String oldName = Character.toUpperCase(att.getModif().getOldName().charAt(0))+att.getModif().getOldName().substring(1);
		String newName = Character.toUpperCase(att.getModif().getNewName().charAt(0))+att.getModif().getNewName().substring(1);
		String getter = "get"+oldName+"()";	
		String setter = "set"+newName;
		content.add("		switch (val."+getter+".getValue()) {");
		for (EnumLiteralModif elt : att.getEnumModif().getEnumLiteralModif()) {
			if (! elt.getModif().isRemove()) {
				String oldLitValue = ""+elt.getModif().getOldValue();
				String newLitValue = elt.getEnumModif().getModif().getNewName()+".get("+elt.getModif().getNewValue()+")";
				content.add("			case "+oldLitValue+": result."+setter+"("+newLitValue+");break;");
			}
		}		
		content.add("		}");
	}


	/**
	 * References code generation.
	 * 
	 * @param ecm Class for migration.
	 * @return content List of code lines to generate.
	 */
	protected List<String> generateAddReferencesCode(EclassModif ecm) {
		List<String> content = new ArrayList<String>();		
		if (ecm.getEcore()!=null)  {
			if (! ecm.getEcore().isAbstract() && ! ecm.getModif().isChangeAbstract()) {
				// add references of not contained references
				content.add("		// add not contained references");
				content.add("		"+ecm.getNewLongName()+" obj"+paramName+" = ("+ecm.getNewLongName()+") sourceToTarget.get("+paramName+");");				
				for (int i =0; i <ecm.getAllReferences().size();i++) {
					EreferenceModif ref = ecm.getAllReferences().get(i);
					if (ref.getEcore()!=null && !ref.isDerived() && !ref.getEcore().isContainment() || ((ref.getTo().isMerged() && ! ref.wasContainment()))) {
						generateAddNotContainedReferences(content, ref.getTo(), ref, i);
						for (int k=0; k<ref.getTo().getAllSubTypes().size();k++) {
							if (ref.getTo().getAllSubTypes().get(k).getEcore()!=null) {	generateAddNotContainedReferences(content, ref.getTo().getAllSubTypes().get(k), ref, i); }
						}
					}
				}
				content.add("		// add derived references");
				generateDerivedReferences(content, ecm);
				// call addReferences of contained objects
				content.add("		// call addReferences of contained objects");
				for (int j =0; j <ecm.getAllReferences().size();j++) {
					EreferenceModif ref = ecm.getAllReferences().get(j);
					if (ref.getEcore()!=null && !ref.isDerived() && ref.getEcore().isContainment() || ((ref.getTo().isMerged() && ref.wasContainment())) ) {
						// it is a reference to an existing concrete class
						generateCallAddReferences(content,ref,ref.getTo(),j);
						// add objects contained references on inherited objects (containment is true)
						for (int k=0; k<ref.getTo().getAllSubTypes().size();k++) { generateCallAddReferences(content, ref, ref.getTo().getAllSubTypes().get(k),j); }
					}
				}
				content.add("		// call addReferences of derived contained objects");
				for (int j =0; j <ecm.getAllReferences().size();j++) {
					EreferenceModif ref = ecm.getAllReferences().get(j);
					if (ref.getEcore()!=null && ref.isDerived() && ref.getEcore().isContainment()) {
						// it is a reference to an existing concrete class
						generateCallAddDerivedReferences(content,ecm , ref,ref.getTo(),j);
						// add objects contained references on inherited objects (containment is true)
						for (int k=0; k<ref.getTo().getAllSubTypes().size();k++) { generateCallAddDerivedReferences(content, ecm, ref, ref.getTo().getAllSubTypes().get(k),j); }
					}
				}
			}
		}
		return content;
	}


	/**
	 * Derived reference code generation.
	 * 
	 * @param content Already generated code. Derived reference code will be added to content.
	 * @param cm Class containing the attribute.
	 */
	protected void generateDerivedReferences(List<String> content, EclassModif cm) {
		for (AddDerived add : cm.getModif().getAddDeriveds()) {
			if (add instanceof AddDerivedReference) {				
				EclassModifImpl rcm = (EclassModifImpl) cm;
				int upperBound = 1;
				StringBuilder namePath = new StringBuilder(paramName);
				pRCM theRcm = new pRCM(rcm);
				upperBound = generatePreDerived(content,theRcm,add,upperBound,namePath);
				// look for corresponding ecoreModif Feature
				AddDerivedReference adr = (AddDerivedReference) add ;
				// Name of derived feature
				String newName = Character.toUpperCase(adr.getNewName().charAt(0))+adr.getNewName().substring(1);		
				String test = namePath.toString();	
				String namepath = "("+theRcm.rcm.getNewLongName()+")(sourceToTarget.get("+test+"))";
				content.add("		if ("+test+ "!= null) {");
				if (upperBound > 1 || upperBound ==-1) {
					content.add("			obj"+paramName+".get"+newName+"().add("+namepath+");");
				}
				else { content.add("			obj"+paramName+".set"+newName+"("+namepath+");"); }
				content.add("		}");
				generatePostDerived(content,rcm,add);	
			}
		}
	}


	/**
	 * Pre derived code generation.
	 * 
	 * @param content Already generated code.
	 * @param prcm
	 * @param add Derived reference to be added to the code.
	 * @param upperBound Upper bound of the derived reference.
	 * @param namePath Name.
	 * @return upperBound Upper bound of the derived reference.
	 */
	protected int generatePreDerived(List<String> content, pRCM prcm, AddDerived add, int upperBound, StringBuilder namePath) {
		// List of name of references
		EList<String> names =add.getReferenceName();			
		EreferenceModif rrm = null;

		for (int j = 0; j < names.size(); j++) {
			rrm = prcm.rcm.containsOldNameReference(names.get(j));
			prcm.rcm = (EclassModifImpl) rrm.getTo();
			String nameRef = Character.toUpperCase(rrm.getModif().getOldName().charAt(0))+rrm.getModif().getOldName().substring(1);
			content.add("		if ("+namePath+ "!= null) {");
		}
		return upperBound;
	}


	/**
	 * Post derived code generation.
	 * 
	 * @param content Already generated code. Derived code will be added to content.
	 * @param rcm
	 * @param add Derived reference.
	 */
	protected void generatePostDerived(List<String> content, EclassModifImpl rcm, AddDerived add) {
		// List of name of references
		EList<String> names = add.getReferenceName();
		EreferenceModif rrm = null;
		for (int j = 0; j < names.size(); j++) {
			rrm = rcm.containsOldNameReference(names.get(j));
			rcm = (EclassModifImpl) rrm.getTo();
			content.add("		}");
		}	
	}


	/**
	 * Derived attributes code generation.
	 * 
	 * @param content Already generated code. Derived attribute code will be added to content.
	 * @param cm Class containing the attribute.
	 */
	protected void generateDerivedAttributes(List<String> content, EclassModif cm) {
		for (AddDerived add : cm.getModif().getAddDeriveds()) {
			if (add instanceof AddDerivedAttribute) {	
				EclassModifImpl rcm = (EclassModifImpl) cm;
				int upperBound = 1;
				StringBuilder namePath = new StringBuilder(paramName);
				pRCM prcm = new pRCM(rcm);
				upperBound = generatePreDerived(content,prcm,add,upperBound,namePath);
				AddDerivedAttribute ada = (AddDerivedAttribute) add ;
				// Name of derived feature
				String newName = Character.toUpperCase(ada.getNewName().charAt(0))+ada.getNewName().substring(1);
				EattributeModif eam = prcm.rcm.containsOldNameAttribute(ada.getAttributeName());
				String nameAtt = Character.toUpperCase(eam.getModif().getOldName().charAt(0))+eam.getModif().getOldName().substring(1);
				generatePostDerived(content,rcm,add);	
			}
		}
	}


	/**
	 * 
	 * @param content
	 * @param ect
	 * @param ref
	 * @param num
	 */
	protected void generateAddNotContainedReferences(List<String> content, EclassModif ect, EreferenceModif ref, int num) {
		String oldName = Character.toUpperCase(ref.getModif().getOldName().charAt(0))+ref.getModif().getOldName().substring(1);
		String newName = Character.toUpperCase(ref.getModif().getNewName().charAt(0))+ref.getModif().getNewName().substring(1);
		// setter of the new reference
		// if it is a list of attributes, call the EMF generated get function, else the set function
		// case >1 to >1 : list to list
	}


	/**
	 * 
	 * @param content
	 * @param ref
	 * @param ect
	 * @param num
	 */
	protected void generateCallAddReferences(List<String> content, EreferenceModif ref, EclassModif ect, int num) {

		if (ect.getEcore()!=null && !ect.getEcore().isAbstract() && ! ect.getModif().isChangeAbstract()) {
			String oldName = Character.toUpperCase(ref.getModif().getOldName().charAt(0))+ref.getModif().getOldName().substring(1);
			String source = ect.getModif().getOldName();
			// case <=1 
		}
	}


	/**
	 * Call derived references code generation.
	 * 
	 * @param content Already generated code. Derived contained object code will be added to content.
	 * @param ecm Class.
	 * @param ref Reference.
	 * @param ect Class.
	 * @param num
	 */
	protected void generateCallAddDerivedReferences(List<String> content, EclassModif ecm, EreferenceModif ref, EclassModif ect, int num) {
		EclassModifImpl rcm = (EclassModifImpl) ecm;
		int upperBound = 1;
		StringBuilder namePath = new StringBuilder(paramName);

		pRCM prcm = new pRCM(rcm);
		upperBound = generatePreDerived(content,prcm,ref.getDerived(),upperBound,namePath);

		//namePath = namePath.delete(0, 3);
		if (ect.getEcore()!=null && !ect.getEcore().isAbstract() && ! ect.getModif().isChangeAbstract()) {
			//		String oldName = Character.toUpperCase(namePath.charAt(0))+namePath.substring(1);
			String source = ect.getModif().getOldName();
			content.add("			if ("+namePath+" != null) {");
			content.add("			if ("+namePath+".getClass().equals("+ect.getParent().getOldLongName()+"impl."+source+"Impl.class)) {");
			content.add("				this.addReferences"+source+"( ("+ect.getOldLongName()+") "+namePath+");");
			content.add("			}");
			content.add("			}");
		}
		generatePostDerived(content,rcm,ref.getDerived());	
	}

	/**
	 * Contained objects code generation.
	 * 
	 * @param content Already generated code. Contained attribute code will be added to content.
	 * @param ect Class.
	 * @param ref Reference.
	 * @param num
	 */
	protected void generateContainedObjects(List<String> content, EclassModif ect, EreferenceModif ref, int num) {
		// it is a reference to an existing concrete class
		if (ect.getEcore()!=null && !ect.getEcore().isAbstract() && ! ect.getModif().isChangeAbstract()) {

			String oldName = Character.toUpperCase(ref.getModif().getOldName().charAt(0))+ref.getModif().getOldName().substring(1);
			String newName = Character.toUpperCase(ref.getModif().getNewName().charAt(0))+ref.getModif().getNewName().substring(1);
			String source = ect.getModif().getOldName();
			String target = ect.getModif().getNewName();
			// build elements for attribute migration code (copy)
			// setter of the new reference
			// if it is a list of attributes, call the EMF generated get function, else the set function
		}
	}


	/**
	 * Derived contained objects code generation.
	 * 
	 * @param content Already generated code. Derived contained object code will be added to content.
	 * @param ecm Class.
	 * @param ect Class.
	 * @param ref Reference.
	 * @param num
	 */
	protected void generateDerivedContainedObjects(List<String> content, EclassModif ecm, EclassModif ect, EreferenceModif ref, int num) {

		EclassModifImpl rcm = (EclassModifImpl) ecm;
		int upperBound = 1;
		StringBuilder namePath = new StringBuilder(paramName);

		pRCM prcm = new pRCM(rcm);
		upperBound = generatePreDerived(content,prcm,ref.getDerived(),upperBound,namePath);
		namePath = namePath.delete(0, 3);
		if (ect.getEcore()!=null && !ect.getEcore().isAbstract() && ! ect.getModif().isChangeAbstract()) {
			String oldName = Character.toUpperCase(namePath.charAt(0))+namePath.substring(1);
			String newName = Character.toUpperCase(ref.getDerived().getNewName().charAt(0))+ref.getDerived().getNewName().substring(1);		
			String source = ect.getModif().getOldName();
			String target = ect.getModif().getNewName();
			// build elements for attribute migration code (copy)
			// setter of the new reference
			// if it is a list of attributes, call the EMF generated get function, else the set function
			content.add("			}");
			content.add("			}");	
		}
		generatePostDerived(content,rcm,ref.getDerived());	
	}


	/**
	 * Reverse migration code generation.
	 * 
	 * @param ecm Class.
	 * @return
	 */
	protected List<String> generateReverseMigrationCode(EclassModif ecm) {
		List<String> content = new ArrayList<String>();		
		if (ecm.getEcore()!=null)  { 
			content.add("	"+ecm.getOldLongName()+" result = null;"); // myFactory.createAA();");
		}
		else  { content.add("EObject result = null;"); }	
		return content;
	}

}