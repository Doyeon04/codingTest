import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int map[][][] = new int[n][5][7];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                String str = br.readLine();
                for (int k = 0; k < 7; k++) {
                    map[i][j][k] = str.charAt(k);
                }
            }
        }
        int cnt = 0;
        int min = Integer.MAX_VALUE, a = 0, b = 0;
        for (int i = 0; i < n; i++) { // 그림 2개 비교
            for (int j = i + 1; j < n; j++) {
                cnt = 0;

                // 그림 두 개를 놓고 한 칸씩 비교
                for (int y = 0; y < 5; y++) {
                    for (int x = 0; x < 7; x++) {
                        if (map[i][y][x] != map[j][y][x]) {
                            cnt++;
                        }
                    }
                }
                if (cnt < min) {
                    min = cnt;
                    a = i + 1;
                    b = j + 1;
                }
            }

        }
        System.out.println(a+" "+b);
    }
}


