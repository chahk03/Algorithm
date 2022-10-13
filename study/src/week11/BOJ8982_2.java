package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ8982_2 { // 수족관1
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수족관 꼭짓점 개수
		ArrayList<Point> pList = new ArrayList<>();
		int R = 0, C = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			pList.add(new Point(row, col));
			
			R = Math.max(R, row);
			C = Math.max(C, col);
		}
		
		int total = 0;
		for(int i = 0; i < pList.size(); i++) {
			if(i % 2 == 0) continue;
			if(i == pList.size() - 1) continue;
			
			int row = pList.get(i).x;
			int col = pList.get(i).y;
			int next_col = pList.get(i + 1).y;
			
			for(int c = col; c < next_col; c++) {
				for(int j = 0; j < row; j++) {
					total++;
				}
			}			
		}
		
		int K = Integer.parseInt(br.readLine());
		ArrayList<Point> hList = new ArrayList<>();
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			hList.add(new Point(row, col));
		} // end input
		
		Collections.sort(hList, (o1, o2) -> o1.x - o2.x);
		
		int start = 0;
		for(int h = 0; h < hList.size(); h++) {
			for(int i = start; i < hList.get(h).x; i++) {
				int col = hList.get(h).y;
//				map[i][col] = 0;
				list[col].set(i, 0);
				
				while(true) {
					int mCol = col - 1;
					
					if(mCol < 0) break;
//					if(map[i][mCol] == 0) break;
					if(list[mCol].size() <= i) continue;
					if(list[mCol].get(i) == 0) break;
					
//					map[i][mCol] = 0;
					list[mCol].set(i, 0);
					
					col = mCol;
				}
				
				col = hList.get(h).y;
				while(true) {
					int pCol = col + 1;
					
					if(pCol >= C) break;
					if(list[pCol].size() <= i) continue;
					if(list[pCol].get(i) == 0) break;
					
					list[pCol].set(i, 0);
					col = pCol;
				}
			}
			
			start = hList.get(h).x - 1;
//			System.out.println(start);
		}
		
		int result = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
//				if(map[i][j] == 1) result++;
				if(list[j].size() <= i) continue;
				if(list[j].get(i) == 1) result++;
			}
		}
		
//		System.out.println("----------수조 비운 뒤-----------");
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(result);
	}
	
	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
