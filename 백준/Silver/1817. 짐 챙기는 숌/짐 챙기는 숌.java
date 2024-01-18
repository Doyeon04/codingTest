import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n==0){
            System.out.println(0);
            return;
        }
        st = new StringTokenizer(br.readLine());
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += weight[i];
            if (sum > m) {
                cnt++;
                sum = weight[i];
            }
        }
        System.out.println(cnt);

    }
}
