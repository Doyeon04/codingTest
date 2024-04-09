import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int[][] arr;
    public static boolean[] visited;
    public static int n;

    public static int[] nums;
    public static int min = Integer.MAX_VALUE;

    public static void dfs(int cnt, int s, int num){ // 조합

        if(cnt==num){
            int start = 0;
            int link = 0;

           /* for(int x : nums){
                System.out.print(x+" ");
            }*/
//            for(boolean x : visited){
//                System.out.print(x+" ");
//            }
//            System.out.println();

            for(int i=1; i<n; i++){
                for(int j=i+1; j<=n; j++){
                    if(visited[i] && visited[j]){ // 두 사람이 true면 스타트팀
                        start += arr[i][j] + arr[j][i];
                    }
                    else if(!visited[i] && !visited[j]){ // 두 사람이 false면 링크팀
                        link += arr[i][j] + arr[j][i];
                    }
                }
            }
            int gap = Math.abs(start-link); // 두 팀의 점수 차이

            min = Math.min(min, gap);
            return;
        }

        for(int i=s; i<=n; i++){ // 중복된 수열이 나오지 않도록 오름차순으로 하기 위해 s부터 시작
            if(visited[i]) continue;
            nums[cnt] = i;
            visited[i] = true;
            dfs(cnt+1, i+1, num); // 카운트 증가, i증가(오름차순 위해)
            visited[i] = false;

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        nums = new int[n];

        StringTokenizer st;

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n/2; i++){
            dfs(0, 1, i);
        }
        System.out.println(min);
    }
}