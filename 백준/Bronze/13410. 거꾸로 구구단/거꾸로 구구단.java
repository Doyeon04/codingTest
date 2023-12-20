import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max=0;
        for(int i=1; i<=K; i++){
            int n = N * i;
            StringBuilder val = new StringBuilder();
            while(n>0){
                val.append(n%10);
                n /= 10;
            }
            max = Math.max(max, Integer.parseInt(String.valueOf(val)));
        }
        System.out.println(max);
    }
}


