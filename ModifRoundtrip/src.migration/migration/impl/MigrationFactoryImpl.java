/**
 */
package migration.impl;

import migration.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MigrationFactoryImpl extends EFactoryImpl implements MigrationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MigrationFactory init() {
		try {
			MigrationFactory theMigrationFactory = (MigrationFactory)EPackage.Registry.INSTANCE.getEFactory(MigrationPackage.eNS_URI);
			if (theMigrationFactory != null) {
				return theMigrationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MigrationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MigrationPackage.MIGRATION: return createMigration();
			case MigrationPackage.INSTANCE: return createInstance();
			case MigrationPackage.DELETION: return createDeletion();
			case MigrationPackage.DELETED_ATTRIBUTE: return createDeletedAttribute();
			case MigrationPackage.DELETED_REFERENCE: return createDeletedReference();
			case MigrationPackage.DERIVED_REFERENCE: return createDerivedReference();
			case MigrationPackage.REFERENCE_PATH: return createReferencePath();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Migration createMigration() {
		MigrationImpl migration = new MigrationImpl();
		return migration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Instance createInstance() {
		InstanceImpl instance = new InstanceImpl();
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deletion createDeletion() {
		DeletionImpl deletion = new DeletionImpl();
		return deletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeletedAttribute createDeletedAttribute() {
		DeletedAttributeImpl deletedAttribute = new DeletedAttributeImpl();
		return deletedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeletedReference createDeletedReference() {
		DeletedReferenceImpl deletedReference = new DeletedReferenceImpl();
		return deletedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivedReference createDerivedReference() {
		DerivedReferenceImpl derivedReference = new DerivedReferenceImpl();
		return derivedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferencePath createReferencePath() {
		ReferencePathImpl referencePath = new ReferencePathImpl();
		return referencePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MigrationPackage getMigrationPackage() {
		return (MigrationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MigrationPackage getPackage() {
		return MigrationPackage.eINSTANCE;
	}

} //MigrationFactoryImpl
