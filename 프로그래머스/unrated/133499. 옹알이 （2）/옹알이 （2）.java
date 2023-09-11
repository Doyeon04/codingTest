import java.util.*; 

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"}; 
        
        for(String b : babbling){
            for(String s : arr){
                if(b.contains("ayaaya") || b.contains("yeye") || b.contains("woowoo") || b.contains("mama")) continue;
                if(b.contains(s)) b = b.replace(s, " "); 
            }
            b = b.replace(" ", ""); 

            if(b.equals("")) answer++; 
        }
        
        
        return answer;
    }
}

// aya, ye, woo, ma
