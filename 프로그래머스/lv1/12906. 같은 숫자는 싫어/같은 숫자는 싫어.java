import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> list = new ArrayList<>(); 
        Stack<Integer> st = new Stack<>();
        
        for(int n : arr){
            if(st.isEmpty()) {
                st.push(n); 
                list.add(n); 
            }
            else if(st.peek()!=n) {
                st.push(n);
                list.add(n); 
            }  
        }
        
      

        return list.stream().mapToInt(x->x).toArray();
    }
}