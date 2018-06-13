/**
 */
package modif;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.ClassModification#isChangeAbstract <em>Change Abstract</em>}</li>
 *   <li>{@link modif.ClassModification#isHide <em>Hide</em>}</li>
 *   <li>{@link modif.ClassModification#isFlatten <em>Flatten</em>}</li>
 *   <li>{@link modif.ClassModification#isFlattenAll <em>Flatten All</em>}</li>
 *   <li>{@link modif.ClassModification#getFeatureModification <em>Feature Modification</em>}</li>
 *   <li>{@link modif.ClassModification#getAddFeatures <em>Add Features</em>}</li>
 *   <li>{@link modif.ClassModification#getAddDeriveds <em>Add Deriveds</em>}</li>
 *   <li>{@link modif.ClassModification#getEnumerate <em>Enumerate</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getClassModification()
 * @model
 * @generated
 */
public interface ClassModification extends Modification {
	/**
	 * Returns the value of the '<em><b>Change Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Abstract</em>' attribute.
	 * @see #setChangeAbstract(boolean)
	 * @see modif.ModifPackage#getClassModification_ChangeAbstract()
	 * @model default="false"
	 * @generated
	 */
	boolean isChangeAbstract();

	/**
	 * Sets the value of the '{@link modif.ClassModification#isChangeAbstract <em>Change Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Abstract</em>' attribute.
	 * @see #isChangeAbstract()
	 * @generated
	 */
	void setChangeAbstract(boolean value);

	/**
	 * Returns the value of the '<em><b>Hide</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hide</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hide</em>' attribute.
	 * @see #setHide(boolean)
	 * @see modif.ModifPackage#getClassModification_Hide()
	 * @model default="false"
	 * @generated
	 */
	boolean isHide();

	/**
	 * Sets the value of the '{@link modif.ClassModification#isHide <em>Hide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide</em>' attribute.
	 * @see #isHide()
	 * @generated
	 */
	void setHide(boolean value);

	/**
	 * Returns the value of the '<em><b>Flatten</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flatten</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flatten</em>' attribute.
	 * @see #setFlatten(boolean)
	 * @see modif.ModifPackage#getClassModification_Flatten()
	 * @model default="false"
	 * @generated
	 */
	boolean isFlatten();

	/**
	 * Sets the value of the '{@link modif.ClassModification#isFlatten <em>Flatten</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flatten</em>' attribute.
	 * @see #isFlatten()
	 * @generated
	 */
	void setFlatten(boolean value);

	/**
	 * Returns the value of the '<em><b>Flatten All</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flatten All</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flatten All</em>' attribute.
	 * @see #setFlattenAll(boolean)
	 * @see modif.ModifPackage#getClassModification_FlattenAll()
	 * @model default="false"
	 * @generated
	 */
	boolean isFlattenAll();

	/**
	 * Sets the value of the '{@link modif.ClassModification#isFlattenAll <em>Flatten All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Flatten All</em>' attribute.
	 * @see #isFlattenAll()
	 * @generated
	 */
	void setFlattenAll(boolean value);

	/**
	 * Returns the value of the '<em><b>Feature Modification</b></em>' containment reference list.
	 * The list contents are of type {@link modif.StructuralFeatureModification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Modification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Modification</em>' containment reference list.
	 * @see modif.ModifPackage#getClassModification_FeatureModification()
	 * @model containment="true"
	 * @generated
	 */
	EList<StructuralFeatureModification> getFeatureModification();

	/**
	 * Returns the value of the '<em><b>Add Features</b></em>' containment reference list.
	 * The list contents are of type {@link modif.AddFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Features</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Features</em>' containment reference list.
	 * @see modif.ModifPackage#getClassModification_AddFeatures()
	 * @model containment="true"
	 * @generated
	 */
	EList<AddFeature> getAddFeatures();

	/**
	 * Returns the value of the '<em><b>Add Deriveds</b></em>' containment reference list.
	 * The list contents are of type {@link modif.AddDerived}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Deriveds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Deriveds</em>' containment reference list.
	 * @see modif.ModifPackage#getClassModification_AddDeriveds()
	 * @model containment="true"
	 * @generated
	 */
	EList<AddDerived> getAddDeriveds();

	/**
	 * Returns the value of the '<em><b>Enumerate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumerate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumerate</em>' containment reference.
	 * @see #setEnumerate(Enumerate)
	 * @see modif.ModifPackage#getClassModification_Enumerate()
	 * @model containment="true"
	 * @generated
	 */
	Enumerate getEnumerate();

	/**
	 * Sets the value of the '{@link modif.ClassModification#getEnumerate <em>Enumerate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumerate</em>' containment reference.
	 * @see #getEnumerate()
	 * @generated
	 */
	void setEnumerate(Enumerate value);

} // ClassModification
