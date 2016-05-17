package com.lab.riv.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 *
 * @author LittlePrince
 */
public class Rebus {
	
	private static List<Integer> myxa = new ArrayList<Integer>(Arrays.asList(4,5,6,3));
	private static Set<Integer> slon = new HashSet<Integer>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(Operator.isSuccesfull(myxa, slon));
		//display();
		Operator oper = new Operator();
		oper.calculate2();
	}
	
	private static void display(){
		System.out.print("myxa:");
		myxa.forEach(value -> System.out.print(value));
		System.out.print(", слон:");
		slon.forEach(value -> System.out.print(value));
		System.out.println(" size = " + slon.size());
	}

}
