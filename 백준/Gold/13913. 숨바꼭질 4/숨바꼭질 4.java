import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //수빈이 위치
        int K = Integer.parseInt(st.nextToken()); //동생 위치
        int[] map = new int[100001];
        Arrays.fill(map, -1);

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(N, 0));
        map[N] = 0;

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (p.pos == K) {
                System.out.println(p.time);
                break;
            }

            if (0 <= p.pos - 1 && map[p.pos - 1] == -1) {
                map[p.pos - 1] = p.pos;
                pq.add(new Point(p.pos - 1, p.time + 1));
            }

            if (p.pos + 1 <= 100000 && map[p.pos + 1] == -1) {
                map[p.pos + 1] = p.pos;
                pq.add(new Point(p.pos + 1, p.time + 1));
            }

            if (p.pos * 2 <= 100000 && map[p.pos * 2] == -1) {
                map[p.pos * 2] = p.pos;
                pq.add(new Point(p.pos * 2, p.time + 1));
            }
        }

        StringBuilder sb = new StringBuilder(String.valueOf(K));
        while (K != N) {
            sb.insert(0, map[K] + " ");
            K = map[K];
        }

        System.out.println(sb);
    }

    static class Point implements Comparable<Point> {
        int pos, time;

        public Point(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            return this.time - o.time;
        }
    }
}