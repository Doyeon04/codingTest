import java.util.*; 
class Node{
    int x, y, cnt; 
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }  
}
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; 
    static int[][] dist; 
    static int n, m; 
    static int answer=0; 
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length(); 
        boolean findL = false; 
        dist = new int[n][m]; 
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j) == 'S'){
                    if(!bfs(i, j, maps, 'L')) return -1; 
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               if(maps[i].charAt(j)=='L'){
                    if(!bfs(i, j, maps, 'E')) return -1; 
                }
            }
        }
        return answer;
    }
    public boolean bfs(int y, int x, String[] maps, char find){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        
       
        boolean[][] visit = new boolean[n][m];
        visit[y][x] = true; 
        
        while(!q.isEmpty()){
            Node p = q.poll();
            int px = p.x;
            int py = p.y;
            char now = maps[p.y].charAt(p.x);

            if(find == now){
                if(find == 'E') {
                    answer = dist[py][px];

                }
                return true; 
            }
   
            for(int i=0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                char newNode = maps[ny].charAt(nx); 
                if(newNode == 'X' || visit[ny][nx]) continue; 
                 q.offer(new Node(nx, ny));
                
                 dist[ny][nx] = dist[py][px] + 1; 
                 visit[ny][nx] = true; 

            }
        }
        return false; 
    }
}
