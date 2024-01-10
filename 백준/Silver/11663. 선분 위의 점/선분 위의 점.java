import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(binarySearch(start, end)).append("\n");
        }
        System.out.println(sb);
    }

    static int binarySearch(int x, int y){

        int start = 0;
        int end = arr.length-1;

        // 선분의 y좌표보다 작은 점들의 개수
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] > y) end = mid - 1;
            else start = mid + 1;
        }
        int endIndex = start;

        start = 0;
        end = arr.length - 1;

        // 선분의 x좌표보다 작은 점들의 개수
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid] >= x) end = mid - 1;
            else start = mid + 1;
        }
        int startIndex = start;

        return endIndex - startIndex;
    }
}