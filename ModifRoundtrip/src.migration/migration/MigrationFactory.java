/**
 */
package migration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see migration.MigrationPackage
 * @generated
 */
public interface MigrationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MigrationFactory eINSTANCE = migration.impl.MigrationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Migration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Migration</em>'.
	 * @generated
	 */
	Migration createMigration();

	/**
	 * Returns a new object of class '<em>Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance</em>'.
	 * @generated
	 */
	Instance createInstance();

	/**
	 * Returns a new object of class '<em>Deletion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deletion</em>'.
	 * @generated
	 */
	Deletion createDeletion();

	/**
	 * Returns a new object of class '<em>Deleted Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deleted Attribute</em>'.
	 * @generated
	 */
	DeletedAttribute createDeletedAttribute();

	/**
	 * Returns a new object of class '<em>Deleted Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deleted Reference</em>'.
	 * @generated
	 */
	DeletedReference createDeletedReference();

	/**
	 * Returns a new object of class '<em>Derived Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Derived Reference</em>'.
	 * @generated
	 */
	DerivedReference createDerivedReference();

	/**
	 * Returns a new object of class '<em>Reference Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Path</em>'.
	 * @generated
	 */
	ReferencePath createReferencePath();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MigrationPackage getMigrationPackage();

} //MigrationFactory
