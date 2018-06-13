/**
 */
package migration.impl;

import java.util.Collection;

import migration.DeletedAttribute;
import migration.DeletedReference;
import migration.Deletion;
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
 * An implementation of the model object '<em><b>Deletion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link migration.impl.DeletionImpl#getDeletedAttributes <em>Deleted Attributes</em>}</li>
 *   <li>{@link migration.impl.DeletionImpl#getDeletedReferences <em>Deleted References</em>}</li>
 *   <li>{@link migration.impl.DeletionImpl#isDeleteInstance <em>Delete Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeletionImpl extends MinimalEObjectImpl.Container implements Deletion {
	/**
	 * The cached value of the '{@link #getDeletedAttributes() <em>Deleted Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeletedAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<DeletedAttribute> deletedAttributes;

	/**
	 * The cached value of the '{@link #getDeletedReferences() <em>Deleted References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeletedReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<DeletedReference> deletedReferences;

	/**
	 * The default value of the '{@link #isDeleteInstance() <em>Delete Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleteInstance()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELETE_INSTANCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeleteInstance() <em>Delete Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeleteInstance()
	 * @generated
	 * @ordered
	 */
	protected boolean deleteInstance = DELETE_INSTANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeletionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MigrationPackage.Literals.DELETION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeletedAttribute> getDeletedAttributes() {
		if (deletedAttributes == null) {
			deletedAttributes = new EObjectContainmentEList<DeletedAttribute>(DeletedAttribute.class, this, MigrationPackage.DELETION__DELETED_ATTRIBUTES);
		}
		return deletedAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DeletedReference> getDeletedReferences() {
		if (deletedReferences == null) {
			deletedReferences = new EObjectContainmentEList<DeletedReference>(DeletedReference.class, this, MigrationPackage.DELETION__DELETED_REFERENCES);
		}
		return deletedReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeleteInstance() {
		return deleteInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeleteInstance(boolean newDeleteInstance) {
		boolean oldDeleteInstance = deleteInstance;
		deleteInstance = newDeleteInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.DELETION__DELETE_INSTANCE, oldDeleteInstance, deleteInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MigrationPackage.DELETION__DELETED_ATTRIBUTES:
				return ((InternalEList<?>)getDeletedAttributes()).basicRemove(otherEnd, msgs);
			case MigrationPackage.DELETION__DELETED_REFERENCES:
				return ((InternalEList<?>)getDeletedReferences()).basicRemove(otherEnd, msgs);
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
			case MigrationPackage.DELETION__DELETED_ATTRIBUTES:
				return getDeletedAttributes();
			case MigrationPackage.DELETION__DELETED_REFERENCES:
				return getDeletedReferences();
			case MigrationPackage.DELETION__DELETE_INSTANCE:
				return isDeleteInstance();
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
			case MigrationPackage.DELETION__DELETED_ATTRIBUTES:
				getDeletedAttributes().clear();
				getDeletedAttributes().addAll((Collection<? extends DeletedAttribute>)newValue);
				return;
			case MigrationPackage.DELETION__DELETED_REFERENCES:
				getDeletedReferences().clear();
				getDeletedReferences().addAll((Collection<? extends DeletedReference>)newValue);
				return;
			case MigrationPackage.DELETION__DELETE_INSTANCE:
				setDeleteInstance((Boolean)newValue);
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
			case MigrationPackage.DELETION__DELETED_ATTRIBUTES:
				getDeletedAttributes().clear();
				return;
			case MigrationPackage.DELETION__DELETED_REFERENCES:
				getDeletedReferences().clear();
				return;
			case MigrationPackage.DELETION__DELETE_INSTANCE:
				setDeleteInstance(DELETE_INSTANCE_EDEFAULT);
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
			case MigrationPackage.DELETION__DELETED_ATTRIBUTES:
				return deletedAttributes != null && !deletedAttributes.isEmpty();
			case MigrationPackage.DELETION__DELETED_REFERENCES:
				return deletedReferences != null && !deletedReferences.isEmpty();
			case MigrationPackage.DELETION__DELETE_INSTANCE:
				return deleteInstance != DELETE_INSTANCE_EDEFAULT;
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
		result.append(" (deleteInstance: ");
		result.append(deleteInstance);
		result.append(')');
		return result.toString();
	}

} //DeletionImpl
