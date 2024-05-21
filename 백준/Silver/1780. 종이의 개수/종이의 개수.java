import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] arr;
    static int n;
    static int cntMinusOne,cntOne, cntZero;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st ;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count(0, 0, n);
        System.out.println(cntMinusOne);
        System.out.println(cntZero);
        System.out.println(cntOne);
    }
    static void count(int x, int y, int size){
        if(isSame(x, y, size)){
            if(arr[x][y]== -1) cntMinusOne++;
            else if(arr[x][y]==0) cntZero++;
            else cntOne++;
            return;
        }

        int newSize = size/3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                count(x+ newSize * i, y+newSize * j, newSize);
            }
        }
    }
    static boolean isSame(int x, int y, int size){
        int num = arr[x][y];
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(num!=arr[i][j]) return false;
            }
        }
        return true;
    }
}