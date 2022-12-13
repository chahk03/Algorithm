import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // 코드
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            
            if(chr == '(') {
                stack.push('(');
            } else {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    answer = false;
                    break;
                }
            }
        }

        if(!stack.isEmpty()) answer = false;
        
        return answer;
    }
}