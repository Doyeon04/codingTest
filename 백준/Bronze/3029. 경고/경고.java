import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nowArr = br.readLine().split(":");
        String[] nextArr = br.readLine().split(":");

        int nowSecond = Integer.parseInt(nowArr[0]) * 60 * 60 + Integer.parseInt(nowArr[1]) * 60 + Integer.parseInt(nowArr[2]);
        int nextSecond = Integer.parseInt(nextArr[0]) * 60 * 60 + Integer.parseInt(nextArr[1]) * 60 + Integer.parseInt(nextArr[2]);

        int diff=0;
        if(nowSecond < nextSecond){
            diff = nextSecond - nowSecond;
        }else{
            diff = 24 * 60 * 60 - nowSecond + nextSecond;
        }

        String hour = String.valueOf(diff / (60 * 60));
        String min = String.valueOf((diff % (60 * 60)) / 60);
        String sec = String.valueOf(((diff % (60 * 60)) % 60));

        if(Integer.parseInt(hour) < 10) hour = "0" + hour;
        if(Integer.parseInt(min) < 10) min = "0" + min;
        if(Integer.parseInt(sec) < 10) sec = "0" + sec;

        System.out.println(hour +":" + min + ":" + sec);
    }
}