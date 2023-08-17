class Solution {
    static int[] arr = new int[3]; 
    static int answer=0; 
    public int solution(int[] number) {
       
        dfs(0, 0, number); 
        return answer;
    }
    public static void dfs(int cnt, int s, int[] number){
        if(cnt == 3){
            int sum = 0; 
            for(int n : arr){
                sum+=n;
            }
            if(sum == 0) answer++; 
            return;
        }
        for(int i=s; i<number.length; i++){
            arr[cnt] = number[i]; 
            dfs(cnt+1, i+1, number); 
        }
    }
}