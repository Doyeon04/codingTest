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
            int cnt=0;
            for (char c : str.toCharArray()) {
                if(c=='{') stack.push(c);
                else{
                    if(stack.isEmpty()){
                        stack.push('{');
                        cnt++;
                    }else stack.pop();
                }
            }
            if(!stack.isEmpty()){
                cnt+=stack.size()/2;
            }
            sb.append(idx).append(". ").append(cnt).append("\n");
            idx++;
        }
        System.out.println(sb);
    }

}

