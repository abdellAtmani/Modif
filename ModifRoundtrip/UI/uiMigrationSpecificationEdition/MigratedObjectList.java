package uiMigrationSpecificationEdition;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import migration.Instance;
import migration.Migration;


/**
 * This class that plays the role of the domain model in the TableViewerExample
 * In real life, this class would access a persistent store of some kind.
 * 
 */

public class MigratedObjectList {

	private int COUNT = 0;
	private Vector migratedObjects = new Vector(COUNT);
	private Set changeListeners = new HashSet();

	// Combo box choices
	static final String[] DELETES_ARRAY = { "False", "True" };

	Migration migrationSpecification;
	HashMap<String, ArrayList<String>> modelFeaturesMap;
	HashMap<String, String> modelClassesMap;
	HashMap<String, Integer> deleteMap = new HashMap<String, Integer>();

	/**
	 * Constructor 
	 * 
	 * @param migrationSPec Migration specification.
	 */
	public MigratedObjectList(){
		super();		
		this.initData();
	}

	/**
	 * Constructor 
	 * 
	 * @param migrationSPec Migration specification.
	 */
	public MigratedObjectList(Migration migrationSpec, HashMap<String, ArrayList<String>> featuresMap, HashMap<String, String> classesMap){
		super();	
		migrationSpecification = migrationSpec;
		modelFeaturesMap = featuresMap;
		modelClassesMap = classesMap;
		this.initData();
	}


	/**
	 * Initialize the table data. 
	 * It creates the migratedObjects and add them to the list of migrated objects.
	 */
	private void initData() {
		MigratedObject migratedObject;
		HashMap<String, Integer> idMap = buildIdMap();
		Collection<Integer> ids = idMap.values();
		ArrayList<Integer> objects = new ArrayList<Integer>();
		Iterator<Integer> it = ids.iterator();
		while(it.hasNext())
		{
			int i = it.next();
			objects.add(i);
		}

		COUNT = objects.size();
		for (int i = 0; i < COUNT; i++) {
			int id = objects.get(i);
			// MigratedObject with its features (attributes and references)
			ArrayList<String> features = getFeatures(id, idMap);
			String featuresString = "";
			for(String f : features){ featuresString += "\n"+f; }
			migratedObject = new MigratedObject(featuresString);
			migratedObject.setId(id);
			
			Iterator it2 = idMap.entrySet().iterator();
			while (it2.hasNext()) {
				Map.Entry e = (Map.Entry)it2.next();
				String key = (String) e.getKey();
				Integer value =(Integer) e.getValue();
				if(value == id){ 
					migratedObject.setUUID(key);
				}
			}
			
			migratedObject.setEClass(getclass(id, idMap));
			migratedObject.setDelete(DELETES_ARRAY[0]);
			migratedObjects.add(migratedObject);
		}
	};


	/**
	 * Return the class property of an object.

	 * @param id Identifier of the object.
	 * @return eclass Name of the class.
	 */
	public String getclass(int id, HashMap<String, Integer> idMap){
		String eclass = "";
		Iterator it = idMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			String key = (String) e.getKey();
			Integer value =(Integer) e.getValue();
			if(value == id){ 
				for(Instance i : migrationSpecification.getInstances()){
					if(i.getUUID().equals(key)){
						eclass = modelClassesMap.get(key);
					}
				}
			}
		}
		return eclass;
	}


	/**
	 * Return the array of deletes   
	 * 
	 * @return DELETES_ARRAY;
	 */
	public String[] getDeletes() {
		return DELETES_ARRAY;
	}


	/**
	 * Return the collection of migratedObjects
	 * @return migratedObjects Collection of migratedObjects
	 */
	public Vector getMigratedObjects() {
		return migratedObjects;
	}


	/**
	 * Set the delete property to False.
	 */
	public void resetMigratedObjects(){
		for( Object migratedObject : migratedObjects){
			((MigratedObject) migratedObject).setDelete("False");
			Iterator iterator = changeListeners.iterator();
			while (iterator.hasNext()){ ((IMigratedObjectListViewer) iterator.next()).resetMigratedObjects((MigratedObject) migratedObject); }
		}

	}


	/**
	 * Update an objects.
	 * 
	 * @param migratedObject Object to be updated.
	 */
	public void migratedObjectChanged(MigratedObject migratedObject) {
		Iterator iterator = changeListeners.iterator();
		while (iterator.hasNext()){ ((IMigratedObjectListViewer) iterator.next()).updateMigratedObject(migratedObject); }
	}


	public void removeChangeListener(IMigratedObjectListViewer viewer) {
		changeListeners.remove(viewer);
	}


	public void addChangeListener(IMigratedObjectListViewer viewer) {
		changeListeners.add(viewer);
	}


	/**
	 * Return the features of an object.
	 * 
	 * @param id Identifier of the object.
	 * @return features List of object features.
	 */
	public ArrayList<String> getFeatures(int id, HashMap<String, Integer> idMap){
		ArrayList<String> features = new ArrayList<String>();		
		Iterator it = modelFeaturesMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			String key = (String) e.getKey();
			ArrayList<String> value = (ArrayList<String>) e.getValue();
			int identifier = idMap.get(key);
			if(identifier == id){
				features.addAll(value);
			}
		}

		return features;
	}


	private HashMap<String, Integer> buildIdMap(){
		HashMap<String, Integer> idMap = new HashMap<String, Integer>();
		int id = 0;
		String UUID;
		for(Instance instance : this.migrationSpecification.getInstances()){
			UUID = instance.getUUID();
			if(!instance.getDeletion().isDeleteInstance()){
				id = id + 1;
				idMap.put(UUID, id);
			}
		}
		return idMap;
	}
	
	
	public HashMap<String, Integer> getDeleteMap(){
		return deleteMap;
	}

}
