import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static StringBuilder answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine())!=null){
            int n = Integer.parseInt(str);
            int strLen = (int) Math.pow(3, n);
            answer = new StringBuilder();

            for (int i = 0; i < strLen; i++) {
                answer.append("-");
            }
            replaceBlank(0, strLen);
            System.out.println(answer);
        }
      
    }

    private static void replaceBlank(int start, int size) {
        if(size==1) return;
        int newSize = size/3;

        for(int i=start+newSize; i<start+2*newSize; i++){
            answer.setCharAt(i, ' ');
        }

        replaceBlank(start, newSize);
        replaceBlank(start+newSize * 2, newSize);
    }

}
