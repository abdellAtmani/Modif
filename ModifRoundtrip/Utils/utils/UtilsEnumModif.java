/**
 *  a set of utility methods (constructor from ecore, find from name) to manipulate EnumModification
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

package utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;

import modif.*;
import modif.impl.*;

public class UtilsEnumModif {
	
	// find a EnumModification by its name in a list of EnumModification 
	// returns it if found, null otherwise
	public EnumModification findEnum(String nameEnum, EList<EnumModification> listEnumModif) {
	
		int positionEnum=0;	
		
		int i=0;
		while (i < listEnumModif.size() && positionEnum == 0) {
			if (listEnumModif.get(i).getOldName().equals(nameEnum)) {
				positionEnum =i+1;
			}
			i++;
		}
		
		if (positionEnum==0) {
			return null;
		}
		else {
			return listEnumModif.get(positionEnum-1);
		}	
	}
	
	// by-default constructor of an EnumModification from an EEnum
	// keep the same name
	// set remove, removeEAnnotations to false
	// the created EnumModification is added to container
	public EnumModification Create(EEnum en) {
		ModifFactoryImpl mf = new ModifFactoryImpl();
		
		EnumModification enm = mf.createEnumModification() ;
		
		enm.setOldName(en.getName());
		enm.setNewName(en.getName());
		
		enm.setRemove(false);
		enm.setRemoveEAnnotations(false);

		enm.setOldInstanceTypeName(en.getInstanceTypeName());
		enm.setNewInstanceTypeName(en.getInstanceTypeName());

		enm.setReify(false);
		
		return enm;
	}
	
	
	// find a EnumLiteralModification by its name in a list of EnumLiteralModification 
	// returns it if found, null otherwise
	public EnumLiteralModification findEnumLiteral(String nameEnumLiteral, EList<EnumLiteralModification> listEnumLiteralModif) {
	
		int positionEnumLiteral=0;	
		
		int i=0;
		while (i < listEnumLiteralModif.size() && positionEnumLiteral == 0) {
			if (listEnumLiteralModif.get(i).getOldName().equals(nameEnumLiteral)) {
				positionEnumLiteral =i+1;
			}
			i++;
		}
		
		if (positionEnumLiteral==0) {
			return null;
		}
		else {
			return listEnumLiteralModif.get(positionEnumLiteral-1);
		}	
	}
	
	// by-default constructor of an EnumLiteralModification from an EEnumLiteral
	// keep the same name, literal and value
	// set remove, removeEAnnotations to false
	// the created EnumLiteralModification is added to container
	public EnumLiteralModification Create(EEnumLiteral enl, EnumModification container) {
		ModifFactoryImpl mf = new ModifFactoryImpl();
		
		EnumLiteralModification enlm = mf.createEnumLiteralModification() ;
		
		enlm.setOldName(enl.getName());
		enlm.setNewName(enl.getName());
		
		enlm.setRemove(false);
		enlm.setRemoveEAnnotations(false);	
		
		enlm.setOldLiteral(enl.getLiteral());
		enlm.setNewLiteral(enl.getLiteral());
		
		enlm.setOldValue(enl.getValue());
		enlm.setNewValue(enl.getValue());
		
		return enlm;
	}
	
	public void complete(EEnum en, EnumModification enm) {
		
		if (enm.getNewName() == null || enm.getNewName().equals("")) {
			enm.setNewName(en.getName());
		}
		if (enm.getOldInstanceTypeName() == null || enm.getOldInstanceTypeName().equals("")) {
			enm.setOldInstanceTypeName(en.getInstanceTypeName());
		}
		if (enm.getNewInstanceTypeName() == null || enm.getNewInstanceTypeName().equals("")) {
			enm.setNewInstanceTypeName(en.getInstanceTypeName());
		}
	}
	
	public void complete(EEnumLiteral enl, EnumLiteralModification enlm) {
		
		if (enlm.getNewName() == null || enlm.getNewName().equals("")) {
			enlm.setNewName(enl.getName());
		}
		if (enlm.getOldLiteral() == null || enlm.getOldLiteral().equals("")) {
			enlm.setOldLiteral(enl.getLiteral());
		}
		if (enlm.getNewLiteral() == null || enlm.getNewLiteral().equals("")) {
			enlm.setNewLiteral(enl.getLiteral());
		}
	}
}
