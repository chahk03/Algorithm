package day0808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1158 { // 요세푸스 문제
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int N = Integer.parseInt(st.nextToken()); // 사람 수
		int K = Integer.parseInt(st.nextToken()); // 제거 번호
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0, idx = 1; i < N; i++) {
			list.add(idx++);
		}
		
		int idx = K - 1;
		while(!list.isEmpty()) {
			if(idx >= list.size()) {
				idx %= list.size();
			}
			
			if(list.size() > 1) {
				sb.append(list.get(idx) + ", ");				
			} else {
				sb.append(list.get(idx));
			}
			
			list.remove(idx);
			idx += (K - 1);
		}
		
		sb.append(">");
		System.out.println(sb);
	}
}
