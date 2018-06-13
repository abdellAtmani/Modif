/**
 */
package modif;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.EnumLiteralModification#getOldLiteral <em>Old Literal</em>}</li>
 *   <li>{@link modif.EnumLiteralModification#getNewLiteral <em>New Literal</em>}</li>
 *   <li>{@link modif.EnumLiteralModification#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link modif.EnumLiteralModification#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getEnumLiteralModification()
 * @model
 * @generated
 */
public interface EnumLiteralModification extends Modification {
	/**
	 * Returns the value of the '<em><b>Old Literal</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Literal</em>' attribute.
	 * @see #setOldLiteral(String)
	 * @see modif.ModifPackage#getEnumLiteralModification_OldLiteral()
	 * @model default=""
	 * @generated
	 */
	String getOldLiteral();

	/**
	 * Sets the value of the '{@link modif.EnumLiteralModification#getOldLiteral <em>Old Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Literal</em>' attribute.
	 * @see #getOldLiteral()
	 * @generated
	 */
	void setOldLiteral(String value);

	/**
	 * Returns the value of the '<em><b>New Literal</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Literal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Literal</em>' attribute.
	 * @see #setNewLiteral(String)
	 * @see modif.ModifPackage#getEnumLiteralModification_NewLiteral()
	 * @model default=""
	 * @generated
	 */
	String getNewLiteral();

	/**
	 * Sets the value of the '{@link modif.EnumLiteralModification#getNewLiteral <em>New Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Literal</em>' attribute.
	 * @see #getNewLiteral()
	 * @generated
	 */
	void setNewLiteral(String value);

	/**
	 * Returns the value of the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Value</em>' attribute.
	 * @see #setOldValue(int)
	 * @see modif.ModifPackage#getEnumLiteralModification_OldValue()
	 * @model
	 * @generated
	 */
	int getOldValue();

	/**
	 * Sets the value of the '{@link modif.EnumLiteralModification#getOldValue <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Value</em>' attribute.
	 * @see #getOldValue()
	 * @generated
	 */
	void setOldValue(int value);

	/**
	 * Returns the value of the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' attribute.
	 * @see #setNewValue(int)
	 * @see modif.ModifPackage#getEnumLiteralModification_NewValue()
	 * @model
	 * @generated
	 */
	int getNewValue();

	/**
	 * Sets the value of the '{@link modif.EnumLiteralModification#getNewValue <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' attribute.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(int value);

} // EnumLiteralModification
