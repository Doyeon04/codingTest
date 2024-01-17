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

        int total=0;
        for(int i=0; i<n-1; i++){
            int restSum=0;
            for(int j=i+1; j<n; j++){
                restSum+=arr[j];
            }
            total+=arr[i]*restSum;
        }
        System.out.println(total);
    }
}

