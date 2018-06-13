/**
 */
package migration.impl;

import java.util.Collection;

import migration.DerivedReference;
import migration.MigrationPackage;
import migration.ReferencePath;

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
 * An implementation of the model object '<em><b>Derived Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link migration.impl.DerivedReferenceImpl#getPath <em>Path</em>}</li>
 *   <li>{@link migration.impl.DerivedReferenceImpl#getNewReferenceName <em>New Reference Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DerivedReferenceImpl extends MinimalEObjectImpl.Container implements DerivedReference {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected EList<ReferencePath> path;

	/**
	 * The default value of the '{@link #getNewReferenceName() <em>New Reference Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewReferenceName()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_REFERENCE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNewReferenceName() <em>New Reference Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewReferenceName()
	 * @generated
	 * @ordered
	 */
	protected String newReferenceName = NEW_REFERENCE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DerivedReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MigrationPackage.Literals.DERIVED_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReferencePath> getPath() {
		if (path == null) {
			path = new EObjectContainmentEList<ReferencePath>(ReferencePath.class, this, MigrationPackage.DERIVED_REFERENCE__PATH);
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewReferenceName() {
		return newReferenceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewReferenceName(String newNewReferenceName) {
		String oldNewReferenceName = newReferenceName;
		newReferenceName = newNewReferenceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.DERIVED_REFERENCE__NEW_REFERENCE_NAME, oldNewReferenceName, newReferenceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MigrationPackage.DERIVED_REFERENCE__PATH:
				return ((InternalEList<?>)getPath()).basicRemove(otherEnd, msgs);
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
			case MigrationPackage.DERIVED_REFERENCE__PATH:
				return getPath();
			case MigrationPackage.DERIVED_REFERENCE__NEW_REFERENCE_NAME:
				return getNewReferenceName();
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
			case MigrationPackage.DERIVED_REFERENCE__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends ReferencePath>)newValue);
				return;
			case MigrationPackage.DERIVED_REFERENCE__NEW_REFERENCE_NAME:
				setNewReferenceName((String)newValue);
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
			case MigrationPackage.DERIVED_REFERENCE__PATH:
				getPath().clear();
				return;
			case MigrationPackage.DERIVED_REFERENCE__NEW_REFERENCE_NAME:
				setNewReferenceName(NEW_REFERENCE_NAME_EDEFAULT);
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
			case MigrationPackage.DERIVED_REFERENCE__PATH:
				return path != null && !path.isEmpty();
			case MigrationPackage.DERIVED_REFERENCE__NEW_REFERENCE_NAME:
				return NEW_REFERENCE_NAME_EDEFAULT == null ? newReferenceName != null : !NEW_REFERENCE_NAME_EDEFAULT.equals(newReferenceName);
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
		result.append(" (newReferenceName: ");
		result.append(newReferenceName);
		result.append(')');
		return result.toString();
	}

} //DerivedReferenceImpl
