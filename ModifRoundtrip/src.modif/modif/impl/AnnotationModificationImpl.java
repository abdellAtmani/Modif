/**
 */
package modif.impl;

import java.util.Collection;

import modif.AnnotationModification;
import modif.DetailsEntryModification;
import modif.ModifPackage;

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
 * An implementation of the model object '<em><b>Annotation Modification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modif.impl.AnnotationModificationImpl#getOldSource <em>Old Source</em>}</li>
 *   <li>{@link modif.impl.AnnotationModificationImpl#getNewSource <em>New Source</em>}</li>
 *   <li>{@link modif.impl.AnnotationModificationImpl#isRemoveEAnnotations <em>Remove EAnnotations</em>}</li>
 *   <li>{@link modif.impl.AnnotationModificationImpl#isRemove <em>Remove</em>}</li>
 *   <li>{@link modif.impl.AnnotationModificationImpl#getDetailsEntryModification <em>Details Entry Modification</em>}</li>
 *   <li>{@link modif.impl.AnnotationModificationImpl#getAnnotationModification <em>Annotation Modification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnnotationModificationImpl extends MinimalEObjectImpl.Container implements AnnotationModification {
	/**
	 * The default value of the '{@link #getOldSource() <em>Old Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldSource()
	 * @generated
	 * @ordered
	 */
	protected static final String OLD_SOURCE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getOldSource() <em>Old Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOldSource()
	 * @generated
	 * @ordered
	 */
	protected String oldSource = OLD_SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNewSource() <em>New Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewSource()
	 * @generated
	 * @ordered
	 */
	protected static final String NEW_SOURCE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getNewSource() <em>New Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewSource()
	 * @generated
	 * @ordered
	 */
	protected String newSource = NEW_SOURCE_EDEFAULT;

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
	 * The cached value of the '{@link #getDetailsEntryModification() <em>Details Entry Modification</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailsEntryModification()
	 * @generated
	 * @ordered
	 */
	protected EList<DetailsEntryModification> detailsEntryModification;

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
	protected AnnotationModificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModifPackage.Literals.ANNOTATION_MODIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOldSource() {
		return oldSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOldSource(String newOldSource) {
		String oldOldSource = oldSource;
		oldSource = newOldSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ANNOTATION_MODIFICATION__OLD_SOURCE, oldOldSource, oldSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNewSource() {
		return newSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewSource(String newNewSource) {
		String oldNewSource = newSource;
		newSource = newNewSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ANNOTATION_MODIFICATION__NEW_SOURCE, oldNewSource, newSource));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ANNOTATION_MODIFICATION__REMOVE_EANNOTATIONS, oldRemoveEAnnotations, removeEAnnotations));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModifPackage.ANNOTATION_MODIFICATION__REMOVE, oldRemove, remove));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DetailsEntryModification> getDetailsEntryModification() {
		if (detailsEntryModification == null) {
			detailsEntryModification = new EObjectContainmentEList<DetailsEntryModification>(DetailsEntryModification.class, this, ModifPackage.ANNOTATION_MODIFICATION__DETAILS_ENTRY_MODIFICATION);
		}
		return detailsEntryModification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AnnotationModification> getAnnotationModification() {
		if (annotationModification == null) {
			annotationModification = new EObjectContainmentEList<AnnotationModification>(AnnotationModification.class, this, ModifPackage.ANNOTATION_MODIFICATION__ANNOTATION_MODIFICATION);
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
			case ModifPackage.ANNOTATION_MODIFICATION__DETAILS_ENTRY_MODIFICATION:
				return ((InternalEList<?>)getDetailsEntryModification()).basicRemove(otherEnd, msgs);
			case ModifPackage.ANNOTATION_MODIFICATION__ANNOTATION_MODIFICATION:
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
			case ModifPackage.ANNOTATION_MODIFICATION__OLD_SOURCE:
				return getOldSource();
			case ModifPackage.ANNOTATION_MODIFICATION__NEW_SOURCE:
				return getNewSource();
			case ModifPackage.ANNOTATION_MODIFICATION__REMOVE_EANNOTATIONS:
				return isRemoveEAnnotations();
			case ModifPackage.ANNOTATION_MODIFICATION__REMOVE:
				return isRemove();
			case ModifPackage.ANNOTATION_MODIFICATION__DETAILS_ENTRY_MODIFICATION:
				return getDetailsEntryModification();
			case ModifPackage.ANNOTATION_MODIFICATION__ANNOTATION_MODIFICATION:
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
			case ModifPackage.ANNOTATION_MODIFICATION__OLD_SOURCE:
				setOldSource((String)newValue);
				return;
			case ModifPackage.ANNOTATION_MODIFICATION__NEW_SOURCE:
				setNewSource((String)newValue);
				return;
			case ModifPackage.ANNOTATION_MODIFICATION__REMOVE_EANNOTATIONS:
				setRemoveEAnnotations((Boolean)newValue);
				return;
			case ModifPackage.ANNOTATION_MODIFICATION__REMOVE:
				setRemove((Boolean)newValue);
				return;
			case ModifPackage.ANNOTATION_MODIFICATION__DETAILS_ENTRY_MODIFICATION:
				getDetailsEntryModification().clear();
				getDetailsEntryModification().addAll((Collection<? extends DetailsEntryModification>)newValue);
				return;
			case ModifPackage.ANNOTATION_MODIFICATION__ANNOTATION_MODIFICATION:
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
			case ModifPackage.ANNOTATION_MODIFICATION__OLD_SOURCE:
				setOldSource(OLD_SOURCE_EDEFAULT);
				return;
			case ModifPackage.ANNOTATION_MODIFICATION__NEW_SOURCE:
				setNewSource(NEW_SOURCE_EDEFAULT);
				return;
			case ModifPackage.ANNOTATION_MODIFICATION__REMOVE_EANNOTATIONS:
				setRemoveEAnnotations(REMOVE_EANNOTATIONS_EDEFAULT);
				return;
			case ModifPackage.ANNOTATION_MODIFICATION__REMOVE:
				setRemove(REMOVE_EDEFAULT);
				return;
			case ModifPackage.ANNOTATION_MODIFICATION__DETAILS_ENTRY_MODIFICATION:
				getDetailsEntryModification().clear();
				return;
			case ModifPackage.ANNOTATION_MODIFICATION__ANNOTATION_MODIFICATION:
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
			case ModifPackage.ANNOTATION_MODIFICATION__OLD_SOURCE:
				return OLD_SOURCE_EDEFAULT == null ? oldSource != null : !OLD_SOURCE_EDEFAULT.equals(oldSource);
			case ModifPackage.ANNOTATION_MODIFICATION__NEW_SOURCE:
				return NEW_SOURCE_EDEFAULT == null ? newSource != null : !NEW_SOURCE_EDEFAULT.equals(newSource);
			case ModifPackage.ANNOTATION_MODIFICATION__REMOVE_EANNOTATIONS:
				return removeEAnnotations != REMOVE_EANNOTATIONS_EDEFAULT;
			case ModifPackage.ANNOTATION_MODIFICATION__REMOVE:
				return remove != REMOVE_EDEFAULT;
			case ModifPackage.ANNOTATION_MODIFICATION__DETAILS_ENTRY_MODIFICATION:
				return detailsEntryModification != null && !detailsEntryModification.isEmpty();
			case ModifPackage.ANNOTATION_MODIFICATION__ANNOTATION_MODIFICATION:
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
		result.append(" (oldSource: ");
		result.append(oldSource);
		result.append(", newSource: ");
		result.append(newSource);
		result.append(", removeEAnnotations: ");
		result.append(removeEAnnotations);
		result.append(", remove: ");
		result.append(remove);
		result.append(')');
		return result.toString();
	}

} //AnnotationModificationImpl
