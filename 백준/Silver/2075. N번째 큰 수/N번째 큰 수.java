import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                pq.add(Integer.parseInt(str[j]));
            }
        }
        for(int i=0; i<N-1; i++){
            pq.poll();
        }
        System.out.println(pq.peek());
    }
}
