import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            Stack<Character> stack = new Stack<>();
            for (char c : str.toCharArray()) {
                if (c == '(' || c == '[') stack.push(c);
                if (!stack.isEmpty()) {
                    if (c == ')' && stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }
                    if (c == ']' && stack.peek() == '[') {
                        stack.pop();
                        continue;
                    }
                }
                if(c==')' || c==']') stack.push(c);

            }
            if (stack.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.println(sb);
    }
}
