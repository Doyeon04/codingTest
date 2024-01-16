import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        char before = ' ';
        int bCnt=0;
        int rCnt=0;
        for(int i=0; i<n; i++){
            char c = s.charAt(i);
            if(before != c){
                if(c=='B') bCnt++;
                else rCnt++;
            }
            before = c;
        }
        int ans = Math.min(bCnt, rCnt) +1;
        System.out.println(ans);

    }
}

