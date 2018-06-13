/**
 */
package modif;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see modif.ModifFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface ModifPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modif";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fr.ubo.mde.babau.modif";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fr.ubo.mde.babau.modif";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModifPackage eINSTANCE = modif.impl.ModifPackageImpl.init();

	/**
	 * The meta object id for the '{@link modif.impl.ModificationsImpl <em>Modifications</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.ModificationsImpl
	 * @see modif.impl.ModifPackageImpl#getModifications()
	 * @generated
	 */
	int MODIFICATIONS = 0;

	/**
	 * The feature id for the '<em><b>Root Package Modification</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS__ROOT_PACKAGE_MODIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Add Root Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS__ADD_ROOT_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Add Name Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS__ADD_NAME_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Remove All Annotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS__REMOVE_ALL_ANNOTATIONS = 3;

	/**
	 * The feature id for the '<em><b>Remove All Operations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS__REMOVE_ALL_OPERATIONS = 4;

	/**
	 * The feature id for the '<em><b>Remove All EString Attributes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS__REMOVE_ALL_ESTRING_ATTRIBUTES = 5;

	/**
	 * The feature id for the '<em><b>Remove All Opposites</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS__REMOVE_ALL_OPPOSITES = 6;

	/**
	 * The feature id for the '<em><b>Add All Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS__ADD_ALL_OPPOSITE = 7;

	/**
	 * The number of structural features of the '<em>Modifications</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Modifications</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATIONS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.impl.ModificationImpl <em>Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.ModificationImpl
	 * @see modif.impl.ModifPackageImpl#getModification()
	 * @generated
	 */
	int MODIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Old Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__OLD_NAME = 0;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__NEW_NAME = 1;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__REMOVE = 2;

	/**
	 * The feature id for the '<em><b>Remove EAnnotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__REMOVE_EANNOTATIONS = 3;

	/**
	 * The feature id for the '<em><b>Annotation Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION__ANNOTATION_MODIFICATION = 4;

	/**
	 * The number of structural features of the '<em>Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.impl.PackageModificationImpl <em>Package Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.PackageModificationImpl
	 * @see modif.impl.ModifPackageImpl#getPackageModification()
	 * @generated
	 */
	int PACKAGE_MODIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Old Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__OLD_NAME = MODIFICATION__OLD_NAME;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__NEW_NAME = MODIFICATION__NEW_NAME;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__REMOVE = MODIFICATION__REMOVE;

	/**
	 * The feature id for the '<em><b>Remove EAnnotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__REMOVE_EANNOTATIONS = MODIFICATION__REMOVE_EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__ANNOTATION_MODIFICATION = MODIFICATION__ANNOTATION_MODIFICATION;

	/**
	 * The feature id for the '<em><b>Old Prefix Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__OLD_PREFIX_NAME = MODIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Prefix Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__NEW_PREFIX_NAME = MODIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Old URI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__OLD_URI_NAME = MODIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>New URI Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__NEW_URI_NAME = MODIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__HIDE = MODIFICATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Package Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__PACKAGE_MODIFICATION = MODIFICATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Class Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__CLASS_MODIFICATION = MODIFICATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Data Type Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__DATA_TYPE_MODIFICATION = MODIFICATION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Enum Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION__ENUM_MODIFICATION = MODIFICATION_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Package Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION_FEATURE_COUNT = MODIFICATION_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Package Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_MODIFICATION_OPERATION_COUNT = MODIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.ClassModificationImpl <em>Class Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.ClassModificationImpl
	 * @see modif.impl.ModifPackageImpl#getClassModification()
	 * @generated
	 */
	int CLASS_MODIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Old Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__OLD_NAME = MODIFICATION__OLD_NAME;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__NEW_NAME = MODIFICATION__NEW_NAME;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__REMOVE = MODIFICATION__REMOVE;

	/**
	 * The feature id for the '<em><b>Remove EAnnotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__REMOVE_EANNOTATIONS = MODIFICATION__REMOVE_EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__ANNOTATION_MODIFICATION = MODIFICATION__ANNOTATION_MODIFICATION;

	/**
	 * The feature id for the '<em><b>Change Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__CHANGE_ABSTRACT = MODIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hide</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__HIDE = MODIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Flatten</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__FLATTEN = MODIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Flatten All</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__FLATTEN_ALL = MODIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Feature Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__FEATURE_MODIFICATION = MODIFICATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Add Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__ADD_FEATURES = MODIFICATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Add Deriveds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__ADD_DERIVEDS = MODIFICATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Enumerate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION__ENUMERATE = MODIFICATION_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Class Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION_FEATURE_COUNT = MODIFICATION_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Class Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MODIFICATION_OPERATION_COUNT = MODIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.StructuralFeatureModificationImpl <em>Structural Feature Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.StructuralFeatureModificationImpl
	 * @see modif.impl.ModifPackageImpl#getStructuralFeatureModification()
	 * @generated
	 */
	int STRUCTURAL_FEATURE_MODIFICATION = 4;

	/**
	 * The feature id for the '<em><b>Old Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_MODIFICATION__OLD_NAME = MODIFICATION__OLD_NAME;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_MODIFICATION__NEW_NAME = MODIFICATION__NEW_NAME;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_MODIFICATION__REMOVE = MODIFICATION__REMOVE;

	/**
	 * The feature id for the '<em><b>Remove EAnnotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_MODIFICATION__REMOVE_EANNOTATIONS = MODIFICATION__REMOVE_EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_MODIFICATION__ANNOTATION_MODIFICATION = MODIFICATION__ANNOTATION_MODIFICATION;

	/**
	 * The number of structural features of the '<em>Structural Feature Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_MODIFICATION_FEATURE_COUNT = MODIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Structural Feature Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_FEATURE_MODIFICATION_OPERATION_COUNT = MODIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.AttributeModificationImpl <em>Attribute Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.AttributeModificationImpl
	 * @see modif.impl.ModifPackageImpl#getAttributeModification()
	 * @generated
	 */
	int ATTRIBUTE_MODIFICATION = 5;

	/**
	 * The feature id for the '<em><b>Old Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MODIFICATION__OLD_NAME = STRUCTURAL_FEATURE_MODIFICATION__OLD_NAME;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MODIFICATION__NEW_NAME = STRUCTURAL_FEATURE_MODIFICATION__NEW_NAME;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MODIFICATION__REMOVE = STRUCTURAL_FEATURE_MODIFICATION__REMOVE;

	/**
	 * The feature id for the '<em><b>Remove EAnnotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MODIFICATION__REMOVE_EANNOTATIONS = STRUCTURAL_FEATURE_MODIFICATION__REMOVE_EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MODIFICATION__ANNOTATION_MODIFICATION = STRUCTURAL_FEATURE_MODIFICATION__ANNOTATION_MODIFICATION;

	/**
	 * The feature id for the '<em><b>Change Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MODIFICATION__CHANGE_TYPE = STRUCTURAL_FEATURE_MODIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MODIFICATION__NEW_TYPE = STRUCTURAL_FEATURE_MODIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Change Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS = STRUCTURAL_FEATURE_MODIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MODIFICATION_FEATURE_COUNT = STRUCTURAL_FEATURE_MODIFICATION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Attribute Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_MODIFICATION_OPERATION_COUNT = STRUCTURAL_FEATURE_MODIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.ReferenceModificationImpl <em>Reference Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.ReferenceModificationImpl
	 * @see modif.impl.ModifPackageImpl#getReferenceModification()
	 * @generated
	 */
	int REFERENCE_MODIFICATION = 6;

	/**
	 * The feature id for the '<em><b>Old Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION__OLD_NAME = STRUCTURAL_FEATURE_MODIFICATION__OLD_NAME;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION__NEW_NAME = STRUCTURAL_FEATURE_MODIFICATION__NEW_NAME;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION__REMOVE = STRUCTURAL_FEATURE_MODIFICATION__REMOVE;

	/**
	 * The feature id for the '<em><b>Remove EAnnotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION__REMOVE_EANNOTATIONS = STRUCTURAL_FEATURE_MODIFICATION__REMOVE_EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION__ANNOTATION_MODIFICATION = STRUCTURAL_FEATURE_MODIFICATION__ANNOTATION_MODIFICATION;

	/**
	 * The feature id for the '<em><b>Change Bounds</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION__CHANGE_BOUNDS = STRUCTURAL_FEATURE_MODIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Change Containement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION__CHANGE_CONTAINEMENT = STRUCTURAL_FEATURE_MODIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Remove Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION__REMOVE_OPPOSITE = STRUCTURAL_FEATURE_MODIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Add Opposite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION__ADD_OPPOSITE = STRUCTURAL_FEATURE_MODIFICATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Reify</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION__REIFY = STRUCTURAL_FEATURE_MODIFICATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Reference Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION_FEATURE_COUNT = STRUCTURAL_FEATURE_MODIFICATION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Reference Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_MODIFICATION_OPERATION_COUNT = STRUCTURAL_FEATURE_MODIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.ChangeBoundsImpl <em>Change Bounds</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.ChangeBoundsImpl
	 * @see modif.impl.ModifPackageImpl#getChangeBounds()
	 * @generated
	 */
	int CHANGE_BOUNDS = 7;

	/**
	 * The feature id for the '<em><b>Old Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_BOUNDS__OLD_LOWER = 0;

	/**
	 * The feature id for the '<em><b>New Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_BOUNDS__NEW_LOWER = 1;

	/**
	 * The feature id for the '<em><b>Old Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_BOUNDS__OLD_UPPER = 2;

	/**
	 * The feature id for the '<em><b>New Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_BOUNDS__NEW_UPPER = 3;

	/**
	 * The number of structural features of the '<em>Change Bounds</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_BOUNDS_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Change Bounds</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_BOUNDS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.impl.DataTypeModificationImpl <em>Data Type Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.DataTypeModificationImpl
	 * @see modif.impl.ModifPackageImpl#getDataTypeModification()
	 * @generated
	 */
	int DATA_TYPE_MODIFICATION = 8;

	/**
	 * The feature id for the '<em><b>Old Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_MODIFICATION__OLD_NAME = MODIFICATION__OLD_NAME;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_MODIFICATION__NEW_NAME = MODIFICATION__NEW_NAME;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_MODIFICATION__REMOVE = MODIFICATION__REMOVE;

	/**
	 * The feature id for the '<em><b>Remove EAnnotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_MODIFICATION__REMOVE_EANNOTATIONS = MODIFICATION__REMOVE_EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_MODIFICATION__ANNOTATION_MODIFICATION = MODIFICATION__ANNOTATION_MODIFICATION;

	/**
	 * The feature id for the '<em><b>Old Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_MODIFICATION__OLD_INSTANCE_TYPE_NAME = MODIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_MODIFICATION__NEW_INSTANCE_TYPE_NAME = MODIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Type Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_MODIFICATION_FEATURE_COUNT = MODIFICATION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Type Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_MODIFICATION_OPERATION_COUNT = MODIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.EnumModificationImpl <em>Enum Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.EnumModificationImpl
	 * @see modif.impl.ModifPackageImpl#getEnumModification()
	 * @generated
	 */
	int ENUM_MODIFICATION = 9;

	/**
	 * The feature id for the '<em><b>Old Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_MODIFICATION__OLD_NAME = MODIFICATION__OLD_NAME;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_MODIFICATION__NEW_NAME = MODIFICATION__NEW_NAME;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_MODIFICATION__REMOVE = MODIFICATION__REMOVE;

	/**
	 * The feature id for the '<em><b>Remove EAnnotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_MODIFICATION__REMOVE_EANNOTATIONS = MODIFICATION__REMOVE_EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_MODIFICATION__ANNOTATION_MODIFICATION = MODIFICATION__ANNOTATION_MODIFICATION;

	/**
	 * The feature id for the '<em><b>Old Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_MODIFICATION__OLD_INSTANCE_TYPE_NAME = MODIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Instance Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_MODIFICATION__NEW_INSTANCE_TYPE_NAME = MODIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Reify</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_MODIFICATION__REIFY = MODIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Enum Literal Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_MODIFICATION__ENUM_LITERAL_MODIFICATION = MODIFICATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Enum Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_MODIFICATION_FEATURE_COUNT = MODIFICATION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Enum Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_MODIFICATION_OPERATION_COUNT = MODIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.EnumLiteralModificationImpl <em>Enum Literal Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.EnumLiteralModificationImpl
	 * @see modif.impl.ModifPackageImpl#getEnumLiteralModification()
	 * @generated
	 */
	int ENUM_LITERAL_MODIFICATION = 10;

	/**
	 * The feature id for the '<em><b>Old Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_MODIFICATION__OLD_NAME = MODIFICATION__OLD_NAME;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_MODIFICATION__NEW_NAME = MODIFICATION__NEW_NAME;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_MODIFICATION__REMOVE = MODIFICATION__REMOVE;

	/**
	 * The feature id for the '<em><b>Remove EAnnotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_MODIFICATION__REMOVE_EANNOTATIONS = MODIFICATION__REMOVE_EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Annotation Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_MODIFICATION__ANNOTATION_MODIFICATION = MODIFICATION__ANNOTATION_MODIFICATION;

	/**
	 * The feature id for the '<em><b>Old Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_MODIFICATION__OLD_LITERAL = MODIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>New Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_MODIFICATION__NEW_LITERAL = MODIFICATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_MODIFICATION__OLD_VALUE = MODIFICATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_MODIFICATION__NEW_VALUE = MODIFICATION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Enum Literal Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_MODIFICATION_FEATURE_COUNT = MODIFICATION_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Enum Literal Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_MODIFICATION_OPERATION_COUNT = MODIFICATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.AnnotationModificationImpl <em>Annotation Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.AnnotationModificationImpl
	 * @see modif.impl.ModifPackageImpl#getAnnotationModification()
	 * @generated
	 */
	int ANNOTATION_MODIFICATION = 11;

	/**
	 * The feature id for the '<em><b>Old Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_MODIFICATION__OLD_SOURCE = 0;

	/**
	 * The feature id for the '<em><b>New Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_MODIFICATION__NEW_SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Remove EAnnotations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_MODIFICATION__REMOVE_EANNOTATIONS = 2;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_MODIFICATION__REMOVE = 3;

	/**
	 * The feature id for the '<em><b>Details Entry Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_MODIFICATION__DETAILS_ENTRY_MODIFICATION = 4;

	/**
	 * The feature id for the '<em><b>Annotation Modification</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_MODIFICATION__ANNOTATION_MODIFICATION = 5;

	/**
	 * The number of structural features of the '<em>Annotation Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_MODIFICATION_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Annotation Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_MODIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.impl.DetailsEntryModificationImpl <em>Details Entry Modification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.DetailsEntryModificationImpl
	 * @see modif.impl.ModifPackageImpl#getDetailsEntryModification()
	 * @generated
	 */
	int DETAILS_ENTRY_MODIFICATION = 12;

	/**
	 * The feature id for the '<em><b>Old Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_ENTRY_MODIFICATION__OLD_KEY = 0;

	/**
	 * The feature id for the '<em><b>New Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_ENTRY_MODIFICATION__NEW_KEY = 1;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_ENTRY_MODIFICATION__OLD_VALUE = 2;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_ENTRY_MODIFICATION__NEW_VALUE = 3;

	/**
	 * The feature id for the '<em><b>Remove</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_ENTRY_MODIFICATION__REMOVE = 4;

	/**
	 * The number of structural features of the '<em>Details Entry Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_ENTRY_MODIFICATION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Details Entry Modification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_ENTRY_MODIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.impl.AddFeatureImpl <em>Add Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.AddFeatureImpl
	 * @see modif.impl.ModifPackageImpl#getAddFeature()
	 * @generated
	 */
	int ADD_FEATURE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE__LOWER = 1;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE__UPPER = 2;

	/**
	 * The number of structural features of the '<em>Add Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Add Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_FEATURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.impl.AddAttributeImpl <em>Add Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.AddAttributeImpl
	 * @see modif.impl.ModifPackageImpl#getAddAttribute()
	 * @generated
	 */
	int ADD_ATTRIBUTE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ATTRIBUTE__NAME = ADD_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ATTRIBUTE__LOWER = ADD_FEATURE__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ATTRIBUTE__UPPER = ADD_FEATURE__UPPER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ATTRIBUTE__TYPE = ADD_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ATTRIBUTE__DEFAULT_VALUE = ADD_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Add Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ATTRIBUTE_FEATURE_COUNT = ADD_FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Add Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ATTRIBUTE_OPERATION_COUNT = ADD_FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.AddReferenceImpl <em>Add Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.AddReferenceImpl
	 * @see modif.impl.ModifPackageImpl#getAddReference()
	 * @generated
	 */
	int ADD_REFERENCE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REFERENCE__NAME = ADD_FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REFERENCE__LOWER = ADD_FEATURE__LOWER;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REFERENCE__UPPER = ADD_FEATURE__UPPER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REFERENCE__TYPE = ADD_FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Add Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REFERENCE_FEATURE_COUNT = ADD_FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Add Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_REFERENCE_OPERATION_COUNT = ADD_FEATURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.AddOppositeImpl <em>Add Opposite</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.AddOppositeImpl
	 * @see modif.impl.ModifPackageImpl#getAddOpposite()
	 * @generated
	 */
	int ADD_OPPOSITE = 16;

	/**
	 * The feature id for the '<em><b>Opposite Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OPPOSITE__OPPOSITE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Opposite Lower</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OPPOSITE__OPPOSITE_LOWER = 1;

	/**
	 * The feature id for the '<em><b>Opposite Upper</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OPPOSITE__OPPOSITE_UPPER = 2;

	/**
	 * The number of structural features of the '<em>Add Opposite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OPPOSITE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Add Opposite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_OPPOSITE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.impl.AddRootClassImpl <em>Add Root Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.AddRootClassImpl
	 * @see modif.impl.ModifPackageImpl#getAddRootClass()
	 * @generated
	 */
	int ADD_ROOT_CLASS = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ROOT_CLASS__NAME = 0;

	/**
	 * The number of structural features of the '<em>Add Root Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ROOT_CLASS_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Add Root Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_ROOT_CLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.impl.AddNameClassImpl <em>Add Name Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.AddNameClassImpl
	 * @see modif.impl.ModifPackageImpl#getAddNameClass()
	 * @generated
	 */
	int ADD_NAME_CLASS = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NAME_CLASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Name Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NAME_CLASS__NAME_NAME = 1;

	/**
	 * The number of structural features of the '<em>Add Name Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NAME_CLASS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Add Name Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_NAME_CLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.impl.AddDerivedImpl <em>Add Derived</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.AddDerivedImpl
	 * @see modif.impl.ModifPackageImpl#getAddDerived()
	 * @generated
	 */
	int ADD_DERIVED = 19;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED__NEW_NAME = 0;

	/**
	 * The feature id for the '<em><b>Reference Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED__REFERENCE_NAME = 1;

	/**
	 * The number of structural features of the '<em>Add Derived</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Add Derived</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.impl.AddDerivedReferenceImpl <em>Add Derived Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.AddDerivedReferenceImpl
	 * @see modif.impl.ModifPackageImpl#getAddDerivedReference()
	 * @generated
	 */
	int ADD_DERIVED_REFERENCE = 20;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED_REFERENCE__NEW_NAME = ADD_DERIVED__NEW_NAME;

	/**
	 * The feature id for the '<em><b>Reference Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED_REFERENCE__REFERENCE_NAME = ADD_DERIVED__REFERENCE_NAME;

	/**
	 * The number of structural features of the '<em>Add Derived Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED_REFERENCE_FEATURE_COUNT = ADD_DERIVED_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Add Derived Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED_REFERENCE_OPERATION_COUNT = ADD_DERIVED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.AddDerivedAttributeImpl <em>Add Derived Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.AddDerivedAttributeImpl
	 * @see modif.impl.ModifPackageImpl#getAddDerivedAttribute()
	 * @generated
	 */
	int ADD_DERIVED_ATTRIBUTE = 21;

	/**
	 * The feature id for the '<em><b>New Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED_ATTRIBUTE__NEW_NAME = ADD_DERIVED__NEW_NAME;

	/**
	 * The feature id for the '<em><b>Reference Name</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED_ATTRIBUTE__REFERENCE_NAME = ADD_DERIVED__REFERENCE_NAME;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED_ATTRIBUTE__ATTRIBUTE_NAME = ADD_DERIVED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Add Derived Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED_ATTRIBUTE_FEATURE_COUNT = ADD_DERIVED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Add Derived Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_DERIVED_ATTRIBUTE_OPERATION_COUNT = ADD_DERIVED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link modif.impl.ReferenceReificationImpl <em>Reference Reification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.ReferenceReificationImpl
	 * @see modif.impl.ModifPackageImpl#getReferenceReification()
	 * @generated
	 */
	int REFERENCE_REIFICATION = 22;

	/**
	 * The feature id for the '<em><b>Name Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REIFICATION__NAME_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Name First Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REIFICATION__NAME_FIRST_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Name Second Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REIFICATION__NAME_SECOND_REFERENCE = 2;

	/**
	 * The number of structural features of the '<em>Reference Reification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REIFICATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Reference Reification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_REIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.impl.EnumerateImpl <em>Enumerate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.impl.EnumerateImpl
	 * @see modif.impl.ModifPackageImpl#getEnumerate()
	 * @generated
	 */
	int ENUMERATE = 23;

	/**
	 * The feature id for the '<em><b>Enum Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATE__ENUM_NAME = 0;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATE__ATTRIBUTE_NAME = 1;

	/**
	 * The number of structural features of the '<em>Enumerate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Enumerate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link modif.PrimitiveType <em>Primitive Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see modif.PrimitiveType
	 * @see modif.impl.ModifPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 24;


	/**
	 * Returns the meta object for class '{@link modif.Modifications <em>Modifications</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modifications</em>'.
	 * @see modif.Modifications
	 * @generated
	 */
	EClass getModifications();

	/**
	 * Returns the meta object for the containment reference '{@link modif.Modifications#getRootPackageModification <em>Root Package Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root Package Modification</em>'.
	 * @see modif.Modifications#getRootPackageModification()
	 * @see #getModifications()
	 * @generated
	 */
	EReference getModifications_RootPackageModification();

	/**
	 * Returns the meta object for the containment reference '{@link modif.Modifications#getAddRootClass <em>Add Root Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Add Root Class</em>'.
	 * @see modif.Modifications#getAddRootClass()
	 * @see #getModifications()
	 * @generated
	 */
	EReference getModifications_AddRootClass();

	/**
	 * Returns the meta object for the containment reference '{@link modif.Modifications#getAddNameClass <em>Add Name Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Add Name Class</em>'.
	 * @see modif.Modifications#getAddNameClass()
	 * @see #getModifications()
	 * @generated
	 */
	EReference getModifications_AddNameClass();

	/**
	 * Returns the meta object for the attribute '{@link modif.Modifications#isRemoveAllAnnotations <em>Remove All Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remove All Annotations</em>'.
	 * @see modif.Modifications#isRemoveAllAnnotations()
	 * @see #getModifications()
	 * @generated
	 */
	EAttribute getModifications_RemoveAllAnnotations();

	/**
	 * Returns the meta object for the attribute '{@link modif.Modifications#isRemoveAllOperations <em>Remove All Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remove All Operations</em>'.
	 * @see modif.Modifications#isRemoveAllOperations()
	 * @see #getModifications()
	 * @generated
	 */
	EAttribute getModifications_RemoveAllOperations();

	/**
	 * Returns the meta object for the attribute '{@link modif.Modifications#isRemoveAllEStringAttributes <em>Remove All EString Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remove All EString Attributes</em>'.
	 * @see modif.Modifications#isRemoveAllEStringAttributes()
	 * @see #getModifications()
	 * @generated
	 */
	EAttribute getModifications_RemoveAllEStringAttributes();

	/**
	 * Returns the meta object for the attribute '{@link modif.Modifications#isRemoveAllOpposites <em>Remove All Opposites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remove All Opposites</em>'.
	 * @see modif.Modifications#isRemoveAllOpposites()
	 * @see #getModifications()
	 * @generated
	 */
	EAttribute getModifications_RemoveAllOpposites();

	/**
	 * Returns the meta object for the attribute '{@link modif.Modifications#isAddAllOpposite <em>Add All Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Add All Opposite</em>'.
	 * @see modif.Modifications#isAddAllOpposite()
	 * @see #getModifications()
	 * @generated
	 */
	EAttribute getModifications_AddAllOpposite();

	/**
	 * Returns the meta object for class '{@link modif.Modification <em>Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modification</em>'.
	 * @see modif.Modification
	 * @generated
	 */
	EClass getModification();

	/**
	 * Returns the meta object for the attribute '{@link modif.Modification#getOldName <em>Old Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Name</em>'.
	 * @see modif.Modification#getOldName()
	 * @see #getModification()
	 * @generated
	 */
	EAttribute getModification_OldName();

	/**
	 * Returns the meta object for the attribute '{@link modif.Modification#getNewName <em>New Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Name</em>'.
	 * @see modif.Modification#getNewName()
	 * @see #getModification()
	 * @generated
	 */
	EAttribute getModification_NewName();

	/**
	 * Returns the meta object for the attribute '{@link modif.Modification#isRemove <em>Remove</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remove</em>'.
	 * @see modif.Modification#isRemove()
	 * @see #getModification()
	 * @generated
	 */
	EAttribute getModification_Remove();

	/**
	 * Returns the meta object for the attribute '{@link modif.Modification#isRemoveEAnnotations <em>Remove EAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remove EAnnotations</em>'.
	 * @see modif.Modification#isRemoveEAnnotations()
	 * @see #getModification()
	 * @generated
	 */
	EAttribute getModification_RemoveEAnnotations();

	/**
	 * Returns the meta object for the containment reference list '{@link modif.Modification#getAnnotationModification <em>Annotation Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotation Modification</em>'.
	 * @see modif.Modification#getAnnotationModification()
	 * @see #getModification()
	 * @generated
	 */
	EReference getModification_AnnotationModification();

	/**
	 * Returns the meta object for class '{@link modif.PackageModification <em>Package Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Modification</em>'.
	 * @see modif.PackageModification
	 * @generated
	 */
	EClass getPackageModification();

	/**
	 * Returns the meta object for the attribute '{@link modif.PackageModification#getOldPrefixName <em>Old Prefix Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Prefix Name</em>'.
	 * @see modif.PackageModification#getOldPrefixName()
	 * @see #getPackageModification()
	 * @generated
	 */
	EAttribute getPackageModification_OldPrefixName();

	/**
	 * Returns the meta object for the attribute '{@link modif.PackageModification#getNewPrefixName <em>New Prefix Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Prefix Name</em>'.
	 * @see modif.PackageModification#getNewPrefixName()
	 * @see #getPackageModification()
	 * @generated
	 */
	EAttribute getPackageModification_NewPrefixName();

	/**
	 * Returns the meta object for the attribute '{@link modif.PackageModification#getOldURIName <em>Old URI Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old URI Name</em>'.
	 * @see modif.PackageModification#getOldURIName()
	 * @see #getPackageModification()
	 * @generated
	 */
	EAttribute getPackageModification_OldURIName();

	/**
	 * Returns the meta object for the attribute '{@link modif.PackageModification#getNewURIName <em>New URI Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New URI Name</em>'.
	 * @see modif.PackageModification#getNewURIName()
	 * @see #getPackageModification()
	 * @generated
	 */
	EAttribute getPackageModification_NewURIName();

	/**
	 * Returns the meta object for the attribute '{@link modif.PackageModification#isHide <em>Hide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide</em>'.
	 * @see modif.PackageModification#isHide()
	 * @see #getPackageModification()
	 * @generated
	 */
	EAttribute getPackageModification_Hide();

	/**
	 * Returns the meta object for the containment reference list '{@link modif.PackageModification#getPackageModification <em>Package Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Package Modification</em>'.
	 * @see modif.PackageModification#getPackageModification()
	 * @see #getPackageModification()
	 * @generated
	 */
	EReference getPackageModification_PackageModification();

	/**
	 * Returns the meta object for the containment reference list '{@link modif.PackageModification#getClassModification <em>Class Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Modification</em>'.
	 * @see modif.PackageModification#getClassModification()
	 * @see #getPackageModification()
	 * @generated
	 */
	EReference getPackageModification_ClassModification();

	/**
	 * Returns the meta object for the containment reference list '{@link modif.PackageModification#getDataTypeModification <em>Data Type Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Type Modification</em>'.
	 * @see modif.PackageModification#getDataTypeModification()
	 * @see #getPackageModification()
	 * @generated
	 */
	EReference getPackageModification_DataTypeModification();

	/**
	 * Returns the meta object for the containment reference list '{@link modif.PackageModification#getEnumModification <em>Enum Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enum Modification</em>'.
	 * @see modif.PackageModification#getEnumModification()
	 * @see #getPackageModification()
	 * @generated
	 */
	EReference getPackageModification_EnumModification();

	/**
	 * Returns the meta object for class '{@link modif.ClassModification <em>Class Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Modification</em>'.
	 * @see modif.ClassModification
	 * @generated
	 */
	EClass getClassModification();

	/**
	 * Returns the meta object for the attribute '{@link modif.ClassModification#isChangeAbstract <em>Change Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Change Abstract</em>'.
	 * @see modif.ClassModification#isChangeAbstract()
	 * @see #getClassModification()
	 * @generated
	 */
	EAttribute getClassModification_ChangeAbstract();

	/**
	 * Returns the meta object for the attribute '{@link modif.ClassModification#isHide <em>Hide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hide</em>'.
	 * @see modif.ClassModification#isHide()
	 * @see #getClassModification()
	 * @generated
	 */
	EAttribute getClassModification_Hide();

	/**
	 * Returns the meta object for the attribute '{@link modif.ClassModification#isFlatten <em>Flatten</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flatten</em>'.
	 * @see modif.ClassModification#isFlatten()
	 * @see #getClassModification()
	 * @generated
	 */
	EAttribute getClassModification_Flatten();

	/**
	 * Returns the meta object for the attribute '{@link modif.ClassModification#isFlattenAll <em>Flatten All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flatten All</em>'.
	 * @see modif.ClassModification#isFlattenAll()
	 * @see #getClassModification()
	 * @generated
	 */
	EAttribute getClassModification_FlattenAll();

	/**
	 * Returns the meta object for the containment reference list '{@link modif.ClassModification#getFeatureModification <em>Feature Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Feature Modification</em>'.
	 * @see modif.ClassModification#getFeatureModification()
	 * @see #getClassModification()
	 * @generated
	 */
	EReference getClassModification_FeatureModification();

	/**
	 * Returns the meta object for the containment reference list '{@link modif.ClassModification#getAddFeatures <em>Add Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Add Features</em>'.
	 * @see modif.ClassModification#getAddFeatures()
	 * @see #getClassModification()
	 * @generated
	 */
	EReference getClassModification_AddFeatures();

	/**
	 * Returns the meta object for the containment reference list '{@link modif.ClassModification#getAddDeriveds <em>Add Deriveds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Add Deriveds</em>'.
	 * @see modif.ClassModification#getAddDeriveds()
	 * @see #getClassModification()
	 * @generated
	 */
	EReference getClassModification_AddDeriveds();

	/**
	 * Returns the meta object for the containment reference '{@link modif.ClassModification#getEnumerate <em>Enumerate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Enumerate</em>'.
	 * @see modif.ClassModification#getEnumerate()
	 * @see #getClassModification()
	 * @generated
	 */
	EReference getClassModification_Enumerate();

	/**
	 * Returns the meta object for class '{@link modif.StructuralFeatureModification <em>Structural Feature Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Feature Modification</em>'.
	 * @see modif.StructuralFeatureModification
	 * @generated
	 */
	EClass getStructuralFeatureModification();

	/**
	 * Returns the meta object for class '{@link modif.AttributeModification <em>Attribute Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Modification</em>'.
	 * @see modif.AttributeModification
	 * @generated
	 */
	EClass getAttributeModification();

	/**
	 * Returns the meta object for the attribute '{@link modif.AttributeModification#isChangeType <em>Change Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Change Type</em>'.
	 * @see modif.AttributeModification#isChangeType()
	 * @see #getAttributeModification()
	 * @generated
	 */
	EAttribute getAttributeModification_ChangeType();

	/**
	 * Returns the meta object for the attribute '{@link modif.AttributeModification#getNewType <em>New Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Type</em>'.
	 * @see modif.AttributeModification#getNewType()
	 * @see #getAttributeModification()
	 * @generated
	 */
	EAttribute getAttributeModification_NewType();

	/**
	 * Returns the meta object for the containment reference '{@link modif.AttributeModification#getChangeBounds <em>Change Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Change Bounds</em>'.
	 * @see modif.AttributeModification#getChangeBounds()
	 * @see #getAttributeModification()
	 * @generated
	 */
	EReference getAttributeModification_ChangeBounds();

	/**
	 * Returns the meta object for class '{@link modif.ReferenceModification <em>Reference Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Modification</em>'.
	 * @see modif.ReferenceModification
	 * @generated
	 */
	EClass getReferenceModification();

	/**
	 * Returns the meta object for the containment reference '{@link modif.ReferenceModification#getChangeBounds <em>Change Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Change Bounds</em>'.
	 * @see modif.ReferenceModification#getChangeBounds()
	 * @see #getReferenceModification()
	 * @generated
	 */
	EReference getReferenceModification_ChangeBounds();

	/**
	 * Returns the meta object for the attribute '{@link modif.ReferenceModification#isChangeContainement <em>Change Containement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Change Containement</em>'.
	 * @see modif.ReferenceModification#isChangeContainement()
	 * @see #getReferenceModification()
	 * @generated
	 */
	EAttribute getReferenceModification_ChangeContainement();

	/**
	 * Returns the meta object for the attribute '{@link modif.ReferenceModification#isRemoveOpposite <em>Remove Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remove Opposite</em>'.
	 * @see modif.ReferenceModification#isRemoveOpposite()
	 * @see #getReferenceModification()
	 * @generated
	 */
	EAttribute getReferenceModification_RemoveOpposite();

	/**
	 * Returns the meta object for the containment reference '{@link modif.ReferenceModification#getAddOpposite <em>Add Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Add Opposite</em>'.
	 * @see modif.ReferenceModification#getAddOpposite()
	 * @see #getReferenceModification()
	 * @generated
	 */
	EReference getReferenceModification_AddOpposite();

	/**
	 * Returns the meta object for the containment reference '{@link modif.ReferenceModification#getReify <em>Reify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reify</em>'.
	 * @see modif.ReferenceModification#getReify()
	 * @see #getReferenceModification()
	 * @generated
	 */
	EReference getReferenceModification_Reify();

	/**
	 * Returns the meta object for class '{@link modif.ChangeBounds <em>Change Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Bounds</em>'.
	 * @see modif.ChangeBounds
	 * @generated
	 */
	EClass getChangeBounds();

	/**
	 * Returns the meta object for the attribute '{@link modif.ChangeBounds#getOldLower <em>Old Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Lower</em>'.
	 * @see modif.ChangeBounds#getOldLower()
	 * @see #getChangeBounds()
	 * @generated
	 */
	EAttribute getChangeBounds_OldLower();

	/**
	 * Returns the meta object for the attribute '{@link modif.ChangeBounds#getNewLower <em>New Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Lower</em>'.
	 * @see modif.ChangeBounds#getNewLower()
	 * @see #getChangeBounds()
	 * @generated
	 */
	EAttribute getChangeBounds_NewLower();

	/**
	 * Returns the meta object for the attribute '{@link modif.ChangeBounds#getOldUpper <em>Old Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Upper</em>'.
	 * @see modif.ChangeBounds#getOldUpper()
	 * @see #getChangeBounds()
	 * @generated
	 */
	EAttribute getChangeBounds_OldUpper();

	/**
	 * Returns the meta object for the attribute '{@link modif.ChangeBounds#getNewUpper <em>New Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Upper</em>'.
	 * @see modif.ChangeBounds#getNewUpper()
	 * @see #getChangeBounds()
	 * @generated
	 */
	EAttribute getChangeBounds_NewUpper();

	/**
	 * Returns the meta object for class '{@link modif.DataTypeModification <em>Data Type Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Modification</em>'.
	 * @see modif.DataTypeModification
	 * @generated
	 */
	EClass getDataTypeModification();

	/**
	 * Returns the meta object for the attribute '{@link modif.DataTypeModification#getOldInstanceTypeName <em>Old Instance Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Instance Type Name</em>'.
	 * @see modif.DataTypeModification#getOldInstanceTypeName()
	 * @see #getDataTypeModification()
	 * @generated
	 */
	EAttribute getDataTypeModification_OldInstanceTypeName();

	/**
	 * Returns the meta object for the attribute '{@link modif.DataTypeModification#getNewInstanceTypeName <em>New Instance Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Instance Type Name</em>'.
	 * @see modif.DataTypeModification#getNewInstanceTypeName()
	 * @see #getDataTypeModification()
	 * @generated
	 */
	EAttribute getDataTypeModification_NewInstanceTypeName();

	/**
	 * Returns the meta object for class '{@link modif.EnumModification <em>Enum Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Modification</em>'.
	 * @see modif.EnumModification
	 * @generated
	 */
	EClass getEnumModification();

	/**
	 * Returns the meta object for the attribute '{@link modif.EnumModification#getOldInstanceTypeName <em>Old Instance Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Instance Type Name</em>'.
	 * @see modif.EnumModification#getOldInstanceTypeName()
	 * @see #getEnumModification()
	 * @generated
	 */
	EAttribute getEnumModification_OldInstanceTypeName();

	/**
	 * Returns the meta object for the attribute '{@link modif.EnumModification#getNewInstanceTypeName <em>New Instance Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Instance Type Name</em>'.
	 * @see modif.EnumModification#getNewInstanceTypeName()
	 * @see #getEnumModification()
	 * @generated
	 */
	EAttribute getEnumModification_NewInstanceTypeName();

	/**
	 * Returns the meta object for the attribute '{@link modif.EnumModification#isReify <em>Reify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reify</em>'.
	 * @see modif.EnumModification#isReify()
	 * @see #getEnumModification()
	 * @generated
	 */
	EAttribute getEnumModification_Reify();

	/**
	 * Returns the meta object for the containment reference list '{@link modif.EnumModification#getEnumLiteralModification <em>Enum Literal Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enum Literal Modification</em>'.
	 * @see modif.EnumModification#getEnumLiteralModification()
	 * @see #getEnumModification()
	 * @generated
	 */
	EReference getEnumModification_EnumLiteralModification();

	/**
	 * Returns the meta object for class '{@link modif.EnumLiteralModification <em>Enum Literal Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Modification</em>'.
	 * @see modif.EnumLiteralModification
	 * @generated
	 */
	EClass getEnumLiteralModification();

	/**
	 * Returns the meta object for the attribute '{@link modif.EnumLiteralModification#getOldLiteral <em>Old Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Literal</em>'.
	 * @see modif.EnumLiteralModification#getOldLiteral()
	 * @see #getEnumLiteralModification()
	 * @generated
	 */
	EAttribute getEnumLiteralModification_OldLiteral();

	/**
	 * Returns the meta object for the attribute '{@link modif.EnumLiteralModification#getNewLiteral <em>New Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Literal</em>'.
	 * @see modif.EnumLiteralModification#getNewLiteral()
	 * @see #getEnumLiteralModification()
	 * @generated
	 */
	EAttribute getEnumLiteralModification_NewLiteral();

	/**
	 * Returns the meta object for the attribute '{@link modif.EnumLiteralModification#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see modif.EnumLiteralModification#getOldValue()
	 * @see #getEnumLiteralModification()
	 * @generated
	 */
	EAttribute getEnumLiteralModification_OldValue();

	/**
	 * Returns the meta object for the attribute '{@link modif.EnumLiteralModification#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see modif.EnumLiteralModification#getNewValue()
	 * @see #getEnumLiteralModification()
	 * @generated
	 */
	EAttribute getEnumLiteralModification_NewValue();

	/**
	 * Returns the meta object for class '{@link modif.AnnotationModification <em>Annotation Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Modification</em>'.
	 * @see modif.AnnotationModification
	 * @generated
	 */
	EClass getAnnotationModification();

	/**
	 * Returns the meta object for the attribute '{@link modif.AnnotationModification#getOldSource <em>Old Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Source</em>'.
	 * @see modif.AnnotationModification#getOldSource()
	 * @see #getAnnotationModification()
	 * @generated
	 */
	EAttribute getAnnotationModification_OldSource();

	/**
	 * Returns the meta object for the attribute '{@link modif.AnnotationModification#getNewSource <em>New Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Source</em>'.
	 * @see modif.AnnotationModification#getNewSource()
	 * @see #getAnnotationModification()
	 * @generated
	 */
	EAttribute getAnnotationModification_NewSource();

	/**
	 * Returns the meta object for the attribute '{@link modif.AnnotationModification#isRemoveEAnnotations <em>Remove EAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remove EAnnotations</em>'.
	 * @see modif.AnnotationModification#isRemoveEAnnotations()
	 * @see #getAnnotationModification()
	 * @generated
	 */
	EAttribute getAnnotationModification_RemoveEAnnotations();

	/**
	 * Returns the meta object for the attribute '{@link modif.AnnotationModification#isRemove <em>Remove</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remove</em>'.
	 * @see modif.AnnotationModification#isRemove()
	 * @see #getAnnotationModification()
	 * @generated
	 */
	EAttribute getAnnotationModification_Remove();

	/**
	 * Returns the meta object for the containment reference list '{@link modif.AnnotationModification#getDetailsEntryModification <em>Details Entry Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Details Entry Modification</em>'.
	 * @see modif.AnnotationModification#getDetailsEntryModification()
	 * @see #getAnnotationModification()
	 * @generated
	 */
	EReference getAnnotationModification_DetailsEntryModification();

	/**
	 * Returns the meta object for the containment reference list '{@link modif.AnnotationModification#getAnnotationModification <em>Annotation Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotation Modification</em>'.
	 * @see modif.AnnotationModification#getAnnotationModification()
	 * @see #getAnnotationModification()
	 * @generated
	 */
	EReference getAnnotationModification_AnnotationModification();

	/**
	 * Returns the meta object for class '{@link modif.DetailsEntryModification <em>Details Entry Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Details Entry Modification</em>'.
	 * @see modif.DetailsEntryModification
	 * @generated
	 */
	EClass getDetailsEntryModification();

	/**
	 * Returns the meta object for the attribute '{@link modif.DetailsEntryModification#getOldKey <em>Old Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Key</em>'.
	 * @see modif.DetailsEntryModification#getOldKey()
	 * @see #getDetailsEntryModification()
	 * @generated
	 */
	EAttribute getDetailsEntryModification_OldKey();

	/**
	 * Returns the meta object for the attribute '{@link modif.DetailsEntryModification#getNewKey <em>New Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Key</em>'.
	 * @see modif.DetailsEntryModification#getNewKey()
	 * @see #getDetailsEntryModification()
	 * @generated
	 */
	EAttribute getDetailsEntryModification_NewKey();

	/**
	 * Returns the meta object for the attribute '{@link modif.DetailsEntryModification#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see modif.DetailsEntryModification#getOldValue()
	 * @see #getDetailsEntryModification()
	 * @generated
	 */
	EAttribute getDetailsEntryModification_OldValue();

	/**
	 * Returns the meta object for the attribute '{@link modif.DetailsEntryModification#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see modif.DetailsEntryModification#getNewValue()
	 * @see #getDetailsEntryModification()
	 * @generated
	 */
	EAttribute getDetailsEntryModification_NewValue();

	/**
	 * Returns the meta object for the attribute '{@link modif.DetailsEntryModification#isRemove <em>Remove</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remove</em>'.
	 * @see modif.DetailsEntryModification#isRemove()
	 * @see #getDetailsEntryModification()
	 * @generated
	 */
	EAttribute getDetailsEntryModification_Remove();

	/**
	 * Returns the meta object for class '{@link modif.AddFeature <em>Add Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Feature</em>'.
	 * @see modif.AddFeature
	 * @generated
	 */
	EClass getAddFeature();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see modif.AddFeature#getName()
	 * @see #getAddFeature()
	 * @generated
	 */
	EAttribute getAddFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddFeature#getLower <em>Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower</em>'.
	 * @see modif.AddFeature#getLower()
	 * @see #getAddFeature()
	 * @generated
	 */
	EAttribute getAddFeature_Lower();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddFeature#getUpper <em>Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper</em>'.
	 * @see modif.AddFeature#getUpper()
	 * @see #getAddFeature()
	 * @generated
	 */
	EAttribute getAddFeature_Upper();

	/**
	 * Returns the meta object for class '{@link modif.AddAttribute <em>Add Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Attribute</em>'.
	 * @see modif.AddAttribute
	 * @generated
	 */
	EClass getAddAttribute();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddAttribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see modif.AddAttribute#getType()
	 * @see #getAddAttribute()
	 * @generated
	 */
	EAttribute getAddAttribute_Type();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddAttribute#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see modif.AddAttribute#getDefaultValue()
	 * @see #getAddAttribute()
	 * @generated
	 */
	EAttribute getAddAttribute_DefaultValue();

	/**
	 * Returns the meta object for class '{@link modif.AddReference <em>Add Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Reference</em>'.
	 * @see modif.AddReference
	 * @generated
	 */
	EClass getAddReference();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see modif.AddReference#getType()
	 * @see #getAddReference()
	 * @generated
	 */
	EAttribute getAddReference_Type();

	/**
	 * Returns the meta object for class '{@link modif.AddOpposite <em>Add Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Opposite</em>'.
	 * @see modif.AddOpposite
	 * @generated
	 */
	EClass getAddOpposite();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddOpposite#getOppositeName <em>Opposite Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opposite Name</em>'.
	 * @see modif.AddOpposite#getOppositeName()
	 * @see #getAddOpposite()
	 * @generated
	 */
	EAttribute getAddOpposite_OppositeName();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddOpposite#getOppositeLower <em>Opposite Lower</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opposite Lower</em>'.
	 * @see modif.AddOpposite#getOppositeLower()
	 * @see #getAddOpposite()
	 * @generated
	 */
	EAttribute getAddOpposite_OppositeLower();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddOpposite#getOppositeUpper <em>Opposite Upper</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opposite Upper</em>'.
	 * @see modif.AddOpposite#getOppositeUpper()
	 * @see #getAddOpposite()
	 * @generated
	 */
	EAttribute getAddOpposite_OppositeUpper();

	/**
	 * Returns the meta object for class '{@link modif.AddRootClass <em>Add Root Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Root Class</em>'.
	 * @see modif.AddRootClass
	 * @generated
	 */
	EClass getAddRootClass();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddRootClass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see modif.AddRootClass#getName()
	 * @see #getAddRootClass()
	 * @generated
	 */
	EAttribute getAddRootClass_Name();

	/**
	 * Returns the meta object for class '{@link modif.AddNameClass <em>Add Name Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Name Class</em>'.
	 * @see modif.AddNameClass
	 * @generated
	 */
	EClass getAddNameClass();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddNameClass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see modif.AddNameClass#getName()
	 * @see #getAddNameClass()
	 * @generated
	 */
	EAttribute getAddNameClass_Name();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddNameClass#getNameName <em>Name Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Name</em>'.
	 * @see modif.AddNameClass#getNameName()
	 * @see #getAddNameClass()
	 * @generated
	 */
	EAttribute getAddNameClass_NameName();

	/**
	 * Returns the meta object for class '{@link modif.AddDerived <em>Add Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Derived</em>'.
	 * @see modif.AddDerived
	 * @generated
	 */
	EClass getAddDerived();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddDerived#getNewName <em>New Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Name</em>'.
	 * @see modif.AddDerived#getNewName()
	 * @see #getAddDerived()
	 * @generated
	 */
	EAttribute getAddDerived_NewName();

	/**
	 * Returns the meta object for the attribute list '{@link modif.AddDerived#getReferenceName <em>Reference Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Reference Name</em>'.
	 * @see modif.AddDerived#getReferenceName()
	 * @see #getAddDerived()
	 * @generated
	 */
	EAttribute getAddDerived_ReferenceName();

	/**
	 * Returns the meta object for class '{@link modif.AddDerivedReference <em>Add Derived Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Derived Reference</em>'.
	 * @see modif.AddDerivedReference
	 * @generated
	 */
	EClass getAddDerivedReference();

	/**
	 * Returns the meta object for class '{@link modif.AddDerivedAttribute <em>Add Derived Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Derived Attribute</em>'.
	 * @see modif.AddDerivedAttribute
	 * @generated
	 */
	EClass getAddDerivedAttribute();

	/**
	 * Returns the meta object for the attribute '{@link modif.AddDerivedAttribute#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see modif.AddDerivedAttribute#getAttributeName()
	 * @see #getAddDerivedAttribute()
	 * @generated
	 */
	EAttribute getAddDerivedAttribute_AttributeName();

	/**
	 * Returns the meta object for class '{@link modif.ReferenceReification <em>Reference Reification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Reification</em>'.
	 * @see modif.ReferenceReification
	 * @generated
	 */
	EClass getReferenceReification();

	/**
	 * Returns the meta object for the attribute '{@link modif.ReferenceReification#getNameClass <em>Name Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Class</em>'.
	 * @see modif.ReferenceReification#getNameClass()
	 * @see #getReferenceReification()
	 * @generated
	 */
	EAttribute getReferenceReification_NameClass();

	/**
	 * Returns the meta object for the attribute '{@link modif.ReferenceReification#getNameFirstReference <em>Name First Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name First Reference</em>'.
	 * @see modif.ReferenceReification#getNameFirstReference()
	 * @see #getReferenceReification()
	 * @generated
	 */
	EAttribute getReferenceReification_NameFirstReference();

	/**
	 * Returns the meta object for the attribute '{@link modif.ReferenceReification#getNameSecondReference <em>Name Second Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Second Reference</em>'.
	 * @see modif.ReferenceReification#getNameSecondReference()
	 * @see #getReferenceReification()
	 * @generated
	 */
	EAttribute getReferenceReification_NameSecondReference();

	/**
	 * Returns the meta object for class '{@link modif.Enumerate <em>Enumerate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerate</em>'.
	 * @see modif.Enumerate
	 * @generated
	 */
	EClass getEnumerate();

	/**
	 * Returns the meta object for the attribute '{@link modif.Enumerate#getEnumName <em>Enum Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enum Name</em>'.
	 * @see modif.Enumerate#getEnumName()
	 * @see #getEnumerate()
	 * @generated
	 */
	EAttribute getEnumerate_EnumName();

	/**
	 * Returns the meta object for the attribute '{@link modif.Enumerate#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see modif.Enumerate#getAttributeName()
	 * @see #getEnumerate()
	 * @generated
	 */
	EAttribute getEnumerate_AttributeName();

	/**
	 * Returns the meta object for enum '{@link modif.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Type</em>'.
	 * @see modif.PrimitiveType
	 * @generated
	 */
	EEnum getPrimitiveType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModifFactory getModifFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link modif.impl.ModificationsImpl <em>Modifications</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.ModificationsImpl
		 * @see modif.impl.ModifPackageImpl#getModifications()
		 * @generated
		 */
		EClass MODIFICATIONS = eINSTANCE.getModifications();

		/**
		 * The meta object literal for the '<em><b>Root Package Modification</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFICATIONS__ROOT_PACKAGE_MODIFICATION = eINSTANCE.getModifications_RootPackageModification();

		/**
		 * The meta object literal for the '<em><b>Add Root Class</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFICATIONS__ADD_ROOT_CLASS = eINSTANCE.getModifications_AddRootClass();

		/**
		 * The meta object literal for the '<em><b>Add Name Class</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFICATIONS__ADD_NAME_CLASS = eINSTANCE.getModifications_AddNameClass();

		/**
		 * The meta object literal for the '<em><b>Remove All Annotations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATIONS__REMOVE_ALL_ANNOTATIONS = eINSTANCE.getModifications_RemoveAllAnnotations();

		/**
		 * The meta object literal for the '<em><b>Remove All Operations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATIONS__REMOVE_ALL_OPERATIONS = eINSTANCE.getModifications_RemoveAllOperations();

		/**
		 * The meta object literal for the '<em><b>Remove All EString Attributes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATIONS__REMOVE_ALL_ESTRING_ATTRIBUTES = eINSTANCE.getModifications_RemoveAllEStringAttributes();

		/**
		 * The meta object literal for the '<em><b>Remove All Opposites</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATIONS__REMOVE_ALL_OPPOSITES = eINSTANCE.getModifications_RemoveAllOpposites();

		/**
		 * The meta object literal for the '<em><b>Add All Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATIONS__ADD_ALL_OPPOSITE = eINSTANCE.getModifications_AddAllOpposite();

		/**
		 * The meta object literal for the '{@link modif.impl.ModificationImpl <em>Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.ModificationImpl
		 * @see modif.impl.ModifPackageImpl#getModification()
		 * @generated
		 */
		EClass MODIFICATION = eINSTANCE.getModification();

		/**
		 * The meta object literal for the '<em><b>Old Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATION__OLD_NAME = eINSTANCE.getModification_OldName();

		/**
		 * The meta object literal for the '<em><b>New Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATION__NEW_NAME = eINSTANCE.getModification_NewName();

		/**
		 * The meta object literal for the '<em><b>Remove</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATION__REMOVE = eINSTANCE.getModification_Remove();

		/**
		 * The meta object literal for the '<em><b>Remove EAnnotations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODIFICATION__REMOVE_EANNOTATIONS = eINSTANCE.getModification_RemoveEAnnotations();

		/**
		 * The meta object literal for the '<em><b>Annotation Modification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODIFICATION__ANNOTATION_MODIFICATION = eINSTANCE.getModification_AnnotationModification();

		/**
		 * The meta object literal for the '{@link modif.impl.PackageModificationImpl <em>Package Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.PackageModificationImpl
		 * @see modif.impl.ModifPackageImpl#getPackageModification()
		 * @generated
		 */
		EClass PACKAGE_MODIFICATION = eINSTANCE.getPackageModification();

		/**
		 * The meta object literal for the '<em><b>Old Prefix Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODIFICATION__OLD_PREFIX_NAME = eINSTANCE.getPackageModification_OldPrefixName();

		/**
		 * The meta object literal for the '<em><b>New Prefix Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODIFICATION__NEW_PREFIX_NAME = eINSTANCE.getPackageModification_NewPrefixName();

		/**
		 * The meta object literal for the '<em><b>Old URI Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODIFICATION__OLD_URI_NAME = eINSTANCE.getPackageModification_OldURIName();

		/**
		 * The meta object literal for the '<em><b>New URI Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODIFICATION__NEW_URI_NAME = eINSTANCE.getPackageModification_NewURIName();

		/**
		 * The meta object literal for the '<em><b>Hide</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PACKAGE_MODIFICATION__HIDE = eINSTANCE.getPackageModification_Hide();

		/**
		 * The meta object literal for the '<em><b>Package Modification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_MODIFICATION__PACKAGE_MODIFICATION = eINSTANCE.getPackageModification_PackageModification();

		/**
		 * The meta object literal for the '<em><b>Class Modification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_MODIFICATION__CLASS_MODIFICATION = eINSTANCE.getPackageModification_ClassModification();

		/**
		 * The meta object literal for the '<em><b>Data Type Modification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_MODIFICATION__DATA_TYPE_MODIFICATION = eINSTANCE.getPackageModification_DataTypeModification();

		/**
		 * The meta object literal for the '<em><b>Enum Modification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_MODIFICATION__ENUM_MODIFICATION = eINSTANCE.getPackageModification_EnumModification();

		/**
		 * The meta object literal for the '{@link modif.impl.ClassModificationImpl <em>Class Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.ClassModificationImpl
		 * @see modif.impl.ModifPackageImpl#getClassModification()
		 * @generated
		 */
		EClass CLASS_MODIFICATION = eINSTANCE.getClassModification();

		/**
		 * The meta object literal for the '<em><b>Change Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MODIFICATION__CHANGE_ABSTRACT = eINSTANCE.getClassModification_ChangeAbstract();

		/**
		 * The meta object literal for the '<em><b>Hide</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MODIFICATION__HIDE = eINSTANCE.getClassModification_Hide();

		/**
		 * The meta object literal for the '<em><b>Flatten</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MODIFICATION__FLATTEN = eINSTANCE.getClassModification_Flatten();

		/**
		 * The meta object literal for the '<em><b>Flatten All</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_MODIFICATION__FLATTEN_ALL = eINSTANCE.getClassModification_FlattenAll();

		/**
		 * The meta object literal for the '<em><b>Feature Modification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MODIFICATION__FEATURE_MODIFICATION = eINSTANCE.getClassModification_FeatureModification();

		/**
		 * The meta object literal for the '<em><b>Add Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MODIFICATION__ADD_FEATURES = eINSTANCE.getClassModification_AddFeatures();

		/**
		 * The meta object literal for the '<em><b>Add Deriveds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MODIFICATION__ADD_DERIVEDS = eINSTANCE.getClassModification_AddDeriveds();

		/**
		 * The meta object literal for the '<em><b>Enumerate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_MODIFICATION__ENUMERATE = eINSTANCE.getClassModification_Enumerate();

		/**
		 * The meta object literal for the '{@link modif.impl.StructuralFeatureModificationImpl <em>Structural Feature Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.StructuralFeatureModificationImpl
		 * @see modif.impl.ModifPackageImpl#getStructuralFeatureModification()
		 * @generated
		 */
		EClass STRUCTURAL_FEATURE_MODIFICATION = eINSTANCE.getStructuralFeatureModification();

		/**
		 * The meta object literal for the '{@link modif.impl.AttributeModificationImpl <em>Attribute Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.AttributeModificationImpl
		 * @see modif.impl.ModifPackageImpl#getAttributeModification()
		 * @generated
		 */
		EClass ATTRIBUTE_MODIFICATION = eINSTANCE.getAttributeModification();

		/**
		 * The meta object literal for the '<em><b>Change Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_MODIFICATION__CHANGE_TYPE = eINSTANCE.getAttributeModification_ChangeType();

		/**
		 * The meta object literal for the '<em><b>New Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_MODIFICATION__NEW_TYPE = eINSTANCE.getAttributeModification_NewType();

		/**
		 * The meta object literal for the '<em><b>Change Bounds</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS = eINSTANCE.getAttributeModification_ChangeBounds();

		/**
		 * The meta object literal for the '{@link modif.impl.ReferenceModificationImpl <em>Reference Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.ReferenceModificationImpl
		 * @see modif.impl.ModifPackageImpl#getReferenceModification()
		 * @generated
		 */
		EClass REFERENCE_MODIFICATION = eINSTANCE.getReferenceModification();

		/**
		 * The meta object literal for the '<em><b>Change Bounds</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_MODIFICATION__CHANGE_BOUNDS = eINSTANCE.getReferenceModification_ChangeBounds();

		/**
		 * The meta object literal for the '<em><b>Change Containement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_MODIFICATION__CHANGE_CONTAINEMENT = eINSTANCE.getReferenceModification_ChangeContainement();

		/**
		 * The meta object literal for the '<em><b>Remove Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_MODIFICATION__REMOVE_OPPOSITE = eINSTANCE.getReferenceModification_RemoveOpposite();

		/**
		 * The meta object literal for the '<em><b>Add Opposite</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_MODIFICATION__ADD_OPPOSITE = eINSTANCE.getReferenceModification_AddOpposite();

		/**
		 * The meta object literal for the '<em><b>Reify</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_MODIFICATION__REIFY = eINSTANCE.getReferenceModification_Reify();

		/**
		 * The meta object literal for the '{@link modif.impl.ChangeBoundsImpl <em>Change Bounds</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.ChangeBoundsImpl
		 * @see modif.impl.ModifPackageImpl#getChangeBounds()
		 * @generated
		 */
		EClass CHANGE_BOUNDS = eINSTANCE.getChangeBounds();

		/**
		 * The meta object literal for the '<em><b>Old Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_BOUNDS__OLD_LOWER = eINSTANCE.getChangeBounds_OldLower();

		/**
		 * The meta object literal for the '<em><b>New Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_BOUNDS__NEW_LOWER = eINSTANCE.getChangeBounds_NewLower();

		/**
		 * The meta object literal for the '<em><b>Old Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_BOUNDS__OLD_UPPER = eINSTANCE.getChangeBounds_OldUpper();

		/**
		 * The meta object literal for the '<em><b>New Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_BOUNDS__NEW_UPPER = eINSTANCE.getChangeBounds_NewUpper();

		/**
		 * The meta object literal for the '{@link modif.impl.DataTypeModificationImpl <em>Data Type Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.DataTypeModificationImpl
		 * @see modif.impl.ModifPackageImpl#getDataTypeModification()
		 * @generated
		 */
		EClass DATA_TYPE_MODIFICATION = eINSTANCE.getDataTypeModification();

		/**
		 * The meta object literal for the '<em><b>Old Instance Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_MODIFICATION__OLD_INSTANCE_TYPE_NAME = eINSTANCE.getDataTypeModification_OldInstanceTypeName();

		/**
		 * The meta object literal for the '<em><b>New Instance Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_MODIFICATION__NEW_INSTANCE_TYPE_NAME = eINSTANCE.getDataTypeModification_NewInstanceTypeName();

		/**
		 * The meta object literal for the '{@link modif.impl.EnumModificationImpl <em>Enum Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.EnumModificationImpl
		 * @see modif.impl.ModifPackageImpl#getEnumModification()
		 * @generated
		 */
		EClass ENUM_MODIFICATION = eINSTANCE.getEnumModification();

		/**
		 * The meta object literal for the '<em><b>Old Instance Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_MODIFICATION__OLD_INSTANCE_TYPE_NAME = eINSTANCE.getEnumModification_OldInstanceTypeName();

		/**
		 * The meta object literal for the '<em><b>New Instance Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_MODIFICATION__NEW_INSTANCE_TYPE_NAME = eINSTANCE.getEnumModification_NewInstanceTypeName();

		/**
		 * The meta object literal for the '<em><b>Reify</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_MODIFICATION__REIFY = eINSTANCE.getEnumModification_Reify();

		/**
		 * The meta object literal for the '<em><b>Enum Literal Modification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_MODIFICATION__ENUM_LITERAL_MODIFICATION = eINSTANCE.getEnumModification_EnumLiteralModification();

		/**
		 * The meta object literal for the '{@link modif.impl.EnumLiteralModificationImpl <em>Enum Literal Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.EnumLiteralModificationImpl
		 * @see modif.impl.ModifPackageImpl#getEnumLiteralModification()
		 * @generated
		 */
		EClass ENUM_LITERAL_MODIFICATION = eINSTANCE.getEnumLiteralModification();

		/**
		 * The meta object literal for the '<em><b>Old Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_LITERAL_MODIFICATION__OLD_LITERAL = eINSTANCE.getEnumLiteralModification_OldLiteral();

		/**
		 * The meta object literal for the '<em><b>New Literal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_LITERAL_MODIFICATION__NEW_LITERAL = eINSTANCE.getEnumLiteralModification_NewLiteral();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_LITERAL_MODIFICATION__OLD_VALUE = eINSTANCE.getEnumLiteralModification_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_LITERAL_MODIFICATION__NEW_VALUE = eINSTANCE.getEnumLiteralModification_NewValue();

		/**
		 * The meta object literal for the '{@link modif.impl.AnnotationModificationImpl <em>Annotation Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.AnnotationModificationImpl
		 * @see modif.impl.ModifPackageImpl#getAnnotationModification()
		 * @generated
		 */
		EClass ANNOTATION_MODIFICATION = eINSTANCE.getAnnotationModification();

		/**
		 * The meta object literal for the '<em><b>Old Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_MODIFICATION__OLD_SOURCE = eINSTANCE.getAnnotationModification_OldSource();

		/**
		 * The meta object literal for the '<em><b>New Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_MODIFICATION__NEW_SOURCE = eINSTANCE.getAnnotationModification_NewSource();

		/**
		 * The meta object literal for the '<em><b>Remove EAnnotations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_MODIFICATION__REMOVE_EANNOTATIONS = eINSTANCE.getAnnotationModification_RemoveEAnnotations();

		/**
		 * The meta object literal for the '<em><b>Remove</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION_MODIFICATION__REMOVE = eINSTANCE.getAnnotationModification_Remove();

		/**
		 * The meta object literal for the '<em><b>Details Entry Modification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_MODIFICATION__DETAILS_ENTRY_MODIFICATION = eINSTANCE.getAnnotationModification_DetailsEntryModification();

		/**
		 * The meta object literal for the '<em><b>Annotation Modification</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_MODIFICATION__ANNOTATION_MODIFICATION = eINSTANCE.getAnnotationModification_AnnotationModification();

		/**
		 * The meta object literal for the '{@link modif.impl.DetailsEntryModificationImpl <em>Details Entry Modification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.DetailsEntryModificationImpl
		 * @see modif.impl.ModifPackageImpl#getDetailsEntryModification()
		 * @generated
		 */
		EClass DETAILS_ENTRY_MODIFICATION = eINSTANCE.getDetailsEntryModification();

		/**
		 * The meta object literal for the '<em><b>Old Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAILS_ENTRY_MODIFICATION__OLD_KEY = eINSTANCE.getDetailsEntryModification_OldKey();

		/**
		 * The meta object literal for the '<em><b>New Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAILS_ENTRY_MODIFICATION__NEW_KEY = eINSTANCE.getDetailsEntryModification_NewKey();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAILS_ENTRY_MODIFICATION__OLD_VALUE = eINSTANCE.getDetailsEntryModification_OldValue();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAILS_ENTRY_MODIFICATION__NEW_VALUE = eINSTANCE.getDetailsEntryModification_NewValue();

		/**
		 * The meta object literal for the '<em><b>Remove</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DETAILS_ENTRY_MODIFICATION__REMOVE = eINSTANCE.getDetailsEntryModification_Remove();

		/**
		 * The meta object literal for the '{@link modif.impl.AddFeatureImpl <em>Add Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.AddFeatureImpl
		 * @see modif.impl.ModifPackageImpl#getAddFeature()
		 * @generated
		 */
		EClass ADD_FEATURE = eINSTANCE.getAddFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_FEATURE__NAME = eINSTANCE.getAddFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_FEATURE__LOWER = eINSTANCE.getAddFeature_Lower();

		/**
		 * The meta object literal for the '<em><b>Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_FEATURE__UPPER = eINSTANCE.getAddFeature_Upper();

		/**
		 * The meta object literal for the '{@link modif.impl.AddAttributeImpl <em>Add Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.AddAttributeImpl
		 * @see modif.impl.ModifPackageImpl#getAddAttribute()
		 * @generated
		 */
		EClass ADD_ATTRIBUTE = eINSTANCE.getAddAttribute();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_ATTRIBUTE__TYPE = eINSTANCE.getAddAttribute_Type();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_ATTRIBUTE__DEFAULT_VALUE = eINSTANCE.getAddAttribute_DefaultValue();

		/**
		 * The meta object literal for the '{@link modif.impl.AddReferenceImpl <em>Add Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.AddReferenceImpl
		 * @see modif.impl.ModifPackageImpl#getAddReference()
		 * @generated
		 */
		EClass ADD_REFERENCE = eINSTANCE.getAddReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_REFERENCE__TYPE = eINSTANCE.getAddReference_Type();

		/**
		 * The meta object literal for the '{@link modif.impl.AddOppositeImpl <em>Add Opposite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.AddOppositeImpl
		 * @see modif.impl.ModifPackageImpl#getAddOpposite()
		 * @generated
		 */
		EClass ADD_OPPOSITE = eINSTANCE.getAddOpposite();

		/**
		 * The meta object literal for the '<em><b>Opposite Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_OPPOSITE__OPPOSITE_NAME = eINSTANCE.getAddOpposite_OppositeName();

		/**
		 * The meta object literal for the '<em><b>Opposite Lower</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_OPPOSITE__OPPOSITE_LOWER = eINSTANCE.getAddOpposite_OppositeLower();

		/**
		 * The meta object literal for the '<em><b>Opposite Upper</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_OPPOSITE__OPPOSITE_UPPER = eINSTANCE.getAddOpposite_OppositeUpper();

		/**
		 * The meta object literal for the '{@link modif.impl.AddRootClassImpl <em>Add Root Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.AddRootClassImpl
		 * @see modif.impl.ModifPackageImpl#getAddRootClass()
		 * @generated
		 */
		EClass ADD_ROOT_CLASS = eINSTANCE.getAddRootClass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_ROOT_CLASS__NAME = eINSTANCE.getAddRootClass_Name();

		/**
		 * The meta object literal for the '{@link modif.impl.AddNameClassImpl <em>Add Name Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.AddNameClassImpl
		 * @see modif.impl.ModifPackageImpl#getAddNameClass()
		 * @generated
		 */
		EClass ADD_NAME_CLASS = eINSTANCE.getAddNameClass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_NAME_CLASS__NAME = eINSTANCE.getAddNameClass_Name();

		/**
		 * The meta object literal for the '<em><b>Name Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_NAME_CLASS__NAME_NAME = eINSTANCE.getAddNameClass_NameName();

		/**
		 * The meta object literal for the '{@link modif.impl.AddDerivedImpl <em>Add Derived</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.AddDerivedImpl
		 * @see modif.impl.ModifPackageImpl#getAddDerived()
		 * @generated
		 */
		EClass ADD_DERIVED = eINSTANCE.getAddDerived();

		/**
		 * The meta object literal for the '<em><b>New Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_DERIVED__NEW_NAME = eINSTANCE.getAddDerived_NewName();

		/**
		 * The meta object literal for the '<em><b>Reference Name</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_DERIVED__REFERENCE_NAME = eINSTANCE.getAddDerived_ReferenceName();

		/**
		 * The meta object literal for the '{@link modif.impl.AddDerivedReferenceImpl <em>Add Derived Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.AddDerivedReferenceImpl
		 * @see modif.impl.ModifPackageImpl#getAddDerivedReference()
		 * @generated
		 */
		EClass ADD_DERIVED_REFERENCE = eINSTANCE.getAddDerivedReference();

		/**
		 * The meta object literal for the '{@link modif.impl.AddDerivedAttributeImpl <em>Add Derived Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.AddDerivedAttributeImpl
		 * @see modif.impl.ModifPackageImpl#getAddDerivedAttribute()
		 * @generated
		 */
		EClass ADD_DERIVED_ATTRIBUTE = eINSTANCE.getAddDerivedAttribute();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_DERIVED_ATTRIBUTE__ATTRIBUTE_NAME = eINSTANCE.getAddDerivedAttribute_AttributeName();

		/**
		 * The meta object literal for the '{@link modif.impl.ReferenceReificationImpl <em>Reference Reification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.ReferenceReificationImpl
		 * @see modif.impl.ModifPackageImpl#getReferenceReification()
		 * @generated
		 */
		EClass REFERENCE_REIFICATION = eINSTANCE.getReferenceReification();

		/**
		 * The meta object literal for the '<em><b>Name Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_REIFICATION__NAME_CLASS = eINSTANCE.getReferenceReification_NameClass();

		/**
		 * The meta object literal for the '<em><b>Name First Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_REIFICATION__NAME_FIRST_REFERENCE = eINSTANCE.getReferenceReification_NameFirstReference();

		/**
		 * The meta object literal for the '<em><b>Name Second Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_REIFICATION__NAME_SECOND_REFERENCE = eINSTANCE.getReferenceReification_NameSecondReference();

		/**
		 * The meta object literal for the '{@link modif.impl.EnumerateImpl <em>Enumerate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.impl.EnumerateImpl
		 * @see modif.impl.ModifPackageImpl#getEnumerate()
		 * @generated
		 */
		EClass ENUMERATE = eINSTANCE.getEnumerate();

		/**
		 * The meta object literal for the '<em><b>Enum Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATE__ENUM_NAME = eINSTANCE.getEnumerate_EnumName();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATE__ATTRIBUTE_NAME = eINSTANCE.getEnumerate_AttributeName();

		/**
		 * The meta object literal for the '{@link modif.PrimitiveType <em>Primitive Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see modif.PrimitiveType
		 * @see modif.impl.ModifPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EEnum PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

	}

} //ModifPackage
