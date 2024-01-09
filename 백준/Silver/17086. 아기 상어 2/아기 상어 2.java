import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visit = new boolean[n][m];
                ans = Math.max(ans, bfs(i, j, 0));
            }
        }
        System.out.println(ans);
    }

    static int bfs(int y, int x, int cnt){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y,cnt});
        visit[y][x] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            x = poll[0];
            y = poll[1];
            cnt = poll[2];

            if(map[y][x] == 1){
                return cnt;
            }

            for(int i=0; i<8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx>=m || ny < 0 || ny >= n || visit[ny][nx]) continue;

                q.add(new int[]{nx, ny, cnt+1});
                visit[ny][nx] = true;
            }
        }
        return -1;
    }
}

