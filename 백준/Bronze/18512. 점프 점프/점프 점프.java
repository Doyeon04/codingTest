import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int ans=-1;
        while(p1 < 10000 && p2 < 10000){
            if(p1 > p2){
                p2+=y;
            }else if(p1 < p2){
                p1+=x;
            }else{
                ans = p1;
                break;
            }

        }
        System.out.println(ans);
    }
}


