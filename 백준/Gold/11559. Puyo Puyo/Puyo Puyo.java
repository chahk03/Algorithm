import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static List<int[]> puyo;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        int result = 0;

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        while (true) {
            boolean flag = false;
            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        puyo = new ArrayList<>();
                        check(i, j, map[i][j]);

                        if (puyo.size() >= 4) { //뿌요 제거
                            flag = true;
                            for (int[] p : puyo) {
                                map[p[0]][p[1]] = '.';
                            }
                        }
                    }
                }
            }

            if (!flag) break;
            result++;
            down();
        }

        System.out.println(result);
    }

    //같은 뿌요 확인
    static void check(int i, int j, char c) {
        visited[i][j] = true;
        puyo.add(new int[]{i, j});

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (0 <= ni && ni < 12 && 0 <= nj && nj < 6 && !visited[ni][nj] && map[ni][nj] == c) {
                check(ni, nj, c);
            }
        }
    }

    //뿌요 떨어뜨리기
    static void down() {
        for (int j = 0; j < 6; j++) {
            Queue<Character> queue = new ArrayDeque<>();
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] != '.') queue.add(map[i][j]);
            }

            for (int i = 11; i >= 0; i--) {
                if (!queue.isEmpty()) map[i][j] = queue.poll();
                else map[i][j] = '.';
            }
        }
    }
}