import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int h = 0, m = 0, s = 0;
        int cnt=0;
        while(true){
            
            if(s==60){
                m++;
                s=0;
            }
            if(m==60){
                h++;
                m=0;
            }
            String time = (h < 10 ? "0" + h : h+"") + (m < 10 ? "0" + m : m+"") + (s < 10 ? "0" + s : s+"");
            if(time.contains(K+"")) cnt++;

            if(h==N && s == 59 && m == 59) break;
            s++;
        }
        System.out.println(cnt);
    }
}


