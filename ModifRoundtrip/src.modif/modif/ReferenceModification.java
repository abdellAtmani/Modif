/**
 */
package modif;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.ReferenceModification#getChangeBounds <em>Change Bounds</em>}</li>
 *   <li>{@link modif.ReferenceModification#isChangeContainement <em>Change Containement</em>}</li>
 *   <li>{@link modif.ReferenceModification#isRemoveOpposite <em>Remove Opposite</em>}</li>
 *   <li>{@link modif.ReferenceModification#getAddOpposite <em>Add Opposite</em>}</li>
 *   <li>{@link modif.ReferenceModification#getReify <em>Reify</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getReferenceModification()
 * @model
 * @generated
 */
public interface ReferenceModification extends StructuralFeatureModification {
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
	 * @see modif.ModifPackage#getReferenceModification_ChangeBounds()
	 * @model containment="true"
	 * @generated
	 */
	ChangeBounds getChangeBounds();

	/**
	 * Sets the value of the '{@link modif.ReferenceModification#getChangeBounds <em>Change Bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Bounds</em>' containment reference.
	 * @see #getChangeBounds()
	 * @generated
	 */
	void setChangeBounds(ChangeBounds value);

	/**
	 * Returns the value of the '<em><b>Change Containement</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Containement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Containement</em>' attribute.
	 * @see #setChangeContainement(boolean)
	 * @see modif.ModifPackage#getReferenceModification_ChangeContainement()
	 * @model default="false"
	 * @generated
	 */
	boolean isChangeContainement();

	/**
	 * Sets the value of the '{@link modif.ReferenceModification#isChangeContainement <em>Change Containement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Containement</em>' attribute.
	 * @see #isChangeContainement()
	 * @generated
	 */
	void setChangeContainement(boolean value);

	/**
	 * Returns the value of the '<em><b>Remove Opposite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove Opposite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove Opposite</em>' attribute.
	 * @see #setRemoveOpposite(boolean)
	 * @see modif.ModifPackage#getReferenceModification_RemoveOpposite()
	 * @model default="false"
	 * @generated
	 */
	boolean isRemoveOpposite();

	/**
	 * Sets the value of the '{@link modif.ReferenceModification#isRemoveOpposite <em>Remove Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove Opposite</em>' attribute.
	 * @see #isRemoveOpposite()
	 * @generated
	 */
	void setRemoveOpposite(boolean value);

	/**
	 * Returns the value of the '<em><b>Add Opposite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Opposite</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Opposite</em>' containment reference.
	 * @see #setAddOpposite(AddOpposite)
	 * @see modif.ModifPackage#getReferenceModification_AddOpposite()
	 * @model containment="true"
	 * @generated
	 */
	AddOpposite getAddOpposite();

	/**
	 * Sets the value of the '{@link modif.ReferenceModification#getAddOpposite <em>Add Opposite</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Opposite</em>' containment reference.
	 * @see #getAddOpposite()
	 * @generated
	 */
	void setAddOpposite(AddOpposite value);

	/**
	 * Returns the value of the '<em><b>Reify</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reify</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reify</em>' containment reference.
	 * @see #setReify(ReferenceReification)
	 * @see modif.ModifPackage#getReferenceModification_Reify()
	 * @model containment="true"
	 * @generated
	 */
	ReferenceReification getReify();

	/**
	 * Sets the value of the '{@link modif.ReferenceModification#getReify <em>Reify</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reify</em>' containment reference.
	 * @see #getReify()
	 * @generated
	 */
	void setReify(ReferenceReification value);

} // ReferenceModification
