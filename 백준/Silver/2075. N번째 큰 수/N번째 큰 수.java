import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(q.size() == N){
                    if(q.peek() < num){ // n개의 숫자가 들어있는 큐에서 가장 작은 값보다 더 크면 추가
                        q.poll();
                        q.add(num);
                    }
                }else q.add(num);
            }
        }
        System.out.println(q.peek());
    }
}


