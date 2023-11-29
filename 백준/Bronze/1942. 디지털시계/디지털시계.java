import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final int MAX_SECOND = 60;
    private static final int MAX_MINUTE = 60;
    private static final int MAX_HOUR = 24;

    public static class Time {
        int hour, minute, second;

        public Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
    }

    private static void getTime(String input, Time startTime, Time endTime) {
        String[] split = input.split(" ");

        startTime.hour = Integer.parseInt(split[0].split(":")[0]);
        startTime.minute = Integer.parseInt(split[0].split(":")[1]);
        startTime.second = Integer.parseInt(split[0].split(":")[2]);

        endTime.hour = Integer.parseInt(split[1].split(":")[0]);
        endTime.minute = Integer.parseInt(split[1].split(":")[1]);
        endTime.second = Integer.parseInt(split[1].split(":")[2]);
    }

    private static int convertTimeToInt(Time time) {
        return time.hour * 10000 + time.minute * 100 + time.second;
    }

    private static void incrementTime(Time time) {
        time.second++;

        if (time.second == MAX_SECOND) {
            time.second = 0;
            time.minute++;
        }

        if (time.minute == MAX_MINUTE) {
            time.minute = 0;
            time.hour++;
        }

        if (time.hour == MAX_HOUR) {
            time.hour = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String input = br.readLine();
            Time startTime = new Time(0, 0, 0);
            Time endTime = new Time(0, 0, 0);
            getTime(input, startTime, endTime);

            int result = 0;

            while (true) {
                int start = convertTimeToInt(startTime);
                if (start % 3 == 0) {
                    result++;
                }
                if (startTime.hour == endTime.hour
                        && startTime.minute == endTime.minute
                        && startTime.second == endTime.second) break;

                incrementTime(startTime);
            }
            System.out.println(result);
        }
    }
}