package com.lab.riv.five.test;

import com.lab.riv.four.Rebus;

import junit.framework.TestCase;

public class TestRebus extends TestCase {

	public void testStringToInteger(){
		String dva= "���";
		String tri= "���";
		String five= "����";
		Rebus r = new Rebus(dva, tri, five);
		//r.calculate2();
		r.addValueToCode("�",1);
		r.addValueToCode("�",2);
		r.addValueToCode("�",3);
		r.addValueToCode("�",4);
		r.addValueToCode("�",5);
		r.addValueToCode("�",6);
		r.addValueToCode("�",7);
		r.addValueToCode("�",8);
		r.addValueToCode("�",1);
		r.addValueToCode("�",9);
		
		assertEquals((int)123, (int)r.stringToInteger(dva));
		assertEquals((int)456, (int)r.stringToInteger(tri));
		assertEquals((int)7849, (int)r.stringToInteger(five));
	}
	
	public void testSuccesfull(){
		String dva= "���";
		String tri= "���";
		String five= "����";
		
		Rebus r = new Rebus(dva, tri, five);
		
		r.addValueToCode("�",1);
		r.addValueToCode("�",2);
		r.addValueToCode("�",3);
		r.addValueToCode("�",9);
		r.addValueToCode("�",7);
		r.addValueToCode("�",5);
		//r.addValueToCode("�",1);
		//r.addValueToCode("�",0);
		//r.addValueToCode("�",9);
		//r.addValueToCode("�",8);
		
		assertTrue(r.isSuccesfull(dva, tri, five));
	}
	
}
