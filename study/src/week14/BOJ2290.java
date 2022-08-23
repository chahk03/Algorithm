package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2290 {
	static int s, n;
	static char[][] arr;
	static int row, col;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		s = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		row = 2 * s + 3;
		col = s + 2;
		arr = new char[row][col + col + 1];
		
		makeNum(0, 0, 0);
		makeNum(0, 5, 0);
		print();
	}
	
	static void makeNum(int x, int y, int num) {
		for(int i = x; i < x + row; i++) {
			if(i == x || i == x + row / 2 || i == x + row - 1) {
				for(int j = y + 1; j < y + col - 1; j++) {
					arr[i][j] = '-';
				}
			} else {
				arr[i][y] = '|';
				arr[i][y + col - 1] = '|';
			}
		}
	}
	
	static void print() {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col + col + 1; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
