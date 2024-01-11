import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt, area, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    area=1;
                    cnt++;
                    map[i][j] = 0;
                    dfs(i, j);
                    ans = Math.max(ans, area);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(ans);
    }
    static void dfs(int y, int x) {
        for(int i=0; i<4; i++){
            int ny = y +dy[i];
            int nx = x +dx[i];
            if(nx < 0 || nx >= m || ny < 0 || ny >= n || map[ny][nx]==0) continue;

            area++;
            map[ny][nx]=0;
            dfs(ny, nx);
        }
    }

}

