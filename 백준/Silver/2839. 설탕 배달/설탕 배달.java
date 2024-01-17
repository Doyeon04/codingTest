import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        if(n<5){
            if(n==3) System.out.println(1);
            else System.out.println(-1);
            return;
        }
        Arrays.fill(dp, 5000);
        dp[3] = 1;
        dp[5] = 1;
        for(int i=6; i<dp.length; i++){
            dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1);
        }
        if(dp[n] > 5000) System.out.println(-1);
        else System.out.println(dp[n]);

    }
}

