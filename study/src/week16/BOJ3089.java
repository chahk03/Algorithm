package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3089 { // 네잎 클로버를 찾아서
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 네잎 클로버 개수
		int M = Integer.parseInt(st.nextToken()); // 외계인 전송 명령 수
		boolean[][] map = new boolean[200000][200000];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x + 100000][y + 100000] = true;
		}
		
		for(int j = 0; j < M; j++) {
			
		}
	}
}
