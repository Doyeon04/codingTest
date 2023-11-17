class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(char alpha : s.toCharArray()){
            char newAlpha = alpha;
         
            for(int i=0; i<index; i++){
                newAlpha++; 
                
                if(newAlpha > 'z') newAlpha-=26; 
                
                 if(skip.contains(String.valueOf(newAlpha))){ 
                      i--;
                  }
            }
            answer+=newAlpha; 
        }
        return answer;
    }
}



