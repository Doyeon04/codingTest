import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C];

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int T = Integer.parseInt(br.readLine());

        int answer=0;
        for(int i=0; i<R-2; i++){
            for(int j=0; j<C-2; j++){
                List<Integer> tmpList = new ArrayList<>();
                for(int k=0; k<3; k++){
                    for(int l=0; l<3; l++){
                        tmpList.add(arr[i+k][j+l]);
                    }
                }
                Collections.sort(tmpList);
                if(tmpList.get(4) >= T) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}



