package exam07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2615 {

	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {0, 1, 1}; // 8방향
	static int[] dy = {1, 1, 0}; // 8방향
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력문
		
		map = new int[19][19]; // 오목판 배열
		visit = new boolean[19][19]; // 검사 확인 배열
		
		// 바둑알 정보 입력
		for(int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 모든 오목판 위치 탐색
		for(int i = 0; i < 19; i++) {
			for(int j = 0; j < 19; j++) {
				if(map[i][j] != 0) { // 알이 놓인 경우
					for(int d = 0; d < 3; d++) { // 8방향 모두 탐색
						check(i, j, 1, d, map[i][j]); // 해당 방향으로 오목알 확인
					}
				}
			}
		}
		
		System.out.println(0); // 승부가 결정되지 않은 경우 출력
	}
	
	// 해당 방향으로 같은 색의 오목알이 5알 놓여있는지 확인하는 함수
	static void check(int x, int y, int n, int d, int c) {
		// 같은 색 5알이 연속으로 놓인 경우
		if(n == 5) {
			// 6알이 놓일 위치가 없는 경우, 6알이 같은 색의 알이 아닌 경우
			if(x + dx[d] < 0 || x + dx[d] >= 19 || y + dy[d] < 0 || y + dy[d] >= 19 || map[x + dx[d]][y + dy[d]] != c) {
				System.out.println(c); // 색상 출력
				System.out.println((x + 1 - 4 * dx[d]) + " " + (y + 1 - 4 * dy[d])); // 가장 왼쪽, 위쪽 위치 출력
				System.exit(0); // 프로그램 종료
			} else if(map[x + dx[d]][y + dy[d]] == c) { // 6알 위치에 같은 색의 알이 놓인 경우
				return; // 이긴 경우가 아니므로 리턴
			}
		}
		
		// 유효한 오목판 위치가 아닌 경우
		if(x + dx[d] < 0 || x + dx[d] >= 19 || y + dy[d] < 0 || y + dy[d] >= 19) {
			return;
		}
		
		// 일직선에 같은 색상이 놓여있지 않은 경우
		if(map[x + dx[d]][y + dy[d]] != c) {
			return;
		}
		
		// 검사하지 않은 오목판 위치인 경우
		
		check(x + dx[d], y + dy[d], n + 1, d, c); // 재귀 함수 호출로 다음 위치 알 확인
		
	}
}
