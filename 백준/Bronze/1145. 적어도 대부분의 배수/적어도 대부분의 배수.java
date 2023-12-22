import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[5];
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int num=0;
        int min=Integer.MAX_VALUE;
        while(true){
            num++;
            for(int i=0; i<3; i++){
                for(int j=i+1; j<4; j++){
                    for(int k=j+1; k<5; k++){
                        if(num % arr[i] ==0 & num % arr[j] ==0 && num % arr[k]==0){
                            min =Math.min(min, num);
                        }
                    }
                }
            }
            if(num==1000000) break;
        }
        System.out.println(min);
    }
}


