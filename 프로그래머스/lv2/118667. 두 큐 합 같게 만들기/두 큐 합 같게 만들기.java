import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {        
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        long total1 = 0, total2 = 0;
        int answer = 0;
        
        for(int value : queue1) {
            q1.add(value);
            total1 += value;
        }
        
        for(int value : queue2) {
            q2.add(value);
            total2 += value;
        }
        
        while(true) {
            if(total1 == total2) break;
            if(q1.isEmpty() || q2.isEmpty() || answer > 600000) {
                answer = -1;
                break;
            }
            
            answer += 1;
            
            if(total1 < total2) {
                int num = q2.poll();
                q1.add(num);
                total2 -= num;
                total1 += num;
            } else {
                int num = q1.poll();
                q2.add(num);
                total1 -= num;
                total2 += num;
            }
        }
        
        return answer;
    }
}