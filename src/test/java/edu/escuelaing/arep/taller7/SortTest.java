package edu.escuelaing.arep.taller7;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import edu.escuelaing.arep.taller7.utils.SortUtil;

/**
 * Unit test for simple App.
 */
public class SortTest {
	
	@Test
	public void shouldSort() {
		double[] array = {10,9,8,7,6,5,4,3,2,1};
		double[] expected = {1,2,3,4,5,6,7,8,9,10};
		double[] res = SortUtil.sort(array);
		
		assertArrayEquals(expected, res, 0);
	}
	
	@Test
	public void shouldSortNegative() {
		double[] array = {-1,-2,-3,-4,-5,-6,-7,-8,-9,10};
		double[] expected = {-9,-8,-7,-6,-5,-4,-3,-2,-1,10};
		double[] res = SortUtil.sort(array);
		
		assertArrayEquals(expected, res, 0);
	}
	
	@Test
	public void shouldSortNegativeDecimal() {
		double[] array = {2,1.99999,1.999,1.91,1.9,1.8};
		double[] expected = {1.8,1.9,1.91,1.999,1.99999,2};
		double[] res = SortUtil.sort(array);
		
		assertArrayEquals(expected, res, 0);
	}

}
