import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        for(int i=0; i<n; i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        int now = score[n-1];
        int ans=0;
        for(int i=n-2; i>=0; i--){
            if(score[i] >= now){
                ans+= score[i] - (now-1);
                now--;
            }else{
                now = score[i];
            }
        }
        System.out.println(ans);


    }
}