/**
 */
package modif.impl;

import java.util.Collection;

import modif.ClassModification;
import modif.DataTypeModification;
import modif.EnumModification;
import modif.ModifPackage;
import modif.PackageModification;

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
 * An implementation of the model object '<em><b>Package Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.PackageModificationImpl#getOldPrefixName <em>Old Prefix Name</em>}</li>
 *   <li>{@link modif.impl.PackageModificationImpl#getNewPrefixName <em>New Prefix Name</em>}</li>
 *   <li>{@link modif.impl.PackageModificationImpl#getOldURIName <em>Old URI Name</em>}</li>
 *   <li>{@link modif.impl.PackageModificationImpl#getNewURIName <em>New URI Name</em>}</li>
 *   <li>{@link modif.impl.PackageModificationImpl#isHide <em>Hide</em>}</li>
 *   <li>{@link modif.impl.PackageModificationImpl#getPackageModification <em>Package Modification</em>}</li>
 *   <li>{@link modif.impl.PackageModificationImpl#getClassModification <em>Class Modification</em>}</li>
 *   <li>{@link modif.impl.PackageModificationImpl#getDataTypeModification <em>Data Type Modification</em>}</li>
 *   <li>{@link modif.impl.PackageModificationImpl#getEnumModification <em>Enum Modification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageModificationImpl extends ModificationImpl implements PackageModification {
	/**
	 * The default value of the '{@link #getOldPrefixName() <em>Old Prefix Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldPrefixName()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_PREFIX_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOldPrefixName() <em>Old Prefix Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldPrefixName()
	 * @generated
	 * @ordered
	 */
	protected String oldPrefixName = OLD_PREFIX_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewPrefixName() <em>New Prefix Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewPrefixName()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_PREFIX_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewPrefixName() <em>New Prefix Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewPrefixName()
	 * @generated
	 * @ordered
	 */
	protected String newPrefixName = NEW_PREFIX_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getOldURIName() <em>Old URI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldURIName()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_URI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOldURIName() <em>Old URI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldURIName()
	 * @generated
	 * @ordered
	 */
	protected String oldURIName = OLD_URI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewURIName() <em>New URI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewURIName()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_URI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewURIName() <em>New URI Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewURIName()
	 * @generated
	 * @ordered
	 */
	protected String newURIName = NEW_URI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isHide() <em>Hide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHide()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HIDE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHide() <em>Hide</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHide()
	 * @generated
	 * @ordered
	 */
	protected boolean hide = HIDE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPackageModification() <em>Package Modification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageModification()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageModification> packageModification;

	/**
	 * The cached value of the '{@link #getClassModification() <em>Class Modification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassModification()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassModification> classModification;

	/**
	 * The cached value of the '{@link #getDataTypeModification() <em>Data Type Modification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypeModification()
	 * @generated
	 * @ordered
	 */
	protected EList<DataTypeModification> dataTypeModification;

	/**
	 * The cached value of the '{@link #getEnumModification() <em>Enum Modification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumModification()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumModification> enumModification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.PACKAGE_MODIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldPrefixName() {
		return oldPrefixName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldPrefixName(String newOldPrefixName) {
		String oldOldPrefixName = oldPrefixName;
		oldPrefixName = newOldPrefixName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.PACKAGE_MODIFICATION__OLD_PREFIX_NAME, oldOldPrefixName, oldPrefixName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewPrefixName() {
		return newPrefixName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewPrefixName(String newNewPrefixName) {
		String oldNewPrefixName = newPrefixName;
		newPrefixName = newNewPrefixName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.PACKAGE_MODIFICATION__NEW_PREFIX_NAME, oldNewPrefixName, newPrefixName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldURIName() {
		return oldURIName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldURIName(String newOldURIName) {
		String oldOldURIName = oldURIName;
		oldURIName = newOldURIName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.PACKAGE_MODIFICATION__OLD_URI_NAME, oldOldURIName, oldURIName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewURIName() {
		return newURIName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewURIName(String newNewURIName) {
		String oldNewURIName = newURIName;
		newURIName = newNewURIName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.PACKAGE_MODIFICATION__NEW_URI_NAME, oldNewURIName, newURIName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHide() {
		return hide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHide(boolean newHide) {
		boolean oldHide = hide;
		hide = newHide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.PACKAGE_MODIFICATION__HIDE, oldHide, hide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageModification> getPackageModification() {
		if (packageModification == null) {
			packageModification = new EObjectContainmentEList<PackageModification>(PackageModification.class, this, ModifPackage.PACKAGE_MODIFICATION__PACKAGE_MODIFICATION);
		}
		return packageModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassModification> getClassModification() {
		if (classModification == null) {
			classModification = new EObjectContainmentEList<ClassModification>(ClassModification.class, this, ModifPackage.PACKAGE_MODIFICATION__CLASS_MODIFICATION);
		}
		return classModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataTypeModification> getDataTypeModification() {
		if (dataTypeModification == null) {
			dataTypeModification = new EObjectContainmentEList<DataTypeModification>(DataTypeModification.class, this, ModifPackage.PACKAGE_MODIFICATION__DATA_TYPE_MODIFICATION);
		}
		return dataTypeModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnumModification> getEnumModification() {
		if (enumModification == null) {
			enumModification = new EObjectContainmentEList<EnumModification>(EnumModification.class, this, ModifPackage.PACKAGE_MODIFICATION__ENUM_MODIFICATION);
		}
		return enumModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModifPackage.PACKAGE_MODIFICATION__PACKAGE_MODIFICATION:
				return ((InternalEList<?>)getPackageModification()).basicRemove(otherEnd, msgs);
			case ModifPackage.PACKAGE_MODIFICATION__CLASS_MODIFICATION:
				return ((InternalEList<?>)getClassModification()).basicRemove(otherEnd, msgs);
			case ModifPackage.PACKAGE_MODIFICATION__DATA_TYPE_MODIFICATION:
				return ((InternalEList<?>)getDataTypeModification()).basicRemove(otherEnd, msgs);
			case ModifPackage.PACKAGE_MODIFICATION__ENUM_MODIFICATION:
				return ((InternalEList<?>)getEnumModification()).basicRemove(otherEnd, msgs);
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
			case ModifPackage.PACKAGE_MODIFICATION__OLD_PREFIX_NAME:
				return getOldPrefixName();
			case ModifPackage.PACKAGE_MODIFICATION__NEW_PREFIX_NAME:
				return getNewPrefixName();
			case ModifPackage.PACKAGE_MODIFICATION__OLD_URI_NAME:
				return getOldURIName();
			case ModifPackage.PACKAGE_MODIFICATION__NEW_URI_NAME:
				return getNewURIName();
			case ModifPackage.PACKAGE_MODIFICATION__HIDE:
				return isHide();
			case ModifPackage.PACKAGE_MODIFICATION__PACKAGE_MODIFICATION:
				return getPackageModification();
			case ModifPackage.PACKAGE_MODIFICATION__CLASS_MODIFICATION:
				return getClassModification();
			case ModifPackage.PACKAGE_MODIFICATION__DATA_TYPE_MODIFICATION:
				return getDataTypeModification();
			case ModifPackage.PACKAGE_MODIFICATION__ENUM_MODIFICATION:
				return getEnumModification();
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
			case ModifPackage.PACKAGE_MODIFICATION__OLD_PREFIX_NAME:
				setOldPrefixName((String)newValue);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__NEW_PREFIX_NAME:
				setNewPrefixName((String)newValue);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__OLD_URI_NAME:
				setOldURIName((String)newValue);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__NEW_URI_NAME:
				setNewURIName((String)newValue);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__HIDE:
				setHide((Boolean)newValue);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__PACKAGE_MODIFICATION:
				getPackageModification().clear();
				getPackageModification().addAll((Collection<? extends PackageModification>)newValue);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__CLASS_MODIFICATION:
				getClassModification().clear();
				getClassModification().addAll((Collection<? extends ClassModification>)newValue);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__DATA_TYPE_MODIFICATION:
				getDataTypeModification().clear();
				getDataTypeModification().addAll((Collection<? extends DataTypeModification>)newValue);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__ENUM_MODIFICATION:
				getEnumModification().clear();
				getEnumModification().addAll((Collection<? extends EnumModification>)newValue);
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
			case ModifPackage.PACKAGE_MODIFICATION__OLD_PREFIX_NAME:
				setOldPrefixName(OLD_PREFIX_NAME_EDEFAULT);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__NEW_PREFIX_NAME:
				setNewPrefixName(NEW_PREFIX_NAME_EDEFAULT);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__OLD_URI_NAME:
				setOldURIName(OLD_URI_NAME_EDEFAULT);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__NEW_URI_NAME:
				setNewURIName(NEW_URI_NAME_EDEFAULT);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__HIDE:
				setHide(HIDE_EDEFAULT);
				return;
			case ModifPackage.PACKAGE_MODIFICATION__PACKAGE_MODIFICATION:
				getPackageModification().clear();
				return;
			case ModifPackage.PACKAGE_MODIFICATION__CLASS_MODIFICATION:
				getClassModification().clear();
				return;
			case ModifPackage.PACKAGE_MODIFICATION__DATA_TYPE_MODIFICATION:
				getDataTypeModification().clear();
				return;
			case ModifPackage.PACKAGE_MODIFICATION__ENUM_MODIFICATION:
				getEnumModification().clear();
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
			case ModifPackage.PACKAGE_MODIFICATION__OLD_PREFIX_NAME:
				return OLD_PREFIX_NAME_EDEFAULT == null ? oldPrefixName != null : !OLD_PREFIX_NAME_EDEFAULT.equals(oldPrefixName);
			case ModifPackage.PACKAGE_MODIFICATION__NEW_PREFIX_NAME:
				return NEW_PREFIX_NAME_EDEFAULT == null ? newPrefixName != null : !NEW_PREFIX_NAME_EDEFAULT.equals(newPrefixName);
			case ModifPackage.PACKAGE_MODIFICATION__OLD_URI_NAME:
				return OLD_URI_NAME_EDEFAULT == null ? oldURIName != null : !OLD_URI_NAME_EDEFAULT.equals(oldURIName);
			case ModifPackage.PACKAGE_MODIFICATION__NEW_URI_NAME:
				return NEW_URI_NAME_EDEFAULT == null ? newURIName != null : !NEW_URI_NAME_EDEFAULT.equals(newURIName);
			case ModifPackage.PACKAGE_MODIFICATION__HIDE:
				return hide != HIDE_EDEFAULT;
			case ModifPackage.PACKAGE_MODIFICATION__PACKAGE_MODIFICATION:
				return packageModification != null && !packageModification.isEmpty();
			case ModifPackage.PACKAGE_MODIFICATION__CLASS_MODIFICATION:
				return classModification != null && !classModification.isEmpty();
			case ModifPackage.PACKAGE_MODIFICATION__DATA_TYPE_MODIFICATION:
				return dataTypeModification != null && !dataTypeModification.isEmpty();
			case ModifPackage.PACKAGE_MODIFICATION__ENUM_MODIFICATION:
				return enumModification != null && !enumModification.isEmpty();
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
		result.append(" (oldPrefixName: ");
		result.append(oldPrefixName);
		result.append(", newPrefixName: ");
		result.append(newPrefixName);
		result.append(", oldURIName: ");
		result.append(oldURIName);
		result.append(", newURIName: ");
		result.append(newURIName);
		result.append(", hide: ");
		result.append(hide);
		result.append(')');
		return result.toString();
	}

} //PackageModificationImpl
