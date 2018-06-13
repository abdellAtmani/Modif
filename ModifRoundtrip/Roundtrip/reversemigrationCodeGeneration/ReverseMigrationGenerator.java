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

package reversemigrationCodeGeneration;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

import fileUtils.fileUtils;


public class ReverseMigrationGenerator {

	/* *************************************************************** */
	/* ****   ATTRIBUTS                                           **** */
	/* *************************************************************** */

	/** object to generate migration code	 */
	private ReverseMigrationCore reversemigrationcore;

	/** root object of ecoreModif objetc */
	protected EPackage rootEcore;
	protected String inputModel;
	protected String initialModel;
	protected String refactoredModel;
	protected EPackage outputrootEcore;
	protected EPackage initialrootEcore;
	
	/** folder for generated code	   */
	private String sourceFolder;

	/** name of generated base package */
	private String basePackageName;

	/** name of source package */
	private String nameSourcePackage;

	/** name of target package */
	private String nameTargetPackage;
	
	/** name of initial package */
	private String nameInitialPackage;
	
	/** name of generated interface name	 */
	private String interfaceName;
	
	/* constant name of parameter name */
	protected String paramName ="val";	
	
	/** folders creation	 */
	private void createJavaSourceFolders(boolean graph) {
		// source :
		fileUtils.createFolder(this.sourceFolder);
		
		// base package :
		if(graph){
			fileUtils.createFolder(this.sourceFolder+"/graphContext");	
		}else{
			fileUtils.createFolder(this.sourceFolder+"/keysContext");	
		}
	}
	
	/** Interfaces migration classes creation	 */
	private void createInterfacesAndClasses(boolean graph) {
		
		// IO classes 
		/*fileUtils.createFile(this.sourceFolder+"/testreverse/"+this.nameSourcePackage+"IO.java",
				createIOClassContent());
		fileUtils.createFile(this.sourceFolder+"/testreverse/"+this.nameTargetPackage+"IO.java",
				createIOClassContent());*/
		
		// migration class
		if(graph){
			fileUtils.createFile(this.sourceFolder+"/graphContext/Contextualization.java", 
					createReverseMigrationClassContent(graph));
		}else{
			fileUtils.createFile(this.sourceFolder+"/keysContext/Contextualization.java", 
					createReverseMigrationClassContent(graph));
		}
	}
	
	/** Main creation	 */
	private void createMain(boolean graph) {
		List<String> content = new ArrayList<String>();
		
		EClassifier ec = rootEcore.getEClassifiers().get(0);
		if(graph){
			content.add("package graphContext;\n");
		}else{
			content.add("package keysContext;\n");
		}
		
		content.add("import "+initialrootEcore.getName()+"to"+rootEcore.getName()+".implementation.*;\n");
		
		content.add("import java.util.ArrayList;");
		content.add("import java.util.List;\n");
		
		content.add("import scan.Scan"+initialrootEcore.getName()+";");
		content.add("import scan.Scan"+rootEcore.getName()+";\n");
		
		content.add("/**\n * Simple migration example\n */");
		content.add("public class Main {\n");
		content.add("   public static void main(String[] args) throws java.io.IOException {");

		content.add("		"+this.nameSourcePackage+"IO io"+this.nameSourcePackage+" = new "+this.nameSourcePackage+"IO();");
		content.add("		"+this.nameInitialPackage+"IO io"+this.nameInitialPackage+" = new "+this.nameInitialPackage+"IO();\n");
		content.add("		"+initialrootEcore.getName()+".Root model = io"+this.nameInitialPackage+".loadRoot"+"(\""+initialModel+"\");");
		content.add("		"+rootEcore.getName()+".Root model2 = io"+this.nameSourcePackage+".loadRoot"+"(\""+refactoredModel+"\");\n");
		content.add("		"+rootEcore.getName()+".Root model3 = io"+this.nameSourcePackage+".loadRoot"+"(\""+inputModel+"\");\n");
		content.add("		Scan"+initialrootEcore.getName()+" scan = new Scan"+initialrootEcore.getName()+"();");
		content.add("		Scan"+rootEcore.getName()+" scan2 = new Scan"+rootEcore.getName()+"();");
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
	
	/** Contextualization creation content	 */
	private List<String> createReverseMigrationClassContent(boolean graph) {
		List<String> content = new ArrayList<String>();
		if(graph){
			content.add("package graphContext;\n");
		}else{
			content.add("package keysContext;\n");
		}
		
		content.add("import java.io.IOException;");
		content.add("import java.util.HashMap;");
		content.add("import java.util.List;");
		content.add("import java.util.Map;\n");
		
		content.add("import org.eclipse.emf.common.util.EList;");
		content.add("import org.eclipse.emf.ecore.EObject;\n");
		
		content.add("import hfsma_keystohfsmwa_keys.implementation.*;\n");

		content.add("public class Contextualization{\n");
		content.add("   hfsma_keys.Root initial;");
		content.add("   hfsma_keys.Root result;");
		content.add("   List<Integer> deleted;\n");
		content.add("   public Map<EObject, EObject> sourceToTarget = new HashMap<EObject, EObject>();\n");
		
		content.add("      public Contextualization(hfsmwa_keys.Root inputModel, List<Integer> deleted, hfsma_keys.Root initial){\n");
		content.add("         Hfsma_keysIO ioHfsma_keys = new Hfsma_keysIO();");
		
	    content.add("	      this.initial = initial;");
	    content.add("         this.deleted = deleted;");
	    content.add("         result = (hfsma_keys.Root) contextRoot(inputModel);");
	    content.add("         addReferencesRoot(inputModel);\n");
		     
		content.add("         try {");
		content.add("            ioHfsma_keys.save(result, \"C:/Amodif2/AAtest/model/kM4.hfsma_keys\");");
		content.add("         } catch (IOException e) {");
		content.add("             System.out.println(\"error\");");
		content.add("			  e.printStackTrace();");
		content.add("         }");
		content.add("    }\n");
		
		content.add("//----------------------- CONTEXT ");
		for(EClassifier ec : rootEcore.getEClassifiers()){
			//content.add("   @Override");
			content.add("   public final EObject context"+ec.getName()+"("+nameSourcePackage.toLowerCase()+"."+ec.getName()+" "+paramName+") {");
			
			content.addAll(this.reversemigrationcore.generateMigrationCode((EClass) ec));
			//content.addAll(this.reversemigrationcore.generateMigration)
		
			content.add("		return result;");
			content.add("   }\n");
			
			content.add("   public final void addReferences"+ec.getName()+"("+nameSourcePackage.toLowerCase()+"."+ec.getName()+" "+paramName+") {");
			content.addAll(this.reversemigrationcore.generateAddReferencesCode((EClass) ec));
			content.add("   }\n");
		}
		
		//content.addAll(generateToolContains());
		//content.addAll(generateGetPostId());
		
		
		/*content.add("  public static EList<Integer> getDeletedElements(keymodif.Reuse graph){");
		content.add("	   EList<Integer> beforeMigration = null;");
		content.add("	   for(int i = 0 ; i<graph.getMigrations().size(); i++){");
		content.add("		   beforeMigration = graph.getMigrations().get(i).getInitial();");
		content.add("	   }\n");*/
			   
		/*content.add("	   EList<Integer> afterMigration = null;");
		content.add("	   for(int i = 0 ; i<graph.getMigrations().size(); i++){");
		content.add("		   afterMigration = graph.getMigrations().get(i).getMigrated();");
		content.add("		   System.out.println(graph.getMigrations().get(i).getMigrated());");
		content.add("	   }\n");*/
			   
		/*content.add("	   EList<Integer> deleted = beforeMigration;");
		content.add("	   for(int i = 0 ; i<afterMigration.size(); i++){");
		content.add("		  if(deleted.contains(afterMigration.get(i))){");
		content.add("			  deleted.remove(afterMigration.get(i));");
		content.add("		  }");
		content.add("	   }");
			   
		content.add("	   return deleted;");
		content.add("   }\n");*/
		

		//content.addAll(this.reversemigrationcore.generateGetRelated());
		
		content.add("	}\n\n}");
		/*if(graph){
			fileUtils.createFile(this.sourceFolder+"/graphContext/Contextualization.java", content);
		}else{
			fileUtils.createFile(this.sourceFolder+"/keysContext/Contextualization.java", content);
		}*/
		return content;
	}
	
	
	/**
	 * constructor from a RootEcoreModif and a folder for generated code
	 *
	 */
	public ReverseMigrationGenerator(EPackage rootEF, String inputMF, String initialMF, String refactoredMF, EPackage outputrootEF, EPackage initialrootEF, String sourceFolderGen, boolean graph) {
		
		// object rootEcoreModif creation 
		this.rootEcore = rootEF;
		this.inputModel = inputMF;
		this.initialModel = initialMF;
		this.refactoredModel = refactoredMF;
		this.outputrootEcore = outputrootEF;
		this.initialrootEcore = initialrootEF;
		
		// object creation for code generation
		this.reversemigrationcore = new ReverseMigrationCore( this.rootEcore, this.outputrootEcore, this.initialrootEcore);

		// directory for source code generation
		this.sourceFolder = sourceFolderGen;		
		
		// Creation of package and interface names
		nameSourcePackage = Character.toUpperCase(this.rootEcore.getName().charAt(0))+this.rootEcore.getName().substring(1);
		nameTargetPackage = Character.toUpperCase(this.outputrootEcore.getName().charAt(0))+this.outputrootEcore.getName().substring(1);		
		nameInitialPackage = Character.toUpperCase(this.initialrootEcore.getName().charAt(0))+this.initialrootEcore.getName().substring(1);
		this.interfaceName = nameSourcePackage + "To"+ nameTargetPackage;
	//	this.basePackageName = this.interfaceName.toLowerCase();
		
		// packages creation
		this.createJavaSourceFolders(graph);
		
		//this.createContextualization(graph);
		this.createInterfacesAndClasses(graph);
		
		// main creation
		this.createMain(graph);
	}

			

	

	
	/*protected List<String> generateToolContains() {
		List<String> content = new ArrayList<String>();	
	  
		content.add("public final boolean toolContains(int id){");
		content.add("   boolean contains = false;");
		content.add("   for(int i=0; i<graph.getTools().size(); i++){");
		content.add("	   if(graph.getTools().get(i).getId() == id){");
		content.add("		   contains = true;");
		content.add("		   break;");
		content.add("	   }else{");
		content.add("		   contains = false;");
		content.add("	   }");
		content.add("   }");
		content.add("   return contains;");
		content.add("}");
		return content;
	}*/
	
	/*protected List<String> generateGetPostId() {
		List<String> content = new ArrayList<String>();	
	
	   content.add("public final EList<Integer> getPostId(int id){");
	   content.add("	EList<Integer> postId = null;");
		   
		content.add("	for(int i=0; i<graph.getTools().size(); i++){");
		content.add("		if(graph.getTools().get(i).getId() == id){");
		content.add("			postId = graph.getTools().get(i).getIdpos();");
		content.add("		}");
		content.add("	}");
		content.add("   return postId;");
	   	content.add("}");
	   return content;
	}*/
	
	

	
	/**
	 * Creation of migration interface
	 * @return interface migration content
	 */
	private List<String> createMigrationInterfaceContent(boolean keys, boolean fromKeys) {
		
		List<String> content = new ArrayList<String>();
		
		content.add("package "+this.basePackageName+".interfaces;\n");
		content.add("import org.eclipse.emf.ecore.*;\n");
	//	content.add("/**\n * Migration functions generated from concrete classes of "+this.rootEcoreModif.getRoot().getModif().getOldName()+"\n */");
		content.add("public interface "+this.interfaceName+"Migration {");
		
		content.add("\n// ----------------- MIGRATION");
		
		//for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {
			if(keys){
				content.add("\n   /**");		
				
		//		content.add("    * Migration of an instance of the metaclass "+ecm.getOldLongName());
			//	content.add("    * @param "+paramName+" : instance of "+ecm.getOldLongName());
			//	content.add("    * @return an instance of the corresponding metaclass of "+ecm.getNewLongName()+", or null if deleted or hidden");
				content.add("    */");
			//	content.add("   public EObject migration"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+");");

				content.add("\n   /**");
			//	content.add("    * Add the non containement references of the metaclass "+ecm.getOldLongName());
		//		content.add("    */");
		//		content.add("   public void addReferences"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+");");
			}
			//else if (ecm.getEcore()!=null ) {
				content.add("\n   /**");		
			
			//	content.add("    * Migration of an instance of the metaclass "+ecm.getOldLongName());
			//	content.add("    * @param "+paramName+" : instance of "+ecm.getOldLongName());
			//	content.add("    * @return an instance of the corresponding metaclass of "+ecm.getNewLongName()+", or null if deleted or hidden");
				content.add("    */");
			//	content.add("   public EObject migration"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+");");

				content.add("\n   /**");
			//	content.add("    * Add the non containement references of the metaclass "+ecm.getOldLongName());
				content.add("    */");
		//		content.add("   public void addReferences"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+");");
			//}
		
		//}
		
	//	content.add("\n// ----------------- REVERSED MIGRATION");
		
		//for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {
			if(keys){
				content.add("\n   /**");
			//	content.add("    * Reversed migration of an instance of the metaclass "+ecm.getNewLongName());
			//	content.add("    * @param "+paramName+" : instance of "+ecm.getNewLongName());
			//	content.add("    * @return an instance of the corresponding metaclass of "+ecm.getOldLongName());
				content.add("    */");
		//		content.add("   public EObject reversedMigration"+ecm.getModif().getNewName()+"("+ecm.getNewLongName()+" "+paramName+");");	
			}
			//else if (ecm.getEcore()!=null && !ecm.isMerged()) {
				content.add("\n   /**");
			//	content.add("    * Reversed migration of an instance of the metaclass "+ecm.getNewLongName());
			//	content.add("    * @param "+paramName+" : instance of "+ecm.getNewLongName());
			//	content.add("    * @return an instance of the corresponding metaclass of "+ecm.getOldLongName());
			//	content.add("    */");
			//	content.add("   public EObject reversedMigration"+ecm.getModif().getNewName()+"("+ecm.getNewLongName()+" "+paramName+");");	
		//	}
		//}

		//content.add("}");
		return content;
	}
	
	/**
	 * Creation of usercode interface
	 * @return interface content
	 */
	private List<String> createUsercodeInterfaceContent(boolean keys, boolean fromKeys) {
		List<String> content = new ArrayList<String>();
		content.add("package "+this.basePackageName+".interfaces;\n");
		content.add("import org.eclipse.emf.ecore.*;\n");
		content.add("/**\n * Customizable pre and post processing functions associated to each migration function\n */");
		content.add("public interface "+this.interfaceName+"UserCode {");

		content.add("\n// ----------------- MIGRATION");
		
	//	for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {
			if(keys){
				content.add("\n   /**");
		//		content.add("    * Preprocessing of migration"+ecm.getModif().getOldName());
			//	content.add("    * @param "+paramName+" : instance of "+ecm.getOldLongName()+" to be preprocessed");
				content.add("    * @return preprocessed input parameter");
				content.add("    */");
		//		content.add("   public "+ecm.getOldLongName()+" preMigration"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+");");
				content.add("\n   /**");
		//		content.add("    * Postprocessing of migration"+ecm.getModif().getOldName());
		//		content.add("    * @param "+paramName+" : result of migration"+ecm.getModif().getOldName()+" to be postprocessed");
				content.add("    * @return postprocessed input parameter");
				content.add("    */");
		//		content.add("   public EObject postMigration"+ecm.getModif().getOldName()+"(EObject "+paramName+");");
			}
		//	else if (ecm.getEcore()!=null ) {
				content.add("\n   /**");
			//	content.add("    * Preprocessing of migration"+ecm.getModif().getOldName());
		//		content.add("    * @param "+paramName+" : instance of "+ecm.getOldLongName()+" to be preprocessed");
				content.add("    * @return preprocessed input parameter");
				content.add("    */");
		//		content.add("   public "+ecm.getOldLongName()+" preMigration"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+");");
				content.add("\n   /**");
			//	content.add("    * Postprocessing of migration"+ecm.getModif().getOldName());
			//	content.add("    * @param "+paramName+" : result of migration"+ecm.getModif().getOldName()+" to be postprocessed");
				content.add("    * @return postprocessed input parameter");
				content.add("    */");
			//	content.add("   public EObject postMigration"+ecm.getModif().getOldName()+"(EObject "+paramName+");");
			//}
	//	}
		
		//content.add("\n// ----------------- REVERSED MIGRATION");
		
	//	for (EclassModif ecm: rootEcoreModif.getAllClassModifications()) {
			if(keys){
				content.add("\n   /**");
			//	content.add("    * Preprocessing of reversedMigration"+ecm.getModif().getNewName());
			//	content.add("    * @param "+paramName+" : instance of "+ecm.getNewLongName()+" to be preprocessed");
				content.add("    * @return preprocessed input parameter");
				content.add("    */");
		//		content.add("   public "+ecm.getNewLongName()+" preReversedMigration"+ecm.getModif().getNewName()+"("+ecm.getNewLongName()+" "+paramName+");");
				content.add("\n   /**");
		//		content.add("    * Postprocessing of reversedMigration"+ecm.getModif().getNewName());
		//		content.add("    * @param "+paramName+" : result of migration"+ecm.getModif().getNewName()+" to be postprocessed");
				content.add("    * @return postprocessed input parameter");
				content.add("    */");
			//	content.add("   public EObject postReversedMigration"+ecm.getModif().getNewName()+"(EObject "+paramName+");");
			}
			//else if (ecm.getEcore()!=null && !ecm.isMerged()) {
				content.add("\n   /**");
			//	content.add("    * Preprocessing of reversedMigration"+ecm.getModif().getNewName());
			//	content.add("    * @param "+paramName+" : instance of "+ecm.getNewLongName()+" to be preprocessed");
				content.add("    * @return preprocessed input parameter");
				content.add("    */");
			//	content.add("   public "+ecm.getNewLongName()+" preReversedMigration"+ecm.getModif().getNewName()+"("+ecm.getNewLongName()+" "+paramName+");");
				content.add("\n   /**");
			//	content.add("    * Postprocessing of reversedMigration"+ecm.getModif().getNewName());
			//	content.add("    * @param "+paramName+" : result of migration"+ecm.getModif().getNewName()+" to be postprocessed");
				content.add("    * @return postprocessed input parameter");
				content.add("    */");
			//	content.add("   public EObject postReversedMigration"+ecm.getModif().getNewName()+"(EObject "+paramName+");");
			//}
		//}

		//content.add("}");
		return content;
	}
	
	
	/**
	 * Creation of UI class content 
	 * @param back is true for back 
	 * @return class content
	 */
	private List<String> createUIClassContent(boolean back) {
		List<String> input = fileUtils.readTemplate("MM1ToMM2UIclassTemplate.java");
		List<String> content = new ArrayList<String>();
	//	String sourcemm = Character.toUpperCase(this.rootEcoreModif.getRoot().getModif().getOldName().charAt(0))+this.rootEcoreModif.getRoot().getModif().getOldName().substring(1);
	//	String targetmm = Character.toUpperCase(this.rootEcoreModif.getRoot().getEcore().getName().charAt(0))+this.rootEcoreModif.getRoot().getEcore().getName().substring(1);
		
		for (String line : input) {
			if (line.contains("%%%")) {
				line = line.replaceFirst("%%%JAVAPACKAGE",    this.basePackageName+".implementation");
				line = line.replaceFirst("%%%CLASS",          this.interfaceName+(back ? "Back" : "")+"UI");
	//			line = line.replaceFirst("%%%SOURCEMM",       back ? targetmm : sourcemm);
	//			line = line.replaceFirst("%%%TARGETMM",       back ? sourcemm : targetmm);
	//			line = line.replaceFirst("%%%SOURCEEPACKAGE", (back ? rootEcoreModif.getRoot().getEcore().getName() : rootEcoreModif.getRoot().getModif().getOldName()));
	//			line = line.replaceFirst("%%%TARGETEPACKAGE", (back ? rootEcoreModif.getRoot().getModif().getOldName() : rootEcoreModif.getRoot().getEcore().getName()));
				content.add(line);
			} else {
				content.add(line);
			}	
		}

		return content;
	}
	
	/**
	 * Creation of I/O class content 
	 * @param back is true for back 
	 * @return class content
	 */
	private List<String> createIOClassContent() {
		List<String> input = fileUtils.readTemplate("MM1ToMM2IOclassTemplate.java");
		List<String> content = new ArrayList<String>();
		String sourcemm = nameSourcePackage;
		String targetmm = nameTargetPackage;
		
		for (String line : input) {
			if (line.contains("%%%")) {
				line = line.replaceFirst("%%%JAVAPACKAGE",    "testreverse");
				line = line.replaceFirst("%%%CLASS",          this.nameSourcePackage+"IO");
				line = line.replaceFirst("%%%SOURCEMM",       sourcemm);
				line = line.replaceFirst("%%%TARGETMM",       sourcemm);
				content.add(line);
			} else if (line.contains("$$$$INCLUDELOADINGFUNCTIONS")) {
				content.addAll(this.createLoadingFunctions());
			} else if (line.contains("$$$$INCLUDESAVINGFUNCTIONS")) {
				content.addAll(this.createSavingFunctions());
			} else {
				content.add(line);
			}
		}

		return content;
	}
	
	/**
	 * Creation of loading function code
	 * @param back is true for back
	 * @return generated code
	 */
	private List<String> createLoadingFunctions() {
		List<String> content = new ArrayList<String>();
		String sourcemm = Character.toUpperCase(this.rootEcore.getName().charAt(0))+this.rootEcore.getName().substring(1);
		//String targetmm = Character.toUpperCase(this.outputrootEcore.getName().charAt(0))+this.outputrootEcore.getName().substring(1);
		for(EClassifier ec : rootEcore.getEClassifiers()){
			if (ec!=null )  {
			List<String> input = fileUtils.readTemplate("MM1ToMM2IOLoadingTemplate.java");
			for (String line : input) {
				if (line.contains("%%%")) {
					line = line.replace("%%%SOURCEMM",           sourcemm);
					line = line.replace("%%%COMPLETEJAVANAME",   sourcemm+ec.getName());
					line = line.replace("%%%COMPLETEECLASSNAME", ec.getName());
					line = line.replace("%%%SOURCEEPACKAGE",     rootEcore.getName());
				}
				content.add(line);
			}
			content.add("");
			}
		}
		return content;
	}
	
	/**
	 * Creation of saving function code
	 * @param back is true for save and false for load
	 * @return generated code
	 */
	private List<String> createSavingFunctions() {
		List<String> content = new ArrayList<String>();
		String sourcemm = Character.toUpperCase(this.rootEcore.getName().charAt(0))+this.rootEcore.getName().substring(1);
		//String targetmm = Character.toUpperCase(this.rootEcoreModif.getRoot().getModif().getNewName().charAt(0))+this.rootEcoreModif.getRoot().getModif().getNewName().substring(1);
		//	for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {			
		for(EClassifier ec : rootEcore.getEClassifiers()){
			if (ec != null ) {
				List<String> input = fileUtils.readTemplate("MM1ToMM2IOSavingTemplate.java");
				for (String line : input) {
					if (line.contains("%%%")) {
						line = line.replace("%%%COMPLETEJAVANAME", sourcemm );
						line = line.replace("%%%TARGETEPACKAGE",   sourcemm );
					}
					content.add(line);
				}
				content.add("");
			}
		}
		return content;
	}
	
	/**
	 * creation of migration classes
	 * @return class content
	 */
	private List<String> createMigrationClassContent(boolean keys, boolean fromKeys) {
		List<String> content = new ArrayList<String>();
		content.add("package "+this.basePackageName+".implementation;\n");
		content.add("import java.util.*;");
		content.add("import org.eclipse.emf.ecore.*;");
//		content.add("import "+rootEcoreModif.getRoot().getNewLongName()+"*;");	
//		content.add("import "+rootEcoreModif.getRoot().getNewLongName()+"impl.*;");			
		content.add("import "+this.basePackageName+".interfaces.*;\n");
		
		content.add("public class "+this.interfaceName+" implements "+this.interfaceName+"Migration, "+this.interfaceName+"UserCode {");

		content.add("\n	// map to store correspondences between source and target EObjects");
		content.add("	public Map<EObject, EObject> sourceToTarget = new HashMap<EObject, EObject>();");
		if(keys){
			content.add("    int key = 0;");
		}
		content.add("\n// ----------------- PRE AND POST PROCESSING OF MIGRATION\n");
		
//		for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {
			if(keys){
		//		content.add("   @Override public "+ecm.getOldLongName()+" preMigration"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+") { return "+paramName+"; }");
		//		content.add("   @Override public EObject postMigration"+ecm.getModif().getOldName()+"(EObject "+paramName+") { return "+paramName+"; }");
			}
		//	else if (ecm.getEcore()!=null) {
		//	content.add("   @Override public "+ecm.getOldLongName()+" preMigration"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+") { return "+paramName+"; }");
		//	content.add("   @Override public EObject postMigration"+ecm.getModif().getOldName()+"(EObject "+paramName+") { return "+paramName+"; }");
		//	}
		//}
		
	//	content.add("\n// ----------------- PRE AND POST PROCESSING OF REVERSED MIGRATION\n");
		
	//	for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {
			if(keys){
			//	content.add("   @Override public "+ecm.getNewLongName()+" preReversedMigration"+ecm.getModif().getNewName()+"("+ecm.getNewLongName()+" "+paramName+") { return "+paramName+"; }");
			//	content.add("   @Override public EObject postReversedMigration"+ecm.getModif().getNewName()+"(EObject "+paramName+") { return "+paramName+"; }");
			}
			//else if (ecm.getEcore()!=null && !ecm.isMerged()) {
		//	content.add("   @Override public "+ecm.getNewLongName()+" preReversedMigration"+ecm.getModif().getNewName()+"("+ecm.getNewLongName()+" "+paramName+") { return "+paramName+"; }");
		//	content.add("   @Override public EObject postReversedMigration"+ecm.getModif().getNewName()+"(EObject "+paramName+") { return "+paramName+"; }");
		//	}
		//}

	//	content.add("\n// ----------------- MIGRATION\n");
		
	//	for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {
			if(keys){
				//content.add("   @Override");
		//		content.add("   public final EObject migration"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+") {");
		//		content.add("       "+paramName+" = this.preMigration"+ecm.getModif().getOldName()+"("+paramName+");");

		//		content.addAll(this.migrationcore.generateMigrationCode(ecm, keys, false));
		//		ecm.getParent().getNewLongName();
			
		//		content.add("       return this.postMigration"+ecm.getModif().getOldName()+"(result);");
				content.add("   }\n");
				
				content.add("   @Override");
		//		content.add("   public final void addReferences"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+") {");

			//	content.addAll(this.migrationcore.generateAddReferencesCode(ecm, keys));
			
				content.add("   }\n");	
		//	}else if (ecm.getEcore()!=null) {
			//content.add("   @Override");
	//		content.add("   public final EObject migration"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+") {");
	//		content.add("       "+paramName+" = this.preMigration"+ecm.getModif().getOldName()+"("+paramName+");");

			if(fromKeys){
		//		content.addAll(this.reversemigrationcore.generateMigrationCode(ecm, false, true));
			}else{
			//	content.addAll(this.reversemigrationcore.generateMigrationCode(ecm, false, false));
			}
		//	content.add("       return this.postMigration"+ecm.getModif().getOldName()+"(result);");
			content.add("   }\n");
			
			//content.add("   @Override");
		//	content.add("   public final void addReferences"+ecm.getModif().getOldName()+"("+ecm.getOldLongName()+" "+paramName+") {");

		//	content.addAll(this.reversemigrationcore.generateAddReferencesCode(ecm, false));
		
			content.add("   }\n");			
			}
		//}
		
		//content.add("// ----------------- REVERSED MIGRATION\n");
		
	//	for (EclassModif ecm : rootEcoreModif.getAllClassModifications()) {
			if(keys){
			//	content.add("   @Override");
		//		content.add("   public final EObject reversedMigration"+ecm.getModif().getNewName()+"("+ecm.getNewLongName()+" "+paramName+") {");
			//	content.add("       "+paramName+" = this.preReversedMigration"+ecm.getModif().getNewName()+"("+paramName+");");

			//	content.addAll(this.reversemigrationcore.generateReverseMigrationCode(ecm, true));
			
			//	content.add("       return this.postReversedMigration"+ecm.getModif().getNewName()+"(result);");
				content.add("   }\n");
			}
		//	else if (ecm.getEcore()!=null && !ecm.isMerged()) {
			//content.add("   @Override");
		//	content.add("   public final EObject reversedMigration"+ecm.getModif().getNewName()+"("+ecm.getNewLongName()+" "+paramName+") {");
		//	content.add("       "+paramName+" = this.preReversedMigration"+ecm.getModif().getNewName()+"("+paramName+");");

		//	content.addAll(this.reversemigrationcore.generateReverseMigrationCode(ecm, false));
		
	//		content.add("       return this.postReversedMigration"+ecm.getModif().getNewName()+"(result);");
			content.add("   }\n");
	//		}
	//	}
		if(keys){
			content.add("   public int getKey(int key){");
			content.add("     this.key = key+1;");
			content.add("     return this.key;");
			content.add("   }");
		}
		content.add("}");
		return content;
	}
}