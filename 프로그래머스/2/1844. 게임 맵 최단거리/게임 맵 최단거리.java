import java.util.*; 
class Solution {
    static int n, m;
    static int[][] dist; 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; 
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length; 
        dist = new int[n][m]; 
        
        return bfs(maps);
    }
    
    static int bfs(int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
       
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int px = poll[0];
            int py = poll[1];
            
            if(py == n-1 && px == m-1){
                return dist[n-1][m-1] + 1;
            }
            
            for(int i=0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || maps[ny][nx] != 1) continue;
                
                maps[ny][nx] = 0; 
                dist[ny][nx] = dist[py][px] + 1; 
                q.offer(new int[]{nx, ny});
            }
        }
        return -1; 
    }
}