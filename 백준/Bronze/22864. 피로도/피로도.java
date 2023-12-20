import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); // 한시간 일하면 쌓이는 피로도
        int B = Integer.parseInt(st.nextToken()); // 처리할 수 있는 일
        int C = Integer.parseInt(st.nextToken()); // 한시간 쉬었을 때 내려가는 피로도
        int M = Integer.parseInt(st.nextToken()); // 번아웃 한계치

        int work = 0, hour = 0, p = 0;

        while(hour < 24){
            if(p+A <= M){ // 현재 피로도 + 피로도 증가될 양이 최대치 이내일 경우
                work+=B; // 피로도와 처리량 증가
                p += A;
            }else{ // 증가할 피로도가 최대치 넘어가게 되면
                p -= C; // 한시간 쉰만큼 피로도를 내려보냄
                if(p < 0) p = 0; // 피로도 음수면 0으로
            }
            hour++;
        }
        System.out.println(work);
    }
}


