package com.lab.riv.six;

import java.util.Comparator;

public class ArraySort<T extends Comparable> {
	static int cnt = 0;

	private boolean less(T v, T w) { // метод сравнивает два элемента
		cnt++;
		return v.compareTo(w) < 0;
	}

	private void exch(T[] a, int i, int j) {
		T t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private void compExch(T[] a, int i, int j) {
		if (less(a[j], a[i]))
			exch(a, i, j);
	}

	private void sort(T[] a, int l, int r) {
		for (int i = l + 1; i <= r; i++)
			for (int j = i; j > l; j--)
				compExch(a, j - 1, j);
	}
	
	public static void main(String[] args) {
		ArraySort<Double> sorter = new ArraySort<>();
		try {
			int N = Integer.parseInt("10");
			Double a[] = new Double[N];
			double d[] = new double[N];
			for (int i = 0; i < N; i++)
				a[i] = Math.random();
			System.out.println("Несортированный массив: ");
			if (N < 100)
				for (int i = 0; i < N; i++)
					System.out.println(a[i] + "");
			sorter.sort(a, 0, N - 1);
			//sorter.sort(d, 0, N - 1); ошибка, так как double не реализует Comparable
			System.out.println("Сортированный массив: ");
			if (N < 100)
				for (int i = 0; i < N; i++)
					System.out.println(a[i] + "");
			System.out.println("Использовано сравнений: " + cnt);
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
			e.printStackTrace();
		}

	}
}
