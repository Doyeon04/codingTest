import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[] check;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        check = new boolean[m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(ans);

    }
    static void dfs(int start, int cnt){
        if(cnt==3){ // 치킨 세종류 고르면
            int sum=0;
            for(int i=0; i<n; i++){
                int max=0;
                for(int j=0; j<m; j++){
                    if(check[j]) max = Math.max(max, arr[i][j]);
                }
                sum+=max;
            }
            ans = Math.max(ans, sum);
            return;
        }
        for(int i=start; i<m; i++){
            if(check[i]) continue;
            check[i] = true;
            dfs(i+1, cnt+1);
            check[i] = false;
        }
    }
}
