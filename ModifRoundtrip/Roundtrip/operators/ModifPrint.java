/**
 * 
 *  operator to print all the ecore+modif elements
 *
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Jean-Philippe Babau
 *  22/11/2013
 */

package operators;

import ecoremodif.*;
import ecoremodif.impl.*;

public class ModifPrint implements ModifElementVisitor {
	
	public void VisitRoot(RootEcoreModif rm){
		// access to the root package 
		EpackageModifImpl root = (EpackageModifImpl) rm.getRoot();
		
		// visitor call for root package
		root.accept(this);
	}
	
	public void Visit(EpackageModif pm) {

		// print the properties of the package (ecore and then modif part)
		if (pm.getEcore()==null){
			System.out.println("EPackage: null");					
		}
		else {		
			System.out.println("EPackage:"+pm.getEcore().toString());		
		}
		if (pm.getModif()==null){
			System.out.println("PackageModification: null");					
		}
		else {		
		System.out.println("PackageModification:"+pm.getModif().toString());
		}
		System.out.println("");	
		
		// for each  subpackage	
		for (EpackageModif subPackage : pm.getPackageModif()) {
			//  visitor call for each subpackage
			((EpackageModifImpl) subPackage).accept(this);
		}
		// for each subclass	
		for (EclassModif subClass: pm.getClassModif()) {		
			//  visitor call for each subclass
			((EclassModifImpl)subClass).accept(this);			
		}
		// for each subDataType	
		for (EdataTypeModif subDataType : pm.getDataTypeModif()) {
			//  visitor call for each subclass
			((EdataTypeModifImpl) subDataType).accept(this);
		}
		// for each subEnum	
		for (EnumModif subEnum : pm.getEnumModif()) {
			//  visitor call for each subclass
			((EnumModifImpl) subEnum).accept(this);			
		}
	}
	
	public void Visit(EclassModif cm){

		// print the properties of the class (ecore and then modif part)
		if (cm.getEcore()==null){
			System.out.println("EClass: null");					
		}
		else {
			System.out.println("EClass:"+cm.getEcore().toString());
		}
		
		if (cm.getModif()==null){
			System.out.println("ClassModification: null");					
		}
		else {
			System.out.println("ClassModification:"+cm.getModif().toString());		
		}
		System.out.println("");	
		
		// for each attribute	
		for (EattributeModif att: cm.getAttributeModif()) {
			//  visitor call for each attribute
			((EattributeModifImpl)att).accept(this);		
		}
		// for each reference	
		for (EreferenceModif ref: cm.getReferenceModif()) {
			//  visitor call for each reference
			((EreferenceModifImpl)ref).accept(this);		
		}
	}
	
	public void Visit(EattributeModif am){

		if (am.getEcore()==null){
			System.out.println("EAttribute: null");					
		}
		else {
			System.out.println("EAttribute:"+am.getEcore().toString());
		}
		
		if (am.getModif()==null){
			System.out.println("AttributeModification: null");					
		}
		else {
			System.out.println("AttributeModification:"+am.getModif().toString());		
		}
		System.out.println("");	

	}
	
	public void Visit(EreferenceModif rm){

		if (rm.getEcore()==null){
			System.out.println("EReference: null");					
		}
		else {
			System.out.println("EReference:"+rm.getEcore().toString());
		}
		
		if (rm.getModif()==null){
			System.out.println("ReferenceModification: null");					
		}
		else {
			System.out.println("ReferenceModification:"+rm.getModif().toString());		
		}
		System.out.println("");	

	}
	
	public void Visit(EdataTypeModif dtm){	
		
		if (dtm.getEcore()==null){
			System.out.println("EDataType: null");					
		}
		else {
			System.out.println("EDataType:"+dtm.getEcore().toString());
		}
		
		if (dtm.getModif()==null){
			System.out.println("DataTypeModification: null");					
		}
		else {
			System.out.println("DataTypeModification:"+dtm.getModif().toString());		
		}
		System.out.println("");		
	}
	
	public void Visit(EnumModif enm){	
		
		if (enm.getEcore()==null){
			System.out.println("EEnum: null");					
		}
		else {
			System.out.println("EEnum:"+enm.getEcore().toString());
		}
		
		if (enm.getModif()==null){
			System.out.println("EnumModification: null");					
		}
		else {
			System.out.println("EnumModification:"+enm.getModif().toString());		
		}
		System.out.println("");		
		
		// for each subEnumLiteral	
		for (EnumLiteralModif subEnumLit : enm.getEnumLiteralModif()) {
			//  visitor call for each subenum
			((EnumLiteralModifImpl) subEnumLit).accept(this);			
		}
	}

	public void Visit(EnumLiteralModif elm){	
		
		if (elm.getEcore()==null){
			System.out.println("EEnumLiteral: null");					
		}
		else {
			System.out.println("EEnumLiteral:"+elm.getEcore().toString());
		}
		
		if (elm.getModif()==null){
			System.out.println("EnumLiteralModification: null");					
		}
		else {
			System.out.println("EnumLiteralModification:"+elm.getModif().toString());		
		}
		System.out.println("");		
	}
	
}
