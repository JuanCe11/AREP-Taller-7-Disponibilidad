package edu.escuelaing.arep.taller7.utils;

/**
 *	Class that sort an array 
 */
public class SortUtil {
	
	/**
	 * Method that sorts an array
	 * 
	 * @param ada_array the array
	 * @return sorted array
	 */
	public static double[] sort(double[] ada_array) {		
		mergeSort(ada_array, 0, ada_array.length - 1);
		return ada_array;
	}
	
	/**
	 * Divides the array recursively
	 * 
	 * @param ada_array the array
	 * @param ai_left left index
	 * @param ai_right right index
	 */
	private static void mergeSort(double[] ada_array, int ai_left, int ai_right) {
		if (ai_left < ai_right) {
			int li_middle = (ai_left + ai_right)/2;
			mergeSort(ada_array, ai_left, li_middle);
			mergeSort(ada_array, li_middle + 1, ai_right);
			merge(ada_array, ai_left, li_middle, ai_right);
		}
	}
	
	/**
	 * Merges all the sorted array parts 
	 * 
	 * @param ada_array the array
	 * @param ai_left left index
	 * @param ai_middle middle index
	 * @param ai_right right index
	 */
	private static void merge(double[] ada_array, int ai_left, int ai_middle, int ai_right) {
		int li_n1;
		int li_n2;
		double[] lda_left;
		double[] lda_right;
		
		li_n1 = ai_middle - ai_left + 1;
		li_n2 = ai_right - ai_middle;
		lda_left = new double [li_n1];
		lda_right = new double [li_n2];
		
		for (int i = 0; i < li_n1; i++) {
			lda_left[i] = ada_array[ai_left + i];
		}
		
		for (int j = 0; j < li_n2; j++) {
			lda_right[j] = ada_array[ai_middle + 1 + j];
		}
		
		{
			int li_i;
			int li_j;
			int li_k;
			
			li_i = 0;
			li_j = 0;
			li_k = ai_left;
			
			while (li_i < li_n1 && li_j < li_n2) {
				if (lda_left[li_i] <= lda_right[li_j]) {
					ada_array[li_k] = lda_left[li_i];
					li_i++;
				} else {
					ada_array[li_k] = lda_right[li_j];
					li_j++;
				}
				li_k++;
			}
			
			while (li_i < li_n1) {
				ada_array[li_k] = lda_left[li_i];
				li_i++;
				li_k++;
			}
			
			while (li_j < li_n2) {
				ada_array[li_k] = lda_right[li_j];
				li_j++;
				li_k++;
			}
		}
	}
}
