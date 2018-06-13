/**
 */
package migration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see migration.MigrationFactory
 * @model kind="package"
 * @generated
 */
public interface MigrationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "migration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/resource/Migration/model/Migration.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "migration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MigrationPackage eINSTANCE = migration.impl.MigrationPackageImpl.init();

	/**
	 * The meta object id for the '{@link migration.impl.MigrationImpl <em>Migration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see migration.impl.MigrationImpl
	 * @see migration.impl.MigrationPackageImpl#getMigration()
	 * @generated
	 */
	int MIGRATION = 0;

	/**
	 * The feature id for the '<em><b>Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__INSTANCES = 0;

	/**
	 * The feature id for the '<em><b>Input Model URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__INPUT_MODEL_URI = 1;
	
	int MIGRATION__INPUT_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Input Metamodel URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__INPUT_METAMODEL_URI = 3;

	/**
	 * The feature id for the '<em><b>Output Model URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__OUTPUT_MODEL_URI = 4;

	/**
	 * The feature id for the '<em><b>Output Metamodel URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION__OUTPUT_METAMODEL_URI = 5;

	/**
	 * The number of structural features of the '<em>Migration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Migration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MIGRATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link migration.impl.InstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see migration.impl.InstanceImpl
	 * @see migration.impl.MigrationPackageImpl#getInstance()
	 * @generated
	 */
	int INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>UUID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__UUID = 0;

	/**
	 * The feature id for the '<em><b>Deletion</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__DELETION = 1;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__DERIVED = 2;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link migration.impl.DeletionImpl <em>Deletion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see migration.impl.DeletionImpl
	 * @see migration.impl.MigrationPackageImpl#getDeletion()
	 * @generated
	 */
	int DELETION = 2;

	/**
	 * The feature id for the '<em><b>Deleted Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETION__DELETED_ATTRIBUTES = 0;

	/**
	 * The feature id for the '<em><b>Deleted References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETION__DELETED_REFERENCES = 1;

	/**
	 * The feature id for the '<em><b>Delete Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETION__DELETE_INSTANCE = 2;

	/**
	 * The number of structural features of the '<em>Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link migration.impl.DeletedAttributeImpl <em>Deleted Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see migration.impl.DeletedAttributeImpl
	 * @see migration.impl.MigrationPackageImpl#getDeletedAttribute()
	 * @generated
	 */
	int DELETED_ATTRIBUTE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETED_ATTRIBUTE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Deleted Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETED_ATTRIBUTE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Deleted Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETED_ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link migration.impl.DeletedReferenceImpl <em>Deleted Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see migration.impl.DeletedReferenceImpl
	 * @see migration.impl.MigrationPackageImpl#getDeletedReference()
	 * @generated
	 */
	int DELETED_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETED_REFERENCE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Deleted Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETED_REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Deleted Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETED_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link migration.impl.DerivedReferenceImpl <em>Derived Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see migration.impl.DerivedReferenceImpl
	 * @see migration.impl.MigrationPackageImpl#getDerivedReference()
	 * @generated
	 */
	int DERIVED_REFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_REFERENCE__PATH = 0;

	/**
	 * The feature id for the '<em><b>New Reference Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_REFERENCE__NEW_REFERENCE_NAME = 1;

	/**
	 * The number of structural features of the '<em>Derived Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_REFERENCE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Derived Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link migration.impl.ReferencePathImpl <em>Reference Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see migration.impl.ReferencePathImpl
	 * @see migration.impl.MigrationPackageImpl#getReferencePath()
	 * @generated
	 */
	int REFERENCE_PATH = 6;

	/**
	 * The feature id for the '<em><b>Reference Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PATH__REFERENCE_NAME = 0;

	/**
	 * The number of structural features of the '<em>Reference Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PATH_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Reference Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PATH_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link migration.Migration <em>Migration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Migration</em>'.
	 * @see migration.Migration
	 * @generated
	 */
	EClass getMigration();

	/**
	 * Returns the meta object for the containment reference list '{@link migration.Migration#getInstances <em>Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Instances</em>'.
	 * @see migration.Migration#getInstances()
	 * @see #getMigration()
	 * @generated
	 */
	EReference getMigration_Instances();

	/**
	 * Returns the meta object for the attribute '{@link migration.Migration#getInputModelURI <em>Input Model URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Model URI</em>'.
	 * @see migration.Migration#getInputModelURI()
	 * @see #getMigration()
	 * @generated
	 */
	EAttribute getMigration_InputModelURI();

	/**
	 * Returns the meta object for the attribute '{@link migration.Migration#getInputMetamodelURI <em>Input Metamodel URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Metamodel URI</em>'.
	 * @see migration.Migration#getInputMetamodelURI()
	 * @see #getMigration()
	 * @generated
	 */
	EAttribute getMigration_InputMetamodelURI();

	/**
	 * Returns the meta object for the attribute '{@link migration.Migration#getOutputModelURI <em>Output Model URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Model URI</em>'.
	 * @see migration.Migration#getOutputModelURI()
	 * @see #getMigration()
	 * @generated
	 */
	EAttribute getMigration_OutputModelURI();

	/**
	 * Returns the meta object for the attribute '{@link migration.Migration#getOutputMetamodelURI <em>Output Metamodel URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Metamodel URI</em>'.
	 * @see migration.Migration#getOutputMetamodelURI()
	 * @see #getMigration()
	 * @generated
	 */
	EAttribute getMigration_OutputMetamodelURI();

	/**
	 * Returns the meta object for class '{@link migration.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see migration.Instance
	 * @generated
	 */
	EClass getInstance();

	/**
	 * Returns the meta object for the attribute '{@link migration.Instance#getUUID <em>UUID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>UUID</em>'.
	 * @see migration.Instance#getUUID()
	 * @see #getInstance()
	 * @generated
	 */
	EAttribute getInstance_UUID();

	/**
	 * Returns the meta object for the containment reference '{@link migration.Instance#getDeletion <em>Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deletion</em>'.
	 * @see migration.Instance#getDeletion()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_Deletion();

	/**
	 * Returns the meta object for the containment reference list '{@link migration.Instance#getDerived <em>Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Derived</em>'.
	 * @see migration.Instance#getDerived()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_Derived();

	/**
	 * Returns the meta object for class '{@link migration.Deletion <em>Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deletion</em>'.
	 * @see migration.Deletion
	 * @generated
	 */
	EClass getDeletion();

	/**
	 * Returns the meta object for the containment reference list '{@link migration.Deletion#getDeletedAttributes <em>Deleted Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deleted Attributes</em>'.
	 * @see migration.Deletion#getDeletedAttributes()
	 * @see #getDeletion()
	 * @generated
	 */
	EReference getDeletion_DeletedAttributes();

	/**
	 * Returns the meta object for the containment reference list '{@link migration.Deletion#getDeletedReferences <em>Deleted References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deleted References</em>'.
	 * @see migration.Deletion#getDeletedReferences()
	 * @see #getDeletion()
	 * @generated
	 */
	EReference getDeletion_DeletedReferences();

	/**
	 * Returns the meta object for the attribute '{@link migration.Deletion#isDeleteInstance <em>Delete Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delete Instance</em>'.
	 * @see migration.Deletion#isDeleteInstance()
	 * @see #getDeletion()
	 * @generated
	 */
	EAttribute getDeletion_DeleteInstance();

	/**
	 * Returns the meta object for class '{@link migration.DeletedAttribute <em>Deleted Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deleted Attribute</em>'.
	 * @see migration.DeletedAttribute
	 * @generated
	 */
	EClass getDeletedAttribute();

	/**
	 * Returns the meta object for the attribute '{@link migration.DeletedAttribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see migration.DeletedAttribute#getName()
	 * @see #getDeletedAttribute()
	 * @generated
	 */
	EAttribute getDeletedAttribute_Name();

	/**
	 * Returns the meta object for class '{@link migration.DeletedReference <em>Deleted Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deleted Reference</em>'.
	 * @see migration.DeletedReference
	 * @generated
	 */
	EClass getDeletedReference();

	/**
	 * Returns the meta object for the attribute '{@link migration.DeletedReference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see migration.DeletedReference#getName()
	 * @see #getDeletedReference()
	 * @generated
	 */
	EAttribute getDeletedReference_Name();

	/**
	 * Returns the meta object for class '{@link migration.DerivedReference <em>Derived Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derived Reference</em>'.
	 * @see migration.DerivedReference
	 * @generated
	 */
	EClass getDerivedReference();

	/**
	 * Returns the meta object for the containment reference list '{@link migration.DerivedReference#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Path</em>'.
	 * @see migration.DerivedReference#getPath()
	 * @see #getDerivedReference()
	 * @generated
	 */
	EReference getDerivedReference_Path();

	/**
	 * Returns the meta object for the attribute '{@link migration.DerivedReference#getNewReferenceName <em>New Reference Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Reference Name</em>'.
	 * @see migration.DerivedReference#getNewReferenceName()
	 * @see #getDerivedReference()
	 * @generated
	 */
	EAttribute getDerivedReference_NewReferenceName();

	/**
	 * Returns the meta object for class '{@link migration.ReferencePath <em>Reference Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Path</em>'.
	 * @see migration.ReferencePath
	 * @generated
	 */
	EClass getReferencePath();

	/**
	 * Returns the meta object for the attribute '{@link migration.ReferencePath#getReferenceName <em>Reference Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Reference Name</em>'.
	 * @see migration.ReferencePath#getReferenceName()
	 * @see #getReferencePath()
	 * @generated
	 */
	EAttribute getReferencePath_ReferenceName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MigrationFactory getMigrationFactory();

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
		 * The meta object literal for the '{@link migration.impl.MigrationImpl <em>Migration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see migration.impl.MigrationImpl
		 * @see migration.impl.MigrationPackageImpl#getMigration()
		 * @generated
		 */
		EClass MIGRATION = eINSTANCE.getMigration();

		/**
		 * The meta object literal for the '<em><b>Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MIGRATION__INSTANCES = eINSTANCE.getMigration_Instances();

		/**
		 * The meta object literal for the '<em><b>Input Model URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION__INPUT_MODEL_URI = eINSTANCE.getMigration_InputModelURI();

		/**
		 * The meta object literal for the '<em><b>Input Metamodel URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION__INPUT_METAMODEL_URI = eINSTANCE.getMigration_InputMetamodelURI();

		/**
		 * The meta object literal for the '<em><b>Output Model URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION__OUTPUT_MODEL_URI = eINSTANCE.getMigration_OutputModelURI();

		/**
		 * The meta object literal for the '<em><b>Output Metamodel URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MIGRATION__OUTPUT_METAMODEL_URI = eINSTANCE.getMigration_OutputMetamodelURI();

		/**
		 * The meta object literal for the '{@link migration.impl.InstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see migration.impl.InstanceImpl
		 * @see migration.impl.MigrationPackageImpl#getInstance()
		 * @generated
		 */
		EClass INSTANCE = eINSTANCE.getInstance();

		/**
		 * The meta object literal for the '<em><b>UUID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE__UUID = eINSTANCE.getInstance_UUID();

		/**
		 * The meta object literal for the '<em><b>Deletion</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE__DELETION = eINSTANCE.getInstance_Deletion();

		/**
		 * The meta object literal for the '<em><b>Derived</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE__DERIVED = eINSTANCE.getInstance_Derived();

		/**
		 * The meta object literal for the '{@link migration.impl.DeletionImpl <em>Deletion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see migration.impl.DeletionImpl
		 * @see migration.impl.MigrationPackageImpl#getDeletion()
		 * @generated
		 */
		EClass DELETION = eINSTANCE.getDeletion();

		/**
		 * The meta object literal for the '<em><b>Deleted Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETION__DELETED_ATTRIBUTES = eINSTANCE.getDeletion_DeletedAttributes();

		/**
		 * The meta object literal for the '<em><b>Deleted References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETION__DELETED_REFERENCES = eINSTANCE.getDeletion_DeletedReferences();

		/**
		 * The meta object literal for the '<em><b>Delete Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELETION__DELETE_INSTANCE = eINSTANCE.getDeletion_DeleteInstance();

		/**
		 * The meta object literal for the '{@link migration.impl.DeletedAttributeImpl <em>Deleted Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see migration.impl.DeletedAttributeImpl
		 * @see migration.impl.MigrationPackageImpl#getDeletedAttribute()
		 * @generated
		 */
		EClass DELETED_ATTRIBUTE = eINSTANCE.getDeletedAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELETED_ATTRIBUTE__NAME = eINSTANCE.getDeletedAttribute_Name();

		/**
		 * The meta object literal for the '{@link migration.impl.DeletedReferenceImpl <em>Deleted Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see migration.impl.DeletedReferenceImpl
		 * @see migration.impl.MigrationPackageImpl#getDeletedReference()
		 * @generated
		 */
		EClass DELETED_REFERENCE = eINSTANCE.getDeletedReference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DELETED_REFERENCE__NAME = eINSTANCE.getDeletedReference_Name();

		/**
		 * The meta object literal for the '{@link migration.impl.DerivedReferenceImpl <em>Derived Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see migration.impl.DerivedReferenceImpl
		 * @see migration.impl.MigrationPackageImpl#getDerivedReference()
		 * @generated
		 */
		EClass DERIVED_REFERENCE = eINSTANCE.getDerivedReference();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVED_REFERENCE__PATH = eINSTANCE.getDerivedReference_Path();

		/**
		 * The meta object literal for the '<em><b>New Reference Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DERIVED_REFERENCE__NEW_REFERENCE_NAME = eINSTANCE.getDerivedReference_NewReferenceName();

		/**
		 * The meta object literal for the '{@link migration.impl.ReferencePathImpl <em>Reference Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see migration.impl.ReferencePathImpl
		 * @see migration.impl.MigrationPackageImpl#getReferencePath()
		 * @generated
		 */
		EClass REFERENCE_PATH = eINSTANCE.getReferencePath();

		/**
		 * The meta object literal for the '<em><b>Reference Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REFERENCE_PATH__REFERENCE_NAME = eINSTANCE.getReferencePath_ReferenceName();

	}

} //MigrationPackage
