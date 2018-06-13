package uiMigrationSpecificationEdition;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.eclipse.emf.ecore.EObject;

import migration.Migration;

/**
 * 
 * Frame for editing migration specifications.
 *
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Paola Vallejo
 *  
 */
public class CustomMigrationSpecification extends JFrame {
	static Migration migration;
	static Migration customMigration;
	static Migration customMigrationSpecification = null;

	ArrayList<String> mandatoryDeletion = new ArrayList<String>();
	ArrayList<String> customDeletion = new ArrayList<String>();
	boolean isValidMigration;
	static JScrollPane sp;
	static JPanel panel;
	static CustomMigrationSpecification frame = new CustomMigrationSpecification();

	/**
	 * Constructor
	 */
	public CustomMigrationSpecification() {
		super("Migration Specification Edition");
	}


	/**
	 * Create list of items.
	 * An item is an instance of the migration specification.
	 * @param strs list of string to be added to the checkable list.
	 * @return items List of instances of the migration specification.
	 */
	private static CheckableItem[] createData(ArrayList<String> strs) {
		int n = strs.size();
		CheckableItem[] items = new CheckableItem[n];   
		CustomMigrationSpecification custom = new CustomMigrationSpecification();
		for(int i = 0; i< n; i++){ items[i] = custom.new CheckableItem(strs.get(i)); }
		return items;
	}


	/**
	 * Reset list of instances of the migration specification.
	 * @param n Number of items.
	 * @param items List of items.
	 * @return List of items in which no elements are selected.
	 */
	private static CheckableItem[] resetData(int n, CheckableItem[] items) {
		for (int i = 0; i < n; i++) { items[i].setSelected(false); }
		return items;
	}


	/**
	 * Get the panel.
	 * @return panel.
	 */
	private JPanel getPanel(){
		return panel;
	}

	/**
	 * Get the scroll pane object.
	 * @return sp scroll pane.
	 */
	private JScrollPane getScrollPane(){
		return sp;
	}


	/**
	 * Modify an instance of the migration specification.
	 * @param instanceUUID instance whose value of deletion has to be modified.
	 * @param deleted If true, the instance is set to be deleted. If False, the instance is set to be kept. 
	 * @throws IOException
	 */
	private static void  modifyInstance(String instanceUUID, boolean deleted) throws IOException {
		for(EObject instance : migration.eContents()){
			String instanceuuid = (String) instance.eGet(instance.eClass().getEStructuralFeature("UUID"));
			if(instanceuuid.equals(instanceUUID)){
				for(EObject deletion : instance.eContents()){ deletion.eSet(deletion.eClass().getEStructuralFeature("deleteInstance"), deleted); }
			}
		}
	}


	/**
	 * Indicates if a migration is valid to be applied to a specific model.
	 * @return isValidMigration True if the migration is valid. False, otherwise.
	 */
	private boolean isAValidMigration(){
		return isValidMigration;
	}


	/**
	 * Inner class to handle checkable items.
	 * CheckableItem items
	 *
	 */
	class CheckableItem {
		private String str;
		private boolean isSelected;


		/**
		 * Checkable items.
		 * @param str item of the list.
		 */
		public CheckableItem(String str) {
			this.str = str;
			isSelected = false;
		}


		/**
		 * Set the value of the selected attribute of an item.
		 * @param selected If true, the item is selected. If false, the item is not selected.
		 */
		public void setSelected(boolean selected) { 
			isSelected = selected;
		}


		/**
		 * Verify if an item is selected.
		 * @return isSelected. True if the item is selected. False if the item is not selected.
		 */
		public boolean isSelected() {
			return isSelected;
		}


		/**
		 * Transform an item into a String.
		 * @return str String coresponding to an item.
		 */
		public String toString() {
			return str;
		}
	}


	/**
	 * Inner class to handle lists of checkable items.
	 *
	 */
	class CheckListRenderer extends JCheckBox implements ListCellRenderer {

		/**
		 * Constructor
		 */
		public CheckListRenderer() {
			setBackground(UIManager.getColor("List.textBackground"));
			setForeground(UIManager.getColor("List.textForeground"));
		}


		/**
		 * Get the list of checkable items.
		 * @return Component A collection of checkable items.
		 */
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {
			setEnabled(list.isEnabled());
			setSelected(((CheckableItem) value).isSelected());
			setFont(list.getFont());
			setText(value.toString());
			return this;
		}
	}


	/**
	 * Initialize the migration specification editor.
	 * @param migrationSpecification Migration specification to be edited.
	 */
	public static Migration init(Migration migrationSpecification) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception evt) {}

		final ArrayList<String> strs = new ArrayList<String>();

		migration = migrationSpecification;

		for(EObject instance : migration.eContents()){
			String instanceuuid = (String) instance.eGet(instance.eClass().getEStructuralFeature("UUID"));
			for(EObject deletion : instance.eContents()){
				boolean deleteinstance = (boolean) deletion.eGet(deletion.eClass().getEStructuralFeature("deleteInstance"));
				if(!deleteinstance){ strs.add(instanceuuid); }
			}
		}

		final CheckableItem[] data = createData(strs);
		final JList list = new JList(data);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(new EmptyBorder(0, 4, 0, 0));
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index = list.locationToIndex(e.getPoint());
				CheckableItem item = (CheckableItem) list.getModel().getElementAt(index);
				item.setSelected(!item.isSelected());
				Rectangle rect = list.getCellBounds(index, index);
				list.repaint(rect);
			}
		});
		sp = new JScrollPane(list);

		JButton validateButton = new JButton("Validate");
		validateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListModel model = list.getModel();
				int n = model.getSize();
				for (int i = 0; i < n; i++) {
					CheckableItem item = (CheckableItem) model.getElementAt(i);
					// modify the migration specification
					try { modifyInstance(strs.get(i), item.isSelected); } 
					catch (IOException e1) { e1.printStackTrace(); }
					customMigrationSpecification = migration;
					//TODO  validate the result by applying the new migration specification
				}
			}
		});

		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetData(strs.size(), data);
				Rectangle rect = list.getCellBounds(0, strs.size()-1);
				list.repaint(rect);
			}
		});

		panel = new JPanel(new GridLayout(2, 1));
		panel.add(validateButton);
		panel.add(resetButton);

		frame.add(sp, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.EAST);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setSize(300, 200);
		frame.setVisible(true);

		return customMigrationSpecification;
	}

	/**
	 * Get the custom migration specification
	 * @return customMigration custom migration specification.
	 */
	public Migration getCustomMigration(){
		return customMigration;
	}

}