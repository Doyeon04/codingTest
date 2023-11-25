import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            Queue<int[]> q = new LinkedList<>();
            PriorityQueue<Integer> priQ = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                q.offer(new int[]{i, n});
                priQ.offer(n);
            }
            int cnt = 1;
            while (true) {
                if (q.peek()[1] != priQ.peek()) {
                    q.offer(q.poll());
                } else { // 인쇄됨
                    if (q.peek()[0] == M) {
                        sb.append(cnt).append("\n");
                        break;
                    }
                    q.poll();
                    priQ.poll();
                    cnt++;
                }
            }

        }
        System.out.println(sb);
    }
}
