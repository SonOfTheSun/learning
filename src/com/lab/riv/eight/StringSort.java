package com.lab.riv.eight;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StringSort {

	
	public static void main(String[] args) throws IOException {
		
		FileReader fin = new FileReader("src\\com\\lab\\riv\\eight\\base.txt");
		Scanner src = new Scanner(fin); // Чтение из файла
		StringTokenizer st;
		List<String> sortable = getListByWord(src);
		fin.close();
		sortable.sort(null);
		for(String str: sortable){
			System.out.println(str);
		}
	}
	
	public static List<String> getListByLine(Scanner src){
		List<String> sortable = new ArrayList<String>();
		while (src.hasNextLine()) {
			sortable.add(src.nextLine());
		}
		return sortable;
	}
	
	public static List<String> getListByWord(Scanner src){
		List<String> sortable = new ArrayList<String>();
		StringTokenizer st;
		while (src.hasNextLine()) {
			st = new StringTokenizer(src.nextLine()," \t\n\r+*/-(){}");
			while (st.hasMoreTokens()) {
				sortable.add(st.nextToken());
			}
		}
		return sortable;
	}
}
