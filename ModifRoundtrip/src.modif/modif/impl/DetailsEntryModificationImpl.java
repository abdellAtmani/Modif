/**
 */
package modif.impl;

import modif.DetailsEntryModification;
import modif.ModifPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Details Entry Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.DetailsEntryModificationImpl#getOldKey <em>Old Key</em>}</li>
 *   <li>{@link modif.impl.DetailsEntryModificationImpl#getNewKey <em>New Key</em>}</li>
 *   <li>{@link modif.impl.DetailsEntryModificationImpl#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link modif.impl.DetailsEntryModificationImpl#getNewValue <em>New Value</em>}</li>
 *   <li>{@link modif.impl.DetailsEntryModificationImpl#isRemove <em>Remove</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DetailsEntryModificationImpl extends MinimalEObjectImpl.Container implements DetailsEntryModification {
	/**
	 * The default value of the '{@link #getOldKey() <em>Old Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldKey()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_KEY_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOldKey() <em>Old Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldKey()
	 * @generated
	 * @ordered
	 */
	protected String oldKey = OLD_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewKey() <em>New Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewKey()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_KEY_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getNewKey() <em>New Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewKey()
	 * @generated
	 * @ordered
	 */
	protected String newKey = NEW_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getOldValue() <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_VALUE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOldValue() <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected String oldValue = OLD_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_VALUE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected String newValue = NEW_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemove() <em>Remove</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemove()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemove() <em>Remove</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemove()
	 * @generated
	 * @ordered
	 */
	protected boolean remove = REMOVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DetailsEntryModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.DETAILS_ENTRY_MODIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldKey() {
		return oldKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldKey(String newOldKey) {
		String oldOldKey = oldKey;
		oldKey = newOldKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.DETAILS_ENTRY_MODIFICATION__OLD_KEY, oldOldKey, oldKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewKey() {
		return newKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewKey(String newNewKey) {
		String oldNewKey = newKey;
		newKey = newNewKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.DETAILS_ENTRY_MODIFICATION__NEW_KEY, oldNewKey, newKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldValue() {
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldValue(String newOldValue) {
		String oldOldValue = oldValue;
		oldValue = newOldValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.DETAILS_ENTRY_MODIFICATION__OLD_VALUE, oldOldValue, oldValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewValue() {
		return newValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewValue(String newNewValue) {
		String oldNewValue = newValue;
		newValue = newNewValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.DETAILS_ENTRY_MODIFICATION__NEW_VALUE, oldNewValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemove() {
		return remove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemove(boolean newRemove) {
		boolean oldRemove = remove;
		remove = newRemove;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.DETAILS_ENTRY_MODIFICATION__REMOVE, oldRemove, remove));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__OLD_KEY:
				return getOldKey();
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__NEW_KEY:
				return getNewKey();
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__OLD_VALUE:
				return getOldValue();
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__NEW_VALUE:
				return getNewValue();
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__REMOVE:
				return isRemove();
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
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__OLD_KEY:
				setOldKey((String)newValue);
				return;
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__NEW_KEY:
				setNewKey((String)newValue);
				return;
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__OLD_VALUE:
				setOldValue((String)newValue);
				return;
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__NEW_VALUE:
				setNewValue((String)newValue);
				return;
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__REMOVE:
				setRemove((Boolean)newValue);
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
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__OLD_KEY:
				setOldKey(OLD_KEY_EDEFAULT);
				return;
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__NEW_KEY:
				setNewKey(NEW_KEY_EDEFAULT);
				return;
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__OLD_VALUE:
				setOldValue(OLD_VALUE_EDEFAULT);
				return;
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__NEW_VALUE:
				setNewValue(NEW_VALUE_EDEFAULT);
				return;
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__REMOVE:
				setRemove(REMOVE_EDEFAULT);
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
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__OLD_KEY:
				return OLD_KEY_EDEFAULT == null ? oldKey != null : !OLD_KEY_EDEFAULT.equals(oldKey);
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__NEW_KEY:
				return NEW_KEY_EDEFAULT == null ? newKey != null : !NEW_KEY_EDEFAULT.equals(newKey);
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__OLD_VALUE:
				return OLD_VALUE_EDEFAULT == null ? oldValue != null : !OLD_VALUE_EDEFAULT.equals(oldValue);
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__NEW_VALUE:
				return NEW_VALUE_EDEFAULT == null ? newValue != null : !NEW_VALUE_EDEFAULT.equals(newValue);
			case ModifPackage.DETAILS_ENTRY_MODIFICATION__REMOVE:
				return remove != REMOVE_EDEFAULT;
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
		result.append(" (oldKey: ");
		result.append(oldKey);
		result.append(", newKey: ");
		result.append(newKey);
		result.append(", oldValue: ");
		result.append(oldValue);
		result.append(", newValue: ");
		result.append(newValue);
		result.append(", remove: ");
		result.append(remove);
		result.append(')');
		return result.toString();
	}

} //DetailsEntryModificationImpl
