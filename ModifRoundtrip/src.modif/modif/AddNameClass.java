/**
 */
package modif;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Name Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.AddNameClass#getName <em>Name</em>}</li>
 *   <li>{@link modif.AddNameClass#getNameName <em>Name Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getAddNameClass()
 * @model
 * @generated
 */
public interface AddNameClass extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>"NamedElement"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see modif.ModifPackage#getAddNameClass_Name()
	 * @model default="NamedElement" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link modif.AddNameClass#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Name Name</b></em>' attribute.
	 * The default value is <code>"name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Name</em>' attribute.
	 * @see #setNameName(String)
	 * @see modif.ModifPackage#getAddNameClass_NameName()
	 * @model default="name" required="true"
	 * @generated
	 */
	String getNameName();

	/**
	 * Sets the value of the '{@link modif.AddNameClass#getNameName <em>Name Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Name</em>' attribute.
	 * @see #getNameName()
	 * @generated
	 */
	void setNameName(String value);

} // AddNameClass
