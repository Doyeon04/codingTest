import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {
    static int a, b, n, m;
    static boolean[] visit;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[100001];
        System.out.println(bfs(n));
    }

    static void checkAndOffer(int x, int cnt){
        if(x >= 0 && x <= 100000 && !visit[x]) {
            q.offer(new int[]{x, cnt+1});
            visit[x] = true;
        }
    }
    static int bfs(int v){
        q.offer(new int[]{v, 0});
        visit[v] = true;

        while(!q.isEmpty()){
            int[] poll = q.poll();
            int x = poll[0];
            int cnt = poll[1];
            if(x==m){
                return poll[1];
            }
            checkAndOffer(x*a, cnt);
            checkAndOffer(x*b, cnt);
            checkAndOffer(x+a, cnt);
            checkAndOffer(x+b, cnt);
            checkAndOffer(x+1, cnt);
            checkAndOffer(x-1, cnt);
            checkAndOffer(x-a, cnt);
            checkAndOffer(x-b, cnt);
        }
        return 0;
    }
}

