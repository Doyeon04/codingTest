import java.util.*; 

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : participant){
            map.put(s, map.getOrDefault(s, 0) + 1);     
        }
        
        for(String s : completion){
            if(map.containsKey(s)) map.put(s, map.get(s)-1); 
            if(map.get(s) == 0) map.remove(s); 
        }
        
        for(String key : map.keySet()){
            answer = key; 
        }
        
        return answer;
    }
}