/**
 */
package modif;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modifications</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.Modifications#getRootPackageModification <em>Root Package Modification</em>}</li>
 *   <li>{@link modif.Modifications#getAddRootClass <em>Add Root Class</em>}</li>
 *   <li>{@link modif.Modifications#getAddNameClass <em>Add Name Class</em>}</li>
 *   <li>{@link modif.Modifications#isRemoveAllAnnotations <em>Remove All Annotations</em>}</li>
 *   <li>{@link modif.Modifications#isRemoveAllOperations <em>Remove All Operations</em>}</li>
 *   <li>{@link modif.Modifications#isRemoveAllEStringAttributes <em>Remove All EString Attributes</em>}</li>
 *   <li>{@link modif.Modifications#isRemoveAllOpposites <em>Remove All Opposites</em>}</li>
 *   <li>{@link modif.Modifications#isAddAllOpposite <em>Add All Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getModifications()
 * @model
 * @generated
 */
public interface Modifications extends EObject {
	/**
	 * Returns the value of the '<em><b>Root Package Modification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Package Modification</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Package Modification</em>' containment reference.
	 * @see #setRootPackageModification(PackageModification)
	 * @see modif.ModifPackage#getModifications_RootPackageModification()
	 * @model containment="true"
	 * @generated
	 */
	PackageModification getRootPackageModification();

	/**
	 * Sets the value of the '{@link modif.Modifications#getRootPackageModification <em>Root Package Modification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Package Modification</em>' containment reference.
	 * @see #getRootPackageModification()
	 * @generated
	 */
	void setRootPackageModification(PackageModification value);

	/**
	 * Returns the value of the '<em><b>Add Root Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Root Class</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Root Class</em>' containment reference.
	 * @see #setAddRootClass(AddRootClass)
	 * @see modif.ModifPackage#getModifications_AddRootClass()
	 * @model containment="true"
	 * @generated
	 */
	AddRootClass getAddRootClass();

	/**
	 * Sets the value of the '{@link modif.Modifications#getAddRootClass <em>Add Root Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Root Class</em>' containment reference.
	 * @see #getAddRootClass()
	 * @generated
	 */
	void setAddRootClass(AddRootClass value);

	/**
	 * Returns the value of the '<em><b>Add Name Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Name Class</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Name Class</em>' containment reference.
	 * @see #setAddNameClass(AddNameClass)
	 * @see modif.ModifPackage#getModifications_AddNameClass()
	 * @model containment="true"
	 * @generated
	 */
	AddNameClass getAddNameClass();

	/**
	 * Sets the value of the '{@link modif.Modifications#getAddNameClass <em>Add Name Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Name Class</em>' containment reference.
	 * @see #getAddNameClass()
	 * @generated
	 */
	void setAddNameClass(AddNameClass value);

	/**
	 * Returns the value of the '<em><b>Remove All Annotations</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove All Annotations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove All Annotations</em>' attribute.
	 * @see #setRemoveAllAnnotations(boolean)
	 * @see modif.ModifPackage#getModifications_RemoveAllAnnotations()
	 * @model default="false"
	 * @generated
	 */
	boolean isRemoveAllAnnotations();

	/**
	 * Sets the value of the '{@link modif.Modifications#isRemoveAllAnnotations <em>Remove All Annotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove All Annotations</em>' attribute.
	 * @see #isRemoveAllAnnotations()
	 * @generated
	 */
	void setRemoveAllAnnotations(boolean value);

	/**
	 * Returns the value of the '<em><b>Remove All Operations</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove All Operations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove All Operations</em>' attribute.
	 * @see #setRemoveAllOperations(boolean)
	 * @see modif.ModifPackage#getModifications_RemoveAllOperations()
	 * @model default="false"
	 * @generated
	 */
	boolean isRemoveAllOperations();

	/**
	 * Sets the value of the '{@link modif.Modifications#isRemoveAllOperations <em>Remove All Operations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove All Operations</em>' attribute.
	 * @see #isRemoveAllOperations()
	 * @generated
	 */
	void setRemoveAllOperations(boolean value);

	/**
	 * Returns the value of the '<em><b>Remove All EString Attributes</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove All EString Attributes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove All EString Attributes</em>' attribute.
	 * @see #setRemoveAllEStringAttributes(boolean)
	 * @see modif.ModifPackage#getModifications_RemoveAllEStringAttributes()
	 * @model default="false"
	 * @generated
	 */
	boolean isRemoveAllEStringAttributes();

	/**
	 * Sets the value of the '{@link modif.Modifications#isRemoveAllEStringAttributes <em>Remove All EString Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove All EString Attributes</em>' attribute.
	 * @see #isRemoveAllEStringAttributes()
	 * @generated
	 */
	void setRemoveAllEStringAttributes(boolean value);

	/**
	 * Returns the value of the '<em><b>Remove All Opposites</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove All Opposites</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove All Opposites</em>' attribute.
	 * @see #setRemoveAllOpposites(boolean)
	 * @see modif.ModifPackage#getModifications_RemoveAllOpposites()
	 * @model default="false"
	 * @generated
	 */
	boolean isRemoveAllOpposites();

	/**
	 * Sets the value of the '{@link modif.Modifications#isRemoveAllOpposites <em>Remove All Opposites</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove All Opposites</em>' attribute.
	 * @see #isRemoveAllOpposites()
	 * @generated
	 */
	void setRemoveAllOpposites(boolean value);

	/**
	 * Returns the value of the '<em><b>Add All Opposite</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add All Opposite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add All Opposite</em>' attribute.
	 * @see #setAddAllOpposite(boolean)
	 * @see modif.ModifPackage#getModifications_AddAllOpposite()
	 * @model default="false"
	 * @generated
	 */
	boolean isAddAllOpposite();

	/**
	 * Sets the value of the '{@link modif.Modifications#isAddAllOpposite <em>Add All Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add All Opposite</em>' attribute.
	 * @see #isAddAllOpposite()
	 * @generated
	 */
	void setAddAllOpposite(boolean value);

} // Modifications
