import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int turn = 0;
        
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            queue.add(i);
        }
        
        while(true) {
            int doc = queue.poll();
            boolean print = true;
            
            Queue<Integer> queue_copy = new ArrayDeque<>(queue);
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int next_doc = queue.poll();
                
                if(priorities[doc] < priorities[next_doc]) {
                    queue_copy.add(doc);
                    print = false;
                    break;
                }
            }
            
            queue = queue_copy;
            
            if(print) {
                turn++;
                
                if(location == doc) {
                    answer = turn;
                    break;
                }
            }
        }
        
        return answer;
    }
}