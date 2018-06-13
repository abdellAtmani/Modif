/**
 *  a set of utility methods (constructor from ecore, clone, find from name) 
 *  to manipulate StructuralFeatureModification
 *  @author Jean-Philippe Babau
 *  22/11/2013
 */

package utils;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;

import modif.*;
import modif.impl.*;

public class UtilsFeatureModif {
	
	// find a StructuralFeatureModification by its name in a list of StructuralFeatureModification 
	// returns it if found, null otherwise
	public StructuralFeatureModification findStructuralFeature(String nameFeature, EList<StructuralFeatureModification> listFeatureModif) {
	
		int positionStructuralFeature=0;	
		
		int i=0;
		while (i < listFeatureModif.size() && positionStructuralFeature == 0) {
			if (listFeatureModif.get(i).getOldName().equals(nameFeature)) {
				positionStructuralFeature =i+1;
			}
			i++;
		}
		if (positionStructuralFeature==0) {
			return null;	}
		else {
			return listFeatureModif.get(positionStructuralFeature-1);		}	
	}
	
	// by-default constructor of an AttributeModification from an EAttribute
	// keep the same name, the same lower and upper bounds
	// set remove, removeEAnnotations to false
	public AttributeModification Create(EAttribute ea) {
		ModifFactoryImpl mf = new ModifFactoryImpl();
		
		AttributeModification am = mf.createAttributeModification() ;
		
		am.setOldName(ea.getName());
		am.setNewName(ea.getName());
		
		am.setRemove(false);
		am.setRemoveEAnnotations(false);		
		
		ChangeBounds cb = mf.createChangeBounds();
		
		cb.setOldLower(ea.getLowerBound());
		cb.setNewLower(ea.getLowerBound());
		cb.setOldUpper(ea.getUpperBound());
		cb.setNewUpper(ea.getUpperBound());
		
		am.setChangeBounds(cb);

		am.setChangeType(false);
		am.setNewType(PrimitiveType.INT);
		
		return am;
	}
	
	// clone a AttributeModification 
	public AttributeModification Copy(AttributeModification eam) {
		ModifFactoryImpl mf = new ModifFactoryImpl();
		
		AttributeModification am = mf.createAttributeModification() ;
		
		am.setOldName(eam.getOldName());
		am.setNewName(eam.getNewName());
		
		am.setRemove(eam.isRemove());
		am.setRemoveEAnnotations(eam.isRemoveEAnnotations());		
		
		ChangeBounds cb = mf.createChangeBounds();
		
		cb.setOldLower(eam.getChangeBounds().getOldLower());
		cb.setNewLower(eam.getChangeBounds().getNewLower());
		cb.setOldUpper(eam.getChangeBounds().getOldUpper());
		cb.setNewUpper(eam.getChangeBounds().getNewUpper());
		
		am.setChangeBounds(cb);

		am.setChangeType(eam.isChangeType());
		am.setNewType(eam.getNewType());
		
		return am;
	}

	// by-default constructor of a ReferenceModification from an EReference
	// keep the same name, the same lower and upper bounds
	// set remove, removeEAnnotations and changeContainment to false
	// the created ReferenceModification is added to container
	public ReferenceModification Create(EReference er) {
		ModifFactoryImpl mf = new ModifFactoryImpl();
		
		ReferenceModification rm = mf.createReferenceModification() ;
		
		rm.setOldName(er.getName());
		rm.setNewName(er.getName());
		
		rm.setRemove(false);
		rm.setRemoveEAnnotations(false);
		
		ChangeBounds cb = mf.createChangeBounds();
		
		cb.setOldLower(er.getLowerBound());
		cb.setNewLower(er.getLowerBound());
		cb.setOldUpper(er.getUpperBound());
		cb.setNewUpper(er.getUpperBound());
		
		rm.setChangeBounds(cb);
		
		rm.setChangeContainement(false);
		
		rm.setRemoveOpposite(false);
		rm.setReify(null);
		
		return rm;
	}

	// clone a ReferenceModification 
	public ReferenceModification Copy(ReferenceModification erm) {
		ModifFactoryImpl mf = new ModifFactoryImpl();
		
		ReferenceModification rm = mf.createReferenceModification() ;
		
		rm.setOldName(erm.getOldName());
		rm.setNewName(erm.getNewName());
		
		rm.setRemove(erm.isRemove());
		rm.setRemoveEAnnotations(erm.isRemoveEAnnotations());
		
		ChangeBounds cb = mf.createChangeBounds();
		
		cb.setOldLower(erm.getChangeBounds().getOldLower());
		cb.setNewLower(erm.getChangeBounds().getNewLower());
		cb.setOldUpper(erm.getChangeBounds().getOldUpper());
		cb.setNewUpper(erm.getChangeBounds().getNewUpper());
		
		rm.setChangeBounds(cb);
		
		rm.setChangeContainement(erm.isChangeContainement());
		
		rm.setRemoveOpposite(erm.isRemoveOpposite());
		rm.setReify(erm.getReify());
		
		return rm;
	}

	public void complete(EAttribute ea, AttributeModification eam) {
		
		if (eam.getNewName() == null || eam.getNewName().equals("")) {
			eam.setNewName(ea.getName());
		}
		
		if (eam.getChangeBounds()==null) {
			ModifFactoryImpl mf = new ModifFactoryImpl();
			ChangeBounds cb = mf.createChangeBounds();
		
			cb.setOldLower(ea.getLowerBound());
			cb.setNewLower(ea.getLowerBound());
			cb.setOldUpper(ea.getUpperBound());
			cb.setNewUpper(ea.getUpperBound());
		
			eam.setChangeBounds(cb);
		}
	}
	
	public void complete(EReference er, ReferenceModification erm) {
		
		if (erm.getNewName() == null || erm.getNewName().equals("")) {
			erm.setNewName(er.getName());
		}
		
		if (erm.getChangeBounds()==null) {
			ModifFactoryImpl mf = new ModifFactoryImpl();
			ChangeBounds cb = mf.createChangeBounds();
		
			cb.setOldLower(er.getLowerBound());
			cb.setNewLower(er.getLowerBound());
			cb.setOldUpper(er.getUpperBound());
			cb.setNewUpper(er.getUpperBound());
		
			erm.setChangeBounds(cb);
		}
	}
}
