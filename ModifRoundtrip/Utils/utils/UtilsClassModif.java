/**
 *  a set of utility methods (constructor from ecore, find from name) to manipulate ClassModification
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

package utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import modif.ClassModification;
import modif.impl.ModifFactoryImpl;

public class UtilsClassModif {
	
	// find a ClassModification by its name in a list of ClassModification 
	// returns it if found, null otherwise
	public ClassModification findClass(String nameClass, EList<ClassModification> listClassModif) {
	
		int positionClass=0;	
		int i=0;
		while (i < listClassModif.size() && positionClass == 0) {		
			if (listClassModif.get(i).getOldName().equals(nameClass)) {
				positionClass =i+1;
			}
			i++;
		}
		if (positionClass==0) {
			return null;
		}
		else {
			return listClassModif.get(positionClass-1);
		}	
	}
	
	// by-default constructor of a ClassModification from an EClass
	// keep the same name
	// set remove, removeEAnnotations, hide, changeAbstract, flatten to false
	// the created ClassModification is added to container
	public ClassModification Create(EClass ec) {
		ModifFactoryImpl mf = new ModifFactoryImpl();
		
		ClassModification cm = mf.createClassModification() ;
		
		cm.setOldName(ec.getName());
		cm.setNewName(ec.getName());
		cm.setRemove(false);
		cm.setRemoveEAnnotations(false);
		
		cm.setChangeAbstract(false);
		cm.setHide(false);
		cm.setFlatten(false);
		cm.setFlattenAll(false);
		cm.setEnumerate(null);
		
		return cm;
	}
	
	public void complete(EClass ec, ClassModification ecm) {
		
		if (ecm.getNewName() == null || ecm.getNewName().equals("")) {
			ecm.setNewName(ec.getName());
		}
		
	}
	
}
