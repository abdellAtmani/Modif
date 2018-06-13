/**
 */
package modif.impl;

import java.util.Collection;

import modif.AnnotationModification;
import modif.ModifPackage;
import modif.Modification;

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
 * An implementation of the model object '<em><b>Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.ModificationImpl#getOldName <em>Old Name</em>}</li>
 *   <li>{@link modif.impl.ModificationImpl#getNewName <em>New Name</em>}</li>
 *   <li>{@link modif.impl.ModificationImpl#isRemove <em>Remove</em>}</li>
 *   <li>{@link modif.impl.ModificationImpl#isRemoveEAnnotations <em>Remove EAnnotations</em>}</li>
 *   <li>{@link modif.impl.ModificationImpl#getAnnotationModification <em>Annotation Modification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ModificationImpl extends MinimalEObjectImpl.Container implements Modification {
	/**
	 * The default value of the '{@link #getOldName() <em>Old Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldName()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOldName() <em>Old Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldName()
	 * @generated
	 * @ordered
	 */
	protected String oldName = OLD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewName() <em>New Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewName()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getNewName() <em>New Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewName()
	 * @generated
	 * @ordered
	 */
	protected String newName = NEW_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemove() <em>Remove</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemove()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemove() <em>Remove</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemove()
	 * @generated
	 * @ordered
	 */
	protected boolean remove = REMOVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemoveEAnnotations() <em>Remove EAnnotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveEAnnotations()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOVE_EANNOTATIONS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemoveEAnnotations() <em>Remove EAnnotations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoveEAnnotations()
	 * @generated
	 * @ordered
	 */
	protected boolean removeEAnnotations = REMOVE_EANNOTATIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnnotationModification() <em>Annotation Modification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotationModification()
	 * @generated
	 * @ordered
	 */
	protected EList<AnnotationModification> annotationModification;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.MODIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldName() {
		return oldName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldName(String newOldName) {
		String oldOldName = oldName;
		oldName = newOldName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATION__OLD_NAME, oldOldName, oldName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewName() {
		return newName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewName(String newNewName) {
		String oldNewName = newName;
		newName = newNewName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATION__NEW_NAME, oldNewName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemove() {
		return remove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemove(boolean newRemove) {
		boolean oldRemove = remove;
		remove = newRemove;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATION__REMOVE, oldRemove, remove));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemoveEAnnotations() {
		return removeEAnnotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoveEAnnotations(boolean newRemoveEAnnotations) {
		boolean oldRemoveEAnnotations = removeEAnnotations;
		removeEAnnotations = newRemoveEAnnotations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.MODIFICATION__REMOVE_EANNOTATIONS, oldRemoveEAnnotations, removeEAnnotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationModification> getAnnotationModification() {
		if (annotationModification == null) {
			annotationModification = new EObjectContainmentEList<AnnotationModification>(AnnotationModification.class, this, ModifPackage.MODIFICATION__ANNOTATION_MODIFICATION);
		}
		return annotationModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModifPackage.MODIFICATION__ANNOTATION_MODIFICATION:
				return ((InternalEList<?>)getAnnotationModification()).basicRemove(otherEnd, msgs);
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
			case ModifPackage.MODIFICATION__OLD_NAME:
				return getOldName();
			case ModifPackage.MODIFICATION__NEW_NAME:
				return getNewName();
			case ModifPackage.MODIFICATION__REMOVE:
				return isRemove();
			case ModifPackage.MODIFICATION__REMOVE_EANNOTATIONS:
				return isRemoveEAnnotations();
			case ModifPackage.MODIFICATION__ANNOTATION_MODIFICATION:
				return getAnnotationModification();
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
			case ModifPackage.MODIFICATION__OLD_NAME:
				setOldName((String)newValue);
				return;
			case ModifPackage.MODIFICATION__NEW_NAME:
				setNewName((String)newValue);
				return;
			case ModifPackage.MODIFICATION__REMOVE:
				setRemove((Boolean)newValue);
				return;
			case ModifPackage.MODIFICATION__REMOVE_EANNOTATIONS:
				setRemoveEAnnotations((Boolean)newValue);
				return;
			case ModifPackage.MODIFICATION__ANNOTATION_MODIFICATION:
				getAnnotationModification().clear();
				getAnnotationModification().addAll((Collection<? extends AnnotationModification>)newValue);
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
			case ModifPackage.MODIFICATION__OLD_NAME:
				setOldName(OLD_NAME_EDEFAULT);
				return;
			case ModifPackage.MODIFICATION__NEW_NAME:
				setNewName(NEW_NAME_EDEFAULT);
				return;
			case ModifPackage.MODIFICATION__REMOVE:
				setRemove(REMOVE_EDEFAULT);
				return;
			case ModifPackage.MODIFICATION__REMOVE_EANNOTATIONS:
				setRemoveEAnnotations(REMOVE_EANNOTATIONS_EDEFAULT);
				return;
			case ModifPackage.MODIFICATION__ANNOTATION_MODIFICATION:
				getAnnotationModification().clear();
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
			case ModifPackage.MODIFICATION__OLD_NAME:
				return OLD_NAME_EDEFAULT == null ? oldName != null : !OLD_NAME_EDEFAULT.equals(oldName);
			case ModifPackage.MODIFICATION__NEW_NAME:
				return NEW_NAME_EDEFAULT == null ? newName != null : !NEW_NAME_EDEFAULT.equals(newName);
			case ModifPackage.MODIFICATION__REMOVE:
				return remove != REMOVE_EDEFAULT;
			case ModifPackage.MODIFICATION__REMOVE_EANNOTATIONS:
				return removeEAnnotations != REMOVE_EANNOTATIONS_EDEFAULT;
			case ModifPackage.MODIFICATION__ANNOTATION_MODIFICATION:
				return annotationModification != null && !annotationModification.isEmpty();
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
		result.append(" (oldName: ");
		result.append(oldName);
		result.append(", newName: ");
		result.append(newName);
		result.append(", remove: ");
		result.append(remove);
		result.append(", removeEAnnotations: ");
		result.append(removeEAnnotations);
		result.append(')');
		return result.toString();
	}

} //ModificationImpl
