class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] x = new int[10];
        int[] y = new int[10];
        
        StringBuilder sb = new StringBuilder(); 
        for(char c : X.toCharArray()){
            x[c-'0']++;
        }
        for(char c : Y.toCharArray()){
            y[c-'0']++;
        }
        
        for(int i=9; i>=0; i--){
            if(x[i] > 0 && y[i] > 0) {
                int cnt = Math.min(x[i], y[i]);
                //System.out.println(i+","+cnt); 
                
                for(int j=0; j<cnt; j++){
                    sb.append(i);  
                }
            }
        }
        answer = sb.toString();
        
        if(answer.equals("")) return "-1";

        //if(Integer.parseInt(answer)==0) answer = "0"; 
        else if(answer.replace("0","") == "") answer = "0";

        return answer; 
    }
}