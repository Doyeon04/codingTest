import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0));
    }
    static String bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int px = poll[0];
            int py = poll[1];

            if(px == n-1 && py == n-1){
                return "HaruHaru";
            }

            if(isValidRange(map[py][px]+px, py)) {
                q.offer(new int[]{map[py][px] + px, py}); // 오른쪽
            }
            if(isValidRange(px, map[py][px] + py)) {
                q.offer(new int[]{px, map[py][px] + py}); // 아래
            }
        }
        return "Hing";
    }

    static boolean isValidRange(int x, int y){
        if(x < n && x >= 0 && y < n && y >= 0 && !visit[y][x]) {
            visit[y][x] = true;
            return true;
        }
        else return false;
    }
}
