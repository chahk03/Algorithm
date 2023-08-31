class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        for(int lotto : lottos) {
            if(lotto == 0) answer[0] += 1;
            for(int win_num : win_nums) {
                if(lotto == win_num) {
                    answer[0] += 1;
                    answer[1] += 1;
                }
            }
        }
        
        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];
        return answer;
    }
}