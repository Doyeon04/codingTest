import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        String name = br.readLine();
        boolean available = true;
        int oddCheck = 0;
        char mid = ' ';
        int[] alphabet = new int[26];
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < name.length(); i++) {
            alphabet[name.charAt(i) - 'A']++;
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] % 2 == 1) { // 개수가 홀수인 알파벳이 1개뿐이면 팰린드롬 만들 수 있음
                if (oddCheck == 0) {
                    oddCheck++;
                    mid = (char) ('A' + i);
                } else { // 알파벳 개수가 홀수인게 2개면 팰린드롬 못만듬
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
            for (int j = 0; j < alphabet[i] / 2; j++) { // 앞 뒤에 각각 개수/2 만큼 붙임
                front.append((char) ('A' + i));
                back.insert(0, (char) ('A' + i));
            }
        }


        if (mid == ' ') result.append(front).append(back);
        else result.append(front).append(mid).append(back);
        System.out.println(result);
    }
}

