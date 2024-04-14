import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
       
        for(String s : skill_trees){
            boolean flag = true; 
        
            int p1 = 0; 
            for(int p2=0; p2<s.length(); p2++){
                char c = s.charAt(p2); 
                if(skill.indexOf(c)==-1) continue; // 없는 문자면
                else if(c!=skill.charAt(p1)){ // 있는 문잔데 같지 않으면
                    flag=false;
                    break;
                }
                else p1++; // 있는 문잔데 같으면 

            }
             if(flag) answer++; 
        
        }
     return answer;

    }
}
