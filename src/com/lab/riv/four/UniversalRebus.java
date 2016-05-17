package com.lab.riv.four;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversalRebus {

	private Map<Integer, Code> codes = new HashMap<Integer, Code>();
	//private Set<Code> codes = new HashSet<>();
	private char[] exp1, exp2, answer;
	private List<Code> expCodesOne = new ArrayList<>();
	private List<Code> expCodesTwo = new ArrayList<>();
	private List<Code> answerCodes = new ArrayList<>();
	
	public UniversalRebus(String exp1, String exp2, String answer){
		this.exp1 = exp1.toCharArray();
		this.exp2 = exp2.toCharArray();
		this.answer = answer.toCharArray();
		this.init();
	}

	private void init() {
		addCodes(exp1);
		addCodes(exp2);
		addCodes(answer);
		if(codes.size() > 10)
			throw new IllegalArgumentException("В переданном ребусе допущена неоднозначность.\n"+
					"Число кодов превышает число доступных цифр в десятичной системе счисления");
	}
	
	public void goExp1(int rank){
		for(int i = 0; i<10; i++){
			if(insertValue(i)){
				//expCodesOne.
			}
		}
	} 

	private boolean insertValue(int i) {
		return false;
	}

	private void addCodes(char[] codeArr) {
		for(int i = 0; i<codeArr.length; i++){
			getCode((int)codeArr[i]);
		}
	}
	
	private Code getCode(int charCode){
		if(codes.get(charCode) == null)
			codes.put(charCode, new Code(charCode));
		return codes.get(charCode);
	}
	
	
	private class Code{
		
		int value = -1;
		String code;
		
		Code(int code){
			this.code = String.valueOf((char)code);
		}
		
		public void setValue(int value){
			this.value = value; 
		}
		
		public void removeValue(){
			value = -1;
		}
		
		public boolean isEmpty(){
			return value == -1;
		}
		
	}
	
}
