import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(i==1 && j ==1) dp[i][j] = map[1][1];
                else dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1]) + map[i][j];
            }
        }
        System.out.println(dp[n][m]);
    }

}