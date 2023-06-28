import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        arr[1] = 1;

        for (int i = 0; i <= 5000; i++) {
            for (int j = 0; j <= 3333; j++) {
                int idx = 2 * i + 3 * j;
                if (idx > 10000) break;
                arr[idx] += 1;
            }
        }

        for (int i = 2; i <= 10000; i++) {
            arr[i] += arr[i - 1];
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n] + "\n");
        }

        System.out.println(sb);
    }
}