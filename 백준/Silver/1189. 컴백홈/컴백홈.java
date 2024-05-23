import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, k;
    static char[][] map;
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visit = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        dfs(r-1, 0, 1);
        System.out.println(answer);

    }

    private static void dfs(int y, int x, int cnt) {
        visit[y][x] = true;
        if(x==c-1 && y==0){
            if(cnt==k){
                answer++;
            }
            return;
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= c || ny < 0 || ny >= r || visit[ny][nx]) continue;

            if (map[ny][nx] != 'T') {
                dfs(ny, nx, cnt+1);
                visit[ny][nx] = false;
            }

        }

    }
}
