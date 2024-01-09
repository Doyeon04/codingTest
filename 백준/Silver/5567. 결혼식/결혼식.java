import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[] visit;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        visit[1] = true;
        dfs(1, 0);
      
        for(int i=2; i<=n; i++){
            if(visit[i]) ans++;
        }
        System.out.println(ans);
    }

    static void dfs(int v, int cnt) {
        if(cnt==2) {
            return;
        }

        for(int i=1; i<=n; i++){
            if(arr[v][i] == 1){
                visit[i] = true;
                dfs(i, cnt+1); 
            }
        }
    }
}

