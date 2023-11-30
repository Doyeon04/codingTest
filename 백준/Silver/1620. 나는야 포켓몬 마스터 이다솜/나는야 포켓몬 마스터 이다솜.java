import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int idx=1;
        while(N-->0){
            String str = br.readLine();
            map.put(str, idx++);
            list.add(str);
        }
        while (M-- > 0) {
            String str = br.readLine();
            char start = str.charAt(0);
            if(start >= '0' && start <= '9'){
                System.out.println(list.get(Integer.parseInt(str)-1));
            }else System.out.println(map.get(str));
        }

    }
}

