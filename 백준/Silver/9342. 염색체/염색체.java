

import java.io.*;
import java.util.*;

public class Main {

    public static boolean isInfected(String str) {
        if (str.charAt(0) - 'A' > 5 && str.charAt(0) != 'A') // A, B, C, D, E 이외면서 A로 시작 안하면
            return false;

        if(!str.contains("A") || !str.contains("F") || !str.contains("C")) return false;
        
        for (int i = str.indexOf("F"); i < str.length(); i++) {
            char c = str.charAt(i);
            char prev = str.charAt(str.indexOf(c) - 1);
            if (c == 'F') {
                if (prev != 'A') return false;
            } else if (c == 'C') {
                    if (prev != 'F') return false;
            }
        }

        if (str.charAt(str.length() - 1) - 'A' > 5) return false;

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String str = br.readLine();
            sb.append(isInfected(str) ? "Infected!" : "Good").append("\n");
        }
        System.out.println(sb);
    }
}
