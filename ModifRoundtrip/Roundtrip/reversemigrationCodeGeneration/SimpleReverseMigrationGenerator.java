/**
 * comment
 *  
 * Copyright (C) 2014 IDL 
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Jean-Philippe Babau
 *  @date 8 janv. 2014
 */
package reversemigrationCodeGeneration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

import fileUtils.fileUtils;

/**
 * @author user1
 *
 */
public class SimpleReverseMigrationGenerator {
	protected String inputModel;
	protected EPackage initialrootEcore;
	
	/** folder for generated code	   */
	private String sourceFolder;
	
	SimpleReverseMigrationGenerator(String inputMF, EPackage initialrootEF, String sourceFolderGen){
			this.inputModel = inputMF;
			this.initialrootEcore = initialrootEF;	
			this.sourceFolder = sourceFolderGen;
			
			// packages creation
			this.createJavaSourceFolders();
			
			//this.createMain();
	}
	
	
	/** folders creation	 */
	private void createJavaSourceFolders() {
		// source :
		fileUtils.createFolder(this.sourceFolder);
		
		// base package :
			fileUtils.createFolder(this.sourceFolder+"/simpleContext");		
	}
	
	
	
	/** Main creation	 */
	private void createMain(boolean graph) {
		List<String> content = new ArrayList<String>();
		
		content.add("package simpleContext;\n");
		
		//content.add("import "+initialrootEcore.getName()+"to"+rootEcore.getName()+".implementation.*;\n");
		
		content.add("import java.util.ArrayList;");
		content.add("import java.util.List;\n");
			
		content.add("/**\n * Simple migration example\n */");
		content.add("public class Main {\n");
		content.add("   public static void main(String[] args) throws java.io.IOException {");

	//	content.add("		"+this.nameSourcePackage+"IO io"+this.nameSourcePackage+" = new "+this.nameSourcePackage+"IO();");
	//	content.add("		"+this.nameInitialPackage+"IO io"+this.nameInitialPackage+" = new "+this.nameInitialPackage+"IO();\n");
	//	content.add("		"+initialrootEcore.getName()+".Root model = io"+this.nameInitialPackage+".loadRoot"+"(\""+initialModel+"\");");
	//	content.add("		"+rootEcore.getName()+".Root model2 = io"+this.nameSourcePackage+".loadRoot"+"(\""+refactoredModel+"\");\n");
	//	content.add("		"+rootEcore.getName()+".Root model3 = io"+this.nameSourcePackage+".loadRoot"+"(\""+inputModel+"\");\n");
		content.add("		Scan"+initialrootEcore.getName()+" scan = new Scan"+initialrootEcore.getName()+"();");
	//	content.add("		Scan"+rootEcore.getName()+" scan2 = new Scan"+rootEcore.getName()+"();");
		content.add("       List<Integer> list = new ArrayList<Integer>();");
		content.add("       List<Integer> list2 = new ArrayList<Integer>();");
		content.add("		list = scan.listRoot(model);");
		content.add("		list2 = scan2.listRoot(model2);");
		content.add("		List<Integer> result = new ArrayList<Integer>();\n");
		
		content.add("		for(int i = 0; i< list2.size(); i++){");
		content.add("			result = list;");
		content.add("			result.remove(list2.get(i));");
		content.add("		}");
		
		content.add("	Contextualization contextualization = new Contextualization(model3, list, model);");
		
		content.add("	}\n");

		content.add("}\n");
		
		if(graph){
			fileUtils.createFile(this.sourceFolder+"/graphContext/Main.java", content);
		}else{
			fileUtils.createFile(this.sourceFolder+"/keysContext/Main.java", content);
		}
	}
	

}
