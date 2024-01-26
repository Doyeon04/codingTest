import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] visit;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int kx = Integer.parseInt(st.nextToken());
        int ky = Integer.parseInt(st.nextToken());

        board = new int[n + 1][n + 1];
        visit = new boolean[n + 1][n + 1];

        bfs(kx, ky);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            sb.append(board[ex][ey]).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;


        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int px = poll[0];
            int py = poll[1];

            for (int i = 0; i < 8; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx <= 0 || nx > n || ny <= 0 || ny > n || visit[nx][ny]) continue;

                visit[nx][ny] = true;
                board[nx][ny] = board[px][py] + 1;

                q.offer(new int[]{nx, ny});
            }
        }
    }
}









