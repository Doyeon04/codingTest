import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int sum=0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
        }
        Arrays.sort(arr);

        long total=0;
        for(int i=0; i<n-1; i++){
            sum-=arr[i];
            total+= (long) arr[i] * sum;
        }
        System.out.println(total);
        // 2 3 4 5

    }
}

