import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans=0;

        while(true){
            if(n%5==0){
                ans += n / 5;
                break;
            }
            n-=2;
            ans++;

            if(n<0){
                ans = -1;
                break;
            }
        }
        System.out.println(ans);
    }
}

