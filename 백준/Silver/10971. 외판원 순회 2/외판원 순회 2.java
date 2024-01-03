import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[] visited;
    static int n, answer = Integer.MAX_VALUE; 

    public static void dfs(int v, int cnt, int cost) {

        visited[v] = true;

        if (cnt == n - 1) {
            if (arr[v][1] != 0) {
                cost += arr[v][1];
                answer = Math.min(answer, cost);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[v][i] != 0 && !visited[i]) { // 갈 수 있고 방문하지 않은 도시라면
                dfs(i, cnt + 1, cost + arr[v][i]);
                visited[i] = false;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0, 0);
        System.out.println(answer);
    }
}