package day0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686 {
	static int N, M;
	static ArrayList<int[]> cList, hList;
	static int[] list;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 크기
		M = Integer.parseInt(st.nextToken()); // 최대 치킨집 수

		cList = new ArrayList<>();
		hList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if (value == 2) {
					cList.add(new int[] {i, j});
				} else if(value == 1) {
					hList.add(new int[] {i, j});
				}
			}
		}

		list = new int[cList.size()];
		comb(0, 0);
		System.out.println(result);
	}

	// 치킨집 경우의 수 탐색
	static void comb(int cnt, int start) {
		if (cnt > M) return;

		if (cnt != 0 && cnt <= M) {
			int sum = distance(cnt);
			result = Math.min(result, sum);
		}

		for(int i = start; i < cList.size(); i++) {
			list[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	// 치킨 거리 구하는 함수
	static int distance(int cnt) {
		int sum = 0;
		for(int i = 0; i < hList.size(); i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < cnt; j++) {
				int[] h = hList.get(i);
				int[] c = cList.get(list[j]);
				min = Math.min(min, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
			}
			sum += min;
		}
		return sum;
	}
}
