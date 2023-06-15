import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, X;
    static int[] level;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //문제 개수
        L = Integer.parseInt(st.nextToken()); //최소 난이도 합
        R = Integer.parseInt(st.nextToken()); //최대 난이도 합
        X = Integer.parseInt(st.nextToken()); //최소 난이도 차

        level = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];
        powerSet(0, 0, 0, 1000001, 0);
        System.out.println(result);
    }

    static void powerSet(int idx, int cnt, int sum, int min, int max) {
        if (idx == N) {
            if (cnt >= 2 && L <= sum && sum <= R && X <= (max - min)) result++;
            return;
        }

        visited[idx] = true;
        powerSet(idx + 1, cnt + 1, sum + level[idx], Math.min(min, level[idx]), Math.max(max, level[idx]));
        visited[idx] = false;
        powerSet(idx + 1, cnt, sum, min, max);
    }
}