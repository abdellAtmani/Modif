/**
 */
package modif;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.EnumModification#getOldInstanceTypeName <em>Old Instance Type Name</em>}</li>
 *   <li>{@link modif.EnumModification#getNewInstanceTypeName <em>New Instance Type Name</em>}</li>
 *   <li>{@link modif.EnumModification#isReify <em>Reify</em>}</li>
 *   <li>{@link modif.EnumModification#getEnumLiteralModification <em>Enum Literal Modification</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getEnumModification()
 * @model
 * @generated
 */
public interface EnumModification extends Modification {
	/**
	 * Returns the value of the '<em><b>Old Instance Type Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Instance Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Instance Type Name</em>' attribute.
	 * @see #setOldInstanceTypeName(String)
	 * @see modif.ModifPackage#getEnumModification_OldInstanceTypeName()
	 * @model default=""
	 * @generated
	 */
	String getOldInstanceTypeName();

	/**
	 * Sets the value of the '{@link modif.EnumModification#getOldInstanceTypeName <em>Old Instance Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Instance Type Name</em>' attribute.
	 * @see #getOldInstanceTypeName()
	 * @generated
	 */
	void setOldInstanceTypeName(String value);

	/**
	 * Returns the value of the '<em><b>New Instance Type Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Instance Type Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Instance Type Name</em>' attribute.
	 * @see #setNewInstanceTypeName(String)
	 * @see modif.ModifPackage#getEnumModification_NewInstanceTypeName()
	 * @model default=""
	 * @generated
	 */
	String getNewInstanceTypeName();

	/**
	 * Sets the value of the '{@link modif.EnumModification#getNewInstanceTypeName <em>New Instance Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Instance Type Name</em>' attribute.
	 * @see #getNewInstanceTypeName()
	 * @generated
	 */
	void setNewInstanceTypeName(String value);

	/**
	 * Returns the value of the '<em><b>Reify</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reify</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reify</em>' attribute.
	 * @see #setReify(boolean)
	 * @see modif.ModifPackage#getEnumModification_Reify()
	 * @model default="false"
	 * @generated
	 */
	boolean isReify();

	/**
	 * Sets the value of the '{@link modif.EnumModification#isReify <em>Reify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reify</em>' attribute.
	 * @see #isReify()
	 * @generated
	 */
	void setReify(boolean value);

	/**
	 * Returns the value of the '<em><b>Enum Literal Modification</b></em>' containment reference list.
	 * The list contents are of type {@link modif.EnumLiteralModification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Literal Modification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Literal Modification</em>' containment reference list.
	 * @see modif.ModifPackage#getEnumModification_EnumLiteralModification()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumLiteralModification> getEnumLiteralModification();

} // EnumModification
