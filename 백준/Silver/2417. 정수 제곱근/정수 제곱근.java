import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long start = 0, end=n;
        long ans=0;

        while(start<=end){
            long mid = (start+end)/2;
            if(Math.pow(mid,2)>= n){
                end=mid-1;
                ans=mid;
            }else{
                start=mid+1;
            }
        }
        System.out.println(ans);
    }
}