import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        // 모음은 왼쪽으로 세번째, 자음은 왼쪽으로 열번째
        while (true) {
            String str = br.readLine();
            if (str == null) break;
            String ans = "";
            char[] vowel = {'a', 'i', 'y', 'e', 'o', 'u'};
            char[] consonant = {'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'};
            for (char c : str.toCharArray()) {
                if (!Character.isLetter(c)) {
                    ans += c;
                    continue;
                }
                boolean isUpperCase = true;
                if (Character.isLowerCase(c)) isUpperCase = false;
                c = Character.toLowerCase(c);
                int currentIdx = -1;
                char cc = ' ';
                if (c == 'a' || c == 'i' || c == 'y' || c == 'e' || c == 'o' || c == 'u') {
                    for (int i = 0; i < vowel.length; i++) {
                        if (vowel[i] == c) currentIdx = i;
                    }
                    int newIdx = currentIdx - 3;
                    if (newIdx < 0) newIdx += vowel.length;
                    cc = vowel[newIdx];
                } else {
                    for (int i = 0; i < consonant.length; i++) {
                        if (consonant[i] == c) currentIdx = i;
                    }
                    int newIdx = currentIdx - 10;
                    if (newIdx < 0) newIdx += consonant.length;
                    cc = consonant[newIdx];
                }
                if (isUpperCase) ans += Character.toUpperCase(cc);
                else ans += cc;
            }
            System.out.println(ans);
        }

    }

}

