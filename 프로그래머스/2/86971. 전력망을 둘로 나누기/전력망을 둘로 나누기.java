import java.util.*; 
class Solution {
    static int[][] arr; 
    static boolean[] visit; // 노드 방문 체크 
    static int cnt=0; 
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        arr = new int[n+1][n+1];
        visit = new boolean[n+1]; 

        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            arr[a][b] = arr[b][a] = 1; 
        }

        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            arr[a][b] = arr[b][a] = 0; // 선 끊기
            
            cnt=0;
            visit = new boolean[n+1];
            dfs(arr, a, n);
            answer = Math.min(answer, Math.abs(cnt - (n-cnt))); 

            arr[a][b] = arr[b][a] =  1; // 다시 이어줌
        }
        return answer; 

    }
    static void dfs(int[][] arr, int v, int n){
        visit[v] = true; 
        cnt++; 
        for(int i=1; i<=n; i++){
            if(arr[v][i]==1 && !visit[i]){
                dfs(arr, i, n);
            }
        }
    }
}