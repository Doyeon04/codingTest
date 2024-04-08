import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // dp[i][j][k] = 시작 지점에서 [i][j] 지점까지 윗 행 지점으로부터 k 방향으로 이동한 최소 비용
        // 0: 왼쪽, 1: 아래, 2:오른쪽

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][][] dp = new int[n][m][3];
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(i==0){ 
                    dp[i][j][0] = dp[i][j][1] = dp[i][j][2] =  map[i][j];
                }else if(j==m-1){ // 왼쪽 대각선 아래 방향으로 올 수 없는 경우
                    dp[i][j][0] = Integer.MAX_VALUE;
                }else if(j==0){ // 오른쪽 대각선 아래 방향으로 올 수 없는 경우
                    dp[i][j][2] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                if(j+1 < m) dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + map[i][j]; // 위에서부터 왼쪽 대각선으로 온 값
                dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + map[i][j];  // 위에서부터 아래로 온 값
                if(j-1>=0) dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + map[i][j]; // 위에서부터 오른쪽 대각선으로 온 값
            }
        }
        // 마지막 행의 값들 중 최솟값 찾기
        for(int j=0; j<m; j++){
            for(int k=0; k<3; k++){
                min = Math.min(min, dp[n-1][j][k]);
            }
        }
        System.out.println(min);
    }
}



