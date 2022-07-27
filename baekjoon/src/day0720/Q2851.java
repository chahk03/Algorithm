package day0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2851 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[10];
		for(int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int idx = 0;
		int sum = 0;
		while(idx < 10) {
			sum += arr[idx++];
			
			if(sum >= 100) {
				if(sum - 100 > 100 - (sum - arr[idx - 1])) sum -= arr[idx - 1];
				break;
			}
		}
		
		System.out.println(sum);
	}
}
