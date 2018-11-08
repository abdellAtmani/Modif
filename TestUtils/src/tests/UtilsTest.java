package tests;

import utils.UtilsPrint;

public class UtilsTest {

	public static void main(String[] args) {
	
		UtilsPrint up =new UtilsPrint();
		
		System.out.println("produit "+up.printCalcul1(1, 2));
		System.out.println("sqrt  "+up.printCalcul2(1, 1));

	}

}
