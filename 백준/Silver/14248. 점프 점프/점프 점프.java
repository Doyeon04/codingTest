import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, s;
    static int[] rocks;
    static boolean[] visit;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        rocks = new int[n + 1];
        visit = new boolean[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            rocks[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());
        dfs(s);
        System.out.println(cnt);

    }

    static void dfs(int s) {
        if (s < 1 || s > n || visit[s]) return;

        visit[s] = true;
        cnt++;
        dfs(s + rocks[s]);
        dfs(s - rocks[s]);
    }
}

