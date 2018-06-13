/**
 */
package modif;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumerate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.Enumerate#getEnumName <em>Enum Name</em>}</li>
 *   <li>{@link modif.Enumerate#getAttributeName <em>Attribute Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getEnumerate()
 * @model
 * @generated
 */
public interface Enumerate extends EObject {
	/**
	 * Returns the value of the '<em><b>Enum Name</b></em>' attribute.
	 * The default value is <code>"enumClass"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Name</em>' attribute.
	 * @see #setEnumName(String)
	 * @see modif.ModifPackage#getEnumerate_EnumName()
	 * @model default="enumClass" required="true"
	 * @generated
	 */
	String getEnumName();

	/**
	 * Sets the value of the '{@link modif.Enumerate#getEnumName <em>Enum Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enum Name</em>' attribute.
	 * @see #getEnumName()
	 * @generated
	 */
	void setEnumName(String value);

	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
	 * The default value is <code>"enumAttribute"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(String)
	 * @see modif.ModifPackage#getEnumerate_AttributeName()
	 * @model default="enumAttribute" required="true"
	 * @generated
	 */
	String getAttributeName();

	/**
	 * Sets the value of the '{@link modif.Enumerate#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(String value);

} // Enumerate
