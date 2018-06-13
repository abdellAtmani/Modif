/**
 */
package modif.impl;

import modif.AddAttribute;
import modif.AddDerived;
import modif.AddDerivedAttribute;
import modif.AddDerivedReference;
import modif.AddFeature;
import modif.AddNameClass;
import modif.AddOpposite;
import modif.AddReference;
import modif.AddRootClass;
import modif.AnnotationModification;
import modif.AttributeModification;
import modif.ChangeBounds;
import modif.ClassModification;
import modif.DataTypeModification;
import modif.DetailsEntryModification;
import modif.EnumLiteralModification;
import modif.EnumModification;
import modif.Enumerate;
import modif.ModifFactory;
import modif.ModifPackage;
import modif.Modification;
import modif.Modifications;
import modif.PackageModification;
import modif.PrimitiveType;
import modif.ReferenceModification;
import modif.ReferenceReification;
import modif.StructuralFeatureModification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModifPackageImpl extends EPackageImpl implements ModifPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modificationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageModificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classModificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralFeatureModificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeModificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceModificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeBoundsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeModificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumModificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumLiteralModificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationModificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass detailsEntryModificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addOppositeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addRootClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addNameClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addDerivedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addDerivedReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addDerivedAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceReificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum primitiveTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see modif.ModifPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModifPackageImpl() {
		super(eNS_URI, ModifFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ModifPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModifPackage init() {
		if (isInited) return (ModifPackage)EPackage.Registry.INSTANCE.getEPackage(ModifPackage.eNS_URI);

		// Obtain or create and register package
		ModifPackageImpl theModifPackage = (ModifPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModifPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModifPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theModifPackage.createPackageContents();

		// Initialize created meta-data
		theModifPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModifPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModifPackage.eNS_URI, theModifPackage);
		return theModifPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifications() {
		return modificationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifications_RootPackageModification() {
		return (EReference)modificationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifications_AddRootClass() {
		return (EReference)modificationsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifications_AddNameClass() {
		return (EReference)modificationsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifications_RemoveAllAnnotations() {
		return (EAttribute)modificationsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifications_RemoveAllOperations() {
		return (EAttribute)modificationsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifications_RemoveAllEStringAttributes() {
		return (EAttribute)modificationsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifications_RemoveAllOpposites() {
		return (EAttribute)modificationsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModifications_AddAllOpposite() {
		return (EAttribute)modificationsEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModification() {
		return modificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModification_OldName() {
		return (EAttribute)modificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModification_NewName() {
		return (EAttribute)modificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModification_Remove() {
		return (EAttribute)modificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModification_RemoveEAnnotations() {
		return (EAttribute)modificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModification_AnnotationModification() {
		return (EReference)modificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageModification() {
		return packageModificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageModification_OldPrefixName() {
		return (EAttribute)packageModificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageModification_NewPrefixName() {
		return (EAttribute)packageModificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageModification_OldURIName() {
		return (EAttribute)packageModificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageModification_NewURIName() {
		return (EAttribute)packageModificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageModification_Hide() {
		return (EAttribute)packageModificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageModification_PackageModification() {
		return (EReference)packageModificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageModification_ClassModification() {
		return (EReference)packageModificationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageModification_DataTypeModification() {
		return (EReference)packageModificationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageModification_EnumModification() {
		return (EReference)packageModificationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassModification() {
		return classModificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassModification_ChangeAbstract() {
		return (EAttribute)classModificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassModification_Hide() {
		return (EAttribute)classModificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassModification_Flatten() {
		return (EAttribute)classModificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassModification_FlattenAll() {
		return (EAttribute)classModificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassModification_FeatureModification() {
		return (EReference)classModificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassModification_AddFeatures() {
		return (EReference)classModificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassModification_AddDeriveds() {
		return (EReference)classModificationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassModification_Enumerate() {
		return (EReference)classModificationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralFeatureModification() {
		return structuralFeatureModificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeModification() {
		return attributeModificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeModification_ChangeType() {
		return (EAttribute)attributeModificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeModification_NewType() {
		return (EAttribute)attributeModificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeModification_ChangeBounds() {
		return (EReference)attributeModificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceModification() {
		return referenceModificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceModification_ChangeBounds() {
		return (EReference)referenceModificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceModification_ChangeContainement() {
		return (EAttribute)referenceModificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceModification_RemoveOpposite() {
		return (EAttribute)referenceModificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceModification_AddOpposite() {
		return (EReference)referenceModificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceModification_Reify() {
		return (EReference)referenceModificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChangeBounds() {
		return changeBoundsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeBounds_OldLower() {
		return (EAttribute)changeBoundsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeBounds_NewLower() {
		return (EAttribute)changeBoundsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeBounds_OldUpper() {
		return (EAttribute)changeBoundsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChangeBounds_NewUpper() {
		return (EAttribute)changeBoundsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeModification() {
		return dataTypeModificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataTypeModification_OldInstanceTypeName() {
		return (EAttribute)dataTypeModificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataTypeModification_NewInstanceTypeName() {
		return (EAttribute)dataTypeModificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumModification() {
		return enumModificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumModification_OldInstanceTypeName() {
		return (EAttribute)enumModificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumModification_NewInstanceTypeName() {
		return (EAttribute)enumModificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumModification_Reify() {
		return (EAttribute)enumModificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumModification_EnumLiteralModification() {
		return (EReference)enumModificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumLiteralModification() {
		return enumLiteralModificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumLiteralModification_OldLiteral() {
		return (EAttribute)enumLiteralModificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumLiteralModification_NewLiteral() {
		return (EAttribute)enumLiteralModificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumLiteralModification_OldValue() {
		return (EAttribute)enumLiteralModificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumLiteralModification_NewValue() {
		return (EAttribute)enumLiteralModificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationModification() {
		return annotationModificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationModification_OldSource() {
		return (EAttribute)annotationModificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationModification_NewSource() {
		return (EAttribute)annotationModificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationModification_RemoveEAnnotations() {
		return (EAttribute)annotationModificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationModification_Remove() {
		return (EAttribute)annotationModificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationModification_DetailsEntryModification() {
		return (EReference)annotationModificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationModification_AnnotationModification() {
		return (EReference)annotationModificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDetailsEntryModification() {
		return detailsEntryModificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetailsEntryModification_OldKey() {
		return (EAttribute)detailsEntryModificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetailsEntryModification_NewKey() {
		return (EAttribute)detailsEntryModificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetailsEntryModification_OldValue() {
		return (EAttribute)detailsEntryModificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetailsEntryModification_NewValue() {
		return (EAttribute)detailsEntryModificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetailsEntryModification_Remove() {
		return (EAttribute)detailsEntryModificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddFeature() {
		return addFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddFeature_Name() {
		return (EAttribute)addFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddFeature_Lower() {
		return (EAttribute)addFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddFeature_Upper() {
		return (EAttribute)addFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddAttribute() {
		return addAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddAttribute_Type() {
		return (EAttribute)addAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddAttribute_DefaultValue() {
		return (EAttribute)addAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddReference() {
		return addReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddReference_Type() {
		return (EAttribute)addReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddOpposite() {
		return addOppositeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddOpposite_OppositeName() {
		return (EAttribute)addOppositeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddOpposite_OppositeLower() {
		return (EAttribute)addOppositeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddOpposite_OppositeUpper() {
		return (EAttribute)addOppositeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddRootClass() {
		return addRootClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddRootClass_Name() {
		return (EAttribute)addRootClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddNameClass() {
		return addNameClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddNameClass_Name() {
		return (EAttribute)addNameClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddNameClass_NameName() {
		return (EAttribute)addNameClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddDerived() {
		return addDerivedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddDerived_NewName() {
		return (EAttribute)addDerivedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddDerived_ReferenceName() {
		return (EAttribute)addDerivedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddDerivedReference() {
		return addDerivedReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddDerivedAttribute() {
		return addDerivedAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddDerivedAttribute_AttributeName() {
		return (EAttribute)addDerivedAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceReification() {
		return referenceReificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceReification_NameClass() {
		return (EAttribute)referenceReificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceReification_NameFirstReference() {
		return (EAttribute)referenceReificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceReification_NameSecondReference() {
		return (EAttribute)referenceReificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerate() {
		return enumerateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerate_EnumName() {
		return (EAttribute)enumerateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerate_AttributeName() {
		return (EAttribute)enumerateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPrimitiveType() {
		return primitiveTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifFactory getModifFactory() {
		return (ModifFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		modificationsEClass = createEClass(MODIFICATIONS);
		createEReference(modificationsEClass, MODIFICATIONS__ROOT_PACKAGE_MODIFICATION);
		createEReference(modificationsEClass, MODIFICATIONS__ADD_ROOT_CLASS);
		createEReference(modificationsEClass, MODIFICATIONS__ADD_NAME_CLASS);
		createEAttribute(modificationsEClass, MODIFICATIONS__REMOVE_ALL_ANNOTATIONS);
		createEAttribute(modificationsEClass, MODIFICATIONS__REMOVE_ALL_OPERATIONS);
		createEAttribute(modificationsEClass, MODIFICATIONS__REMOVE_ALL_ESTRING_ATTRIBUTES);
		createEAttribute(modificationsEClass, MODIFICATIONS__REMOVE_ALL_OPPOSITES);
		createEAttribute(modificationsEClass, MODIFICATIONS__ADD_ALL_OPPOSITE);

		modificationEClass = createEClass(MODIFICATION);
		createEAttribute(modificationEClass, MODIFICATION__OLD_NAME);
		createEAttribute(modificationEClass, MODIFICATION__NEW_NAME);
		createEAttribute(modificationEClass, MODIFICATION__REMOVE);
		createEAttribute(modificationEClass, MODIFICATION__REMOVE_EANNOTATIONS);
		createEReference(modificationEClass, MODIFICATION__ANNOTATION_MODIFICATION);

		packageModificationEClass = createEClass(PACKAGE_MODIFICATION);
		createEAttribute(packageModificationEClass, PACKAGE_MODIFICATION__OLD_PREFIX_NAME);
		createEAttribute(packageModificationEClass, PACKAGE_MODIFICATION__NEW_PREFIX_NAME);
		createEAttribute(packageModificationEClass, PACKAGE_MODIFICATION__OLD_URI_NAME);
		createEAttribute(packageModificationEClass, PACKAGE_MODIFICATION__NEW_URI_NAME);
		createEAttribute(packageModificationEClass, PACKAGE_MODIFICATION__HIDE);
		createEReference(packageModificationEClass, PACKAGE_MODIFICATION__PACKAGE_MODIFICATION);
		createEReference(packageModificationEClass, PACKAGE_MODIFICATION__CLASS_MODIFICATION);
		createEReference(packageModificationEClass, PACKAGE_MODIFICATION__DATA_TYPE_MODIFICATION);
		createEReference(packageModificationEClass, PACKAGE_MODIFICATION__ENUM_MODIFICATION);

		classModificationEClass = createEClass(CLASS_MODIFICATION);
		createEAttribute(classModificationEClass, CLASS_MODIFICATION__CHANGE_ABSTRACT);
		createEAttribute(classModificationEClass, CLASS_MODIFICATION__HIDE);
		createEAttribute(classModificationEClass, CLASS_MODIFICATION__FLATTEN);
		createEAttribute(classModificationEClass, CLASS_MODIFICATION__FLATTEN_ALL);
		createEReference(classModificationEClass, CLASS_MODIFICATION__FEATURE_MODIFICATION);
		createEReference(classModificationEClass, CLASS_MODIFICATION__ADD_FEATURES);
		createEReference(classModificationEClass, CLASS_MODIFICATION__ADD_DERIVEDS);
		createEReference(classModificationEClass, CLASS_MODIFICATION__ENUMERATE);

		structuralFeatureModificationEClass = createEClass(STRUCTURAL_FEATURE_MODIFICATION);

		attributeModificationEClass = createEClass(ATTRIBUTE_MODIFICATION);
		createEAttribute(attributeModificationEClass, ATTRIBUTE_MODIFICATION__CHANGE_TYPE);
		createEAttribute(attributeModificationEClass, ATTRIBUTE_MODIFICATION__NEW_TYPE);
		createEReference(attributeModificationEClass, ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS);

		referenceModificationEClass = createEClass(REFERENCE_MODIFICATION);
		createEReference(referenceModificationEClass, REFERENCE_MODIFICATION__CHANGE_BOUNDS);
		createEAttribute(referenceModificationEClass, REFERENCE_MODIFICATION__CHANGE_CONTAINEMENT);
		createEAttribute(referenceModificationEClass, REFERENCE_MODIFICATION__REMOVE_OPPOSITE);
		createEReference(referenceModificationEClass, REFERENCE_MODIFICATION__ADD_OPPOSITE);
		createEReference(referenceModificationEClass, REFERENCE_MODIFICATION__REIFY);

		changeBoundsEClass = createEClass(CHANGE_BOUNDS);
		createEAttribute(changeBoundsEClass, CHANGE_BOUNDS__OLD_LOWER);
		createEAttribute(changeBoundsEClass, CHANGE_BOUNDS__NEW_LOWER);
		createEAttribute(changeBoundsEClass, CHANGE_BOUNDS__OLD_UPPER);
		createEAttribute(changeBoundsEClass, CHANGE_BOUNDS__NEW_UPPER);

		dataTypeModificationEClass = createEClass(DATA_TYPE_MODIFICATION);
		createEAttribute(dataTypeModificationEClass, DATA_TYPE_MODIFICATION__OLD_INSTANCE_TYPE_NAME);
		createEAttribute(dataTypeModificationEClass, DATA_TYPE_MODIFICATION__NEW_INSTANCE_TYPE_NAME);

		enumModificationEClass = createEClass(ENUM_MODIFICATION);
		createEAttribute(enumModificationEClass, ENUM_MODIFICATION__OLD_INSTANCE_TYPE_NAME);
		createEAttribute(enumModificationEClass, ENUM_MODIFICATION__NEW_INSTANCE_TYPE_NAME);
		createEAttribute(enumModificationEClass, ENUM_MODIFICATION__REIFY);
		createEReference(enumModificationEClass, ENUM_MODIFICATION__ENUM_LITERAL_MODIFICATION);

		enumLiteralModificationEClass = createEClass(ENUM_LITERAL_MODIFICATION);
		createEAttribute(enumLiteralModificationEClass, ENUM_LITERAL_MODIFICATION__OLD_LITERAL);
		createEAttribute(enumLiteralModificationEClass, ENUM_LITERAL_MODIFICATION__NEW_LITERAL);
		createEAttribute(enumLiteralModificationEClass, ENUM_LITERAL_MODIFICATION__OLD_VALUE);
		createEAttribute(enumLiteralModificationEClass, ENUM_LITERAL_MODIFICATION__NEW_VALUE);

		annotationModificationEClass = createEClass(ANNOTATION_MODIFICATION);
		createEAttribute(annotationModificationEClass, ANNOTATION_MODIFICATION__OLD_SOURCE);
		createEAttribute(annotationModificationEClass, ANNOTATION_MODIFICATION__NEW_SOURCE);
		createEAttribute(annotationModificationEClass, ANNOTATION_MODIFICATION__REMOVE_EANNOTATIONS);
		createEAttribute(annotationModificationEClass, ANNOTATION_MODIFICATION__REMOVE);
		createEReference(annotationModificationEClass, ANNOTATION_MODIFICATION__DETAILS_ENTRY_MODIFICATION);
		createEReference(annotationModificationEClass, ANNOTATION_MODIFICATION__ANNOTATION_MODIFICATION);

		detailsEntryModificationEClass = createEClass(DETAILS_ENTRY_MODIFICATION);
		createEAttribute(detailsEntryModificationEClass, DETAILS_ENTRY_MODIFICATION__OLD_KEY);
		createEAttribute(detailsEntryModificationEClass, DETAILS_ENTRY_MODIFICATION__NEW_KEY);
		createEAttribute(detailsEntryModificationEClass, DETAILS_ENTRY_MODIFICATION__OLD_VALUE);
		createEAttribute(detailsEntryModificationEClass, DETAILS_ENTRY_MODIFICATION__NEW_VALUE);
		createEAttribute(detailsEntryModificationEClass, DETAILS_ENTRY_MODIFICATION__REMOVE);

		addFeatureEClass = createEClass(ADD_FEATURE);
		createEAttribute(addFeatureEClass, ADD_FEATURE__NAME);
		createEAttribute(addFeatureEClass, ADD_FEATURE__LOWER);
		createEAttribute(addFeatureEClass, ADD_FEATURE__UPPER);

		addAttributeEClass = createEClass(ADD_ATTRIBUTE);
		createEAttribute(addAttributeEClass, ADD_ATTRIBUTE__TYPE);
		createEAttribute(addAttributeEClass, ADD_ATTRIBUTE__DEFAULT_VALUE);

		addReferenceEClass = createEClass(ADD_REFERENCE);
		createEAttribute(addReferenceEClass, ADD_REFERENCE__TYPE);

		addOppositeEClass = createEClass(ADD_OPPOSITE);
		createEAttribute(addOppositeEClass, ADD_OPPOSITE__OPPOSITE_NAME);
		createEAttribute(addOppositeEClass, ADD_OPPOSITE__OPPOSITE_LOWER);
		createEAttribute(addOppositeEClass, ADD_OPPOSITE__OPPOSITE_UPPER);

		addRootClassEClass = createEClass(ADD_ROOT_CLASS);
		createEAttribute(addRootClassEClass, ADD_ROOT_CLASS__NAME);

		addNameClassEClass = createEClass(ADD_NAME_CLASS);
		createEAttribute(addNameClassEClass, ADD_NAME_CLASS__NAME);
		createEAttribute(addNameClassEClass, ADD_NAME_CLASS__NAME_NAME);

		addDerivedEClass = createEClass(ADD_DERIVED);
		createEAttribute(addDerivedEClass, ADD_DERIVED__NEW_NAME);
		createEAttribute(addDerivedEClass, ADD_DERIVED__REFERENCE_NAME);

		addDerivedReferenceEClass = createEClass(ADD_DERIVED_REFERENCE);

		addDerivedAttributeEClass = createEClass(ADD_DERIVED_ATTRIBUTE);
		createEAttribute(addDerivedAttributeEClass, ADD_DERIVED_ATTRIBUTE__ATTRIBUTE_NAME);

		referenceReificationEClass = createEClass(REFERENCE_REIFICATION);
		createEAttribute(referenceReificationEClass, REFERENCE_REIFICATION__NAME_CLASS);
		createEAttribute(referenceReificationEClass, REFERENCE_REIFICATION__NAME_FIRST_REFERENCE);
		createEAttribute(referenceReificationEClass, REFERENCE_REIFICATION__NAME_SECOND_REFERENCE);

		enumerateEClass = createEClass(ENUMERATE);
		createEAttribute(enumerateEClass, ENUMERATE__ENUM_NAME);
		createEAttribute(enumerateEClass, ENUMERATE__ATTRIBUTE_NAME);

		// Create enums
		primitiveTypeEEnum = createEEnum(PRIMITIVE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		packageModificationEClass.getESuperTypes().add(this.getModification());
		classModificationEClass.getESuperTypes().add(this.getModification());
		structuralFeatureModificationEClass.getESuperTypes().add(this.getModification());
		attributeModificationEClass.getESuperTypes().add(this.getStructuralFeatureModification());
		referenceModificationEClass.getESuperTypes().add(this.getStructuralFeatureModification());
		dataTypeModificationEClass.getESuperTypes().add(this.getModification());
		enumModificationEClass.getESuperTypes().add(this.getModification());
		enumLiteralModificationEClass.getESuperTypes().add(this.getModification());
		addAttributeEClass.getESuperTypes().add(this.getAddFeature());
		addReferenceEClass.getESuperTypes().add(this.getAddFeature());
		addDerivedReferenceEClass.getESuperTypes().add(this.getAddDerived());
		addDerivedAttributeEClass.getESuperTypes().add(this.getAddDerived());

		// Initialize classes, features, and operations; add parameters
		initEClass(modificationsEClass, Modifications.class, "Modifications", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifications_RootPackageModification(), this.getPackageModification(), null, "rootPackageModification", null, 0, 1, Modifications.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifications_AddRootClass(), this.getAddRootClass(), null, "addRootClass", null, 0, 1, Modifications.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifications_AddNameClass(), this.getAddNameClass(), null, "addNameClass", null, 0, 1, Modifications.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModifications_RemoveAllAnnotations(), ecorePackage.getEBoolean(), "removeAllAnnotations", "false", 0, 1, Modifications.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModifications_RemoveAllOperations(), ecorePackage.getEBoolean(), "removeAllOperations", "false", 0, 1, Modifications.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModifications_RemoveAllEStringAttributes(), ecorePackage.getEBoolean(), "removeAllEStringAttributes", "false", 0, 1, Modifications.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModifications_RemoveAllOpposites(), ecorePackage.getEBoolean(), "removeAllOpposites", "false", 0, 1, Modifications.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModifications_AddAllOpposite(), ecorePackage.getEBoolean(), "addAllOpposite", "false", 0, 1, Modifications.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modificationEClass, Modification.class, "Modification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModification_OldName(), ecorePackage.getEString(), "oldName", "", 1, 1, Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModification_NewName(), ecorePackage.getEString(), "newName", "", 0, 1, Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModification_Remove(), ecorePackage.getEBoolean(), "remove", "false", 0, 1, Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModification_RemoveEAnnotations(), ecorePackage.getEBoolean(), "removeEAnnotations", "false", 0, 1, Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModification_AnnotationModification(), this.getAnnotationModification(), null, "annotationModification", null, 0, -1, Modification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageModificationEClass, PackageModification.class, "PackageModification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPackageModification_OldPrefixName(), ecorePackage.getEString(), "oldPrefixName", null, 0, 1, PackageModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModification_NewPrefixName(), ecorePackage.getEString(), "newPrefixName", null, 0, 1, PackageModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModification_OldURIName(), ecorePackage.getEString(), "oldURIName", null, 0, 1, PackageModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModification_NewURIName(), ecorePackage.getEString(), "newURIName", null, 0, 1, PackageModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageModification_Hide(), ecorePackage.getEBoolean(), "hide", "false", 0, 1, PackageModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageModification_PackageModification(), this.getPackageModification(), null, "packageModification", null, 0, -1, PackageModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageModification_ClassModification(), this.getClassModification(), null, "classModification", null, 0, -1, PackageModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageModification_DataTypeModification(), this.getDataTypeModification(), null, "dataTypeModification", null, 0, -1, PackageModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageModification_EnumModification(), this.getEnumModification(), null, "enumModification", null, 0, -1, PackageModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classModificationEClass, ClassModification.class, "ClassModification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassModification_ChangeAbstract(), ecorePackage.getEBoolean(), "changeAbstract", "false", 0, 1, ClassModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassModification_Hide(), ecorePackage.getEBoolean(), "hide", "false", 0, 1, ClassModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassModification_Flatten(), ecorePackage.getEBoolean(), "flatten", "false", 0, 1, ClassModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassModification_FlattenAll(), ecorePackage.getEBoolean(), "flattenAll", "false", 0, 1, ClassModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassModification_FeatureModification(), this.getStructuralFeatureModification(), null, "featureModification", null, 0, -1, ClassModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassModification_AddFeatures(), this.getAddFeature(), null, "addFeatures", null, 0, -1, ClassModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassModification_AddDeriveds(), this.getAddDerived(), null, "addDeriveds", null, 0, -1, ClassModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassModification_Enumerate(), this.getEnumerate(), null, "enumerate", null, 0, 1, ClassModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuralFeatureModificationEClass, StructuralFeatureModification.class, "StructuralFeatureModification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeModificationEClass, AttributeModification.class, "AttributeModification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeModification_ChangeType(), ecorePackage.getEBoolean(), "changeType", "false", 0, 1, AttributeModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeModification_NewType(), this.getPrimitiveType(), "newType", "int", 0, 1, AttributeModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeModification_ChangeBounds(), this.getChangeBounds(), null, "changeBounds", null, 0, 1, AttributeModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceModificationEClass, ReferenceModification.class, "ReferenceModification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceModification_ChangeBounds(), this.getChangeBounds(), null, "changeBounds", null, 0, 1, ReferenceModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceModification_ChangeContainement(), ecorePackage.getEBoolean(), "changeContainement", "false", 0, 1, ReferenceModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceModification_RemoveOpposite(), ecorePackage.getEBoolean(), "removeOpposite", "false", 0, 1, ReferenceModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceModification_AddOpposite(), this.getAddOpposite(), null, "addOpposite", null, 0, 1, ReferenceModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceModification_Reify(), this.getReferenceReification(), null, "reify", null, 0, 1, ReferenceModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changeBoundsEClass, ChangeBounds.class, "ChangeBounds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChangeBounds_OldLower(), ecorePackage.getEInt(), "oldLower", null, 1, 1, ChangeBounds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChangeBounds_NewLower(), ecorePackage.getEInt(), "newLower", null, 0, 1, ChangeBounds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChangeBounds_OldUpper(), ecorePackage.getEInt(), "oldUpper", null, 1, 1, ChangeBounds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getChangeBounds_NewUpper(), ecorePackage.getEInt(), "newUpper", null, 0, 1, ChangeBounds.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeModificationEClass, DataTypeModification.class, "DataTypeModification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataTypeModification_OldInstanceTypeName(), ecorePackage.getEString(), "oldInstanceTypeName", "", 0, 1, DataTypeModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataTypeModification_NewInstanceTypeName(), ecorePackage.getEString(), "newInstanceTypeName", "", 0, 1, DataTypeModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumModificationEClass, EnumModification.class, "EnumModification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumModification_OldInstanceTypeName(), ecorePackage.getEString(), "oldInstanceTypeName", "", 0, 1, EnumModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumModification_NewInstanceTypeName(), ecorePackage.getEString(), "newInstanceTypeName", "", 0, 1, EnumModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumModification_Reify(), ecorePackage.getEBoolean(), "reify", "false", 0, 1, EnumModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumModification_EnumLiteralModification(), this.getEnumLiteralModification(), null, "enumLiteralModification", null, 0, -1, EnumModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumLiteralModificationEClass, EnumLiteralModification.class, "EnumLiteralModification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumLiteralModification_OldLiteral(), ecorePackage.getEString(), "oldLiteral", "", 0, 1, EnumLiteralModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumLiteralModification_NewLiteral(), ecorePackage.getEString(), "newLiteral", "", 0, 1, EnumLiteralModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumLiteralModification_OldValue(), ecorePackage.getEInt(), "oldValue", null, 0, 1, EnumLiteralModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumLiteralModification_NewValue(), ecorePackage.getEInt(), "newValue", null, 0, 1, EnumLiteralModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationModificationEClass, AnnotationModification.class, "AnnotationModification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotationModification_OldSource(), ecorePackage.getEString(), "oldSource", "", 1, 1, AnnotationModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationModification_NewSource(), ecorePackage.getEString(), "newSource", "", 0, 1, AnnotationModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationModification_RemoveEAnnotations(), ecorePackage.getEBoolean(), "removeEAnnotations", "false", 0, 1, AnnotationModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationModification_Remove(), ecorePackage.getEBoolean(), "remove", "false", 0, 1, AnnotationModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationModification_DetailsEntryModification(), this.getDetailsEntryModification(), null, "detailsEntryModification", null, 0, -1, AnnotationModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationModification_AnnotationModification(), this.getAnnotationModification(), null, "annotationModification", null, 0, -1, AnnotationModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(detailsEntryModificationEClass, DetailsEntryModification.class, "DetailsEntryModification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDetailsEntryModification_OldKey(), ecorePackage.getEString(), "oldKey", "", 1, 1, DetailsEntryModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDetailsEntryModification_NewKey(), ecorePackage.getEString(), "newKey", "", 0, 1, DetailsEntryModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDetailsEntryModification_OldValue(), ecorePackage.getEString(), "oldValue", "", 0, 1, DetailsEntryModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDetailsEntryModification_NewValue(), ecorePackage.getEString(), "newValue", "", 0, 1, DetailsEntryModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDetailsEntryModification_Remove(), ecorePackage.getEBoolean(), "remove", "false", 0, 1, DetailsEntryModification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addFeatureEClass, AddFeature.class, "AddFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddFeature_Name(), ecorePackage.getEString(), "name", "_", 1, 1, AddFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddFeature_Lower(), ecorePackage.getEInt(), "lower", "0", 1, 1, AddFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddFeature_Upper(), ecorePackage.getEInt(), "upper", "1", 1, 1, AddFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addAttributeEClass, AddAttribute.class, "AddAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddAttribute_Type(), this.getPrimitiveType(), "type", "int", 1, 1, AddAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddAttribute_DefaultValue(), ecorePackage.getEString(), "defaultValue", "0", 1, 1, AddAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addReferenceEClass, AddReference.class, "AddReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddReference_Type(), ecorePackage.getEString(), "type", "int", 1, 1, AddReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addOppositeEClass, AddOpposite.class, "AddOpposite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddOpposite_OppositeName(), ecorePackage.getEString(), "oppositeName", "_", 1, 1, AddOpposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddOpposite_OppositeLower(), ecorePackage.getEInt(), "oppositeLower", "0", 1, 1, AddOpposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddOpposite_OppositeUpper(), ecorePackage.getEInt(), "oppositeUpper", "-1", 1, 1, AddOpposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addRootClassEClass, AddRootClass.class, "AddRootClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddRootClass_Name(), ecorePackage.getEString(), "name", "RootClass", 1, 1, AddRootClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addNameClassEClass, AddNameClass.class, "AddNameClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddNameClass_Name(), ecorePackage.getEString(), "name", "NamedElement", 1, 1, AddNameClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddNameClass_NameName(), ecorePackage.getEString(), "nameName", "name", 1, 1, AddNameClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addDerivedEClass, AddDerived.class, "AddDerived", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddDerived_NewName(), ecorePackage.getEString(), "newName", "_", 1, 1, AddDerived.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAddDerived_ReferenceName(), ecorePackage.getEString(), "referenceName", "", 1, -1, AddDerived.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addDerivedReferenceEClass, AddDerivedReference.class, "AddDerivedReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(addDerivedAttributeEClass, AddDerivedAttribute.class, "AddDerivedAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddDerivedAttribute_AttributeName(), ecorePackage.getEString(), "attributeName", "_", 1, 1, AddDerivedAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceReificationEClass, ReferenceReification.class, "ReferenceReification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReferenceReification_NameClass(), ecorePackage.getEString(), "nameClass", "NameClassReference", 1, 1, ReferenceReification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceReification_NameFirstReference(), ecorePackage.getEString(), "nameFirstReference", "nameFrom", 1, 1, ReferenceReification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceReification_NameSecondReference(), ecorePackage.getEString(), "nameSecondReference", "nameTo", 1, 1, ReferenceReification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerateEClass, Enumerate.class, "Enumerate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerate_EnumName(), ecorePackage.getEString(), "enumName", "enumClass", 1, 1, Enumerate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerate_AttributeName(), ecorePackage.getEString(), "attributeName", "enumAttribute", 1, 1, Enumerate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(primitiveTypeEEnum, PrimitiveType.class, "PrimitiveType");
		addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.INT);
		addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.STRING);
		addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.BOOLEAN);
		addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.CHAR);
		addEEnumLiteral(primitiveTypeEEnum, PrimitiveType.FLOAT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

} //ModifPackageImpl
