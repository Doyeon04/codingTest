import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            list.add(new int[]{i+1, num});
        }
        int idx = 0;

        while(true){
            int curNum = list.get(idx)[1];
            System.out.print(list.get(idx)[0]+" ");
            list.remove(idx);

            if(list.size()==0) break;

            int nextIdx = 0;
            if(curNum > 0){
                nextIdx = (idx + curNum - 1) % list.size();
            }else{
                nextIdx = (list.size() + (idx + curNum)) % list.size();
            }
            if(nextIdx < 0) nextIdx += list.size(); 
            idx = nextIdx;
        }

    }
}
