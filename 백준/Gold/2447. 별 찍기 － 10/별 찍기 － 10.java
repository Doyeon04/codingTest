import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (char[] a : arr) {
            Arrays.fill(a, ' '); 
        }

        makeStar(0, 0, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void makeStar(int x, int y, int n) {
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                makeStar(x + size * i, y + size * j, size);
            }
        }
    }
}

