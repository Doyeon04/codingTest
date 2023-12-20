import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int leftCnt=0, rightCnt=0, leftBefore = 0, rightBefore = 0;
        for(int i=0; i<N; i++){
            if(arr[i] > leftBefore) {
                leftCnt++;
                leftBefore = arr[i];
            }

            if(arr[N-i-1] > rightBefore){
                rightCnt++;
                rightBefore = arr[N-i-1];
            }
        }

        System.out.println(leftCnt);
        System.out.println(rightCnt);

    }
}


