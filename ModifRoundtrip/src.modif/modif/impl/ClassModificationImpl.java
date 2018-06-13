/**
 */
package modif.impl;

import java.util.Collection;

import modif.AddDerived;
import modif.AddFeature;
import modif.ClassModification;
import modif.Enumerate;
import modif.ModifPackage;
import modif.StructuralFeatureModification;

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
 * An implementation of the model object '<em><b>Class Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.ClassModificationImpl#isChangeAbstract <em>Change Abstract</em>}</li>
 *   <li>{@link modif.impl.ClassModificationImpl#isHide <em>Hide</em>}</li>
 *   <li>{@link modif.impl.ClassModificationImpl#isFlatten <em>Flatten</em>}</li>
 *   <li>{@link modif.impl.ClassModificationImpl#isFlattenAll <em>Flatten All</em>}</li>
 *   <li>{@link modif.impl.ClassModificationImpl#getFeatureModification <em>Feature Modification</em>}</li>
 *   <li>{@link modif.impl.ClassModificationImpl#getAddFeatures <em>Add Features</em>}</li>
 *   <li>{@link modif.impl.ClassModificationImpl#getAddDeriveds <em>Add Deriveds</em>}</li>
 *   <li>{@link modif.impl.ClassModificationImpl#getEnumerate <em>Enumerate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassModificationImpl extends ModificationImpl implements ClassModification {
	/**
	 * The default value of the '{@link #isChangeAbstract() <em>Change Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChangeAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHANGE_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isChangeAbstract() <em>Change Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isChangeAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean changeAbstract = CHANGE_ABSTRACT_EDEFAULT;

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
	 * The default value of the '{@link #isFlatten() <em>Flatten</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlatten()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FLATTEN_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFlatten() <em>Flatten</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlatten()
	 * @generated
	 * @ordered
	 */
	protected boolean flatten = FLATTEN_EDEFAULT;

	/**
	 * The default value of the '{@link #isFlattenAll() <em>Flatten All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlattenAll()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FLATTEN_ALL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFlattenAll() <em>Flatten All</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFlattenAll()
	 * @generated
	 * @ordered
	 */
	protected boolean flattenAll = FLATTEN_ALL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFeatureModification() <em>Feature Modification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureModification()
	 * @generated
	 * @ordered
	 */
	protected EList<StructuralFeatureModification> featureModification;

	/**
	 * The cached value of the '{@link #getAddFeatures() <em>Add Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<AddFeature> addFeatures;

	/**
	 * The cached value of the '{@link #getAddDeriveds() <em>Add Deriveds</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddDeriveds()
	 * @generated
	 * @ordered
	 */
	protected EList<AddDerived> addDeriveds;

	/**
	 * The cached value of the '{@link #getEnumerate() <em>Enumerate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumerate()
	 * @generated
	 * @ordered
	 */
	protected Enumerate enumerate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.CLASS_MODIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isChangeAbstract() {
		return changeAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeAbstract(boolean newChangeAbstract) {
		boolean oldChangeAbstract = changeAbstract;
		changeAbstract = newChangeAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.CLASS_MODIFICATION__CHANGE_ABSTRACT, oldChangeAbstract, changeAbstract));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.CLASS_MODIFICATION__HIDE, oldHide, hide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFlatten() {
		return flatten;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlatten(boolean newFlatten) {
		boolean oldFlatten = flatten;
		flatten = newFlatten;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.CLASS_MODIFICATION__FLATTEN, oldFlatten, flatten));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFlattenAll() {
		return flattenAll;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFlattenAll(boolean newFlattenAll) {
		boolean oldFlattenAll = flattenAll;
		flattenAll = newFlattenAll;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.CLASS_MODIFICATION__FLATTEN_ALL, oldFlattenAll, flattenAll));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StructuralFeatureModification> getFeatureModification() {
		if (featureModification == null) {
			featureModification = new EObjectContainmentEList<StructuralFeatureModification>(StructuralFeatureModification.class, this, ModifPackage.CLASS_MODIFICATION__FEATURE_MODIFICATION);
		}
		return featureModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddFeature> getAddFeatures() {
		if (addFeatures == null) {
			addFeatures = new EObjectContainmentEList<AddFeature>(AddFeature.class, this, ModifPackage.CLASS_MODIFICATION__ADD_FEATURES);
		}
		return addFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AddDerived> getAddDeriveds() {
		if (addDeriveds == null) {
			addDeriveds = new EObjectContainmentEList<AddDerived>(AddDerived.class, this, ModifPackage.CLASS_MODIFICATION__ADD_DERIVEDS);
		}
		return addDeriveds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumerate getEnumerate() {
		return enumerate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnumerate(Enumerate newEnumerate, NotificationChain msgs) {
		Enumerate oldEnumerate = enumerate;
		enumerate = newEnumerate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModifPackage.CLASS_MODIFICATION__ENUMERATE, oldEnumerate, newEnumerate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumerate(Enumerate newEnumerate) {
		if (newEnumerate != enumerate) {
			NotificationChain msgs = null;
			if (enumerate != null)
				msgs = ((InternalEObject)enumerate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModifPackage.CLASS_MODIFICATION__ENUMERATE, null, msgs);
			if (newEnumerate != null)
				msgs = ((InternalEObject)newEnumerate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModifPackage.CLASS_MODIFICATION__ENUMERATE, null, msgs);
			msgs = basicSetEnumerate(newEnumerate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.CLASS_MODIFICATION__ENUMERATE, newEnumerate, newEnumerate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModifPackage.CLASS_MODIFICATION__FEATURE_MODIFICATION:
				return ((InternalEList<?>)getFeatureModification()).basicRemove(otherEnd, msgs);
			case ModifPackage.CLASS_MODIFICATION__ADD_FEATURES:
				return ((InternalEList<?>)getAddFeatures()).basicRemove(otherEnd, msgs);
			case ModifPackage.CLASS_MODIFICATION__ADD_DERIVEDS:
				return ((InternalEList<?>)getAddDeriveds()).basicRemove(otherEnd, msgs);
			case ModifPackage.CLASS_MODIFICATION__ENUMERATE:
				return basicSetEnumerate(null, msgs);
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
			case ModifPackage.CLASS_MODIFICATION__CHANGE_ABSTRACT:
				return isChangeAbstract();
			case ModifPackage.CLASS_MODIFICATION__HIDE:
				return isHide();
			case ModifPackage.CLASS_MODIFICATION__FLATTEN:
				return isFlatten();
			case ModifPackage.CLASS_MODIFICATION__FLATTEN_ALL:
				return isFlattenAll();
			case ModifPackage.CLASS_MODIFICATION__FEATURE_MODIFICATION:
				return getFeatureModification();
			case ModifPackage.CLASS_MODIFICATION__ADD_FEATURES:
				return getAddFeatures();
			case ModifPackage.CLASS_MODIFICATION__ADD_DERIVEDS:
				return getAddDeriveds();
			case ModifPackage.CLASS_MODIFICATION__ENUMERATE:
				return getEnumerate();
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
			case ModifPackage.CLASS_MODIFICATION__CHANGE_ABSTRACT:
				setChangeAbstract((Boolean)newValue);
				return;
			case ModifPackage.CLASS_MODIFICATION__HIDE:
				setHide((Boolean)newValue);
				return;
			case ModifPackage.CLASS_MODIFICATION__FLATTEN:
				setFlatten((Boolean)newValue);
				return;
			case ModifPackage.CLASS_MODIFICATION__FLATTEN_ALL:
				setFlattenAll((Boolean)newValue);
				return;
			case ModifPackage.CLASS_MODIFICATION__FEATURE_MODIFICATION:
				getFeatureModification().clear();
				getFeatureModification().addAll((Collection<? extends StructuralFeatureModification>)newValue);
				return;
			case ModifPackage.CLASS_MODIFICATION__ADD_FEATURES:
				getAddFeatures().clear();
				getAddFeatures().addAll((Collection<? extends AddFeature>)newValue);
				return;
			case ModifPackage.CLASS_MODIFICATION__ADD_DERIVEDS:
				getAddDeriveds().clear();
				getAddDeriveds().addAll((Collection<? extends AddDerived>)newValue);
				return;
			case ModifPackage.CLASS_MODIFICATION__ENUMERATE:
				setEnumerate((Enumerate)newValue);
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
			case ModifPackage.CLASS_MODIFICATION__CHANGE_ABSTRACT:
				setChangeAbstract(CHANGE_ABSTRACT_EDEFAULT);
				return;
			case ModifPackage.CLASS_MODIFICATION__HIDE:
				setHide(HIDE_EDEFAULT);
				return;
			case ModifPackage.CLASS_MODIFICATION__FLATTEN:
				setFlatten(FLATTEN_EDEFAULT);
				return;
			case ModifPackage.CLASS_MODIFICATION__FLATTEN_ALL:
				setFlattenAll(FLATTEN_ALL_EDEFAULT);
				return;
			case ModifPackage.CLASS_MODIFICATION__FEATURE_MODIFICATION:
				getFeatureModification().clear();
				return;
			case ModifPackage.CLASS_MODIFICATION__ADD_FEATURES:
				getAddFeatures().clear();
				return;
			case ModifPackage.CLASS_MODIFICATION__ADD_DERIVEDS:
				getAddDeriveds().clear();
				return;
			case ModifPackage.CLASS_MODIFICATION__ENUMERATE:
				setEnumerate((Enumerate)null);
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
			case ModifPackage.CLASS_MODIFICATION__CHANGE_ABSTRACT:
				return changeAbstract != CHANGE_ABSTRACT_EDEFAULT;
			case ModifPackage.CLASS_MODIFICATION__HIDE:
				return hide != HIDE_EDEFAULT;
			case ModifPackage.CLASS_MODIFICATION__FLATTEN:
				return flatten != FLATTEN_EDEFAULT;
			case ModifPackage.CLASS_MODIFICATION__FLATTEN_ALL:
				return flattenAll != FLATTEN_ALL_EDEFAULT;
			case ModifPackage.CLASS_MODIFICATION__FEATURE_MODIFICATION:
				return featureModification != null && !featureModification.isEmpty();
			case ModifPackage.CLASS_MODIFICATION__ADD_FEATURES:
				return addFeatures != null && !addFeatures.isEmpty();
			case ModifPackage.CLASS_MODIFICATION__ADD_DERIVEDS:
				return addDeriveds != null && !addDeriveds.isEmpty();
			case ModifPackage.CLASS_MODIFICATION__ENUMERATE:
				return enumerate != null;
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
		result.append(" (changeAbstract: ");
		result.append(changeAbstract);
		result.append(", hide: ");
		result.append(hide);
		result.append(", flatten: ");
		result.append(flatten);
		result.append(", flattenAll: ");
		result.append(flattenAll);
		result.append(')');
		return result.toString();
	}

} //ClassModificationImpl
