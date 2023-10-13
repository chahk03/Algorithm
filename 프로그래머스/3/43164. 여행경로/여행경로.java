import java.util.*;

class Solution {
    boolean[] visited;
    List<String> results;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        results = new ArrayList<>();
        dfs(0, "ICN", "ICN", tickets);
        
        Collections.sort(results);
        String[] answer = results.get(0).split(" ");        
        return answer;
    }
    
    private void dfs(int cnt, String start, String info, String[][] tickets) {
        if(cnt == tickets.length) {
            results.add(info);
            return;
        }        
        
        for(int i = 0; i < tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(cnt + 1, tickets[i][1], info + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}