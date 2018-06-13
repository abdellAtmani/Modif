/**
 * 
 * Class for generation of files and folders for code migration
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Mickael Kerboeuf, Jean-Philippe Babau
 *  22/11/2013
 */

package codeGeneration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import ecoremodif.EclassModif;
import ecoremodif.RootEcoreModif;
import fileUtils.fileUtils;


public class CastingGenerator {

	/* *************************************************************** */
	/* ****   ATTRIBUTS                                           **** */
	/* *************************************************************** */

	/** object to generate migration code	 */
	private CastingCore migrationcore;

	/** root object of ecoreModif object */
	protected RootEcoreModif rootEcoreModif;

	protected EPackage metamodel;

	protected EObject model;

	/** folder for generated code	   */
	private String sourceFolder;

	/** name of generated base package */
	private String basePackageName;

	/* constant name of parameter name */
	protected String paramName ="val";	

	/** name of target package */
	private String namePackage;

	private String rootClassName;


	/**
	 * constructor from a RootEcoreModif and a folder for generated code
	 *
	 */
	public CastingGenerator(EPackage theMetamodel, EObject theModel, String sourceFolderGen) {

		this.model = theModel;
		this.rootClassName = model.eClass().getName();

		// object creation for code generation
		this.migrationcore = new CastingCore ( this.rootEcoreModif, this.rootClassName);

		// directory for source code generation
		this.sourceFolder = sourceFolderGen;	

		this.metamodel = theMetamodel;

		// Creation of package name
		namePackage = ((EClassifier)model.eClass()).getEPackage().getName();		
		this.basePackageName = this.namePackage.toLowerCase();

		// packages creation
		this.createJavaSourceFolders();

		// classes creation
		this.createClasses();

		// main creation
		//this.createMain();
	}


	/** Casting classes creation	 */
	private void createClasses() {

		// casting class
		fileUtils.createFile(this.sourceFolder+"/"+this.basePackageName+"Casting/"+this.namePackage+"Cast.java",
				createMigrationClassContent());
	}

	/** Main creation	 */
	private void createMain() {
		List<String> content = new ArrayList<String>();

		EclassModif ecm = rootEcoreModif.getAllClassModifications().get(0);

		content.add("package "+this.basePackageName+".implementation;\n");
		content.add("/**\n * Simple migration example\n */");
		content.add("public class Main {\n");
		content.add("   public static void main(String[] args) throws java.io.IOException {");
		content.add("		"+this.namePackage+"UI theUI = new "+this.namePackage+"UI();");
		content.add("		"+this.namePackage+"   migration  = new "+this.namePackage+"();\n");
		content.add("		// Loading *WARNING* we suppose the result is an instance of type "+ecm.getModif().getOldName());
		content.add("		// Root Migration");
		content.add("		"+ecm.getNewLongName()+" result = ("+ecm.getNewLongName()+") migration.migration"+ecm.getModif().getOldName()+"(model);\n");
		content.add("		// Add references");
		content.add("		migration.addReferences"+ecm.getModif().getOldName()+"(model);\n");
		content.add("		// Saving:");
		content.add("		io"+this.namePackage+".save(result,theUI.getOutputFileName());");
		content.add("	}\n\n}");

		fileUtils.createFile(this.sourceFolder+"/"+this.basePackageName+"/implementation/Main.java", content);
	}


	/** folders creation	 */
	private void createJavaSourceFolders() {
		// source :
		fileUtils.createFolder(this.sourceFolder);

		// base package :
		fileUtils.createFolder(this.sourceFolder+"/"+this.basePackageName+"Casting");

	}

	/**
	 * creation of migration classes
	 * @return class content
	 */
	private List<String> createMigrationClassContent() {
		List<String> content = new ArrayList<String>();
		content.add("package "+this.basePackageName+"Casting;\n");
		content.add("import org.eclipse.emf.ecore.EObject;");
		content.add("import org.eclipse.emf.ecore.EAttribute;\n");
		
		for( EClassifier eclass : metamodel.getEClassifiers()){
			content.add("import "+namePackage+"."+eclass.getName()+";");
		}
	
		content.add("import "+namePackage+".impl."+namePackage+"FactoryImpl;\n");

		content.add("public class "+this.namePackage+ "Cast {\n");

		content.add("   public "+ rootClassName + " castModel(EObject model) {");
		content.add("       "+namePackage+"FactoryImpl factory = new "+namePackage+"FactoryImpl();");

		for( EClassifier eclass : metamodel.getEClassifiers()){
			if(eclass.getName().equals(rootClassName)){
				content.addAll(this.migrationcore.generateMigrationCode(eclass, metamodel, true));
			}else{
				content.addAll(this.migrationcore.generateMigrationCode(eclass, metamodel, false));
			}
		}

		content.add("       return my"+rootClassName+";");
		content.add("   }");

		content.add("}");
		return content;
	}

	/**
	 * Creation of migration interface
	 * @return interface migration content
	 */
	private List<String> createMigrationInterfaceContent() {

		List<String> content = new ArrayList<String>();

		content.add("package "+this.basePackageName+".interfaces;\n");
		content.add("import org.eclipse.emf.ecore.*;\n");
		content.add("/**\n * Migration functions generated from concrete classes of "+this.rootEcoreModif.getRoot().getModif().getOldName()+"\n */");
		content.add("public interface "+this.namePackage+"Migration {");

		content.add("\n// ----------------- MIGRATION");

		for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {

			if (ecm.getEcore()!=null ) {
				content.add("\n   /**");		

				content.add("    * Migration of an instance of the metaclass "+ecm.getOldLongName());
				content.add("    * @param "+paramName+" : instance of "+ecm.getOldLongName());
				content.add("    * @return an instance of the corresponding metaclass of "+ecm.getNewLongName()+", or null if deleted or hidden");
				content.add("    */");
				content.add("   public EObject migration"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+");");

				content.add("\n   /**");
				content.add("    * Add the non containement references of the metaclass "+ecm.getOldLongName());
				content.add("    */");
				content.add("   public void addReferences"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+");");
			}

		}

		content.add("}");
		return content;
	}

}