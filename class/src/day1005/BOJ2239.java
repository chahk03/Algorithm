package day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2239 { // 스도쿠
	static int[][] map;
	static boolean[][] rVisit;
	static boolean[][] cVisit;
	static boolean[][] bVisit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		rVisit = new boolean[9][10];
		cVisit = new boolean[9][10];
		bVisit = new boolean[9][10];
		
		for(int i = 0, idx = 0; i < 9; i++) {
			String str = br.readLine();
			for(int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j) - '0';
				
				if(map[i][j] != 0) {
					int val = map[i][j];
					rVisit[i][val] = true;
					cVisit[j][val] = true;
					bVisit[idx + (j / 3)][val] = true;					
				}
			}
			
			if(i % 3 == 2) idx += 3;
		}
		
		dfs(0, 0);
	}
	
	static void dfs(int row, int col) {
		if(row == 8 && col == 9) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			System.exit(0);
			return;
		}
		
		if(col == 9) {
			dfs(row + 1, 0);
			return;
		}
		
		if(map[row][col] == 0) {
			for(int i = 1; i <= 9; i++) {
				int idx = (row - (row % 3)) + ((col - (col % 3)) / 3);
				if(!rVisit[row][i] && !cVisit[col][i] && !bVisit[idx][i]) {
					map[row][col] = i;
					rVisit[row][i] = true;
					cVisit[col][i] = true;
					bVisit[idx][i] = true;
					dfs(row, col + 1);
					map[row][col] = 0;
					rVisit[row][i] = false;
					cVisit[col][i] = false;
					bVisit[idx][i] = false;
				}
			}
			
			if(map[row][col] == 0) return;
		}
		
		dfs(row, col + 1);
	}
}
