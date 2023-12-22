import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt=0;
            while(n<=m){
                String s = String.valueOf(n);
                for(char c : s.toCharArray()){
                    if(c=='0') cnt++;
                }
                n++;
            }
           sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}


