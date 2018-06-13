package uiMigrationSpecificationEdition;

public interface IMigratedObjectListViewer {

	/**
	 * Update the view to reflect the fact that one of the migratedObjects was modified.
	 * 
	 * @param migratedObject modified migrated object.
	 */
	public void updateMigratedObject(MigratedObject migratedObject);


	/**
	 * Put the value of the delete column to False.
	 * 
	 * @param migratedObject migrated object.
	 */
	public void resetMigratedObjects(MigratedObject migratedObject);
}
