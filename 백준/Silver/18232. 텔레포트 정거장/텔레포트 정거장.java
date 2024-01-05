import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n, m, s, e;
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        visit = new boolean[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        bfs(s);
        System.out.println(ans);
    }

    static void bfs(int v){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{v, 0});
        visit[v] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int time = poll[1];

            if(x==e){
                ans = time;
                break;
            }
            for(int next : list[x]){
                if(!visit[next]){
                    visit[next] = true;
                    q.add(new int[]{next, time+1});
                }
            }

            if(x+1 <= n && !visit[x+1] ){
                q.add(new int[]{x+1, time+1});
                visit[x+1] = true;
            }

            if(x-1 >= 1 && !visit[x-1] ){
                q.add(new int[]{x-1, time+1});
                visit[x-1] = true;
            }
        }
    }
}