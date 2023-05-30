import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int clock;
    static int[] arr;
    static int result;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = "";
        for (int i = 0; i < 4; i++) {
            str += st.nextToken();
        }

        //입력된 카드의 시계수 구하기
        clock = Integer.parseInt(str);
        for (int i = 0; i < 3; i++) {
            str = str.substring(1, 4) + str.charAt(0);
            clock = Math.min(clock, Integer.parseInt(str));
        }

        //모든 시계수들 중에서 몇 번째로 작은 시계수인지 구하기
        result = 1;
        flag = false;
        arr = new int[4];
        perm(0, "");
    }

    static void perm(int depth, String str) {
        if (flag) return;

        if (depth == 4) {
            if (clock == Integer.parseInt(str)) {
                flag = true;
                System.out.println(result);
            }

            result++;
            return;
        }

        char start = '1';
        if (depth == 1) start = str.charAt(0);
        if (depth == 2) start = str.charAt(0);
        if (depth == 3) {
            if ((str.charAt(0) == str.charAt(1) && str.charAt(1) != str.charAt(2)) || (str.charAt(0) != str.charAt(2))) {
                start = (char) (str.charAt(0) + 1);
            } else start = str.charAt(1);
        }

        for (int i = start - '0'; i <= 9; i++) {
            perm(depth + 1, str + String.valueOf(i));
        }
    }
}