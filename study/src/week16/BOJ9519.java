package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ9519 { // 졸려
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine()); // 눈 깜박이는 횟수
		char[] chr = br.readLine().toCharArray();
		
		int cnt = 0;
		ArrayList<String> list = new ArrayList<>();
		
		while(true) {
			char[] temp = new char[chr.length];
			
			for(int i = 0, idx = 0; i <= chr.length / 2; i++, idx += 2) {
				if(idx < chr.length) temp[idx] = chr[i];
			}
			
			for(int i = chr.length - 1, idx = 1; i >= (chr.length + 1) / 2; i--, idx += 2) {
				temp[idx] = chr[i];
			}
			
			cnt++;
			chr = temp;
			
			if(!list.contains(String.valueOf(chr))) {
				list.add(String.valueOf(chr));
			} else {				
				cnt--;
				break;
			}
		}
		
		int idx = cnt - (X % cnt);
		System.out.println(list.get(idx - 1));
	}
}
