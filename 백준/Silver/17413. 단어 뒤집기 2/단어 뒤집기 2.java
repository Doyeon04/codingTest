

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean isWord = true;
        String ans = "";
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '<' || c == ' ') { // 공백을 만나거나 태그 시작이면 그 전에 있던 단어를 거꾸로 출력
                if (isWord) {
                    while (!stack.isEmpty()) {
                        ans += stack.pop();
                    }
                    if (c == ' ') ans += ' ';
                }

            }
            if (c == '<') isWord = false; // 태그 시작, 단어 아님
            if (!isWord) { // 단어가 아니면 그대로 출력
                ans += c;
            }
            if (isWord && c != ' ') { // 단어이고 공백 아니면
                stack.push(c);
            }
            if (c == '>') isWord = true;

        }

        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
        }
        System.out.println(ans);
    }
}
