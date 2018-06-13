/**
 */
package modif.impl;

import modif.EnumLiteralModification;
import modif.ModifPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Literal Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.EnumLiteralModificationImpl#getOldLiteral <em>Old Literal</em>}</li>
 *   <li>{@link modif.impl.EnumLiteralModificationImpl#getNewLiteral <em>New Literal</em>}</li>
 *   <li>{@link modif.impl.EnumLiteralModificationImpl#getOldValue <em>Old Value</em>}</li>
 *   <li>{@link modif.impl.EnumLiteralModificationImpl#getNewValue <em>New Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumLiteralModificationImpl extends ModificationImpl implements EnumLiteralModification {
	/**
	 * The default value of the '{@link #getOldLiteral() <em>Old Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_LITERAL_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOldLiteral() <em>Old Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldLiteral()
	 * @generated
	 * @ordered
	 */
	protected String oldLiteral = OLD_LITERAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewLiteral() <em>New Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_LITERAL_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getNewLiteral() <em>New Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewLiteral()
	 * @generated
	 * @ordered
	 */
	protected String newLiteral = NEW_LITERAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getOldValue() <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected static final int OLD_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOldValue() <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldValue()
	 * @generated
	 * @ordered
	 */
	protected int oldValue = OLD_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected static final int NEW_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNewValue() <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected int newValue = NEW_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumLiteralModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.ENUM_LITERAL_MODIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldLiteral() {
		return oldLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldLiteral(String newOldLiteral) {
		String oldOldLiteral = oldLiteral;
		oldLiteral = newOldLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ENUM_LITERAL_MODIFICATION__OLD_LITERAL, oldOldLiteral, oldLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewLiteral() {
		return newLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewLiteral(String newNewLiteral) {
		String oldNewLiteral = newLiteral;
		newLiteral = newNewLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ENUM_LITERAL_MODIFICATION__NEW_LITERAL, oldNewLiteral, newLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOldValue() {
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldValue(int newOldValue) {
		int oldOldValue = oldValue;
		oldValue = newOldValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ENUM_LITERAL_MODIFICATION__OLD_VALUE, oldOldValue, oldValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNewValue() {
		return newValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewValue(int newNewValue) {
		int oldNewValue = newValue;
		newValue = newNewValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ENUM_LITERAL_MODIFICATION__NEW_VALUE, oldNewValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifPackage.ENUM_LITERAL_MODIFICATION__OLD_LITERAL:
				return getOldLiteral();
			case ModifPackage.ENUM_LITERAL_MODIFICATION__NEW_LITERAL:
				return getNewLiteral();
			case ModifPackage.ENUM_LITERAL_MODIFICATION__OLD_VALUE:
				return getOldValue();
			case ModifPackage.ENUM_LITERAL_MODIFICATION__NEW_VALUE:
				return getNewValue();
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
			case ModifPackage.ENUM_LITERAL_MODIFICATION__OLD_LITERAL:
				setOldLiteral((String)newValue);
				return;
			case ModifPackage.ENUM_LITERAL_MODIFICATION__NEW_LITERAL:
				setNewLiteral((String)newValue);
				return;
			case ModifPackage.ENUM_LITERAL_MODIFICATION__OLD_VALUE:
				setOldValue((Integer)newValue);
				return;
			case ModifPackage.ENUM_LITERAL_MODIFICATION__NEW_VALUE:
				setNewValue((Integer)newValue);
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
			case ModifPackage.ENUM_LITERAL_MODIFICATION__OLD_LITERAL:
				setOldLiteral(OLD_LITERAL_EDEFAULT);
				return;
			case ModifPackage.ENUM_LITERAL_MODIFICATION__NEW_LITERAL:
				setNewLiteral(NEW_LITERAL_EDEFAULT);
				return;
			case ModifPackage.ENUM_LITERAL_MODIFICATION__OLD_VALUE:
				setOldValue(OLD_VALUE_EDEFAULT);
				return;
			case ModifPackage.ENUM_LITERAL_MODIFICATION__NEW_VALUE:
				setNewValue(NEW_VALUE_EDEFAULT);
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
			case ModifPackage.ENUM_LITERAL_MODIFICATION__OLD_LITERAL:
				return OLD_LITERAL_EDEFAULT == null ? oldLiteral != null : !OLD_LITERAL_EDEFAULT.equals(oldLiteral);
			case ModifPackage.ENUM_LITERAL_MODIFICATION__NEW_LITERAL:
				return NEW_LITERAL_EDEFAULT == null ? newLiteral != null : !NEW_LITERAL_EDEFAULT.equals(newLiteral);
			case ModifPackage.ENUM_LITERAL_MODIFICATION__OLD_VALUE:
				return oldValue != OLD_VALUE_EDEFAULT;
			case ModifPackage.ENUM_LITERAL_MODIFICATION__NEW_VALUE:
				return newValue != NEW_VALUE_EDEFAULT;
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
		result.append(" (oldLiteral: ");
		result.append(oldLiteral);
		result.append(", newLiteral: ");
		result.append(newLiteral);
		result.append(", oldValue: ");
		result.append(oldValue);
		result.append(", newValue: ");
		result.append(newValue);
		result.append(')');
		return result.toString();
	}

} //EnumLiteralModificationImpl
