import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0, left = 0, cnt = 0, answer = Integer.MAX_VALUE;
        boolean exist = false;
        for(int right = 0; right<n; right++){
            sum+=arr[right]; // right 인덱스를 증가시키며 sum에 누적
            cnt++;
           // System.out.println("left: "+left+",right: "+right+",sum: "+sum+",cnt:"+cnt);
            while(sum >= s) { // 합이 s이상이면
                exist = true;
                answer = Math.min(answer, cnt);
                sum -= arr[left++];
                cnt--;
                //System.out.println("left: " + left + ",right: " + right + ",sum: " + sum + ",cnt:" + cnt);
            }
        }
        System.out.println(exist ? answer : 0);
    }
}