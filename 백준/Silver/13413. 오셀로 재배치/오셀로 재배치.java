import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            String s1 = br.readLine();
            String s2 = br.readLine();
            int wbCnt=0, bwCnt=0;
            for(int i=0; i<n; i++){
                char before = s1.charAt(i);
                char after = s2.charAt(i);
                if(before!=after){
                    if(before=='W') wbCnt++;
                    else bwCnt++;
                }
            }

            System.out.println(Math.max(wbCnt, bwCnt));

        }
    }

}
