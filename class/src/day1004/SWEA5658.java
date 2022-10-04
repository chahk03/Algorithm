package day1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SWEA5658 { // 보물상자 비밀번호
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 숫자 개수
			int K = Integer.parseInt(st.nextToken()); // 크기 순서
			
			String str = br.readLine();
			ArrayList<Long> list = new ArrayList<>();
			int cnt = N / 4;
			
			for(int i = 0; i < cnt; i++) {
				String front = String.valueOf(str.charAt(N - 1));
				str = front.concat(str);
				
				for(int j = 0; j <= N - cnt; j += cnt) {
					String num = str.substring(j, j + cnt);
					Long decimal = Long.parseLong(num, 16);
					if(!list.contains(decimal)) list.add(decimal);
				}
			}
			
			Collections.sort(list, Comparator.reverseOrder());
			System.out.println("#" + t + " " + list.get(K - 1));
		}
	}
}
