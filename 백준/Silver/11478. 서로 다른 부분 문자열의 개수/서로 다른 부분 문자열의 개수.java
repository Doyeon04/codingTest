import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        String S = br.readLine();

        Set<String> set = new HashSet<>();
        for(int i=0; i<S.length(); i++){
            String part = ""; 
            for(int j=i; j<S.length(); j++){
                part = S.substring(i, j+1);
                set.add(part);
            }
        }
        System.out.println(set.size());
    }
}

