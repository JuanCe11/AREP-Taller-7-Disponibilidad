package edu.escuelaing.arep.taller7.utils;

/**
 * Class to reads content.
 */
public class StringUtils {
	
	/**
	 * Converts the values of an array of string to an array of double.
	 *  
	 * @param as_values String array with the values to convert  
	 * @return An array of double with the converted numbers.
	 */
	public static double[] toArray(String as_values) {
		String[] lsa_valores;
		double[] lda_arreglo;
		
		lsa_valores = as_values.split(",");
		lda_arreglo = new double[lsa_valores.length];
		
		try {
			
			for (int i = 0; i < lsa_valores.length; i++) {
				lda_arreglo[i] = Double.valueOf(lsa_valores[i]);
			}
	         
		}catch(Exception e) {
			System.out.println("Imposible to charge data.");
		}
		
		return lda_arreglo;
	}
	
	
	/**
	 * Converts the values of an double array to a string 
	 *  
	 * @param ada_values An array of double with umbers. 
	 * @return An String with the numbers in format [a1,a2,...,an]
	 */
	public static String toString(double[] ada_values) {
		String ls_res;
		ls_res = "[";
		
		for (int i = 0; i < ada_values.length; i++) {
			ls_res += ada_values[i];
			if (i < ada_values.length - 1)
				ls_res += ",";
		}
		ls_res += "]";
		return ls_res;
	}

}
