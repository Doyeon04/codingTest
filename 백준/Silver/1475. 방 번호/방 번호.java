import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] nums = new int[10];

        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i)-'0';
            nums[num]++;
        }
        int answer=0;
        int tmp = 0; 
        
        if((nums[9]+nums[6]) % 2 != 0) tmp = (nums[9] + nums[6])/2 + 1; 
        else tmp = (nums[9]+nums[6])/2; 
        
        nums[9] = tmp;
        nums[6] = tmp;
        for(int i=0; i<nums.length; i++){
            answer = Math.max(answer, nums[i]);
        }
        System.out.println(answer);
    }
}
