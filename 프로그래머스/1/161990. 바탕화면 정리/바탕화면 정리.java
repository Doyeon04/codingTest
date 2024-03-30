class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow=50, minCol=50, maxRow=0, maxCol=0; 
        
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