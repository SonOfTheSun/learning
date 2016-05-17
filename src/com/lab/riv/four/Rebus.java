package com.lab.riv.four;

import java.util.HashMap;
import java.util.Map;

public class Rebus {

	private Map<String, Integer> values = new HashMap<>();
	//private int[][] startEnd = { { 1, 9 }, { 0, 9 }, { 0, 9 } };
	private int[] k = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private int count = 0;
	private int one = 0, two = 1, answer = 2;
	private String[] words = new String[3];

	public Rebus(String oneWord, String twoWord, String answerWord) {
		words[one] = oneWord;
		words[two] = twoWord;
		words[answer] = answerWord;
	}

	public void calculate2() {
		goWord(0, words[one], 1);
		System.out.println("Итого найдено " + count + " решений");
	}

	private void goWord(int index, String word, int wordIndex) {
		int start = index == 0 ? 1 : 0;
		String code = getStringByIndex(word, index);
		if (isExistCode(code)) {
			goDawn(index, word, wordIndex);
		} else {
			for (int i = start; i <= 9; i++) {
				if (isExist(k[i]))
					continue;
				addValueToCode(code, k[i]);
				goDawn(index, word, wordIndex);
				removeCode(code);
			}
		}
	}
	
	private void goDawn(int index, String word, int wordIndex){
		if (word.length() == index + 1) {
			if (wordIndex != words.length)
				goWord(0, words[wordIndex], wordIndex + 1);
			else if (isSuccesfull()) {
				count++;
				display();
			}
		} else
			goWord(index + 1, word, wordIndex);
	}

	private boolean isExistCode(String code) {
		return values.containsKey(code);
	}

	private boolean isExist(int o) {
		return values.containsValue(o);
	}

	private boolean isSuccesfull() {
		return isSuccesfull(words[one], words[two], words[answer]);
	}

	public boolean isSuccesfull(String oneWord, String twoWord, String answer) {
		Integer oneNumber = stringToInteger(oneWord);
		Integer twoNumber = stringToInteger(twoWord);
		Integer answerNumber = stringToInteger(answer);
		return answerNumber == oneNumber + twoNumber;
	}

	public Integer stringToInteger(String word) {
		int number = 0;
		int rank = word.length() - 1;
		for (int i = 0; i < word.length(); i++) {
			number += values.get(getStringByIndex(word, i)) * Math.pow(10, rank--);
		}
		return number;
	}

	public void addValueToCode(String code, int value) {
		if (values.get(code) == null)
			values.put(code, value);
	}

	private void removeCode(String code) {
		values.remove(code);
	}

	private String getStringByIndex(String string, int index) {
		return string.substring(index, index + 1);
	}

	private void display() {
		Integer oneNumber = stringToInteger(words[one]);
		Integer twoNumber = stringToInteger(words[two]);
		Integer answerNumber = oneNumber + twoNumber;
		System.out.printf("Найденное решение: %d + %d = %d\n", oneNumber, twoNumber, answerNumber);
	}
}
