import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] cows;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //농장에 있는 소들의 수
        M = Integer.parseInt(st.nextToken()); //선별할 소의 수
        cows = new int[N]; //소들의 몸무게

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        pq = new PriorityQueue<>();
        comb(0, 0, 0);

        int tmp = 0;
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int num = pq.poll();
            if (num != tmp) {
                sb.append(num + " ");
                tmp = num;
            }
        }

        if (sb.length() == 0) System.out.println(-1);
        else System.out.println(sb);
    }

    static void comb(int cnt, int idx, int weight) {
        if (cnt == M) {
            //선별된 소의 몸무게 합이 소수인지 판별
            if (prime(weight)) pq.add(weight);
            return;
        }

        for (int i = idx; i < N; i++) {
            comb(cnt + 1, i + 1, weight + cows[i]);
        }
    }

    static boolean prime(int num) {
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }        
        return true;
    }
}