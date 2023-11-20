class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        int y = park.length;
        int x = park[0].length(); 
        
        char[][] map = new char[y][x]; 
        int cx = 0, cy = 0;
        
        for(int i=0; i<y; i++){
            for(int j=0; j<x; j++){
                map[i][j] = park[i].charAt(j); 
                if(map[i][j] == 'S'){
                    cy = i;
                    cx = j; 
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            String op = routes[i].split(" ")[0];
            int n = Integer.parseInt(routes[i].split(" ")[1]); 
            
            int originX = cx; 
            int originY = cy;  
            
            while(n-->0){
                if(op.equals("E")) cx++;
                if(op.equals("W")) cx--;
                if(op.equals("S")) cy++;
                if(op.equals("N")) cy--;  
                
                if(cy < 0 || cx < 0 || cy >= y || cx >= x || map[cy][cx]=='X'){
                    cy = originY;
                    cx = originX; 
                    break;
                }
            }
        }

        return new int[]{cy, cx};
    }
}