import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum=0;
        for(int i=0; i<9; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum+=num;
        }
        boolean stop = false;
        for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                if(sum-arr[i]-arr[j] == 100){
                    arr[i]=0;
                    arr[j]=0;
                    stop = true;
                    break;
                }
            }
            if(stop) break; 
        }
        for (int x : arr) {
            if(x!=0) System.out.println(x);
        }
    }
}


