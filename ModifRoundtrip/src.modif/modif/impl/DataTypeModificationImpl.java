/**
 */
package modif.impl;

import modif.DataTypeModification;
import modif.ModifPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.DataTypeModificationImpl#getOldInstanceTypeName <em>Old Instance Type Name</em>}</li>
 *   <li>{@link modif.impl.DataTypeModificationImpl#getNewInstanceTypeName <em>New Instance Type Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeModificationImpl extends ModificationImpl implements DataTypeModification {
	/**
	 * The default value of the '{@link #getOldInstanceTypeName() <em>Old Instance Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldInstanceTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_INSTANCE_TYPE_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOldInstanceTypeName() <em>Old Instance Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldInstanceTypeName()
	 * @generated
	 * @ordered
	 */
	protected String oldInstanceTypeName = OLD_INSTANCE_TYPE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewInstanceTypeName() <em>New Instance Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewInstanceTypeName()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_INSTANCE_TYPE_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getNewInstanceTypeName() <em>New Instance Type Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewInstanceTypeName()
	 * @generated
	 * @ordered
	 */
	protected String newInstanceTypeName = NEW_INSTANCE_TYPE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.DATA_TYPE_MODIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldInstanceTypeName() {
		return oldInstanceTypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldInstanceTypeName(String newOldInstanceTypeName) {
		String oldOldInstanceTypeName = oldInstanceTypeName;
		oldInstanceTypeName = newOldInstanceTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.DATA_TYPE_MODIFICATION__OLD_INSTANCE_TYPE_NAME, oldOldInstanceTypeName, oldInstanceTypeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewInstanceTypeName() {
		return newInstanceTypeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewInstanceTypeName(String newNewInstanceTypeName) {
		String oldNewInstanceTypeName = newInstanceTypeName;
		newInstanceTypeName = newNewInstanceTypeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.DATA_TYPE_MODIFICATION__NEW_INSTANCE_TYPE_NAME, oldNewInstanceTypeName, newInstanceTypeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifPackage.DATA_TYPE_MODIFICATION__OLD_INSTANCE_TYPE_NAME:
				return getOldInstanceTypeName();
			case ModifPackage.DATA_TYPE_MODIFICATION__NEW_INSTANCE_TYPE_NAME:
				return getNewInstanceTypeName();
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
			case ModifPackage.DATA_TYPE_MODIFICATION__OLD_INSTANCE_TYPE_NAME:
				setOldInstanceTypeName((String)newValue);
				return;
			case ModifPackage.DATA_TYPE_MODIFICATION__NEW_INSTANCE_TYPE_NAME:
				setNewInstanceTypeName((String)newValue);
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
			case ModifPackage.DATA_TYPE_MODIFICATION__OLD_INSTANCE_TYPE_NAME:
				setOldInstanceTypeName(OLD_INSTANCE_TYPE_NAME_EDEFAULT);
				return;
			case ModifPackage.DATA_TYPE_MODIFICATION__NEW_INSTANCE_TYPE_NAME:
				setNewInstanceTypeName(NEW_INSTANCE_TYPE_NAME_EDEFAULT);
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
			case ModifPackage.DATA_TYPE_MODIFICATION__OLD_INSTANCE_TYPE_NAME:
				return OLD_INSTANCE_TYPE_NAME_EDEFAULT == null ? oldInstanceTypeName != null : !OLD_INSTANCE_TYPE_NAME_EDEFAULT.equals(oldInstanceTypeName);
			case ModifPackage.DATA_TYPE_MODIFICATION__NEW_INSTANCE_TYPE_NAME:
				return NEW_INSTANCE_TYPE_NAME_EDEFAULT == null ? newInstanceTypeName != null : !NEW_INSTANCE_TYPE_NAME_EDEFAULT.equals(newInstanceTypeName);
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
		result.append(" (oldInstanceTypeName: ");
		result.append(oldInstanceTypeName);
		result.append(", newInstanceTypeName: ");
		result.append(newInstanceTypeName);
		result.append(')');
		return result.toString();
	}

} //DataTypeModificationImpl
