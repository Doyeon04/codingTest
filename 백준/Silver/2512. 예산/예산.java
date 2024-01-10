import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr =  new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i=0; i<n; i++){
           arr[i] = Integer.parseInt(st.nextToken());

        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int start=0;
        int end = arr[n-1];
        int ans=0;
        while(start<=end){
            int mid = (start+end)/2;

            int sum=0;
            for (int money : arr) {
                if(money <= mid) sum+= money;
                else sum += mid;
            }
            if(sum <= m){
                start = mid+1;
                ans = mid;
            }else{
                end = mid-1;
            }
        }
        System.out.println(ans);
    }
}