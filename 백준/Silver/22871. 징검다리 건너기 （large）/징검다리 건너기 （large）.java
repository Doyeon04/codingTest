import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stones = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }
        long start = 1;
        long end = (long) (n - 1) * (1 + Math.abs(stones[n] - stones[1]));
        long ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2; // 최대 힘
            boolean flag = false;
            Stack<Integer> stack = new Stack<>();
            boolean[] visit = new boolean[n + 1];
            visit[1] = true;
            stack.push(1);

            while (!stack.isEmpty()) {
                int now = stack.pop();
                if (now == n) { // 오른쪽 끝까지 도달 가능했을 때
                    flag = true;
                    break;
                }
                for (int i = now + 1; i <= n; i++) { // 현재 돌에서 도달 가능한 돌들 탐색
                    long power = (long) (i - now) * (1 + Math.abs(stones[i] - stones[now]));
                    if (power <= mid && !visit[i]) { // 최대 힘(k) 이하고 방문하지 않았다면
                        stack.push(i);
                        visit[i] = true;
                    }
                }
            }
            if (flag) {
                end = mid - 1; //최솟값 구하기 위해 힘 범위를 작게 탐색
                ans = mid;
            } else { // 도달할 수 없다면 힘의 상한선을 높여서 탐색해봄
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
}