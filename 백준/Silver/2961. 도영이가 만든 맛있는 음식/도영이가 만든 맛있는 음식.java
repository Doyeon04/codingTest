import java.io.*;
import java.util.*;

public class Main {
    static int[][] flavors;
    static int n;
    static boolean[] check;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        flavors = new int[n][2];
        check = new boolean[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            flavors[i][0] = Integer.parseInt(st.nextToken());
            flavors[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int cnt){
        if(cnt==n){
            boolean flag = false;
            int s = 1, b = 0;
            for(int i=0; i<n; i++){
                if(check[i]){
                    flag = true;
                    s *= flavors[i][0];
                    b += flavors[i][1];
                }
            }
            if(flag) ans = Math.min(ans, Math.abs(s-b));
            return;
        }

        check[cnt] = true;
        dfs(cnt+1); // 재료 선택
        check[cnt] = false;
        dfs(cnt+1);
    }
}
