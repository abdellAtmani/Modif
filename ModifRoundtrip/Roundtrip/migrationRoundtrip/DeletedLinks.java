package migrationRoundtrip;

import java.util.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.*;

import utils.UtilEMF;
import migration.*;

/**
 * This class gathers the links that will actually be deleted by the onward migration.
 * A link corresponds to an instance UUID maped to a target object through a structural feature.
 * The target object can be a general object if the feature is an attribute or if it is a
 * reference pointing to an instance without UUID. In other cases, the target object is a String
 * corresponding to the referenced instance's UUID.
 * @author M. Kerboeuf
 */
class DeletedLinks {

	private Triplet<String, EStructuralFeature, Object> linkMap;

	/**
	 * Translates an object to the corresponding UUID if possible.
	 * @param o The object to translate.
	 * @param esf The structural feature corressponding to this object.
	 * @param initialInstance The instance associated to this object through the given structural feature.
	 * @return The corresponding UUID if it exists, or the object itself.
	 */
	private static Object translateFeatureValue(Object o, EStructuralFeature esf, EObject initialInstance) {
		if (esf instanceof EAttribute) return o;
		// esf is a reference which can have an opposite:
		EReference opp = ((EReference)esf).getEOpposite();
		if (opp!=null) System.err.println( "Warning: the reference "+initialInstance.eClass().getName()+"."+esf.getName()+" will be deleted together with its opposite reference "+opp.getEContainingClass().getName()+"."+opp.getName()+".");
		String referencedInstanceUUID = UtilEMF.getUUID(o);
		if (referencedInstanceUUID==null) return o; // external or unidentified ref. kept and processed like a normal attribute
		return referencedInstanceUUID;
	}

	/**
	 * Provides a collection of translated object.
	 * @param esf The structural feature to scan.
	 * @param initialInstance The instance associated to this structural feature.
	 * @return The possibly empty set of object associated to this instance through the given structural feature
	 * where objects are replaced by there corresponding UUID if possible.
	 */
	private static Collection<?> translateFeatureValues(EStructuralFeature esf, EObject initialInstance) {
		Collection<Object> newSet = new ArrayList<Object>();
		for (Object o : (Collection<?>) initialInstance.eGet(esf))
			newSet.add(translateFeatureValue(o, esf, initialInstance));
		return newSet;
	}

	/** 
	 * Creates a set of links to be deleted from a migration specification and the corresponding initial model.
	 * @param model1sInit Initial model.
	 * @param migration Migration specification.
	 */
	/*public DeletedLinks(EObject model1sInit, Migration migration) {
		this.linkMap      = new Triplet<String, EStructuralFeature, Object>();
		// map UUID -> instance:
		Map<String, EObject> initModelMap = UtilEMF.createUUIDMap(model1sInit);
		// map UUID -> deletion specification:		
		Map<String, Deletion> migrationMap = new HashMap<String, Deletion>();
		for (Instance i : migration.getInstances())
			if (i.getDeletion()!=null) migrationMap.put(i.getUUID(), i.getDeletion());
		// Scan of initial instances with UUIDs:
		for(String initialInstanceUUID : initModelMap.keySet()) {
			EObject  initialInstance          = initModelMap.get(initialInstanceUUID);
			Deletion initialInstanceMigration = migrationMap.get(initialInstanceUUID);
			if (initialInstanceMigration!=null) { // this instance must be modified
				if (initialInstanceMigration.isDeleteInstance()) {
					// This instance must be deleted, so we look for its containing link:
					EObject initialInstanceContainer = initialInstance.eContainer();
					if (initialInstanceContainer!=null) {
						String containingInstanceUUID = UtilEMF.getUUID(initialInstanceContainer);
						if (containingInstanceUUID==null) System.err.println("Warning: required UUID not found ("+initialInstanceContainer+").");
						else this.linkMap.put(containingInstanceUUID, initialInstance.eContainmentFeature(), initialInstanceUUID);
					}
					else System.err.println("Warning: attempt to delete root object ("+initialInstanceContainer+").");
				}
				else {
					// This instance must be kept, so we scan its features to collect deleted links:
					Set<String> deletedFeaturesNames = new HashSet<String>();
					for (Attribute a : initialInstanceMigration.getAttributes()) deletedFeaturesNames.add(a.getName());
					for (Reference r : initialInstanceMigration.getReferences()) deletedFeaturesNames.add(r.getName());
					for (String esfn : deletedFeaturesNames) {
						EStructuralFeature esf = initialInstance.eClass().getEStructuralFeature(esfn);
						String className       = initialInstance.eClass().getName();
						if (esf==null) System.err.println( "Warning: feature "+esfn+" is supposed to be deleted but it is not found in class "+className+".");
						else if (esf instanceof EReference && ((EReference)esf).isContainer()) System.err.println( "Warning: feature "+className+"."+esfn+" is supposed to be deleted but it is a container.");
						else if (!esf.isChangeable()) System.err.println( "Warning: feature "+className+"."+esfn+" is supposed to be deleted but it is not changeable.");
						else if (initialInstance.eIsSet(esf)) {
							if (esf.isMany()) this.linkMap.putAll(initialInstanceUUID, esf, translateFeatureValues(esf, initialInstance)); 
							else              this.linkMap.put   (initialInstanceUUID, esf, translateFeatureValue(initialInstance.eGet(esf), esf, initialInstance));
						}
					}
				}
			} // end if (initialInstanceMigration!=null) ; else -> there is nothing to do...
		} // end of scan.
		// Some links are redundant because their sources are contained in deleted instances:
		for (String linkSourceUUID : this.linkMap.key1Set()) { // linkSourceUUID = instance UUID, source of link to be deleted
			EObject target = initModelMap.get(linkSourceUUID); String targetUUID = linkSourceUUID;          // link target
			EObject source = target.eContainer()             ; String sourceUUID = UtilEMF.getUUID(source); // source target
			EStructuralFeature containingFeature = target.eContainingFeature();                             // link feature
			boolean toRemove = false; // states if links from linkSourceUUID are redundant
			while (source!=null && !toRemove) {
				if (sourceUUID!= null && targetUUID!= null && this.linkMap.get(sourceUUID, containingFeature).contains(targetUUID)) toRemove=true;
				target = source             ; targetUUID = sourceUUID;
				source = target.eContainer(); sourceUUID = UtilEMF.getUUID(source);
				containingFeature = target.eContainingFeature();
			}
			if (toRemove) this.linkMap.remove(linkSourceUUID);
		}
	}*/

	// DeletedLinks with Hide
	public DeletedLinks(EObject model1sInit, Migration migration) {
		this.linkMap      = new Triplet<String, EStructuralFeature, Object>();
		// map UUID -> instance:
		Map<String, EObject> initModelMap = UtilEMF.createUUIDMap(model1sInit);
		// map UUID -> deletion specification:		
		Map<String, Deletion> migrationMap = new HashMap<String, Deletion>();
		//Map<String, Hide> migrationMapHide = new HashMap<String, Hide>();
		ArrayList<String> uuidList = new ArrayList<String>();

		for (Instance i : migration.getInstances()){
			if (i.getDeletion()!=null){
				migrationMap.put(i.getUUID(), i.getDeletion());
			}
			//if (i.getHide() != null){
				//migrationMapHide.put(i.getUUID(), i.getHide());
			//}
		}
		// Scan of initial instances with UUIDs:
		for(String initialInstanceUUID : initModelMap.keySet()) {
			EObject  initialInstance          = initModelMap.get(initialInstanceUUID);
			Deletion initialInstanceMigration = migrationMap.get(initialInstanceUUID);
			//Hide initialInstanceMigrationHide = migrationMapHide.get(initialInstanceUUID);

			if (initialInstanceMigration!=null) { // this instance must be modified
				if (initialInstanceMigration.isDeleteInstance()) {
					// This instance must be deleted, so we look for its containing link:
					EObject initialInstanceContainer = initialInstance.eContainer();
					if (initialInstanceContainer!=null) {
						String containingInstanceUUID = UtilEMF.getUUID(initialInstanceContainer);						
						if (containingInstanceUUID==null) System.err.println("Warning: required UUID not found ("+initialInstanceContainer+").");
						else this.linkMap.put(containingInstanceUUID, initialInstance.eContainmentFeature(), initialInstanceUUID);
					}
					else System.err.println("Warning: attempt to delete root object ("+initialInstanceContainer+").");
				}
				else {
					// This instance must be kept, so we scan its features to collect deleted links:
					Set<String> deletedFeaturesNames = new HashSet<String>();
					for (DeletedAttribute a : initialInstanceMigration.getDeletedAttributes()) deletedFeaturesNames.add(a.getName());
					for (DeletedReference r : initialInstanceMigration.getDeletedReferences()) deletedFeaturesNames.add(r.getName());
					for (String esfn : deletedFeaturesNames) {
						EStructuralFeature esf = initialInstance.eClass().getEStructuralFeature(esfn);
						String className       = initialInstance.eClass().getName();
						if (esf==null) System.err.println( "Warning: feature "+esfn+" is supposed to be deleted but it is not found in class "+className+".");
						else if (esf instanceof EReference && ((EReference)esf).isContainer()) System.err.println( "Warning: feature "+className+"."+esfn+" is supposed to be deleted but it is a container.");
						else if (!esf.isChangeable()) System.err.println( "Warning: feature "+className+"."+esfn+" is supposed to be deleted but it is not changeable.");
						else if (initialInstance.eIsSet(esf)) {
							if (esf.isMany()) this.linkMap.putAll(initialInstanceUUID, esf, translateFeatureValues(esf, initialInstance)); 
							else              this.linkMap.put   (initialInstanceUUID, esf, translateFeatureValue(initialInstance.eGet(esf), esf, initialInstance));
						}
					}
				}
			} // end if (initialInstanceMigration!=null) ; else -> there is nothing to do...
		} // end of scan.
		// Some links are redundant because their sources are contained in deleted instances:
		for (String linkSourceUUID : this.linkMap.key1Set()) { // linkSourceUUID = instance UUID, source of link to be deleted
			EObject target = initModelMap.get(linkSourceUUID); String targetUUID = linkSourceUUID;          // link target
			EObject source = target.eContainer()             ; String sourceUUID = UtilEMF.getUUID(source); // source target
			EStructuralFeature containingFeature = target.eContainingFeature();                             // link feature
			boolean toRemove = false; // states if links from linkSourceUUID are redundant
			while (source!=null && !toRemove) {
				if (sourceUUID!= null && targetUUID!= null && this.linkMap.get(sourceUUID, containingFeature).contains(targetUUID)) toRemove=true;
				target = source             ; targetUUID = sourceUUID;
				source = target.eContainer(); sourceUUID = UtilEMF.getUUID(source);
				containingFeature = target.eContainingFeature();
			}
			if (toRemove) this.linkMap.remove(linkSourceUUID);
		}
	}
	
	public DeletedLinks(EObject model1sInit, Migration migration, String UUIDtimestamp) {
		this.linkMap      = new Triplet<String, EStructuralFeature, Object>();
		// map UUID -> instance:
		Map<String, EObject> initModelMap = UtilEMF.createUUIDMap(model1sInit, UUIDtimestamp);
		// map UUID -> deletion specification:		
		Map<String, Deletion> migrationMap = new HashMap<String, Deletion>();
		//Map<String, Hide> migrationMapHide = new HashMap<String, Hide>();
		ArrayList<String> uuidList = new ArrayList<String>();

		for (Instance i : migration.getInstances()){
			if (i.getDeletion()!=null){
				migrationMap.put(i.getUUID(), i.getDeletion());
			}
			//if (i.getHide() != null){
				//migrationMapHide.put(i.getUUID(), i.getHide());
			//}
		}
		// Scan of initial instances with UUIDs:
		for(String initialInstanceUUID : initModelMap.keySet()) {
			EObject  initialInstance          = initModelMap.get(initialInstanceUUID);
			Deletion initialInstanceMigration = migrationMap.get(initialInstanceUUID);
			//Hide initialInstanceMigrationHide = migrationMapHide.get(initialInstanceUUID);

			if (initialInstanceMigration!=null) { // this instance must be modified
				if (initialInstanceMigration.isDeleteInstance()) {
					// This instance must be deleted, so we look for its containing link:
					EObject initialInstanceContainer = initialInstance.eContainer();
					if (initialInstanceContainer!=null) {
						
						String containingInstanceUUID = UtilEMF.getUUID(initialInstanceContainer, UUIDtimestamp);						
						if (containingInstanceUUID==null) System.err.println("Warning: required UUID not found ("+initialInstanceContainer+").");
						else this.linkMap.put(containingInstanceUUID, initialInstance.eContainmentFeature(), initialInstanceUUID);
					}
					else System.err.println("Warning: attempt to delete root object ("+initialInstanceContainer+").");
				}
				else {
					// This instance must be kept, so we scan its features to collect deleted links:
					Set<String> deletedFeaturesNames = new HashSet<String>();
					for (DeletedAttribute a : initialInstanceMigration.getDeletedAttributes()) deletedFeaturesNames.add(a.getName());
					for (DeletedReference r : initialInstanceMigration.getDeletedReferences()) deletedFeaturesNames.add(r.getName());
					for (String esfn : deletedFeaturesNames) {
						EStructuralFeature esf = initialInstance.eClass().getEStructuralFeature(esfn);
						String className       = initialInstance.eClass().getName();
						if (esf==null) System.err.println( "Warning: feature "+esfn+" is supposed to be deleted but it is not found in class "+className+".");
						else if (esf instanceof EReference && ((EReference)esf).isContainer()) System.err.println( "Warning: feature "+className+"."+esfn+" is supposed to be deleted but it is a container.");
						else if (!esf.isChangeable()) System.err.println( "Warning: feature "+className+"."+esfn+" is supposed to be deleted but it is not changeable.");
						else if (initialInstance.eIsSet(esf)) {
							if (esf.isMany()) this.linkMap.putAll(initialInstanceUUID, esf, translateFeatureValues(esf, initialInstance)); 
							else              this.linkMap.put   (initialInstanceUUID, esf, translateFeatureValue(initialInstance.eGet(esf), esf, initialInstance));
						}
					}
				}
			} // end if (initialInstanceMigration!=null) ; else -> there is nothing to do...

			/*if (initialInstanceMigrationHide!=null) { // this instance must be modified
				Set<String> deletedFeaturesNames = new HashSet<String>();
				EList<Instance> source = null;
				for(IncomingReference incoming : initialInstanceMigrationHide.getIncoming()){
					source = incoming.getSource();
					//deletedFeaturesNames.add(incoming.getIncomingReferenceName());
					for(NewReference newReference : incoming.getTarget()){
						deletedFeaturesNames.add(newReference.getOldOutgoingName());
					}
				}
				for (String esfn : deletedFeaturesNames) {
					EStructuralFeature esf = initialInstance.eClass().getEStructuralFeature(esfn);
					String className       = initialInstance.eClass().getName();
					if (esf==null){
						// Imprimimos el Map con un Iterador que ya hemos instanciado anteriormente
						Iterator<String> it = initModelMap.keySet().iterator();
						while(it.hasNext()){
							String key = it.next();
							for(Instance s : source){
								if(s.getUUID().equals(key)){
									esf = initModelMap.get(key).eClass().getEStructuralFeature(esfn);
									className       = initModelMap.get(key).eClass().getName();
									if (esf.isMany()){
										this.linkMap.putAll(initialInstanceUUID, esf, translateFeatureValues(esf, initModelMap.get(key))); 
									}
									else {
										this.linkMap.put   (initialInstanceUUID, esf, translateFeatureValue(initModelMap.get(key).eGet(esf), esf, initModelMap.get(key)));
									}
								}else{
									System.err.println( "Warning: feature "+esfn+" is supposed to be deleted but it is not found in class "+className+".");
								}
							}	
						}
					}
					else if (esf instanceof EReference && ((EReference)esf).isContainer()) System.err.println( "Warning: feature "+className+"."+esfn+" is supposed to be deleted but it is a container.");
					else if (!esf.isChangeable()) System.err.println( "Warning: feature "+className+"."+esfn+" is supposed to be deleted but it is not changeable.");
					else if (initialInstance.eIsSet(esf)) {
						if (esf.isMany()) this.linkMap.putAll(initialInstanceUUID, esf, translateFeatureValues(esf, initialInstance)); 
						else              this.linkMap.put   (initialInstanceUUID, esf, translateFeatureValue(initialInstance.eGet(esf), esf, initialInstance));
					}
				}
			}else{
				Set<String> deletedFeaturesNames = new HashSet<String>();
				for (Instance i : migration.getInstances()){
					Hide h = i.getHide();
					if (h != null){
						EList<Instance> source2 = null;
						for(IncomingReference incoming : h.getIncoming()){
							source2 = incoming.getSource();
							for(Instance s : source2){
								if(s.getUUID().equals(initialInstance.eGet(initialInstance.eClass().getEStructuralFeature("UUID")).toString())){
									deletedFeaturesNames.add(incoming.getIncomingReferenceName());
								}
							}
						}
						for (String esfn : deletedFeaturesNames) {
							EStructuralFeature esf = initialInstance.eClass().getEStructuralFeature(esfn);
							String className       = initialInstance.eClass().getName();
							if (esf==null){
								// Imprimimos el Map con un Iterador que ya hemos instanciado anteriormente
								Iterator<String> it = initModelMap.keySet().iterator();
								while(it.hasNext()){
									String key = it.next();
									for(Instance s : source2){
										if(s.getUUID().equals(key)){
											esf = initModelMap.get(key).eClass().getEStructuralFeature(esfn);
											className       = initModelMap.get(key).eClass().getName();
											if (esf.isMany()){
												this.linkMap.putAll(initialInstanceUUID, esf, translateFeatureValues(esf, initModelMap.get(key))); 
											}
											else {
												this.linkMap.put   (initialInstanceUUID, esf, translateFeatureValue(initModelMap.get(key).eGet(esf), esf, initModelMap.get(key)));
											}
										}else{
											System.err.println( "Warning: feature "+esfn+" is supposed to be deleted but it is not found in class "+className+".");
										}
									}	
								}
							}
							else if (esf instanceof EReference && ((EReference)esf).isContainer()) System.err.println( "Warning: feature "+className+"."+esfn+" is supposed to be deleted but it is a container.");
							else if (!esf.isChangeable()) System.err.println( "Warning: feature "+className+"."+esfn+" is supposed to be deleted but it is not changeable.");
							else if (initialInstance.eIsSet(esf)) {
								if (esf.isMany()) this.linkMap.putAll(initialInstanceUUID, esf, translateFeatureValues(esf, initialInstance)); 
								else              this.linkMap.put   (initialInstanceUUID, esf, translateFeatureValue(initialInstance.eGet(esf), esf, initialInstance));
							}
						}
					}
				}
			}*/
		} // end of scan.
		// Some links are redundant because their sources are contained in deleted instances:
		for (String linkSourceUUID : this.linkMap.key1Set()) { // linkSourceUUID = instance UUID, source of link to be deleted
			EObject target = initModelMap.get(linkSourceUUID); String targetUUID = linkSourceUUID;          // link target
			EObject source = target.eContainer()             ; String sourceUUID = UtilEMF.getUUID(source); // source target
			EStructuralFeature containingFeature = target.eContainingFeature();                             // link feature
			boolean toRemove = false; // states if links from linkSourceUUID are redundant
			while (source!=null && !toRemove) {
				if (sourceUUID!= null && targetUUID!= null && this.linkMap.get(sourceUUID, containingFeature).contains(targetUUID)) toRemove=true;
				target = source             ; targetUUID = sourceUUID;
				source = target.eContainer(); sourceUUID = UtilEMF.getUUID(source);
				containingFeature = target.eContainingFeature();
			}
			if (toRemove) this.linkMap.remove(linkSourceUUID);
		}
	}

	/**
	 * Provides the set of instances that are source of deketed links.
	 * @return The set of UUIDs corresponding to instances that are source of deleted links.
	 */
	public Set<String> getSourceUUIDs() {
		return this.linkMap.key1Set();
	}

	/**
	 * Provides the set of structural features associated to a given instance that are defining deleted links.
	 * @param instanceUUID The UUID of the instance to scan.
	 * @return The non-empty set of structural feature, or null.
	 */
	public Set<EStructuralFeature> getDeletedFeatures(String instanceUUID) {
		return this.linkMap.key2Set(instanceUUID);
	}

	/**
	 * Provides the collection of object to be deleted, and associated to a given instance and a given structural feature.
	 * @param instanceUUID The UUID of the insatnce to scan.
	 * @param esf The structural feature to scan.
	 * @return The non-empty collection of object, or null.
	 */
	public Collection<Object> getDeletedFeatureValues(String instanceUUID, EStructuralFeature esf) {
		return this.linkMap.get(instanceUUID, esf);
	}

	@Override
	public String toString() {
		String res = "";
		for(String source : this.linkMap.key1Set()) {
			res+=source+"\n";
			for (EStructuralFeature esf : this.linkMap.key2Set(source)) {
				res+=("  ."+esf.getName()+" (from "+esf.getEContainingClass().getName()+")\n");
				for (Object target : this.linkMap.get(source, esf))
					res+=("       -> "+target+"\n");
			}
		}
		return res;
	}

}