package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 { // 설탕 배달
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 5킬로부터 전부 사용한 뒤 3킬로 사용
		// 남은 용량을 3킬로로 나눌 수 없다면 5킬로 하나씩 줄이면서 체크
		// 정확한 N킬로를 만들 수 없다면 -1 출력
		
		int result = N / 5;
		N = N % 5;
		
		while(true) {
			if(N % 3 == 0) {
				result += N / 3;
				break;
			} else {
				if(result == 0) {
					result = -1;
					break;
				}
				
				result -= 1;
				N += 5;
			}
		}
		
		System.out.println(result);
	}
}
