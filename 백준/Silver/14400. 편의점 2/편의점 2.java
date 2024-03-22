import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] x = new int[n];
        int[] y = new int[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(x);
        Arrays.sort(y);

        int midX = x[n/2];
        int midY = y[n/2];

        long distance=0;
        for(int i=0; i<n; i++){
            distance += Math.abs(midX - x[i]) + Math.abs(midY - y[i]);
        }
        System.out.println(distance);
    }
}

