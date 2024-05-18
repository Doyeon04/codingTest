import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        String[] names = new String[n];
        long answer=0;
        for(int i=0; i<n; i++){
            names[i] = br.readLine();
            int len = names[i].length();

            map.put(len, map.getOrDefault(len, 0) + 1);

            if(i>k){
                int removeLen = names[i-k-1].length();
                map.put(removeLen, map.get(removeLen)-1);
            }

            answer+=map.get(len)-1;
        }
        System.out.println(answer);
    }

}
/*
등수의 차이 <= k
이름의 길이가 같은 친구 쌍 구하기

CYNTHIA
LLOYD
STEVIE
KEVIN
MALCOLM
DABNEY

 */
