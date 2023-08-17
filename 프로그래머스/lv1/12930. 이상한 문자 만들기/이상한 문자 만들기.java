class Solution {
    public String solution(String s) {
        String answer = "";
        
        int i=0; 
        for(char c : s.toCharArray()){
            if(c!=' '){
                if(i % 2 == 0) answer+=String.valueOf(c).toUpperCase();  
                else answer+=String.valueOf(c).toLowerCase(); 
                i++;  
            }else {
                answer+=" "; 
                i = 0;
            } 
        }
        return answer;
    }
}