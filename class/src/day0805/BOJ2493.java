package day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 { // 탑
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			int idx = 0;
			// 왼쪽 탑이 더 높은 경우 (레이저 쏠 수 있는 탑)
			if(i - 1 >= 0 && arr[i] <= arr[i - 1]) {
				stack.push(i - 1); // 왼쪽 탑의 인덱스 스택 추가
				idx = i; // 왼쪽 탑 번호 저장
			} else { // 왼쪽 탑이 더 낮은 경우 (레이저 쏠 수 없는 탑)
				while(!stack.isEmpty()) {
					int temp = stack.pop();
					// 스택에 저장된 탑 중에서 더 높은 탑을 찾은 경우
					if(arr[temp] >= arr[i]) {
						stack.push(temp); // 해당 탑의 인덱스 스택 추가
						idx = temp + 1; // 해당 탑 번호 저장
						break;
					}
				}
			}
			
			sb.append(idx + " ");
		}
		
		System.out.println(sb);
	}
}
