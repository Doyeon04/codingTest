import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        bfs(a);
    }

    static void bfs(int v){
        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[]{v, 1});

        while(!q.isEmpty()){
            long[] poll = q.poll();
            long n = poll[0];
            long cnt = poll[1];

            if(n==b){
                System.out.println(cnt);
                return;
            }

            if(n*2 <= b) q.add(new long[]{n*2, cnt+1});
            if(n*10+1 <= b) q.add(new long[]{n*10 + 1, cnt+1});

        }
        System.out.println(-1);
    }

}