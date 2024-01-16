import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char before = ' ';
        int cnt1=0;
        int cnt0=0;
        for(char c : s.toCharArray()){
            if(c!=before){
                if(c=='0') cnt0++;
                else cnt1++;
            }
            before = c;
        }
        System.out.println(Math.min(cnt0, cnt1));
    }
}

