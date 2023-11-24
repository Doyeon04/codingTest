import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for(int i=0; i<N; i++){
            str[i] = br.readLine();
        }
        Arrays.sort(str, (o1, o2) -> {
            if(o1.length() == o2.length()) return o1.compareTo(o2);
            else return o1.length() - o2.length();
        });

        System.out.println(str[0]);
        for(int i=1; i<str.length; i++){
            if(!str[i].equals(str[i-1])) System.out.println(str[i]);
        }
    }
}