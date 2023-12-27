import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int[] cnt = new int[26];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            Arrays.fill(cnt, 0);
            for (int j = 0; j < n; j++) {
                cnt[arr[j][i] - 'A']++;
            }
            char c = ' ';
            int max = 0;
            for (int k = cnt.length - 1; k >= 0; k--) {
                if (cnt[k] >= max) {
                    max = cnt[k];
                    c = (char) (k + 'A');
                }
            }
            sb.append(c);
        }
        System.out.println(sb);
        int diff = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (sb.toString().charAt(i) != arr[j][i]) diff++;
            }
        }
        System.out.println(diff);
    }
}


