import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++){
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = min+1;
        }
        System.out.println(dp[n]);

    }
}
/*
dp[5] 에서 dp[5-1^], dp[5-2^]중 작은 값
dp[4] = 1, dp[1] = 1
dp[5] = dp[1] + 1(2*2)
 */

