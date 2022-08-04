package day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 { // 암호생성기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			
			Queue<Integer> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			int num = 1;
			while(true) {
				int temp = queue.poll() - num;
				
				if(temp <= 0) {
					queue.add(0);
					break;
				}
				
				queue.add(temp);
				num += 1;
				
				if(num > 5) num = 1;
			}
			
			sb.append("#" + T + " ");
			for(int value : queue) {
				sb.append(value).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
}
