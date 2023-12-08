import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>();
        int cnt=0;
        while(true){
            String str = br.readLine();
            if(str==null) break; 
            cnt++;
            map.put(str, map.getOrDefault(str, 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(String key : map.keySet()){
            double rate = ((double)map.get(key) / cnt) * 100;
            sb.append(key).append(" ").append(String.format("%.4f", rate)).append("\n");
        }
        System.out.println(sb);
    }
}


