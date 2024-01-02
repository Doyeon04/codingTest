import java.io.*;
import java.util.*;

public class Main {
    static int[] TCnts = new int[26];
    static int[] bookCnts = new int[26];
    static String[] books;
    static int n, ans;
    static Map<Integer, Integer> priceMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        n = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;

        for (char c : t.toCharArray()) {
            TCnts[c - 'A']++;
        }
        books = new String[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            priceMap.put(i, price);
            books[i] = st.nextToken();
        }
        dfs(0, 0);
        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static void dfs(int cnt, int sum) { // 시간 복잡도 O(2^N) - n개의 전공책에 대해 선택 or 선택X 두가지 경우의 수
        if (cnt == n) {
            boolean flag = true;
            for (int i = 0; i < 26; i++) {
                if (TCnts[i] > bookCnts[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans = Math.min(ans, sum);

            return;
        }

        for (int i = 0; i < books[cnt].length(); i++) { // cnt 번째 책 선택 하는 경우
            bookCnts[books[cnt].charAt(i) - 'A']++;
        }
        dfs(cnt + 1, sum + priceMap.get(cnt));

        for (int i = 0; i < books[cnt].length(); i++) { // cnt 번째 책 선택 안하는 경우를 위해 다시 선택 안한것으로 수정
            bookCnts[books[cnt].charAt(i) - 'A']--;
        }
        dfs(cnt + 1, sum);
    }
}
