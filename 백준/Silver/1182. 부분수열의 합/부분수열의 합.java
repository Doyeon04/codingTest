import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n, s;
    static int answer;

    public static void dfs(int cnt, int sum) {
        if (cnt == n) {
            if(sum == s) answer++;
            return;
        }
        dfs(cnt + 1, sum + arr[cnt]); // 해당 인덱스값 더함
        dfs(cnt + 1, sum); // 해당 인덱스값 안 더함
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if(s==0) System.out.println(answer-1);
        else System.out.println(answer);
    }
}