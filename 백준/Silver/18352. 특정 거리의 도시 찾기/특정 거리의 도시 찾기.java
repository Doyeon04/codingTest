import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, k, x;
    static ArrayList<ArrayList<Integer>> list;
    static int[] dist;
    static boolean[] visit;
    static ArrayList<Integer> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }
        dist = new int[n+1];
        visit = new boolean[n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        bfs(x);

        if(answers.size()==0){
            System.out.println(-1);
            return;
        }
        Collections.sort(answers);

        StringBuilder sb = new StringBuilder();
        for(int answer : answers){
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visit[x] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            if(dist[cur] == k){
                answers.add(cur);
            }

            if(dist[cur] > k) break;

            for(int next : list.get(cur)){
                if(visit[next]) continue;

                dist[next] = dist[cur] + 1;
                visit[next] = true;
                q.offer(next);
            }
        }
    }

}
