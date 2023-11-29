import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Word implements Comparable<Word> {
    String origin, lower;

    public Word(String origin, String lower) {
        this.origin = origin;
        this.lower = lower;
    }

    @Override
    public int compareTo(Word w) {
        return this.lower.compareTo(w.lower);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            List<Word> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                list.add(new Word(str, str.toLowerCase()));
            }
            Collections.sort(list);
            System.out.println(list.get(0).origin);
        }

    }
}
