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
        int[] fruitLens = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            fruitLens[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(fruitLens);
        for(int i=0; i<n; i++){
            if(fruitLens[i] <= l) l++;
            else break;
        }
        System.out.println(l);
    }
}
