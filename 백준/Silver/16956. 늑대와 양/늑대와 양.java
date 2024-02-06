import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c;
    static char[][] arr;
    static boolean flag = true;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 'W') {
                    q.offer(new int[]{j, i}); // 늑대의 위치 저장
                }
            }
        }
        
        if (bfs()) {
            System.out.println(1);
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        } else System.out.println(0);
    }

    static boolean bfs() {
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= c || ny < 0 || ny >= r) continue;

                if (arr[ny][nx] == '.') arr[ny][nx] = 'D'; // 빈칸인 경우 울타리 설치
                else if (arr[ny][nx] == 'S') { // 양이 있는 경우
                    return false;
                }
            }
        }
        return true;
    }

}