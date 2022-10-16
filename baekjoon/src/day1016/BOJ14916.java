package day1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14916 { // 거스름돈
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		boolean flag = false;
		int five = n / 5;
		int two = 0;
		
		for(int i = five; i >= 0; i--) {
			int money = n - i * 5;
			two = money / 2;
			
			money -= two * 2;
			if(money == 0) {
				flag = true;
				five = i;
				break;
			}
		}
		
		if(flag) System.out.println(five + two);
		else System.out.println(-1);
	}
}
