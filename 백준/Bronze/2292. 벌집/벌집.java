import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 끝점
		int start = 1; // 시작점
		int i = 1;
		
		while(true) {
			if(N == 1)
				break;
			
			start = start + 6 * i;
			i++;
			
			if(start >= N)
				break;
		}
		
		
		System.out.println(i);
		
	}

}