import java.util.*;

class Solution {
    Set<String> set; // visit check
    
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }
    
    private int bfs(String begin, String target, String[] words) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        set = new HashSet<>();
        pq.add(new Info(0, begin));
        set.add(begin);
        
        while(!pq.isEmpty()) {
            Info info = pq.poll();
            if(info.word.equals(target)) return info.cnt;
            
            for(String word : words) {
                int differ = 0;
                for(int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) != info.word.charAt(i)) {
                        differ += 1;
                    }
                }
                
                if(differ == 1 && set.add(word)) {
                    pq.add(new Info(info.cnt + 1, word));
                }
            }
        }
        
        return 0;
    }
    
    class Info implements Comparable<Info> {
        int cnt;
        String word;
        
        Info(int cnt, String word) {
            this.cnt = cnt;
            this.word = word;
        }
        
        public int compareTo(Info info) {
            return this.cnt - info.cnt;
        }
    }
}