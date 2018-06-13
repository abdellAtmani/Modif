/**
 */
package modif;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.AnnotationModification#getOldSource <em>Old Source</em>}</li>
 *   <li>{@link modif.AnnotationModification#getNewSource <em>New Source</em>}</li>
 *   <li>{@link modif.AnnotationModification#isRemoveEAnnotations <em>Remove EAnnotations</em>}</li>
 *   <li>{@link modif.AnnotationModification#isRemove <em>Remove</em>}</li>
 *   <li>{@link modif.AnnotationModification#getDetailsEntryModification <em>Details Entry Modification</em>}</li>
 *   <li>{@link modif.AnnotationModification#getAnnotationModification <em>Annotation Modification</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getAnnotationModification()
 * @model
 * @generated
 */
public interface AnnotationModification extends EObject {
	/**
	 * Returns the value of the '<em><b>Old Source</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Source</em>' attribute.
	 * @see #setOldSource(String)
	 * @see modif.ModifPackage#getAnnotationModification_OldSource()
	 * @model default="" required="true"
	 * @generated
	 */
	String getOldSource();

	/**
	 * Sets the value of the '{@link modif.AnnotationModification#getOldSource <em>Old Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Source</em>' attribute.
	 * @see #getOldSource()
	 * @generated
	 */
	void setOldSource(String value);

	/**
	 * Returns the value of the '<em><b>New Source</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Source</em>' attribute.
	 * @see #setNewSource(String)
	 * @see modif.ModifPackage#getAnnotationModification_NewSource()
	 * @model default=""
	 * @generated
	 */
	String getNewSource();

	/**
	 * Sets the value of the '{@link modif.AnnotationModification#getNewSource <em>New Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Source</em>' attribute.
	 * @see #getNewSource()
	 * @generated
	 */
	void setNewSource(String value);

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
	 * @see modif.ModifPackage#getAnnotationModification_RemoveEAnnotations()
	 * @model default="false"
	 * @generated
	 */
	boolean isRemoveEAnnotations();

	/**
	 * Sets the value of the '{@link modif.AnnotationModification#isRemoveEAnnotations <em>Remove EAnnotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove EAnnotations</em>' attribute.
	 * @see #isRemoveEAnnotations()
	 * @generated
	 */
	void setRemoveEAnnotations(boolean value);

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
	 * @see modif.ModifPackage#getAnnotationModification_Remove()
	 * @model default="false"
	 * @generated
	 */
	boolean isRemove();

	/**
	 * Sets the value of the '{@link modif.AnnotationModification#isRemove <em>Remove</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove</em>' attribute.
	 * @see #isRemove()
	 * @generated
	 */
	void setRemove(boolean value);

	/**
	 * Returns the value of the '<em><b>Details Entry Modification</b></em>' containment reference list.
	 * The list contents are of type {@link modif.DetailsEntryModification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Details Entry Modification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details Entry Modification</em>' containment reference list.
	 * @see modif.ModifPackage#getAnnotationModification_DetailsEntryModification()
	 * @model containment="true"
	 * @generated
	 */
	EList<DetailsEntryModification> getDetailsEntryModification();

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
	 * @see modif.ModifPackage#getAnnotationModification_AnnotationModification()
	 * @model containment="true"
	 * @generated
	 */
	EList<AnnotationModification> getAnnotationModification();

} // AnnotationModification
