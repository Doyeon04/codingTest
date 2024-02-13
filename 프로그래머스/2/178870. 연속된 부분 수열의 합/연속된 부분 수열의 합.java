class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum=0, left=0;
        
        int min = sequence.length; 
    
        for(int right=0; right<sequence.length; right++){
            sum+=sequence[right];
            if(sum == k){
                if(min > right - left){
                    answer[0] = left;
                    answer[1] = right;
                    min = right-left; 
                }
            }
            while(sum>=k){
                sum-=sequence[left++];
                if(sum==k){
                    if(min > right-left){
                        answer[0] = left;
                        answer[1] = right; 
                        min = right-left; 
                    }
                }
            }
        }
            
        return answer;
    }
 
    
}