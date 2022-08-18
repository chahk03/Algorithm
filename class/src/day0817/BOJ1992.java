package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 { // 쿼드트리
	static int N;
	static int[][] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 영상 크기
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		quadTree(0, 0, N);
		System.out.println(sb);
	}
	
	static void quadTree(int row, int col, int n) {
		if(check(row, col, n)) {
			sb.append(arr[row][col]);
		} else {
			int size = n / 2;
			
			sb.append('(');
			quadTree(row, col, size);
			quadTree(row, col + size, size);
			quadTree(row + size, col, size);
			quadTree(row + size, col + size, size);
			sb.append(')');
		}
	}
	
	static boolean check(int row, int col, int n) {
		int value = arr[row][col];
		for(int i = row; i < row + n; i++) {
			for(int j = col; j < col + n; j++) {
				if(arr[i][j] != value) return false;
			}
		}
		
		return true;
	}
}
