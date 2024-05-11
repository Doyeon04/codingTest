import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] chicken;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;
    static List<int[]> chickenList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        chicken = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        comb(0, 0);
        System.out.println(answer);
    }

    static void comb(int start, int depth) {
        if (depth == m) {
            int sum=0;
            chickenList.clear();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (chicken[i][j]) {
                        //sum+= bfs(i, j);
                        chickenList.add(new int[]{i, j});
                    }
                }
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j]==1){ // 집이면
                        int dist = Integer.MAX_VALUE;
                        for(int[] c: chickenList){
                            dist = Math.min(dist, Math.abs(c[0]-i) + Math.abs(c[1]-j));
                        }
                        sum+=dist;
                    }
                }
            }
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = start; i < n * n; i++) {
            int x = i / n;
            int y = i % n;

            if (!chicken[x][y] && map[x][y] == 2) {
                chicken[x][y] = true;
                comb(i + 1, depth + 1);
                chicken[x][y] = false;
            }

        }
    }

//    static int bfs(int x, int y) {
//        Queue<int[]> q = new LinkedList<>();
//        q.offer(new int[]{x, y});
//        boolean[][] visit = new boolean[n][n];
//        visit[x][y] = true;
//
//        while (!q.isEmpty()) {
//            int[] poll = q.poll();
//            int cx = poll[0];
//            int cy = poll[1];
//
//            if (chicken[cx][cy]) { // 제일 가까운 치킨집까지의 거리
//                return Math.abs(x - cx) + Math.abs(y - cy);
//            }
//
//            for (int i = 0; i < 4; i++) {
//                int nx = cx + dx[i];
//                int ny = cy + dy[i];
//                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visit[nx][ny]) {
//                    continue;
//                }
//
//                q.offer(new int[]{nx, ny});
//                visit[nx][ny] = true;
//            }
//        }
//        return 0;
//    }

}

