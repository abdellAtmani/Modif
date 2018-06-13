/**
 * 
 * facade for ecoreModif classes (Modif ATL fabrics, EcoreModif IO Fabric, 
 * Refactoring, XML creation and code generation
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  @author Paola Vallejo
 *  22/11/2013
 */

package uiModif;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import dependency.DependencyPackage;
import dependency.Graph;
import migration.DerivedReference;
import migration.Instance;
import migration.Migration;
import migration.MigrationPackage;
import migration.ReferencePath;
import migrationRoundtrip.MigrationRoundtrip;
import migrationRoundtrip.MigrationSpecificationGenerator;
import migrationRoundtrip.ApplyOperators;
import modif.*;
import utils.UtilEMF;
import utils.UtilUUID;
import utils.AtomicModifFactory;
import utils.EraseAllModifFactory;
import utils.NoModifFactory;
import utils.SpecificModifFactory;
import ecoremodif.EattributeModif;
import ecoremodif.EclassModif;
import ecoremodif.EreferenceModif;
import ecoremodif.RootEcoreModif;
import ecoremodif.utils.ModifIO;

public class modifService {

	protected RootEcoreModif theRootEcoreModif;
	protected RootEcoreModif theRootEcoreModifCopy;
	protected ModifIO modifIO ;

	protected Map<String, ArrayList<String>> superTypesMap;
	protected Map<String, ArrayList<String>> attributesMap;

	protected String initialEcoreFile;
	protected String inputEcoreFile;
	protected String originalEcoreFile;
	protected String keyEcoreFile;
	protected String toolEcoreFile;
	protected String refactoredEcoreFile;
	protected EPackage keyEcoreFilePackage;
	protected String modifFile;
	protected String originalModelFile;
	protected String migratedModelFile;
	protected String migrationFile;
	protected String toolOutputModelFile;
	protected String reversedModelFile;
	protected String recontextualizedKeysModelFile;
	protected String graphFile;
	protected String recontextualizedGraphModelFile;
	protected String recontextualizedFinalModelFile;
	protected String projectFile;

	String modifFileName = null;

	protected ArrayList<String> hideClassList;
	protected ArrayList<String> flattenClassList;

	protected String refactoredWithoutKFileName;
	MigrationSpecificationGenerator migrationSpecificationGenerator;

	protected boolean isUML;

	EPackage sourceMetamodelUUID;

	protected Migration migration;
	protected MigrationRoundtrip migrt;
	EObject migratedModel;

	protected Map<String, Map<String, Map<String, String>>> renamemap;
	protected Map<String, Map<String, ArrayList<ArrayList<String>>>> hidemap;
	protected Map<String, String> newReferenceName;
	protected Map<String, Map<String, ArrayList<String>>> referencesToClassMap;

	ArrayList<String> hiddenInstances = new ArrayList<String>();
	


	/**
	 * Constructor
	 */
	public modifService() {
		theRootEcoreModif = null;
		modifIO = new ModifIO();
	}


	/**
	 * Set files.
	 * @param originalEF Input Ecore file.
	 */
	public void setFiles(String originalEF){
		this.originalEcoreFile = originalEF;
	}


	/**
	 * Set files.
	 * @param projectF Project source folder.
	 * @param originalEF Input Ecore file.
	 * @param modifF Modif specification.
	 * @param processedMF Model transformed by a tool.
	 * @param graphF Dependencies graph file.
	 */
	public void setFiles(String projectF, String originalEF, String modifF, String processedMF, String graphF){
		this.projectFile = projectF;
		this.originalEcoreFile = originalEF;
		this.modifFile = modifF;
		this.toolOutputModelFile = processedMF;
		this.graphFile = graphF;
	}


	/**
	 * Set files.
	 * @param projectF Project source folder.
	 * @param originalEF Input Ecore file.
	 * @param modifF Modif specification.
	 * @param toolEF Tools' metamodel file.
	 * @param inputMF Input Ecore file.
	 * @param migrationF Migration specification file.
	 * @param processedMF Model transformed by a tool.
	 * @param graphF Dependencies graph file.
	 * @param isUML True if the input metamodel is UML. false otherwise.
	 */
	public void setFiles(String projectF, String originalEF, String modifF, String toolEF, String inputMF, String migrationF, String processedMF, String graphF, boolean isUML){
		this.projectFile = projectF;
		this.originalEcoreFile = originalEF;
		this.modifFile = modifF;
		this.toolEcoreFile = toolEF;
		this.originalModelFile = inputMF;
		this.migrationFile = migrationF;
		this.toolOutputModelFile = processedMF;
		this.graphFile = graphF;
		this.isUML = isUML;
	}


	/**
	 * Create the modif file.
	 */
	public void CreateModif() {
		// fabric call from files
		if(keyEcoreFile == null){
			String[] strArray = originalEcoreFile.split("\\.");
			String modelName = strArray[strArray.length-2];
			this.keyEcoreFile = (originalEcoreFile.replace(modelName, modelName+"K"));
		}
		modifIO.setModifIO(keyEcoreFile, modifFile);
		theRootEcoreModif = modifIO.getEcoreModif();
		theRootEcoreModifCopy = theRootEcoreModif;
		buildSuperTypesMap(theRootEcoreModif);
	}


	/**
	 * Create the modif file.
	 * 
	 * @param metamodel Metamodel for which the modif file is created.
	 */
	public RootEcoreModif CreateModif(String metamodel) {
		EPackage rootkeyPackage;
		// fabric call from files
		EPackage domainMM = UtilEMF.loadMetamodel(metamodel);
		rootkeyPackage = domainMM;
		if(keyEcoreFile == null){
			String[] strArray = originalEcoreFile.split("\\.");
			String modelName = strArray[strArray.length-2];
			this.keyEcoreFile = (originalEcoreFile.replace(modelName, modelName+"extendedK"));
		}
		modifIO.setModifIO(keyEcoreFile, modifFile);
		theRootEcoreModif = modifIO.getEcoreModif();
		//theRootEcoreModifCopy = theRootEcoreModif;
		//buildSuperTypesMap(theRootEcoreModif);
		//buildHideList(theRootEcoreModif);
		//buildFlattenList(theRootEcoreModif);
		return theRootEcoreModif;
	}


	/**
	 * Create the modif file.
	 * 
	 * @param simpleRefactoring Simple refactoring (without migration).
	 * @param metamodel Metamodel to be modified.
	 */
	public RootEcoreModif CreateModif(boolean simpleRefactoring,  String metamodel) {
		EPackage rootkeyPackage = null;
		// fabric call from files
		if(simpleRefactoring){			
			modifIO.setModifIO(originalEcoreFile, modifFile);
			theRootEcoreModif = modifIO.getEcoreModif();
			theRootEcoreModifCopy = theRootEcoreModif;
			buildSuperTypesMap(theRootEcoreModif);
			//simple migration
		}else{
			EPackage domainMM = UtilEMF.loadMetamodel(metamodel);
			boolean addKeys = true;
			// verifying if keys were already added
			for(TreeIterator<EObject> it = domainMM.eAllContents(); it.hasNext();){
				EObject next = it.next();
				if(next instanceof EClass){
					EClass c = (EClass) next;
					for(EAttribute ea : c.getEAllAttributes()){
						if(ea.getName().equals("UUID")){
							addKeys = false;
							break;
						}
					}
				}
			}
			// adding keys
			if(addKeys){ rootkeyPackage = UtilUUID.addUUIDMetamodelAttribute(domainMM); }
			else{ rootkeyPackage = domainMM; }

			if(keyEcoreFile == null){
				String[] strArray = originalEcoreFile.split("\\.");
				String modelName = strArray[strArray.length-2];
				this.keyEcoreFile = (originalEcoreFile.replace(modelName, modelName+"K"));
			}
			modifIO.setModifIO(keyEcoreFile, modifFile);
			theRootEcoreModif = modifIO.getEcoreModif();
			theRootEcoreModifCopy = theRootEcoreModif;
			buildSuperTypesMap(theRootEcoreModif);
			buildHideList(theRootEcoreModif);
			buildFlattenList(theRootEcoreModif);
		}
		return theRootEcoreModif;
	} 


	/**
	 * Create the modif object from a modif file.
	 * 
	 * @param modifFile Modif file.
	 * @param modifFileName Name of the modif file.
	 * @param type If type is 1, the modif specification produces a copy of the extended package. 
	 * If type is 2, the modif specification deletes all elements of the extended package.
	 */
	public EObject createModif(File modifFile, String modifFileName, int type) {
		ModifIO aModifIO = new ModifIO();
		SpecificModifFactory specificModifFactory = new SpecificModifFactory();
		NoModifFactory noModifFactory = new NoModifFactory();
		EraseAllModifFactory eraseAllModifFactory = new EraseAllModifFactory();
		AtomicModifFactory atomicModifFactory = new AtomicModifFactory();
		EPackage theRootEcore = aModifIO.LoadEcore(this.originalEcoreFile);
		Modifications theRootModif;
		if      (type==1) { theRootModif = noModifFactory.generateModif(theRootEcore); }
		else if (type==2) { theRootModif = eraseAllModifFactory.generateEraseAll(theRootEcore); } 
		else if (type==3) {theRootModif = atomicModifFactory.generateModif(theRootEcore);}
		else { theRootModif = specificModifFactory.generateModif(theRootEcore); }
		try {
			OutputStream ff = new FileOutputStream(modifFile) ;
			ModifIO.SaveModif(theRootModif, modifFileName);
		} 
		catch (IOException e) { e.printStackTrace(); }
		return (EObject)theRootModif;
	}


	/**
	 * Create the modif object from a modif file.
	 * 
	 * @param modifFile Modif file.
	 * @param modifFileName Name of the modif file.
	 * @param type If type is 1, the modif specification produces a copy of the extended package. 
	 * If type is 2, the modif specification deletes all elements of the extended package.
	 * @return theRootModif
	 */
	public EObject createModif(File modifFile, String modifFileName, int type, String extendedPackage) {
		ModifIO aModifIO = new ModifIO();
		NoModifFactory noModifFactory = new NoModifFactory();
		SpecificModifFactory specificmodifFactory = new SpecificModifFactory();
		EraseAllModifFactory eraseAllModifFactory = new EraseAllModifFactory();
		AtomicModifFactory atomicModifFactory = new AtomicModifFactory();
		EPackage theRootEcore = aModifIO.LoadEcore(extendedPackage);
		Modifications theRootModif;
		if (type==2) { theRootModif = eraseAllModifFactory.generateEraseAll(theRootEcore); } 
		else if(type==3) { theRootModif = atomicModifFactory.generateModif(theRootEcore);}
		else if(type==4) { theRootModif = specificmodifFactory.generateModif(theRootEcore);}
		else { theRootModif = noModifFactory.generateModif(theRootEcore);
		System.out.println(""+noModifFactory.listEClassNames(theRootEcore));}
		try {
			OutputStream ff = new FileOutputStream(modifFile) ;
			// Saving the modif specification
			ModifIO.SaveModif(theRootModif, modifFileName);
		} 
		catch (IOException e) { e.printStackTrace(); }
		return (EObject)theRootModif;
	}


	/**
	 * Create the modif file specific for UML metamodel
	 */
	public void CreateModifUML() {
		// fabric call from files
		modifIO.setModifIO(this.originalEcoreFile, modifFile);
		theRootEcoreModif = modifIO.getEcoreModif();
	}


	/**
	 * Modif specification creation.
	 * 
	 * @param type If type is 1, the modif specification will be able to produce a copy of the extended package. 
	 * If type is 2, the modif specification will be able to delete all elements of the extended package.
	 * @param extendedPackage Extended source package.
	 * @param extendedName Name of the extended source package.
	 * @return theRootEcoreModif Root ecore modif.
	 */
	public RootEcoreModif createModifSpecification(int type, EPackage extendedPackage, String extendedName) {
		String modifNoModif;
		String modifEraseAll;
		String modifAtomic;
		File noModif;
		File eraseAll;
		File atomic;
		EObject modifSpecification = null;

		File f = new File(this.originalEcoreFile);
		int idx = f.getName().lastIndexOf('.');

		File modifFolder = new File(f.getParent().replace("metamodel", "modif"));

		// modif folder does not exist
		if(!modifFolder.exists()){
			//modif folder creation
			File dir = new File(f.getParent()+"/../modif");
			dir.mkdir();
			System.out.println("The modif folder has been created");
		}

		switch (type) {
		case 1:
			modifNoModif = f.getParent().replace("metamodel", "modif")+"/NoModif"+extendedPackage.getName()+".modif";
			noModif = new File(modifNoModif);
			modifFile = modifNoModif;
			// There is a NoModif specification
			if(noModif.exists()){
				System.out.println("[rewriting] The "+ noModif.getName() +" specification will be rewrited");
			}
			modifSpecification = createModif(noModif, modifNoModif, type, extendedName);
			break;

		case 2:
			modifEraseAll = f.getParent().replace("metamodel", "modif")+"/eraseAll"+extendedPackage.getName()+".modif";
			eraseAll = new File(modifEraseAll);
			modifFile = modifEraseAll;
			// There is a eraseAll specification
			if(eraseAll.exists()){
				System.out.println("[rewriting] The "+ eraseAll.getName() +" specification will be rewrited");
			}
			modifSpecification = createModif(eraseAll, modifEraseAll, type, extendedName);
			break;
		case 3:
			modifAtomic = f.getParent().replace("metamodel", "modif")+"/Atomic"+extendedPackage.getName()+".modif";
			atomic = new File(modifAtomic);
			modifFile = modifAtomic;
			// There is a NoModif specification
			if(atomic.exists()){
				System.out.println("[rewriting] The "+ atomic.getName() +" specification will be rewrited");
			}
			modifSpecification = createModif(atomic, modifAtomic, type, extendedName);
			break;
		}
		modifIO.setModifIO(extendedName, modifFile);
		theRootEcoreModif = modifIO.getEcoreModif();
		return theRootEcoreModif;
	}


	/**
	 * Generate the modif file able to refactor the domain metamodel
	 * 
	 * @param domainMetamodel metamodel to be refactored
	 * @param atlModif type of modif (NoModif or EraseAll)
	 * @param modifFile modif file name
	 * @throws IOException
	 */
	
	public void generateModifFile(String domainMetamodel, int atlModif, String modifFile, boolean key) throws IOException{
		ModifIO aModifIO = new ModifIO();
		SpecificModifFactory specificModifFactory = new SpecificModifFactory();
		NoModifFactory noModifFactory = new NoModifFactory();
		EraseAllModifFactory eraseAllModifFactory = new EraseAllModifFactory();
		AtomicModifFactory atomicModifFactory = new AtomicModifFactory();
		EPackage theRootEcore      = aModifIO.LoadEcore(domainMetamodel);
		Modifications theRootModif;
		if (atlModif==1)      { theRootModif = noModifFactory.generateModif(theRootEcore, key);}
		else if (atlModif==2) { theRootModif = eraseAllModifFactory.generateEraseAll(theRootEcore, key); }
		else if (atlModif==3) { theRootModif = atomicModifFactory.generateModif(theRootEcore,key);}
		else                  {theRootModif = specificModifFactory.generateModif(theRootEcore,key);
		}
		
			OutputStream ff = new FileOutputStream(modifFile) ;
			// Saving the modif specification
			ModifIO.SaveModif(theRootModif, modifFile);
	
	}


	/**
	 * Simplifies the modif file.
	 * @param modifF Modif file to be simplified.
	 */
	public void Minimize(String modifF) {
		migrationRoundtrip.Minimize tool = new migrationRoundtrip.Minimize();
		Modifications modif = modifIO.LoadModif(modifF);
		tool.accept(modif);
		try { ModifIO.SaveModif(modif, modifF);
		} catch (IOException e) { e.printStackTrace(); }
	}


	/**
	 * Transforms the input ecore according to the operators of the modif file.
	 * 
	 * @return refactoredEcoreFile Name of the saved file containing the refactored metamodel.
	 */
	public String Refactor() {
		if (theRootEcoreModif != null) {
			if (ApplyOperators.ecoreModifIsValid(theRootEcoreModif)) {
				// launch refactoring operators
				ApplyOperators.operate(theRootEcoreModif);
				// save the resulting ecore model		
				try {
					// Save refactored metamodel with UUID
					modifIO.save(projectFile+"\\metamodel\\"+theRootEcoreModif.getRoot().getNewName()+".ecore");		
					refactoredEcoreFile = projectFile+"\\metamodel\\"+theRootEcoreModif.getRoot().getNewName()+".ecore";
				} catch (IOException e) { e.printStackTrace(); }				
			}else System.out.println("\nChange the Modif model");	
		}
		return refactoredEcoreFile;
	}


	/**
	 * Refactor a metamodel and compare the refactored metamodel with an existing metamodel.
	 * @param existingMetamodel Metamodel to compare with the refactored metamodel.
	 * @return refactoredEcoreFile Name of the saved file containing the refactored metamodel.
	 */
	public String Refactor(String existingMetamodel) {
		String refactoredEcoreFile =  Refactor();
		if(existingMetamodel != "") {
			List<Diff> differences = Compare(refactoredEcoreFile, existingMetamodel);
			if(differences.size() == 0){ System.out.println("Refactored Metamodel and target metamodel matches"); }
			else{ 
				System.out.println("Refactored metamodel and target metamodel does not match. To correct it:");
				for(org.eclipse.emf.compare.Diff diff : differences) {								
					String[] split = diff.toString().split(",");
					if(split[0].contains("ReferenceChangeSpec")) {
						if(split[0].contains("eClassifiers")) {
							String className = split[1].substring(split[1].lastIndexOf(" "), split[1].length());
							DifferenceKind kind = diff.getKind();
							DifferenceSource source = diff.getSource();
							if(kind.getName().equals("ADD") && source.getName().equals("LEFT")) { System.out.println("  Remove the"+className+ " EClass"); }
							else if(kind.getName().equals("DELETE") && source.getName().equals("LEFT")) { System.out.println("  Do not remove the"+className+ " EClass"); }
						}
					}
				}
			}
		}
		return refactoredEcoreFile;
	}



	/**
	 * Refactor to be applied before a migration.
	 * @return refactoredWithoutK Refactored metamodel.
	 */
	public EPackage RefactorSimpleMigration() {
		EPackage refactoredWithoutK = null;
		//String refactoredWithoutKFileName = null;
		if (theRootEcoreModif != null) {
			if (ApplyOperators.ecoreModifIsValid(theRootEcoreModif)) {
				// launch refactoring operators
				ApplyOperators.operate(theRootEcoreModif);
				// save the resulting ecore model		
				try {
					// Save refactored metamodel with UUID
					modifIO.save(projectFile+"\\"+theRootEcoreModif.getRoot().getNewName()+".ecore");	
					refactoredEcoreFile = projectFile+"\\"+theRootEcoreModif.getRoot().getNewName()+".ecore";
					// Save refactored metamodel without UUID
					//refactoredWithoutK = UtilEMF.removeUUIDAttribute(UtilEMF.loadMetamodel(refactoredEcoreFile));
					File f = new File(refactoredWithoutK.getNsURI());
					int idx = f.getName().lastIndexOf('K');
					int idx2 = refactoredWithoutK.getName().lastIndexOf('K');
					int idx3 = refactoredWithoutK.getNsPrefix().lastIndexOf('K');
					refactoredWithoutKFileName = (f.getParent()+"/"+f.getName().substring(0, idx)+".ecore").replace("file:\\", "");
					refactoredWithoutK.setName(refactoredWithoutK.getName().substring(0, idx2));
					refactoredWithoutK.setNsPrefix(refactoredWithoutK.getNsPrefix().substring(0, idx3));
					UtilEMF.saveMetamodel(refactoredWithoutK, refactoredWithoutKFileName);
				} catch (IOException e) { e.printStackTrace(); }				
			}else System.out.println("\nChange the Modif model");	
		}
		return refactoredWithoutK;
	}


	/**
	 * Refactor a metamodel and its related metamodels.
	 * 
	 * @param theRootEcoreModif Object containing the metamodels to be refactored and the operators to be applied.
	 * @return refactoredPackages. List of refactored metamodels.
	 */
	public ArrayList<EPackage> Refactoring(RootEcoreModif theRootEcoreModif) {
		ArrayList<EPackage> refactoredPackages = new ArrayList<EPackage>();
		if (theRootEcoreModif != null) {
			if (ApplyOperators.ecoreModifIsValid(theRootEcoreModif)) {
				// launch refactoring operators
				ApplyOperators.operate(theRootEcoreModif);
			}
		}
		refactoredPackages.add(theRootEcoreModif.getRoot().getEcore());
		if(!theRootEcoreModif.getRoot().getEcore().getESubpackages().isEmpty()) {
			for(EPackage subp : theRootEcoreModif.getRoot().getEcore().getESubpackages()) { refactoredPackages.add(subp); }
		}
		return refactoredPackages;
	}


	/**
	 * Refactor a metamodel.
	 * 
	 * @param projectSourceFolder Path of the folder containing the metamodel to be refactored.
	 * @param modifSpecificationType Type of the modif specification to be applied.
	 * @param isUML True if the metamodel to be refactored is UML. False, otherwise.
	 * @param coevolution True if refactoring and migration. False if only refactoring.
	 * @param GUI 
	 * @throws IOException 
	 */
	public void Refactoring(String projectSourceFolder, int modifSpecificationType, boolean isUML, boolean coevolution, boolean GUI) throws IOException {
		if(GUI){
			// TODO: Launch GUI
		}
		if(isUML) {
			if(coevolution) { RefactoringUML(projectSourceFolder, modifSpecificationType, true, GUI); }
			else { RefactoringUML(projectSourceFolder, modifSpecificationType, false, GUI); }
		}else { 
			// TODO Refactoring
		}
	}


	/**
	 * Refactor a metamodel and compare the refactored metamodel with an existing metamodel.
	 * 
	 * @param projectSourceFolder Path of the folder containing the metamodel to be refactored.
	 * @param modifSpecificationType Type of the modif specification to be applied.
	 * @param isUML True if the metamodel to be refactored is UML. False, otherwise.
	 * @param GUI
	 * @param existingMetamodel Metamodel to compare with the refactored metamodel.
	 */
	public void Refactoring(String projectSourceFolder, int modifSpecificationType, boolean isUML, boolean GUI, String existingMetamodel) {
		if(isUML) {
			try {
				String refactoredMetamodelPath = RefactoringUML(projectSourceFolder, modifSpecificationType, false, GUI);
				// Compares the refactored metamodel with an existing metamodel
				if(existingMetamodel != "") {
					List<Diff> differences = Compare(refactoredMetamodelPath, existingMetamodel);
					if(differences.size() == 0){ System.out.println("Refactored Metamodel and target metamodel matches"); }
					else{ 
						System.out.println("Refactored metamodel and target metamodel does not match. To correct it:");
						for(org.eclipse.emf.compare.Diff diff : differences) {								
							String[] split = diff.toString().split(",");
							if(split[0].contains("ReferenceChangeSpec")) {
								if(split[0].contains("eClassifiers")) {
									String className = split[1].substring(split[1].lastIndexOf(" "), split[1].length());
									DifferenceKind kind = diff.getKind();
									DifferenceSource source = diff.getSource();
									if(kind.getName().equals("ADD") && source.getName().equals("LEFT")) { System.out.println("  Remove the"+className+ " EClass"); }
									else if(kind.getName().equals("DELETE") && source.getName().equals("LEFT")) { System.out.println("  Do not remove the"+className+ " EClass"); }
								}
							}
						}
					}
				}
			} 
			catch (IOException e) { e.printStackTrace(); }
		}else {
			// not UML
			try {
				String refactoredMetamodelPath = RefactoringSimple(projectSourceFolder, modifSpecificationType, false, GUI);
				if(existingMetamodel != "") {
					List<Diff> differences = Compare(refactoredMetamodelPath, existingMetamodel);
					if(differences.size() == 0){ System.out.println("Refactored Metamodel and target metamodel match"); }
					else{ 
						System.out.println("Refactored metamodel and target metamodel does not match. To correct it:");
						for(org.eclipse.emf.compare.Diff diff : differences) {								
							String[] split = diff.toString().split(",");
							if(split[0].contains("ReferenceChangeSpec")) {
								if(split[0].contains("eClassifiers")) {
									String className = split[1].substring(split[1].lastIndexOf(" "), split[1].length());
									DifferenceKind kind = diff.getKind();
									DifferenceSource source = diff.getSource();
									if(kind.getName().equals("ADD") && source.getName().equals("LEFT")) { System.out.println("  Remove the"+className+ " EClass"); }
									else if(kind.getName().equals("DELETE") && source.getName().equals("LEFT")) { System.out.println("  Do not remove the"+className+ " EClass"); }
								}
							}
						}
					}
				}
			} 
			catch (IOException e) { e.printStackTrace(); }		
		}
	}


	/**
	 * Refactoring.
	 * 
	 * @param sourceMetamodelPath Path to the source metamodel.
	 * @param modifSpecificationType Type of the modif specification.
	 * @param GUI
	 * @return refactoredMetamodelPath Path to the refactored metamodel.
	 * @throws IOException
	 */
	public String RefactoringSimple(String sourceMetamodelPath, int modifSpecificationType, boolean coevolution, boolean GUI) throws IOException {
		String sourceMetamodelUUIDPath = null;
		String refactoredMetamodelPath = null;
		File ProjectFolder = null; 

		File f = new File(sourceMetamodelPath);
		int idx = f.getName().lastIndexOf('.');

		// Create a by default modif specification
		if(modifSpecificationType == 1) {
			if(coevolution) {
				EPackage sourceMetamodel = UtilEMF.loadMetamodel(sourceMetamodelPath);
				//sourceMetamodelUUID = UtilEMF.addUUIDAttribute(sourceMetamodel);
				sourceMetamodelUUIDPath = f.getAbsolutePath().replace(f.getName(), f.getName().substring(0, idx)+"UUID.ecore");
				UtilEMF.saveMetamodel(sourceMetamodelUUID, sourceMetamodelUUIDPath);
				modifFileName = f.getParent().replace("metamodel", "modif")+"/NoModif"+f.getName().replace(f.getName(), f.getName().substring(0, idx)+"UUID.modif");			
				generateModifFile(sourceMetamodelUUIDPath, modifSpecificationType, modifFileName, false);
			}else {
				modifFileName = f.getParent().replace("metamodel", "modif")+"/NoModif"+f.getName().substring(0,idx)+".modif";				
				generateModifFile(sourceMetamodelPath, modifSpecificationType, modifFileName, false);
			}
		}else if(modifSpecificationType == 2){
			/*if(coevolution) {
			modifFileName = projectSourceFolder+"/modif/EraseAllUMLUUID.modif";
			generateModifFile(projectSourceFolder+"/metamodel/UMLUUID.ecore", modifSpecificationType, modifFileName, true);
		}else {
			modifFileName = projectSourceFolder+"/modif/EraseAllUML.modif";
			generateModifFile(projectSourceFolder+"/metamodel/UML.ecore", modifSpecificationType, modifFileName, false);
		}*/
		}
		// Refactoring
		ProjectFolder = f.getParentFile();
		if(coevolution) { setFiles(f.getParentFile().getParent().toString(), sourceMetamodelUUIDPath, modifFileName, null, null); }
		else { setFiles(f.getParentFile().getParent().toString(), sourceMetamodelPath, modifFileName, null, null); }
		if(!GUI) {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Modify your modif file in order to indicate de operators to be applied");
			System.out.println("Did you finish? y/n");
			String finish = keyboard.nextLine();
			if(finish.equals("y")) {
				if(isUML) {
					CreateModifUML();
					// Siplifying the modif specification
					Minimize(modifFileName);
					refactoredMetamodelPath = Refactor();
				}else {
					CreateModif();
					Minimize(modifFileName);
					refactoredMetamodelPath = Refactor();
				}
			}else {
				// TODO finish != y
			}
			keyboard.close();
			if(coevolution) {
				// Delete UUIDs from the refactored metamodel
				//EPackage refactoredMetamodel = UtilEMF.removeUUIDAttribute(refactoredMetamodelPath);
				//UtilEMF.saveMetamodel(refactoredMetamodel, refactoredMetamodelPath.replace("UUID",""));
			}
		}else {	CreateModifUML(); 
		//refactoredMetamodelPath = Refactor();
		}
		return refactoredMetamodelPath;
	}


	/**
	 * Refactor the UML metamodel.
	 * 
	 * @param projectSourceFolder Path of the folder containing the metamodel to be refactored.
	 * @param modifSpecificationType Type of the modif specification to be applied.
	 * @param coevolution True if refactoring and migration. False if only refactoring.
	 * @param GUI 
	 * @throws IOException
	 */
	public String RefactoringUML(String projectSourceFolder, int modifSpecificationType, boolean coevolution, boolean GUI) throws IOException {
		String refactoredMetamodelPath = null;
		if(coevolution) {
			// TODO
		}
		// Create a by default modif specification
		if(modifSpecificationType == 1) {
			if(coevolution) {
				modifFileName = projectSourceFolder+"/modif/NoModifUMLUUID.modif";
				generateModifFile(projectSourceFolder+"/metamodel/UMLUUID.ecore", modifSpecificationType, modifFileName, true);
			}else {
				modifFileName = projectSourceFolder+"/modif/NoModifUML.modif";
				generateModifFile(projectSourceFolder+"/metamodel/UML.ecore", modifSpecificationType, modifFileName, false);
			}
		}else if(modifSpecificationType == 2){
			if(coevolution) {
				modifFileName = projectSourceFolder+"/modif/EraseAllUMLUUID.modif";
				generateModifFile(projectSourceFolder+"/metamodel/UMLUUID.ecore", modifSpecificationType, modifFileName, true);
			}else {
				modifFileName = projectSourceFolder+"/modif/EraseAllUML.modif";
				generateModifFile(projectSourceFolder+"/metamodel/UML.ecore", modifSpecificationType, modifFileName, false);
			}
		}
		else if(modifSpecificationType == 3) {
			if(coevolution) {
				modifFileName = projectSourceFolder+"/modif/AtomicUMLUUID.modif";
				generateModifFile(projectSourceFolder+"/metamodel/UMLUUID.ecore", modifSpecificationType, modifFileName, true);
			}else {
				modifFileName = projectSourceFolder+"/modif/UML.modif";
				generateModifFile(projectSourceFolder+"/metamodel/UML.ecore", modifSpecificationType, modifFileName, false);
			}
		}
		// Refactoring
		if(coevolution) { setFiles(projectSourceFolder, projectSourceFolder+"/metamodel/UMLUUID.ecore", modifFileName, null, null); }
		else { setFiles(projectSourceFolder, projectSourceFolder+"/metamodel/UML.ecore", modifFileName, null, null); }
		if(!GUI) {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Modify your modif file in order to indicate de operators to be applied");
			System.out.println("Did you finish? y/n");
			String finish = keyboard.nextLine();

			if(finish.equals("y")) {
				CreateModifUML();
				// Siplifying the modif specification
				Minimize(modifFileName);
				refactoredMetamodelPath = Refactor();
			}else {
				// TODO finish != y
			}
			keyboard.close();
			if(coevolution) {
			}
		}else {
			CreateModifUML();
		}
		return refactoredMetamodelPath;
	}


	/**
	 * Refactoring and migration.
	 * 
	 * @param projectSourceFolder Folder of the project.
	 * @param modifSpecificationType Type of the modif specification.
	 * @param isUML True if the metamodel to be refactored is UML. False otherwise.
	 * @param sourceModelPath Path to the source metamodel.
	 * @param withMigrationCodeGeneration True to generate migration code.
	 * @param GUI
	 * @param existingMetamodel Metamodel to be compared with the refactored metamodel.
	 * @throws IOException
	 */
	public void Coevolution(String projectSourceFolder, int modifSpecificationType, boolean isUML,
			String sourceModelPath, boolean withMigrationCodeGeneration, boolean GUI, String existingMetamodel) throws IOException {
		if(isUML) {
			// Refactoring
			String refactoredMetamodelPath = RefactoringUML(projectSourceFolder, modifSpecificationType, true, GUI);
			// Deletion of UUIDs from the refactored metamodel
			//EPackage refactoredMetamodelNoUUID = UtilEMF.removeUUIDAttribute(refactoredMetamodelPath);
			String refactoredMetamodelNoUUIDPath = refactoredMetamodelPath.replace("UUID", "");
			//UtilEMF.saveMetamodel(refactoredMetamodelNoUUID, refactoredMetamodelNoUUIDPath);
			// Comparison between refactored metamodel and target metamodel
			if(existingMetamodel != "") {
				List<Diff> differences = Compare(refactoredMetamodelPath, existingMetamodel);
				if(differences.size() > 0){ 
					for(org.eclipse.emf.compare.Diff diff : differences) {								
						String[] split = diff.toString().split(",");
						if(split[0].contains("ReferenceChangeSpec")) {
							if(split[0].contains("eClassifiers")) {
								System.out.println("Refactored metamodel and target metamodel does not match. -- To correct it:");
								String className = split[1].substring(split[1].lastIndexOf(" "), split[1].length());
								DifferenceKind kind = diff.getKind();
								DifferenceSource source = diff.getSource();
								if(kind.getName().equals("ADD") && source.getName().equals("LEFT")) { System.out.println("  Remove the"+className+ " EClass"); }
								else if(kind.getName().equals("DELETE") && source.getName().equals("LEFT")) { System.out.println("  Do not remove the"+className+ " EClass"); }
							}else {
								System.out.println("Refactored Metamodel and target metamodel match");
								Migrating(projectSourceFolder, sourceModelPath, refactoredMetamodelPath, isUML, withMigrationCodeGeneration);
							}
						}
					}
				}else {
					System.out.println("Refactored Metamodel and target metamodel match");
					Migrating(projectSourceFolder, sourceModelPath, refactoredMetamodelPath, isUML, withMigrationCodeGeneration);	
				}
			}else { Migrating(projectSourceFolder, sourceModelPath, refactoredMetamodelPath, isUML, withMigrationCodeGeneration); }
		} else {
			// Co-evolution if not UML
			//projectSourceFolder = sourceMetamodelPath
			String refactoredMetamodelPath = RefactoringSimple(projectSourceFolder, modifSpecificationType, true, GUI);
			// Comparison between refactored metamodel and target metamodel
			if(existingMetamodel != "") {
				List<Diff> differences = Compare(refactoredMetamodelPath, existingMetamodel);
				getConcreteDifferences(differences);
				Migrating(projectSourceFolder, sourceModelPath, refactoredMetamodelPath, isUML, withMigrationCodeGeneration);			
			}else {
				Migrating(projectSourceFolder, sourceModelPath, refactoredMetamodelPath, isUML, withMigrationCodeGeneration);			
			}
		}
	}


	/**
	 * Checks if the domain metamodel and the tool metamodel fully matches.
	 * 
	 * @return check. True if the refactored and the tool metamodel matches.
	 */
	public boolean Compare(){
		boolean check;
		URI uri1 = URI.createFileURI(refactoredEcoreFile);
		URI uri2 = URI.createFileURI(toolEcoreFile);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();
		Resource resource = resourceSet1.getResource(uri1, true); 
		Resource resource2 = resourceSet2.getResource(uri2, true);
		IComparisonScope scope = new DefaultComparisonScope(resource, resource2, null);
		org.eclipse.emf.compare.Comparison comparison = EMFCompare.builder().build().compare(scope);
		List<org.eclipse.emf.compare.Diff> differences = ((org.eclipse.emf.compare.Comparison) comparison).getDifferences();
		if(differences.size() == 0){ check = true; }
		else{ check = false; }
		return check;
	}


	/**
	 *  Checks if a metamodel fully matches with an existing metamodel.
	 *  
	 *  @param metamodelPath Path to the metamodel to be compared.
	 *  @param existingMetamodelPath Path to the exisitng metamodel.
	 *  @return differences List of differences between the two metamodels.
	 */
	public List<org.eclipse.emf.compare.Diff> Compare(String metamodelPath, String existingMetamodelPath) {
		URI uri1 = URI.createFileURI(metamodelPath);
		URI uri2 = URI.createFileURI(existingMetamodelPath);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();
		Resource resource = resourceSet1.getResource(uri1, true); 
		Resource resource2 = resourceSet2.getResource(uri2, true);
		IComparisonScope scope = new DefaultComparisonScope(resource, resource2, null);
		org.eclipse.emf.compare.Comparison comparison = EMFCompare.builder().build().compare(scope);
		List<org.eclipse.emf.compare.Diff> differences = ((org.eclipse.emf.compare.Comparison) comparison).getDifferences();
		return differences;
	}


	/**
	 * Indicates the classes to be deleted or not, in order to match the two metamodels.
	 * 
	 * @param differences List of differences.
	 * TODO: indicate differences related to attributes and references
	 * @return return true if the metamodel match or false if they do not match.
	 */
	public boolean getConcreteDifferences(List<Diff> differences) {
		boolean match = false;
		if(differences.size() > 0) {
			System.out.println("Refactored metamodel and target metamodel does not match. To correct it:");
			for(org.eclipse.emf.compare.Diff diff : differences) {
				String[] split = diff.toString().split(",");
				if(split[0].contains("ReferenceChangeSpec")) {
					if(split[0].contains("eClassifiers")) {
						String className = split[1].substring(split[1].lastIndexOf(" "), split[1].length());
						DifferenceKind kind = diff.getKind();
						DifferenceSource source = diff.getSource();
						if(kind.getName().equals("ADD") && source.getName().equals("LEFT")) { System.out.println("  Remove the"+className+ " EClass"); }
						else if(kind.getName().equals("DELETE") && source.getName().equals("LEFT")) { System.out.println("  Do not remove the"+className+ " EClass"); }
					}
				}else if(split[0].contains("AttributeChangeSpec")) {
					if(split[0].contains("nsURI")) { System.out.println("  Modify the nsURI"); }
				}
			}
		}else {
			match = true;
			System.out.println("Refactored Metamodel and target metamodel match");
		}
		return match;
	}


	/**
	 * Generate migration specification.
	 * @param sourceModelPath Path of the model to be migrated.
	 * @param sourceMetamodelPath Path of the metamodel to which the model is conform.
	 * @param targetModelPath Path of the migrated model.
	 * @param targetMetamodelPath Path of the metamodel to which the migrated model is conform.
	 * @return migratedModelFile Name of the migrated model.
	 * @throws IOException
	 */
	public String GenerateMigrationSpecification(String sourceModelPath, String sourceMetamodelPath, String targetModelPath, String targetMetamodelPath) throws IOException{	
		migratedModelFile = targetModelPath;
		migrationSpecificationGenerator = new MigrationSpecificationGenerator(theRootEcoreModif, projectFile, sourceModelPath, migratedModelFile);
		migrationFile = migrationSpecificationGenerator.getMigrationFileName();
		System.out.println("[saving] migration specification : ok.");
		return migratedModelFile;
	}


	/**
	 * Generate the Migration specification for the input model.
	 * 
	 * @param inputModel Model to be migrated.
	 * @param keyModelFileName Model with keys.
	 * @param hideClassesList List of hidden classes.
	 * @param flattenClassesList List of flatten classes.
	 * @return migratedModelFile Name of the migrated model.
	 * @throws IOException
	 */
	public String GenerateMigrationSpecification(String inputModel, String keyModelFileName, ArrayList<String> hideClassesList, ArrayList<String> flattenClassesList) throws IOException{	
		Modifications theRootModif = modifIO.LoadModif(modifFile);	
		renamemap = new HashMap<String, Map<String, Map<String, String>>>();
		constructRenameMap();
		if(keyModelFileName.contains(theRootModif.getRootPackageModification().getOldName().toLowerCase())){
			migratedModelFile = inputModel.replace("."+theRootModif.getRootPackageModification().getOldName().toLowerCase(), "_migrated."+theRootModif.getRootPackageModification().getNewName().toLowerCase());
		}
		migrationSpecificationGenerator = new MigrationSpecificationGenerator(superTypesMap, attributesMap, theRootEcoreModif, theRootEcoreModifCopy, 
				theRootModif, projectFile, keyModelFileName, migratedModelFile, hideClassesList, flattenClassesList);
		migrationFile = migrationSpecificationGenerator.getMigrationFileName();
		hiddenInstances = migrationSpecificationGenerator.getHideInstances();
		newReferenceName = migrationSpecificationGenerator.getNewReferencesName();
		referencesToClassMap = migrationSpecificationGenerator.getReferencesToClassMap();
		System.out.println("[saving] migration specification : ok.");
		return migratedModelFile;
	}


	/**
	 * Onward migration of a given input model to a new model conforming with the targeted tool's definition domain.
	 * 
	 * @return migrt Migration.
	 */
	public MigrationRoundtrip Migration() {
		MigrationRoundtrip migrt = null;
		Migration migration = (Migration) UtilEMF.loadModel(this.migrationFile, MigrationPackage.eINSTANCE);
		migrt = new MigrationRoundtrip(migration);
		migratedModel = migrt.onwardMigration();
		return migrt;
	}


	/**
	 * Onward migration of a given input model to a new model conforming with the targeted tool's definition domain.
	 * 
	 * @param newReferenceNameMap Map of references names.
	 * @param renameMap Map of classes and attributes names. 
	 * @return migrt Migration.
	 */
	public MigrationRoundtrip Migration(Map<String,String> newReferenceNameMap, Map<String, Map<String, Map<String, String>>> renameMap) {
		MigrationRoundtrip migrt = null;
		try {
			Migration migration = (Migration) UtilEMF.loadModel(this.migrationFile, MigrationPackage.eINSTANCE);
			Map<String, Map<String, ArrayList<ArrayList<String>>>>  hideMap = new HashMap<String, Map<String, ArrayList<ArrayList<String>>>>();
			hideMap = createHideMap(migration);
			migrt = new MigrationRoundtrip(migration);
			EObject migratedModel;
			if(hasHide(migration)){ 
				migratedModel = migrt.onwardMigrationHide(migration, newReferenceNameMap, renameMap); }
			else{ 
				//migratedModel = migrt.onwardMigration(); 
				migratedModel = migrt.onwardMigrationRename(renameMap);
			}
			migrt.serializeMigratedModel();
			System.out.println("[saving] migrated file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
		return migrt;
	}


	/**
	 * Onward migration of a given input model to a new model conforming with the targeted tool's definition domain.
	 * 
	 * @param newReferenceNameMap Map of references names.
	 * @param renameMap Map of classes and attributes names. 
	 * @param migrationFile Name of the migration specification.
	 * @return migrt Migration.
	 */
	public MigrationRoundtrip Migration(Map<String,String> newReferenceNameMap, Map<String, Map<String, Map<String, String>>> renameMap, String migrationFile) {
		MigrationRoundtrip migrt = null;
		try {
			migration = (Migration) UtilEMF.loadModel(migrationFile, MigrationPackage.eINSTANCE);
			Map<String, Map<String, ArrayList<ArrayList<String>>>>  hideMap = new HashMap<String, Map<String, ArrayList<ArrayList<String>>>>();
			hideMap = createHideMap(migration);
			migrt = new MigrationRoundtrip(migration);
			EObject migratedModel;
			if(hasHide(migration)){ migratedModel = migrt.onwardMigrationHide(migration, newReferenceNameMap, renameMap); }
			else{ 
				//migratedModel = migrt.onwardMigration(); 
				migratedModel = migrt.onwardMigrationRename(renameMap);
			}
			migrt.serializeMigratedModel();
			System.out.println("[saving] migrated file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
		return migrt;
	}


	/**
	 * Migration of a model.
	 * 
	 * @param projectSourceFolder Folder containing metamodels and models.
	 * @param sourceModelPath Path of the model to be migrated.
	 * @param refactoredMetamodelPath Path of the refactored metamodel.
	 * @param isUML True if the metamodel is UML. False otherwise.
	 * @param withMigrationCodeGeneration True if the migration code has to be generated. False otherwise.
	 * @throws IOException
	 */
	public void Migrating(String projectSourceFolder, String sourceModelPath, String refactoredMetamodelPath, boolean isUML, boolean withMigrationCodeGeneration) throws IOException {
		String sourceModelUUIDPath;
		String sourceMetamodelUUIDPath;
		String migratedModelPath;
		String migratedModelNoUUIDPath;
		EObject modelUUID;
		EObject modelUUID2;
		String migrationSpecificationName;
		EObject migratedModel;
		if(isUML) {
			sourceModelUUIDPath = sourceModelPath.replace("."+theRootEcoreModif.getRoot().getModif().getOldName(), ".umluuid.xmi");
			sourceMetamodelUUIDPath = theRootEcoreModif.getRoot().getModif().getOldURIName();
			migratedModelPath = sourceModelPath.replace("."+theRootEcoreModif.getRoot().getModif().getOldName(), "_migrated."+theRootEcoreModif.getRoot().getModif().getNewName().toLowerCase()+".xmi");
			migratedModelNoUUIDPath = migratedModelPath.replace("uuid", "");
			//String refactoredMetamodelPath = theRootEcoreModif.getRoot().getModif().getNewURIName();

			// Adding UUIDs to the source model
			//modelUUID = UtilEMF.changeMetamodel(UtilEMF.loadModel(sourceModelPath, UMLPackage.eINSTANCE), projectSourceFolder+"/metamodel/UMLUUID.ecore");
			//	modelUUID2 = UtilEMF.addUUIDValues(modelUUID);
			//	UtilEMF.saveModel(modelUUID2, sourceModelUUIDPath);			

			// Migration Specification generation
			migrationSpecificationName = GenerateMigrationSpecification(sourceModelUUIDPath, sourceMetamodelUUIDPath, migratedModelPath, refactoredMetamodelPath);

			if(withMigrationCodeGeneration) {
				// Migration code generation
				GenerateMigrationCode(projectSourceFolder, migrationSpecificationName.replace("\\", "/"), migratedModelNoUUIDPath.replace("\\", "/"), isUML, refactoredMetamodelPath.replace("\\", "/"));
			}else { 
				// Migration execution
				migrt = Migration();
				migrt.serializeMigratedModel();
				System.out.println("[saving] migrated file : ok.");	

				// Deletion of UUIDs
				//		migratedModel = UtilEMF.changeMetamodel(UtilEMF.removeUUIDValues(getMigratedModel()), UMLPackage.eINSTANCE);	

				// Serialisation of the migrated model
				//	UtilEMF.saveModel(migratedModel, migratedModelNoUUIDPath);
			}
		}else {
			// is not UML
			sourceModelUUIDPath = sourceModelPath.replace("."+theRootEcoreModif.getRoot().getModif().getOldName().toLowerCase()+".xmi", "."+theRootEcoreModif.getRoot().getModif().getOldName().toLowerCase()+"uuid.xmi");
			sourceMetamodelUUIDPath = theRootEcoreModif.getRoot().getModif().getOldURIName();
			migratedModelPath = sourceModelPath.replace("."+theRootEcoreModif.getRoot().getModif().getOldName().toLowerCase(), "_migrated."+theRootEcoreModif.getRoot().getModif().getNewName().toLowerCase());
			migratedModelNoUUIDPath = migratedModelPath.replace("uuid", "");

			// Adding UUIDs to the source model
			//		modelUUID = UtilEMF.changeMetamodel(UtilEMF.loadModel(sourceModelPath, UMLPackage.eINSTANCE), projectSourceFolder.replace(".ecore", "UUID.ecore"));
			//	modelUUID2 = UtilEMF.addUUIDValues(modelUUID);
			//	UtilEMF.saveModel(modelUUID2, sourceModelUUIDPath);	

			// Migration Specification generation
			migrationSpecificationName = GenerateMigrationSpecification(sourceModelUUIDPath, sourceMetamodelUUIDPath, migratedModelPath, refactoredMetamodelPath);		

			if(withMigrationCodeGeneration) {
				File mf = new File(projectSourceFolder); // Metamodel folder
				File pf = new File(mf.getParent()); // project source folder
				// Migration code generation
				GenerateMigrationCode(pf.getParent(), migrationSpecificationName.replace("\\", "/"), migratedModelNoUUIDPath.replace("\\", "/"), isUML, refactoredMetamodelPath.replace("\\", "/"));
			}else {
				// Migration execution
				migrt = Migration();
				migrt.serializeMigratedModel();
				System.out.println("[saving] migrated file : ok.");	

				// Deletion of UUIDs
				//migratedModel = UtilEMF.changeMetamodel(UtilEMF.removeUUIDValues(getMigratedModel()), refactoredMetamodelPath);	

				// Serialisation of the migrated model
				//UtilEMF.saveModel(migratedModel, migratedModelNoUUIDPath);
			}
		}
	}


	/**
	 * Reverse migration of a processed model.
	 * 
	 * @param migrt migration specification.
	 * @return migration Migration object.
	 */
	public MigrationRoundtrip ReverseMigration(MigrationRoundtrip migrt){
		try {
			this.migration = (Migration) UtilEMF.loadModel(this.migrationFile, MigrationPackage.eINSTANCE);
			EObject toolOutputModel = UtilEMF.loadModel(this.toolOutputModelFile, URI.createURI(migration.getOutputMetamodelURI()).path());
			String reversedModelName = null;
			if(isUML){
				String inputmodelName = migration.getInputModelURI();
				String[] strArray = inputmodelName.split("\\.");
				String modelName = strArray[0];
				reversedModelName = (inputmodelName.replace(modelName, modelName+"_reversed").replace("file:",""));
			}else{
				String inputmodelName = migration.getInputModelURI();
				String[] strArray = inputmodelName.split("\\.");
				String metamodelName = strArray[1];
				String[] strArrayTool = toolOutputModelFile.split("\\.");
				String toolPutputModelName = strArrayTool[0];
				String metamodelToolName = strArrayTool[1];
				reversedModelName = toolOutputModelFile.replace(toolPutputModelName, toolPutputModelName+"_reversed").replace(metamodelToolName, metamodelName);			
			}
			Map<String,Map<String,Map<String,String>>> inversedMap = reversedMap(renamemap);
			if(hasHide(migration)){	UtilEMF.saveModel(migrt.reverseMigration(toolOutputModel, inversedMap, migration), reversedModelName); }
			else{ UtilEMF.saveModel(migrt.reverseMigration(toolOutputModel), reversedModelName); }
			System.out.println("[saving] reversed file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
		return migrt;
	}


	/**
	 * Recontextualization by keys of a reversed model.
	 * 
	 * @param migrt Migration object.
	 */
	public void Recontextualization(MigrationRoundtrip migrt){
		try {
			String recontextualizedKeysModelFile = null;
			String inputmodelName = migration.getInputModelURI();
			File f = new File(inputmodelName);
			String[] strArray = inputmodelName.split("\\.");
			String metamodelName = strArray[1];
			String[] strArrayTool = toolOutputModelFile.split("\\.");
			String toolPutputModelName = strArrayTool[0];
			String metamodelToolName = strArrayTool[1];
			recontextualizedKeysModelFile = toolOutputModelFile.replace(toolPutputModelName, toolPutputModelName+"_recontextkey").replace(metamodelToolName, metamodelName);	
			UtilEMF.saveModel(migrt.recontextualizationKey(), recontextualizedKeysModelFile);
			System.out.println("[saving] recontextualized by key file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
		Graph g = (Graph) UtilEMF.loadModel(graphFile, DependencyPackage.eINSTANCE);
		try {
			String inputmodelName = migration.getInputModelURI();
			File f = new File(inputmodelName);
			String[] strArray = inputmodelName.split("\\.");
			//recontextualizedGraphModelFile = (inputmodelName.replace(modelName, modelName+"_recontextgraph").replace("file:",""));
			recontextualizedFinalModelFile = (toolOutputModelFile.replace("_migrated", "_recontextgraph"));
			String[] strArrayTool = toolOutputModelFile.split("\\.");
			String toolPutputModelName = strArrayTool[0];
			String metamodelToolName = strArrayTool[1];
			String metamodelName = strArray[1];
			recontextualizedGraphModelFile = toolOutputModelFile.replace(toolPutputModelName, toolPutputModelName+"_recontextgraph").replace(metamodelToolName, metamodelName);	
			UtilEMF.saveModel(migrt.recontextualizationGraph(g),recontextualizedGraphModelFile);
			System.out.println("[saving] recontextualized by graph file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
	}


	/**
	 * Recontextualization by graph of a recontextualized by graph model.
	 * 
	 * @param migrt Migration object.
	 * @return
	 */
	public MigrationRoundtrip RecontextualizationGraph(MigrationRoundtrip migrt) {
		Graph g = (Graph) UtilEMF.loadModel(graphFile, DependencyPackage.eINSTANCE);
		try {
			UtilEMF.saveModel(migrt.recontextualizationGraph(g),  recontextualizedGraphModelFile);
			System.out.println("[saving] recontextualized by graph file : ok.");	
		} catch (IOException e) { e.printStackTrace(); }
		return null;
	}


	/**
	 * Migration code generation.
	 * 
	 * @param projectSourceFolder Folder containing models and metamodels.
	 * @param migrationSpecificationName Name of the migration specification.
	 * @param migratedModelNoUUIDPath Path of the migrated model without identifiers.
	 * @throws IOException
	 */
	public void GenerateMigrationCode(String projectSourceFolder, String migrationSpecificationName, String migratedModelNoUUIDPath, boolean isUML, String refactoredMetamodelPath) throws IOException {
		File fout = new File(projectSourceFolder+"/srcgen/code/MigrationCode.java");
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		bw.write("package code;\n");
		bw.newLine();
		bw.write("import migration.Migration;");
		bw.newLine();
		bw.write("import migration.MigrationPackage;");
		bw.newLine();
		bw.write("import migration.tools.MigrationRoundtrip;");
		bw.newLine();
		bw.write("import migration.tools.UtilEMF;\n");
		bw.newLine();
		bw.write("import org.eclipse.emf.ecore.EObject;");
		bw.newLine();
		//bw.write("import org.eclipse.emf.ecore.EPackage;\n");
		bw.newLine();
		if(isUML) {
			bw.write("import org.eclipse.uml2.uml.UMLPackage; \n");
			bw.newLine();
		}
		bw.write("public class MigrationCode { \n");
		bw.write("    public static void main(String[] args) { \n");
		bw.write("      try {");
		bw.newLine();
		bw.write("          MigrationRoundtrip migrt = null;");
		bw.newLine();
		bw.write("          String migrationSpecificationFile = \""+migrationSpecificationName+"\";");
		bw.newLine();
		bw.write("          Migration migration = (Migration) UtilEMF.loadModel(migrationSpecificationFile, MigrationPackage.eINSTANCE);");
		bw.newLine();
		bw.write("          // Migration execution");
		bw.newLine();
		bw.write("          migrt = new MigrationRoundtrip(migration);");
		bw.newLine();
		bw.write("          // Migrated model with UUID \n");
		bw.write("          EObject migratedModelUUID = migrt.onwardMigration();");
		bw.newLine();
		bw.write("			// Serialisation of the migrated model with UUID \n");
		bw.write("          migrt.serializeMigratedModel();");
		bw.newLine();
		bw.write("          // Deletion of UUIDs");
		bw.newLine();
		if(isUML) {
			bw.write("		    EObject migratedModel = UtilEMF.changeMetamodel(UtilEMF.removeUUIDValues(migratedModelUUID), UMLPackage.eINSTANCE); \n");
		}else {
			bw.write("		    EObject migratedModel = UtilEMF.changeMetamodel(UtilEMF.removeUUIDValues(migratedModelUUID),\""+ refactoredMetamodelPath+ "\"); \n");
		}
		bw.write("         // Serialisation of the migrated model \n");
		bw.write(" 			UtilEMF.saveModel(migratedModel, "+"\""+migratedModelNoUUIDPath+"\"); \n");
		bw.write(" 			System.out.println(\"[saving] migrated file : ok.\"); \n");
		bw.write("      } catch (Exception ioe) {");
		bw.newLine();
		bw.write("          ioe.printStackTrace();");
		bw.newLine();
		bw.write("          return;");
		bw.newLine();
		bw.write("      }");
		bw.newLine();
		bw.newLine();
		bw.write("    }");
		bw.newLine();
		bw.newLine();
		bw.write("}");
		bw.newLine();
		bw.close();

	}


	/**
	 * Add deleted references to the migration specification.
	 * 
	 * @param migration Migration specification to be updated.
	 */
	public void addDeletedReferences(Migration migration)
	{
		migrationSpecificationGenerator.addDeleteReferences(migration);
	}


	/**
	 * Clean the custom migration specification.
	 * 
	 * @param migration Migration specification to be updated.
	 */
	public void cleanMigrationSpecification(Migration migration){
		migrationSpecificationGenerator.cleanMigrationSpecification(migration);
	}


	/**
	 * Update the migration specification.
	 * 
	 * @param instanceUUID Instance of the migration specification.
	 * @param value Value to set the deletion attribute.
	 * @param migration Migration specification.
	 * @return newMigration Updated migration specification.
	 */
	public Migration modifyInstance(String instanceUUID, boolean value, Migration migration)
	{
		Migration newMigration = null;
		try { newMigration = migrationSpecificationGenerator.modifyInstance(instanceUUID, value, migration); } 
		catch (IOException e) { e.printStackTrace(); }
		return newMigration;
	}


	/**
	 * Return the name of the by default modif specification
	 * @return modifFileName Name of the modif file.
	 */
	public String getModifFileName() {
		return modifFileName;
	}


	/**
	 * Return the name of the refactored metamodel without keys.
	 * @return refactoredWithoutKFileName Name of the refactored metamodel.
	 */
	public String getRefactoredWithoutKFileName(){
		return refactoredWithoutKFileName;
	}


	/**
	 * Get the map relating old name and new name of references.
	 * 
	 * @return newReferenceName Map of references names.
	 */
	public Map<String,String> getNewReferencesNameMap(){
		return this.newReferenceName;
	}


	/**
	 * Get the name of the migrated model.
	 * 
	 * @return migratedModelFile Name of the migrated model.
	 */
	public String getMigratedModelFileName(){
		return migratedModelFile;
	}


	/**
	 * Get the name of the migration specification file.
	 * 
	 * @return migrationFile Name of the migration specification.
	 */
	public String getMigrationFileName(){
		return migrationFile;
	}


	/**
	 * Get the name of the recontextualized model.
	 * 
	 * @return Name of the recontextualized model.
	 */
	public String getRecontexGraphFileName(){
		return recontextualizedFinalModelFile;
	}


	/**
	 * Get the list of hidden classes.
	 * 
	 * @return hideClassList List of classes marked with hide operator.
	 */
	public ArrayList<String> getHideClassList(){
		return hideClassList;
	}


	/**
	 * Get the list of flattened classes.
	 * 
	 * @return flattenClassList List of classes marked with flatten operator.
	 */
	public ArrayList<String> getFlattenClassList(){
		return flattenClassList;
	}


	/**
	 * Get the rename map.
	 * 
	 * @return renamemap Map of old and new names.
	 */
	public Map<String, Map<String, Map<String, String>>>  getRenameMap(){
		return renamemap;
	}


	/**
	 * Construct a map relating oldname and new name of all elements of a metamodel.
	 */
	public void constructRenameMap(){
		HashMap<String, Map<String, Map<String, String>>>  RenameMap = new HashMap<String, Map<String, Map<String, String>>>();
		for( EclassModif  ecm : theRootEcoreModif.getAllClassModifications()){
			String oldNameClass = ecm.getModif().getOldName();
			String newNameClass = ecm.getModif().getNewName();
			Map <String, String> featuresNameMap = new HashMap<String, String>();
			for(EattributeModif att : ecm.getAllAttributes()){
				String oldNameAtt = att.getModif().getOldName();
				String newNameAtt = att.getModif().getNewName();
				featuresNameMap.put(oldNameAtt, newNameAtt);
			}
			for(EreferenceModif ref : ecm.getAllReferences()){
				String oldNameRef = ref.getModif().getOldName();
				String newNameRef = ref.getModif().getNewName();
				featuresNameMap.put(oldNameRef, newNameRef);
			}
			Map<String, Map<String, String>> tempMap = new HashMap<String, Map<String,String>>();
			tempMap.put(newNameClass, featuresNameMap);
			renamemap.put(oldNameClass, tempMap);
		}
	}


	/**
	 * Build a map with all references going to an instance.
	 * @param rootPackage Metamodel to which the model is conform.
	 * @return referencesToInstanceMap Map relating an instance with all reference going to itself
	 */
	public Map<String, ArrayList<String>> buildMapReferencesToInstance(EPackage rootPackage){
		Map<String, ArrayList<String>> referencesToInstanceMap = null ;
		referencesToInstanceMap = UtilEMF.buildMapReferencesToInstance(UtilEMF.loadModel(originalModelFile, originalEcoreFile), rootPackage);
		return referencesToInstanceMap;
	}


	/**
	 * Build a map of supertypes.
	 * @param rootEcoreModif 
	 */
	public void buildSuperTypesMap(RootEcoreModif rootEcoreModif){
		superTypesMap = new HashMap<String, ArrayList<String>>();
		attributesMap = new HashMap<String, ArrayList<String>>();
		for( EClassifier c : rootEcoreModif.getRoot().getEcore().getEClassifiers()){
			ArrayList<String> supertypes = new ArrayList<String>();
			ArrayList<String> attributes = new ArrayList<String>();
			if(c instanceof EClass){
				for(EAttribute a : ((EClass)c).getEAttributes()){ attributes.add(a.getName()); }
				attributesMap.put(c.getName(), attributes);
				for(EClass st : ((EClass)c).getEAllSuperTypes()){ supertypes.add(st.getName()); }
				superTypesMap.put(c.getName(), supertypes);
			}
		}
	}


	/**
	 * Fills the map of instances whose EClasses are hidden.
	 * 
	 * @param migration Migration specification.
	 * @return hidemap Map of hidden classes.
	 */
	public Map<String, Map<String, ArrayList<ArrayList<String>>>> createHideMap(Migration migration){
		hidemap = new HashMap<String, Map<String, ArrayList<ArrayList<String>>>>();
		for(Instance instance : migration.getInstances()){
			if(!instance.getDerived().isEmpty()){
				Map<String, ArrayList<ArrayList<String>>> derivedReferences = new HashMap<String, ArrayList<ArrayList<String>>>();
				if((instance.getDerived()).size() ==  1){
					DerivedReference derived = instance.getDerived().get(0);
					String newReferenceName = derived.getNewReferenceName();
					ArrayList<ArrayList<String>> allDerived = new ArrayList<ArrayList<String>>();
					for(ReferencePath refPath : derived.getPath()){
						String refName = refPath.getReferenceName();
					}
					/*	for( DerivedReference derivedRef : derived.getDerivedReferences()){
						String refName = derivedRef.getReferenceName();
						String target = derivedRef.getTarget().getUUID();
						ArrayList<String> derivedR = new ArrayList<String>();
						derivedR.add(refName);
						derivedR.add(target);
						allDerived.add(derivedR);	
					}*/
					//derivedReferences.put(newReferenceName, allDerived);
				}
				hidemap.put(instance.getUUID(), derivedReferences);
			}
		}
		return hidemap;
	}


	/**
	 * Reversed hideMap for reverse migration.
	 * 
	 * @param map 
	 * @return map
	 */
	public Map<String, Map<String, ArrayList<ArrayList<String>>>> reversedHideMap(Map<String, Map<String, ArrayList<ArrayList<String>>>> map){
		Map<String, Map<String, ArrayList<ArrayList<String>>>> reversedMap = new HashMap<String, Map<String,ArrayList<ArrayList<String>>>>();		
		Map<String, ArrayList<ArrayList<String>>> derivedMap = new HashMap<String, ArrayList<ArrayList<String>>>();
		Map<String, ArrayList<ArrayList<String>>> reversedDerivedMap = new HashMap<String, ArrayList<ArrayList<String>>>();
		String key;
		for (Entry<String, Map<String, ArrayList<ArrayList<String>>>> e: map.entrySet()) {
			key = e.getKey();
			derivedMap = e.getValue();
			ArrayList<ArrayList<String>> derivedReferences = new ArrayList<ArrayList<String>>();
			String newReferenceName = null;
			for (Entry<String, ArrayList<ArrayList<String>>> entry: derivedMap.entrySet()) {
				newReferenceName = entry.getKey();
				derivedReferences = entry.getValue();
				ArrayList<ArrayList<String>> derivedRef = new ArrayList<ArrayList<String>>();
				String referenceName = null;
				for( ArrayList<String> dr : derivedReferences){
					referenceName = dr.get(0);
					String target = dr.get(1);
					ArrayList<String> newList = new ArrayList<String>();
					newList.add(newReferenceName);
					newList.add(target);
					derivedRef.add(newList);
					reversedDerivedMap.put(referenceName, derivedRef);
				}	
			}
			reversedMap.put(key, reversedDerivedMap);
		}
		return reversedMap;
	}


	/**
	 * Reversed names map for reverse migration
	 * 
	 * @param map
	 * @return map
	 */
	public Map<String, Map<String, Map<String, String>>> reversedMap(Map<String, Map<String,Map<String, String>>> map){
		Map<String, Map<String,Map<String, String>>> result = new HashMap<String, Map<String,Map<String, String>>>();
		Map<String, String> invfeaturesMap = new HashMap<String, String>();
		String key;
		Map<String, Map<String, String>> value = new HashMap<>();
		for (Entry<String, Map<String, Map<String, String>>> e: map.entrySet()) {
			key = e.getKey();
			value = e.getValue();
			String k = null;
			Map<String,String> v;
			Map<String, Map<String,String>> invertedValue = new HashMap<String, Map<String,String>>();
			for (Entry<String, Map<String,String>> ee: value.entrySet()) {
				k = ee.getKey();
				v = ee.getValue();
				for (Entry<String, String> entry : v.entrySet()){ invfeaturesMap.put(entry.getValue(), entry.getKey()); }
				invertedValue.put(key, invfeaturesMap);
			}
			result.put(k, invertedValue);
		}
		return result;
	}


	/**
	 * Build the list of classes marked with the hide operator.
	 * 
	 * @param rootEcoreModif Root ecore.
	 */
	public void buildHideList(RootEcoreModif rootEcoreModif){	
		hideClassList = new ArrayList<String>();
		for( ClassModification ecm : rootEcoreModif.getRoot().getModif().getClassModification()){
			if(ecm.isHide()){
				if(hasSuperTypes(rootEcoreModif, ecm)){ hideClassList.add(ecm.getOldName()); }
			}
		}
	}


	/**
	 * Build the list of classes marked with the flatten operator.
	 * 
	 * @param rootEcoreModif Root ecore.
	 */
	public void buildFlattenList(RootEcoreModif rootEcoreModif){	
		flattenClassList = new ArrayList<String>();
		for( ClassModification ecm : rootEcoreModif.getRoot().getModif().getClassModification()){
			if(ecm.isFlatten()){ 
				if(hasSuperTypes(rootEcoreModif, ecm)){ flattenClassList.add(ecm.getOldName()); }
			}
		}
	}


	/**
	 * Check if a class has supertypes.
	 * 
	 * @param rootEcoreModif Root ecore.
	 * @param ecm Class to be checked.
	 * @return result True if the class has supertypes. False otherwise.
	 */
	private boolean hasSuperTypes(RootEcoreModif rootEcoreModif, ClassModification ecm){
		boolean result = false;
		for(EClassifier ec : rootEcoreModif.getRoot().getEcore().getEClassifiers()){
			if(!((EClass)ec).getEAllSuperTypes().isEmpty()){
				if(ec.getName().equals(ecm.getOldName())){
					result = true;
					break;
				}
			}
		}
		return result;
	}


	/**
	 * Check if the class of an instance is hidden.
	 * 
	 * @param migration Migration specification.
	 * @return hide True if the class is hidden. False otherwise.
	 */
	public boolean hasHide(Migration migration){
		boolean hide = false;
		for(Instance i : migration.getInstances()){
			if(!i.getDerived().isEmpty()){
				hide = true;
				break;
			}
		}
		return hide;
	}


	/**
	 * Verify dependences to external ecores.
	 * 
	 * @param externalPackages List of packages.
	 * @return depends
	 */
	public boolean dependingOnExternalEcore(Set<EPackage> externalPackages) {
		boolean depends = false;
		if(externalPackages.size() == 0) {
			// The source metamodel does not depend on other ecores
			depends = false;
		}else if(externalPackages.size() == 1) {
			// The source metamodel depends on one external ecore
			for (Iterator<EPackage> it = externalPackages.iterator(); it.hasNext(); ) {
				EPackage rel = it.next();
				if(rel.getName().equals("ecore")) {
					depends = false;
				}
			}
		}else {
			depends = true;
		}
		return depends;
	}


	/**
	 *  Add schema location to a xmi file.
	 * @param inputfile Input file.
	 * @param finalModelFile Model with the schema location.
	 * @param URI URI of the metamodel.
	 * @throws IOException
	 */
	public void addSchemaLocation(String inputfile, String finalModelFile, String URI, String metamodelName) throws IOException {
		FileReader fr=new FileReader(inputfile);
		BufferedReader br=new BufferedReader(fr);

		File fout = new File(finalModelFile);
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		String line=br.readLine();

		while (line!=null) {
			String xmi = "xmlns:xmi=\"http://www.omg.org/XMI\"";
			//String nom = "Statechart.ecore";
			if(line.contains(xmi)){
				String newLine = line.replace(xmi, "xsi:schemaLocation=\""+ URI + " ../metamodel/"+ metamodelName +"\""+ " "+xmi);
				bw.write(newLine);
			}else{ bw.write(line); }
			bw.newLine();  
			line=br.readLine();
		} 
		br.close();
		fr.close();  
		bw.close();
	}

}
