import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //도시의 수
        int M = Integer.parseInt(br.readLine()); //여행 계획에 속한 도시들의 수

        StringTokenizer st;
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            list[i] = new ArrayList<>();

            for (int j = 1; j <= N; j++) {
                int flag = Integer.parseInt(st.nextToken());
                if (flag == 1) list[i].add(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        Queue<Integer> plan = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            plan.add(Integer.parseInt(st.nextToken()));
        }

        int start = plan.poll();
        String result = "YES";

        while (!plan.isEmpty()) {
            int end = plan.poll();
            boolean flag = false;

            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[N + 1];
            queue.add(start);
            visited[start] = true;

            while (!queue.isEmpty()) {
                int city = queue.poll();
                if (city == end) {
                    flag = true;
                    break;
                }

                for (int c : list[city]) {
                    if (!visited[c]) {
                        queue.add(c);
                        visited[c] = true;
                    }
                }
            }

            if (!flag) {
                result = "NO";
                break;
            }

            start = end;
        }

        System.out.println(result);
    }
}