/**
 */
package migration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Migration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link migration.Migration#getInstances <em>Instances</em>}</li>
 *   <li>{@link migration.Migration#getInputModelURI <em>Input Model URI</em>}</li>
 *   <li>{@link migration.Migration#getInputMetamodelURI <em>Input Metamodel URI</em>}</li>
 *   <li>{@link migration.Migration#getOutputModelURI <em>Output Model URI</em>}</li>
 *   <li>{@link migration.Migration#getOutputMetamodelURI <em>Output Metamodel URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see migration.MigrationPackage#getMigration()
 * @model
 * @generated
 */
public interface Migration extends EObject {
	/**
	 * Returns the value of the '<em><b>Instances</b></em>' containment reference list.
	 * The list contents are of type {@link migration.Instance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instances</em>' containment reference list.
	 * @see migration.MigrationPackage#getMigration_Instances()
	 * @model containment="true"
	 * @generated
	 */
	EList<Instance> getInstances();

	/**
	 * Returns the value of the '<em><b>Input Model URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Model URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Model URI</em>' attribute.
	 * @see #setInputModelURI(String)
	 * @see migration.MigrationPackage#getMigration_InputModelURI()
	 * @model required="true"
	 * @generated
	 */
	String getInputModelURI();
	
	EObject getInputModel();

	/**
	 * Sets the value of the '{@link migration.Migration#getInputModelURI <em>Input Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Model URI</em>' attribute.
	 * @see #getInputModelURI()
	 * @generated
	 */
	void setInputModelURI(String value);
	
	void setInputModel(EObject model);

	/**
	 * Returns the value of the '<em><b>Input Metamodel URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Metamodel URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Metamodel URI</em>' attribute.
	 * @see #setInputMetamodelURI(String)
	 * @see migration.MigrationPackage#getMigration_InputMetamodelURI()
	 * @model required="true"
	 * @generated
	 */
	String getInputMetamodelURI();

	/**
	 * Sets the value of the '{@link migration.Migration#getInputMetamodelURI <em>Input Metamodel URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Metamodel URI</em>' attribute.
	 * @see #getInputMetamodelURI()
	 * @generated
	 */
	void setInputMetamodelURI(String value);

	/**
	 * Returns the value of the '<em><b>Output Model URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Model URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Model URI</em>' attribute.
	 * @see #setOutputModelURI(String)
	 * @see migration.MigrationPackage#getMigration_OutputModelURI()
	 * @model required="true"
	 * @generated
	 */
	String getOutputModelURI();

	/**
	 * Sets the value of the '{@link migration.Migration#getOutputModelURI <em>Output Model URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Model URI</em>' attribute.
	 * @see #getOutputModelURI()
	 * @generated
	 */
	void setOutputModelURI(String value);

	/**
	 * Returns the value of the '<em><b>Output Metamodel URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Metamodel URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Metamodel URI</em>' attribute.
	 * @see #setOutputMetamodelURI(String)
	 * @see migration.MigrationPackage#getMigration_OutputMetamodelURI()
	 * @model required="true"
	 * @generated
	 */
	String getOutputMetamodelURI();

	/**
	 * Sets the value of the '{@link migration.Migration#getOutputMetamodelURI <em>Output Metamodel URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Metamodel URI</em>' attribute.
	 * @see #getOutputMetamodelURI()
	 * @generated
	 */
	void setOutputMetamodelURI(String value);

} // Migration
