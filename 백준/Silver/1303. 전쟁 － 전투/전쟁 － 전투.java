import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[m][n];
        visit = new boolean[m][n];

        for(int i=0; i<m; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = s.charAt(j);
            }
        }

        System.out.println(getPower('W') + " " + getPower('B'));
    }

    static int getPower(char color){
        visit = new boolean[m][n];

        int totalPower=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==color && !visit[i][j]){
                    count=0;
                    dfs(i, j, color);
                    totalPower+=count * count;
                }
            }
        }
        return totalPower;
    }
    static void dfs(int y, int x, char color){
        count++;
        visit[y][x] = true;

        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= m || nx < 0 || nx >= n || map[ny][nx]!=color || visit[ny][nx]) continue;

            dfs(ny, nx, color);
        }
    }
}
