package com.lab.riv.eight;

import java.util.Stack;
import java.util.StringTokenizer;

public class StackTest {
	static boolean checkParity(String expression, String open, String close) {

		Stack<String> stack = new Stack<String>();
		StringTokenizer st = new StringTokenizer(expression,
				" \t\n\r+*/-(){}", true);
		while (st.hasMoreTokens()) {
			String tmp = st.nextToken();
			if (tmp.equals(open))
				stack.push(open);

			if (tmp.equals(close)){
				if(stack.empty()){ 
					return false;
				}else{
					stack.pop();
				}
			}
		}
		if (stack.isEmpty())
			return true;
		return false;

	}

	public static void main(String[] args) {

		System.out.println(checkParity("a - ((b) - (c - a) / (b + c) - 2)", "(", ")"));
	}
}
