

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            str = br.readLine();
            if(str==null) break;

            st = new StringTokenizer(str);
            String s = st.nextToken();
            String t = st.nextToken();

            int sp=0;
            String ans = "No";

            for(int tp=0; tp<=t.length()-1; tp++){
                if(s.charAt(sp) == t.charAt(tp)) sp++;

                if(sp==s.length()){
                    ans="Yes";
                    break;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
