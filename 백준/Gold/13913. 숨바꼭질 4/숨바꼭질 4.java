import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //수빈이 위치
        int K = Integer.parseInt(st.nextToken()); //동생 위치
        int[] map = new int[100001];
        Arrays.fill(map, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        map[N] = 0;

        while (!q.isEmpty()) {
            int X = q.poll();
            if (X == K) {
                break;
            }

            if (0 <= X - 1 && map[X - 1] == -1) {
                map[X - 1] = X;
                q.add(X - 1);
            }

            if (X + 1 <= 100000 && map[X + 1] == -1) {
                map[X + 1] = X;
                q.add(X + 1);
            }

            if (X * 2 <= 100000 && map[X * 2] == -1) {
                map[X * 2] = X;
                q.add(X * 2);
            }
        }

        int time = 0;
        StringBuilder sb = new StringBuilder(String.valueOf(K));
        while (K != N) {
            time += 1;
            sb.insert(0, map[K] + " ");
            K = map[K];
        }

        sb.insert(0, time + "\n");
        System.out.println(sb);
    }
}