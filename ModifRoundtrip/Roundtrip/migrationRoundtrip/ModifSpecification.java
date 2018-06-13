package migrationRoundtrip;

import modif.ClassModification;
import modif.Modifications;
import modif.PackageModification;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import utils.EraseAllModifFactory;
import utils.NoModifFactory;
import ecoremodif.utils.ModifIO;

/**
 * Utilitary class for handling modif specifications.
 * Source metamodel has UUIDs.
 * This class gathers useful functions to create and modify modif specifications
 * 
 * @author P. Vallejo
 *
 */

public class ModifSpecification {

	// ATTRIBUTES *******************************************************************************

	private static EPackage sourceMetamodel;
	private static Modifications modifSpecification;
	private static int modifType;

	// PRIVATE **********************************************************************************

	/**
	 * Remove the class containing UUIDs from the modif specification.
	 * @return modifSpecificationNoUUID Modif specification without UUIDs.
	 */
	private static Modifications removeUUIDFromSpecification(){
		Modifications modifSpecificationNoUUID = modifSpecification;
		ClassModification UUIDClass = null;
		PackageModification pm = modifSpecificationNoUUID.getRootPackageModification();
		for( ClassModification cm : pm.getClassModification()){
			if(cm.getOldName().equals("UUIDClass")){
				UUIDClass = cm;
			}
		}
		if(UUIDClass != null){
			EcoreUtil.remove(UUIDClass);
		}
		return modifSpecificationNoUUID;
	}
	// PUBLIC **********************************************************************************

	/**
	 * Produces a by default modif specification.
	 * @param theModifType Indicates the type of the modif specification to be generated. 
	 * 1 - Copy, it is a modif specification which application produces a copy of the source metamodel.
	 * 2 - EraseAll, it is a modif specification which application produces an empty target metamodel.
	 */
	public static void generateModifSpecification(int theModifType) {
		modifType = theModifType;
		ModifIO aModifIO = new ModifIO();
		NoModifFactory noModifFactory = new NoModifFactory();
		EraseAllModifFactory eraseAllModifFactory = new EraseAllModifFactory();
		EPackage theRootEcore; 

		// All operations and annotations are removed from the metamodel
		theRootEcore = sourceMetamodel;
		Modifications theRootModif = null;
		if (modifType==1) {
			theRootModif = noModifFactory.generateModif(theRootEcore); 
		}else if (modifType==2) {
			theRootModif = eraseAllModifFactory.generateEraseAll(theRootEcore);
		}
		modifSpecification = theRootModif;
		
		modifSpecification = removeUUIDFromSpecification();
	}

	/**
	 * Get the modif specification.
	 * @return modifSpecification. Modif specifciation
	 */
	public static Modifications getModifSpecification() {
		return modifSpecification;
	}

	/**
	 * Simplify the modif specification.
	 * Deletes all unuseful lines of the modif specification. 
	 * An unuseful line is a line which application does not modify the corresponding element in the metamodel.
	 * 
	 */
	public static void minimizeStrong() {
		Minimize tool = new Minimize();
		tool.accept(modifSpecification, 2);		
	}

	/**
	 * Simplify the modif specification.
	 * Keep lines with modifications and the names of the classes, the attributes and the references.
	 * it can be easily updated.
	 */
	public static void minimizeToUpdate() {
		Minimize tool = new Minimize();
		tool.accept(modifSpecification, 1);
	}
	
	/**
	 * Set source metamodel.
	 * @param theSourceMetamodel Source metamodel.
	 */
	public static void setSourceMetamodel(EPackage theSourceMetamodel) {
		sourceMetamodel = theSourceMetamodel;
	}

	/**
	 * Set the modif specification.
	 * @param modif Modif specification.
	 */
	public static void setModifSpecification(Modifications modif) {
		modifSpecification = modif;
	}

}
