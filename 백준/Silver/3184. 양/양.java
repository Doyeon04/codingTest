import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int r, c;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int sheep, wolf, totalSheep, totalWolf;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visit = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '#' && !visit[i][j]) { // 울타리가 아니면
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);

                    if(sheep > wolf){
                        totalSheep += sheep;
                    }else{
                        totalWolf += wolf;
                    }
                }
            }
        }
        System.out.println(totalSheep + " " + totalWolf);
    }
    static void dfs(int y, int x){
        if(map[y][x] == 'o') sheep++;
        else if(map[y][x] == 'v') wolf++;
        visit[y][x] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= c || ny < 0 || ny >= r || map[ny][nx] == '#' || visit[ny][nx]) continue;
            dfs(ny, nx);
        }
    }
}
