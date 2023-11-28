import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String ans = "";
        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c)) ans+=String.valueOf(c).toLowerCase();
            else ans+=String.valueOf(c).toUpperCase();
        }
        System.out.println(ans);
    }
}
