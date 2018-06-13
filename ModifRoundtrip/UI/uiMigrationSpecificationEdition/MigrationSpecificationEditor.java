/**
 * comment
 *  
 * Copyright (C) 2014 IDL 
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Paola Vallejo
 *  @date 17 juin 2014
 */
package uiMigrationSpecificationEdition;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import org.eclipse.emf.ecore.EObject;

import utils.UtilEMF;
import migration.Migration;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class MigrationSpecificationEditor {

	private JFrame frmMigrationEditor;
	private static String migrationSpecificationName;
	private Migration migration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MigrationSpecificationEditor window = new MigrationSpecificationEditor(migrationSpecificationName);
					window.frmMigrationEditor.setVisible(true);
				} 
				catch (Exception e) { e.printStackTrace(); }
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MigrationSpecificationEditor(String migrationSpecification) {
		migrationSpecificationName = migrationSpecification;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final DefaultListModel<String> modelPreDeleted = new DefaultListModel<String>();
		final JList<String> listDeleteModif = new JList<String>(modelPreDeleted);
		//listDeleteModif.setBackground(Color.LIGHT_GRAY);
		//listDeleteModif.setSelectionModel(new DisabledItemSelectionModel());
		listDeleteModif.setEnabled(false);

		final DefaultListModel<String> model = new DefaultListModel<String>();
		final JList<String> listDelete = new JList<String>(model);
		listDelete.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		final DefaultListModel<String> model2 = new DefaultListModel<String>();
		final JList<String> listKeep = new JList<String>(model2);
		listKeep.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//migration = (Migration) UtilEMF.loadModel(migrationSpecificationName, MigrationPackage.eINSTANCE);

		// Reading migration specification
		/*for(EObject instance : migration.eContents()){
			String instanceuuid = (String) instance.eGet(instance.eClass().getEStructuralFeature("UUID"));
			for(EObject deletion : instance.eContents()){
				boolean deleteinstance = (boolean) deletion.eGet(deletion.eClass().getEStructuralFeature("deleteInstance"));
				if(deleteinstance){
					// The instance is deleted because the class has been deleted
					modelPreDeleted.addElement(instanceuuid);
				}else{
					model2.addElement(instanceuuid);
					for(EObject feature : deletion.eContents()){
						String deleteFeature = (String)feature.eGet(feature.eClass().getEStructuralFeature("name"));
						if(feature.eClass().getName().equals("Attribute")){
							String attribute = "  Attribute "+instanceuuid+"."+deleteFeature;
							modelPreDeleted.addElement(attribute);
						}else if(feature.eClass().getName().equals("Reference")){
							String reference = "  Reference "+instanceuuid+"."+deleteFeature;
							modelPreDeleted.addElement(reference);
						}
					}
				}
			}

		}*/

		/** TEST **/

		model2.addElement("Brest");
		model.addElement("        UBO");
		model.addElement("               20");
		model.addElement("               Victor Le Gorgeu");
		model.addElement("        Residence Universitaire Kergoat");
		model.addElement("               4");
		model.addElement("               des Archives");
		model2.addElement("        Residence Universitaire Lanredec");
		model2.addElement("               15");
		model2.addElement("               Lanredec");
		model2.addElement("         CHRU");
		model2.addElement("               51");
		model2.addElement("               Professeur Langevin");
		model.addElement("        Residence University Recouvrance");
		model.addElement("               3");
		model.addElement("               Petite Vauban");
		modelPreDeleted.addElement("     29200");
		modelPreDeleted.addElement("     France");
		modelPreDeleted.addElement("Anne");
		modelPreDeleted.addElement("Robert");
		modelPreDeleted.addElement("Bellevue");
		modelPreDeleted.addElement("Recouvrance");

		frmMigrationEditor = new JFrame();
		frmMigrationEditor.setTitle("Migration Editor");
		frmMigrationEditor.setBounds(100, 100, 450, 300);
		frmMigrationEditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		frmMigrationEditor.getContentPane().setLayout(gridBagLayout);

		JLabel lblDelete = new JLabel("Delete");
		GridBagConstraints gbc_lblDelete = new GridBagConstraints();
		gbc_lblDelete.insets = new Insets(0, 0, 5, 5);
		gbc_lblDelete.gridx = 0;
		gbc_lblDelete.gridy = 0;
		frmMigrationEditor.getContentPane().add(lblDelete, gbc_lblDelete);

		JLabel lblKeep = new JLabel("Keep");
		GridBagConstraints gbc_lblKeep = new GridBagConstraints();
		gbc_lblKeep.insets = new Insets(0, 0, 5, 0);
		gbc_lblKeep.gridx = 2;
		gbc_lblKeep.gridy = 0;
		frmMigrationEditor.getContentPane().add(lblKeep, gbc_lblKeep);

		JScrollPane scrollPane_0 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_0 = new GridBagConstraints();
		gbc_scrollPane_0.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_0.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_0.gridx = 0;
		gbc_scrollPane_0.gridy = 1;
		frmMigrationEditor.getContentPane().add(scrollPane_0, gbc_scrollPane_0);

		scrollPane_0.setViewportView(listDeleteModif);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		frmMigrationEditor.getContentPane().add(scrollPane, gbc_scrollPane);

		scrollPane.setViewportView(listDelete);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		frmMigrationEditor.getContentPane().add(scrollPane_1, gbc_scrollPane_1);

		scrollPane_1.setViewportView(listKeep);

		// From the list of instances to delete To the list of instances to keep
		JButton btnAdd = new JButton("To keep");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(model.size() == 0){
					JOptionPane.showMessageDialog(null, "There are not elements to keep");
				}else{
					if(listDelete.getSelectedIndex() == -1){
						JOptionPane.showMessageDialog(null, "Select an element");
					}else if(listDeleteModif.getSelectedIndex() != -1){
						JOptionPane.showMessageDialog(null, "Select a valid element");
					}else{
						int index = listDelete.getSelectedIndex();
						String label = (String) model.getElementAt(index);
						model.removeElementAt(index);
						model2.addElement(label);

						try { modifyInstance(label, false); } 
						catch (IOException e2) { e2.printStackTrace(); }

						try { UtilEMF.saveModel((EObject)migration,migrationSpecificationName.replace(".migration", "Customized.migration")); } 
						catch (IOException e1) { e1.printStackTrace(); }
					}
				}
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 3;
		frmMigrationEditor.getContentPane().add(btnAdd, gbc_btnAdd);

		// From the list of instances to keep To the list of instances to delete
		JButton btnDelete = new JButton("To delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(model2.size() == 0){
					JOptionPane.showMessageDialog(null, "There are not elements to delete");
				}else if(listKeep.getSelectedIndex() == -1){
					JOptionPane.showMessageDialog(null, "Select an element");
				}else{
					int index = listKeep.getSelectedIndex();
					String label = (String) model2.getElementAt(index);
					model2.removeElementAt(index);
					model.addElement(label);

					try { modifyInstance(label, true); } 
					catch (IOException e2) { e2.printStackTrace(); }

					try { UtilEMF.saveModel((EObject)migration,migrationSpecificationName.replace(".migration", "Customized.migration")); } 
					catch (IOException e1) { e1.printStackTrace(); }
				}
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 10);
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 3;
		frmMigrationEditor.getContentPane().add(btnDelete, gbc_btnDelete);

		JButton btnValidate = new JButton("Validate");
		GridBagConstraints gbc_btnValidate = new GridBagConstraints();
		gbc_btnValidate.gridx = 2;
		gbc_btnValidate.gridy = 4;
		frmMigrationEditor.getContentPane().add(btnValidate, gbc_btnValidate);

	}

	/**
	 * 
	 * @param instanceUUID instance whose value of deletion has to be modified
	 * @param value value of deletion
	 * @throws IOException
	 */
	public void  modifyInstance(String instanceUUID, boolean value) throws IOException{
		for(EObject instance : migration.eContents()){
			String instanceuuid = (String) instance.eGet(instance.eClass().getEStructuralFeature("UUID"));
			if(instanceuuid.equals(instanceUUID)){
				for(EObject deletion : instance.eContents()){ deletion.eSet(deletion.eClass().getEStructuralFeature("deleteInstance"), value); }
			}
		}
	}

}
