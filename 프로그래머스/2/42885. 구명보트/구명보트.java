import java.util.*; 

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); 
        int p1 = 0;
        int p2 = people.length-1;
        
        while(p1<=p2){
            if(people[p1] + people[p2] <= limit){
                p1++;
            }
            answer++;
            p2--; 
        }
        
        return answer;
    }
}
/*
50, 50, 70, 80, 90

*/