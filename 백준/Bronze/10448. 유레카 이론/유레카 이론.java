import java.io.*;
import java.util.*;

public class Main {
    public static int triangle(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            boolean flag = false;
            loop:
            for (int i = 1; i <= K; i++) {
                for (int j = 1; j <= K; j++) {
                    for (int k = 1; k <= K; k++) {
                        if (triangle(i) + triangle(j) + triangle(k) == K) {
                            flag = true;
                            break loop;
                        }
                    }
                }
            }
            if (flag) System.out.println(1);
            else System.out.println(0);

        }

    }

}


