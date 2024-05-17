import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(calculate(str));
    }

    static int calculate(String str) {
        Stack<Object> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else { // 닫는 괄호일 때
                int value = 0;
                while (!stack.isEmpty() && stack.peek() instanceof Integer) {
                    value += (Integer) stack.pop();
                }
                if (stack.isEmpty() || (c == ')' && (char) stack.peek() == '[') || c == ']' && (char) stack.peek() == '(') {
                    return 0;
                }
                stack.pop(); // 여는 괄호 제거

                if (c == ')') {
                    stack.push(value == 0 ? 2 : 2 * value);
                } else {
                    stack.push(value == 0 ? 3 : 3 * value);
                }
            }

        }
        int answer = 0;
        while (!stack.isEmpty()) {
            if(stack.peek() instanceof Character) return 0;
            answer+= (Integer) stack.pop();
        }
        return answer;
    }
}


