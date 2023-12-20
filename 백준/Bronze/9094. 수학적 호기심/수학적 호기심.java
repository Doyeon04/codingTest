import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int cnt=0;
            for(int a=1; a<n; a++){
                for(int b=a+1; b<n; b++){
                    if((Math.pow(a, 2) + Math.pow(b, 2) + m) % (a*b) == 0) cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
}


