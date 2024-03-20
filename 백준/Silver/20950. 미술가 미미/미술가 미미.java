import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] R, G, B, gom;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        R = new int[n];
        G = new int[n];
        B = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        gom = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            gom[i] = Integer.parseInt(st.nextToken());
        }
        int len = 0;
        if (n <= 7) len = n;
        else len = 7;

        for (int i = 2; i <= len; i++) {
            dfs(0, i, 0, 0, 0, 0);
        }
        System.out.println(min);
    }

    static void dfs(int count, int totalLen, int start, int r, int g, int b) {
        if (count == totalLen) {
            r /= totalLen;
            g /= totalLen;
            b /= totalLen;
            min = Math.min(min, Math.abs(r - gom[0]) + Math.abs(g - gom[1]) + Math.abs(b - gom[2]));
            return;
        }
        for (int i = start; i < n; i++) {
            dfs(count + 1, totalLen, i + 1, r + R[i], g + G[i], b + B[i]);
        }
    }

}
