import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, t;
    static int[][] screen;
    //static int[][] newScreen;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        screen = new int[n][m * 3];
       // newScreen = new int[n][m];
        visit = new boolean[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                screen[i][j] = (r+g+b) / 3;
            }
        }
        t = Integer.parseInt(br.readLine());

        int cnt=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(screen[i][j]>= t) screen[i][j] = 255;
                else screen[i][j] = 0;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(screen[i][j]==255 && !visit[i][j]){
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(cnt);

    }

    static void dfs(int y, int x){
        visit[y][x] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;

            if(screen[ny][nx] != 0 && !visit[ny][nx]) dfs(ny, nx);
        }
    }

}
