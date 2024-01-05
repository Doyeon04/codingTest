import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }
    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()){
            int[] poll = q.poll();

            for(int i=0; i<4; i++){
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n || map[ny][nx] != 1) continue;

                q.add(new int[]{nx, ny});
                map[ny][nx] = map[poll[1]][poll[0]] + 1;


            }
        }
    }

}