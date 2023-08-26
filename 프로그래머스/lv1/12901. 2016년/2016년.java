class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int total = 0; 
        for(int i=0; i<a-1; i++){
            total += date[i];
        }
        total += b;
        answer = day[total%7];
        
        return answer;
    }
}

/*
1월 : 31일
2월 : 29일
3월 : 31일
4월 : 30일
5월 : 31일
6월 : 30일
7월 : 31일
8월 : 31일
9월 : 30일
10월 : 31일
11월 : 30일
12월 : 31일
*/