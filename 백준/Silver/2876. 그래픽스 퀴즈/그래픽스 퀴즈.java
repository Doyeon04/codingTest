import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][6]; // i번째 책상까지 j 성적을 연속으로 받은 사람 수
        int maxStudentNum = 0;
        int grade = 0;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int aGrade = Integer.parseInt(st.nextToken());
            int bGrade = Integer.parseInt(st.nextToken());
            // i 번째 책상에서 a, b 둘 중에서 더 연속된 값이 많은 것 찾아야됨

            dp[i][aGrade] = dp[i - 1][aGrade] + 1; // i번째 책상까지의 gradeA 를 연속으로 받은 사람 수
            dp[i][bGrade] = dp[i - 1][bGrade] + 1; // i번째 책상까지의 gradeB를 연속으로 받은 사람 수
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                if (maxStudentNum < dp[i][j]) {
                    maxStudentNum = dp[i][j];
                    grade = j;
                }
            }
        }
        // 교수님이 한 가지 색만을 이용해 채점할 수 있는 최대 학생 수와 그때의 그레이드
        System.out.println(maxStudentNum + " " + grade);
    }

}
