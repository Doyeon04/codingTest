import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] arr;
    static int ans;
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new boolean[n+1][n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = true;
        }

        for(int i=1; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                if(arr[i][j]) continue;
                for(int k=j+1; k<=n; k++){
                    if(!arr[i][k] && !arr[j][k]) ans++;
                }
            }
        }
        System.out.println(ans);
    }

}

