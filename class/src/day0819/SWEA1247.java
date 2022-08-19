package day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1247 { // 최적 경로
	static int N;
	static int[][] myArr;
	static int[][] userArr;
	static int[] userNum;
	static boolean[] visit;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			myArr = new int[2][2]; // 회사, 집 좌표
			userArr = new int[N][2]; // 고객 좌표
			
			userNum = new int[N]; // 고객 방문 순서 배열
			visit = new boolean[N]; // 고객 방문 여부 체크
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < 2; j++) {
					myArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 2; j++) {
					userArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			result = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#" + t + " " + result);
		}
	}
	
	static void perm(int cnt) {
		if(cnt == N) {
			// 최소 경로 탐색
			result = Math.min(result, dist());
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				userNum[cnt] = i;
				perm(cnt + 1);
				visit[i] = false;
			}
		}
	}
	
	static int dist() {
		int dist = 0;
		
		// 회사-고객1 거리
		int idx = userNum[0];
		dist += Math.abs(myArr[0][0] - userArr[idx][0]) + Math.abs(myArr[0][1] - userArr[idx][1]);
		
		// 고객1-고객N 거리
		for(int i = 1; i < N; i++) {
			int curUser = userNum[i - 1];
			int nextUser = userNum[i];
			dist += Math.abs(userArr[curUser][0] - userArr[nextUser][0]) + Math.abs(userArr[curUser][1] - userArr[nextUser][1]);
		}
		
		// 고객N-집 거리
		idx = userNum[N - 1];
		dist += Math.abs(myArr[1][0] - userArr[idx][0]) + Math.abs(myArr[1][1] - userArr[idx][1]);
		
		return dist;
	}
}
