package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 { // DNA 비밀번호
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이
		
		String str = br.readLine(); // 임의의 DNA 문자열
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken()); // A 포함 개수
		int C = Integer.parseInt(st.nextToken()); // C 포함 개수
		int G = Integer.parseInt(st.nextToken()); // G 포함 개수
		int T = Integer.parseInt(st.nextToken()); // T 포함 개수
		
		int result = 0;
		
		int cntA = 0, cntC = 0, cntG = 0, cntT = 0;
		for(int i = 0; i < P; i++) {
			char dna = str.charAt(i);
			
			switch(dna) {
			case 'A':
				cntA++; break;
			case 'C':
				cntC++; break;
			case 'G':
				cntG++; break;
			case 'T':
				cntT++; break;
			}
		}
		
		if(A <= cntA && C <= cntC && G <= cntG && T <= cntT) {
			result += 1;
		}
		
		for(int i = 1; i <= S - P; i++) {
			char front = str.charAt(i - 1);
			char back = str.charAt(i + P - 1);
			
			switch(front) {
			case 'A':
				cntA--; break;
			case 'C':
				cntC--; break;
			case 'G':
				cntG--; break;
			case 'T':
				cntT--; break;
			}
			
			switch(back) {
			case 'A':
				cntA++; break;
			case 'C':
				cntC++; break;
			case 'G':
				cntG++; break;
			case 'T':
				cntT++; break;
			}
			
			if(A <= cntA && C <= cntC && G <= cntG && T <= cntT) {
				result += 1;
			}
		}
		
		System.out.println(result);
	}
}
