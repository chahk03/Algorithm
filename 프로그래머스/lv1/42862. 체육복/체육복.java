class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n + 2];
        
        for(int num : lost) {
            students[num] = -1;
        }
        
        for(int num : reserve) {
            students[num] += 1;
        }
        
        for(int i = 1; i <= n; i++) {
            if(students[i] == 0) answer += 1;
            
            if(students[i] == 1) {
                answer += 1;
                
                if(students[i - 1] == -1) {
                    students[i - 1] += 1;
                    students[i] -= 1;
                    answer += 1;
                    continue;
                }
                
                if(students[i + 1] == -1) {
                    students[i + 1] += 1;
                    students[i] -= 1;
                }
            }
        }
        
        return answer;
    }
}