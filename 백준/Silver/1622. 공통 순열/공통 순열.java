import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        String a, b;
        while((a = br.readLine())!=null){
            b=br.readLine();
            int[] cntA = new int[26], cntB = new int[26];
            for(int i=0; i<a.length(); i++) cntA[a.charAt(i)-'a']++;
            for(int i=0; i<b.length(); i++) cntB[b.charAt(i)-'a']++;
            for(int i=0; i<26; i++){
                int cnt = Math.min(cntA[i], cntB[i]);
                for(int j=0; j<cnt; j++) sb.append((char)(i+'a'));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

