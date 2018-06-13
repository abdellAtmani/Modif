/**
 */
package modif;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.Modification#getOldName <em>Old Name</em>}</li>
 *   <li>{@link modif.Modification#getNewName <em>New Name</em>}</li>
 *   <li>{@link modif.Modification#isRemove <em>Remove</em>}</li>
 *   <li>{@link modif.Modification#isRemoveEAnnotations <em>Remove EAnnotations</em>}</li>
 *   <li>{@link modif.Modification#getAnnotationModification <em>Annotation Modification</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getModification()
 * @model abstract="true"
 * @generated
 */
public interface Modification extends EObject {
	/**
	 * Returns the value of the '<em><b>Old Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Name</em>' attribute.
	 * @see #setOldName(String)
	 * @see modif.ModifPackage#getModification_OldName()
	 * @model default="" required="true"
	 * @generated
	 */
	String getOldName();

	/**
	 * Sets the value of the '{@link modif.Modification#getOldName <em>Old Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Name</em>' attribute.
	 * @see #getOldName()
	 * @generated
	 */
	void setOldName(String value);

	/**
	 * Returns the value of the '<em><b>New Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Name</em>' attribute.
	 * @see #setNewName(String)
	 * @see modif.ModifPackage#getModification_NewName()
	 * @model default=""
	 * @generated
	 */
	String getNewName();

	/**
	 * Sets the value of the '{@link modif.Modification#getNewName <em>New Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Name</em>' attribute.
	 * @see #getNewName()
	 * @generated
	 */
	void setNewName(String value);

	/**
	 * Returns the value of the '<em><b>Remove</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove</em>' attribute.
	 * @see #setRemove(boolean)
	 * @see modif.ModifPackage#getModification_Remove()
	 * @model default="false"
	 * @generated
	 */
	boolean isRemove();

	/**
	 * Sets the value of the '{@link modif.Modification#isRemove <em>Remove</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove</em>' attribute.
	 * @see #isRemove()
	 * @generated
	 */
	void setRemove(boolean value);

	/**
	 * Returns the value of the '<em><b>Remove EAnnotations</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove EAnnotations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove EAnnotations</em>' attribute.
	 * @see #setRemoveEAnnotations(boolean)
	 * @see modif.ModifPackage#getModification_RemoveEAnnotations()
	 * @model default="false"
	 * @generated
	 */
	boolean isRemoveEAnnotations();

	/**
	 * Sets the value of the '{@link modif.Modification#isRemoveEAnnotations <em>Remove EAnnotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove EAnnotations</em>' attribute.
	 * @see #isRemoveEAnnotations()
	 * @generated
	 */
	void setRemoveEAnnotations(boolean value);

	/**
	 * Returns the value of the '<em><b>Annotation Modification</b></em>' containment reference list.
	 * The list contents are of type {@link modif.AnnotationModification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation Modification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation Modification</em>' containment reference list.
	 * @see modif.ModifPackage#getModification_AnnotationModification()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnnotationModification> getAnnotationModification();

} // Modification
