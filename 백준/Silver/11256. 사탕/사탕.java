import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken()); // 사탕의 개수
            int n = Integer.parseInt(st.nextToken()); // 상자의 개수
            int[] boxes = new int[n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                boxes[i] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            }
            Arrays.sort(boxes);
            int cnt=0;
            for(int i=n-1; i>=0; i--){
                cnt++;
                if(boxes[i] < j){
                    j -=boxes[i];
                }else{
                    break;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}