/**
 */
package modif.impl;

import java.util.Collection;

import modif.EnumLiteralModification;
import modif.EnumModification;
import modif.ModifPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.EnumModificationImpl#getOldInstanceTypeName <em>Old Instance Type Name</em>}</li>
 *   <li>{@link modif.impl.EnumModificationImpl#getNewInstanceTypeName <em>New Instance Type Name</em>}</li>
 *   <li>{@link modif.impl.EnumModificationImpl#isReify <em>Reify</em>}</li>
 *   <li>{@link modif.impl.EnumModificationImpl#getEnumLiteralModification <em>Enum Literal Modification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumModificationImpl extends ModificationImpl implements EnumModification {
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
	 * The default value of the '{@link #isReify() <em>Reify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReify()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REIFY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReify() <em>Reify</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReify()
	 * @generated
	 * @ordered
	 */
	protected boolean reify = REIFY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEnumLiteralModification() <em>Enum Literal Modification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumLiteralModification()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumLiteralModification> enumLiteralModification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.ENUM_MODIFICATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ENUM_MODIFICATION__OLD_INSTANCE_TYPE_NAME, oldOldInstanceTypeName, oldInstanceTypeName));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ENUM_MODIFICATION__NEW_INSTANCE_TYPE_NAME, oldNewInstanceTypeName, newInstanceTypeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReify() {
		return reify;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReify(boolean newReify) {
		boolean oldReify = reify;
		reify = newReify;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ENUM_MODIFICATION__REIFY, oldReify, reify));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnumLiteralModification> getEnumLiteralModification() {
		if (enumLiteralModification == null) {
			enumLiteralModification = new EObjectContainmentEList<EnumLiteralModification>(EnumLiteralModification.class, this, ModifPackage.ENUM_MODIFICATION__ENUM_LITERAL_MODIFICATION);
		}
		return enumLiteralModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModifPackage.ENUM_MODIFICATION__ENUM_LITERAL_MODIFICATION:
				return ((InternalEList<?>)getEnumLiteralModification()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModifPackage.ENUM_MODIFICATION__OLD_INSTANCE_TYPE_NAME:
				return getOldInstanceTypeName();
			case ModifPackage.ENUM_MODIFICATION__NEW_INSTANCE_TYPE_NAME:
				return getNewInstanceTypeName();
			case ModifPackage.ENUM_MODIFICATION__REIFY:
				return isReify();
			case ModifPackage.ENUM_MODIFICATION__ENUM_LITERAL_MODIFICATION:
				return getEnumLiteralModification();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModifPackage.ENUM_MODIFICATION__OLD_INSTANCE_TYPE_NAME:
				setOldInstanceTypeName((String)newValue);
				return;
			case ModifPackage.ENUM_MODIFICATION__NEW_INSTANCE_TYPE_NAME:
				setNewInstanceTypeName((String)newValue);
				return;
			case ModifPackage.ENUM_MODIFICATION__REIFY:
				setReify((Boolean)newValue);
				return;
			case ModifPackage.ENUM_MODIFICATION__ENUM_LITERAL_MODIFICATION:
				getEnumLiteralModification().clear();
				getEnumLiteralModification().addAll((Collection<? extends EnumLiteralModification>)newValue);
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
			case ModifPackage.ENUM_MODIFICATION__OLD_INSTANCE_TYPE_NAME:
				setOldInstanceTypeName(OLD_INSTANCE_TYPE_NAME_EDEFAULT);
				return;
			case ModifPackage.ENUM_MODIFICATION__NEW_INSTANCE_TYPE_NAME:
				setNewInstanceTypeName(NEW_INSTANCE_TYPE_NAME_EDEFAULT);
				return;
			case ModifPackage.ENUM_MODIFICATION__REIFY:
				setReify(REIFY_EDEFAULT);
				return;
			case ModifPackage.ENUM_MODIFICATION__ENUM_LITERAL_MODIFICATION:
				getEnumLiteralModification().clear();
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
			case ModifPackage.ENUM_MODIFICATION__OLD_INSTANCE_TYPE_NAME:
				return OLD_INSTANCE_TYPE_NAME_EDEFAULT == null ? oldInstanceTypeName != null : !OLD_INSTANCE_TYPE_NAME_EDEFAULT.equals(oldInstanceTypeName);
			case ModifPackage.ENUM_MODIFICATION__NEW_INSTANCE_TYPE_NAME:
				return NEW_INSTANCE_TYPE_NAME_EDEFAULT == null ? newInstanceTypeName != null : !NEW_INSTANCE_TYPE_NAME_EDEFAULT.equals(newInstanceTypeName);
			case ModifPackage.ENUM_MODIFICATION__REIFY:
				return reify != REIFY_EDEFAULT;
			case ModifPackage.ENUM_MODIFICATION__ENUM_LITERAL_MODIFICATION:
				return enumLiteralModification != null && !enumLiteralModification.isEmpty();
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
		result.append(", reify: ");
		result.append(reify);
		result.append(')');
		return result.toString();
	}

} //EnumModificationImpl
