import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Character, ArrayList<Integer>> posMap;
    static int minLen, maxLen;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            makePositionMap(w);
            findLength(k);

            sb.append(minLen == Integer.MAX_VALUE ? -1 : minLen + " " + maxLen).append("\n");
        }
        System.out.println(sb);
    }

    private static void findLength(int k) {
        minLen = Integer.MAX_VALUE;
        maxLen = 0;

        for (ArrayList<Integer> positions : posMap.values()) {
            if(positions.size() < k) {
                continue;
            }

            for(int i=0; i<=positions.size()-k; i++){
                int start = positions.get(i);
                int end = positions.get(i+k-1);
                int len = end-start+1;
                minLen = Math.min(minLen, len);
                maxLen = Math.max(maxLen, len);
            }
        }
    }

    private static void makePositionMap(String word){
        posMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!posMap.containsKey(c)) {
                posMap.put(c, new ArrayList<>());
            }
            posMap.get(c).add(i);
        }
    }


}

/*
5, 8, 14
 */
