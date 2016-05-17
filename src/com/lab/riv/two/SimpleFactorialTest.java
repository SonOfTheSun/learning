package com.lab.riv.two;

import junit.framework.*;

public class SimpleFactorialTest extends TestCase {
	public void testFactorial() {
		int cases[][] = { { 1, 1 }, { 2, 2 }, {3, 6} };
		for (int i = 0; i < cases.length; i++)
			assertEquals("Неверное число факториала", cases[i][1],
					fact(cases[i][0]));
	}

	int fact(int n) {
		int k = 1;  
		if (n > 1) for (int i=2; i<=n; i++) k = k * i;  
		return k;
		}


}
