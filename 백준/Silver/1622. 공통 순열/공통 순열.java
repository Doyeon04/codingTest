import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        while(true){
            String a = br.readLine();
            if(a == null) break;
            String b = br.readLine();

            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();

            for(char c : a.toCharArray()){
                map1.put(c, map1.getOrDefault(c, 0)+1);
            }
            for(char c : b.toCharArray()){
                map2.put(c, map2.getOrDefault(c,0)+1);
            }
            String ans="";
            for(Character c : map1.keySet()){
                int cnt=0;
                if(map2.containsKey(c)){
                    cnt = Math.min(map1.get(c), map2.get(c));
                }
                while(cnt-->0){
                    ans+=c;
                }
            }
            char[] arr = ans.toCharArray();
            Arrays.sort(arr);
            System.out.println(new String(arr));
        }
    }
}

