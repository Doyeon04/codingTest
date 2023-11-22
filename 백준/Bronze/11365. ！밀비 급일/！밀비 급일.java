import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while(!(str = br.readLine()).equals("END")){
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String answer = sb.reverse().toString();
            System.out.println(answer);
        }
    }
}