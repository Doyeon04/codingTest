import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[] arr = new char[N*W];

        for(int i=0; i<H; i++){
            String str = br.readLine();
            for(int j=0; j<N*W; j++){
                if(str.charAt(j)!='?') arr[j] = str.charAt(j);
            }
        }
        int cnt=0;
        String ans="";
        char c = '?';
        for(int i=0; i<arr.length; i++){
            cnt++;
            if(arr[i]!=0){
                c = arr[i];
            }
            if(cnt==W){
                cnt=0;
                ans+=String.valueOf(c);
                c='?';
            }
        }
        System.out.println(ans);
    }
}

