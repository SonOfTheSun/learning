package com.lab.riv.eight;

import java.util.StringTokenizer;

public class MyParser {
	public static void main(String[] args) {

		String s = "������, ������� �� ����� ��������� �� �����";

		StringTokenizer st = new StringTokenizer(s, " \t\n\r,.");

		while (st.hasMoreTokens()) {
			// �������� ����� � ���-������ ������ � ���, ��������,
			// ������ ������� �� �����
			System.out.println(st.nextToken());
		}

	}
}
