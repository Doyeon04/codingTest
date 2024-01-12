import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = 1;
        }

        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]==1){
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }
        System.out.println(ans);
    }
    static int bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        map[y][x] = 0;
        int size = 0;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            x = poll[0];
            y = poll[1];

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || map[ny][nx] == 0) continue;

                map[ny][nx] = 0;
                q.offer(new int[]{nx, ny});
            }
            size++;
        }
        return size;
    }
}

