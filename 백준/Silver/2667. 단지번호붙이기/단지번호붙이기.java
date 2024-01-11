import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int[][] arr;

    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> q = new LinkedList<>();
    static int cntHouse;
    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int x, int y){
        q.add(new Point(x, y));

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;

                if(arr[nx][ny]==1){
                    arr[nx][ny] = 0;
                    cntHouse++;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0) continue;
                cnt++;
                cntHouse = 1;
                arr[i][j] = 0;
                bfs(i, j);
                list.add(cntHouse);
            }
        }
       Collections.sort(list);

        System.out.println(cnt);
        for(int x : list){
            System.out.println(x);
        }
    }
}