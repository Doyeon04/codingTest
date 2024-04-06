import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String word = br.readLine();

        int count=0;
        while(true){
            if(text.contains(word)){ // 포함되어 있다면 포함할 때 첫 인덱스 찾기
                int startIdx = text.indexOf(word);
                count++;

                int endIdx = startIdx + word.length();
                text = text.substring(endIdx);
            }else break;
        }
        System.out.println(count);
    }
}



