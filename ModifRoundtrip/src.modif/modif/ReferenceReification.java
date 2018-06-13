/**
 */
package modif;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Reification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.ReferenceReification#getNameClass <em>Name Class</em>}</li>
 *   <li>{@link modif.ReferenceReification#getNameFirstReference <em>Name First Reference</em>}</li>
 *   <li>{@link modif.ReferenceReification#getNameSecondReference <em>Name Second Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getReferenceReification()
 * @model
 * @generated
 */
public interface ReferenceReification extends EObject {
	/**
	 * Returns the value of the '<em><b>Name Class</b></em>' attribute.
	 * The default value is <code>"NameClassReference"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Class</em>' attribute.
	 * @see #setNameClass(String)
	 * @see modif.ModifPackage#getReferenceReification_NameClass()
	 * @model default="NameClassReference" required="true"
	 * @generated
	 */
	String getNameClass();

	/**
	 * Sets the value of the '{@link modif.ReferenceReification#getNameClass <em>Name Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Class</em>' attribute.
	 * @see #getNameClass()
	 * @generated
	 */
	void setNameClass(String value);

	/**
	 * Returns the value of the '<em><b>Name First Reference</b></em>' attribute.
	 * The default value is <code>"nameFrom"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name First Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name First Reference</em>' attribute.
	 * @see #setNameFirstReference(String)
	 * @see modif.ModifPackage#getReferenceReification_NameFirstReference()
	 * @model default="nameFrom" required="true"
	 * @generated
	 */
	String getNameFirstReference();

	/**
	 * Sets the value of the '{@link modif.ReferenceReification#getNameFirstReference <em>Name First Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name First Reference</em>' attribute.
	 * @see #getNameFirstReference()
	 * @generated
	 */
	void setNameFirstReference(String value);

	/**
	 * Returns the value of the '<em><b>Name Second Reference</b></em>' attribute.
	 * The default value is <code>"nameTo"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name Second Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Second Reference</em>' attribute.
	 * @see #setNameSecondReference(String)
	 * @see modif.ModifPackage#getReferenceReification_NameSecondReference()
	 * @model default="nameTo" required="true"
	 * @generated
	 */
	String getNameSecondReference();

	/**
	 * Sets the value of the '{@link modif.ReferenceReification#getNameSecondReference <em>Name Second Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Second Reference</em>' attribute.
	 * @see #getNameSecondReference()
	 * @generated
	 */
	void setNameSecondReference(String value);

} // ReferenceReification
