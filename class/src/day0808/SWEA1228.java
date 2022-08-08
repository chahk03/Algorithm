package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1228 { // 암호문1
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			ArrayList<Integer> list = new ArrayList<>();
			
			int N = Integer.parseInt(br.readLine()); // 원본 암호문 길이
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken())); // 원본 암호문 저장
			}
			
			int O = Integer.parseInt(br.readLine()); // 명령어 개수
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < O; i++) {
				String order = st.nextToken();
				if(order.equals("I")) {
					int index = Integer.parseInt(st.nextToken());
					int count = Integer.parseInt(st.nextToken());
					
					for (int j = 0; j < count; j++) {
						list.add(index++, Integer.parseInt(st.nextToken()));	
					}
				}
			}
			
			sb.append("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
