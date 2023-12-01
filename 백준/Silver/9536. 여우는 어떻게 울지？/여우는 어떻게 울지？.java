import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] sounds = br.readLine().split(" ");
            Set<String> set = new HashSet<>();
            while (true) {
                String str = br.readLine();
                if (str.equals("what does the fox say?")) break;
                String animalSound = str.split(" ")[2];
                set.add(animalSound);
            }
            for (String s : sounds) {
                if(!set.contains(s)) sb.append(s).append(" "); 
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

