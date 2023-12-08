import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for(int i=0; i<A; i++){
            setA.add(Integer.parseInt(st.nextToken()));
        }
        int cnt=0;
        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<B; i++){
            int num = Integer.parseInt(st.nextToken());
            setB.add(num);
            if(!setA.contains(num)) cnt++;
        }
        for(int n : setA){
            if(!setB.contains(n)) cnt++;
        }
        System.out.println(cnt);
    }
}


