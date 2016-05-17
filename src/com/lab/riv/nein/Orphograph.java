package com.lab.riv.nein;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Orphograph {

	public static final String exitWord = "exit"; 
	private Pattern pattern = Pattern.compile("([чщ][яю]|[жш]ы)?");
	public static final String helloMessage = "Программа для проверки правила русского языка:\n" +
			"\"Гласные И, А, У после шипящих в разных частях слова: жи, ши, ча, ща, чу, щу\"\n" +
			"Вводите слова разделяя пробелом и нажмитжышые \"Ввод\". В случае ошибки программа сообщит вам об этом" + 
			"для выхода из программы введите \"" + exitWord +"\"";
	public static final String noErrorMessage = "Поздравляю, все слова написаны без ошибок";
	
	private Map<String, String> resolve = new HashMap<>();
	private List<Pare> wordsWithError = new ArrayList<>();
	
	{
		resolve.put("жы", "жи");
		resolve.put("шы", "ши");
		resolve.put("чя", "ча");
		resolve.put("щя", "ща");
		resolve.put("чю", "чу");
		resolve.put("щю", "щу");
	}
	
	/**
	 * Создание сообщения об ошибке
	 * @param wordsWithError слова с ошибками
	 * @return
	 */
	private String createErrorMessage(){
		int count = wordsWithError.size();
		StringBuilder message = new StringBuilder("Увы, вы допустили ");
		message.append(count);
		message.append(count == 1 ? " ошибку " : count < 5 ? " ошибки " : " ошибок ").append(":");
		wordsWithError.forEach(word -> { message.append("\n" + word);});
		return message.toString();
	}
	
	/**
	 * Вывод сообщения пользователю
	 */
	private void printMessage(){
		if(wordsWithError.size()>0){
			System.out.println(createErrorMessage());
			wordsWithError.clear();
		}else
			System.out.println(noErrorMessage);
	}
	
	/**
	 * Проверка, правильно ли написано слово
	 * @param word
	 * @return true - если слово написано с ошибкой, false - если написано верно
	 */
	private boolean errorValidation(String word){
		Matcher mather = pattern.matcher(word);
		boolean isError = false;
		String goodWord = word;
		while(mather.find()){
			int count = mather.groupCount();
			String errorSlog = mather.group(1);
			if(errorSlog != null){
				goodWord = replaceError(goodWord, errorSlog);
				isError = true;
			}
		}
		if(isError){
			wordsWithError.add(new Pare(word, goodWord));
		}
		return isError;
	}
	
	private String replaceError(String word, String errorSlog) {
		return word.replaceAll(errorSlog, resolve.get(errorSlog));
	}
	
	public void start(){
		Scanner input  = new Scanner(System.in);
		System.out.println(helloMessage);
		boolean noExit = true;
		while(noExit){
			String words = input.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(words, " ");
			while(tokenizer.hasMoreTokens()){
				String word = tokenizer.nextToken();
				if(word.toLowerCase().equals(exitWord))
				{
					noExit = false;
					break;
				}
				errorValidation(word);
			}
			if(noExit)
			printMessage();
		}
		input.close();
	}
	
	public static void main(String[] args) {
		Orphograph orphograph = new Orphograph();
		orphograph.start();
	}
	
	private class Pare{
		
		private String errorWord;
		private String solveWord;
		
		public Pare(String word, String replaceError) {
			this.errorWord = word;
			this.solveWord = replaceError;
		}
		
		@Override
		public String toString() {
			return String.format("%s, Правильное написание: %s", errorWord, solveWord);
		}
	}
}
