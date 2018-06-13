/**
 */
package modif.util;

import modif.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see modif.ModifPackage
 * @generated
 */
public class ModifAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModifPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ModifPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModifSwitch<Adapter> modelSwitch =
		new ModifSwitch<Adapter>() {
			@Override
			public Adapter caseModifications(Modifications object) {
				return createModificationsAdapter();
			}
			@Override
			public Adapter caseModification(Modification object) {
				return createModificationAdapter();
			}
			@Override
			public Adapter casePackageModification(PackageModification object) {
				return createPackageModificationAdapter();
			}
			@Override
			public Adapter caseClassModification(ClassModification object) {
				return createClassModificationAdapter();
			}
			@Override
			public Adapter caseStructuralFeatureModification(StructuralFeatureModification object) {
				return createStructuralFeatureModificationAdapter();
			}
			@Override
			public Adapter caseAttributeModification(AttributeModification object) {
				return createAttributeModificationAdapter();
			}
			@Override
			public Adapter caseReferenceModification(ReferenceModification object) {
				return createReferenceModificationAdapter();
			}
			@Override
			public Adapter caseChangeBounds(ChangeBounds object) {
				return createChangeBoundsAdapter();
			}
			@Override
			public Adapter caseDataTypeModification(DataTypeModification object) {
				return createDataTypeModificationAdapter();
			}
			@Override
			public Adapter caseEnumModification(EnumModification object) {
				return createEnumModificationAdapter();
			}
			@Override
			public Adapter caseEnumLiteralModification(EnumLiteralModification object) {
				return createEnumLiteralModificationAdapter();
			}
			@Override
			public Adapter caseAnnotationModification(AnnotationModification object) {
				return createAnnotationModificationAdapter();
			}
			@Override
			public Adapter caseDetailsEntryModification(DetailsEntryModification object) {
				return createDetailsEntryModificationAdapter();
			}
			@Override
			public Adapter caseAddFeature(AddFeature object) {
				return createAddFeatureAdapter();
			}
			@Override
			public Adapter caseAddAttribute(AddAttribute object) {
				return createAddAttributeAdapter();
			}
			@Override
			public Adapter caseAddReference(AddReference object) {
				return createAddReferenceAdapter();
			}
			@Override
			public Adapter caseAddOpposite(AddOpposite object) {
				return createAddOppositeAdapter();
			}
			@Override
			public Adapter caseAddRootClass(AddRootClass object) {
				return createAddRootClassAdapter();
			}
			@Override
			public Adapter caseAddNameClass(AddNameClass object) {
				return createAddNameClassAdapter();
			}
			@Override
			public Adapter caseAddDerived(AddDerived object) {
				return createAddDerivedAdapter();
			}
			@Override
			public Adapter caseAddDerivedReference(AddDerivedReference object) {
				return createAddDerivedReferenceAdapter();
			}
			@Override
			public Adapter caseAddDerivedAttribute(AddDerivedAttribute object) {
				return createAddDerivedAttributeAdapter();
			}
			@Override
			public Adapter caseReferenceReification(ReferenceReification object) {
				return createReferenceReificationAdapter();
			}
			@Override
			public Adapter caseEnumerate(Enumerate object) {
				return createEnumerateAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link modif.Modifications <em>Modifications</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.Modifications
	 * @generated
	 */
	public Adapter createModificationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.Modification <em>Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.Modification
	 * @generated
	 */
	public Adapter createModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.PackageModification <em>Package Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.PackageModification
	 * @generated
	 */
	public Adapter createPackageModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.ClassModification <em>Class Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.ClassModification
	 * @generated
	 */
	public Adapter createClassModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.StructuralFeatureModification <em>Structural Feature Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.StructuralFeatureModification
	 * @generated
	 */
	public Adapter createStructuralFeatureModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.AttributeModification <em>Attribute Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.AttributeModification
	 * @generated
	 */
	public Adapter createAttributeModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.ReferenceModification <em>Reference Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.ReferenceModification
	 * @generated
	 */
	public Adapter createReferenceModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.ChangeBounds <em>Change Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.ChangeBounds
	 * @generated
	 */
	public Adapter createChangeBoundsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.DataTypeModification <em>Data Type Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.DataTypeModification
	 * @generated
	 */
	public Adapter createDataTypeModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.EnumModification <em>Enum Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.EnumModification
	 * @generated
	 */
	public Adapter createEnumModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.EnumLiteralModification <em>Enum Literal Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.EnumLiteralModification
	 * @generated
	 */
	public Adapter createEnumLiteralModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.AnnotationModification <em>Annotation Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.AnnotationModification
	 * @generated
	 */
	public Adapter createAnnotationModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.DetailsEntryModification <em>Details Entry Modification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.DetailsEntryModification
	 * @generated
	 */
	public Adapter createDetailsEntryModificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.AddFeature <em>Add Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.AddFeature
	 * @generated
	 */
	public Adapter createAddFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.AddAttribute <em>Add Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.AddAttribute
	 * @generated
	 */
	public Adapter createAddAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.AddReference <em>Add Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.AddReference
	 * @generated
	 */
	public Adapter createAddReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.AddOpposite <em>Add Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.AddOpposite
	 * @generated
	 */
	public Adapter createAddOppositeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.AddRootClass <em>Add Root Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.AddRootClass
	 * @generated
	 */
	public Adapter createAddRootClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.AddNameClass <em>Add Name Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.AddNameClass
	 * @generated
	 */
	public Adapter createAddNameClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.AddDerived <em>Add Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.AddDerived
	 * @generated
	 */
	public Adapter createAddDerivedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.AddDerivedReference <em>Add Derived Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.AddDerivedReference
	 * @generated
	 */
	public Adapter createAddDerivedReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.AddDerivedAttribute <em>Add Derived Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.AddDerivedAttribute
	 * @generated
	 */
	public Adapter createAddDerivedAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.ReferenceReification <em>Reference Reification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.ReferenceReification
	 * @generated
	 */
	public Adapter createReferenceReificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link modif.Enumerate <em>Enumerate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see modif.Enumerate
	 * @generated
	 */
	public Adapter createEnumerateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ModifAdapterFactory
