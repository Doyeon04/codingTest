import java.io.*;
import java.util.Arrays;

public class Main {
    static String wolf = "wolf";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] cnt = new int[26];
        char[] arr = new char[4];
        char prev = str.charAt(0);
        arr[0] = str.charAt(0); 
        cnt[str.charAt(0)-'a']++;
        int idx=1;

        for(int i=1; i<str.length(); i++){
            char now = str.charAt(i);
            if(now == prev){
                cnt[now-'a']++; // 알파벳이 등장한 횟수
                continue;
            }
            // 이전문자와 같지 않을 경우
            
            if(idx==4){
                if(!check(arr, cnt)) {
                    System.out.println(0);
                    return;
                }
                idx=0;
                Arrays.fill(cnt, 0);
            }
            arr[idx++] = now;
            cnt[now-'a']++; 
            prev = now;
        }

        if(!check(arr, cnt)){
            System.out.println(0);
        }else System.out.println(1);
    }

    private static boolean check(char[] arr, int[] cnt){
        int n = cnt[arr[0]-'a'];
        for(int i=0; i<4; i++){
            if(arr[i] != wolf.charAt(i)) return false;
            if(cnt[arr[i]-'a'] != n) return false;
        }
        return true;
    }
}
