package day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 { // 괄호 짝짓기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			int result = 1;
			Stack<Character> stack = new Stack<>();
			
			for(int i = 0; i < str.length(); i++) {
				char input = str.charAt(i);
				
				if(input == '(' || input == '[' || input == '{' || input == '<') {
					stack.push(input);
				} else {
					if(stack.isEmpty()) {
						result = 0; 
						break;
					}
					
					char output = stack.pop();
					char expect = ' ';
					
					if(input == ')') {
						expect = '(';
					} else if(input == ']') {
						expect = '[';
					} else if(input == '}') {
						expect = '{';
					} else if(input == '>') {
						expect = '<';
					}
					
					if(output != expect) {
						result = 0;
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
