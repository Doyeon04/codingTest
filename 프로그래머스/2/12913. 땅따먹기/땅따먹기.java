import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int len = land.length; 
        int[][] dp = new int[len][4];
        
        for(int i=0; i<4; i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i=1; i<len; i++){
            for(int j=0; j<4; j++){
                int max=0; 
                for(int k=0; k<4; k++){
                    if(j==k) continue; 
                    max = Math.max(max, dp[i-1][k]); // 이전 행에서 최댓값 찾기
                }
                dp[i][j] = max + land[i][j]; 
                
            }
        }
        
        for(int i=0; i<4; i++){
            answer = Math.max(answer, dp[len-1][i]); 
        }
        
        return answer;
    }
}