package uiMigrationSpecificationEdition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;


import migration.Migration;

import org.eclipse.jface.viewers.*;



/**
 * 
 * This class handles migrated objects edition in order to produce custom migrated models. 
 * The table is composed of a list of migrated objects (instances in the migration specification).
 * 
 * This class uses the org.eclipse.jface.viewers.TableViewer class to implement an editable table with text and combobox editors. 
 * 
 */

public class TableViewerMigratedObject {

	public static Migration migrationSpecification;
	public static HashMap<String, ArrayList<String>> modelFeaturesMap;
	public static HashMap<String, String> modelClassesMap;
	public static HashMap<String, Boolean> deleteMap;
	public static HashMap<String, Boolean> newDeleteMap;

	private Table table;
	private TableViewer tableViewer;
	private Button closeButton;	

	// Create a MigratedObjectList and assign it to an instance variable
	private static MigratedObjectList migratedObjectList; 

	// Set the table column property names
	public final String ID_COLUMN		= "id";
	private final String ECLASS_COLUMN 	= "eclass";
	private final String OBJECT_COLUMN 	= "object";
	private final String DELETE_COLUMN 	= "delete";

	final int TEXT_MARGIN = 3;
	final int COLUMN_COUNT = 4;

	// Set column names
	private String[] columnNames = new String[] { ID_COLUMN, ECLASS_COLUMN, OBJECT_COLUMN, DELETE_COLUMN, };
	
	
	/**
	 * Constructor
	 */
	public TableViewerMigratedObject(){ }


	/**
	 * Constructor
	 * 
	 * @param parent composite to attach the table.
	 */
	private TableViewerMigratedObject(Composite parent) {
		this.addChildControls(parent);
	}


	/**
	 * Main method to launch the window.
	 */
	public static void init() {
		Shell shell = new Shell();
		shell.setText("Migrated Objects");

		// Set layout for shell
		GridLayout layout = new GridLayout();
		shell.setLayout(layout);

		// Create a composite to hold the children
		Composite composite = new Composite(shell, SWT.NONE);
		final TableViewerMigratedObject tableViewerExample = new TableViewerMigratedObject(composite);

		tableViewerExample.getControl().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				tableViewerExample.dispose();			
			}

		});

		// Display the content of the shell
		shell.pack();
		shell.open();
		tableViewerExample.run(shell);
	}

	
	/**
	 * Run and wait for a close event.
	 * 
	 * @param shell Instance of Shell.
	 */
	private void run(Shell shell) {

		// Add a listener for the close button
		closeButton.addSelectionListener(new SelectionAdapter() {

			// Close the view
			public void widgetSelected(SelectionEvent e) {
				table.getParent().getParent().dispose();
			}
		});

		Display display = shell.getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}


	/**
	 * Release resources.
	 */
	public void dispose() {
		// Tell the label provider to release its ressources
		tableViewer.getLabelProvider().dispose();
	}


	/**
	 * Create a new shell, add the widgets, then open the shell.
	 *  
	 */
	private void addChildControls(Composite composite) {

		// Create a composite to hold the children
		GridData gridData = new GridData (GridData.HORIZONTAL_ALIGN_FILL | GridData.FILL_BOTH);
		composite.setLayoutData (gridData);

		// Set numColumns to 3 for the buttons (Apply, Reset, Close)
		GridLayout layout = new GridLayout(3, false);
		layout.marginWidth = 4;
		composite.setLayout (layout);

		// Create the table 
		createTable(composite);

		// Create and setup the TableViewer
		createTableViewer();
		tableViewer.setContentProvider(new ExampleContentProvider());
		tableViewer.setLabelProvider(new MigratedObjectLabelProvider());
		// The input for the table viewer is the instance of ExampleMigratedObjectList
		migratedObjectList = new MigratedObjectList(migrationSpecification, modelFeaturesMap, modelClassesMap);
		tableViewer.setInput(migratedObjectList);

		// Add the buttons
		createButtons(composite);
	}


	/**
	 * Create the Table
	 * 
	 * @param parent composite containing the table.
	 */
	private void createTable(Composite parent) {
		int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

		table = new Table(parent, style);

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.grabExcessVerticalSpace = true;
		gridData.horizontalSpan = 3;
		table.setLayoutData(gridData);		

		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		// 1st column with Ids
		TableColumn column = new TableColumn(table, SWT.CENTER, 0);
		column.setText("#");
		column.setWidth(50);

		// 2nd column with migratedObject EClass 
		column = new TableColumn(table, SWT.CENTER, 1);
		column.setText("EClass");
		column.setWidth(80);
		//  Add listener to column so migratedObjects are sorted by eclass when clicked
		column.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				tableViewer.setSorter(new MigratedObjectSorter(MigratedObjectSorter.ECLASS));
			}
		});

		// 3rd column with migratedObject Object
		column = new TableColumn(table, SWT.LEFT, 2);
		column.setText("Object");
		column.setWidth(400);
		// Add listener to column so migratedObjects are sorted by object when clicked 
		column.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				tableViewer.setSorter(new MigratedObjectSorter(MigratedObjectSorter.OBJECT));
			}
		});

		// 4th column with migratedObject Delete
		column = new TableColumn(table, SWT.LEFT, 3);
		column.setText("Remove");
		column.setWidth(100);
		// Add listener to column so migratedObjects are sorted by delete when clicked
		column.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				tableViewer.setSorter(new MigratedObjectSorter(MigratedObjectSorter.DELETE));
			}
		});

		// Allows to specify the dimensions of a cell's content
		table.addListener(SWT.MeasureItem, new Listener(){
			public void handleEvent(Event event){
				TableItem item = (TableItem)event.item;
				String text = item.getText(event.index);
				Point size = event.gc.textExtent(text);
				event.width = size.x + 2 * TEXT_MARGIN;
				event.height = Math.max(event.height, size.y + TEXT_MARGIN);
			}
		});

		// Allows to custom draw a cell's background and/or selection
		table.addListener(SWT.EraseItem, new Listener(){
			public void handleEvent(Event event){
				event.detail &= ~SWT.FOREGROUND;
			}
		});

		// Allows to custom draw or augment a cell's foreground and/or focus rectangle
		table.addListener(SWT.PaintItem, new Listener() {
			public void handleEvent(Event event) {
				TableItem item = (TableItem)event.item;
				String text = item.getText(event.index);
				/* center column 1 vertically */
				int yOffset = 0;
				if (event.index == 1 || event.index == 2) {
					Point size = event.gc.textExtent(text);
					yOffset = Math.max(0, (event.height - size.y) / 2);
				}
				event.gc.drawText(text, event.x + TEXT_MARGIN, event.y + yOffset, true);
			}
		});

		/*for (int i = 0; i < COLUMN_COUNT; i++) {
			table.getColumn(i).pack();
		}*/
		table.pack();
	}

	/**
	 * Create the TableViewer 
	 */
	private void createTableViewer() {
		migratedObjectList = new MigratedObjectList(migrationSpecification, modelFeaturesMap, modelClassesMap);
		tableViewer = new TableViewer(table);
		tableViewer.setUseHashlookup(true);

		tableViewer.setColumnProperties(columnNames);

		// Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];

		// Column 4 : Delete (Combo Box) 
		editors[3] = new ComboBoxCellEditor(table, migratedObjectList.getDeletes(), SWT.READ_ONLY);

		// Assign the cell editors to the viewer 
		tableViewer.setCellEditors(editors);
		// Set the cell modifier for the viewer
		tableViewer.setCellModifier(new MigratedObjectCellModifier(this));
		// Set the default sorter for the viewer 
		tableViewer.setSorter(new MigratedObjectSorter(MigratedObjectSorter.OBJECT));
	}

	/*
	 * Close the window and dispose of resources.
	 */
	public void close() {
		Shell shell = table.getShell();

		if (shell != null && !shell.isDisposed())
			shell.dispose();
	}


	/**
	 * InnerClass that acts as a proxy for the MigratedObjectList providing content for the Table. 
	 * It implements the IMigratedObjectListViewer interface since it must register changeListeners with the 
	 * MigratedObjectList 
	 */
	class ExampleContentProvider implements IStructuredContentProvider, IMigratedObjectListViewer {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
			if (newInput != null)
				((MigratedObjectList) newInput).addChangeListener(this);
			if (oldInput != null)
				((MigratedObjectList) oldInput).removeChangeListener(this);
		}

		// Dispose
		public void dispose() {
			migratedObjectList.removeChangeListener(this);
		}

		// Return the migratedObjects as an array of Objects
		public Object[] getElements(Object parent) {
			return migratedObjectList.getMigratedObjects().toArray();
		}

		/* (non-Javadoc)
		 * @see IMigratedObjectListViewer#addMigratedObject(ExampleMigratedObject)
		 */
		public void addMigratedObject(MigratedObject migratedObject) {
			tableViewer.add(migratedObject);
		}

		/* (non-Javadoc)
		 * @see IMigratedObjectListViewer#removeMigratedObject(ExampleMigratedObject)
		 */
		public void removeMigratedObject(MigratedObject migratedObject) {
			tableViewer.remove(migratedObject);			
		}

		/* (non-Javadoc)
		 * @see IMigratedObjectListViewer#updateMigratedObject(ExampleMigratedObject)
		 */
		public void updateMigratedObject(MigratedObject migratedObject) {
			tableViewer.update(migratedObject, null);	
		}

		public void resetMigratedObjects(MigratedObject migratedObject) {
			String [] del = { "False"};
			tableViewer.update(migratedObject, del);
		}
	}

	/**
	 * Return the array of choices for a multiple choice cell.
	 * 
	 * @param property
	 */
	public String[] getChoices(String property) {
		if (DELETE_COLUMN.equals(property))
			return migratedObjectList.getDeletes();  // The ExampleMigratedObjectList knows about the choice of deletes
		else
			return new String[]{};
	}


	/**
	 * Add the "Apply", "Reset" and "Close" buttons.
	 * 
	 * @param parent the parent composite.
	 */
	private void createButtons(Composite parent) {

		// Create and configure the "Apply" button
		Button add = new Button(parent, SWT.PUSH | SWT.CENTER);
		add.setText("Apply");

		GridData gridData = new GridData (GridData.HORIZONTAL_ALIGN_BEGINNING);
		gridData.widthHint = 80;
		add.setLayoutData(gridData);
		add.addSelectionListener(new SelectionAdapter() {

			// Add a migratedObject to the ExampleMigratedObjectList and refresh the view
			public void widgetSelected(SelectionEvent e) {
				newDeleteMap = new HashMap<String, Boolean>();
				for(int i = 0; i< migratedObjectList.getMigratedObjects().size(); i++){
					MigratedObject m = (MigratedObject) migratedObjectList.getMigratedObjects().get(i);
					String delete = m.getDelete();
					if(delete.equals("True")){
						newDeleteMap.put(m.getUUID(), true);
					}else if(delete.equals("False")){
						newDeleteMap.put(m.getUUID(), false);
					}
				}
				// TODO : No close
				close();
			}
		});

		//	Create and configure the "Reset" button
		Button delete = new Button(parent, SWT.PUSH | SWT.CENTER);
		delete.setText("Reset");
		gridData = new GridData (GridData.HORIZONTAL_ALIGN_BEGINNING);
		gridData.widthHint = 80; 
		delete.setLayoutData(gridData); 

		delete.addSelectionListener(new SelectionAdapter() {
			//	Set Delete to False
			public void widgetSelected(SelectionEvent e) {
				migratedObjectList.resetMigratedObjects();				
			}

		});

		//	Create and configure the "Close" button
		closeButton = new Button(parent, SWT.PUSH | SWT.CENTER);
		closeButton.setText("Close");
		gridData = new GridData (GridData.HORIZONTAL_ALIGN_END);
		gridData.widthHint = 80; 
		closeButton.setLayoutData(gridData); 		
	}

	/**
	 * Return the column names in a collection.
	 * 
	 * @return List  containing column names.
	 */
	public java.util.List getColumnNames() {
		return Arrays.asList(columnNames);
	}


	/**
	 * Return the currently selected item.
	 * 
	 * @return currently selected item.
	 */
	public ISelection getSelection() {
		return tableViewer.getSelection();
	}


	/**
	 * Return the ExampleMigratedObjectList.
	 */
	public MigratedObjectList getMigratedObjectList() {
		return migratedObjectList;	
	}


	/**
	 * Return the parent composite
	 */
	public Control getControl() {
		return table.getParent();
	}


	/**
	 * Return the 'close' Button
	 */
	public Button getCloseButton() {
		return closeButton;
	}


	/**
	 * Return the collection of migrated objects.
	 * 
	 * @return mig Collection of migratedObjects.
	 */
	public static Vector getMigratedElements(){
		Vector mig = migratedObjectList.getMigratedObjects();
		return mig;
	}


	/**
	 * Set the migration specification.
	 * 
	 * @param migrationSpec Migration specification.
	 */
	public void setMigrationSpecification(Migration migrationSpec, HashMap<String, ArrayList<String>> featuresMap, HashMap<String, String> classesNamesMap){
		migrationSpecification = migrationSpec;
		modelFeaturesMap = featuresMap;
		modelClassesMap = classesNamesMap;
	}

	public HashMap<String, Boolean> getNewDeleteMap(){
		return newDeleteMap;
	}

}