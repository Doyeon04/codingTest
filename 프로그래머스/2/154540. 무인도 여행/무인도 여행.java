import java.util.*; 
class Solution {
    static int count=0; 
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit; 
    static int n, m; 
    static List<Integer> list = new ArrayList<>(); 
    public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length(); 
        visit = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                count=0; 
                if(visit[i][j] || maps[i].charAt(j)=='X') continue; 
                dfs(i, j, maps); 
                list.add(count); 
            }
        }
        if(list.size()==0) return new int[]{-1}; 
        Collections.sort(list); 
        return list.stream().mapToInt(x->x).toArray();
    }
    static void dfs(int y, int x, String[] maps){
      
        count+=maps[y].charAt(x)-'0'; 
        visit[y][x] = true; 
        
        for(int i=0; i<4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
            if(maps[ny].charAt(nx)=='X'|| visit[ny][nx]) continue;
            dfs(ny, nx, maps); 
        }
    }
}