package utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Utilitary class for handling UUIDs.
 * This class gathers useful functions to add and remove UUIDs from metamodels and models.
 * 
 * @author P. Vallejo
 *
 */

public class UtilUUID {

	// ATTRIBUTES ******************************************************************************

	private static String UUIDtimeStamp;

	// PRIVATE **********************************************************************************

	/**
	 * Create the UUID attribute. 
	 * @return uuid UUID attribute.
	 */
	private static EAttribute createUUIDAttribute() {
		EAttribute uuid = EcoreFactory.eINSTANCE.createEAttribute();
		// Add a timestamp to avoid errors if UUID exists
		UUIDtimeStamp = new SimpleDateFormat("ddMMyyHHmm").format(new Date());
		uuid.setName("UUID"+UUIDtimeStamp);
		uuid.setEType(EcorePackage.eINSTANCE.getEString());
		uuid.setLowerBound(1);
		uuid.setUpperBound(1);
		uuid.setUnique(true);
		return uuid;
	}
	
	/**
	 * Create the UUID attribute. 
	 * @return uuid UUID attribute.
	 */
	private static EAttribute createUUIDAttribute(String timeStamp) {
		EAttribute uuid = EcoreFactory.eINSTANCE.createEAttribute();
		// Add a timestamp to avoid errors if UUID exists
		UUIDtimeStamp = timeStamp;
		uuid.setName("UUID"+UUIDtimeStamp);
		uuid.setEType(EcorePackage.eINSTANCE.getEString());
		uuid.setLowerBound(1);
		uuid.setUpperBound(1);
		uuid.setUnique(true);
		return uuid;
	}

	/**
	 * Create a class called UUIDClass.
	 * @return uuidClass A new abstract class containing the UUID attribute.
	 */
	private static EClass createUUIDClass() {
		EClass uuidClass = EcoreFactory.eINSTANCE.createEClass();
		uuidClass.setAbstract(true);
		// TODO verify that UUIDClass does not exist
		uuidClass.setName("UUIDClass");
		uuidClass.getEStructuralFeatures().add(createUUIDAttribute());
		return uuidClass;
	}
	
	private static EClass createUUIDClass(String timeStamp) {
		EClass uuidClass = EcoreFactory.eINSTANCE.createEClass();
		uuidClass.setAbstract(true);
		// TODO verify that UUIDClass does not exist
		uuidClass.setName("UUIDClass");
		uuidClass.getEStructuralFeatures().add(createUUIDAttribute(timeStamp));
		return uuidClass;
	}


	/**
	 * Get the classes to the top of the hierarchy.
	 * It means, the classes that do not inherits from other classes.
	 * @param metamodel Metamodel to be evaludated.
	 * @return topClassesList List containing the classes of the top of the hierarchy.
	 */
	private static ArrayList<EClass> getTopClasses(EPackage metamodel){
		ArrayList<EClass> topClassesList = new ArrayList<EClass>();
		// Visit each element of the metamodel
		for (TreeIterator<EObject> it = metamodel.eAllContents(); it.hasNext();) {
			EObject next = it.next();
			// Get only the classes
			if (next instanceof EClass) {
				EClass c = (EClass) next;
				// Scan of inherited classes
				EList<EClass> superClasses = c.getESuperTypes();
				// Add classes to the top classes list
				if(superClasses.size() == 0) {
					topClassesList.add(c);
				}else if(superClasses.size() == 1){
					if(superClasses.get(0).getName().equals("UUIDClass")){ topClassesList.add(c); }
				}
			}
		}
		return topClassesList;
	}

	/**
	 * Remove the UUID attribute of a class.
	 * @param UUIDClass Class from which the UUID attribute has to be removed.
	 */
	private static void removeAttribute(EClass UUIDClass) {
		EStructuralFeature uuid = null;
		EList<EAttribute> a = UUIDClass.getEAllAttributes();
		for(int i=0; i<a.size() && uuid==null; i++) {
			if (a.get(i).getName().contains("UUID")) uuid = a.get(i); 
		}
		EcoreUtil.remove(uuid);
	}

	/**
	 * Remove the UUID attribute of each instance of the model received in parameter.
	 * @param modelUUID Model containing UUID attributes.
	 * @return model without UUID attributes.
	 */
	private static EObject removeUUIDModelAttribute(EObject modelUUID) {
		// UUID feature of root object:
		EStructuralFeature uuid = null;
		EList<EAttribute> a = modelUUID.eClass().getEAllAttributes();
		for(int i=0; i<a.size() && uuid==null; i++) {
			if (a.get(i).getName().equals("UUID"+UUIDtimeStamp)) uuid = a.get(i); 
			else if(a.get(i).getName().equals(getTimeStampFromModel(modelUUID))) uuid = a.get(i); 
		}
		// Update of root object :
		if (uuid!=null) modelUUID.eUnset(uuid);
		// Update of children object :
		for(EObject modelRootChild : modelUUID.eContents()) {
			removeUUIDModelAttribute(modelRootChild);
		}
		return modelUUID;
	}

	/**
	 * Set the value of the timestamp.
	 * @param timeStamp Timestamp associated to the UUID attribute.
	 */
	private static void setTimeStamp(String timeStamp) {
		UUIDtimeStamp = timeStamp;
	}
	
	/**
	 * Set UUID values.
	 * It sets the UUID attribute of each instance with a ramdom value.
	 * @param model Root object of the model to be modified.
	 * @return model Model with UUID values.
	 */
	private static EObject setUUIDValues(EObject model) {
		// UUID feature of root object:
		EStructuralFeature uuid = null;
		EList<EAttribute> a = model.eClass().getEAllAttributes();
		for(int i=0; i<a.size() && uuid==null; i++) {
			if (a.get(i).getName().equals("UUID"+UUIDtimeStamp)) {
				uuid = a.get(i);
				// If the current timestamp is not the timestamp of the model
			}else if(a.get(i).getName().equals(getTimeStampFromModel(model))) {
				uuid = a.get(i);
			}
		}
		// Update of root object :
		if (uuid!=null){ 
			for(EAttribute attribute : model.eClass().getEAllAttributes()){
				if(attribute.getName().equals("UUID"+UUIDtimeStamp)){
					model.eSet(uuid, model.eClass().getName()+":"+EcoreUtil.generateUUID());
					break;
					// If the current timestamp is not the timestamp of the model
				}else if(attribute.getName().equals(getTimeStampFromModel(model))){
					model.eSet(uuid, model.eClass().getName()+":"+EcoreUtil.generateUUID());
					break;
				}
			}
		}
		// Update of children object :
		for(EObject modelRootChild : model.eContents()) {
			setUUIDValues(modelRootChild);
		}
		return model;
	}


	// PUBLIC ***********************************************************************************

	/**
	 * Add the UUID attribute.
	 * It adds, to the top of the hierarchy, an abstract class containing the UUID attribute.
	 * All classes of the metamodel inherits directly or indirectly from the new class. 
	 * @param metamodel Package of the metamodel to be extended with UUID attributes.
	 * @return metamodelWithUUID Updated metamodel.
	 */
	public static EPackage addUUIDMetamodelAttribute(EPackage metamodel) {
		EPackage metamodelWithUUID = EcoreUtil.copy(metamodel);
		
		// All operations and annotations are removed from the metamodel
		metamodelWithUUID = UtilEMF.removeOperations(UtilEMF.removeOppositeFeature(UtilEMF.removeAnnotations(metamodelWithUUID)));
		
		ArrayList<EClass> topClasses = getTopClasses(metamodelWithUUID);		
		// Create UUIDClass
		EClass UUIDClass = createUUIDClass();
		// Add the UUIDClass to the metamodel
		metamodelWithUUID.getEClassifiers().add(UUIDClass);
		for (TreeIterator<EObject> it = metamodelWithUUID.eAllContents(); it.hasNext();) {
			EObject next = it.next();
			// Get only the classes
			if (next instanceof EClass) {
				EClass c = (EClass) next;
				if(topClasses.contains(c)){
					c.getESuperTypes().add(UUIDClass); 
				}
			}
		}
		return metamodelWithUUID;
	}
	
	public static EPackage addUUIDMetamodelAttribute(EPackage metamodel, String timeStamp) {
		EPackage metamodelWithUUID = EcoreUtil.copy(metamodel);
		
		// All operations and annotations are removed from the metamodel
		metamodelWithUUID = UtilEMF.removeOperations(UtilEMF.removeOppositeFeature(UtilEMF.removeAnnotations(metamodelWithUUID)));
		
		ArrayList<EClass> topClasses = getTopClasses(metamodelWithUUID);
		System.out.println("topClasses  "+topClasses);
		
		// Create UUIDClass
		EClass UUIDClass = createUUIDClass(timeStamp);
		// Add the UUIDClass to the metamodel
		metamodelWithUUID.getEClassifiers().add(UUIDClass);
		for (TreeIterator<EObject> it = metamodelWithUUID.eAllContents(); it.hasNext();) {
			EObject next = it.next();
			// Get only the classes
			if (next instanceof EClass) {
				EClass c = (EClass) next;
				if(topClasses.contains(c)) c.getESuperTypes().add(UUIDClass); 
			}
		}
		return metamodelWithUUID;
	}

	/**
	 * Add the UUID attribute to each instance of the model.
	 * @param model Model to wich the UUID attribut will be added.
	 * @param metamodelUUID Metamodel with UUID.
	 * @return modelUUID Model with the UUID attribute associate to each of its instances.
	 */
	public static EObject addUUIDModelAttribute(EObject model, EPackage metamodelUUID) {
		// TODO Verify UUID in metamodel
		EObject modelUUIDAttribute = UtilEMF.changeMetamodel(model, metamodelUUID);
		EObject modelUUID = setUUIDValues(modelUUIDAttribute);
		return modelUUID;
	}
	
	/**
	 * Get the timestamp associated to the UUID attribute.
	 * @return UUIDtimeStamp Timestamp of the UUID attribute.
	 */
	public static String getTimeStampFromModel(EObject model) {
		String timeStamp = null;
		for(EAttribute attribute : model.eClass().getEAllAttributes()){
			if(attribute.getName().contains("UUID")){
				timeStamp = attribute.getName();
				break;
			}
		}
		setTimeStamp(timeStamp);
		return timeStamp;
	}
	
	/**
	 * Get the timestamp associated to the UUID attribute.
	 * @return UUIDtimeStamp Timestamp of the UUID attribute.
	 */
	public static String getTimeStamp() {
		System.out.println("UUIDtimeStamp "+UUIDtimeStamp);
		return UUIDtimeStamp;
	}

	/**
	 * Remove the UUID attribute.
	 * It removes, from the top of the hierarchy, the abstract class containing the UUID attribute.
	 * All inheritance links beetween the deleted class and other classes are also removed. 
	 * @param metamodelWithUUID Package of the metamodel with UUID attibutes.
	 * @return metamodelWithUUID Updated metamodel without UUID attribute.
	 */
	public static EPackage removeUUIDMetamodelAttribute(EPackage metamodelWithUUID) {
		// TODO There is not UUIDClass in metamodel
	//	EPackage metamodel = EcoreUtil.copy(metamodelWithUUID);
		EClass UUIDClass = null;
		for(TreeIterator<EObject> it = metamodelWithUUID.eAllContents(); it.hasNext();){
			EObject next = it.next();
			// Get only the classes
			if (next instanceof EClass) {
				EClass c = (EClass) next;
				if(c.getName().equals("UUIDClass")) {
					UUIDClass = c;
					removeAttribute(UUIDClass);
				}
			}
		}

		if(UUIDClass != null) EcoreUtil.delete(UUIDClass); 
		return metamodelWithUUID;
	}

	/**
	 * Remove the UUID attribute of each instance of a model.
	 * @param modelUUID Model with UUIDs.
	 * @param metamodel Metamodel without UUIDs, to be the model without UUIDs has to be conform.
	 * @return modelWithoutUUID Model without UUIDs, conforms to the metamodel.
	 */
	public static EObject removeUUIDModelAttribute(EObject modelUUID, EPackage metamodel) {
		EObject model = removeUUIDModelAttribute(modelUUID);
		EObject modelWithoutUUID = UtilEMF.changeMetamodel(model, metamodel);
		return modelWithoutUUID;
	}

}
