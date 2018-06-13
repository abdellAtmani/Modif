/**
 */
package modif;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Derived</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.AddDerived#getNewName <em>New Name</em>}</li>
 *   <li>{@link modif.AddDerived#getReferenceName <em>Reference Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getAddDerived()
 * @model abstract="true"
 * @generated
 */
public interface AddDerived extends EObject {
	/**
	 * Returns the value of the '<em><b>New Name</b></em>' attribute.
	 * The default value is <code>"_"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Name</em>' attribute.
	 * @see #setNewName(String)
	 * @see modif.ModifPackage#getAddDerived_NewName()
	 * @model default="_" required="true"
	 * @generated
	 */
	String getNewName();

	/**
	 * Sets the value of the '{@link modif.AddDerived#getNewName <em>New Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Name</em>' attribute.
	 * @see #getNewName()
	 * @generated
	 */
	void setNewName(String value);

	/**
	 * Returns the value of the '<em><b>Reference Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference Name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference Name</em>' attribute list.
	 * @see modif.ModifPackage#getAddDerived_ReferenceName()
	 * @model default="" unique="false" required="true"
	 * @generated
	 */
	EList<String> getReferenceName();

} // AddDerived
