import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long max=0;
        if(n%2!=0) max = arr[n-1];

        for(int i=0; i<n/2; i++){
            if(n%2==0){
                max = Math.max(max, arr[i] + arr[n-1-i]);
            }else{
                max = Math.max(max, arr[i] + arr[n-2-i]);
            }
        }
        System.out.println(max);
    }
}

