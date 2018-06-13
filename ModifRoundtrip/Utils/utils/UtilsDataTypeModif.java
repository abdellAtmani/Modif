/**
 *  a set of utility methods (constructor from ecore, find from name) to manipulate DataTypeModification
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

package utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;

import modif.*;
import modif.impl.*;

public class UtilsDataTypeModif {
	
	// find a DataTypeModification by its name in a list of DataTypeModification 
	// returns it if found, null otherwise
	public DataTypeModification findDataType(String nameDataType, EList<DataTypeModification> listDataTypeModif) {
	
		int positionStructuralFeature=0;	
		
		int i=0;
		while (i < listDataTypeModif.size() && positionStructuralFeature == 0) {
			if (listDataTypeModif.get(i).getOldName().equals(nameDataType)) {
				positionStructuralFeature =i+1;
			}
			i++;
		}
		
		if (positionStructuralFeature==0) {
			return null;
		}
		else {
			return listDataTypeModif.get(positionStructuralFeature-1);
		}	
	}
	
	// by-default constructor of an DataTypeModification from an EDataType
	// keep the same name, the same lower and upper bounds
	// set remove, removeEAnnotations to false
	// the created DataTypeModification is added to container
	public DataTypeModification Create(EDataType edt) {
		ModifFactoryImpl mf = new ModifFactoryImpl();
		
		DataTypeModification dm = mf.createDataTypeModification() ;
		
		dm.setOldName(edt.getName());
		dm.setNewName(edt.getName());

		dm.setRemove(false);
		dm.setRemoveEAnnotations(false);
		
		dm.setOldInstanceTypeName(edt.getInstanceTypeName());
		dm.setNewInstanceTypeName(edt.getInstanceTypeName());
		
		return dm;
	}
	
	public void complete(EDataType edt, DataTypeModification edm) {
		
		if (edm.getNewName() == null || edm.getNewName().equals("")) {
			edm.setNewName(edt.getName());
		}
		if (edm.getOldInstanceTypeName() == null || edm.getOldInstanceTypeName().equals("")) {
			edm.setOldInstanceTypeName(edt.getInstanceTypeName());
		}
		if (edm.getNewInstanceTypeName() == null || edm.getNewInstanceTypeName().equals("")) {
			edm.setNewInstanceTypeName(edt.getInstanceTypeName());
		}
	}
	
}

