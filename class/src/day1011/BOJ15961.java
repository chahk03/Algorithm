package day1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15961 { // 회전 초밥 (hard)
	static int N, d, k, c;
	static int[] adjArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 벨트 위 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥 가지 수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		adjArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			adjArr[i] = Integer.parseInt(br.readLine());
		} // end input
		
		int[] numCnt = new int[d + 1];
		
		int max = 0;
		int first = 0;
		int last = k;
		
		numCnt[c] = 1; max++;
		
		// 첫번째 ~ k번째
		for(int i = 0; i < k; i++) {
			numCnt[adjArr[i]] += 1;
			if(numCnt[adjArr[i]] == 1) max++;
		}
		
		int result = max;
		
		for(int i = 1; i < N; i++) {
			if(last >= N) last -= N;
			
			numCnt[adjArr[first]] -= 1;
			if(numCnt[adjArr[first++]] == 0) max--;
			numCnt[adjArr[last]] += 1;
			if(numCnt[adjArr[last++]] == 1) max++;
			
			result = Math.max(result, max);
		}
		
		System.out.println(result);
	}
}
