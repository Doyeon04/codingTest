class Solution {
    public String solution(String number, int k) {
       StringBuilder answer = new StringBuilder(); 
        int index=0; 
        for(int i=0; i<number.length()-k; i++){ // 만들어져야 하는 결과의 자릿수만큼 반복
            int max=0; 
            for(int j=index; j<=k+i; j++){ 
                if(max < number.charAt(j) -'0'){
                    max = number.charAt(j)-'0';
                    index = j+1; // 가장 큰 수의 다음 인덱스부터 탐색 시작 
                }
            }
            answer.append(max); 
        }
        return answer.toString();
    }
}