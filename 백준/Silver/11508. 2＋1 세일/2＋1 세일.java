import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 2 / 2 3 3
        // 4 5 5 / 5 5 6 => 11 + 10
        Arrays.sort(arr);


        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i-=3) {
            if (i - 2 >= 0) {
                sum += arr[i] + arr[i - 1];
            }else{
                if(i-1 >= 0) sum += arr[i] + arr[i-1];
                else sum += arr[i];
            }
        }
        System.out.println(sum);
    }
}

