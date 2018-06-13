/**
 */
package modif;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.DataTypeModification#getOldInstanceTypeName <em>Old Instance Type Name</em>}</li>
 *   <li>{@link modif.DataTypeModification#getNewInstanceTypeName <em>New Instance Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getDataTypeModification()
 * @model
 * @generated
 */
public interface DataTypeModification extends Modification {
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
	 * @see modif.ModifPackage#getDataTypeModification_OldInstanceTypeName()
	 * @model default=""
	 * @generated
	 */
	String getOldInstanceTypeName();

	/**
	 * Sets the value of the '{@link modif.DataTypeModification#getOldInstanceTypeName <em>Old Instance Type Name</em>}' attribute.
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
	 * @see modif.ModifPackage#getDataTypeModification_NewInstanceTypeName()
	 * @model default=""
	 * @generated
	 */
	String getNewInstanceTypeName();

	/**
	 * Sets the value of the '{@link modif.DataTypeModification#getNewInstanceTypeName <em>New Instance Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Instance Type Name</em>' attribute.
	 * @see #getNewInstanceTypeName()
	 * @generated
	 */
	void setNewInstanceTypeName(String value);

} // DataTypeModification
