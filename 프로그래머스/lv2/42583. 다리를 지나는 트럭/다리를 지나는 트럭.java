import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truck_weight = 0;
        int truck_number = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }
        
        while(!queue.isEmpty()) {
            answer++;
            truck_weight -= queue.poll();
            
            if(truck_number < truck_weights.length) {
                if(truck_weight + truck_weights[truck_number] <= weight) {
                    queue.add(truck_weights[truck_number]);
                    truck_weight += truck_weights[truck_number];
                    truck_number++;
                } else {
                    queue.add(0);
                }
            }
        }
        
        return answer;
    }
}