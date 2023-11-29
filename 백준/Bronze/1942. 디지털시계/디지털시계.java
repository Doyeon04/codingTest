import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int sh, sm, ss, eh, em, es, timeInt;
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            String[] input = br.readLine().split(" ");
            String[] start = input[0].split(":");
            String[] end = input[1].split(":");
            sh = Integer.parseInt(start[0]);
            sm = Integer.parseInt(start[1]);
            ss = Integer.parseInt(start[2]);
            eh = Integer.parseInt(end[0]);
            em = Integer.parseInt(end[1]);
            es = Integer.parseInt(end[2]);
            while (true) {
                timeInt = sh * 10000 + sm * 100 + ss;
                if (timeInt % 3 == 0) cnt++;
                if (sh == eh && sm == em && ss == es) {
                    break;
                }
                ss++;
                if (ss == 60) {
                    ss = 0;
                    sm++;
                }
                if (sm == 60) {
                    sm = 0;
                    sh++;
                }
                if (sh == 24) {
                    sh = 0;
                }
            }
            System.out.println(cnt);
        }
    }
}
