/**
 */
package modif.impl;

import modif.ChangeBounds;
import modif.ModifPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Change Bounds</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.ChangeBoundsImpl#getOldLower <em>Old Lower</em>}</li>
 *   <li>{@link modif.impl.ChangeBoundsImpl#getNewLower <em>New Lower</em>}</li>
 *   <li>{@link modif.impl.ChangeBoundsImpl#getOldUpper <em>Old Upper</em>}</li>
 *   <li>{@link modif.impl.ChangeBoundsImpl#getNewUpper <em>New Upper</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChangeBoundsImpl extends MinimalEObjectImpl.Container implements ChangeBounds {
	/**
	 * The default value of the '{@link #getOldLower() <em>Old Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldLower()
	 * @generated
	 * @ordered
	 */
	protected static final int OLD_LOWER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOldLower() <em>Old Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldLower()
	 * @generated
	 * @ordered
	 */
	protected int oldLower = OLD_LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewLower() <em>New Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewLower()
	 * @generated
	 * @ordered
	 */
	protected static final int NEW_LOWER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNewLower() <em>New Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewLower()
	 * @generated
	 * @ordered
	 */
	protected int newLower = NEW_LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getOldUpper() <em>Old Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldUpper()
	 * @generated
	 * @ordered
	 */
	protected static final int OLD_UPPER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOldUpper() <em>Old Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldUpper()
	 * @generated
	 * @ordered
	 */
	protected int oldUpper = OLD_UPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewUpper() <em>New Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewUpper()
	 * @generated
	 * @ordered
	 */
	protected static final int NEW_UPPER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNewUpper() <em>New Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewUpper()
	 * @generated
	 * @ordered
	 */
	protected int newUpper = NEW_UPPER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChangeBoundsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.CHANGE_BOUNDS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOldLower() {
		return oldLower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldLower(int newOldLower) {
		int oldOldLower = oldLower;
		oldLower = newOldLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.CHANGE_BOUNDS__OLD_LOWER, oldOldLower, oldLower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNewLower() {
		return newLower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewLower(int newNewLower) {
		int oldNewLower = newLower;
		newLower = newNewLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.CHANGE_BOUNDS__NEW_LOWER, oldNewLower, newLower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOldUpper() {
		return oldUpper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldUpper(int newOldUpper) {
		int oldOldUpper = oldUpper;
		oldUpper = newOldUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.CHANGE_BOUNDS__OLD_UPPER, oldOldUpper, oldUpper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNewUpper() {
		return newUpper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewUpper(int newNewUpper) {
		int oldNewUpper = newUpper;
		newUpper = newNewUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.CHANGE_BOUNDS__NEW_UPPER, oldNewUpper, newUpper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifPackage.CHANGE_BOUNDS__OLD_LOWER:
				return getOldLower();
			case ModifPackage.CHANGE_BOUNDS__NEW_LOWER:
				return getNewLower();
			case ModifPackage.CHANGE_BOUNDS__OLD_UPPER:
				return getOldUpper();
			case ModifPackage.CHANGE_BOUNDS__NEW_UPPER:
				return getNewUpper();
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
			case ModifPackage.CHANGE_BOUNDS__OLD_LOWER:
				setOldLower((Integer)newValue);
				return;
			case ModifPackage.CHANGE_BOUNDS__NEW_LOWER:
				setNewLower((Integer)newValue);
				return;
			case ModifPackage.CHANGE_BOUNDS__OLD_UPPER:
				setOldUpper((Integer)newValue);
				return;
			case ModifPackage.CHANGE_BOUNDS__NEW_UPPER:
				setNewUpper((Integer)newValue);
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
			case ModifPackage.CHANGE_BOUNDS__OLD_LOWER:
				setOldLower(OLD_LOWER_EDEFAULT);
				return;
			case ModifPackage.CHANGE_BOUNDS__NEW_LOWER:
				setNewLower(NEW_LOWER_EDEFAULT);
				return;
			case ModifPackage.CHANGE_BOUNDS__OLD_UPPER:
				setOldUpper(OLD_UPPER_EDEFAULT);
				return;
			case ModifPackage.CHANGE_BOUNDS__NEW_UPPER:
				setNewUpper(NEW_UPPER_EDEFAULT);
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
			case ModifPackage.CHANGE_BOUNDS__OLD_LOWER:
				return oldLower != OLD_LOWER_EDEFAULT;
			case ModifPackage.CHANGE_BOUNDS__NEW_LOWER:
				return newLower != NEW_LOWER_EDEFAULT;
			case ModifPackage.CHANGE_BOUNDS__OLD_UPPER:
				return oldUpper != OLD_UPPER_EDEFAULT;
			case ModifPackage.CHANGE_BOUNDS__NEW_UPPER:
				return newUpper != NEW_UPPER_EDEFAULT;
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
		result.append(" (oldLower: ");
		result.append(oldLower);
		result.append(", newLower: ");
		result.append(newLower);
		result.append(", oldUpper: ");
		result.append(oldUpper);
		result.append(", newUpper: ");
		result.append(newUpper);
		result.append(')');
		return result.toString();
	}

} //ChangeBoundsImpl
