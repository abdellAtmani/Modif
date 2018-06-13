/**
 */
package modif.impl;

import modif.ModifPackage;
import modif.ReferenceReification;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Reification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.ReferenceReificationImpl#getNameClass <em>Name Class</em>}</li>
 *   <li>{@link modif.impl.ReferenceReificationImpl#getNameFirstReference <em>Name First Reference</em>}</li>
 *   <li>{@link modif.impl.ReferenceReificationImpl#getNameSecondReference <em>Name Second Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceReificationImpl extends MinimalEObjectImpl.Container implements ReferenceReification {
	/**
	 * The default value of the '{@link #getNameClass() <em>Name Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameClass()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_CLASS_EDEFAULT = "NameClassReference";

	/**
	 * The cached value of the '{@link #getNameClass() <em>Name Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameClass()
	 * @generated
	 * @ordered
	 */
	protected String nameClass = NAME_CLASS_EDEFAULT;

	/**
	 * The default value of the '{@link #getNameFirstReference() <em>Name First Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameFirstReference()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_FIRST_REFERENCE_EDEFAULT = "nameFrom";

	/**
	 * The cached value of the '{@link #getNameFirstReference() <em>Name First Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameFirstReference()
	 * @generated
	 * @ordered
	 */
	protected String nameFirstReference = NAME_FIRST_REFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNameSecondReference() <em>Name Second Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameSecondReference()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_SECOND_REFERENCE_EDEFAULT = "nameTo";

	/**
	 * The cached value of the '{@link #getNameSecondReference() <em>Name Second Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNameSecondReference()
	 * @generated
	 * @ordered
	 */
	protected String nameSecondReference = NAME_SECOND_REFERENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceReificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.REFERENCE_REIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNameClass() {
		return nameClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameClass(String newNameClass) {
		String oldNameClass = nameClass;
		nameClass = newNameClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.REFERENCE_REIFICATION__NAME_CLASS, oldNameClass, nameClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNameFirstReference() {
		return nameFirstReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameFirstReference(String newNameFirstReference) {
		String oldNameFirstReference = nameFirstReference;
		nameFirstReference = newNameFirstReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.REFERENCE_REIFICATION__NAME_FIRST_REFERENCE, oldNameFirstReference, nameFirstReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNameSecondReference() {
		return nameSecondReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameSecondReference(String newNameSecondReference) {
		String oldNameSecondReference = nameSecondReference;
		nameSecondReference = newNameSecondReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.REFERENCE_REIFICATION__NAME_SECOND_REFERENCE, oldNameSecondReference, nameSecondReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifPackage.REFERENCE_REIFICATION__NAME_CLASS:
				return getNameClass();
			case ModifPackage.REFERENCE_REIFICATION__NAME_FIRST_REFERENCE:
				return getNameFirstReference();
			case ModifPackage.REFERENCE_REIFICATION__NAME_SECOND_REFERENCE:
				return getNameSecondReference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModifPackage.REFERENCE_REIFICATION__NAME_CLASS:
				setNameClass((String)newValue);
				return;
			case ModifPackage.REFERENCE_REIFICATION__NAME_FIRST_REFERENCE:
				setNameFirstReference((String)newValue);
				return;
			case ModifPackage.REFERENCE_REIFICATION__NAME_SECOND_REFERENCE:
				setNameSecondReference((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModifPackage.REFERENCE_REIFICATION__NAME_CLASS:
				setNameClass(NAME_CLASS_EDEFAULT);
				return;
			case ModifPackage.REFERENCE_REIFICATION__NAME_FIRST_REFERENCE:
				setNameFirstReference(NAME_FIRST_REFERENCE_EDEFAULT);
				return;
			case ModifPackage.REFERENCE_REIFICATION__NAME_SECOND_REFERENCE:
				setNameSecondReference(NAME_SECOND_REFERENCE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModifPackage.REFERENCE_REIFICATION__NAME_CLASS:
				return NAME_CLASS_EDEFAULT == null ? nameClass != null : !NAME_CLASS_EDEFAULT.equals(nameClass);
			case ModifPackage.REFERENCE_REIFICATION__NAME_FIRST_REFERENCE:
				return NAME_FIRST_REFERENCE_EDEFAULT == null ? nameFirstReference != null : !NAME_FIRST_REFERENCE_EDEFAULT.equals(nameFirstReference);
			case ModifPackage.REFERENCE_REIFICATION__NAME_SECOND_REFERENCE:
				return NAME_SECOND_REFERENCE_EDEFAULT == null ? nameSecondReference != null : !NAME_SECOND_REFERENCE_EDEFAULT.equals(nameSecondReference);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (nameClass: ");
		result.append(nameClass);
		result.append(", nameFirstReference: ");
		result.append(nameFirstReference);
		result.append(", nameSecondReference: ");
		result.append(nameSecondReference);
		result.append(')');
		return result.toString();
	}

} //ReferenceReificationImpl
