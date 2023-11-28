import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String key = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') sb.append(" ");
            else{
                int changed = str.charAt(i) - key.charAt(i % key.length());
                if (changed <= 0) changed += 26;
                sb.append((char)(changed + 'a' - 1));
            }
        }
        System.out.println(sb);
    }
}
