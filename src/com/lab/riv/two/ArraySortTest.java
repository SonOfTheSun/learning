package com.lab.riv.two;

import junit.framework.TestCase;

/**
 * 
 *
 * @author LittlePrince
 */
public class ArraySortTest extends TestCase{

	
	public void testMethodLess(){
		double p1 = 3d, p2 = 5d;
		assertTrue("Сравнение елементов массива прошло неудачно", ArraySort.less(p1, p2));
	}
	
	public void testMethodExch(){
		double[] m = {1d, 2d, 3d, 4d, 5d};
		int[][] cases = {{0,1}, {0,2}, {0,3}, {1,4}, {3,2}};
		for(int i = 0; i< cases.length; i++){
			double f = m[cases[i][0]], t = m[cases[i][1]];
			ArraySort.exch(m, cases[i][0], cases[i][1]);
			assertEquals("Ошибка обмена элемента массива" ,m[cases[i][0]], t);
			assertEquals("Ошибка обмена элемента массива" ,m[cases[i][1]], f);
		}
	}
	
	public void testMethodCompExch(){
		double[][] cases = {{1d,2d},{6.3, 6.4}, {11d,10d}, {5.5, 5.4}};
		for(int i = 0; i< cases.length; i++){
			ArraySort.compExch(cases[i], 0, 1);
			assertTrue(cases[i][0]< cases[i][1]);
		}
	}

	public void testMethodSort(){
		double[] m = {9d, 3d, 7d, 4d, 5d};
		int[][] cases = {{0,4},{0,3},{1,4},{2,3},{0,2}};
		for(int n = 0; n<cases.length; n++){
			int start = cases[n][0], end = cases[n][1];
			ArraySort.sort(m, start, end);
			for(int i= start + 1; i< end-start; i++){
				assertTrue("Массив отсортирован не верно", m[i]>m[i-1]);
			}
		}
	}
}
