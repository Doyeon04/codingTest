import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max=Integer.MIN_VALUE;
        for(int i=K-1; i<N; i++){
            int sum=0;
            for(int j=0; j<K; j++){
                sum+=arr[i-j];
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}


