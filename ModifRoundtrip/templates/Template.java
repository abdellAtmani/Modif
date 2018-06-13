package %%%JAVAPACKAGE;

import %%%PACKAGE.%%%ROOTCLASS;

public class %%%CLASS {
	
	static String model;
	static String metamodel;
	static String graph;
	static String output;
	
	public %%%CLASS(String model, String metamodel, String graph, String output){
		this.model = model;
		this.metamodel = metamodel;
		this.graph = graph;
		this.output = output;
	}
	
	public static void main(String[] args){
		 %%%ROOTCLASS %%%VARROOTCLASS = new %%%ROOTCLASS();
		 %%%VARROOTCLASS.%%%FUNCTION(model, metamodel, graph, output);
	}
}
