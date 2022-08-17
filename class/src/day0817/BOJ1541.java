package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 { // 잃어버린 괄호
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] numStr = str.split("-");
		int[] num = new int[numStr.length]; // -로 구분된 식의 결과값 저장 배열
		
		for(int i = 0; i < numStr.length; i++) {
			if(numStr[i].contains("+")) { // +를 포함한 식인 경우
				String[] plusNum = numStr[i].split("\\+");
				
				int sum = 0;
				for(int j = 0; j < plusNum.length; j++) {
					sum += Integer.parseInt(plusNum[j]);
				}
				
				num[i] = sum; // 합계 저장
				continue;
			}
			
			// +를 포함하지 않은 경우 숫자 그대로 저장
			num[i] = Integer.parseInt(numStr[i]);
		}
		
		int result = num[0];
		for(int i = 1; i < num.length; i++) {
			result -= num[i]; // -로 구분한 각각의 식의 결과값 빼기
		}
		
		System.out.println(result);
	}
}
