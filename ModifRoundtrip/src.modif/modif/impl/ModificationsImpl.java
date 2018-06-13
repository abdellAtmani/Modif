/**
 */
package modif.impl;

import modif.AddNameClass;
import modif.AddRootClass;
import modif.ModifPackage;
import modif.Modifications;
import modif.PackageModification;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Modifications</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.ModificationsImpl#getRootPackageModification <em>Root Package Modification</em>}</li>
 *   <li>{@link modif.impl.ModificationsImpl#getAddRootClass <em>Add Root Class</em>}</li>
 *   <li>{@link modif.impl.ModificationsImpl#getAddNameClass <em>Add Name Class</em>}</li>
 *   <li>{@link modif.impl.ModificationsImpl#isRemoveAllAnnotations <em>Remove All Annotations</em>}</li>
 *   <li>{@link modif.impl.ModificationsImpl#isRemoveAllOperations <em>Remove All Operations</em>}</li>
 *   <li>{@link modif.impl.ModificationsImpl#isRemoveAllEStringAttributes <em>Remove All EString Attributes</em>}</li>
 *   <li>{@link modif.impl.ModificationsImpl#isRemoveAllOpposites <em>Remove All Opposites</em>}</li>
 *   <li>{@link modif.impl.ModificationsImpl#isAddAllOpposite <em>Add All Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModificationsImpl extends MinimalEObjectImpl.Container implements Modifications {
	/**
	 * The cached value of the '{@link #getRootPackageModification() <em>Root Package Modification</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootPackageModification()
	 * @generated
	 * @ordered
	 */
	protected PackageModification rootPackageModification;

	/**
	 * The cached value of the '{@link #getAddRootClass() <em>Add Root Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddRootClass()
	 * @generated
	 * @ordered
	 */
	protected AddRootClass addRootClass;

	/**
	 * The cached value of the '{@link #getAddNameClass() <em>Add Name Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddNameClass()
	 * @generated
	 * @ordered
	 */
	protected AddNameClass addNameClass;

	/**
	 * The default value of the '{@link #isRemoveAllAnnotations() <em>Remove All Annotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveAllAnnotations()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOVE_ALL_ANNOTATIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemoveAllAnnotations() <em>Remove All Annotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveAllAnnotations()
	 * @generated
	 * @ordered
	 */
	protected boolean removeAllAnnotations = REMOVE_ALL_ANNOTATIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemoveAllOperations() <em>Remove All Operations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveAllOperations()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOVE_ALL_OPERATIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemoveAllOperations() <em>Remove All Operations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveAllOperations()
	 * @generated
	 * @ordered
	 */
	protected boolean removeAllOperations = REMOVE_ALL_OPERATIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemoveAllEStringAttributes() <em>Remove All EString Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveAllEStringAttributes()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOVE_ALL_ESTRING_ATTRIBUTES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemoveAllEStringAttributes() <em>Remove All EString Attributes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveAllEStringAttributes()
	 * @generated
	 * @ordered
	 */
	protected boolean removeAllEStringAttributes = REMOVE_ALL_ESTRING_ATTRIBUTES_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemoveAllOpposites() <em>Remove All Opposites</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveAllOpposites()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOVE_ALL_OPPOSITES_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemoveAllOpposites() <em>Remove All Opposites</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveAllOpposites()
	 * @generated
	 * @ordered
	 */
	protected boolean removeAllOpposites = REMOVE_ALL_OPPOSITES_EDEFAULT;

	/**
	 * The default value of the '{@link #isAddAllOpposite() <em>Add All Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddAllOpposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ADD_ALL_OPPOSITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAddAllOpposite() <em>Add All Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAddAllOpposite()
	 * @generated
	 * @ordered
	 */
	protected boolean addAllOpposite = ADD_ALL_OPPOSITE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModificationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.MODIFICATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageModification getRootPackageModification() {
		return rootPackageModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRootPackageModification(PackageModification newRootPackageModification, NotificationChain msgs) {
		PackageModification oldRootPackageModification = rootPackageModification;
		rootPackageModification = newRootPackageModification;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATIONS__ROOT_PACKAGE_MODIFICATION, oldRootPackageModification, newRootPackageModification);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootPackageModification(PackageModification newRootPackageModification) {
		if (newRootPackageModification != rootPackageModification) {
			NotificationChain msgs = null;
			if (rootPackageModification != null)
				msgs = ((InternalEObject)rootPackageModification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModifPackage.MODIFICATIONS__ROOT_PACKAGE_MODIFICATION, null, msgs);
			if (newRootPackageModification != null)
				msgs = ((InternalEObject)newRootPackageModification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModifPackage.MODIFICATIONS__ROOT_PACKAGE_MODIFICATION, null, msgs);
			msgs = basicSetRootPackageModification(newRootPackageModification, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATIONS__ROOT_PACKAGE_MODIFICATION, newRootPackageModification, newRootPackageModification));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddRootClass getAddRootClass() {
		return addRootClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddRootClass(AddRootClass newAddRootClass, NotificationChain msgs) {
		AddRootClass oldAddRootClass = addRootClass;
		addRootClass = newAddRootClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATIONS__ADD_ROOT_CLASS, oldAddRootClass, newAddRootClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddRootClass(AddRootClass newAddRootClass) {
		if (newAddRootClass != addRootClass) {
			NotificationChain msgs = null;
			if (addRootClass != null)
				msgs = ((InternalEObject)addRootClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModifPackage.MODIFICATIONS__ADD_ROOT_CLASS, null, msgs);
			if (newAddRootClass != null)
				msgs = ((InternalEObject)newAddRootClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModifPackage.MODIFICATIONS__ADD_ROOT_CLASS, null, msgs);
			msgs = basicSetAddRootClass(newAddRootClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATIONS__ADD_ROOT_CLASS, newAddRootClass, newAddRootClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddNameClass getAddNameClass() {
		return addNameClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddNameClass(AddNameClass newAddNameClass, NotificationChain msgs) {
		AddNameClass oldAddNameClass = addNameClass;
		addNameClass = newAddNameClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATIONS__ADD_NAME_CLASS, oldAddNameClass, newAddNameClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddNameClass(AddNameClass newAddNameClass) {
		if (newAddNameClass != addNameClass) {
			NotificationChain msgs = null;
			if (addNameClass != null)
				msgs = ((InternalEObject)addNameClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModifPackage.MODIFICATIONS__ADD_NAME_CLASS, null, msgs);
			if (newAddNameClass != null)
				msgs = ((InternalEObject)newAddNameClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModifPackage.MODIFICATIONS__ADD_NAME_CLASS, null, msgs);
			msgs = basicSetAddNameClass(newAddNameClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATIONS__ADD_NAME_CLASS, newAddNameClass, newAddNameClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemoveAllAnnotations() {
		return removeAllAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoveAllAnnotations(boolean newRemoveAllAnnotations) {
		boolean oldRemoveAllAnnotations = removeAllAnnotations;
		removeAllAnnotations = newRemoveAllAnnotations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATIONS__REMOVE_ALL_ANNOTATIONS, oldRemoveAllAnnotations, removeAllAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemoveAllOperations() {
		return removeAllOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoveAllOperations(boolean newRemoveAllOperations) {
		boolean oldRemoveAllOperations = removeAllOperations;
		removeAllOperations = newRemoveAllOperations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATIONS__REMOVE_ALL_OPERATIONS, oldRemoveAllOperations, removeAllOperations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemoveAllEStringAttributes() {
		return removeAllEStringAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoveAllEStringAttributes(boolean newRemoveAllEStringAttributes) {
		boolean oldRemoveAllEStringAttributes = removeAllEStringAttributes;
		removeAllEStringAttributes = newRemoveAllEStringAttributes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATIONS__REMOVE_ALL_ESTRING_ATTRIBUTES, oldRemoveAllEStringAttributes, removeAllEStringAttributes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemoveAllOpposites() {
		return removeAllOpposites;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoveAllOpposites(boolean newRemoveAllOpposites) {
		boolean oldRemoveAllOpposites = removeAllOpposites;
		removeAllOpposites = newRemoveAllOpposites;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATIONS__REMOVE_ALL_OPPOSITES, oldRemoveAllOpposites, removeAllOpposites));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAddAllOpposite() {
		return addAllOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddAllOpposite(boolean newAddAllOpposite) {
		boolean oldAddAllOpposite = addAllOpposite;
		addAllOpposite = newAddAllOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATIONS__ADD_ALL_OPPOSITE, oldAddAllOpposite, addAllOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModifPackage.MODIFICATIONS__ROOT_PACKAGE_MODIFICATION:
				return basicSetRootPackageModification(null, msgs);
			case ModifPackage.MODIFICATIONS__ADD_ROOT_CLASS:
				return basicSetAddRootClass(null, msgs);
			case ModifPackage.MODIFICATIONS__ADD_NAME_CLASS:
				return basicSetAddNameClass(null, msgs);
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
			case ModifPackage.MODIFICATIONS__ROOT_PACKAGE_MODIFICATION:
				return getRootPackageModification();
			case ModifPackage.MODIFICATIONS__ADD_ROOT_CLASS:
				return getAddRootClass();
			case ModifPackage.MODIFICATIONS__ADD_NAME_CLASS:
				return getAddNameClass();
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_ANNOTATIONS:
				return isRemoveAllAnnotations();
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_OPERATIONS:
				return isRemoveAllOperations();
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_ESTRING_ATTRIBUTES:
				return isRemoveAllEStringAttributes();
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_OPPOSITES:
				return isRemoveAllOpposites();
			case ModifPackage.MODIFICATIONS__ADD_ALL_OPPOSITE:
				return isAddAllOpposite();
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
			case ModifPackage.MODIFICATIONS__ROOT_PACKAGE_MODIFICATION:
				setRootPackageModification((PackageModification)newValue);
				return;
			case ModifPackage.MODIFICATIONS__ADD_ROOT_CLASS:
				setAddRootClass((AddRootClass)newValue);
				return;
			case ModifPackage.MODIFICATIONS__ADD_NAME_CLASS:
				setAddNameClass((AddNameClass)newValue);
				return;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_ANNOTATIONS:
				setRemoveAllAnnotations((Boolean)newValue);
				return;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_OPERATIONS:
				setRemoveAllOperations((Boolean)newValue);
				return;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_ESTRING_ATTRIBUTES:
				setRemoveAllEStringAttributes((Boolean)newValue);
				return;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_OPPOSITES:
				setRemoveAllOpposites((Boolean)newValue);
				return;
			case ModifPackage.MODIFICATIONS__ADD_ALL_OPPOSITE:
				setAddAllOpposite((Boolean)newValue);
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
			case ModifPackage.MODIFICATIONS__ROOT_PACKAGE_MODIFICATION:
				setRootPackageModification((PackageModification)null);
				return;
			case ModifPackage.MODIFICATIONS__ADD_ROOT_CLASS:
				setAddRootClass((AddRootClass)null);
				return;
			case ModifPackage.MODIFICATIONS__ADD_NAME_CLASS:
				setAddNameClass((AddNameClass)null);
				return;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_ANNOTATIONS:
				setRemoveAllAnnotations(REMOVE_ALL_ANNOTATIONS_EDEFAULT);
				return;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_OPERATIONS:
				setRemoveAllOperations(REMOVE_ALL_OPERATIONS_EDEFAULT);
				return;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_ESTRING_ATTRIBUTES:
				setRemoveAllEStringAttributes(REMOVE_ALL_ESTRING_ATTRIBUTES_EDEFAULT);
				return;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_OPPOSITES:
				setRemoveAllOpposites(REMOVE_ALL_OPPOSITES_EDEFAULT);
				return;
			case ModifPackage.MODIFICATIONS__ADD_ALL_OPPOSITE:
				setAddAllOpposite(ADD_ALL_OPPOSITE_EDEFAULT);
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
			case ModifPackage.MODIFICATIONS__ROOT_PACKAGE_MODIFICATION:
				return rootPackageModification != null;
			case ModifPackage.MODIFICATIONS__ADD_ROOT_CLASS:
				return addRootClass != null;
			case ModifPackage.MODIFICATIONS__ADD_NAME_CLASS:
				return addNameClass != null;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_ANNOTATIONS:
				return removeAllAnnotations != REMOVE_ALL_ANNOTATIONS_EDEFAULT;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_OPERATIONS:
				return removeAllOperations != REMOVE_ALL_OPERATIONS_EDEFAULT;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_ESTRING_ATTRIBUTES:
				return removeAllEStringAttributes != REMOVE_ALL_ESTRING_ATTRIBUTES_EDEFAULT;
			case ModifPackage.MODIFICATIONS__REMOVE_ALL_OPPOSITES:
				return removeAllOpposites != REMOVE_ALL_OPPOSITES_EDEFAULT;
			case ModifPackage.MODIFICATIONS__ADD_ALL_OPPOSITE:
				return addAllOpposite != ADD_ALL_OPPOSITE_EDEFAULT;
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
		result.append(" (removeAllAnnotations: ");
		result.append(removeAllAnnotations);
		result.append(", removeAllOperations: ");
		result.append(removeAllOperations);
		result.append(", removeAllEStringAttributes: ");
		result.append(removeAllEStringAttributes);
		result.append(", removeAllOpposites: ");
		result.append(removeAllOpposites);
		result.append(", addAllOpposite: ");
		result.append(addAllOpposite);
		result.append(')');
		return result.toString();
	}

} //ModificationsImpl
