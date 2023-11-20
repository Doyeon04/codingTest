class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        char[][] arr = new char[wallpaper.length][wallpaper[0].length()];
        
        int minCol = 50, minRow = 50, maxCol = 0, maxRow = 0; 
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                arr[i][j] = wallpaper[i].charAt(j);
                if(arr[i][j]=='.') continue; 
                minCol = Math.min(minCol, i);
                minRow = Math.min(minRow, j);
                maxCol = Math.max(maxCol, i);
                maxRow = Math.max(maxRow, j); 
            }
        }
 
        answer[0] = minCol;
        answer[1] = minRow;
        answer[2] = maxCol+1;
        answer[3] = maxRow+1; 
        return answer;
    }
}


