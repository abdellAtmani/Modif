/**
 */
package migration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link migration.Instance#getUUID <em>UUID</em>}</li>
 *   <li>{@link migration.Instance#getDeletion <em>Deletion</em>}</li>
 *   <li>{@link migration.Instance#getDerived <em>Derived</em>}</li>
 * </ul>
 * </p>
 *
 * @see migration.MigrationPackage#getInstance()
 * @model
 * @generated
 */
public interface Instance extends EObject {
	/**
	 * Returns the value of the '<em><b>UUID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>UUID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>UUID</em>' attribute.
	 * @see #setUUID(String)
	 * @see migration.MigrationPackage#getInstance_UUID()
	 * @model id="true" required="true"
	 * @generated
	 */
	String getUUID();

	/**
	 * Sets the value of the '{@link migration.Instance#getUUID <em>UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>UUID</em>' attribute.
	 * @see #getUUID()
	 * @generated
	 */
	void setUUID(String value);

	/**
	 * Returns the value of the '<em><b>Deletion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deletion</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deletion</em>' containment reference.
	 * @see #setDeletion(Deletion)
	 * @see migration.MigrationPackage#getInstance_Deletion()
	 * @model containment="true"
	 * @generated
	 */
	Deletion getDeletion();

	/**
	 * Sets the value of the '{@link migration.Instance#getDeletion <em>Deletion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deletion</em>' containment reference.
	 * @see #getDeletion()
	 * @generated
	 */
	void setDeletion(Deletion value);

	/**
	 * Returns the value of the '<em><b>Derived</b></em>' containment reference list.
	 * The list contents are of type {@link migration.DerivedReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived</em>' containment reference list.
	 * @see migration.MigrationPackage#getInstance_Derived()
	 * @model containment="true"
	 * @generated
	 */
	EList<DerivedReference> getDerived();

} // Instance
