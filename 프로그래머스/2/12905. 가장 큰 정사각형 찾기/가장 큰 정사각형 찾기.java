class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length; 
        int m = board[0].length; 
        int maxLen=0; 
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==0) continue; 
              
                int up = (i-1>=0) ? board[i-1][j] : 0;
                int left = (j-1>=0) ? board[i][j-1] : 0; 
                int diagonal = (i-1 >= 0 && j-1 >= 0) ? board[i-1][j-1] : 0; 
                
                board[i][j] = Math.min(Math.min(up, left), diagonal)+1;
                maxLen = Math.max(maxLen, board[i][j]); 
            }
        }
        
        return maxLen * maxLen;
    }
}