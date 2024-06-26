import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[L];
        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(br.readLine());

        // 1000 * 1000 = 1000,000
        Arrays.sort(arr);
        long answer = 0;
        if(1 <= n && n <= arr[0]-1){
            answer+= findGoodRange(1, arr[0]-1, n);
        }

        for (int i = 0; i < L - 1; i++) {
            if (arr[i] + 1 <= n && arr[i + 1] - 1 >= n) {
                answer += findGoodRange(arr[i]+1, arr[i+1]-1, n);
            }
        }
        System.out.println(answer);
    }

    static int findGoodRange(int a, int b, int n){
        int cnt=0;
        for (int j = a; j <= b-1; j++) {
            for (int k = a+1; k <= b; k++) {
                if (j == k) continue;
                if (j <= n && n <= k) cnt++;
            }
        }
        return cnt;
    }
}

