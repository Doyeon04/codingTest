import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][9];
        

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 8; j++) {
                if (i == n) { // 마지막 문어라면
                    if(arr[i][j]==0 && arr[1][j]==0){  // 나와 그다음 문어의 사용하지 않은 손이라면
                       arr[i][j]=1; // 내 손 사용
                       arr[1][j]=1;  // 그 다음 문어도 같은 손 사용
                        System.out.println(j);
                        break;
                    }
                } else {
                    if(arr[i][j]==0 && arr[i+1][j] == 0){
                        arr[i][j] = 1;
                        arr[i+1][j] = 1;
                        System.out.println(j);
                        break;
                    }
                }
            }
        }
        
        /*
        1 - 2 : 1 (1번손)
        2 - 3 : 2 (2번손)
        3 - 4 : 3 (1번손)
        4 - 5 : 4 (2번손)
        5 - 1 : 5 (3번손?)
         */


    }
}

