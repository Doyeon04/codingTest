import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(ans);
    }
    static void dfs(int cnt, int sum){
        if(cnt==3){
            ans = Math.min(ans, sum);
            return;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isPossible(i, j)){
                    int priceSum = getPriceAndCheck(i, j);
                    visited[i][j] = true;
                   dfs(cnt+1, sum+priceSum);
                   visited[i][j] = false;
                   clearMap(i, j);
                }
            }
        }
    }

    static void clearMap(int y, int x){
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[ny][nx] = false;
        }
    }

    static int getPriceAndCheck(int y, int x){
        int sum=map[y][x];
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[ny][nx] = true;
            sum+=map[ny][nx];
        }
       return sum;
    }
    static boolean isPossible(int y, int x){
        if(visited[y][x]) return false;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >=n || ny < 0 || ny >= n || visited[ny][nx]) return false;
        }
        return true;
    }
}
