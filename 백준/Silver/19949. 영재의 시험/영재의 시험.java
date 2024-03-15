import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] answers = new int[10];
    static int answer = 0;
    static int[] marks = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    static void dfs(int depth, int score) {
        if (depth == 10) {
            if (score >= 5) answer++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2 && (marks[depth - 1] == marks[depth - 2])) {
                if (marks[depth - 1] == i) continue;
            }
            marks[depth] = i;
            if (i == answers[depth]) dfs(depth + 1, score + 1);
            else dfs(depth + 1, score);
        }
    }

}
