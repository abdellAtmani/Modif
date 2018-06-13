package migrationRoundtrip;

import modif.Modifications;

import org.eclipse.emf.ecore.EPackage;

import utils.IOModifSpecification;
import utils.UtilUUID;

/**
 * Class for handling refactoring.
 *
 * A target metamodel is produced from a source metamodel and a modif specification.
 * This class gathers useful functions to refactor metamodels.
 * 
 * @author P. Vallejo
 *
 */

public class Refactoring {

	// ATTRIBUTES ******************************************************************************

	EPackage sourceMetamodel;
	EPackage sourceMetamodelUUID;
	Modifications modifSpecification;


	// PRIVATE *********************************************************************************



	// PUBLIC **********************************************************************************

	/**
	 * Create a modif specification from the source model.
	 * @param modifSpecificationPath Path to save the modif specification
	 * @return theModifSpecification Modif specification compatible with the source metamodel 
	 */
	public Modifications createModif(String modifSpecificationPath){
		Modifications theModifSpecification = null; 

		// Add UUIDs to the source metamodel
		this.sourceMetamodelUUID = UtilUUID.addUUIDMetamodelAttribute(sourceMetamodel);

		ModifSpecification.setSourceMetamodel(this.sourceMetamodelUUID);

		// Generate the modif specification
		ModifSpecification.generateModifSpecification(1);
		theModifSpecification = ModifSpecification.getModifSpecification();

		// Save the modif specification in a file
		IOModifSpecification.saveModifSpecification(theModifSpecification, modifSpecificationPath);
		this.modifSpecification = theModifSpecification;

		return theModifSpecification; 
	}

	/**
	 * Refactor the source metamodel (with UUIDs) according to the operators of the modif specification.
	 * @return targetMetamodel Refactored metamodel (whitout UUIDs).
	 */
	public EPackage refactor(){
		EPackage targetMetamodelUUID; 
		Refactor.setSourceMetamodel(this.sourceMetamodelUUID);
		Refactor.setModifSpecification(this.modifSpecification);
		Refactor.refactor();
		targetMetamodelUUID = Refactor.getTargetMetamodel();
		EPackage targetMetamodel = UtilUUID.removeUUIDMetamodelAttribute(targetMetamodelUUID);
		return targetMetamodel;
	}

	/**
	 * Set the source metamodel.
	 * @param theSourceMetamodel Source metamodel.
	 */
	public void setSourceMetamodel(EPackage theSourceMetamodel){
		this.sourceMetamodel = theSourceMetamodel;
	}

}
