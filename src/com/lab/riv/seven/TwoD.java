package com.lab.riv.seven;

public class TwoD {
	int x, y;

	TwoD(int a, int b) {

	x = a;

	y = b;

	}
	
	public void show(){
		System.out.print(x+"\t");
		System.out.print(y+"\t");
	}
	
	public String showHead(){
		return "x\ty\t";
	}
}
