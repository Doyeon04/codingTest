import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        S = S.replaceAll("pi", " ");
        S = S.replaceAll("ka", " ");
        S = S.replaceAll("chu", " ");
        S = S.replaceAll(" ", "");

        if(S.equals("")) System.out.println("YES");
        else System.out.println("NO");

    }
}
