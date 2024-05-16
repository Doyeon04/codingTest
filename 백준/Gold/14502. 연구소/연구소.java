import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;

    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static void bfs(){
        int[][] copyMap = new int[n][m];
        Queue<Point> queue = new LinkedList<>();

        for(int y=0; y<n; y++){
            for(int x=0; x<m; x++){
                copyMap[y][x] = map[y][x]; // 복사
                if(copyMap[y][x]==2) queue.add(new Point(x, y));
            }
        }

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(ny<0 || ny>=n || nx<0 || nx>=m) continue;

                if (copyMap[ny][nx] == 0) {
                    copyMap[ny][nx] = 2;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        int cnt = 0;
        for(int y=0; y<n; y++){
            for(int x=0; x<m; x++){
                if(copyMap[y][x] == 0) cnt++;
            }
        }

        answer = Math.max(answer, cnt);
    }
    static void dfs(int cnt){
        if(cnt == 3){
            bfs();
            return;
        }

        for(int y=0; y<n; y++){
            for(int x=0; x<m; x++){
                if(map[y][x] == 0){
                    map[y][x] = 1;
                    dfs(cnt+1);
                    map[y][x] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map= new int[n][m];

        for(int y=0; y<n; y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<m; x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0); //

        System.out.println(answer);

    }
}