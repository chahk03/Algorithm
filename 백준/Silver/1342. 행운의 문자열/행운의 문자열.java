import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String S;
    static int[] alpha;
    static List<Character> list;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        alpha = new int[26];
        list = new ArrayList<>();

        for (char chr : S.toCharArray()) {
            alpha[chr - 97]++;
            if (alpha[chr - 97] == 1) list.add(chr);
        }

        lucky(0, -1, "");
        System.out.println(result);
    }

    static void lucky(int len, int idx, String str) {
        if (len == S.length()) {
            result++;
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == idx) continue;
            char chr = list.get(i);
            if (alpha[chr - 97] == 0) continue;

            alpha[chr - 97]--;
            lucky(len + 1, i, str + list.get(i));
            alpha[chr - 97]++;
        }
    }
}