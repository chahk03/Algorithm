import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        boolean[] visited = new boolean[input.length];

        int count = input.length / 5;
        if (input.length % 5 != 0) count += 1;

        int[][] quacks = new int[count][5];
        int[] ducks = new int[quacks.length];
        Arrays.fill(ducks, -1);
        
        char[] quack = {'q', 'u', 'a', 'c', 'k'};
        int result = 0;

        for (int i = 0; i < quacks.length; i++) {
            int idx = 0;
            for (int j = 0; j < input.length; j++) {
                if (idx == 5) break;
                if (!visited[j] && input[j] == quack[idx]) {
                    visited[j] = true;
                    quacks[i][idx] = j;
                    idx++;
                }
            }

            if (idx != 5) {
                result = -1;
                break;
            }
        }

        if (result != -1) {
            for (int i = 0; i < quacks.length; i++) {
                for (int j = 0; j < ducks.length; j++) {
                    if (ducks[j] < quacks[i][0]) {
                        ducks[j] = quacks[i][4];
                        result = Math.max(result, j + 1);
                        break;
                    } 
                }
            }
        }

        System.out.println(result);
    }
}