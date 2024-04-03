import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cakes = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cakes[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(cakes);

        List<Integer> tenCakes = new ArrayList<>();
        List<Integer> otherCakes = new ArrayList<>();

        for(int cake : cakes){
            if(cake % 10 == 0) tenCakes.add(cake);
            else otherCakes.add(cake);
        }

        int cakeCount=0;

        for(int cake : tenCakes){ // 10으로 나눠떨어지는 케이크들
            if(m <= 0) break;

            m-= (cake/10 -1);
            cakeCount += cake/10;
        }

        if(m < 0){
            cakeCount -= -1 * m + 1; // 최대 자를 수 있는 횟수를 초과해서 나온 케이크 개수만큼 다시 빼줌
        }else{
            for(int cake : otherCakes){
                if(m <= 0) break;

                m -= (cake/10);
                cakeCount += cake/10;
            }
            if(m < 0){
                cakeCount -= -1 * m;
            }

        }
        System.out.println(cakeCount);
    }
}


