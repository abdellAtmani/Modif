package ecoremodif.utils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import modif.*;
import uiModif.ihmController;
import ecoremodif.*;
import ecoremodif.impl.RootEcoreModifImpl;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import xtext.XModifStandaloneSetup;

import com.google.inject.Injector;


/**
 *  class to build a RootEcoreModif object from Modif and Ecore files
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @author Mickaël kerboeuf, Jean-Philippe Babau
 *  22/11/2013
 */

public class ModifIO {

	// EcoreModif object
	private RootEcoreModif theRootEcoreModif;

	
	/**
	 * Get the root EcoreModif object.
	 * @return theRootEcoreModif The root EcoreModif object.
	 */
	public RootEcoreModif getEcoreModif() {	
		return theRootEcoreModif; 
	}	
	

	/**
	 * Build an ecore model from an ecore file.
	 * @param inputFile ecore file name.
	 * @return ecore model.
	 */
	public EPackage LoadEcore(String inputFile) {

		// EMF resource set
		ResourceSet resourceSet = new ResourceSetImpl();

		// register a factory (XMI) :
		resourceSet
		.getResourceFactoryRegistry()
		.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// register the Epackage root :
		resourceSet.getPackageRegistry()
		.put( EcorePackage.eNS_URI, EcorePackage.eINSTANCE);

		// uri of ecore file
		File file = new File(inputFile);
		URI uri = file.isFile() ?
				URI.createFileURI(file.getAbsolutePath())
				: URI.createURI(inputFile);

				// load the file
				Resource resource = resourceSet.getResource(uri, true);

				System.out.println("[loading] file "+ file.getName() + ": ok.");

				// return the EPakage root
				return ((EPackage) resource.getContents().get(0));
	}

	/**
	 * Utilitary fonction for serialise and deserialise a modif file or an ecore file. 
	 * @param inputFile File to be loaded.
	 * @return Root object of the given file.
	 */
	public Modifications LoadModif(String inputFile) {

		Injector injector = new XModifStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		File file = new File(inputFile);
		URI uri = URI.createFileURI(file.getAbsolutePath());

		// register the S2PMiner EPackage root
		resourceSet.getPackageRegistry().put( ModifPackage.eNS_URI, ModifPackage.eINSTANCE );

		XtextResource resource = (XtextResource) resourceSet.getResource(uri, true);

		System.out.println("[loading] file "+ file.getName() + ": ok.");

		return ((Modifications) resource.getContents().get(0));
	}


	/**
	 * ecore and modif files reading to build theRootEcoreModif.
	 * @param inputEcoreFile Ecore package file.
	 * @param modifFile Modif specification file.
	 */
	public void setModifIO(String inputEcoreFile, String modifFile) {

		Modifications theRootModif  = LoadModif(modifFile);
		EPackage theRootEcore       = LoadEcore(inputEcoreFile);

		this.theRootEcoreModif      = null;
		this.theRootEcoreModif      = new RootEcoreModifImpl(theRootEcore,theRootModif);
	}


	/**
	 * Builds the RootEcoreModif when the ecore package and the modif specification are given
	 * @param theRootEcore
	 * @param theRootModif
	 */
	public void setModifIO(EPackage theRootEcore, Modifications theRootModif) {
		this.theRootEcoreModif = new RootEcoreModifImpl(theRootEcore, theRootModif);
	}


	/**
	 * Save the root object of the input metamodel into a file indicated as paramerter.
	 * @param outputEcoreFile File to be created.
	 * @throws IOException 
	 */
	public void save(String outputEcoreFile) throws IOException {

		// Set of EMF ressource to fill and save
		ResourceSet resourceSet = new ResourceSetImpl();

		// Save a generic (XMI) objects factory
		resourceSet.getResourceFactoryRegistry()
		.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Designate or create the output files
		File file = new File(outputEcoreFile);
		URI uriOut = URI.createFileURI(file.getAbsolutePath());

		// Create a resource
		Resource resource = resourceSet.createResource(uriOut);

		// Add the root object of the output metamodel to the ressource
		resource.getContents().add(this.theRootEcoreModif.getRoot().getEcore());

		// Saving
		resource.save(Collections.EMPTY_MAP);

		System.out.println("[saving] file "+ file.getName() + ": ok.");
	}


	/**
	 * Save a modif specification in a file.
	 * @param modif Modif specification.
	 * @param outputFile Name of the output file.
	 * @throws IOException
	 */
	public static void SaveModif(Modifications modif, String outputFile) throws IOException{

		Injector injector = new XModifStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);

		File file = new File(outputFile);

		URI uri = URI.createFileURI(file.getAbsolutePath());

		// register the Modif EPackage root
		resourceSet.getPackageRegistry().put( ModifPackage.eNS_URI, ModifPackage.eINSTANCE);

		XtextResource resource = (XtextResource) resourceSet.getResource(uri, true);

		resource.getContents().clear();

		resource.getContents().add(modif);

		resource.save(Collections.EMPTY_MAP);

		System.out.println("[saving] file "+ file.getName() + ": ok.");
	}

}
