import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int n, m;
    static int[][] arr;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][][] visited;
    static int answer = Integer.MAX_VALUE;


    static class Point {
        int x, y, destroy;

        Point(int x, int y, int destroy) {
            this.x = x;
            this.y = y;
            this.destroy = destroy;
        }

    }

    public static int bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));

        visited[0][0][0] = 1;

        while(!queue.isEmpty()){
            Point cur = queue.poll();

            if(cur.x == n-1 && cur.y == m-1){
                return visited[cur.x][cur.y][cur.destroy];
            }

            for(int i=0; i<4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int n_destroy = cur.destroy; // 지금까지 벽을 부쉈는지의 유무

                if(nx<0 || nx>=n || ny<0 || ny>=m || visited[nx][ny][n_destroy]!=0) continue; // 방문 한적이 있다면

                if(arr[nx][ny]==0){ // 길이면
                    visited[nx][ny][n_destroy] = visited[cur.x][cur.y][cur.destroy] + 1;
                    queue.add(new Point(nx, ny, n_destroy));
                }
                if(arr[nx][ny] == 1 && n_destroy==0){ // 벽인데 벽 하나도 부신적 없으면
                    visited[nx][ny][1] = visited[cur.x][cur.y][cur.destroy] + 1;
                    n_destroy = 1; // 벽 부순 적 있다고 처리
                    queue.add(new Point(nx, ny, n_destroy));

                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
      /*
        5 5
        01000
        01010
        01010
        01011
        00010

        correct answer : 9
        wrong answer : -1*/
    }
}