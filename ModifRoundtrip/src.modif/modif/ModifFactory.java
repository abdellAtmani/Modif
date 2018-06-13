/**
 */
package modif;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see modif.ModifPackage
 * @generated
 */
public interface ModifFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifFactory eINSTANCE = modif.impl.ModifFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Modifications</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modifications</em>'.
	 * @generated
	 */
	Modifications createModifications();

	/**
	 * Returns a new object of class '<em>Package Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Package Modification</em>'.
	 * @generated
	 */
	PackageModification createPackageModification();

	/**
	 * Returns a new object of class '<em>Class Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Modification</em>'.
	 * @generated
	 */
	ClassModification createClassModification();

	/**
	 * Returns a new object of class '<em>Attribute Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Modification</em>'.
	 * @generated
	 */
	AttributeModification createAttributeModification();

	/**
	 * Returns a new object of class '<em>Reference Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Modification</em>'.
	 * @generated
	 */
	ReferenceModification createReferenceModification();

	/**
	 * Returns a new object of class '<em>Change Bounds</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Change Bounds</em>'.
	 * @generated
	 */
	ChangeBounds createChangeBounds();

	/**
	 * Returns a new object of class '<em>Data Type Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Modification</em>'.
	 * @generated
	 */
	DataTypeModification createDataTypeModification();

	/**
	 * Returns a new object of class '<em>Enum Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Modification</em>'.
	 * @generated
	 */
	EnumModification createEnumModification();

	/**
	 * Returns a new object of class '<em>Enum Literal Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal Modification</em>'.
	 * @generated
	 */
	EnumLiteralModification createEnumLiteralModification();

	/**
	 * Returns a new object of class '<em>Annotation Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation Modification</em>'.
	 * @generated
	 */
	AnnotationModification createAnnotationModification();

	/**
	 * Returns a new object of class '<em>Details Entry Modification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Details Entry Modification</em>'.
	 * @generated
	 */
	DetailsEntryModification createDetailsEntryModification();

	/**
	 * Returns a new object of class '<em>Add Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Attribute</em>'.
	 * @generated
	 */
	AddAttribute createAddAttribute();

	/**
	 * Returns a new object of class '<em>Add Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Reference</em>'.
	 * @generated
	 */
	AddReference createAddReference();

	/**
	 * Returns a new object of class '<em>Add Opposite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Opposite</em>'.
	 * @generated
	 */
	AddOpposite createAddOpposite();

	/**
	 * Returns a new object of class '<em>Add Root Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Root Class</em>'.
	 * @generated
	 */
	AddRootClass createAddRootClass();

	/**
	 * Returns a new object of class '<em>Add Name Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Name Class</em>'.
	 * @generated
	 */
	AddNameClass createAddNameClass();

	/**
	 * Returns a new object of class '<em>Add Derived Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Derived Reference</em>'.
	 * @generated
	 */
	AddDerivedReference createAddDerivedReference();

	/**
	 * Returns a new object of class '<em>Add Derived Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Derived Attribute</em>'.
	 * @generated
	 */
	AddDerivedAttribute createAddDerivedAttribute();

	/**
	 * Returns a new object of class '<em>Reference Reification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Reification</em>'.
	 * @generated
	 */
	ReferenceReification createReferenceReification();

	/**
	 * Returns a new object of class '<em>Enumerate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumerate</em>'.
	 * @generated
	 */
	Enumerate createEnumerate();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModifPackage getModifPackage();

} //ModifFactory
