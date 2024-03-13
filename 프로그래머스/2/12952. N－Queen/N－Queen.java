import java.util.*; 
class Solution {
    static int[] col; 
    static int answer; 
    public int solution(int n) {
        col = new int[n];
        dfs(0, n); 
        return answer;
    }
    
    static boolean check(int y){
        for(int i=0; i<y; i++){ // 같은 열이나 같은 대각선에 있는지 확인 
            if(col[y] == col[i] || Math.abs(y-i)==Math.abs(col[y] - col[i])) return false; 
        }
        return true; 
    }
    static void dfs(int y, int n){
        if(y==n){
            answer++;
            return; 
        }
        
        for(int i=0; i<n; i++){
            col[y]=i; // y번째 행의 i번째 열에 퀸 배치
            if(check(y)) dfs(y+1, n); // 놓을 수 있다면 다음 행에 퀸 배치 
        }
    }
}