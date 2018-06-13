package uiMigrationSpecificationEdition;

/**
 * A MigratedObject has the following properties: id, class, object and delete.
 * 
 */
public class MigratedObject {

	public int id = 0;
	public String UUID = "0";
	private String eclass = ""; 
	private String delete = "False";
	private String object = "";


	/**
	 * Create a migratedObject with an initial object.
	 * 
	 * @param string content of the object.
	 */
	public MigratedObject(String string) {
		super();
		setObject(string);
	}


	/**
	 * Get the identifier of the object.
	 * 
	 * @return id Identifier of the object.
	 */
	public int getId(){
		return id;
	}

	
	public String getUUID(){
		return UUID;
	}

	/**
	 * Get the object.
	 * 
	 * @return object Migrated object.
	 */
	public String getObject() {
		return object;
	}


	/**
	 * Get the delete value.
	 * 
	 * @return delete Delete value of the object.
	 */
	public String getDelete() {
		return delete;
	}


	/**
	 * Get the name of the object's class.
	 * 
	 * @return eclass Name of the object's class.
	 * 
	 */
	public String getEClass() {
		return eclass;
	}


	/**
	 * Set the 'id' property.
	 * 
	 * @param identifier Identifier.
	 */
	public void setId(int identifier){
		id = identifier;
	}
	
	
	public void setUUID(String identifier){
		UUID = identifier;
	}


	/**
	 * Set the 'object' property.
	 * 
	 * @param object Object.
	 */
	public void setObject(String string) {
		object = string;
	}


	/**
	 * Set the 'delete' property.
	 * 
	 * @param deleteVal Delete value.
	 */
	public void setDelete(String deleteVal) {
		delete = deleteVal;
	}


	/**
	 * Set the 'eclass' property.
	 * 
	 * @param name Class name.
	 */
	public void setEClass(String name) {
		eclass = name;
	}

}
