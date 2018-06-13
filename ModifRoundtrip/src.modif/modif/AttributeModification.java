/**
 */
package modif;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.AttributeModification#isChangeType <em>Change Type</em>}</li>
 *   <li>{@link modif.AttributeModification#getNewType <em>New Type</em>}</li>
 *   <li>{@link modif.AttributeModification#getChangeBounds <em>Change Bounds</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getAttributeModification()
 * @model
 * @generated
 */
public interface AttributeModification extends StructuralFeatureModification {
	/**
	 * Returns the value of the '<em><b>Change Type</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Type</em>' attribute.
	 * @see #setChangeType(boolean)
	 * @see modif.ModifPackage#getAttributeModification_ChangeType()
	 * @model default="false"
	 * @generated
	 */
	boolean isChangeType();

	/**
	 * Sets the value of the '{@link modif.AttributeModification#isChangeType <em>Change Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Type</em>' attribute.
	 * @see #isChangeType()
	 * @generated
	 */
	void setChangeType(boolean value);

	/**
	 * Returns the value of the '<em><b>New Type</b></em>' attribute.
	 * The default value is <code>"int"</code>.
	 * The literals are from the enumeration {@link modif.PrimitiveType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Type</em>' attribute.
	 * @see modif.PrimitiveType
	 * @see #setNewType(PrimitiveType)
	 * @see modif.ModifPackage#getAttributeModification_NewType()
	 * @model default="int"
	 * @generated
	 */
	PrimitiveType getNewType();

	/**
	 * Sets the value of the '{@link modif.AttributeModification#getNewType <em>New Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Type</em>' attribute.
	 * @see modif.PrimitiveType
	 * @see #getNewType()
	 * @generated
	 */
	void setNewType(PrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Change Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Bounds</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Bounds</em>' containment reference.
	 * @see #setChangeBounds(ChangeBounds)
	 * @see modif.ModifPackage#getAttributeModification_ChangeBounds()
	 * @model containment="true"
	 * @generated
	 */
	ChangeBounds getChangeBounds();

	/**
	 * Sets the value of the '{@link modif.AttributeModification#getChangeBounds <em>Change Bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Bounds</em>' containment reference.
	 * @see #getChangeBounds()
	 * @generated
	 */
	void setChangeBounds(ChangeBounds value);

} // AttributeModification
