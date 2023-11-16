class Solution {
    
    public static int gcd(int n, int m){
        if(m==0) return n;
        else return gcd(m, n%m); 
    }
    
    public int[] solution(int n, int m) {
        int[] answer = new int[2]; 
        
        answer[0] = gcd(n, m); 
        answer[1] = n*m/gcd(n, m); 
        
        return answer;
    }
}