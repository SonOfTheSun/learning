package com.lab.riv.seven;

public class Coords<T extends TwoD> {
	T[] coords;

	Coords(T[] o) {

	coords = o;

	}
	
	public void showHead(){
		System.out.println(coords[0].showHead());
	}
}
