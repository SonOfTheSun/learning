package com.lab.riv.eight;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BasaReader {
	public static void main(String args[]) throws IOException {
		String str;
		FileReader fin = new FileReader("src\\com\\lab\\riv\\eight\\base.txt");
		Scanner src = new Scanner(fin); // Чтение из файла
		StringTokenizer st;
		while (src.hasNextLine()) {
			str = src.nextLine();
			st = new StringTokenizer(str, " \t\n\r,.");
			while (st.hasMoreTokens()) {
				if(st.countTokens() != 2){
					System.out.print(st.nextToken() + " ");
				}else
					st.nextToken();
			}
			System.out.println();
		}
		fin.close();
	}
}
