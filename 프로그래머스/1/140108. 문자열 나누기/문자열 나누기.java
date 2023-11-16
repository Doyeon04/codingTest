class Solution {
    public int solution(String s) {
        int answer = 0;
        char first = 0; 
        int firstCnt = 0, elseCnt = 0; 
        
        
        for(char c : s.toCharArray()){
            if(first == 0) first = c;
            if(c == first) firstCnt++; 
            else elseCnt++;
            
            if(firstCnt == elseCnt){
                firstCnt = elseCnt = first = 0;
                answer++; 
            }
        
        }
        if(first != 0) answer++; 
        
        return answer;
    }
}