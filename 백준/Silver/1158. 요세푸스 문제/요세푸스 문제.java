import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int idx = k-1;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) list.add(i);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(n>1){
            sb.append(list.remove(idx--)).append(", ");
            idx = (idx+k) % --n;
        }
        sb.append(list.remove(idx)).append(">");
        System.out.println(sb);

    }
}
