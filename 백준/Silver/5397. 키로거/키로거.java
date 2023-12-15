import java.io.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String str = br.readLine();
            LinkedList<Character> lnklist = new LinkedList<>();
            ListIterator<Character> list = lnklist.listIterator();
            int idx = 0;
            for (int i = 0; i < str.length(); i++) {
                //System.out.println("idx = " + idx);
                char c = str.charAt(i);
                if (c == '<') {
                    if(list.hasPrevious()) list.previous();
                } else if (c == '>') {
                    if(list.hasNext()) list.next();
                } else if (c == '-' ) {
                    if(list.hasPrevious()){
                        list.previous();
                        list.remove();;
                    }
                } else { // 알파벳이면
                   list.add(c);
                }
            }
            for (char c : lnklist) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}


