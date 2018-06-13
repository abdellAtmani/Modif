	/**
	 * Saving an instance of a %%%COMPLETEJAVANAME from %%%TARGETEPACKAGE into the output file
	 * @param val object to be saved
	 * @throws IOException 
	 */
	public void save(%%%COMPLETEJAVANAME val, String outputFile) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry()
		.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		File file = new File(outputFile);
		URI uriOut = URI.createFileURI(file.getAbsolutePath());
		
		Resource resource = resourceSet.createResource(uriOut);
		if (val != null) resource.getContents().add(val);
		resource.save(Collections.EMPTY_MAP);

		System.out.println("[saving] file "+ file.getName() + ": ok.");
	}
