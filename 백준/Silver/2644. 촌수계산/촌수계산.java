import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] arr;
    static boolean[] visit;
    static int a, b, n, answer = 0;

    public static void dfs(int v, int cnt){
        if(v == b) {
            answer = cnt;
        }
        else{
            for(int i=1; i<=n; i++){
                if(arr[v][i] == 1 && !visit[i]){
                    visit[i] = true;
                    dfs(i, cnt+1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        visit = new boolean[n+1];

        // x는 y의 부모 번호
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = arr[y][x] = 1;
        }


        visit[a] = true;
        dfs(a, 0);
        if(answer == 0) System.out.println(-1);
        else System.out.println(answer);
    }
}