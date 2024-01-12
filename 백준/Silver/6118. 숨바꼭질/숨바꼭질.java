import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Integer>> list;
    static boolean[] visit;
    static int[] dist;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n+1];
        dist = new int[n+1];
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1);
        
        int max=0;
        for (int i : dist) {
            max = Math.max(max, i); 
        }
        int cnt=0;
        int num=0; 
        for(int i=1; i<=dist.length; i++){
            if(dist[i] == max){
                num = i;
                break;
            }
        }
        for (int i : dist) {
            if(i==max) cnt++; 
        }
        System.out.println(num+" "+max+" "+cnt);
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for(int next : list.get(now)){
                if(visit[next]) continue;

                visit[next] = true;
                dist[next] = dist[now] + 1;
                q.offer(next); 
            }
        }
    }
}

