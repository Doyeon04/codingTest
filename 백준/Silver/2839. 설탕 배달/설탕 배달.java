import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans=0;

        while(n%5!=0){
            n-=3;
            ans++;
        }
        if(n<0) System.out.println(-1);
        else{
            ans+=n/5;
            System.out.println(ans);
        }
    }
}