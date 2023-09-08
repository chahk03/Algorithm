import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] cost = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            Arrays.fill(cost[i], 20000001);
            cost[i][i] = 0;
        }
        
        for(int[] fare : fares) {
            cost[fare[0]][fare[1]] = cost[fare[1]][fare[0]] = fare[2];
        }
        
        // 플로이드-워셜 알고리즘
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            answer = Math.min(answer, cost[s][i] + cost[i][a] + cost[i][b]);
        }
        
        return answer;
    }
}