package utils;

import java.io.IOException;

import migration.Migration;
import migration.MigrationPackage;
import modif.Modifications;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import ecoremodif.utils.ModifIO;

public class IOMigrationSpecification {

	// ATTRIBUTES ************************************************************************


	// PUBLIC ****************************************************************************

	/**
	 * Load a migration specification.
	 * @param migrationSpecificationPath Path of the migration specification file.
	 * @return migrationSpecification. Loaded migration specification.
	 */
	public static Migration loadMigrationSpecification(String migrationSpecificationPath){
		Migration migrationSpecification = (Migration) UtilEMF.loadModel(migrationSpecificationPath, MigrationPackage.eINSTANCE);
		return migrationSpecification;
	}

	/**
	 * Save a migration specification.
	 * @param migrationSpecification Migration specification to save in a file.
	 * @param migrationSpecificationPath Path to save the migration specification.
	 */
	public static void saveMigrationSpecification(Migration migrationSpecification, String migrationSpecificationPath) {		
		if(migrationSpecification != null) {
			try {
				UtilEMF.saveModel(migrationSpecification, migrationSpecificationPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
