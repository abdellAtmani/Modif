package migrationRoundtrip;

import org.eclipse.emf.ecore.EPackage;

import ecoremodif.RootEcoreModif;
import ecoremodif.utils.ModifIO;
import modif.Modifications;

/**
 * Utilitary class for handling refactoring.
 * Source metamodel has UUIDs.
 * A target metamodel is produced from a source metamodel and a modif specification.
 * This class gathers useful functions to refactor metamodels.
 * 
 * @author P. Vallejo
 *
 */
public class Refactor {

	// ATTRIBUTES *******************************************************************************

	private static EPackage sourceMetamodel;
	private static Modifications modifSpecification;
	private static EPackage targetMetamodel;
	private static RootEcoreModif theRootEcoreModif;


	// PRIVATE **********************************************************************************

	/**
	 * Check if the modif specification and the metamodel are compatible.
	 * @return compatible. True, if the modif specification can be applied to the metamodel. False, otherwise.
	 */
	private static boolean checkModifMetamodelCompatibility() {
		System.out.println("modifSpecification : "+modifSpecification);
		
		boolean compatible = false;
		String URI = sourceMetamodel.getNsURI();
		String modifURI = modifSpecification.getRootPackageModification().getOldURIName();
		String prefix = sourceMetamodel.getNsPrefix();
		String modiPrefix = modifSpecification.getRootPackageModification().getOldPrefixName();
		String name = sourceMetamodel.getName();
		String modifName = modifSpecification.getRootPackageModification().getOldName();

		if(URI.equals(modifURI) && prefix.equals(modiPrefix) && name.equals(modifName)) {
			compatible = true;
		}
		return compatible;
	}


	// PUBLIC **********************************************************************************

	/**
	 * Get the target metamodel.
	 * @return targetMetamodel Refactored metamodel.
	 */
	public static EPackage getTargetMetamodel() {
		return targetMetamodel;
	}

	/**
	 * Set the source metamodel.
	 * @param theSourceMetamodel Source metamodel.
	 */
	public static void setSourceMetamodel(EPackage theSourceMetamodel) {
		sourceMetamodel = theSourceMetamodel; 
	}

	/**
	 * Set the modif specification.
	 * @param theModifSpecification. Modif specification.
	 */
	public static void setModifSpecification(Modifications theModifSpecification) {
		modifSpecification = theModifSpecification;
	}

	/**
	 * Transform the source metamodel according to the operators of the modif specification.
	 */
	public static void refactor() {
		boolean compatible = checkModifMetamodelCompatibility();

		if(compatible) {
			
			ModifIO modifIO = new ModifIO();
			modifIO.setModifIO(sourceMetamodel, modifSpecification);	
			theRootEcoreModif = modifIO.getEcoreModif();			
			if (theRootEcoreModif != null) {
				if (ApplyOperators.ecoreModifIsValid(theRootEcoreModif)) {
					// launch refactoring operators
					ApplyOperators.operate(theRootEcoreModif);
				}
			}	
			targetMetamodel = theRootEcoreModif.getRoot().getEcore();
		}else {

			System.out.println(" Modif and Metamodel are not compatible ");
		}
	}

}
