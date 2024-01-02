import java.io.*;
import java.util.*;

public class Main {
    static int h, w, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        가로로 정한 것이 모눈종이의 W의 이하라면
        세로로 정한 것중에 가장 큰게 모눈종이의 H의 이하라면
        넓이 최댓값 갱신
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPossible(arr[i], arr[j])) {
                    max = Math.max(max, arr[i][0] * arr[i][1] + arr[j][0] * arr[j][1]); // 두 스티커의 합의 최댓값 찾기
                }
            }
        }
        System.out.println(max);
    }

    static boolean isPossible(int[] sticker1, int[] sticker2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (sticker1[i] + sticker2[j] <= h && Math.max(sticker1[1 - i], sticker2[1 - j]) <= w) return true;
                if (sticker1[i] + sticker2[j] <= w && Math.max(sticker1[1 - i], sticker2[1 - j]) <= h) return true;
            }
        }
        return false;
    }
}
