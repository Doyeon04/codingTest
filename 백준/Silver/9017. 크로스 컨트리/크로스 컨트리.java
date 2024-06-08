import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            int[] counts = new int[201];
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new HashMap<>(); // 팀 번호, 점수 총합
            List<List<Integer>> list = new ArrayList<>();
            for(int i=0; i<=200; i++){
                list.add(new ArrayList<>());
            }

            for(int i=0; i<n; i++){
                int teamNum = Integer.parseInt(st.nextToken());
                counts[teamNum]++;
                arr[i] = teamNum;
            }
            int score=1;
            for(int i=0; i<n; i++){
                if(counts[arr[i]]!=6) continue;

                list.get(arr[i]).add(score++);
            }

            for(int i=1; i<list.size(); i++){
               if(counts[i]!= 6) continue;

                int sum=0;
                for(int j=0; j<4; j++){
                    sum+=list.get(i).get(j);
                }
                map.put(i, sum);
            }
            int minSum=Integer.MAX_VALUE;
            int winTeam = 0;
            for (Integer key : map.keySet()) {
                if(map.get(key) < minSum){
                    minSum = map.get(key);
                    winTeam = key;
                }else if(map.get(key) == minSum){
                    if(list.get(key).get(4) < list.get(winTeam).get(4)){
                        winTeam = key;
                    }
                }
            }
            sb.append(winTeam).append("\n");
        }
        System.out.println(sb);

    }
}
