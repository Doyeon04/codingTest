import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA=arrayA[0]; 
        int gcdB=arrayB[0];
        for(int i=1; i<arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]); 
            gcdB = gcd(gcdB, arrayB[i]); 
        }

        if(gcdA!=1 && notDevided(arrayB, gcdA)){ 
            answer = Math.max(answer, gcdA); 
        }
        if(gcdB!=1 && notDevided(arrayA, gcdB)){ 
            answer = Math.max(answer, gcdB); 
        }
      
        return answer;
    }
    private boolean notDevided(int[] array, int gcd){
        for(int x : array){
            if(x % gcd == 0){
                return false; 
            }
        }
        return true; 
    }
    
    private int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a % b); 
    }
}
