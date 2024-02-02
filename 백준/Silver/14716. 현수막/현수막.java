import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1){
                    cnt++;
                    arr[i][j] = 0;
                    dfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int y, int x){

        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || arr[ny][nx] == 0) continue;

            arr[ny][nx] = 0;
            dfs(ny, nx);
        }
    }
}
