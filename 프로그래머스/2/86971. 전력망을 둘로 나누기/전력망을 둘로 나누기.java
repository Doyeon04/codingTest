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
        boolean[][] disconnected = new boolean[n+1][n+1]; 
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i][j] == 1 && !disconnected[i][j]){ // 끊어진적 없는 곳이라면
                    arr[i][j] = arr[j][i] = 0;
                    disconnected[i][j] = disconnected[j][i] = true; 
                    visit = new boolean[n+1]; 
                    answer = Math.min(answer, count(arr, n)); 
                    arr[i][j] = arr[j][i] =  1; // 다시 이어줌
                }
            }
        }
         return answer; 
    
    }
    static int count(int[][] arr, int n){
      
        List<Integer> list = new ArrayList<>(); 
        for(int i=1; i<=n; i++){
            if(!visit[i]) {
                cnt=0; 
                dfs(i, n);
                list.add(cnt); 
            }
        }

        if(list.size()==2){
            return Math.abs(list.get(0) - list.get(1)); 
        }else return Integer.MAX_VALUE; 
    }
    
    static void dfs(int v, int n){
        visit[v] = true; 
        cnt++; 
        for(int i=1; i<=n; i++){
            if(arr[v][i]==1 && !visit[i]){
                dfs(i, n);
            }
        }
    }
}
