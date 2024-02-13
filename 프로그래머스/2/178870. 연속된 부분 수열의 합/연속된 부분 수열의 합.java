class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int sum=0, right = -1, left=0;
        
        int min = sequence.length; 
        
        while(right < sequence.length){
            if(sum<k){
                if(++right < sequence.length){
                    sum += sequence[right];
                }
            }else if(sum > k){
                sum -= sequence[left++];
            }else{ // 같으면
                if(right-left < min){
                    min = right-left;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum-=sequence[left++]; 
            }
        }
            
        return answer;
    }
 
    
}