import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] colors;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            colors = new int[v + 1];
            check = true;

            for (int i = 0; i <= v; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list.get(start).add(end);
                list.get(end).add(start);
            }

            for (int i = 1; i <= v; i++) {
                if (!check) break;

                if (colors[i] == 0) {
                    dfs(i, 1);
                }
            }
            System.out.println(check ? "YES" : "NO");
        }
    }

    static void dfs(int v, int color) {
        colors[v] = color;

        for (int next : list.get(v)) {
            if (colors[next] == color) { // 인접한 정점과 색이 같으면 이분 그래프가 아님
                check = false;
                return;
            }
            if (colors[next] == 0) { // 방문하지 않은 정점이라면
                dfs(next, -color);
            }
        }

    }
}