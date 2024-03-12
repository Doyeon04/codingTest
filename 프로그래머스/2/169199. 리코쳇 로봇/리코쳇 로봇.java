import java.util.*;
class Solution {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(String[] board) {
        int answer = 0;
        n = board.length;
        m = board[0].length();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i].charAt(j)=='R'){
                    answer = bfs(board, i, j); 
                }
            }
        }
        
        return answer;
    }
    static int bfs(String[] board, int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        boolean[][] visit = new boolean[n][m];
        visit[y][x] = true; 
        
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];
            int cnt = poll[2]; 

            if(board[cy].charAt(cx)=='G'){
                return cnt; 
            }
            for(int i=0; i<4; i++){
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                while(ny < n && ny >=0 && nx < m && nx >=0 && board[ny].charAt(nx)!='D'){
                    ny += dy[i];
                    nx += dx[i]; 
                }
                
                ny-=dy[i];
                nx-=dx[i];
                if(visit[ny][nx] || (cy==ny && cx == nx)) continue;
                visit[ny][nx] = true; 
                
                q.offer(new int[]{nx, ny, cnt+1}); 
            }    
        }
        return -1; 
    }
}
