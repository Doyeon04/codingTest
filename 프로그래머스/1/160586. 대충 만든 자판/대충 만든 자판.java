class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length]; 
        
        int idx = 101; 
        
        for(int i=0; i<targets.length; i++){
            int result = 0; 
            for(int j=0; j<targets[i].length(); j++){
                char alpha = targets[i].charAt(j); 
                int press = 101;
                for(String map : keymap){
                    idx = map.indexOf(alpha); 
                    if(idx != -1) press = Math.min(press, idx+1);
           
                }
                if(press==101) {
                    result = -1; 
                    break;
                }
                else result += press;
            }
            answer[i] = result; 
        }
        
        return answer;
    }
}