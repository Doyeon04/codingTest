import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String x="";
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++){
            x+=st.nextToken();
        }
        int ans=0;
        while(n>=0){
           String str = String.valueOf(n);
           boolean allIn = true;
           for(char c : str.toCharArray()){
               if(!x.contains(String.valueOf(c))){
                  allIn= false;
                  break;
               }
           }
           if(allIn) {
               ans=Math.max(ans, n);
               break; 
           }
           n--;
        }
        System.out.println(ans);
    }
}


