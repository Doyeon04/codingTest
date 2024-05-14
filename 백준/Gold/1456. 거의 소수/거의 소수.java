import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        boolean[] isPrime = new boolean[10000001];

        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < isPrime.length; j = j + i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) { // 소수면
                long num = i;

                while (num <= b / i) {
                    num *= i;
                    if (num >= a)
                        count++;
                }

            }


        }
        System.out.println(count);
    }
}