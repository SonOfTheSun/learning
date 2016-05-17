
package com.lab.riv.seven;

import java.util.Comparator;

public class ArraySort {
	Comparator comparator;
	static int cnt = 0;
	boolean less(Double v, Double w){ // ����� ���������� ��� ��������
		cnt++;
		return comparator.compare(v, w) < 0;
	}
	void exch(double[] a, int i, int j) { // ����� ���������� ��� ��������
		double t = a[i]; a[i] = a[j]; a[j] = t;
	}
	void compExch(double[] a, int i, int j){ // ����� ���������� � ���������� ��� ��������
		if (less(a[j], a[i])) exch(a,i,j);
	}
	void sort(double[] a, int l, int r, Comparator<? extends Comparable> comparator) {
		this.comparator = comparator;
		for (int i = l+1; i<=r; i++)
			for (int j = i; j > l; j--)
				compExch(a, j-1, j);
	}
	public static void main(String[] args) {
		try {
			ArraySort sorter = new ArraySort();
		    int N = Integer.parseInt("10");
		    double a[] = new double[N];
			for (int i = 0; i < N; i++)	a[i] = Math.random();
			System.out.println("��������������� ������: ");
			if (N < 100) for (int i = 0; i < N; i++) System.out.println(a[i] + "");
			//TODO ���� ���� �� ���������, ��� ��� ����� Digit �� ��������� Comparable
			/*sorter.sort(a, 0, N-1, new Comparator<Digit>(){
				@Override
				public int compare(Digit o1, Digit o2) {
					return 0;
				}});*/
			sorter.sort(a, 0, N-1, new Comparator<Double>(){
				@Override
				public int compare(Double o1, Double o2) {
					return o1.compareTo(o2);
				}});
			System.out.println("������������� ������: ");
			if (N < 100) for (int i = 0; i < N; i++) System.out.println(a[i] + "");
			System.out.println("������������ ���������: " + cnt);
		}catch (Exception e) {
			System.out.println("Exception: " + e.toString());
			e.printStackTrace();
		}
		
	}
	
	private class Digit{}
}
