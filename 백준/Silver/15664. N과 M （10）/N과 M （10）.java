import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] num;
    static HashSet<String> set;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //N개의 자연수 중에서
        M = Integer.parseInt(st.nextToken()); //M개를 고른 수열
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        set = new HashSet<>();
        sb = new StringBuilder();
        comb(0, 0, "");
        System.out.println(sb);
    }

    static void comb(int cnt, int idx, String str) {
        if (cnt == M) {
            if (!set.contains(str)) {
                set.add(str);
                sb.append(str).append("\n");
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            comb(cnt + 1, i + 1, str + (num[i] + " "));
        }
    }
}