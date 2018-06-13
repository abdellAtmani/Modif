/**
 */
package modif;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Modification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link modif.PackageModification#getOldPrefixName <em>Old Prefix Name</em>}</li>
 *   <li>{@link modif.PackageModification#getNewPrefixName <em>New Prefix Name</em>}</li>
 *   <li>{@link modif.PackageModification#getOldURIName <em>Old URI Name</em>}</li>
 *   <li>{@link modif.PackageModification#getNewURIName <em>New URI Name</em>}</li>
 *   <li>{@link modif.PackageModification#isHide <em>Hide</em>}</li>
 *   <li>{@link modif.PackageModification#getPackageModification <em>Package Modification</em>}</li>
 *   <li>{@link modif.PackageModification#getClassModification <em>Class Modification</em>}</li>
 *   <li>{@link modif.PackageModification#getDataTypeModification <em>Data Type Modification</em>}</li>
 *   <li>{@link modif.PackageModification#getEnumModification <em>Enum Modification</em>}</li>
 * </ul>
 * </p>
 *
 * @see modif.ModifPackage#getPackageModification()
 * @model
 * @generated
 */
public interface PackageModification extends Modification {
	/**
	 * Returns the value of the '<em><b>Old Prefix Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old Prefix Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Prefix Name</em>' attribute.
	 * @see #setOldPrefixName(String)
	 * @see modif.ModifPackage#getPackageModification_OldPrefixName()
	 * @model
	 * @generated
	 */
	String getOldPrefixName();

	/**
	 * Sets the value of the '{@link modif.PackageModification#getOldPrefixName <em>Old Prefix Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Prefix Name</em>' attribute.
	 * @see #getOldPrefixName()
	 * @generated
	 */
	void setOldPrefixName(String value);

	/**
	 * Returns the value of the '<em><b>New Prefix Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Prefix Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Prefix Name</em>' attribute.
	 * @see #setNewPrefixName(String)
	 * @see modif.ModifPackage#getPackageModification_NewPrefixName()
	 * @model
	 * @generated
	 */
	String getNewPrefixName();

	/**
	 * Sets the value of the '{@link modif.PackageModification#getNewPrefixName <em>New Prefix Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Prefix Name</em>' attribute.
	 * @see #getNewPrefixName()
	 * @generated
	 */
	void setNewPrefixName(String value);

	/**
	 * Returns the value of the '<em><b>Old URI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Old URI Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old URI Name</em>' attribute.
	 * @see #setOldURIName(String)
	 * @see modif.ModifPackage#getPackageModification_OldURIName()
	 * @model
	 * @generated
	 */
	String getOldURIName();

	/**
	 * Sets the value of the '{@link modif.PackageModification#getOldURIName <em>Old URI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old URI Name</em>' attribute.
	 * @see #getOldURIName()
	 * @generated
	 */
	void setOldURIName(String value);

	/**
	 * Returns the value of the '<em><b>New URI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New URI Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New URI Name</em>' attribute.
	 * @see #setNewURIName(String)
	 * @see modif.ModifPackage#getPackageModification_NewURIName()
	 * @model
	 * @generated
	 */
	String getNewURIName();

	/**
	 * Sets the value of the '{@link modif.PackageModification#getNewURIName <em>New URI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New URI Name</em>' attribute.
	 * @see #getNewURIName()
	 * @generated
	 */
	void setNewURIName(String value);

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
	 * @see modif.ModifPackage#getPackageModification_Hide()
	 * @model default="false"
	 * @generated
	 */
	boolean isHide();

	/**
	 * Sets the value of the '{@link modif.PackageModification#isHide <em>Hide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hide</em>' attribute.
	 * @see #isHide()
	 * @generated
	 */
	void setHide(boolean value);

	/**
	 * Returns the value of the '<em><b>Package Modification</b></em>' containment reference list.
	 * The list contents are of type {@link modif.PackageModification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Modification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Modification</em>' containment reference list.
	 * @see modif.ModifPackage#getPackageModification_PackageModification()
	 * @model containment="true"
	 * @generated
	 */
	EList<PackageModification> getPackageModification();

	/**
	 * Returns the value of the '<em><b>Class Modification</b></em>' containment reference list.
	 * The list contents are of type {@link modif.ClassModification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Modification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Modification</em>' containment reference list.
	 * @see modif.ModifPackage#getPackageModification_ClassModification()
	 * @model containment="true"
	 * @generated
	 */
	EList<ClassModification> getClassModification();

	/**
	 * Returns the value of the '<em><b>Data Type Modification</b></em>' containment reference list.
	 * The list contents are of type {@link modif.DataTypeModification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type Modification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type Modification</em>' containment reference list.
	 * @see modif.ModifPackage#getPackageModification_DataTypeModification()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataTypeModification> getDataTypeModification();

	/**
	 * Returns the value of the '<em><b>Enum Modification</b></em>' containment reference list.
	 * The list contents are of type {@link modif.EnumModification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enum Modification</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enum Modification</em>' containment reference list.
	 * @see modif.ModifPackage#getPackageModification_EnumModification()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumModification> getEnumModification();

} // PackageModification
