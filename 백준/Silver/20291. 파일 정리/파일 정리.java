import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        while(N-->0){
            String file = br.readLine();
            String extension = file.split("\\.")[1];
            map.put(extension, map.getOrDefault(extension, 0)+1);
        }
        for(String key : map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
    }
}
