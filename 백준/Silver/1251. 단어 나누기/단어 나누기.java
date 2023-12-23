import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        List<String> list = new ArrayList<>();
        for(int i=1; i<word.length(); i++){
            for(int j=i+1; j<word.length(); j++){
                String a = word.substring(0, i);
                String b = word.substring(i, j);
                String c = word.substring(j);
                String s = new StringBuilder(a).reverse()
                        .append(new StringBuilder(b).reverse())
                        .append(new StringBuilder(c).reverse()).toString();
                list.add(s);
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));
    }
}


