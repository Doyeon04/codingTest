import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = 0;
        for (int i = 1; i <= K; i++) {
            int base = N * i;
            int reverse = 0;
            while (base > 0) {
                reverse *= 10;
                reverse += base % 10;
                base /= 10;
            }
            max = Math.max(max, reverse);
        }
        System.out.println(max);
    }
}


