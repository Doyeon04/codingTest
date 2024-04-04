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
                if(check(i)) answer++;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(int i) {
        int[] nums = new int[10];
        String room = String.valueOf(i);

        for(char c : room.toCharArray()){
            if(nums[c-'0'] > 0) {
               return false;
            }
            nums[c-'0']++;
        }
        return true;
    }
}
