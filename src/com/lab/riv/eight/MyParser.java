package com.lab.riv.eight;

import java.util.StringTokenizer;

public class MyParser {
	public static void main(String[] args) {

		String s = "—трока, которую мы хотим разобрать на слова";

		StringTokenizer st = new StringTokenizer(s, " \t\n\r,.");

		while (st.hasMoreTokens()) {
			// ѕолучаем слово и что-нибудь делаем с ним, например,
			// просто выводим на экран
			System.out.println(st.nextToken());
		}

	}
}
