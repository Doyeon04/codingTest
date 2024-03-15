import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] leakPoints = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            leakPoints[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(leakPoints);

        int tapeCount = 1;
        int start = leakPoints[0];

        for(int i=1; i<n; i++){
            if(leakPoints[i]-start>=l){
                start = leakPoints[i];
                tapeCount++;
            }
        }
        System.out.println(tapeCount);
    }

}
