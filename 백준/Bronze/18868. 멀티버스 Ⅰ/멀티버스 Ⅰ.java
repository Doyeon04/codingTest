import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        String[] arr = new String[M];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int[] tmp = new int[N];
            for(int j=0; j<N; j++){
                tmp[j] = Integer.parseInt(st.nextToken());
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<N-1; j++){
                for(int k=j+1; k<N; k++){
                    if(tmp[k]>tmp[j]) sb.append('+');
                    else if(tmp[k]<tmp[j]) sb.append('-');
                    else sb.append("=");
                }
            }
            arr[i] = sb.toString();
        }
        int cnt=0;
        for(int i=0; i<M-1; i++){
            for(int j=i+1; j<M; j++){
                if(arr[i].equals(arr[j])) cnt++;
            }
        }
        System.out.println(cnt);
    }
}


