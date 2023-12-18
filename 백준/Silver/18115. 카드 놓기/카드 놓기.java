import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) list.add(Integer.parseInt(st.nextToken()));
        Collections.reverse(list);
 
        for(int i=1; i<=n; i++){
            int skill = list.get(i-1);
            if(skill == 1) deque.addFirst(i);
            else if(skill == 2){
                int pop = deque.removeFirst();
                deque.addFirst(i);
                deque.addFirst(pop);
            }else deque.addLast(i);
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.removeFirst()).append(" ");
        }
        System.out.println(sb);
    }
}


