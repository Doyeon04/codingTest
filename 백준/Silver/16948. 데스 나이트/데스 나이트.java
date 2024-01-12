import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, r1, r2, c1, c2;
    static int[][] board;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, +1, -2, +2, -1, +1};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        visit = new boolean[n][n];

        System.out.println(bfs(r1, c1));
    }
    static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int cur_x = poll[0];
            int cur_y = poll[1];

            if(cur_x == r2 && cur_y == c2){
                return board[cur_x][cur_y];
            }

            for(int i=0; i<6; i++){
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) continue;

                board[nx][ny] = board[cur_x][cur_y] + 1;
                visit[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return -1;
    }
}

