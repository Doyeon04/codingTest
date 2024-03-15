import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] answers = new int[10];
    static int answer=0;
    static int[] nums = new int[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<10; i++){
            answers[i] = Integer.parseInt(st.nextToken());
        }
        dfs( 0);
        System.out.println(answer);
    }
    static void dfs(int len){
        if(len == 10){
            String s = "";
            for (int num : nums) {
                s+=num;
            }
            if(s.contains("111")) return;
            if(s.contains("222")) return;
            if(s.contains("333")) return;
            if(s.contains("444")) return;
            if(s.contains("555")) return;
            

            int score=0;
            for(int i=0; i<10; i++){
                if(s.charAt(i)-'0' == answers[i]){
                    score++;
                }
            }
            if(score >= 5){
                answer++;
            }
            return;
        }

        for(int i=1; i<=5; i++){
            nums[len] = i;
            dfs(len+1);
        }
    }

}
