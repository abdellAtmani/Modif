/**
 */
package migration.impl;

import java.util.Collection;

import migration.Instance;
import migration.Migration;
import migration.MigrationPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Migration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link migration.impl.MigrationImpl#getInstances <em>Instances</em>}</li>
 *   <li>{@link migration.impl.MigrationImpl#getInputModelURI <em>Input Model URI</em>}</li>
 *   <li>{@link migration.impl.MigrationImpl#getInputMetamodelURI <em>Input Metamodel URI</em>}</li>
 *   <li>{@link migration.impl.MigrationImpl#getOutputModelURI <em>Output Model URI</em>}</li>
 *   <li>{@link migration.impl.MigrationImpl#getOutputMetamodelURI <em>Output Metamodel URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MigrationImpl extends MinimalEObjectImpl.Container implements Migration {
	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<Instance> instances;

	/**
	 * The default value of the '{@link #getInputModelURI() <em>Input Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputModelURI()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_MODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputModelURI() <em>Input Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputModelURI()
	 * @generated
	 * @ordered
	 */
	protected String inputModelURI = INPUT_MODEL_URI_EDEFAULT;

	protected static final EObject INPUT_MODEL_EDEFAULT = null;
	
	protected EObject inputModel = INPUT_MODEL_EDEFAULT;
	
	/**
	 * The default value of the '{@link #getInputMetamodelURI() <em>Input Metamodel URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputMetamodelURI()
	 * @generated
	 * @ordered
	 */
	protected static final String INPUT_METAMODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInputMetamodelURI() <em>Input Metamodel URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputMetamodelURI()
	 * @generated
	 * @ordered
	 */
	protected String inputMetamodelURI = INPUT_METAMODEL_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputModelURI() <em>Output Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputModelURI()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_MODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputModelURI() <em>Output Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputModelURI()
	 * @generated
	 * @ordered
	 */
	protected String outputModelURI = OUTPUT_MODEL_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutputMetamodelURI() <em>Output Metamodel URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputMetamodelURI()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_METAMODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutputMetamodelURI() <em>Output Metamodel URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputMetamodelURI()
	 * @generated
	 * @ordered
	 */
	protected String outputMetamodelURI = OUTPUT_METAMODEL_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MigrationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MigrationPackage.Literals.MIGRATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Instance> getInstances() {
		if (instances == null) {
			instances = new EObjectContainmentEList<Instance>(Instance.class, this, MigrationPackage.MIGRATION__INSTANCES);
		}
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputModelURI() {
		return inputModelURI;
	}
	
	public EObject getInputModel() {
		return inputModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputModelURI(String newInputModelURI) {
		String oldInputModelURI = inputModelURI;
		inputModelURI = newInputModelURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.MIGRATION__INPUT_MODEL_URI, oldInputModelURI, inputModelURI));
	}
	
	public void setInputModel(EObject newInputModel){
		EObject oldInputModel = inputModel;
		inputModel = newInputModel;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.MIGRATION__INPUT_MODEL, oldInputModel, inputModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInputMetamodelURI() {
		return inputMetamodelURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputMetamodelURI(String newInputMetamodelURI) {
		String oldInputMetamodelURI = inputMetamodelURI;
		inputMetamodelURI = newInputMetamodelURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.MIGRATION__INPUT_METAMODEL_URI, oldInputMetamodelURI, inputMetamodelURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputModelURI() {
		return outputModelURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputModelURI(String newOutputModelURI) {
		String oldOutputModelURI = outputModelURI;
		outputModelURI = newOutputModelURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.MIGRATION__OUTPUT_MODEL_URI, oldOutputModelURI, outputModelURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutputMetamodelURI() {
		return outputMetamodelURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputMetamodelURI(String newOutputMetamodelURI) {
		String oldOutputMetamodelURI = outputMetamodelURI;
		outputMetamodelURI = newOutputMetamodelURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MigrationPackage.MIGRATION__OUTPUT_METAMODEL_URI, oldOutputMetamodelURI, outputMetamodelURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MigrationPackage.MIGRATION__INSTANCES:
				return ((InternalEList<?>)getInstances()).basicRemove(otherEnd, msgs);
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
			case MigrationPackage.MIGRATION__INSTANCES:
				return getInstances();
			case MigrationPackage.MIGRATION__INPUT_MODEL_URI:
				return getInputModelURI();
			case MigrationPackage.MIGRATION__INPUT_MODEL:
				return getInputModel();
			case MigrationPackage.MIGRATION__INPUT_METAMODEL_URI:
				return getInputMetamodelURI();
			case MigrationPackage.MIGRATION__OUTPUT_MODEL_URI:
				return getOutputModelURI();
			case MigrationPackage.MIGRATION__OUTPUT_METAMODEL_URI:
				return getOutputMetamodelURI();
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
			case MigrationPackage.MIGRATION__INSTANCES:
				getInstances().clear();
				getInstances().addAll((Collection<? extends Instance>)newValue);
				return;
			case MigrationPackage.MIGRATION__INPUT_MODEL_URI:
				setInputModelURI((String)newValue);
				return;
			case MigrationPackage.MIGRATION__INPUT_MODEL:
				setInputModel((EObject)newValue);
				return;
			case MigrationPackage.MIGRATION__INPUT_METAMODEL_URI:
				setInputMetamodelURI((String)newValue);
				return;
			case MigrationPackage.MIGRATION__OUTPUT_MODEL_URI:
				setOutputModelURI((String)newValue);
				return;
			case MigrationPackage.MIGRATION__OUTPUT_METAMODEL_URI:
				setOutputMetamodelURI((String)newValue);
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
			case MigrationPackage.MIGRATION__INSTANCES:
				getInstances().clear();
				return;
			case MigrationPackage.MIGRATION__INPUT_MODEL_URI:
				setInputModelURI(INPUT_MODEL_URI_EDEFAULT);
				return;
			case MigrationPackage.MIGRATION__INPUT_MODEL:
				setInputModel(INPUT_MODEL_EDEFAULT);
				return;
			case MigrationPackage.MIGRATION__INPUT_METAMODEL_URI:
				setInputMetamodelURI(INPUT_METAMODEL_URI_EDEFAULT);
				return;
			case MigrationPackage.MIGRATION__OUTPUT_MODEL_URI:
				setOutputModelURI(OUTPUT_MODEL_URI_EDEFAULT);
				return;
			case MigrationPackage.MIGRATION__OUTPUT_METAMODEL_URI:
				setOutputMetamodelURI(OUTPUT_METAMODEL_URI_EDEFAULT);
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
			case MigrationPackage.MIGRATION__INSTANCES:
				return instances != null && !instances.isEmpty();
			case MigrationPackage.MIGRATION__INPUT_MODEL_URI:
				return INPUT_MODEL_URI_EDEFAULT == null ? inputModelURI != null : !INPUT_MODEL_URI_EDEFAULT.equals(inputModelURI);
			case MigrationPackage.MIGRATION__INPUT_MODEL:
				return INPUT_MODEL_EDEFAULT == null ? inputModel != null : !INPUT_MODEL_EDEFAULT.equals(inputModel);
			case MigrationPackage.MIGRATION__INPUT_METAMODEL_URI:
				return INPUT_METAMODEL_URI_EDEFAULT == null ? inputMetamodelURI != null : !INPUT_METAMODEL_URI_EDEFAULT.equals(inputMetamodelURI);
			case MigrationPackage.MIGRATION__OUTPUT_MODEL_URI:
				return OUTPUT_MODEL_URI_EDEFAULT == null ? outputModelURI != null : !OUTPUT_MODEL_URI_EDEFAULT.equals(outputModelURI);
			case MigrationPackage.MIGRATION__OUTPUT_METAMODEL_URI:
				return OUTPUT_METAMODEL_URI_EDEFAULT == null ? outputMetamodelURI != null : !OUTPUT_METAMODEL_URI_EDEFAULT.equals(outputMetamodelURI);
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
		result.append(" (inputModelURI: ");
		result.append(inputModelURI);
		result.append(" (inputModel: ");
		result.append(inputModel);
		result.append(", inputMetamodelURI: ");
		result.append(inputMetamodelURI);
		result.append(", outputModelURI: ");
		result.append(outputModelURI);
		result.append(", outputMetamodelURI: ");
		result.append(outputMetamodelURI);
		result.append(')');
		return result.toString();
	}

} //MigrationImpl
