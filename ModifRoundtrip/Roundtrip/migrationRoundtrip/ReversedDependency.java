package migrationRoundtrip;

import java.util.*;
import dependency.*;

/**
 * This class represents a reversed dependency graph.
 * A dependency graph relates an instance to the instances that have been used to compute or update it.
 * A reverse dependency graph relates an instance to the instances that have been computed or updated from it.
 * @author M. Kerboeuf
 */
class ReversedDependency {
	private Map<String, Set<String>> reversedDependencyGraph;
	
	/**
	 * Creation of a reversed dependency graph from a given dependency graph. 
	 * @param graph A dependency graph to be reversed.
	 */
	public ReversedDependency(Graph graph) {
		this.reversedDependencyGraph = new HashMap<String, Set<String>>();
		for (Vertex v : graph.getInstances())
			for (Vertex vd : v.getDependsOn())
				if (!v.getUUID().equals(vd.getUUID())) { // only non-trivial dependencies are kept
					Set<String> vdDep = this.reversedDependencyGraph.get(vd.getUUID());
					if (vdDep==null) vdDep = new TreeSet<String>();
					vdDep.add(v.getUUID());
					this.reversedDependencyGraph.put(vd.getUUID(), vdDep);
				}
	}

	/**
	 * Provides the vertices of the graph corresponding to sources of edges.
	 * @return The edge sources (ie UUIDs).
	 */
	public Set<String> getSourceUUIDs() {
		return this.reversedDependencyGraph.keySet();
	}

	/**
	 * Provides the vertices of the graph corresponding to targets of edges
	 * coming from a given source.
	 * @param instanceUUID The vertex to scan (ie an UUID). 
	 * @return The edge targets (ie UUIDs).
	 */
	public Set<String> getDependentUUIDs(Object instanceUUID) {
		return this.reversedDependencyGraph.get(instanceUUID);
	}
	
	@Override
	public String toString() {
		String res = "";
		for(String source : this.reversedDependencyGraph.keySet()) {
			res+=(source+" -> ");
			for(String target : this.reversedDependencyGraph.get(source)) res+=(target+" ");
			res+="\n";
		}
		return res;
	}
		
}
