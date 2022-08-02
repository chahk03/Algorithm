package day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[100];
		
		for(int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine()); // 덤프 횟수
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken()); // 상자 배열
            }
             
            for(int i = 0; i < n; i++) {
                Arrays.sort(arr);
                arr[0] += 1;
                arr[99] -= 1;
            }
             
            Arrays.sort(arr);
            System.out.println("#" + t + " " + (arr[99] - arr[0]));
        }
	}
}
