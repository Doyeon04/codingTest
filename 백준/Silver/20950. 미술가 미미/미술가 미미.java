import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] colors;
    static int[] gomColor = new int[3];
    static int[] pickColors;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        colors = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            gomColor[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 2; i <= 7; i++) { // 1개 ~ 7개의 물감을 뽑는 경우의 수
            pickColors = new int[i];
            dfs(i, 0, 0);
        }
        System.out.println(answer);
    }

    static void dfs(int totalLen, int curLen, int start) {
        if (totalLen == curLen) {
            int[] newColor = new int[3];
            for (int pickColor : pickColors) {
                for (int i = 0; i < 3; i++) {
                    newColor[i] += colors[pickColor][i];
                }
            }
            for (int i = 0; i < 3; i++) {
                newColor[i] /= totalLen;
            }
            int diff = 0;
            for (int i = 0; i < 3; i++) {
                diff += Math.abs(newColor[i] - gomColor[i]);
            }
            answer = Math.min(answer, diff);
            return;
        }

        for (int i = start; i < n; i++) {
            pickColors[curLen] = i;
            dfs(totalLen, curLen + 1, i + 1);
        }

    }

}
