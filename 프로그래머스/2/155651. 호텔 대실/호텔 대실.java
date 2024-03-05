class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] fullTime = new int[24*60+10]; // 분 단위

        for(String[] time : book_time){
            fullTime[toMinute(time[0])]+=1; // 입실 시간 
            fullTime[toMinute(time[1])+10]-=1; // 퇴실 + 청소 시간 
        }
        
        for(int i=1; i<fullTime.length; i++){
            fullTime[i] += fullTime[i-1]; 
            answer = Math.max(answer, fullTime[i]); 
        }
   
        return answer;
    }
    private int toMinute(String str){
        String[] s = str.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]); 
    }
}
