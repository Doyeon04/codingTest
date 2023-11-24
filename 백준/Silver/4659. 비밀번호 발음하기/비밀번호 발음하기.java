

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) break;
            boolean acceptable = false;

            int vowelCnt = 0, consonantCnt = 0;

            char tmp = ' ';
            for (char c : str.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    acceptable = true;
                    consonantCnt=0;
                    vowelCnt++;

                } else {
                    vowelCnt=0;
                    consonantCnt++;
                }
                if(vowelCnt==3 || consonantCnt==3){
                    acceptable = false;
                    break;
                }

                if(c == tmp){
                    if(c!= 'e' && c !='o')  {
                        acceptable = false;
                        break;
                    }
                }
                tmp = c;
            }
            if(acceptable) System.out.println("<"+str+"> "+"is acceptable.");
            else System.out.println("<"+str+"> "+"is not acceptable.");
        }
    }
}