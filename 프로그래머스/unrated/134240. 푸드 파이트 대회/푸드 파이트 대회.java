class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i=1; i<food.length; i++){ 
            int half = food[i]/2; 
              while(half-->0){
                    answer+=String.valueOf(i); 
                }
        }
        StringBuilder sb = new StringBuilder(answer);
        answer+=sb.append("0").reverse().toString();
   
        return answer;
    }
}
