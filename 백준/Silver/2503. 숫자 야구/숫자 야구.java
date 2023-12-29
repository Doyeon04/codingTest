import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[1000];

        for(int i=123; i<1000; i++){
            String num = String.valueOf(i);
            if(num.charAt(0) == num.charAt(1) || num.charAt(1) == num.charAt(2) || num.charAt(0) == num.charAt(2)) continue;
            if(num.contains("0")) continue;

            check[i] = true;
        }
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for(int i=123; i<1000; i++){
               if(!check[i]) continue;

               String num =String.valueOf(i);
                int s=0;
                int b=0;
                for(int j=0; j<3; j++){
                    char min = String.valueOf(q).charAt(j);
                    for(int k=0; k<3; k++){
                        char young = num.charAt(k);

                        if(min==young && j==k) s++;
                        else if(min==young) b++;
                    }
                }
                if(s==strike && b==ball) {
                    check[i] = true;
                }
                else check[i] = false;
            }
        }
        int cnt=0;
        for(int i=0; i<check.length; i++){
            if(check[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
