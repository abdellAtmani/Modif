/**
 */
package migration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deletion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link migration.Deletion#getDeletedAttributes <em>Deleted Attributes</em>}</li>
 *   <li>{@link migration.Deletion#getDeletedReferences <em>Deleted References</em>}</li>
 *   <li>{@link migration.Deletion#isDeleteInstance <em>Delete Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see migration.MigrationPackage#getDeletion()
 * @model
 * @generated
 */
public interface Deletion extends EObject {
	/**
	 * Returns the value of the '<em><b>Deleted Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link migration.DeletedAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted Attributes</em>' containment reference list.
	 * @see migration.MigrationPackage#getDeletion_DeletedAttributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DeletedAttribute> getDeletedAttributes();

	/**
	 * Returns the value of the '<em><b>Deleted References</b></em>' containment reference list.
	 * The list contents are of type {@link migration.DeletedReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deleted References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted References</em>' containment reference list.
	 * @see migration.MigrationPackage#getDeletion_DeletedReferences()
	 * @model containment="true"
	 * @generated
	 */
	EList<DeletedReference> getDeletedReferences();

	/**
	 * Returns the value of the '<em><b>Delete Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delete Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delete Instance</em>' attribute.
	 * @see #setDeleteInstance(boolean)
	 * @see migration.MigrationPackage#getDeletion_DeleteInstance()
	 * @model required="true"
	 * @generated
	 */
	boolean isDeleteInstance();

	/**
	 * Sets the value of the '{@link migration.Deletion#isDeleteInstance <em>Delete Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delete Instance</em>' attribute.
	 * @see #isDeleteInstance()
	 * @generated
	 */
	void setDeleteInstance(boolean value);

} // Deletion
