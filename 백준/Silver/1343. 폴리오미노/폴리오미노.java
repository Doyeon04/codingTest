import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        int cnt=0;
        String ans = "";
        boolean flag = true;
        int idx=0;
        for(char c : board.toCharArray()){
            idx++;
            if(c == '.' || idx == board.length()) {
                if(c!='.') cnt++;
                int cntA = cnt / 4;
                cnt = cnt % 4;
                int cntB=0;
                if(cnt % 2==0) cntB = cnt / 2;
                else flag = false;
                
                for(int i=0; i<cntA; i++){
                    ans += "AAAA";
                }
                for(int i=0; i<cntB; i++){
                    ans += "BB";
                }
                if(c=='.') ans+='.';
                cnt=0;
            }else cnt++;
            
        }
        if(!flag) System.out.println(-1);
        else System.out.println(ans);
    }
}

