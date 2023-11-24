import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        while (N-- > 0) {
            String str = br.readLine();
            int[] arr = new int[26];
            arr[str.charAt(0) - 'a']++;
            boolean isGroup = true;

            for (int i = 1; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c != str.charAt(i - 1) && arr[c-'a']>0) {
                    isGroup = false;
                    break;
                }
                arr[c - 'a']++;
            }
            if (isGroup) ans++;
        }
        System.out.println(ans);
    }
}