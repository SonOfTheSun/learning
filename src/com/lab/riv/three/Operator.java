package com.lab.riv.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 *
 * @author LittlePrince
 */
public class Operator {
	
	private int[] end = {4,9,9,9};
	private int[] m = {0,1,2,3,4,5,6,7,8,9};
	private int[] y = {0,1,2,3,4,5,6,7,8,9};
	private int[] x = {0,1,2,3,4,5,6,7,8,9};
	private int[] a = {0,1,2,3,4,5,6,7,8,9};
	private List<Integer> myxa = new ArrayList<Integer>();
	private List<Integer> slon = new LinkedList<Integer>();
	private Stack<Integer> buff = new Stack();
	private int count = 0;

	public void calculate(){
		for(int i=0; i<=4;i++){
			myxa.add(0, m[i]);
			for(int j=0; j<=9;j++){
				if(myxa.contains(y[j])) continue;
				myxa.add(1, y[j]);
				for(int k=0; k<=9;k++){
					if(myxa.contains(x[k])) continue;
					myxa.add(2, x[k]);
					for(int n=1; n<10;n++){
						if(myxa.contains(a[n])) continue;
						myxa.add(3, a[n]);
						if(isSuccesfull()){
							count++;
							display();
						}
						myxa.remove(3);
						slon.clear();
					}
					myxa.remove(2);
				}
				myxa.remove(1);
			}
			myxa.remove(0);
		}
		System.out.println("Итого найдено " + count + " решений");
	}
	
	public void calculate2(){
		go(0);
		System.out.println("Итого найдено " + count + " решений");
	}
	
	private void go(int index){
		for(int i = 0; i<=end[index]; i++){
			//if(myxa.contains(x[i])) continue;
			if(!validate(x[i])) continue;
			myxa.add(index, x[i]);
			if(index == 3 && isSuccesfull()){
					count++;
					display();
					slon.clear();
			}else
				go(index+1);
			myxa.remove(index);
		}
	}
	
	private boolean validate(int o){
		return buff.search(o) == -1;
	}
	
	private boolean isSuccesfull(){
		return isSuccesfull(myxa, slon);
	}
	
	/**
	 * Выполняет заполнянение коллекции "slon", проверяет, является ли решение удовлетворяющим условие задачи
	 * @param c1 myxa
	 * @param c2 slon
	 * @return true если удовлетворяет
	 */
	public static boolean isSuccesfull(List<Integer> c1, List<Integer> c2){
		int one = 0;
		Set<Integer> temp = new HashSet<>();
		for(int z = 3; z>=0;z--){
			int d = c1.get(z)*2+one;
			if(temp.add(d%10)){
				((LinkedList<Integer>)c2).addFirst(d%10);
				if(d>10) 
					one = 1;
				else
					one = 0;
			}else{
				return false;
			}
			if(!temp.add(c1.get(z)))
				return false;
			
		}
		return true;
	}
	
	private boolean notConstraint(){
		List<Integer> c = new ArrayList<Integer>(slon);
		return c.retainAll(myxa) && c.isEmpty();
	}
	
	private void display(){
		System.out.print("myxa:");
		myxa.forEach(value -> System.out.print(value));
		System.out.print(", слон:");
		slon.forEach(value -> System.out.print(value));
		System.out.println(" size = " + slon.size());
	}
}
