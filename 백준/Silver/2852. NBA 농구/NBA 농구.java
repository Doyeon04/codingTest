import java.io.*;
import java.util.*;

class Record {
    int team;
    int time;

    public Record(int team, int time) {
        this.team = team;
        this.time = time;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        int n = Integer.parseInt(br.readLine());
        int win_team;
        int min_time;
        List<Record> records = new ArrayList<>();
        int[] ans_score = {0, 0};
        int[] ans_time = {0, 0};

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            win_team = Integer.parseInt(st.nextToken());
            String[] time = st.nextToken().split(":");
            min_time = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            records.add(new Record(win_team, min_time));
        }
        ans_score[records.get(0).team - 1]++;
        min_time = records.get(0).time;

        for (int i = 1; i < n; i++) {
            int tmp_team = records.get(i).team;
            int tmp_time = records.get(i).time;

            if (ans_score[0] > ans_score[1]) ans_time[0] += tmp_time - min_time;
            if (ans_score[1] > ans_score[0]) ans_time[1] += tmp_time - min_time;
            
            min_time = tmp_time;
            ans_score[tmp_team - 1]++;
        }
        if (ans_score[0] > ans_score[1]) ans_time[0] += (48 * 60 - min_time);
        if (ans_score[0] < ans_score[1]) ans_time[1] += (48 * 60 - min_time);

        for (int i = 0; i < 2; i++) {
            int min = ans_time[i] / 60;
            int sec = ans_time[i] % 60;
            StringBuilder sb = new StringBuilder();
            if (min < 10) sb.append("0").append(min);
            else sb.append(min);
            sb.append(":");
            if (sec < 10) sb.append("0").append(sec);
            else sb.append(sec);
            System.out.println(sb);
        }

    }
}

