import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();       
        hanoi(n, 1, 2, 3, list);
        
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private void hanoi(int n, int from, int between, int to, List<int[]> list) {
        if(n == 0) return;
        hanoi(n - 1, from, to, between, list);
        list.add(new int[]{from, to});
        hanoi(n - 1, between, from, to, list);        
    }
}