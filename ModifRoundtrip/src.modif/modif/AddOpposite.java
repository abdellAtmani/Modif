/**
 */
package modif;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Opposite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.AddOpposite#getOppositeName <em>Opposite Name</em>}</li>
 *   <li>{@link modif.AddOpposite#getOppositeLower <em>Opposite Lower</em>}</li>
 *   <li>{@link modif.AddOpposite#getOppositeUpper <em>Opposite Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getAddOpposite()
 * @model
 * @generated
 */
public interface AddOpposite extends EObject {
	/**
	 * Returns the value of the '<em><b>Opposite Name</b></em>' attribute.
	 * The default value is <code>"_"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite Name</em>' attribute.
	 * @see #setOppositeName(String)
	 * @see modif.ModifPackage#getAddOpposite_OppositeName()
	 * @model default="_" required="true"
	 * @generated
	 */
	String getOppositeName();

	/**
	 * Sets the value of the '{@link modif.AddOpposite#getOppositeName <em>Opposite Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite Name</em>' attribute.
	 * @see #getOppositeName()
	 * @generated
	 */
	void setOppositeName(String value);

	/**
	 * Returns the value of the '<em><b>Opposite Lower</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite Lower</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite Lower</em>' attribute.
	 * @see #setOppositeLower(int)
	 * @see modif.ModifPackage#getAddOpposite_OppositeLower()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getOppositeLower();

	/**
	 * Sets the value of the '{@link modif.AddOpposite#getOppositeLower <em>Opposite Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite Lower</em>' attribute.
	 * @see #getOppositeLower()
	 * @generated
	 */
	void setOppositeLower(int value);

	/**
	 * Returns the value of the '<em><b>Opposite Upper</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite Upper</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite Upper</em>' attribute.
	 * @see #setOppositeUpper(int)
	 * @see modif.ModifPackage#getAddOpposite_OppositeUpper()
	 * @model default="-1" required="true"
	 * @generated
	 */
	int getOppositeUpper();

	/**
	 * Sets the value of the '{@link modif.AddOpposite#getOppositeUpper <em>Opposite Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opposite Upper</em>' attribute.
	 * @see #getOppositeUpper()
	 * @generated
	 */
	void setOppositeUpper(int value);

} // AddOpposite
