package com.lab.riv.seven;

public class ThreeD extends TwoD {

	int z;

	ThreeD(int a, int b, int c) {

	super(a, b);

	z = c;

	}

	@Override
	public void show() {
		super.show();
		System.out.print(z+"\t");
	}
	
	@Override
	public String showHead(){
		return super.showHead() + "z\t";
	}

}
