import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int index;
        int move = length-1;
        
        for(int i=0; i<length; i++){
            answer+=Math.min(name.charAt(i)-'A', 'Z' - name.charAt(i) + 1); // 상하 중에 더 최소 이동 횟수
            
            index = i+1; 
            while(index < length && name.charAt(index) == 'A'){
                index++;    
            }
            move = Math.min(move, i*2+length-index); // 순서대로 가는 것, 뒤로 돌아가는 것 중 최소 이동 횟수
            move = Math.min(move, (length-index) * 2 + i); // 마지막 문자 위치로 이동시켜 (length-index) 만큼 바꾸고 다시 
            // 처음으로 돌아와 차례로 바꾸는 것
        }
        
        answer+=move; 
        return answer;
    }
}

// a b c d .... z 
// BBBAAAAAAB
// b의 인덱스는 9 