class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = s.charAt(0); 
        int firstCnt = 0, elseCnt = 0; 
        
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i); 
            
            if(c==first) firstCnt++;
            else elseCnt++; 
            
            if(firstCnt == elseCnt){
                answer++;
                if(i < s.length()-1)  first = s.charAt(i+1);
            }else if(i==s.length()-1) answer++; 
         
        }

        return answer;
    }
}