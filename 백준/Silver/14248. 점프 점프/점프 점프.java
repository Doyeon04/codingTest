import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, s;
    static int[] rocks;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rocks = new int[n+1];
        visit = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            rocks[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());

        visit[s] = true;
        dfs(s);

        int cnt=0;
        for (boolean b : visit) {
            if(b) cnt++;
        }
        System.out.println(cnt);

    }
    static void dfs(int s){

        int right = s + rocks[s];
        int left = s - rocks[s];

        if(right >= 1 && right <= n){
            dfs(right);
            visit[right] = true;
        }

        if(left >= 1 && left <= n){
            dfs(left);
            visit[left] = true;
        }
    }
}

