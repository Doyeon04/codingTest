import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cnt = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        String S = br.readLine();
        int sum=0;
        for (int i = 0; i < S.length(); i++) {
            sum+=cnt[S.charAt(i) - 'A'];
        }
        if(sum % 2 ==1)
            System.out.println("I'm a winner!");
        else
            System.out.println("You're the winner?");
    }
}