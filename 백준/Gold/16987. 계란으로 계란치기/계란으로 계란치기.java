import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[] durability;
    static int[] weight;
    static int n;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        durability = new int[n];
        weight = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int nowIndex, int cnt) {

        if (nowIndex == n) { // n번째 계란까지 들어서 깨봤다면
            answer = Math.max(answer, cnt);
            return;
        }
        if (durability[nowIndex] <= 0 || cnt == n - 1) { // 손에든 계란이 깨졌거나 나머지 계란들이 다 깨졌으면
            dfs(nowIndex + 1, cnt);
            return;
        }

        int saveCnt=cnt; 
        for (int i = 0; i < n; i++) {

            if (nowIndex == i || durability[i] <= 0) {
                continue; // 자신이랑 같은 계란, 깨진 계란은 제외
            }

            durability[nowIndex] -= weight[i];
            durability[i] -= weight[nowIndex];

            if (durability[nowIndex] <= 0) {
                cnt++;
            }
            if (durability[i] <= 0) {
                cnt++;
            }
            dfs(nowIndex + 1, cnt);
            cnt=saveCnt; 
            durability[nowIndex] += weight[i];
            durability[i] += weight[nowIndex];
        }
    }
}
