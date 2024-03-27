import java.util.*; 
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine); 
        int[] arr = new int[10000001];
        for(int i=0; i<tangerine.length; i++){
            arr[tangerine[i]]++;
        }
        Arrays.sort(arr);
        
        for(int i=arr.length-1; i>=0; i--){
            answer++;
            k-=arr[i];
            if(k<=0) break; 
        }
        
        return answer;
    }
}

/*
arr[1] = 1
arr[2] = 2
arr[3] = 2
arr[4] = 1
arr[5] = 2 
{1, 2, 2, 1, 2} => {1, 1, 2, 2, 2}
*/