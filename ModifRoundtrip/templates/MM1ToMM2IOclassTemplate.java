package %%%JAVAPACKAGE;

import java.io.*;
import java.util.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * Class providing IO services for model migration.<p>
 * An instance of %%%CLASS is used :
 * <li>
 * <ul> to load a model conforming to a concrete class of %%%SOURCEMM from an existing file</ul>
 * <ul> to save a model conforming to a concrete class of %%%TARGETMM into a (possibly) new file</ul>
 * </li>
 * Typically, the instance to be saved comes from the migration of the loaded instance.
 */
public class %%%CLASS {

	/* *************************************************************** */
	/* ****   LOADING FUNCTIONS                                   **** */
	/* *************************************************************** */

$$$$INCLUDELOADINGFUNCTIONS
    /* *************************************************************** */
	/* ****   SAVING FUNCTIONS                                    **** */
	/* *************************************************************** */

$$$$INCLUDESAVINGFUNCTIONS
}
