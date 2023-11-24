

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum = N+M;

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        int cnt=0;
        while(sum-->0){
            String name = br.readLine();
            if(set.contains(name)) {
                cnt++;
                list.add(name);
            }
            set.add(name);
        }
        Collections.sort(list);
        System.out.println(cnt);
        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s).append("\n");

        System.out.println(sb);
    }
}
