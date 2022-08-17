package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15683 { // 감시
	static int N, M;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][][] dir = {{{}}, {{0}, {1}, {2}, {3}}, // 1번 CCTV
			{{0, 2}, {1, 3}}, // 2번 CCTV
			{{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 CCTV
			{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번 CCTV
			{{0, 1, 2, 3}}}; // 5번 CCTV
	static ArrayList<CCTV> cctvList;
	static int[] cctvDir;
	static int total, wall;
	static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사무실 세로
		M = Integer.parseInt(st.nextToken()); // 사무실 가로
		cctvList = new ArrayList<>(); // CCTV 목록
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 && map[i][j] != 6) cctvList.add(new CCTV(i, j, map[i][j]));
				if(map[i][j] == 6) wall += 1;
			}
		}
		
		cctvDir = new int[cctvList.size()]; // CCTV 방향 배열
		direction(0);
		System.out.println(result);
	}
	
	static void direction(int cnt) {
		if(cnt == cctvList.size()) {
			// 사각 지대 최소 크기 구하기
			int[][] copy_map = copy(map);
			total = N * M - cctvList.size() - wall; // 빈칸 개수
			
			for(int i = 0; i < cnt; i++) {
				for(int j = 0; j < dir[cctvList.get(i).d][cctvDir[i]].length; j++) {
					watch(cctvList.get(i).x, cctvList.get(i).y, dir[cctvList.get(i).d][cctvDir[i]][j]);
				}
			}
			
			result = Math.min(result, total);
			map = copy_map;
			return;
		}
		
		// CCTV 방향 경우의 수 모두 구하기
		for(int i = 0; i < dir[cctvList.get(cnt).d].length; i++) {
			cctvDir[cnt] = i;
			direction(cnt + 1);
		}
	}
	
	// 해당 방향으로 CCTV 보기
	static void watch(int x, int y, int d) {
		while(true) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(0 > nx || nx >= N || 0 > ny || ny >= M) break;
			if(map[nx][ny] == 6) break;
			
			x += dx[d];
			y += dy[d];
			
			if(map[x][y] == 0) total -= 1;
			map[x][y] = -1;
		}
	}
	
	static int[][] copy(int[][] map) {
		int[][] copy_map = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copy_map[i][j] = map[i][j];
			}
		}
		
		return copy_map;
	}
	
	static class CCTV {
		int x;
		int y;
		int d;
		
		CCTV(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
