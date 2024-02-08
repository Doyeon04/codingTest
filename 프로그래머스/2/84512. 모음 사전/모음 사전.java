import java.util.*;
class Solution {
    static String[] alphabets = {"A", "E", "I", "O", "U"};
    static int answer=0; 
    static boolean find = false; 
    public int solution(String word) {
        
        dfs("", word); 
        return answer-1;
    }
    
    static void dfs(String str, String findWord){
         answer++; 
        
         if(str.equals(findWord)) {
            find = true; 
            return;
        }
        if(str.length()>=5) return;
        
        for(String alphabet : alphabets){
            if(!find) dfs(str+alphabet, findWord); 
        }
    }
    
}