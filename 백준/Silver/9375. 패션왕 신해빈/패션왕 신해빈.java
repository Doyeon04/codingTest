import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 2 * 1 => 3 * 2 -1
        // 1 * 1 => 2 * 2 -1
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            while(n-->0){
                String[] strs = br.readLine().split(" ");
                map.put(strs[1], map.getOrDefault(strs[1], 0)+1);
            }

            int ans=1;
            for(String s : map.keySet()){
                ans *= (map.get(s)+1);
            }
            System.out.println(ans-1);

        }
    }
}


