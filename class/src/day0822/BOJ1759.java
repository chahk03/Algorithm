package day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 { // 암호 만들기
	static int L, C;
	static char[] alpha;
	static char[] pw;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		L = Integer.parseInt(st.nextToken()); // 암호 길이
		C = Integer.parseInt(st.nextToken()); // 구성 알파벳
		alpha = new char[C];
		pw = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alpha);
		comb(0, 0, 0, 0);
		System.out.println(sb);
	}
	
	static void comb(int idx, int start, int a, int b) {
		if(idx == L) {
			if(a >= 1 && b >= 2) {
				for(char chr : pw) {
					sb.append(chr);
				}
				sb.append('\n');
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			pw[idx] = alpha[i];
			if(pw[idx] == 'a' || pw[idx] == 'e' || pw[idx] == 'i' || pw[idx] == 'o' || pw[idx] == 'u') {
				comb(idx + 1, i + 1, a + 1, b);	
			} else {
				comb(idx + 1, i + 1, a, b + 1);	
			}
		}
	}
}
