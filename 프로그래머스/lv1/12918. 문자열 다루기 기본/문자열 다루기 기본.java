class Solution {
    public boolean solution(String s) {
        
        int len = 0; 
        for(int i=0; i<s.length(); i++){
            len++;
            char c = s.charAt(i); 
            if(!Character.isDigit(c)) return false; 
        }
        if(len==4 || len==6) return true; 
        else return false; 
    }
}