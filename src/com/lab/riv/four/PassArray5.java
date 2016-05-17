package com.lab.riv.four;

public class PassArray5 {
	
	static void vaTest(int... v) {
		System.out.print("vaTest(int ...): " + v.length + " Содержимое: ");
		for (int x : v) System.out.print(x + " ");
		System.out.println();

	}

	static void vaTest(boolean... v) {
		System.out.print("vaTest(boolean ...): " + v.length + " Содержимое: ");
		for (boolean x : v)
			System.out.print(x + " ");
		System.out.println();
	}
	
	static void vaTest(Integer i){
		System.out.println(i == i);
	}
	
	static void vaTest(int i){
		System.out.println(12901 == 12901);
	}

	public static void main(String args[]) {

		vaTest(1, 2, 3); // Все в порядке

		vaTest(true, false, true); // Все в порядке

		//vaTest(); // Ошибка: неоднозначность
		
		vaTest(129);

	}
}
