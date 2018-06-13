/**
 */
package modif;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Derived Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.AddDerivedAttribute#getAttributeName <em>Attribute Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getAddDerivedAttribute()
 * @model
 * @generated
 */
public interface AddDerivedAttribute extends AddDerived {
	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
	 * The default value is <code>"_"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(String)
	 * @see modif.ModifPackage#getAddDerivedAttribute_AttributeName()
	 * @model default="_" required="true"
	 * @generated
	 */
	String getAttributeName();

	/**
	 * Sets the value of the '{@link modif.AddDerivedAttribute#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(String value);

} // AddDerivedAttribute
