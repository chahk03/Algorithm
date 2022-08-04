package day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ2164 { // 카드2
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			queue.add(i + 1);
		}
		
		while(queue.size() > 1) {
			// 맨 위 카드 버리기
			queue.poll();
			
			// 맨 위 카드 아래로 옮기기
			int up = queue.poll();
			queue.add(up);
		}
		
		System.out.println(queue.poll());
	}
}
