package com.lab.riv.five;

public class Hello {

	public static void main(String[] args) {
		try {
			DataProvider dataProvider = AbstractDataProvider.createDataProvider(DataProvider.FILE);
			dataProvider.displayMessage();
		}

		catch (Throwable t) {

			System.out.print(t.getMessage());

			t.printStackTrace();

		}

	}

}
