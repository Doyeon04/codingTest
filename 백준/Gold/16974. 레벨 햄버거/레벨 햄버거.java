import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static long[] layers;
    static long[] patties;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        layers = new long[n + 1]; // 각 레벨 별 버거 층 수
        patties = new long[n + 1]; // 각 레벨 별 패티 수

        layers[0] = 1;
        patties[0] = 1;

        for (int i = 1; i <= n; i++) {
            layers[i] = layers[i - 1] * 2 + 3;
            patties[i] = patties[i - 1] * 2 + 1;
        }
        System.out.println(countPatties(n, x));
    }

    // 레벨 n의 버거에서 아래 x번째 층까지 먹은 패티의 수 계산
    public static long countPatties(int n, long x) {

        // 레벨이 0인 경우
        if (n == 0) {
            if (x == 1) {
                return 1; // 층이 1이면 패티는 1장
            } else {
                return 0; // 패티는 없음
            }
        }

        if (x == 1) {
            return 0; // 레벨 0이 아닐 때 먹은 층이 첫번째 층인 경우 패티 없음
        } else if (x <= 1 + layers[n - 1]) { // x가 중간 패티 위치보다 작으면
            // 맨 앞의 빵을 빼고(x-1) 이전 레벨의 패티수를 호출
            return countPatties(n - 1, x - 1);
        } else if (x == 1 + layers[n - 1] + 1) { // x가 중간 패티 위치에 있다면
            return patties[n - 1] + 1; // 이전 패티의 수 + 1
        } else if (x <= 1 + layers[n - 1] + 1 + layers[n - 1]) { // x가 중간 패티 위치보다 크다면
            // 중간 패티까지의 패티 수 + (현재 층 - 중간 패티 위치의 층)
            return (patties[n - 1] + 1) + countPatties(n - 1, x - (1 + layers[n - 1] + 1));
        } else { // 먹은 층이 레벨 n의 층까지라면
            return patties[n]; // 레벨 n의 모든 패티를 다먹음
        }
    }
}

/*
(L)버거 : B, (L-1)버거, P, (L-1)버거, B

0) P
1) B, P, P, P, B
2) B, BPPPB, P, BPPPB, B
3) B, BBPPPBPBPPPBB, P, BBPPPBPBPPPBB, B
...

 */