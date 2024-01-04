import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] arr;

    static int[] dx = {-1, 0, 1, 0, -1, 1, 1, -1};
    static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
    static int w, h;

    static Queue<Point> q = new LinkedList<>();

    public static void bfs(int x, int y) {
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;

                if (arr[nx][ny] == 1) { // 땅이면
                    arr[nx][ny] = 0; // 방문 처리
                    q.add(new Point(nx, ny));
                }

            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {

            StringTokenizer st;
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            arr = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}