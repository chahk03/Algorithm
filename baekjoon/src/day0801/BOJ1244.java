package day0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 스위치 개수
		int[] arr = new int[N + 1]; // 스위치 배열: 켜져 있으면 1, 꺼져 있으면 0
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine()); // 학생 수
		for(int s = 0; s < student; s++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken()); // 성별: 남학생 1, 여학생 2
			int number = Integer.parseInt(st.nextToken()); // 받은 수
			
			if(gender == 1) {
				for(int i = 1; i < N + 1; i++) {
					if(i % number == 0) {
						arr[i] = (int) Math.pow(arr[i] - 1, 2);
					}
				}
			} else if(gender == 2) {
				arr[number] = (int) Math.pow(arr[number] - 1, 2);
				
				for(int i = 1; i < number; i++) {
					if(0 < number - i && number + i <= N) {
						if(arr[number - i] == arr[number + i]) {
							arr[number - i] = (int) Math.pow(arr[number - i] - 1, 2);
							arr[number + i] = (int) Math.pow(arr[number + i] - 1, 2);
						} else {
							break;
						}
					}
				}
			}
		}
		
		for(int i = 1; i < N + 1; i++) {
			sb.append(arr[i]).append(' ');
			if(i % 20 == 0) sb.append('\n');
		}
		
		System.out.println(sb);
	}
}
