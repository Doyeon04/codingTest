import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][9];
        StringBuilder sb = new StringBuilder();


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 8; j++) {
                int next = i + 1;
                if (i == n) next = 1;

                if (arr[i][j] == 0 && arr[next][j] == 0) {
                    arr[i][j] = 1; // 내손 사용
                    arr[next][j] = 1; // 그다음 문어도 같은 손 사용
                    sb.append(j).append(" ");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

