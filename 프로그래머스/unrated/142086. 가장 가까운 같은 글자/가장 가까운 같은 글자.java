class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()]; 
        
        int idx=0; 
        String prevStr = ""; 
        
        for(char c : s.toCharArray()){
            int i = prevStr.lastIndexOf(c); 
            if(i!=-1) answer[idx] = idx - i; 
            else answer[idx] = i; 
            prevStr += String.valueOf(c); 
            idx++; 
        }
        return answer;
    }
}