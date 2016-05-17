package com.lab.riv.four;

import java.util.Formatter;

public class Ticket {
	
	private boolean isLucky = false;
	private int part1 = 0, part2 = 0;
	private String number;
	public Validator SIMPLE, HARD;
	private Validator default_valid;
	
	{
		default_valid = SIMPLE = () -> {isLucky = part1 == part2;};
		HARD = () -> {
			isLucky = luckyExp(part1) || luckyExp(part2);
		};
	}
	
	public Ticket(String number){
		this(toLong(number));
	}

	public Ticket(Long number){
		this.number = numberToString(number);
	}
	
	private static Long toLong(String number) {
		try{
			return Long.valueOf(number);
		}catch(NumberFormatException cce){
			throw new RuntimeException("Недопустимые символы в номере билета: " + number);
		}
	}
	
	public void eval(){
		eval(default_valid);
	}
	
	public void eval(Validator v){
		int length = number.length();
		for(int i=0; i<number.length()/2;i++){
			part1 += Integer.valueOf(number.substring(i, i+1));
			part2 += Integer.valueOf(number.substring(length-i-1, length-i));
		}
		v.isLucky();
	}
	
	public static void eval(Ticket ...tickets){
		for(Ticket t: tickets)
			t.eval();
	}
	
	
	private boolean luckyExp(int value){
		if(value == 0) return false;
		boolean end = true;
		int exp = 2;
		Integer result;
		while(end){
			result = (int)Math.pow(value, exp);
			if(result.equals(Integer.valueOf(number)))
				return true;
			else if(result > Integer.valueOf(number) || value ==1)
				end = false;
			exp++;
		}
		return false;
	}
	
	public boolean isLucky(){
		return isLucky;
	}
	
	public String toString(){
		return "Билет " + number + (isLucky ? " счастливый" : " не счастливый");
	}
	
	private String numberToString(long number){
		Formatter fmt = new Formatter();
		fmt.format("%06d", number);
		return fmt.toString();
	}
	
	
	@FunctionalInterface
	private interface Validator{
		public void isLucky();
	}
}
