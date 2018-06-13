/**
 *  utility class to manipulate files, folder and create files from templates
 *  
 *  Copyright (C) 2013 IDL
 * 
 * This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU General Public License V 3
 *  
 *  @authors Mickael Kerboeuf
 *  22/11/2013
 */

package fileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// import org.eclipse.emf.common.util.*;

/**
 * @author Mickaël
 *
 * file manipulation sueful methods
 * 
 */

public class fileUtils {

	/**
	 * Fonction utilitaire de création des dossiers
	 * @param name nom du dossier à créer
	 */
	public static void createFolder(String name) {
		File f = new File(name);
		if (f.mkdir()) System.out.println("[creating] folder "+name+": ok.");
		else System.out.println("[updating] folder "+name+": ok.");
	}

	/**
	 * Fonction utilitaire de création des fichiers de code
	 * @param name nom du fichier à créer
	 * @param content liste de lignes à écrire dans le fichier
	 * @return true si le fichier a bien été créé, false sinon
	 */
	public static boolean createFile(String name, List<String> content) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(name));
			for (String l : content) bw.write(l+"\n");
			bw.flush();
			bw.close();
			System.out.println("[creating] file "+name+": ok.");
			return true;
		} catch (IOException e) {
			System.out.println("[ERROR] trying to create file "+name);
			e.printStackTrace();
		}
		return false;
	}		

	/**
	 * Fonction utilitaire de lecture des templates de code
	 * @param name nom du template à lire
	 * @return liste des lignes chargées depuis le fichier
	 */
	public static List<String> readTemplate(String name) {
//		IWorkspace workspace = ResourcesPlugin.getWorkspace(); 
//		String templatePath = workspace.getRoot().getLocation().toFile().getPath().toString()
//					+"/ModifMigrationGenerator/templates/";
		String templatePath = "../EcoreModif2/templates/";
        List<String> res = new ArrayList<String>();
        BufferedReader br = null;
        try {
			br = new BufferedReader(new FileReader(templatePath+name));
			for (String line = br.readLine(); line!=null; line = br.readLine())
				res.add(line);
			br.close();
		} catch (IOException e) {
			System.out.println("[ERROR] trying to read file "+name);
			e.printStackTrace();
		}
		return res;
	}		

}
