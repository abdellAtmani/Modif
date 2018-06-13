package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import migrationRoundtrip.ModifSpecification;
import modif.Modifications;
import ecoremodif.utils.ModifIO;

public class IOModifSpecification {

	// PUBLIC ******************************************************************************

	/**
	 * Load a modif specification located a the given path.
	 * @param modifSpecificationPath Path of the modif specification.
	 * @return modif Loaded modif specification.
	 */
	public static Modifications loadModifSpecification(String modifSpecificationPath) {
		Modifications modif = null;
		File modifFile = new File(modifSpecificationPath);
		if(modifFile.exists()){
		ModifIO modifIO = new ModifIO();
		modif = modifIO.LoadModif(modifSpecificationPath);	
		ModifSpecification.setModifSpecification(modif);
		}else{
			System.err.println("[Loading] file "+modifSpecificationPath+" : file does not exist.");
			System.exit(1);
		}
		return modif;
	}

	/**
	 * Save a modif specification.
	 * @param modifSpecification Modif specification to be saved.
	 * @param modifPath Path to save the modif specification.
	 */
	public static void saveModifSpecification(Modifications modifSpecification, String modifPath) {
		try {
			OutputStream f = new FileOutputStream(modifPath) ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			ModifIO.SaveModif(modifSpecification, modifPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
