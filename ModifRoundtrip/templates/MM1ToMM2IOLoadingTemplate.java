	/**
	 * Loading a %%%SOURCEMM file whose root is an instance of %%%COMPLETEJAVANAME 
	 * @return loaded root object
	 */
	public %%%COMPLETEJAVANAME load%%%COMPLETEECLASSNAME( String inputFile ) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet
		.getResourceFactoryRegistry()
		.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(%%%SOURCEEPACKAGE.%%%SOURCEMMPackage.eNS_URI, %%%SOURCEEPACKAGE.%%%SOURCEMMPackage.eINSTANCE);

		File file = new File(inputFile);
		URI uri = file.isFile() ?
				  URI.createFileURI(file.getAbsolutePath())
				: URI.createURI(inputFile);
		Resource resource = resourceSet.getResource(uri, true);
		
		System.out.println("[loading] file "+ file.getName() + ": ok.");
		return (%%%COMPLETEJAVANAME) resource.getContents().get(0);
	}
