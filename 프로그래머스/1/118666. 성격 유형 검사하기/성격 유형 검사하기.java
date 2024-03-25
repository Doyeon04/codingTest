import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        String[][] types = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        int[] score = {3, 2, 1, 0, 1, 2, 3};
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<survey.length; i++){
            String type = ""; 
            if(choices[i] < 4){ // 비동의
                 type = survey[i].substring(0, 1); 
            }else if(choices[i] >4){ // 동의
                 type = survey[i].substring(1); 
            }
            int addScore = score[choices[i]-1]; 
            map.put(type, map.getOrDefault(type, 0) + addScore); 
        }
        for(String[] type : types){
            int leftScore =0; 
            int rightScore =0; 
            
            if(map.containsKey(type[0])) leftScore=map.get(type[0]); 
            if(map.containsKey(type[1])) rightScore=map.get(type[1]);  
            
            if(leftScore > rightScore) answer+=type[0]; 
            else if(leftScore < rightScore) answer+=type[1]; 
            else {
                if(type[0].compareTo(type[1])<0) answer+=type[0];
                else answer+=type[1]; 
            }
            
        }
        return answer;
    }
}