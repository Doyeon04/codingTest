import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] nums = new int[10];

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num == 9) {
                num = 6;
            }
            nums[num]++;
        }

        int sixCnt = nums[6] / 2;
        if (nums[6] % 2 != 0) {
            sixCnt++;
        }
        nums[6] = sixCnt;

        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            answer = Math.max(answer, nums[i]);
        }

        System.out.println(answer);
    }
}
// 99966