class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int a = 0, b = 0; 
        
        for(int i=0; i<sizes.length; i++){
            for(int j=0; j<2; j++){
                if(sizes[i][0] >= sizes[i][1]) {
                    a = Math.max(a, sizes[i][0]);
                    b = Math.max(b, sizes[i][1]); 
                }
                else {
                    a = Math.max(a, sizes[i][1]); 
                    b = Math.max(b, sizes[i][0]); 
                }
            }
        }
        answer = a * b; 
        return answer;
    }
}