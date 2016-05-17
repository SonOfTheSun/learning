package com.lab.riv.six;

public class Hypotenusa {
	
	static Calculation PRIMITIVE = () -> {
		double a, b, c;
		a = 10.0; b = 4.0;
		c = Math.sqrt(a*a + b*b);
	};
	
	static Calculation OBJECT = () -> {
		Double a, b, c;
		a = 10.0; b = 4.0;
		c = Math.sqrt(a*a + b*b);
	};
	static Calculation PRIMITIVE_WITH_PRINT = () -> {
		double a, b, c;
		a = 10.0; b = 4.0;
		c = Math.sqrt(a*a + b*b);
		System.out.println("Гипотенуза равна " + c);
	};
	
	static Calculation OBJECT_WITH_PRINT = () -> {
		Double a, b, c;
		a = 10.0; b = 4.0;
		c = Math.sqrt(a*a + b*b);
		System.out.println("Гипотенуза равна " + c);
	};
	
	
	public static void main(String[] args) {
		long timeObj = mediumTime(OBJECT);
		System.out.println("среднее время выполнения расчета гипотенузы с объектными типами -> " + timeObj);
		long time = mediumTime(PRIMITIVE);
		System.out.println("среднее время выполнения расчета гипотенузы с примитивными типами -> " + time);
	}
	
	private static long mediumTime(Calculation calculation){
		long mediumTime = 0;
		int countIteration = 100000;
		for(int i=0; i<countIteration;i++){
			long start = System.nanoTime();
			calculation.calc();
			long end = System.nanoTime();
			mediumTime+=(end-start);
		}
		return mediumTime/100000;
	}
	
	private static long timeInvoke(Calculation calculation){
		long mediumTime = 0;
		int countIteration = 100000;
		for(int i=0; i<countIteration;i++){
			long start = System.nanoTime();
			calculation.calc();
			long end = System.nanoTime();
			mediumTime+=(end-start);
		}
		return mediumTime/100000;
	}
	
	
	@FunctionalInterface
	private interface Calculation{
		public void calc();
	}

}
