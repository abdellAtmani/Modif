package uiMigrationSpecificationEdition;

import org.eclipse.jface.viewers.ICellModifier;


/**
 * This class is able to modify a cell in the tableViewer.
 * It implements an ICellModifier.
 * 
 */

public class MigratedObjectCellModifier implements ICellModifier {
	private TableViewerMigratedObject tableViewerMigratedObject;


	/**
	 * Constructor 
	 * @param tableViewer Instance of a TableViewerMigratedObject.
	 */
	public MigratedObjectCellModifier(TableViewerMigratedObject tableViewer) {
		super();
		this.tableViewerMigratedObject = tableViewer;
	}


	/**
	 * Checks whether the given property of the given element can be modified.
	 * 
	 * @param element
	 * @param property
	 * @return True if the property can be modified. False if it is not modifiable.
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#canModify(java.lang.Object, java.lang.String)
	 */
	public boolean canModify(Object element, String property) {
		return true;
	}


	/**
	 * Returns the value for the given property of the given element. 
	 * Returns null if the element does not have the given property.
	 * 
	 * @param element
	 * @param property
	 * @return The property value.
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#getValue(java.lang.Object, java.lang.String)
	 */
	public Object getValue(Object element, String property) {

		// Find the index of the column
		int columnIndex = tableViewerMigratedObject.getColumnNames().indexOf(property);

		Object result = null;
		MigratedObject migratedObject = (MigratedObject) element;

		switch (columnIndex) {
		case 0 : // ID_COLUMN
			result = migratedObject.getId()+ "";
			break;
		case 1 : // ECLASS_COLUMN 
			result = migratedObject.getEClass() + "";
			break;
		case 2 : // OBJECT_COLUMN 
			result = migratedObject.getObject();
			break;
		case 3 : // DELETE_COLUMN 
			String stringValue = migratedObject.getDelete();
			String[] choices = tableViewerMigratedObject.getChoices(property);
			int i = choices.length - 1;
			while (!stringValue.equals(choices[i]) && i > 0){ --i; }
			result = new Integer(i);					
			break;
		default :
			result = "";
		}
		return result;	
	}


	/**
	 * 
	 * Modifies the value for the given property of the given element. 
	 * Has no effect if the element does not have the given property, or if the property cannot be modified.
	 * 
	 * @param element
	 * @param property
	 * @param value
	 * 
	 * @see org.eclipse.jface.viewers.ICellModifier#modify(java.lang.Object, java.lang.String, java.lang.Object)
	 */
	public void modify(Object element, String property, Object value) {	

		// Find the index of the column 
		int columnIndex	= tableViewerMigratedObject.getColumnNames().indexOf(property);

		TableItem item = (TableItem) element;
		MigratedObject migratedObject = (MigratedObject) item.getData();
		String valueString;

		switch (columnIndex) {
		case 0 : // ID_COLUMN
			valueString = ((String) value).trim();
			if (valueString.length() == 0) { valueString = "0"; }
			migratedObject.setId(Integer.parseInt(valueString));
			break;
		case 1 : // ECLASS_COLUMN
			valueString = ((String) value).trim();
			if (valueString.length() == 0) { valueString = "0"; }
			migratedObject.setEClass(valueString);
			break;
		case 2 : // TOTO_COLUMN 
			valueString = ((String) value).trim();
			migratedObject.setObject(valueString);
			break;
		case 3 : // DELETE_COLUMN 
			valueString = tableViewerMigratedObject.getChoices(property)[((Integer) value).intValue()].trim();
			if (!migratedObject.getDelete().equals(valueString)) { migratedObject.setDelete(valueString); }
			break;

		default :
		}
		tableViewerMigratedObject.getMigratedObjectList().migratedObjectChanged(migratedObject);
	}
}
