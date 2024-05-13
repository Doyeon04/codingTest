import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        int[] count = new int[d + 1];

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int cnt=0;
        for (int i = 0; i < k; i++) {
            if(count[sushi[i]]==0){
                cnt++;
            }
            count[sushi[i]]++;
        }
        int answer = 0;
        for(int start=0; start<n; start++){
            int end = (start + k) % n;

            count[sushi[start]]--;
            if(count[sushi[start]]==0) cnt--; // 아예 없는 초밥이라면 카운팅 감소

            if(count[sushi[end]]==0){
                cnt++;
            }
            count[sushi[end]]++;

            int totalCnt = cnt;
            if(count[c]==0) totalCnt++;

            answer = Math.max(answer, totalCnt);
        }
        System.out.println(answer);
    }
}