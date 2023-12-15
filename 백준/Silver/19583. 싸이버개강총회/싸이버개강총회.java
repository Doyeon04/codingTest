import java.io.*;

import java.util.*;

public class Main {
    public static int toMin(String time){
        return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        String S = str[0];
        String E = str[1];
        String Q = str[2];

        Map<String, String> map = new HashMap<>();
        while(true){
            String s= br.readLine();
            if(s==null) break;
            String time = s.split(" ")[0];
            String name = s.split(" ")[1];

            if(!map.containsKey(name)){
                if(toMin(time) <= toMin(S)) map.put(name, "in");
            }else{ // 입장한 회원이라면 퇴장 체크
                if(toMin(time) >= toMin(E) && toMin(time) <= toMin(Q)) map.put(name, "out");
            }
        }
        int ans=0;
        for(String val : map.values()){
            if(val.equals("out")) ans++;
        }
        System.out.println(ans);
    }
}


