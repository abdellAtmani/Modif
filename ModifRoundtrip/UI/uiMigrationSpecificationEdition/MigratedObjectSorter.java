package uiMigrationSpecificationEdition;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;


/**
 * Sorter for the TableViewerMigratedObject.
 * It displays the items sorted by : Id, EClass, Object or Delete.
 * 
 */
public class MigratedObjectSorter extends ViewerSorter {

	/**
	 * Constructor 
	 */
	public final static int ID 		= 1;
	public final static int ECLASS	= 2;
	public final static int OBJECT	= 3;
	public final static int DELETE 	= 4;

	// Criteria that the instance uses 
	private int criteria;

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 *
	 * @param criteria the sort criterion to use.
	 */
	public MigratedObjectSorter(int criteria) {
		super();
		this.criteria = criteria;
	}


	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {

		MigratedObject migratedObject1 = (MigratedObject) o1;
		MigratedObject migratedObject2 = (MigratedObject) o2;

		switch (criteria) {
		case ID :
			return compareEClass(migratedObject1, migratedObject2);
		case ECLASS :
			return compareEClass(migratedObject1, migratedObject2);
		case OBJECT :
			return compareObjects(migratedObject1, migratedObject2);
		case DELETE :
			return compareDeletes(migratedObject1, migratedObject2);
		default:
			return 0;
		}
	}

	/**
	 * Return a number reflecting the order of the given migratedObjects based on the eclass name.
	 *
	 * @param migratedObject1
	 * @param migratedObject2
	 * @return a negative number if the first element is less  than the second element. 
	 * The value 0 if the first element is equal to the second one.
	 * A positive number if the first element is greater than the second element.
	 */
	private int compareEClass(MigratedObject migratedObject1, MigratedObject migratedObject2) {
		/*int result = migratedObject1.getEClass() - migratedObject2.getEClass();
		result = result < 0 ? -1 : (result > 0) ? 1 : 0;  
		return result;*/
		return collator.compare(migratedObject1.getEClass(), migratedObject2.getEClass());
	}

	/**
	 * Return a number reflecting the order of the given migratedObjects based on the migrated object.
	 *
	 * @param migratedObject1
	 * @param migratedObject2
	 * @return a negative number if the first element is less  than the second element. 
	 * The value 0 if the first element is equal to the second one.
	 * A positive number if the first element is greater than the second element.
	 */
	protected int compareObjects(MigratedObject migratedObject1, MigratedObject migratedObject2) {
		return collator.compare(migratedObject1.getObject(), migratedObject2.getObject());
	}


	/**
	 * Return a number reflecting the order of the given migratedObjects based on the delete property value.
	 *
	 * @param migratedObject1
	 * @param migratedObject2
	 * @return a negative number if the first element is less  than the second element. 
	 * The value 0 if the first element is equal to the second one.
	 * A positive number if the first element is greater than the second element.
	 */
	protected int compareDeletes(MigratedObject migratedObject1, MigratedObject migratedObject2) {
		return collator.compare(migratedObject1.getDelete(), migratedObject2.getDelete());
	}


	/**
	 * Return the sort criteria of this this sorter.
	 *
	 * @return criteria The sort criterion.
	 */
	public int getCriteria() {
		return criteria;
	}
}
