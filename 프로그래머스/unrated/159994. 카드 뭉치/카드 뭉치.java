class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int p1 = 0, p2 = 0, idx = 0; 
        
        while(idx<goal.length){
            if(p1<cards1.length && goal[idx].equals(cards1[p1])) p1++;
            else if(p2<cards2.length && goal[idx].equals(cards2[p2])) p2++; 
            else answer = "No"; 
            
            idx++; 
        }
        return answer;
    }
}