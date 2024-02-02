import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        dist = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 2){
                    visit[i][j] = true;
                    System.out.println(bfs(i, j));
                    break;
                }
            }
        }
    }
    static String bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int px = poll[0];
            int py = poll[1];

            if(arr[py][px] >= 3 && arr[py][px] <= 5){
                return "TAK" + "\n" + dist[py][px];
            }

            for(int i=0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n || arr[ny][nx] == 1 || visit[ny][nx]) continue;

                dist[ny][nx] = dist[py][px] + 1;
                visit[ny][nx] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return "NIE";
    }
}
