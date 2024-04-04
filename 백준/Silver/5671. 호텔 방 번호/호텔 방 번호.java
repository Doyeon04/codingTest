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

        String s = "";
        StringBuilder sb = new StringBuilder();

        while((s = br.readLine())!=null && !s.isEmpty()){
            StringTokenizer st = new StringTokenizer(s);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int answer=0;

            for(int i=n; i<=m; i++){
                int[] nums = new int[10];
                String room = String.valueOf(i);
                boolean possible = true;

                for(char c : room.toCharArray()){
                    if(nums[c-'0'] > 0) {
                        possible = false;
                        break;
                    }
                    nums[c-'0']++;
                }
                if(possible) answer++;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);


    }
}
