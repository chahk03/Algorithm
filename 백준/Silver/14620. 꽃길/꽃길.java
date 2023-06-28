import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int answer = 3001;
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //화단의 한 변의 길이
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);
        System.out.println(answer);
    }

    static void bfs(int cnt, int cost) {
        if (cnt == 3) {
            answer = Math.min(answer, cost);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                boolean flag = true;
                for (int d = 0; d < 5; d++) {
                    if (visited[i + dx[d]][j + dy[d]]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    int temp = map[i][j];
                    visited[i][j] = true;
                    for (int d = 1; d <= 4; d++) {
                        temp += map[i + dx[d]][j + dy[d]];
                        visited[i + dx[d]][j + dy[d]] = true;
                    }

                    bfs(cnt + 1, cost + temp);
                    for (int d = 0; d < 5; d++) {
                        visited[i + dx[d]][j + dy[d]] = false;
                    }
                }
            }
        }
    }
}
