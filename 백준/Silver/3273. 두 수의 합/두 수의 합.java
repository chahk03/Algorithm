import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //수열의 크기
        StringTokenizer st = new StringTokenizer(br.readLine()); //수열
        int x = Integer.parseInt(br.readLine()); //두 수의 합

        HashSet<Integer> set = new HashSet<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (set.contains(num)) result++;
            else set.add(x - num);
        }

        System.out.println(result);
    }
}