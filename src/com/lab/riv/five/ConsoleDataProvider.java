package com.lab.riv.five;

import java.util.Scanner;

public class ConsoleDataProvider extends AbstractDataProvider{
	
	private Scanner scan;
	
	private Scanner getScanner(){
		if(scan == null)
			scan = new Scanner(System.in);
		return scan;
	}

	@Override
	protected void readData() throws Exception {
		System.out.println("������� ���� ��� � ���� �������� � ������� \"��.��.����\" ����� ������: ");
		Scanner sc = getScanner();
		args = sc.nextLine().split(" ");
	}

	@Override
	protected void writeData(String data) throws Exception {
		System.out.println(getResultMessage());
	}
	
}
