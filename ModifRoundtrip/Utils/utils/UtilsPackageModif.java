/**
 *  a set of utility methods (constructor from ecore, find from name) to manipulate PackageModification
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */
package utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;

import modif.PackageModification;
import modif.impl.ModifFactoryImpl;

public class UtilsPackageModif {
	
	// find a PackageModification by its name in a list of PackageModification 
	// returns it if found, null otherwise
	public PackageModification findPackage(String namePackage, EList<PackageModification> listPackModif) {
		
		int positionPackage=0;	
		
		int i=0;
		while (i < listPackModif.size() && positionPackage == 0) {
			if (listPackModif.get(i).getOldName().equals(namePackage)) {
				positionPackage =i+1;
			}
			i++;
		}
		
		if (positionPackage==0) {
			return null;
		}
		else {
			return listPackModif.get(positionPackage-1);
		}	

	}
	
	// by-default constructor of a PackageModification from an EPackage
	// keep the same names
	// set remove, removeEAnnotations and hide to false
	// the created PackageModification is added to container
	public PackageModification Create(EPackage ep) {
		ModifFactoryImpl mf = new ModifFactoryImpl();
		
		PackageModification pm = mf.createPackageModification() ;
		
		pm.setOldName(ep.getName());
		pm.setNewName(ep.getName());
		pm.setRemove(false);
		pm.setRemoveEAnnotations(false);		
		
		pm.setOldPrefixName(ep.getNsPrefix());
		pm.setNewPrefixName(ep.getNsPrefix());	
		pm.setOldURIName(ep.getNsURI());
		pm.setNewURIName(ep.getNsURI());

		pm.setHide(false);
		
		return pm;
	}
	
	public void complete(EPackage ep, PackageModification epm) {
		
		if (epm.getNewName() == null || epm.getNewName().equals("")) {
			epm.setNewName(ep.getName());
		}
		if (epm.getOldPrefixName() == null || epm.getOldPrefixName().equals("")) {
			epm.setOldPrefixName(ep.getNsPrefix());
		}		
		if (epm.getOldURIName() == null || epm.getOldURIName().equals("")) {
			epm.setOldURIName(ep.getNsURI());
		}
		if (epm.getNewPrefixName() == null || epm.getNewPrefixName().equals("")) {
			epm.setNewPrefixName(ep.getNsPrefix());
		}		
		if (epm.getNewURIName() == null || epm.getNewURIName().equals("")) {
			epm.setNewURIName(ep.getNsURI());
		}
	}
	
}


