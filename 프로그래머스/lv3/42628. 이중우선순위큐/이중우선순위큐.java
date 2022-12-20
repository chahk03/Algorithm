import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String str : operations) {
            String op = str.split(" ")[0];
            int num = Integer.parseInt(str.split(" ")[1]);
            System.out.println(op + " " + num);
            System.out.println(pq);
            
            switch(op) {
                case "I":
                    pq.add(num);
                    break;
                case "D":
                    if(!pq.isEmpty()) {
                        if(num == 1) { // 최댓값 삭제
                            PriorityQueue<Integer> temp_pq = new PriorityQueue<>();
                            while(pq.size() > 1) {
                                temp_pq.add(pq.poll());
                            }
                            pq = temp_pq;
                        } else if(num == -1) { // 최솟값 삭제
                            pq.poll();
                        }
                    }
                    break;
            }
        }
        
        if(pq.size() == 1) {
            answer[1] = pq.poll();
            answer[0] = answer[1];
        } else if(pq.size() > 1) {
            answer[1] = pq.poll();
            while(pq.size() > 1) {
                pq.poll();
            }
            answer[0] = pq.poll();
        }
    
        return answer;
    }
}