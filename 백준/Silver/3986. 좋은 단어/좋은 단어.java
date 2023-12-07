import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt=0;
        while(N-->0){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(char c : str.toCharArray()){
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }else stack.push(c);
            }
            if(stack.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}
