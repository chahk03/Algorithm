import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static List<Node> virusList;
    static int emptyCnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Node[] temp;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //연구소 크기
        M = Integer.parseInt(st.nextToken()); //바이러스 개수

        virusList = new ArrayList<>();
        map = new int[N][N];
        temp = new Node[M];
        emptyCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                if (value == 0) emptyCnt++;
                if (value == 2) {
                    emptyCnt++;
                    map[i][j] = 0;
                    virusList.add(new Node(i, j, 0));
                }
            }
        }

        if (emptyCnt > M) {
            comb(0, 0);
            result = result == Integer.MAX_VALUE ? -1 : result;
        } else {
            result = 0;
        }

        System.out.println(result);
    }

    static void comb(int cnt, int depth) {
        if (cnt == M) {
            int[][] copyMap = new int[N][N];
            for (int i = 0; i < N; i++) {
                copyMap[i] = map[i].clone();
            }

            Queue<Node> queue = new ArrayDeque<>(Arrays.asList(temp));
            result = Math.min(result, bfs(queue, copyMap, emptyCnt));
            return;
        }

        for (int i = depth; i < virusList.size(); i++) {
            temp[cnt] = virusList.get(i);
            map[temp[cnt].x][temp[cnt].y] = 1;
            comb(cnt + 1, i + 1);
            map[temp[cnt].x][temp[cnt].y] = 0;
        }
    }

    static int bfs(Queue<Node> queue, int[][] map, int total) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int d = 0; d < 4; d++) {
                int x = node.x + dx[d];
                int y = node.y + dy[d];

                if (0 <= x && x < N && 0 <= y && y < N && map[x][y] == 0) {
                    map[x][y] = node.w + 1;
                    queue.add(new Node(x, y, map[x][y]));
                    total--;
                }

                if (total == M) {
                    return node.w + 1;
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static class Node {
        int x, y, w;

        Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
}