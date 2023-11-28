import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        while(N-->0){
            String name = br.readLine();
            arr[name.charAt(0)-'a']++;
        }
        String ans="";
        for(int i=0; i<arr.length; i++){
            if(arr[i]>=5) ans+=(char)(i+'a');
        }
        System.out.println(ans.equals("") ? "PREDAJA" : ans);
    }
}
