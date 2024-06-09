import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String word1 = br.readLine();
        int answer=0;
        for(int i=0; i<n-1; i++){
            String word2 = br.readLine();
            if(isSimilar(word1, word2)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isSimilar(String word1, String word2) {
        Map<Character, Integer> map1 = makeMap(word1);
        Map<Character, Integer> map2 = makeMap(word2);

        int diff=0;
        for(char ch = 'A'; ch<='Z'; ch++){
            int alphaCnt1 = map1.get(ch);
            int alphaCnt2 = map2.get(ch);
            diff+=Math.abs(alphaCnt1-alphaCnt2);
        }
        return diff <= 2 && Math.abs(word1.length()- word2.length()) <= 1;
    }

    private static Map<Character, Integer> makeMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch = 'A'; ch<='Z'; ch++){
            map.put(ch, 0);
        }
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}
