import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static ArrayList<ArrayList<Integer>> list;
    static int[] colors;
    static boolean isBiGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(k-->0){
             st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i=0; i<=v; i++){
                list.add(new ArrayList<>());
            }
            isBiGraph = true;
            colors = new int[v+1];

            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list.get(start).add(end);
                list.get(end).add(start);
            }
            for(int i=1; i<=v; i++){
                if(colors[i]==0) {
                    dfs(i, 1);
                }
                if(!isBiGraph) break;

            }
            System.out.println(isBiGraph ? "YES" : "NO");
        }
    }
    static void dfs(int v, int color){
        colors[v] = color;
        for(int next : list.get(v)){
            if(colors[next] == color){
                isBiGraph = false;
                return;
            }
            if(colors[next]==0){
                dfs(next, color * -1);
            }
        }
    }
}

/*
1. 색칠되지 않은 모든 정점에 대해 연결된 정점을 dfs를 진행한다.
2. 연결된 정점과 색이 같으면 이분 그래프가 아니다.
3. 방문하지 않은 정점이면 연결된 정점을 다른 색상으로 색칠한다.

 */