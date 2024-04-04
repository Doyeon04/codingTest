import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();
        int answer=Integer.MAX_VALUE;


        for(int i=0; i<b.length()-a.length()+1; i++){
            String part = b.substring(i, i+a.length());
            int diff=0;
            for(int j=0; j<a.length(); j++){
                if(a.charAt(j)!= part.charAt(j)) {
                    diff++;
                }
            }
            answer = Math.min(answer, diff);
        }
        System.out.println(answer);
    }
}
