package day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO1828 { // 냉장고
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 화학물질 수
		int[][] arr = new int[N][2]; // 최저 온도, 최고 온도
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		// 1. 최저 온도 낮은 순으로 정렬
		// 2. 최고 온도 높은 순으로 정렬
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o2[1] - o1[1];
				else return o1[0] - o2[0];
			}
		});
		
		int result = 1;
		int max = arr[0][1];
		for(int i = 0; i < N - 1; i++) {
			if(max < arr[i + 1][0]) {
				max = arr[i + 1][1];
				result += 1;
			}
			
			if(max > arr[i + 1][1]) {
				max = arr[i + 1][1];
			}
		}
		
		System.out.println(result);
	}
}
