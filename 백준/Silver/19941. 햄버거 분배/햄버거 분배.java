import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] chr = br.readLine().toCharArray();
        boolean[] visited = new boolean[N];
        int result = 0;

        for (int n = 0; n < N; n++) {
            if (chr[n] == 'H') {
                for (int k = -K;  k <= K; k++) {
                    if (0 <= n + k && n + k < N && chr[n + k] == 'P' && !visited[n + k]) {
                        result++;
                        visited[n + k] = true;
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}