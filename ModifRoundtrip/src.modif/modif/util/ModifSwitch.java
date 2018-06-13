/**
 */
package modif.util;

import modif.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see modif.ModifPackage
 * @generated
 */
public class ModifSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ModifPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifSwitch() {
		if (modelPackage == null) {
			modelPackage = ModifPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModifPackage.MODIFICATIONS: {
				Modifications modifications = (Modifications)theEObject;
				T result = caseModifications(modifications);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.MODIFICATION: {
				Modification modification = (Modification)theEObject;
				T result = caseModification(modification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.PACKAGE_MODIFICATION: {
				PackageModification packageModification = (PackageModification)theEObject;
				T result = casePackageModification(packageModification);
				if (result == null) result = caseModification(packageModification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.CLASS_MODIFICATION: {
				ClassModification classModification = (ClassModification)theEObject;
				T result = caseClassModification(classModification);
				if (result == null) result = caseModification(classModification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.STRUCTURAL_FEATURE_MODIFICATION: {
				StructuralFeatureModification structuralFeatureModification = (StructuralFeatureModification)theEObject;
				T result = caseStructuralFeatureModification(structuralFeatureModification);
				if (result == null) result = caseModification(structuralFeatureModification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ATTRIBUTE_MODIFICATION: {
				AttributeModification attributeModification = (AttributeModification)theEObject;
				T result = caseAttributeModification(attributeModification);
				if (result == null) result = caseStructuralFeatureModification(attributeModification);
				if (result == null) result = caseModification(attributeModification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.REFERENCE_MODIFICATION: {
				ReferenceModification referenceModification = (ReferenceModification)theEObject;
				T result = caseReferenceModification(referenceModification);
				if (result == null) result = caseStructuralFeatureModification(referenceModification);
				if (result == null) result = caseModification(referenceModification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.CHANGE_BOUNDS: {
				ChangeBounds changeBounds = (ChangeBounds)theEObject;
				T result = caseChangeBounds(changeBounds);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.DATA_TYPE_MODIFICATION: {
				DataTypeModification dataTypeModification = (DataTypeModification)theEObject;
				T result = caseDataTypeModification(dataTypeModification);
				if (result == null) result = caseModification(dataTypeModification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ENUM_MODIFICATION: {
				EnumModification enumModification = (EnumModification)theEObject;
				T result = caseEnumModification(enumModification);
				if (result == null) result = caseModification(enumModification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ENUM_LITERAL_MODIFICATION: {
				EnumLiteralModification enumLiteralModification = (EnumLiteralModification)theEObject;
				T result = caseEnumLiteralModification(enumLiteralModification);
				if (result == null) result = caseModification(enumLiteralModification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ANNOTATION_MODIFICATION: {
				AnnotationModification annotationModification = (AnnotationModification)theEObject;
				T result = caseAnnotationModification(annotationModification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.DETAILS_ENTRY_MODIFICATION: {
				DetailsEntryModification detailsEntryModification = (DetailsEntryModification)theEObject;
				T result = caseDetailsEntryModification(detailsEntryModification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ADD_FEATURE: {
				AddFeature addFeature = (AddFeature)theEObject;
				T result = caseAddFeature(addFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ADD_ATTRIBUTE: {
				AddAttribute addAttribute = (AddAttribute)theEObject;
				T result = caseAddAttribute(addAttribute);
				if (result == null) result = caseAddFeature(addAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ADD_REFERENCE: {
				AddReference addReference = (AddReference)theEObject;
				T result = caseAddReference(addReference);
				if (result == null) result = caseAddFeature(addReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ADD_OPPOSITE: {
				AddOpposite addOpposite = (AddOpposite)theEObject;
				T result = caseAddOpposite(addOpposite);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ADD_ROOT_CLASS: {
				AddRootClass addRootClass = (AddRootClass)theEObject;
				T result = caseAddRootClass(addRootClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ADD_NAME_CLASS: {
				AddNameClass addNameClass = (AddNameClass)theEObject;
				T result = caseAddNameClass(addNameClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ADD_DERIVED: {
				AddDerived addDerived = (AddDerived)theEObject;
				T result = caseAddDerived(addDerived);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ADD_DERIVED_REFERENCE: {
				AddDerivedReference addDerivedReference = (AddDerivedReference)theEObject;
				T result = caseAddDerivedReference(addDerivedReference);
				if (result == null) result = caseAddDerived(addDerivedReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ADD_DERIVED_ATTRIBUTE: {
				AddDerivedAttribute addDerivedAttribute = (AddDerivedAttribute)theEObject;
				T result = caseAddDerivedAttribute(addDerivedAttribute);
				if (result == null) result = caseAddDerived(addDerivedAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.REFERENCE_REIFICATION: {
				ReferenceReification referenceReification = (ReferenceReification)theEObject;
				T result = caseReferenceReification(referenceReification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModifPackage.ENUMERATE: {
				Enumerate enumerate = (Enumerate)theEObject;
				T result = caseEnumerate(enumerate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modifications</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modifications</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifications(Modifications object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModification(Modification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageModification(PackageModification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassModification(ClassModification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Feature Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Feature Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuralFeatureModification(StructuralFeatureModification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeModification(AttributeModification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceModification(ReferenceModification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Change Bounds</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Change Bounds</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChangeBounds(ChangeBounds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeModification(DataTypeModification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumModification(EnumModification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteralModification(EnumLiteralModification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotationModification(AnnotationModification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Details Entry Modification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Details Entry Modification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDetailsEntryModification(DetailsEntryModification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddFeature(AddFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddAttribute(AddAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddReference(AddReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Opposite</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Opposite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddOpposite(AddOpposite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Root Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Root Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddRootClass(AddRootClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Name Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Name Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddNameClass(AddNameClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Derived</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Derived</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddDerived(AddDerived object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Derived Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Derived Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddDerivedReference(AddDerivedReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Derived Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Derived Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddDerivedAttribute(AddDerivedAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Reification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Reification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceReification(ReferenceReification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerate(Enumerate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ModifSwitch
