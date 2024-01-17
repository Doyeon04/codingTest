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
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long total=0;
        for(int i=0; i<n-1; i++){
            long restSum=0;
            for(int j=i+1; j<n; j++){
                restSum+=arr[j];
            }
            total+=arr[i]*restSum; // 101 * 500,000 의 합 
        }
        System.out.println(total);
    }
}

