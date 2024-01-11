import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int a, b, n, m;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visit;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];

        list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        visit[a] = true;
        System.out.println(bfs(a));
    }

    static int bfs(int v){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{v, 0});
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int now = poll[0];
            int cnt = poll[1];
            if(now == b){
               return cnt;
            }
            for (int next: list.get(now)) {
                if(visit[next]) continue;
                visit[next] = true;
                q.offer(new int[]{next, cnt+1});
            }
        }
        return -1;
    }

}