package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import dependency.Graph;
import dependency.Vertex;
import dependency.impl.DependencyFactoryImpl;

public class UtilGraph {

	protected static DependencyFactoryImpl factory;
	protected static Graph graph;
	static EList<dependency.Vertex> instances;

	public UtilGraph() {
		factory = new DependencyFactoryImpl();
		graph = factory.createGraph();
		instances = graph.getInstances();
	}

	/**
	 * Creates a Vertex
	 * @param id UUID 
	 * @return A vertex of the dependency graph
	 */
	public static dependency.Vertex createVertex(String id, String idCopy){
		dependency.Vertex vertex = factory.createVertex();
		dependency.Vertex vertexCopy = factory.createVertex();
		vertexCopy.setUUID(idCopy);
		vertex.setUUID(id);
		instances.add(vertexCopy);
		instances.add(vertex);
		vertex.getDependsOn().add(vertex);
		vertexCopy.getDependsOn().add(vertex);
		System.out.println("vertex : "+ vertex.getUUID());
		return vertex;
	}

	public static void createVertex(String id, ArrayList<String> idDependsOn){
		System.out.println("id : " + id);
		if(idDependsOn.size()==1){
			System.out.println("size = 1");
			System.out.println("depends On : "+ idDependsOn.get(0));
			if(!isInstance(idDependsOn.get(0))){
				System.out.println("NO instance");
				if(id.equals(idDependsOn.get(0))){
					dependency.Vertex vertex; 
					vertex = factory.createVertex();
					vertex.setUUID(id);
					vertex.getDependsOn().add(vertex);
					instances.add(vertex);
				}else{
					dependency.Vertex vertex; 
					vertex = factory.createVertex();
					vertex.setUUID(idDependsOn.get(0));
					vertex.getDependsOn().add(vertex);
					instances.add(vertex);

					dependency.Vertex vertexCopy; 
					vertexCopy = factory.createVertex();
					vertexCopy.setUUID(id);
					vertexCopy.getDependsOn().add(vertex);
					instances.add(vertexCopy);
				}
			}else{
				System.out.println("Is instance");
			}
		}else if(idDependsOn.size() > 1){
			System.out.println("size > 1");
			List<dependency.Vertex> addDependency = new ArrayList<dependency.Vertex>();
			dependency.Vertex mainVertex = null; 
			for(String depends : idDependsOn){
				System.out.println("___ depends : "+depends);
				dependency.Vertex v = getVertex(depends);

				if(!isInstance(depends)){
					System.out.println("NO Instance");
					dependency.Vertex vertex = null;
					if(id.equals(depends)){
						vertex = factory.createVertex();
						vertex.setUUID(id);
						vertex.getDependsOn().add(vertex);
						System.out.println("***newVertex : "+vertex);
						mainVertex = vertex;
						instances.add(mainVertex);

					}else{
						dependency.Vertex newVertex; 
						newVertex = factory.createVertex();
						newVertex.setUUID(depends);
						newVertex.getDependsOn().add(newVertex);
						System.out.println("====   newVertex : "+newVertex);
						instances.add(newVertex);
						addDependency.add(newVertex);
					}

					if(!addDependency.isEmpty()){
						System.out.println("***vertex : "+mainVertex);
						if(vertex != null){
							mainVertex.getDependsOn().addAll(addDependency);
						}	
					}

				}else{
					System.out.println("Instance");
					dependency.Vertex otherVertex = getVertex(depends);
					if(otherVertex != null){
						
						List<dependency.Vertex> vs = otherVertex.getDependsOn();
						System.out.println("vs  : " + vs);
						
						addDependency.addAll(vs);
						
						
						if(!addDependency.isEmpty()){
							System.out.println("addDependency  : " + addDependency);
							
							//mainVertex.getDependsOn().addAll(addDependency);
						}
					}		
				}
			}
		}
	}


	public static boolean isInstance(String id){
		boolean isinstance = false;
		for(dependency.Vertex instance : instances){
			if(instance.getUUID().equals(id)){
				isinstance = true;
				break;
			}else{
				isinstance = false;
			}
		}
		return isinstance;
	}

	public static dependency.Vertex getVertex(String id){
		dependency.Vertex vertex = null;
		for(dependency.Vertex v : instances){
			if(v.getUUID().equals(id)){
				vertex = v;
				break;
			}
		}
		return vertex;
	}



	public static dependency.Vertex createVertex(String id){
		dependency.Vertex vertex = factory.createVertex();
		vertex.setUUID(id);
		instances.add(vertex);
		vertex.getDependsOn().add(vertex);
		System.out.println("vertex : "+ vertex.getUUID());
		return vertex;
	}

	public static Graph createGraph(Map<String, ArrayList<String>> dependencies){
		//instances = graph.getInstances();
		Iterator it = dependencies.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();

			//System.out.println("k "+e.getKey());
			System.out.println(e.getKey() + " " + e.getValue());
			createVertex(e.getKey().toString(), (ArrayList)e.getValue());
			/*if(((ArrayList)e.getValue()).size() == 1){
				if(((ArrayList)e.getValue()).get(0).toString().equals(e.getKey().toString())){
					if(!instances.contains(e.getKey().toString())){
						createVertex(e.getKey().toString());
					}
				}else{
					if(!instances.contains(((ArrayList)e.getValue()).get(0).toString())){
						if(!instances.contains(e.getKey().toString())){
							createVertex(((ArrayList)e.getValue()).get(0).toString(), e.getKey().toString());
						}
					}
				}
			}else if(((ArrayList)e.getValue()).size() > 1){
				for(Object depends : (ArrayList)e.getValue()){
					String idDepends = depends.toString();
					System.out.println("idDepends "+idDepends);
					//createVertex(e.getKey().toString(),idDepends);
					if(!idDepends.equals(e.getKey().toString())){
						if(!instances.contains(idDepends)){
							createVertex(idDepends);
						}
					}else{
						createVertex(e.getKey().toString(), (ArrayList)e.getValue());
					}
				}
			}*/

		}
		return graph;
	}

}
