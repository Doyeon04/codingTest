import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Test implements Comparable<Test>{
    int a, b;
    public Test(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public int compareTo(Test o){
        return this.a - o.a; // 서류 심사 성적 오름차순 정렬
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            List<Test> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new Test(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            Collections.sort(list);

            int cnt=0;
            int highRank = Integer.MAX_VALUE;
            for(Test t : list){
                if(t.b < highRank){
                    highRank = t.b;
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }

}

