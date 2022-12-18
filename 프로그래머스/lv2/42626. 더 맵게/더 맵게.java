import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int new_scoville = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while(true) {
            if(pq.size() == 1) {
                answer = -1;
                break;
            }
            
            new_scoville = pq.poll() + 2 * pq.poll();
            pq.add(new_scoville);
            answer++;
            
            if(pq.peek() >= K) break;
        }
        
        return answer;
    }
}