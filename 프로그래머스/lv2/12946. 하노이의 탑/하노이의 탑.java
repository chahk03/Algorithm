import java.util.*;

class Solution {
    public int[][] solution(int n) {
        List<int[]>[] lists = new ArrayList[16];        
        for(int i = 1; i <= 15; i++) {
            lists[i] = new ArrayList<>();
        }
        
        lists[1].add(new int[]{1, 3});
        
        for(int i = 2; i <= n; i++) {
            for(int[] list : lists[i - 1]) {
                int[] tmp = new int[2];
                tmp[0] = list[0];
                tmp[1] = list[1];
                
                if(list[0] == 2) tmp[0] = 3;
                else if(list[0] == 3) tmp[0] = 2;
                if(list[1] == 2) tmp[1] = 3;
                else if(list[1] == 3) tmp[1] = 2;
                
                lists[i].add(tmp);
            }
            
            lists[i].add(new int[]{1, 3});
            
            for(int[] list : lists[i - 1]) {
                int[] tmp = new int[2];
                tmp[0] = list[0];
                tmp[1] = list[1];
                
                if(list[0] == 1) tmp[0] = 2;
                else if(list[0] == 2) tmp[0] = 1;
                if(list[1] == 1) tmp[1] = 2;
                else if(list[1] == 2) tmp[1] = 1;
                
                lists[i].add(tmp);
            }
        }
        
        int[][] answer = new int[lists[n].size()][2];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = lists[n].get(i);
        }
        
        return answer;
    }
}