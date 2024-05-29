import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] heights = new int[1000];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }
        int answer = n;

        for(int i=0; i<n; i++){
            int time = 0;
            for(int j=0; j<n; j++){
                int now = k * (j-i) + heights[i];
                if(now < 1){
                    time = n;
                    break;
                }
                if(now != heights[j]) time++;
            }
            answer = Math.min(answer, time);
        }
        System.out.println(answer);

    }

}
