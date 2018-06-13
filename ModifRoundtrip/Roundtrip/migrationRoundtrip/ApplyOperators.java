/**
 * 
 * sequence call of refactoring operators 
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  22/11/2013
 */

package migrationRoundtrip;

import ecoremodif.*;

public class ApplyOperators {


	/**
	 * Check if the ecore and the modif are valid
	 * @param theRootEcoreModif Root ecore + modif object.
	 * @return True if ecore+modif is valid. False otherwise.
	 */
	public static boolean ecoreModifIsValid(RootEcoreModif theRootEcoreModif) {
		// test if the ecore + modif element is valid
		return (new ecoremodif.utils.ValidModif().isValid(theRootEcoreModif));
	}


	/**
	 * Apply the operators to the ecore, in the specified order.
	 * @param theRootEcoreModif Ecore+modif object.
	 */
	public static void operate(RootEcoreModif theRootEcoreModif) {

		// propagate macro modif operators
		new operators.ModifPropagate().VisitRoot(theRootEcoreModif);

		if (ApplyOperators.ecoreModifIsValid(theRootEcoreModif)) {

			// rename (if necessary) all ecore elements	
			new operators.ModifRename().VisitRoot(theRootEcoreModif);				

			// merge (if necessary) classes
			new operators.ModifMergeClasses().VisitRoot(theRootEcoreModif);

			// merge (if necessary) references
			new operators.ModifMergeReferences().VisitRoot(theRootEcoreModif);

			// change (if necessary) the properties (abstract, containment, lower and upper bounds, attribute type) 
			// of all concerned ecore elements
			new operators.ModifChangeProperties().VisitRoot(theRootEcoreModif);

			// flatten (if necessary) the corresponding structural features	
			new operators.ModifFlattenClass().VisitRoot(theRootEcoreModif);		
			new operators.ModifFlattenAllClass().VisitRoot(theRootEcoreModif);

			// hide (if necessary) all EPackages	
			new operators.ModifHidePackage().VisitRoot(theRootEcoreModif);

			// hide (if necessary) all EClasses		
			new operators.ModifHideClass().VisitRoot(theRootEcoreModif);				

			// add derived (if necessary) to all EClasses	
			new operators.ModifAddDerived().VisitRoot(theRootEcoreModif);		

			// remove (if necessary) all ecore elements
			// remove all EOperations
			// remove (if necessary) all EAnnotations and EOpposite of references				
			new operators.ModifRemove().VisitRoot(theRootEcoreModif);

			// add (if necessary) attributes			
			new operators.ModifAddFeature().VisitRoot(theRootEcoreModif);

			// reify (if necessary) references and enums				
			new operators.ModifReify().VisitRoot(theRootEcoreModif);

			// enumerate (if necessary) subclasses			
			new operators.ModifEnumerate().VisitRoot(theRootEcoreModif);

			// add (if necessary) a rootClass containing all the classes			
			new operators.ModifAddRootClass().VisitRoot(theRootEcoreModif);

			// add (if necessary) an abstract namedElement Class, and all the classes inherits from it		
			new operators.ModifAddAllName().VisitRoot(theRootEcoreModif);
		} 		
	}

}
