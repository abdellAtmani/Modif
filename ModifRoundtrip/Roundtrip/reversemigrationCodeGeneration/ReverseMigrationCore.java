package reversemigrationCodeGeneration;

import java.util.*;

import javax.print.attribute.standard.MediaSize.Other;

import modif.AddAttribute;
import modif.AddDerived;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EClassImpl;

public class ReverseMigrationCore {
	
	/** root object of ecoreModif object */
	protected EPackage rootEcore;
	protected EPackage outputrootEcore;
	protected EPackage initialrootEcore;

	/** by-default name of generated parameter of functions in generated code */
	protected String paramName = "val";
	protected String paramNameInitial = "initial";
	
	/** constructor */
	protected ReverseMigrationCore(EPackage rootEcore, EPackage outputrootEcore, EPackage initialrootEcore ) {
		this.rootEcore = rootEcore;
		this.outputrootEcore = outputrootEcore;
		this.initialrootEcore = initialrootEcore;
	}
	
	/**
	 * code generation function
	 * @param ecm class for migration
	 * @return list of code lines to generate
	 */
	protected List<String> generateMigrationCode(EClass ec) {
		List<String> content = new ArrayList<String>();		
		
		// for a concrete EClass
		if (! ec.isAbstract()) {
			// create objects
			
			String newPackName = outputrootEcore.getName();
			
			String newLongPackName = Character.toUpperCase(outputrootEcore.getName().charAt(0))+outputrootEcore.getName().substring(1);
			content.add("		"+outputrootEcore.getName()+"."+newLongPackName+"Factory myFactory = new "+outputrootEcore.getName()+".impl."+newLongPackName+"FactoryImpl();");
			content.add("		"+outputrootEcore.getName()+"."+ec.getName()+" result = myFactory.create"+ec.getName()+"();");
			// add attributes
			content.add("		// add attributes");
			int number = 0;
			for (EAttribute att : ec.getEAttributes()) {
				// for migrated EAttribute, not new and not derived
				if (!att.isDerived()) {
					generateAttributes(content, att, number);
				}
				number++;
			}
			content.add("		// add new attributes");
			/*for (AddAttribute ada : ecm.getModif().getAddAttributes()) {
					generateNewAttributes(content, ada);
				}*/
			content.add("		// add derived attributes");
				generateDerivedAttributes(content, ec);
			// add objects of contained references (containment is true)
			content.add("		// add objects of contained objects");
			
			for(EClassifier eci : initialrootEcore.getEClassifiers()){
				//System.out.println("*** ECI : "+eci.getName());
				//System.out.println("*** EC : "+ec.getName());
//--- error
				if(eci.getName().equals(ec.getName())){
					//System.out.println("*** ECUAL");	
					content.addAll(generateContextCode((EClass) eci, initialrootEcore));
				}
			}
			number = 0;
			for (EReference ref : ec.getEReferences()) {
					// for migrated EReference (containment true), not new 
					if (ref.isContainment()) {		
						if(!ref.isDerived()){ //not derived
							generateContainedObjects(content, ref.getEReferenceType(), ref, number);
							//add objects contained references on inherited objects (containment is true)
							/*for(EClass subC : ref.getEType().getAllSubtypes()){
								generateContainedObjects(content, subC, ref, number);
							}*/
						}
						if(ref.isDerived()){ //derived
							content.add("      //add derived contained objects");
							//generateDerivedContainedObjects(content, ec, ref.getEType(), ref, number);
							// add objects contained references on inherited objects (containment is true)
							/*for(EClass subC : ref.getEType().getAllSubTypes()){
								generateDerivedContainedObjects(content, ec, subC, ref, number);
							}*/
						}
					}
					number ++;
			}
			
			// save correspondence between objects into sourceTotarget		
			content.add("		sourceToTarget.put("+paramName+", result);");
		}	else  {
			content.add("		EObject result = null;");			
		}		
		return content;
	}
	
	
	protected List<String> generateAddReferencesCode(EClass ec){
		List<String> content = new ArrayList<String>();
		
		if(!ec.isAbstract()){
			// add references of not contained references
			content.add("         // add not contained references");
			content.add("        "+outputrootEcore.getName()+"."+ec.getName()+" obj"+paramName+" = ("+outputrootEcore.getName()+"."+ec.getName()+") sourceToTarget.get("+paramName+");");
			for(int i =0; i <ec.getEReferences().size(); i++){
				EReference ref = ec.getEReferences().get(i);
				if(!ref.isContainment()){
					generateAddNotContainedReferences(content, (EClass) ref.getEType(), ref, i);
					/*for (int k=0; k<ref.getEType().getAllSubTypes().size();k++) {
						if (ref.getEType().getAllSubTypes().get(k).getEcore()!=null) {				
							generateAddNotContainedReferences(content, ref.getEType().getAllSubTypes().get(k), ref, i);
						}
					}*/
				}
			}
		}
		content.add("      // add derived references");
		generateDerivedReferences(content, ec);
		// call addReferences of contained objects
		content.add("              //call addReferences of contained objects");
		for(int j =0; j< ec.getEReferences().size(); j++){
			EReference ref = ec.getEReferences().get(j);
			if(ref.isContainment()){
				// it is a reference to an existing concrete class
				generateCallAddReferences(content, ref, (EClass) ref.getEType(), j);
				// add objects contained references on inherited objects (containment is true)
				/*for (int k=0; k<ref.getEType().getAllSubTypes().size();k++) {				
					generateCallAddReferences(content, ref, ref.getEType().getAllSubTypes().get(k),j);
				}*/
			}
		}
		content.add("		// call addReferences of derived contained objects");
		/*for(int j=0; j<ec.getEReferences().size(); j++){
			EReference ref = ec.getEReferences().get(j);
			if(ref.isContainment()){
				// it is a reference to an existing concrete class
				generateCallAddDerivedReferences(content, ec, ref, (EClass) ref.getEType(), j);
				// add objects contained references on inherited objects (containement is true)
				/*for (int k=0; k<ref.getTo().getAllSubTypes().size();k++) {				
					generateCallAddDerivedReferences(content, ecm, ref, ref.getTo().getAllSubTypes().get(k),j);
				}
				
			}
		}*/
		return content;
	}
	
	
	protected void generateAttributes(List<String> content, EAttribute att, int num) {
		
		if (att != null) {
			// build elements for attribute migration code (copy)

			String name = Character.toUpperCase(att.getName().charAt(0))+att.getName().substring(1);
			int max = att.getUpperBound();
		
			// setter of the new attribute
			// if it is a list of attributes, call the EMF generated get function, else the set function
			String setter = ((max>1 || max==-1)?"get":"set") + name;
			// if it is a list of attributes, it is necessary to then call add or addAll function  
			String add = "";
			// element to list : add
			if(max>1 || max==-1){
				add = "().addAll";
			}
			
			// list to list : addAll
			/*if ((max>1 || max==-1) ) {
				add = "().addAll";			
			}*/
			// getter of the old attribute
			// if it is a boolean attribute, EMF generates a is function, else a get function
			String getter = ((att.getEType().equals(EcorePackage.Literals.EBOOLEAN))?"is":"get") +name+"()";
							
			/*if ((max==1) ) {
				content.add("      if(!"+paramName+"."+getter+"isEmpty()) {");
				getter = getter +".get(0)";
				
			}*/
		
			// list to element : by default select the first element of the list to set the attribute

			content.add("		result."+setter+add+"("+paramName+"."+getter+");");
		
			/*if (max==1)  {
				content.add("   }");
			}*/
		}
		else {
			generateEnumAttributes(content, att, num);
		}
	}
	
	protected void generateEnumAttributes(List<String> content, EAttribute att, int num) {
		String name = Character.toUpperCase(att.getName().charAt(0))+att.getName().substring(1);
		//String newName = Character.toUpperCase(att.getModif().getNewName().charAt(0))+att.getModif().getNewName().substring(1);
		String getter = "get"+name+"()";	
		String setter = "set"+name;
		content.add("		switch (val."+getter+".getValue()) {");
		/*for (EnumLiteral elt : att.getEnum().getEnumLiteral()) {
			if (! elt.getModif().isRemove()) {
				String oldLitValue = ""+elt.getModif().getOldValue();
				String newLitValue = elt.getEnumModif().getModif().getNewName()+".get("+elt.getModif().getNewValue()+")";
				content.add("			case "+oldLitValue+": result."+setter+"("+newLitValue+");break;");
			}
		}*/		
		content.add("		}");
	}
	
	/*protected void generateNewAttributes(List<String> content, AddAttribute att){
		String name = Character.toUpperCase(att.getNewAttributeName().charAt(0))+att.getNewAttributeName().substring(1);
		if(att.isIsMandatory()){
			content.add("    result.set"+name+"("+att.getNewAttributeDefaultValue()+");");
		}
	}*/
	
	protected void generateDerivedAttributes(List<String> content, EClass c){
		
	}
	
	
	
	
	
	
	protected List<String> generateContextCode(EClass ec, EPackage initial) {
		List<String> content = new ArrayList<String>();	
		int number = 0;
		content.add("        int "+ec.getName()+"Id = result.getKeyForModif();");
		content.add("        for(int k=0; k <deleted.size(); k++){");
		for(EClassifier eci : initialrootEcore.getEClassifiers()){
			for(EReference ref : ((EClass) eci).getEReferences()){
				if(ref.isContainment()){
					if(!ref.isDerived()){
						generateContainedObjectsInitial(content, (EClass) ec, (EClass) eci, ref, number);
					}
					/*if(ref.isDerived()){
						content.add("        // add derived contained objects");
						generate
					}*/
				}
			}
			number ++;
		}
		content.add("        }");

    	return content;
	}

	protected void generateDerivedReferences(List<String> content, EClass c){
		
	}
	
	protected void generateContainedObjects(List<String> content, EClass ect, EReference ref, int num) {
		// it is a reference to an existing concrete class
		if (!ect.isAbstract()) {
	
			String name = Character.toUpperCase(ref.getName().charAt(0))+ref.getName().substring(1);
			
			String source = ect.getName();
			String target = ect.getName();
			int max = ref.getUpperBound();

			// build elements for attribute migration code (copy)
			
			// setter of the new reference
			// if it is a list of attributes, call the EMF generated get function, else the set function
			String setter = ((max>1 || max==-1)?"get":"set") + name;
			// if it is a list of attributes, it is necessary to then call a EMF add or addAll function  
			String add =  (max>1 || max==-1)?"().add":"";
			// getter of old reference
			String getter = ".get"+name+"()";
			// list to element : by default select the first element of the list to set the attribute
			/*if (max ==1 ) {
				getter = ".get"+name+"().get(0)";
			}*/
			// list to list : copy element by element
			if (max>1 || max==-1) {
				getter = ".get"+name+"().get(j"+num+")";
			}
			
			// list to list : copy element by element
			if (max>1 || max==-1) {
				content.add("		for (int j"+num+"=0; j"+num+" <"+paramName+".get"+name+"().size();j"+num+"++) {");
			}
			/*if (max ==1 ) {
				content.add("		if (!"+paramName+".get"+name+"().isEmpty()) {");
			}*/
			content.add("		    if("+paramName+getter+" !=null ) {");
			content.add("			//	if("+paramName+getter+".getClass().equals("+outputrootEcore.getName()+".impl."+source+"Impl.class)) {");
			//content.add("			   if("+paramName+getter+".getClass().toString().split(\"\\\\.\")[2].equals("+"\""+source+"Impl\")) {");
			//content.add("				   "+outputrootEcore.getName()+"."+etc.getName()+" obj"+target+" = ("+outputrootEcore.getName()+"."+etc.getName()+") this.context"+source+"( ("+rootEcore.getName()+"."+etc.getName()+") "+paramName+getter+");");
			content.add("				"+outputrootEcore.getName()+"."+ect.getName()+" obj"+target+" = ("+outputrootEcore.getName()+"."+ect.getName()+") this.context"+source+"( ("+rootEcore.getName()+"."+ect.getName()+") "+paramName+getter+");");
			content.add("			      	result."+setter+add+"(obj"+target+");");
			content.add("       	   //}");
			content.add("			}");
			if (max>1 || max==-1) {
				content.add("		}");
			}			
		}
	}

	protected void generateContainedObjectsInitial(List<String> content, EClass ec, EClass ect, EReference ref, int num) {
		// it is a reference to an existing concrete class
		if (!ect.isAbstract()) {
	
			String name = Character.toUpperCase(ref.getName().charAt(0))+ref.getName().substring(1);
			String source = ect.getName();
			String target = ect.getName();
			int max = ref.getUpperBound();

			// build elements for attribute migration code (copy)
			
			// setter of the new reference
			// if it is a list of attributes, call the EMF generated get function, else the set function
			String setter = ((max>1 || max==-1)?"get":"set") + name;
			// if it is a list of attributes, it is necessary to then call a EMF add or addAll function  
			String add =  (max>1 || max==-1)?"().add":"";
			// getter of old reference
			String getter = ".get"+name+"()";
			// list to element : by default select the first element of the list to set the attribute
			/*if (max ==1 ) {
				getter = ".get"+name+"().get(0)";
			}*/
			// list to list : copy element by element
			if (max>1 || max==-1) {
				getter = ".get"+name+"().get(j"+num+")";
			}
			
			// list to list : copy element by element
			if (max>1 || max==-1) {
				content.add("		   for (int j"+num+"=0; j"+num+" <"+paramNameInitial+".get"+name+"().size();j"+num+"++) {");
			}
			/*if (max ==1 ) {
				content.add("		if (!"+paramName+".get"+name+"().isEmpty()) {");
			}*/
			content.add("              if("+paramNameInitial+getter+".getKeyForModif() == "+ec.getName()+"Id) {"); 
			
			System.out.println("--- EC --- "+ect.getName());
			for(EReference r : ect.getEReferences()){
				
				if(r.getUpperBound() == 1){
				
					System.out.println("--- R --- "+r.getName());
					String nameInitial = Character.toUpperCase(r.getName().charAt(0))+r.getName().substring(1);
					content.add("		   		    if("+paramNameInitial+getter+".get"+nameInitial+"() !=null ) {");
					content.add("		   		   		if("+paramNameInitial+getter+".get"+nameInitial+"().getKeyForModif() == deleted.get(k)) {");
					content.add("                           "+outputrootEcore.getName()+"."+r.getEType().getName()+" "+r.getName()+" = myFactory.create"+r.getEType().getName()+"();");

					System.out.println("--- ET --- "+r.getEType().getName());
					for(EAttribute att : ((EClass) r.getEType()).getEAllAttributes()){
						System.out.println("--- A --- "+att.getName());
						String attName = Character.toUpperCase(att.getName().charAt(0))+att.getName().substring(1);
						String get = paramNameInitial+getter+".get"+nameInitial+"().get"+attName+"()";
					
						content.add("                           "+r.getName()+".set"+attName+"("+get+");");			
					}
					content.add("                           result.set"+nameInitial+"("+r.getName()+");");
				
					content.add("                   	    }");
					content.add("                    }");
			
				}
				//content.add("			     	  	result."+setter+add+"(obj"+target+");");
				/*content.add("       	   }");
				content.add("			  		 }");
				if (max>1 || max==-1) {
					content.add("		  	 }");
				}*/
			}
		}
	}

	protected void generateCallAddReferences(List<String> content, EReference ref, EClass ect, int num) {
		if(!ect.isAbstract()){
			//String name = ref.getName();
			String name = Character.toUpperCase(ref.getName().charAt(0))+ref.getName().substring(1);
			String source = ect.getName();
			// case <=1 
			if(0<= ref.getUpperBound() && ref.getUpperBound()<=1){
				content.add("			if ("+paramName+".get"+name+"() != null) {");
				content.add("				//if ("+paramName+".get"+name+"().getClass().equals("+outputrootEcore.getName()+".impl."+source+"Impl.class)) {");
				content.add("					this.addReferences"+source+"( ("+rootEcore.getName()+"."+ect.getName()+") "+paramName+".get"+name+"());");
				content.add("				//}");
				content.add("			}");
			}
			// case >1 
			if ((ref.getUpperBound()>1) || (ref.getUpperBound()==-1) ) {
				content.add("		for (int k"+num+"=0; k"+num+" <"+paramName+".get"+name+"().size();k"+num+"++) {");
				content.add("			if (sourceToTarget.get("+paramName+".get"+name+"().get(k"+num+")) != null) {");			
				content.add("				if (sourceToTarget.get("+paramName+".get"+name+"().get(k"+num+")).getClass().equals("+outputrootEcore.getName()+".impl."+ect.getName()+"Impl.class)) {");			
				content.add("					this.addReferences"+source+"( ("+rootEcore.getName()+"."+ect.getName()+") "+paramName+".get"+name+"().get(k"+num+"));");
				content.add("				}");
				content.add("			}");
				content.add("		}");
				}
		}
		
	}
	
	protected void generateAddNotContainedReferences(List<String> content, EClass ect, EReference ref, int num){
		String name = Character.toUpperCase(ref.getName().charAt(0))+ref.getName().substring(1);
		
		int max = ref.getUpperBound();
		
		// setter of the new reference
		// if it is a list of attributes, call the EMF generated get function, else the set function
		String setter = ((max>1 || max==-1)?".get":".set") + name;
		// if it is a list of attributes, it is necessary to then call a EMF add or addAll function  
		String add =  (max>1 || max==-1)?"().add":"";
		// getter of old reference
		String getter = ".get"+name+"()";
		// list to element : by default select the first element of the list to set the attribute
		if (max ==1 ) {
			//getter = ".get"+name+"().get(0)";
			getter = ".get"+name+"()";
		}
		// list to list : copy element by element
		if (max>1 || max==-1) {
			getter = ".get"+name+"().get(i"+num+")";
		}
		
		// case >1 to >1 : list to list
		if (max>1 || max==-1) {
			content.add("		for (int i"+num+"=0; i"+num+" <"+paramName+".get"+name+"().size();i"+num+"++) {");
		}
		/*if (max ==1 ) {
			content.add("		if (!"+paramName+".get"+name+"().isEmpty()) {");
		}*/
		
		content.add("		if (sourceToTarget.get("+paramName+getter+") != null) {");
		System.out.println("	if (sourceToTarget.get("+paramName+getter+") != null) {");
		content.add("				//if (sourceToTarget.get("+paramName+getter+").getClass().equals("+outputrootEcore.getName()+".impl."+ect.getName()+"Impl.class)) {");			
		content.add("					obj"+paramName+setter+add+"(("+outputrootEcore.getName()+"."+ect.getName()+")(sourceToTarget.get("+paramName+getter+")));");		
		content.add("				//}");			
		content.add("			}");
		
		if (max>1 || max==-1) {
			content.add("	}");
		}
	}
	
	protected void generateCallAddDerivedReferences(List<String> content, EClass ec, EReference ref, EClass ect, int num) {
		EClassImpl rc = (EClassImpl)ec;
		int upperBound = 1;
		StringBuilder namePath = new StringBuilder(paramName);
		pRC prc = new pRC(rc);
		//upperBound = generatePreDerived(content,prc,ref.getDerived(),upperBound,namePath);
		
		if (!ect.isAbstract()) {
			String source = ect.getName();
			
			content.add("			if ("+namePath+" != null) {");
			content.add("				//if ("+namePath+".getClass().equals("+outputrootEcore.getName()+".impl."+source+"Impl.class)) {");
			content.add("					this.addReferences"+source+"( ("+rootEcore.getName()+"."+ect.getName()+") "+namePath+");");
			content.add("				//}");
			content.add("			}");
			
		}
		
		//generatePostDerived(content,rc,ref.getDerived());
	}
	
	class pRC {
		public EClassImpl rc;
		public pRC(EClassImpl v) {
			rc = v;
		}
	}

	
}
