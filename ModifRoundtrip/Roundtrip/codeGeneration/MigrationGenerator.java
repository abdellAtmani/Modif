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

import fileUtils.fileUtils;


public class MigrationGenerator {

	/* *************************************************************** */
	/* ****   ATTRIBUTS                                           **** */
	/* *************************************************************** */

	protected String rootClass;

	protected String function;

	/** folder for generated code	   */
	private String sourceFolder;

	/** name of generated base package */
	private String basePackageName;

	/* constant name of parameter name */
	protected String paramName ="val";	

	protected String inputModel;

	protected String processedModel;

	protected String graphModel;

	protected String toolMetamodel;


	/**
	 * constructor from a RootEcoreModif and a folder for generated code
	 *
	 */
	public MigrationGenerator(String sourceFolderGen, String rootC, String func, String iModel, String tool) {
		// directory for source code generation
		this.sourceFolder = sourceFolderGen;

		// Creation of package and interface names
		this.basePackageName = "reuse";

		this.rootClass = rootC;

		this.function = func;

		this.inputModel = iModel;

		this.toolMetamodel = tool;
		System.out.println("tMM5  : " + toolMetamodel);

		// packages creation
		this.createJavaSourceFolders();

		// interfaces and classes creation
		this.createClasses();
	}


	/**
	 * folders creation.
	 */
	private void createJavaSourceFolders() {
		// source :
		fileUtils.createFolder(this.sourceFolder.replace("metamodel", "srcgen\\"));
		// base package :
		fileUtils.createFolder(this.sourceFolder.replace("metamodel", "srcgen\\")+this.basePackageName);
	}


	/**
	 * Interfaces migration classes creation.
	 */
	private void createClasses() {
		// migration class
		fileUtils.createFile(this.sourceFolder.replace("metamodel", "srcgen\\")+this.basePackageName+"\\Reuse_"+function+".java",
				createMigrationClassContent());
	}


	/**
	 * creation of migration classes.
	 * 
	 * @return content class content.
	 */
	private List<String> createMigrationClassContent() {
		List<String> content = new ArrayList<String>();
		content.add("package "+this.basePackageName+";\n");

		String[] split = rootClass.split("\\\\");
		int size = split.length;

		String rootClassName = split[size-1].replace(".java","");
		File fRoot = new File(rootClass);

		content.add("import java.io.File;");
		content.add("import java.io.FileInputStream;");
		content.add("import java.io.FileNotFoundException;");
		content.add("import java.io.FileOutputStream;");
		content.add("import java.io.IOException;");
		content.add("import java.lang.reflect.InvocationTargetException;");
		content.add("import java.lang.reflect.Method;");
		content.add("import java.nio.channels.FileChannel;");

		content.add("public class Reuse_"+function+" {\n");
		content.add("     public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {");
		String binClass = this.rootClass.replace("src", "bin").replace("java", "class").replace("\\", "/");

		content.add("        File file = new File(\""+binClass+"\");");
		content.add("     	 try {");
		content.add("           FileInputStream streamTemp1 = new FileInputStream(file);");
		content.add("           FileChannel channel1 = streamTemp1.getChannel();");

		content.add("           File dir = new File(\""+(this.sourceFolder.replace("metamodel", "")+"/bin/"+fRoot.getParentFile().getName()).replace("\\", "/")+"\");");
		content.add("           dir.mkdir();");

		String binCopy = (this.sourceFolder+fRoot.getParentFile().getName()+"/"+fRoot.getName()).replace("metamodel","bin/").replace("\\", "/").replace("java", "class");	

		content.add("           File tempFile2 = new File(\""+binCopy+"\");");

		content.add("           FileOutputStream outputStream = new FileOutputStream(tempFile2);");
		content.add("           FileChannel channel2 = outputStream.getChannel();");
		content.add("           try {");
		content.add("              channel1.transferTo(0, file.length(), channel2);");
		content.add("           } catch (IOException e) {");
		content.add("              e.printStackTrace();");
		content.add("           }\n");

		content.add("        } catch (FileNotFoundException e) {");
		content.add("           e.printStackTrace();");
		content.add("        }\n");
		content.add("        Class classToLoad = Class.forName(\""+fRoot.getParentFile().getName()+"."+fRoot.getName().replace(".java", "") +"\");");
		content.add("        Method[] methods = classToLoad.getMethods();");
		content.add("        for(Method m : methods){");
		content.add("           if(m.getName().equals(\""+function+"\")){");

		String p1 = fRoot.getParentFile().getParentFile().getParentFile().getAbsolutePath().replace("\\", "/");
		String toolMetamodel = p1+"/metamodel";
		String p2 = null;
		File metamodelFolder = new File(toolMetamodel);
		String p3 = this.inputModel.replace("\\","/");
		String p4 = this.inputModel.replace("migrated", this.function).replace("\\","/");
		this.processedModel = p4;

		File toolMetamodelFile = new File(this.toolMetamodel);
		p2 = toolMetamodelFile.getName();
		String metamodelName = this.toolMetamodel.replace("ecore", "");		

		File modelf = new File(this.inputModel);
		String modelFolder = modelf.getParent().replace("\\","/");
		String graphFolder = modelFolder.replace("model", "graph");		
		String p5 = p4.replace(modelFolder, graphFolder).replace((toolMetamodelFile.getName().toLowerCase().replace("ecore", "")),"dependency.").replace("\\","/");

		this.graphModel = p5;

		content.add("              String[] argsMeth = {\""+p1+"\","+"\""+toolMetamodel+"/"+p2+"\","+"\""+p3+"\","+"\""+p4+"\","+"\""+p5+"\"};");
		content.add("              m.invoke(null, argsMeth);");
		content.add("           }\n");
		content.add("        }\n");
		content.add("     }\n");
		content.add("}");

		return content;
	}


	/**
	 * Get the name of the processed model.
	 * 
	 * @return processedModel Name of the processed model.
	 */
	public String getProcessedModelName(){
		return this.processedModel;
	}


	/**
	 * Get the name of the dependencies graph.
	 * 
	 * @return graphModel Name of the dependencies graph.
	 */
	public String getGraphModelName(){
		return this.graphModel;

	}

}