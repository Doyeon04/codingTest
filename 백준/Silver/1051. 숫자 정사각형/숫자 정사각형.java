import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for(int i=0; i<n; i++){
            String str= br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        int maxLen = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=j; k<m; k++){
                    if(arr[i][j] == arr[i][k]){
                        int gap = k-j;
                        if(i+gap >= n) continue;
                        if(arr[i][j] == arr[i+gap][j] && arr[i][k] == arr[i+gap][k]){
                            maxLen = Math.max(maxLen, gap+1);
                        }
                    }
                }
            }
        }
        System.out.println(maxLen * maxLen);

    }
}
