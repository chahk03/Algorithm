package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 { // Z
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 배열 크기: 2에 N승
		int r = Integer.parseInt(st.nextToken()); // 행
		int c = Integer.parseInt(st.nextToken()); // 열
		
		int start = 0, setNum = 0;
		int squared = squared(N);
		int result = 0;
		
		for(int n = 0; n < N; n++) {
			squared /= 2;
			setNum = r / squared * 2 + (c / squared);
			start += setNum * squared * squared;
			r = r % squared;
			c = c % squared;
			
			if(r < 2 && c < 2) {
				if(r == 0) {
					if(c == 0) result = start;
					else if(c == 1) result = start + 1;
				} else if(r == 1) {
					if(c == 0) result = start + 2;
					else if(c == 1) result = start + 3;
				}
			}
		}
		
		System.out.println(result);
	}
	
	static int squared(int cnt) {
		if(cnt == 0) return 1;
		if(cnt == 1) return 2;
		return squared(cnt - 1) * 2;
	}
}
