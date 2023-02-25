import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] info = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int rank = 0;
			
			int w = info[i][0];
			int h = info[i][1];
			
			for(int j = 0; j < N; j++) {
				if(j == i)
					continue;
				
				if((info[j][0] > w) && (info[j][1] > h))
					rank++;
			}
			
			sb.append((rank + 1) + " ");
		}
		
		System.out.println(sb);

	}

}