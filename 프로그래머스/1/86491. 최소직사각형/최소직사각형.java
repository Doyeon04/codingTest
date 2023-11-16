class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int a = 0, b = 0; 
        
        for(int[] card : sizes){
            a = Math.max(a, Math.max(card[0], card[1]));
            b = Math.max(b, Math.min(card[0], card[1])); 
        }
        answer = a * b; 
        return answer;
    }
}