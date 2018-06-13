package uiMigrationSpecificationEdition;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;


/**
 * A label provider implementation which, by default, uses an element's toString value for its text and null for its image.
 * 
 * @see org.eclipse.jface.viewers.LabelProvider 
 */
public class MigratedObjectLabelProvider extends LabelProvider implements ITableLabelProvider {

	/**
	 * Return the text of the column.
	 * 
	 * @param element
	 * @param columnIndex
	 * @return Text of the column.
	 * 
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		String result = "";
		MigratedObject migratedObject = (MigratedObject) element;
		switch (columnIndex) {
		case 0 : // ID_COLUMN
			result = migratedObject.getId() + "";
			break;
		case 1 : // ECLASS_COLUMN
			result = migratedObject.getEClass() + "";
			break;
		case 2 : //OBJECT_COLUMN
			result = migratedObject.getObject();
			break;
		case 3 :
			result = migratedObject.getDelete();
			break;
		default :
			break; 	
		}
		return result;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void addListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return false;
	}


	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void removeListener(ILabelProviderListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
