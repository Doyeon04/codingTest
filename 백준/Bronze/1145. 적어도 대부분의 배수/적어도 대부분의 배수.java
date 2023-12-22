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
        while(true){
            int cnt=0;
            num++;
            for(int i=0; i<5; i++){
                if(num>=arr[i] && num % arr[i]==0) cnt++;
            }
            if(cnt>2) break;
        }
        System.out.println(num);
    }
}


