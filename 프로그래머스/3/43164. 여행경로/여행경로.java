import java.util.*;

class Solution {
    HashMap<String, List<String>> map;
    HashMap<String, Integer> visited;
    List<String> results;
    
    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        visited = new HashMap<>();
        
        for(String[] ticket : tickets) {
            visited.put(ticket[0] + ticket[1], visited.getOrDefault(ticket[0] + ticket[1], 0) + 1);
            if(map.get(ticket[0]) == null) {
                List<String> list = new ArrayList<>();
                list.add(ticket[1]);
                map.put(ticket[0], list);
            } else {
                map.get(ticket[0]).add(ticket[1]);
            }
        } // end input        
        
        results = new ArrayList<>();
        dfs(tickets.length, "ICN", "ICN");
        
        Collections.sort(results);
        String result = results.get(0);
        String[] answer = new String[result.length() / 3];
        for(int i = 0, idx = 0; i < result.length(); i += 3) {
            answer[idx++] = result.substring(i, i + 3);
        }
        
        return answer;
    }
    
    private void dfs(int cnt, String start, String info) {
        if(cnt == 0) {
            results.add(info);
            return;
        }        
        
        if(map.get(start) != null) {
            int size = map.get(start).size();
            for(int i = 0; i < size; i++) {
                String next = map.get(start).get(i);
                if(visited.get(start + next) > 0) {
                    visited.put(start + next, visited.get(start + next) - 1);
                    dfs(cnt - 1, next, info + next);
                    visited.put(start + next, visited.get(start + next) + 1);
                }
            }
        }
    }
}