import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new TreeMap<>();
        for (int i=0; i<N; i++){
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int max=0;
        long answer=0;
        for(long key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }
        System.out.println(answer);
    }

}
