import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {        
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        
        // 약관 종류별 유효기관 입력
        int[] termArr = new int[26];
        for(String term : terms) {
            String[] splitTerm = term.split(" ");
            termArr[splitTerm[0].charAt(0) - 'A'] = Integer.parseInt(splitTerm[1]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        //개인정보별 유효기간 확인
        for(int i = 0; i < privacies.length; i++) {
            String[] splitPriv = privacies[i].split(" ");
            String[] privDate = splitPriv[0].split("\\.");
            int privYear = Integer.parseInt(privDate[0]);
            int privMonth = Integer.parseInt(privDate[1]);
            int privDay = Integer.parseInt(privDate[2]);
            
            int plusMonth = termArr[splitPriv[1].charAt(0) - 'A'];            
            int endYear = privYear + plusMonth / 12; int endDay = privDay - 1;
            int endMonth = privMonth + plusMonth - 12 * (plusMonth / 12);
            
            if(endMonth > 12) {
                endYear += 1;
                endMonth -= 12;
            }
            
            if(endDay < 1) {
                endMonth -= 1;
                endDay = 28;
                
                if(endMonth < 1) {
                    endYear -= 1;
                    endMonth = 12;
                }
            }
            
            if(endYear < year || (endYear <= year && endMonth < month) || (endYear <= year && endMonth <= month && endDay < day)) {
                list.add(i + 1);
            }
        }
               
        int idx = 0;
        int[] answer = new int[list.size()];
        for(int num : list) {
            answer[idx++] = num;
        }               
        
        return answer;
    }
}