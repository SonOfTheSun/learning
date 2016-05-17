package com.lab.riv.five;

import java.util.Calendar;

public abstract class AbstractDataProvider implements DataProvider{
	
	protected String[] args = new String[2];
	private String name;
	private int age;
	
	public static DataProvider createDataProvider(String type){
		if(CONSOLE.equals(type)) return new ConsoleDataProvider();
		if(FILE.equals(type)) return new FileDataProvider();
		return new ConsoleDataProvider();
	}
	
	abstract protected void readData() throws Exception;
	
	abstract protected void writeData(String data) throws Exception;
	
	private int getAge(String date) {
		Calendar c = Calendar.getInstance();
		String[] dates = date.split("\\.");
		if(c.get(c.MONTH) > Integer.valueOf(dates[0]))
			if(c.get(c.DAY_OF_MONTH) > Integer.valueOf(dates[1]))
				return c.get(c.YEAR) - Integer.valueOf(dates[2]);
		return c.get(c.YEAR) - Integer.valueOf(dates[2]) -1;
		
	}
	
	private void initData(){
		try{
			if(args[0].matches("\\d{2}\\.\\d{2}\\.\\d{4}")){
				age = getAge(args[0]);
				name = args[1];
			}else{
				age = getAge(args[1]);
				name = args[0];
			}
		}catch(Exception e){
			System.err.println("Не удалось инициализировать данные");
			e.printStackTrace();
		}
	}
	
	protected String getResultMessage(){
		return String.format("Привет, %s. Тебе %s лет.", name, age);
	}
	
	public void displayMessage(){
		try{
			readData();
		}catch(Exception e){
			System.err.println("Не удалось инициализировать данные");
			e.printStackTrace();
		}
		initData();
		try {
			writeData(getResultMessage());
		} catch (Exception e) {
			System.err.println("Ошибка записи данных");
			e.printStackTrace();
		}
	}

}
