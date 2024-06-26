import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    public static void dfs(int v) {
        if (visited[v]) return;

        visited[v] = true;

        for (int i = 1; i <= n; i++) {
            if (arr[v][i] == 1 && !visited[i]) { // 연결된 정점이고 방문하지 않았다면
                dfs(i);
            }
        }
    }

    public static void bfs(int v){
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()){
            v = queue.poll();
            for(int i=1; i<=n; i++){
                if(arr[v][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v] = arr[v][u] = 1;
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                cnt++;
               // dfs(i);
                bfs(i);
            }
        }
        System.out.println(cnt);
    }
}