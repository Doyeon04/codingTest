import java.util.*; 

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
    
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, 0}); 
        
        boolean[] visit = new boolean[y+1];
        
        while(!q.isEmpty()){
            int[] poll = q.poll();
            int now = poll[0];
            int cnt = poll[1];
            
            if(now==y){  
                return cnt; 
            }
            
            if(now + n <= y && !visit[now+n]) {
                q.offer(new int[]{now + n, cnt+1});
                visit[now+n] = true;
            }
            if(now * 2 <= y && !visit[now*2]) {
                q.offer(new int[]{now * 2, cnt+1});
                visit[now * 2 ] = true; 
            }
            if(now * 3 <= y && !visit[now*3]) {
                q.offer(new int[]{now * 3, cnt+1});
                visit[now * 3] = true; 
            }
        }
        
        return -1;
    }
}