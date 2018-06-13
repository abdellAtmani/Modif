/**
 */
package modif;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Change Bounds</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.ChangeBounds#getOldLower <em>Old Lower</em>}</li>
 *   <li>{@link modif.ChangeBounds#getNewLower <em>New Lower</em>}</li>
 *   <li>{@link modif.ChangeBounds#getOldUpper <em>Old Upper</em>}</li>
 *   <li>{@link modif.ChangeBounds#getNewUpper <em>New Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getChangeBounds()
 * @model
 * @generated
 */
public interface ChangeBounds extends EObject {
	/**
	 * Returns the value of the '<em><b>Old Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Lower</em>' attribute.
	 * @see #setOldLower(int)
	 * @see modif.ModifPackage#getChangeBounds_OldLower()
	 * @model required="true"
	 * @generated
	 */
	int getOldLower();

	/**
	 * Sets the value of the '{@link modif.ChangeBounds#getOldLower <em>Old Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Lower</em>' attribute.
	 * @see #getOldLower()
	 * @generated
	 */
	void setOldLower(int value);

	/**
	 * Returns the value of the '<em><b>New Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Lower</em>' attribute.
	 * @see #setNewLower(int)
	 * @see modif.ModifPackage#getChangeBounds_NewLower()
	 * @model
	 * @generated
	 */
	int getNewLower();

	/**
	 * Sets the value of the '{@link modif.ChangeBounds#getNewLower <em>New Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Lower</em>' attribute.
	 * @see #getNewLower()
	 * @generated
	 */
	void setNewLower(int value);

	/**
	 * Returns the value of the '<em><b>Old Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Upper</em>' attribute.
	 * @see #setOldUpper(int)
	 * @see modif.ModifPackage#getChangeBounds_OldUpper()
	 * @model required="true"
	 * @generated
	 */
	int getOldUpper();

	/**
	 * Sets the value of the '{@link modif.ChangeBounds#getOldUpper <em>Old Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Upper</em>' attribute.
	 * @see #getOldUpper()
	 * @generated
	 */
	void setOldUpper(int value);

	/**
	 * Returns the value of the '<em><b>New Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Upper</em>' attribute.
	 * @see #setNewUpper(int)
	 * @see modif.ModifPackage#getChangeBounds_NewUpper()
	 * @model
	 * @generated
	 */
	int getNewUpper();

	/**
	 * Sets the value of the '{@link modif.ChangeBounds#getNewUpper <em>New Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Upper</em>' attribute.
	 * @see #getNewUpper()
	 * @generated
	 */
	void setNewUpper(int value);

} // ChangeBounds
