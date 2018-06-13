/**
 */
package modif;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Details Entry Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.DetailsEntryModification#getOldKey <em>Old Key</em>}</li>
 *   <li>{@link modif.DetailsEntryModification#getNewKey <em>New Key</em>}</li>
 *   <li>{@link modif.DetailsEntryModification#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link modif.DetailsEntryModification#getNewValue <em>New Value</em>}</li>
 *   <li>{@link modif.DetailsEntryModification#isRemove <em>Remove</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getDetailsEntryModification()
 * @model
 * @generated
 */
public interface DetailsEntryModification extends EObject {
	/**
	 * Returns the value of the '<em><b>Old Key</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Key</em>' attribute.
	 * @see #setOldKey(String)
	 * @see modif.ModifPackage#getDetailsEntryModification_OldKey()
	 * @model default="" required="true"
	 * @generated
	 */
	String getOldKey();

	/**
	 * Sets the value of the '{@link modif.DetailsEntryModification#getOldKey <em>Old Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Key</em>' attribute.
	 * @see #getOldKey()
	 * @generated
	 */
	void setOldKey(String value);

	/**
	 * Returns the value of the '<em><b>New Key</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Key</em>' attribute.
	 * @see #setNewKey(String)
	 * @see modif.ModifPackage#getDetailsEntryModification_NewKey()
	 * @model default=""
	 * @generated
	 */
	String getNewKey();

	/**
	 * Sets the value of the '{@link modif.DetailsEntryModification#getNewKey <em>New Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Key</em>' attribute.
	 * @see #getNewKey()
	 * @generated
	 */
	void setNewKey(String value);

	/**
	 * Returns the value of the '<em><b>Old Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Value</em>' attribute.
	 * @see #setOldValue(String)
	 * @see modif.ModifPackage#getDetailsEntryModification_OldValue()
	 * @model default=""
	 * @generated
	 */
	String getOldValue();

	/**
	 * Sets the value of the '{@link modif.DetailsEntryModification#getOldValue <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Value</em>' attribute.
	 * @see #getOldValue()
	 * @generated
	 */
	void setOldValue(String value);

	/**
	 * Returns the value of the '<em><b>New Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' attribute.
	 * @see #setNewValue(String)
	 * @see modif.ModifPackage#getDetailsEntryModification_NewValue()
	 * @model default=""
	 * @generated
	 */
	String getNewValue();

	/**
	 * Sets the value of the '{@link modif.DetailsEntryModification#getNewValue <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' attribute.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(String value);

	/**
	 * Returns the value of the '<em><b>Remove</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove</em>' attribute.
	 * @see #setRemove(boolean)
	 * @see modif.ModifPackage#getDetailsEntryModification_Remove()
	 * @model default="false"
	 * @generated
	 */
	boolean isRemove();

	/**
	 * Sets the value of the '{@link modif.DetailsEntryModification#isRemove <em>Remove</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove</em>' attribute.
	 * @see #isRemove()
	 * @generated
	 */
	void setRemove(boolean value);

} // DetailsEntryModification
