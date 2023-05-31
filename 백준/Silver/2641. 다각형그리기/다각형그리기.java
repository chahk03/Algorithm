import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //표본 모양수열의 길이
        String origin = br.readLine().replace(" ", "");
        
        //순 방향 (수열 두번 합치기)
        String forward = origin + origin;

        //반대 방향 (숫자 변환한 뒤 방향 바꾸기)
        String backward = "";
        int[] dir = {0, 3, 4, 1, 2};
        
        for (int i = 0; i < N; i++) {
            int num = dir[origin.charAt(i) - '0'];
            backward = String.valueOf(num) + backward;
        }

        backward = backward + backward;

        int count = 0;
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine()); //모양수열의 개수

        for (int i = 0; i < M; i++) {
            String seq = br.readLine();
            String input = seq.replace(" ", "");
            if (forward.contains(input) || backward.contains(input)) {
                count++;
                sb.append(seq).append("\n");
            }
        }

        System.out.println(count);
        System.out.println(sb);
    }
}