
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        int m = Integer.parseInt(st.nextToken()); // 가져가려는 나무의 길이

        // 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값구하기
        int[] trees = new int[n];

        int max = 0 ;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        int left = 0;
        int right = max;
        int answer = 0;

        while(left<=right){
            int mid = (left+right)/2;
            long sum = 0;
            for(int height : trees){
                if(height>mid) sum += height - mid; // 나무 높이가 절단기 높이보다 크다면
            }
            if(sum>=m){
                answer = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

}
