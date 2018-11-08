package utils;

public class UtilsPrint {


	UtilsMath utils =new UtilsMath();

	public String printCalcul1(float a, float b) {
		String s ="la valeur du premier calcul est : "+utils.calculeSomme(a, b);
		return s;
	}
	
	public String printCalcul2(float a, float b) {
		
		return "la valeur du deuxiemme calcul est : "+utils.calculsqrt(a, b);
	}
	
	
}