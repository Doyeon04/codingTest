import java.util.*;

class Conversion{
    boolean agree;
    int score; 
    public Conversion(boolean agree, int score){
        this.agree = agree; 
        this.score = score; 
    }
}


class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
      
        Conversion[] results = new Conversion[8];
        results[1] = new Conversion(false, 3);
        results[2] = new Conversion(false, 2);
        results[3] = new Conversion(false, 1);
        results[4] = new Conversion(false, 0);
        results[5] = new Conversion(true, 1);
        results[6] = new Conversion(true, 2);
        results[7] = new Conversion(true, 3);
       
        HashMap<String, Integer> map = new HashMap<>(); // 문자, 점수 
        
        for(int i=0; i<survey.length; i++){
           String alpha = survey[i]; 
            if(results[choices[i]].agree){ // 동의면 오른쪽
               alpha = alpha.substring(1);  
            }else{ // 비동의면 왼쪽
               alpha = alpha.substring(0, 1);  
            }
            map.put(alpha, map.getOrDefault(alpha, 0) + results[choices[i]].score); 
        }
  
        String[][] typeArr = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}}; 
        for(int i=0; i<4; i++){
            int leftScore = 0;
            int rightScore = 0;
            String left = typeArr[i][0];
            String right = typeArr[i][1]; 
       
            if(map.containsKey(left)) leftScore = map.get(left);
            if(map.containsKey(right)) rightScore = map.get(right);
            
            if(leftScore > rightScore) answer+=left;
            else if(leftScore < rightScore) answer+=right;
            else{ // 같으면 사전순으로 빠른거
                if(left.compareTo(right) < 0){ // 음수면 사전순이 left -> right
                    answer+= left;
                }else answer+= right; 
            }
        }
        
        return answer;
    }
}
