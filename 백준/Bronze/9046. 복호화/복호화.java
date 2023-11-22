import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            String str = br.readLine();
            int[] arr = new int[26];
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i)==' ') continue;
                arr[str.charAt(i)-'a']++;
            }
            int max = 0; 
            for(int i: arr){
                max = Math.max(max, i);
            }
            int maxCnt = 0;
            int answer = 0;

            for(int i=0; i<arr.length; i++){
                if(arr[i] == max){
                    answer = i;
                    maxCnt++;
                }
                if(maxCnt > 1){
                    break;
                }
            }
            if(maxCnt == 1) System.out.println((char)(answer+'a'));
            else System.out.println("?");
        }
    }
}
