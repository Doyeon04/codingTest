import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    static int blueCount = 0, whiteCount = 0;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count(0, 0, n);
        System.out.println(whiteCount);
        System.out.println(blueCount);

    }

    static void count(int x, int y, int len) {

        if (isAllSameColor(x, y, len)) {
            if (arr[x][y] == 0) {
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }
        
        int newLen = len / 2;

        count(x, y, newLen);
        count(x, y + newLen, newLen);
        count(x + newLen, y, newLen);
        count(x + newLen, y + newLen, newLen);
    }

    static boolean isAllSameColor(int x, int y, int len) {
        int val = arr[x][y];
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (arr[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }
}