/**
 */
package modif.impl;

import modif.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class ModifFactoryImpl extends EFactoryImpl implements ModifFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifFactory init() {
		try {
			ModifFactory theModifFactory = (ModifFactory)EPackage.Registry.INSTANCE.getEFactory(ModifPackage.eNS_URI);
			if (theModifFactory != null) {
				return theModifFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModifFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifFactoryImpl() {
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
			case ModifPackage.MODIFICATIONS: return createModifications();
			case ModifPackage.PACKAGE_MODIFICATION: return createPackageModification();
			case ModifPackage.CLASS_MODIFICATION: return createClassModification();
			case ModifPackage.ATTRIBUTE_MODIFICATION: return createAttributeModification();
			case ModifPackage.REFERENCE_MODIFICATION: return createReferenceModification();
			case ModifPackage.CHANGE_BOUNDS: return createChangeBounds();
			case ModifPackage.DATA_TYPE_MODIFICATION: return createDataTypeModification();
			case ModifPackage.ENUM_MODIFICATION: return createEnumModification();
			case ModifPackage.ENUM_LITERAL_MODIFICATION: return createEnumLiteralModification();
			case ModifPackage.ANNOTATION_MODIFICATION: return createAnnotationModification();
			case ModifPackage.DETAILS_ENTRY_MODIFICATION: return createDetailsEntryModification();
			case ModifPackage.ADD_ATTRIBUTE: return createAddAttribute();
			case ModifPackage.ADD_REFERENCE: return createAddReference();
			case ModifPackage.ADD_OPPOSITE: return createAddOpposite();
			case ModifPackage.ADD_ROOT_CLASS: return createAddRootClass();
			case ModifPackage.ADD_NAME_CLASS: return createAddNameClass();
			case ModifPackage.ADD_DERIVED_REFERENCE: return createAddDerivedReference();
			case ModifPackage.ADD_DERIVED_ATTRIBUTE: return createAddDerivedAttribute();
			case ModifPackage.REFERENCE_REIFICATION: return createReferenceReification();
			case ModifPackage.ENUMERATE: return createEnumerate();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ModifPackage.PRIMITIVE_TYPE:
				return createPrimitiveTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ModifPackage.PRIMITIVE_TYPE:
				return convertPrimitiveTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Modifications createModifications() {
		ModificationsImpl modifications = new ModificationsImpl();
		return modifications;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageModification createPackageModification() {
		PackageModificationImpl packageModification = new PackageModificationImpl();
		return packageModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassModification createClassModification() {
		ClassModificationImpl classModification = new ClassModificationImpl();
		return classModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeModification createAttributeModification() {
		AttributeModificationImpl attributeModification = new AttributeModificationImpl();
		return attributeModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceModification createReferenceModification() {
		ReferenceModificationImpl referenceModification = new ReferenceModificationImpl();
		return referenceModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeBounds createChangeBounds() {
		ChangeBoundsImpl changeBounds = new ChangeBoundsImpl();
		return changeBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeModification createDataTypeModification() {
		DataTypeModificationImpl dataTypeModification = new DataTypeModificationImpl();
		return dataTypeModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumModification createEnumModification() {
		EnumModificationImpl enumModification = new EnumModificationImpl();
		return enumModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteralModification createEnumLiteralModification() {
		EnumLiteralModificationImpl enumLiteralModification = new EnumLiteralModificationImpl();
		return enumLiteralModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationModification createAnnotationModification() {
		AnnotationModificationImpl annotationModification = new AnnotationModificationImpl();
		return annotationModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DetailsEntryModification createDetailsEntryModification() {
		DetailsEntryModificationImpl detailsEntryModification = new DetailsEntryModificationImpl();
		return detailsEntryModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddAttribute createAddAttribute() {
		AddAttributeImpl addAttribute = new AddAttributeImpl();
		return addAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddReference createAddReference() {
		AddReferenceImpl addReference = new AddReferenceImpl();
		return addReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddOpposite createAddOpposite() {
		AddOppositeImpl addOpposite = new AddOppositeImpl();
		return addOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddRootClass createAddRootClass() {
		AddRootClassImpl addRootClass = new AddRootClassImpl();
		return addRootClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddNameClass createAddNameClass() {
		AddNameClassImpl addNameClass = new AddNameClassImpl();
		return addNameClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddDerivedReference createAddDerivedReference() {
		AddDerivedReferenceImpl addDerivedReference = new AddDerivedReferenceImpl();
		return addDerivedReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddDerivedAttribute createAddDerivedAttribute() {
		AddDerivedAttributeImpl addDerivedAttribute = new AddDerivedAttributeImpl();
		return addDerivedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceReification createReferenceReification() {
		ReferenceReificationImpl referenceReification = new ReferenceReificationImpl();
		return referenceReification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumerate createEnumerate() {
		EnumerateImpl enumerate = new EnumerateImpl();
		return enumerate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveTypeFromString(EDataType eDataType, String initialValue) {
		PrimitiveType result = PrimitiveType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifPackage getModifPackage() {
		return (ModifPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModifPackage getPackage() {
		return ModifPackage.eINSTANCE;
	}

} //ModifFactoryImpl
