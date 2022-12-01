package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1918 { // 후위 표기식
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < str.length(); i++) {
			char chr = str.charAt(i);
			switch (chr) {
			case '+':
				while(!stack.isEmpty()) {
					char op = stack.peek();
					if(op == '(') break;
					
					sb.append(stack.pop());
				}
				stack.push('+');
				break;
			case '-':
				while(!stack.isEmpty()) {
					char op = stack.peek();
					if(op == '(') break;
					
					sb.append(stack.pop());
				}
				stack.push('-');
				break;
			case '*':
				while(!stack.isEmpty()) {
					char op = stack.peek();
					if(op == '+' || op == '-' || op == '(') break;
					
					sb.append(stack.pop());
				}
				stack.push('*');
				break;
			case '/':
				while(!stack.isEmpty()) {
					char op = stack.peek();
					if(op == '+' || op == '-' || op == '(') break;
					
					sb.append(stack.pop());
				}
				stack.push('/');
				break;
			case '(':
				stack.push('(');
				break;
			case ')':
				while(!stack.isEmpty()) {
					char op = stack.pop();
					if(op == '(') break;
					
					sb.append(op);
				}
				break;
			default:
				sb.append(chr);
				break;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.println(sb);
	}
}
