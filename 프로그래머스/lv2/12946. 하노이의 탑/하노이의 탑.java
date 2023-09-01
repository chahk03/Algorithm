import java.util.*;

class Solution {
    private int idx = 0;
    
    public int[][] solution(int n) {
        int[][] answer = new int[(int) Math.pow(2, n) - 1][2];
        hanoi(n, 1, 2, 3, answer);
        
        return answer;
    }
    
    private void hanoi(int n, int from, int between, int to, int[][] answer) {
        if(n == 1) {
            answer[idx++] = new int[]{from, to};
            return;
        }
        
        hanoi(n - 1, from, to, between, answer);
        answer[idx++] = new int[]{from, to};
        hanoi(n - 1, between, from, to, answer);
    }
}