/**
 */
package modif.impl;

import modif.AttributeModification;
import modif.ChangeBounds;
import modif.ModifPackage;
import modif.PrimitiveType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.AttributeModificationImpl#isChangeType <em>Change Type</em>}</li>
 *   <li>{@link modif.impl.AttributeModificationImpl#getNewType <em>New Type</em>}</li>
 *   <li>{@link modif.impl.AttributeModificationImpl#getChangeBounds <em>Change Bounds</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeModificationImpl extends StructuralFeatureModificationImpl implements AttributeModification {
	/**
	 * The default value of the '{@link #isChangeType() <em>Change Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChangeType()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHANGE_TYPE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChangeType() <em>Change Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChangeType()
	 * @generated
	 * @ordered
	 */
	protected boolean changeType = CHANGE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewType() <em>New Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewType()
	 * @generated
	 * @ordered
	 */
	protected static final PrimitiveType NEW_TYPE_EDEFAULT = PrimitiveType.INT;

	/**
	 * The cached value of the '{@link #getNewType() <em>New Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewType()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveType newType = NEW_TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getChangeBounds() <em>Change Bounds</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeBounds()
	 * @generated
	 * @ordered
	 */
	protected ChangeBounds changeBounds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.ATTRIBUTE_MODIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChangeType() {
		return changeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeType(boolean newChangeType) {
		boolean oldChangeType = changeType;
		changeType = newChangeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_TYPE, oldChangeType, changeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType getNewType() {
		return newType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewType(PrimitiveType newNewType) {
		PrimitiveType oldNewType = newType;
		newType = newNewType == null ? NEW_TYPE_EDEFAULT : newNewType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ATTRIBUTE_MODIFICATION__NEW_TYPE, oldNewType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChangeBounds getChangeBounds() {
		return changeBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChangeBounds(ChangeBounds newChangeBounds, NotificationChain msgs) {
		ChangeBounds oldChangeBounds = changeBounds;
		changeBounds = newChangeBounds;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS, oldChangeBounds, newChangeBounds);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeBounds(ChangeBounds newChangeBounds) {
		if (newChangeBounds != changeBounds) {
			NotificationChain msgs = null;
			if (changeBounds != null)
				msgs = ((InternalEObject)changeBounds).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS, null, msgs);
			if (newChangeBounds != null)
				msgs = ((InternalEObject)newChangeBounds).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS, null, msgs);
			msgs = basicSetChangeBounds(newChangeBounds, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS, newChangeBounds, newChangeBounds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS:
				return basicSetChangeBounds(null, msgs);
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
			case ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_TYPE:
				return isChangeType();
			case ModifPackage.ATTRIBUTE_MODIFICATION__NEW_TYPE:
				return getNewType();
			case ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS:
				return getChangeBounds();
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
			case ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_TYPE:
				setChangeType((Boolean)newValue);
				return;
			case ModifPackage.ATTRIBUTE_MODIFICATION__NEW_TYPE:
				setNewType((PrimitiveType)newValue);
				return;
			case ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS:
				setChangeBounds((ChangeBounds)newValue);
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
			case ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_TYPE:
				setChangeType(CHANGE_TYPE_EDEFAULT);
				return;
			case ModifPackage.ATTRIBUTE_MODIFICATION__NEW_TYPE:
				setNewType(NEW_TYPE_EDEFAULT);
				return;
			case ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS:
				setChangeBounds((ChangeBounds)null);
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
			case ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_TYPE:
				return changeType != CHANGE_TYPE_EDEFAULT;
			case ModifPackage.ATTRIBUTE_MODIFICATION__NEW_TYPE:
				return newType != NEW_TYPE_EDEFAULT;
			case ModifPackage.ATTRIBUTE_MODIFICATION__CHANGE_BOUNDS:
				return changeBounds != null;
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
		result.append(" (changeType: ");
		result.append(changeType);
		result.append(", newType: ");
		result.append(newType);
		result.append(')');
		return result.toString();
	}

} //AttributeModificationImpl
