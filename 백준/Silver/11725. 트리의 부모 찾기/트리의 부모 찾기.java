import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int n;
    static int[] parent;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        parent = new int[n+1];
        visit = new boolean[n+1];

        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(1);

        for(int i=2; i<=n; i++){
            System.out.println(parent[i]);
        }
    }
    static void dfs(int v){
        if(visit[v]) return;

        visit[v] = true;

        for(int next: list.get(v)){
            if(visit[next]) continue;
            parent[next] = v;
            dfs(next);
        }
    }

}