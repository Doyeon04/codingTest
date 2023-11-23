import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String K = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            if(!Character.isDigit(c)) sb.append(c);
        }
        if(sb.toString().contains(K)) System.out.println(1);
        else System.out.println(0);
    }
}