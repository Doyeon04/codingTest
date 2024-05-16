import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int idx=1;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()).charAt(0) != '-') {
            Stack<Character> stack = new Stack<>();
            for (char c : str.toCharArray()) {
                if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            int right = 0, left = 0;
            while (!stack.isEmpty()) {
                char c = stack.pop();
                if (c == '}') {
                    right++;
                } else {
                    left++;
                }
            }

            int answer = 0;
            if (right % 2 == 0) {
                answer = right / 2 + left / 2;
            } else {
                answer = (right - 1) / 2 + (left - 1) / 2 + 2;
            }
            sb.append(idx).append(". ").append(answer).append("\n");
            idx++;
        }
        System.out.println(sb);
    }

}

