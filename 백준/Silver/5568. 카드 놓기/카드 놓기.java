import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int n, k;
    static String[] cards;
    static boolean[] visited;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //총 카드 장수
        k = Integer.parseInt(br.readLine()); //선택 카드 장수
        cards = new String[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            cards[i] = br.readLine();
        }

        set = new HashSet<>();
        perm(0, "");
        System.out.println(set.size());
    }

    static void perm(int cnt, String str) {
        if (cnt == k) {
            set.add(Integer.parseInt(str));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm(cnt + 1, str + cards[i]);
                visited[i] = false;
            }
        }
    }
}