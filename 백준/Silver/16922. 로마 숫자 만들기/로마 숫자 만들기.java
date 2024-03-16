import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] nums = {1, 5, 10, 50};
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 4개의 문자 중 n개를 뽑는 조합

        dfs(0, 0, 0);
        System.out.println(set.size());
    }
    static void dfs(int count, int sum, int start){
        if(count==n){
            set.add(sum);
            return;
        }
        for(int i=start; i<nums.length; i++){
            dfs(count+1, sum+nums[i], i);
        }

    }
}
