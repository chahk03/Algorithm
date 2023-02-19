import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int count[] = new int[26];
		int max = 0;
		int result = 0;
		
		for(int i = 0; i < str.length(); i++) {
			int eng = str.charAt(i);
			
			if(eng >= 97)
				eng -= 32;
			
			count[eng - 65]++;
		}
		
		for(int j = 0; j < 26; j++) {
			
			if(count[j] > max) {
				max = count[j];
				result = j + 65;
				
			} else if(count[j] == max) {
				result = 63;
			}
		}
		
		System.out.println((char)(result));
		
	}

}