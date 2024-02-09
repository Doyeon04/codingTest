import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]); 
        }
    
        while(pq.size()>1 && pq.peek() < K){
            int food1 = pq.poll();
            int food2 = pq.poll();
         
            answer++; 
            
            int mixed = food1 + food2 * 2; 
            pq.add(mixed); 
            
        }
        
        if(pq.size()==1 && pq.poll() < K) answer = -1;  
        
        return answer;
    }
}