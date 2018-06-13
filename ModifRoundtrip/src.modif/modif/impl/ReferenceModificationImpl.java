/**
 */
package modif.impl;

import modif.AddOpposite;
import modif.ChangeBounds;
import modif.ModifPackage;
import modif.ReferenceModification;
import modif.ReferenceReification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.ReferenceModificationImpl#getChangeBounds <em>Change Bounds</em>}</li>
 *   <li>{@link modif.impl.ReferenceModificationImpl#isChangeContainement <em>Change Containement</em>}</li>
 *   <li>{@link modif.impl.ReferenceModificationImpl#isRemoveOpposite <em>Remove Opposite</em>}</li>
 *   <li>{@link modif.impl.ReferenceModificationImpl#getAddOpposite <em>Add Opposite</em>}</li>
 *   <li>{@link modif.impl.ReferenceModificationImpl#getReify <em>Reify</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReferenceModificationImpl extends StructuralFeatureModificationImpl implements ReferenceModification {
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
	 * The default value of the '{@link #isChangeContainement() <em>Change Containement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChangeContainement()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHANGE_CONTAINEMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChangeContainement() <em>Change Containement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChangeContainement()
	 * @generated
	 * @ordered
	 */
	protected boolean changeContainement = CHANGE_CONTAINEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemoveOpposite() <em>Remove Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveOpposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOVE_OPPOSITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemoveOpposite() <em>Remove Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveOpposite()
	 * @generated
	 * @ordered
	 */
	protected boolean removeOpposite = REMOVE_OPPOSITE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAddOpposite() <em>Add Opposite</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddOpposite()
	 * @generated
	 * @ordered
	 */
	protected AddOpposite addOpposite;

	/**
	 * The cached value of the '{@link #getReify() <em>Reify</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReify()
	 * @generated
	 * @ordered
	 */
	protected ReferenceReification reify;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.REFERENCE_MODIFICATION;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModifPackage.REFERENCE_MODIFICATION__CHANGE_BOUNDS, oldChangeBounds, newChangeBounds);
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
				msgs = ((InternalEObject)changeBounds).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModifPackage.REFERENCE_MODIFICATION__CHANGE_BOUNDS, null, msgs);
			if (newChangeBounds != null)
				msgs = ((InternalEObject)newChangeBounds).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModifPackage.REFERENCE_MODIFICATION__CHANGE_BOUNDS, null, msgs);
			msgs = basicSetChangeBounds(newChangeBounds, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.REFERENCE_MODIFICATION__CHANGE_BOUNDS, newChangeBounds, newChangeBounds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChangeContainement() {
		return changeContainement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeContainement(boolean newChangeContainement) {
		boolean oldChangeContainement = changeContainement;
		changeContainement = newChangeContainement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.REFERENCE_MODIFICATION__CHANGE_CONTAINEMENT, oldChangeContainement, changeContainement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemoveOpposite() {
		return removeOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoveOpposite(boolean newRemoveOpposite) {
		boolean oldRemoveOpposite = removeOpposite;
		removeOpposite = newRemoveOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.REFERENCE_MODIFICATION__REMOVE_OPPOSITE, oldRemoveOpposite, removeOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddOpposite getAddOpposite() {
		return addOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddOpposite(AddOpposite newAddOpposite, NotificationChain msgs) {
		AddOpposite oldAddOpposite = addOpposite;
		addOpposite = newAddOpposite;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModifPackage.REFERENCE_MODIFICATION__ADD_OPPOSITE, oldAddOpposite, newAddOpposite);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddOpposite(AddOpposite newAddOpposite) {
		if (newAddOpposite != addOpposite) {
			NotificationChain msgs = null;
			if (addOpposite != null)
				msgs = ((InternalEObject)addOpposite).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModifPackage.REFERENCE_MODIFICATION__ADD_OPPOSITE, null, msgs);
			if (newAddOpposite != null)
				msgs = ((InternalEObject)newAddOpposite).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModifPackage.REFERENCE_MODIFICATION__ADD_OPPOSITE, null, msgs);
			msgs = basicSetAddOpposite(newAddOpposite, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.REFERENCE_MODIFICATION__ADD_OPPOSITE, newAddOpposite, newAddOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceReification getReify() {
		return reify;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReify(ReferenceReification newReify, NotificationChain msgs) {
		ReferenceReification oldReify = reify;
		reify = newReify;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModifPackage.REFERENCE_MODIFICATION__REIFY, oldReify, newReify);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReify(ReferenceReification newReify) {
		if (newReify != reify) {
			NotificationChain msgs = null;
			if (reify != null)
				msgs = ((InternalEObject)reify).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModifPackage.REFERENCE_MODIFICATION__REIFY, null, msgs);
			if (newReify != null)
				msgs = ((InternalEObject)newReify).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModifPackage.REFERENCE_MODIFICATION__REIFY, null, msgs);
			msgs = basicSetReify(newReify, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.REFERENCE_MODIFICATION__REIFY, newReify, newReify));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModifPackage.REFERENCE_MODIFICATION__CHANGE_BOUNDS:
				return basicSetChangeBounds(null, msgs);
			case ModifPackage.REFERENCE_MODIFICATION__ADD_OPPOSITE:
				return basicSetAddOpposite(null, msgs);
			case ModifPackage.REFERENCE_MODIFICATION__REIFY:
				return basicSetReify(null, msgs);
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
			case ModifPackage.REFERENCE_MODIFICATION__CHANGE_BOUNDS:
				return getChangeBounds();
			case ModifPackage.REFERENCE_MODIFICATION__CHANGE_CONTAINEMENT:
				return isChangeContainement();
			case ModifPackage.REFERENCE_MODIFICATION__REMOVE_OPPOSITE:
				return isRemoveOpposite();
			case ModifPackage.REFERENCE_MODIFICATION__ADD_OPPOSITE:
				return getAddOpposite();
			case ModifPackage.REFERENCE_MODIFICATION__REIFY:
				return getReify();
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
			case ModifPackage.REFERENCE_MODIFICATION__CHANGE_BOUNDS:
				setChangeBounds((ChangeBounds)newValue);
				return;
			case ModifPackage.REFERENCE_MODIFICATION__CHANGE_CONTAINEMENT:
				setChangeContainement((Boolean)newValue);
				return;
			case ModifPackage.REFERENCE_MODIFICATION__REMOVE_OPPOSITE:
				setRemoveOpposite((Boolean)newValue);
				return;
			case ModifPackage.REFERENCE_MODIFICATION__ADD_OPPOSITE:
				setAddOpposite((AddOpposite)newValue);
				return;
			case ModifPackage.REFERENCE_MODIFICATION__REIFY:
				setReify((ReferenceReification)newValue);
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
			case ModifPackage.REFERENCE_MODIFICATION__CHANGE_BOUNDS:
				setChangeBounds((ChangeBounds)null);
				return;
			case ModifPackage.REFERENCE_MODIFICATION__CHANGE_CONTAINEMENT:
				setChangeContainement(CHANGE_CONTAINEMENT_EDEFAULT);
				return;
			case ModifPackage.REFERENCE_MODIFICATION__REMOVE_OPPOSITE:
				setRemoveOpposite(REMOVE_OPPOSITE_EDEFAULT);
				return;
			case ModifPackage.REFERENCE_MODIFICATION__ADD_OPPOSITE:
				setAddOpposite((AddOpposite)null);
				return;
			case ModifPackage.REFERENCE_MODIFICATION__REIFY:
				setReify((ReferenceReification)null);
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
			case ModifPackage.REFERENCE_MODIFICATION__CHANGE_BOUNDS:
				return changeBounds != null;
			case ModifPackage.REFERENCE_MODIFICATION__CHANGE_CONTAINEMENT:
				return changeContainement != CHANGE_CONTAINEMENT_EDEFAULT;
			case ModifPackage.REFERENCE_MODIFICATION__REMOVE_OPPOSITE:
				return removeOpposite != REMOVE_OPPOSITE_EDEFAULT;
			case ModifPackage.REFERENCE_MODIFICATION__ADD_OPPOSITE:
				return addOpposite != null;
			case ModifPackage.REFERENCE_MODIFICATION__REIFY:
				return reify != null;
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
		result.append(" (changeContainement: ");
		result.append(changeContainement);
		result.append(", removeOpposite: ");
		result.append(removeOpposite);
		result.append(')');
		return result.toString();
	}

} //ReferenceModificationImpl
