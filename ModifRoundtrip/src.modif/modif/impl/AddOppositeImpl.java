/**
 */
package modif.impl;

import modif.AddOpposite;
import modif.ModifPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Opposite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.AddOppositeImpl#getOppositeName <em>Opposite Name</em>}</li>
 *   <li>{@link modif.impl.AddOppositeImpl#getOppositeLower <em>Opposite Lower</em>}</li>
 *   <li>{@link modif.impl.AddOppositeImpl#getOppositeUpper <em>Opposite Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddOppositeImpl extends MinimalEObjectImpl.Container implements AddOpposite {
	/**
	 * The default value of the '{@link #getOppositeName() <em>Opposite Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeName()
	 * @generated
	 * @ordered
	 */
	protected static final String OPPOSITE_NAME_EDEFAULT = "_";

	/**
	 * The cached value of the '{@link #getOppositeName() <em>Opposite Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeName()
	 * @generated
	 * @ordered
	 */
	protected String oppositeName = OPPOSITE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOppositeLower() <em>Opposite Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeLower()
	 * @generated
	 * @ordered
	 */
	protected static final int OPPOSITE_LOWER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOppositeLower() <em>Opposite Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeLower()
	 * @generated
	 * @ordered
	 */
	protected int oppositeLower = OPPOSITE_LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getOppositeUpper() <em>Opposite Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeUpper()
	 * @generated
	 * @ordered
	 */
	protected static final int OPPOSITE_UPPER_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getOppositeUpper() <em>Opposite Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOppositeUpper()
	 * @generated
	 * @ordered
	 */
	protected int oppositeUpper = OPPOSITE_UPPER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddOppositeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.ADD_OPPOSITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOppositeName() {
		return oppositeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOppositeName(String newOppositeName) {
		String oldOppositeName = oppositeName;
		oppositeName = newOppositeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ADD_OPPOSITE__OPPOSITE_NAME, oldOppositeName, oppositeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOppositeLower() {
		return oppositeLower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOppositeLower(int newOppositeLower) {
		int oldOppositeLower = oppositeLower;
		oppositeLower = newOppositeLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ADD_OPPOSITE__OPPOSITE_LOWER, oldOppositeLower, oppositeLower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOppositeUpper() {
		return oppositeUpper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOppositeUpper(int newOppositeUpper) {
		int oldOppositeUpper = oppositeUpper;
		oppositeUpper = newOppositeUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ADD_OPPOSITE__OPPOSITE_UPPER, oldOppositeUpper, oppositeUpper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_NAME:
				return getOppositeName();
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_LOWER:
				return getOppositeLower();
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_UPPER:
				return getOppositeUpper();
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
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_NAME:
				setOppositeName((String)newValue);
				return;
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_LOWER:
				setOppositeLower((Integer)newValue);
				return;
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_UPPER:
				setOppositeUpper((Integer)newValue);
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
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_NAME:
				setOppositeName(OPPOSITE_NAME_EDEFAULT);
				return;
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_LOWER:
				setOppositeLower(OPPOSITE_LOWER_EDEFAULT);
				return;
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_UPPER:
				setOppositeUpper(OPPOSITE_UPPER_EDEFAULT);
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
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_NAME:
				return OPPOSITE_NAME_EDEFAULT == null ? oppositeName != null : !OPPOSITE_NAME_EDEFAULT.equals(oppositeName);
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_LOWER:
				return oppositeLower != OPPOSITE_LOWER_EDEFAULT;
			case ModifPackage.ADD_OPPOSITE__OPPOSITE_UPPER:
				return oppositeUpper != OPPOSITE_UPPER_EDEFAULT;
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
		result.append(" (oppositeName: ");
		result.append(oppositeName);
		result.append(", oppositeLower: ");
		result.append(oppositeLower);
		result.append(", oppositeUpper: ");
		result.append(oppositeUpper);
		result.append(')');
		return result.toString();
	}

} //AddOppositeImpl
