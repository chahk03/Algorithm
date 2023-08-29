import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> result = new ArrayList<>();
        int nowDay = getDay(today);
        
        // 약관 종류별 유효기관 입력
        int[] termArr = new int[26];
        for(String term : terms) {
            String[] splitTerm = term.split(" ");
            termArr[splitTerm[0].charAt(0) - 'A'] = Integer.parseInt(splitTerm[1]);
        }
        
        // 개인정보별 유효기간 확인
        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int privDay = getDay(privacy[0]) + termArr[privacy[1].charAt(0) - 'A'] * 28;
            if(privDay <= nowDay) result.add(i + 1);
        }
        
        int idx = 0;
        int[] answer = new int[result.size()];
        for(int num : result) answer[idx++] = num;
        
        return answer;
    }
    
    private int getDay(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}