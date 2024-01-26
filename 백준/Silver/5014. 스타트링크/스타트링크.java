import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int f, s, g, u, d;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken()); // 총 층의 개수
        s = Integer.parseInt(st.nextToken()); // 지금 있는 층
        g = Integer.parseInt(st.nextToken()); // 이동하려는 층
        u = Integer.parseInt(st.nextToken()); // 위로 u층 감
        d = Integer.parseInt(st.nextToken()); // 아래로 d층 감
        visit = new boolean[f+1];

        System.out.println(bfs(s));
    }

    static String bfs(int s){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0});
        visit[s] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int now = poll[0];
            int cnt = poll[1];

            if(now == g){
                return String.valueOf(cnt);
            }

            if(now+u <= f && !visit[now+u]){
                q.offer(new int[]{now+u, cnt+1});
                visit[now+u] = true;
            }
            if(now-d > 0 && !visit[now-d]){
                q.offer(new int[]{now-d, cnt+1});
                visit[now-d] = true;
            }
        }
        return "use the stairs";
    }
}
