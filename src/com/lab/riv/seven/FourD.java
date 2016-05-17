package com.lab.riv.seven;

public class FourD extends ThreeD {
	int t;

	FourD(int a, int b, int c, int d) {

	super(a, b, c);

	t = d;

	}
	
	@Override
	public void show() {
		super.show();
		System.out.print(t+"\t");
	}
	
	@Override
	public String showHead(){
		return super.showHead() + "t\t";
	}
}
