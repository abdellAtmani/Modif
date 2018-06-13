/**
 */
package migration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Derived Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link migration.DerivedReference#getPath <em>Path</em>}</li>
 *   <li>{@link migration.DerivedReference#getNewReferenceName <em>New Reference Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see migration.MigrationPackage#getDerivedReference()
 * @model
 * @generated
 */
public interface DerivedReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference list.
	 * The list contents are of type {@link migration.ReferencePath}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' containment reference list.
	 * @see migration.MigrationPackage#getDerivedReference_Path()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReferencePath> getPath();

	/**
	 * Returns the value of the '<em><b>New Reference Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Reference Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Reference Name</em>' attribute.
	 * @see #setNewReferenceName(String)
	 * @see migration.MigrationPackage#getDerivedReference_NewReferenceName()
	 * @model
	 * @generated
	 */
	String getNewReferenceName();

	/**
	 * Sets the value of the '{@link migration.DerivedReference#getNewReferenceName <em>New Reference Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Reference Name</em>' attribute.
	 * @see #getNewReferenceName()
	 * @generated
	 */
	void setNewReferenceName(String value);

} // DerivedReference
