package com.lab.riv.five.test;

import com.lab.riv.four.Rebus;

import junit.framework.TestCase;

public class TestRebus extends TestCase {

	public void testStringToInteger(){
		String dva= "ÄÂÀ";
		String tri= "ÒÐÈ";
		String five= "ÏßÒÜ";
		Rebus r = new Rebus(dva, tri, five);
		//r.calculate2();
		r.addValueToCode("Ä",1);
		r.addValueToCode("Â",2);
		r.addValueToCode("À",3);
		r.addValueToCode("Ò",4);
		r.addValueToCode("Ð",5);
		r.addValueToCode("È",6);
		r.addValueToCode("Ï",7);
		r.addValueToCode("ß",8);
		r.addValueToCode("Ò",1);
		r.addValueToCode("Ü",9);
		
		assertEquals((int)123, (int)r.stringToInteger(dva));
		assertEquals((int)456, (int)r.stringToInteger(tri));
		assertEquals((int)7849, (int)r.stringToInteger(five));
	}
	
	public void testSuccesfull(){
		String dva= "ÄÂÀ";
		String tri= "ÒÐÈ";
		String five= "ÏßÒÜ";
		
		Rebus r = new Rebus(dva, tri, five);
		
		r.addValueToCode("Ä",1);
		r.addValueToCode("Â",2);
		r.addValueToCode("À",3);
		r.addValueToCode("Ò",9);
		r.addValueToCode("Ð",7);
		r.addValueToCode("È",5);
		//r.addValueToCode("Ï",1);
		//r.addValueToCode("ß",0);
		//r.addValueToCode("Ò",9);
		//r.addValueToCode("Ü",8);
		
		assertTrue(r.isSuccesfull(dva, tri, five));
	}
	
}
