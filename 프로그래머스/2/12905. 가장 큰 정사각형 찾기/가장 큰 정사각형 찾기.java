class Solution
{
    public int solution(int [][]board)
    {
        int n = board.length; 
        int m = board[0].length; 
        int[][] area = new int[n+1][m+1];
        
        int max=0; 
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(board[i-1][j-1]!=0){
                    int min = Math.min(Math.min(area[i][j-1], area[i-1][j]), area[i-1][j-1]); 
                    area[i][j] = min+1; 
                    max = Math.max(max, area[i][j]); 
                }
            }
        }
        
        return max * max;
    }
}

/*
0 1 1 0 0 
0 1 1 0 0 
0 0 1 1 1
0 0 1 1 1
0 0 1 1 1
*/