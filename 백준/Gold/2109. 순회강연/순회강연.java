import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture>{
    int price, day;
    public Lecture(int price, int day){
        this.price = price;
        this.day = day;
    }
    @Override
    public int compareTo(Lecture o){
        if(o.price == this.price) return o.day - this.day; 
        return o.price - this.price; // 비용 내림차순
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();
        boolean[] days = new boolean[10001];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(p, d));
        }
        Collections.sort(lectures);
        
        int sum=0;
        for(Lecture lecture : lectures){
            for(int i=lecture.day; i>=1; i--){
                if(!days[i]){
                    sum+=lecture.price;
                    days[i] = true;
                    break;
                }
            }
        }
        System.out.println(sum);

    }
}
