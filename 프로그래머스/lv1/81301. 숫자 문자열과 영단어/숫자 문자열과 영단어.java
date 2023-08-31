class Solution {
    public int solution(String s) {
        String answer = "";
        String[] words = {"zero", "one", "two", "three", "four",
                         "five", "six", "seven", "eight", "nine"};
        
        while(s.length() != 0) {
            boolean flag = true;
            
            for(int i = 0; i < 10; i++) {
                if(s.startsWith(words[i])) {
                    flag = false;
                    answer += i;
                    s = s.substring(words[i].length(), s.length());
                }
            }
            
            if(flag) {
                answer += s.charAt(0);
                s = s.substring(1, s.length());
            }
        }
        
        return Integer.parseInt(answer);
    }
}