/**
 */
package migration.impl;

import java.util.Collection;

import migration.Deletion;
import migration.DerivedReference;
import migration.Instance;
import migration.MigrationPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link migration.impl.InstanceImpl#getUUID <em>UUID</em>}</li>
 *   <li>{@link migration.impl.InstanceImpl#getDeletion <em>Deletion</em>}</li>
 *   <li>{@link migration.impl.InstanceImpl#getDerived <em>Derived</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstanceImpl extends MinimalEObjectImpl.Container implements Instance {
	/**
	 * The default value of the '{@link #getUUID() <em>UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUUID()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUUID() <em>UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUUID()
	 * @generated
	 * @ordered
	 */
	protected String uuid = UUID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDeletion() <em>Deletion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeletion()
	 * @generated
	 * @ordered
	 */
	protected Deletion deletion;

	/**
	 * The cached value of the '{@link #getDerived() <em>Derived</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerived()
	 * @generated
	 * @ordered
	 */
	protected EList<DerivedReference> derived;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MigrationPackage.Literals.INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUUID() {
		return uuid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUUID(String newUUID) {
		String oldUUID = uuid;
		uuid = newUUID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.INSTANCE__UUID, oldUUID, uuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deletion getDeletion() {
		return deletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeletion(Deletion newDeletion, NotificationChain msgs) {
		Deletion oldDeletion = deletion;
		deletion = newDeletion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MigrationPackage.INSTANCE__DELETION, oldDeletion, newDeletion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeletion(Deletion newDeletion) {
		if (newDeletion != deletion) {
			NotificationChain msgs = null;
			if (deletion != null)
				msgs = ((InternalEObject)deletion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MigrationPackage.INSTANCE__DELETION, null, msgs);
			if (newDeletion != null)
				msgs = ((InternalEObject)newDeletion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MigrationPackage.INSTANCE__DELETION, null, msgs);
			msgs = basicSetDeletion(newDeletion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.INSTANCE__DELETION, newDeletion, newDeletion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DerivedReference> getDerived() {
		if (derived == null) {
			derived = new EObjectContainmentEList<DerivedReference>(DerivedReference.class, this, MigrationPackage.INSTANCE__DERIVED);
		}
		return derived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MigrationPackage.INSTANCE__DELETION:
				return basicSetDeletion(null, msgs);
			case MigrationPackage.INSTANCE__DERIVED:
				return ((InternalEList<?>)getDerived()).basicRemove(otherEnd, msgs);
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
			case MigrationPackage.INSTANCE__UUID:
				return getUUID();
			case MigrationPackage.INSTANCE__DELETION:
				return getDeletion();
			case MigrationPackage.INSTANCE__DERIVED:
				return getDerived();
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
			case MigrationPackage.INSTANCE__UUID:
				setUUID((String)newValue);
				return;
			case MigrationPackage.INSTANCE__DELETION:
				setDeletion((Deletion)newValue);
				return;
			case MigrationPackage.INSTANCE__DERIVED:
				getDerived().clear();
				getDerived().addAll((Collection<? extends DerivedReference>)newValue);
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
			case MigrationPackage.INSTANCE__UUID:
				setUUID(UUID_EDEFAULT);
				return;
			case MigrationPackage.INSTANCE__DELETION:
				setDeletion((Deletion)null);
				return;
			case MigrationPackage.INSTANCE__DERIVED:
				getDerived().clear();
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
			case MigrationPackage.INSTANCE__UUID:
				return UUID_EDEFAULT == null ? uuid != null : !UUID_EDEFAULT.equals(uuid);
			case MigrationPackage.INSTANCE__DELETION:
				return deletion != null;
			case MigrationPackage.INSTANCE__DERIVED:
				return derived != null && !derived.isEmpty();
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
		result.append(" (UUID: ");
		result.append(uuid);
		result.append(')');
		return result.toString();
	}

} //InstanceImpl
