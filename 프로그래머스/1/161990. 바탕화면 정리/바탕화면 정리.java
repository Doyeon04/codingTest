class Solution {
    public int[] solution(String[] wallpaper) {
        int minCol = 51, minRow = 51, maxCol = 0, maxRow = 0; 
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j)=='.') continue;
                minRow = Math.min(minRow, i);
                minCol = Math.min(minCol, j);
                maxRow = Math.max(maxRow, i);
                maxCol = Math.max(maxCol, j); 
            }
        }
        
        return new int[]{minRow, minCol, maxRow+1, maxCol+1};
    }
}