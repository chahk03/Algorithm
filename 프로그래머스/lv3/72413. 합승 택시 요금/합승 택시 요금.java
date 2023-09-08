import java.util.*;

class Solution {
    private List<Point>[] list;
    private int[][] map;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] fare : fares) {
            list[fare[0]].add(new Point(fare[1], fare[2]));
            list[fare[1]].add(new Point(fare[0], fare[2]));
        }
        
        map = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
            calcCost(n, i);
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        }
        
        return answer;
    }
    
    private void calcCost(int n, int i) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        pq.add(new Point(i, 0));
        map[i][i] = 0;
        
        while(!pq.isEmpty()) {
            Point cur = pq.poll();
            if(visited[cur.num]) continue;            
            visited[cur.num] = true;
            
            for(Point next : list[cur.num]) {                
                if(map[i][next.num] > map[i][cur.num] + next.cost) {
                    map[i][next.num] = map[i][cur.num] + next.cost;
                    pq.add(new Point(next.num, map[i][next.num]));
                }
            }
        }
    }
    
    class Point implements Comparable<Point> {
        int num, cost;
        
        Point(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
        
        public int compareTo(Point p) {
            return this.cost - p.cost;
        }
    }
}