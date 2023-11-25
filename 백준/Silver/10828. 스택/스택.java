import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int[] stack = new int[10000];
    public static int size = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());


        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch(str){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }

        System.out.println(sb);

    }
    public static void push(int item){ // 정수 X를 스택에 넣는다.
        stack[size] = item;
        size++;
    }
    public static int pop(){ // 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if(size==0) return -1;
        else{
            int p = stack[size-1]; // 인덱스는 0부터 시작하므로 가장 위에 있는 요소의 인덱스는 size-1
            size--;
            return p;
        }
    }

    public static int size(){ // 스택에 들어있는 정수의 개수를 출력한다.
        return size;
    }

    public static int empty(){ // 스택이 비어있으면 1, 아니면 0을 출력한다.
        if(size==0) return 1;
        else return 0;
    }

    public static int top(){ // 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        if(size==0) return -1;
        else{
            int t = stack[size-1];
            return t;
        }
    }
}