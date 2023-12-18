import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int idx = deque.indexOf(num);

            while (deque.peekFirst() != num) {
                if (idx <= deque.size() / 2) {
                    deque.addLast(deque.removeFirst());
                } else {
                    deque.addFirst(deque.removeLast());
                }
                cnt++;
            }
            deque.removeFirst();
        }
        System.out.println(cnt);
    }
}


