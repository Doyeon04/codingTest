import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cnt = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        String S = br.readLine();

        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            numStr.append(cnt[S.charAt(i) - 'A']);
        }

        while (numStr.length() != 1) {
            StringBuilder newStr = new StringBuilder();
            for (int i = 0; i < numStr.length(); i += 2) {
                if (i == numStr.length() - 1) {
                    newStr.append(numStr.charAt(i));
                } else {
                    int sum = (numStr.charAt(i) - '0') + (numStr.charAt(i + 1) - '0');
                    if (sum >= 10) sum %= 10;
                    newStr.append(sum);
                }
            }
            numStr = new StringBuilder(newStr.toString());
        }

        if (Integer.parseInt(numStr.toString()) % 2 == 0) System.out.println("You're the winner?");
        else System.out.println("I'm a winner!");

    }
}