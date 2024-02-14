import java.util.*; 

class Solution {
    static boolean[] visit; 
    static int[] arr; 
    static Set<Integer> set = new HashSet<>(); 
    public int solution(String numbers) {
        int len = numbers.length(); 
        visit = new boolean[len];
       
        for(int i=1; i<=len; i++){
            arr = new int[i];
            dfs(0, i, arr, numbers); 
        }
        return set.size();
    }
    static void dfs(int cnt, int len, int[] arr, String numbers){
        if(cnt==len){
            addPrime(arr);
            return;
        }
        for(int i=0; i<numbers.length(); i++){
            if(visit[i]) continue;
            visit[i] = true;
            arr[cnt] = numbers.charAt(i)-'0'; 
            dfs(cnt+1, len, arr, numbers);
            visit[i] = false; 
            
        }
    }
    static void addPrime(int[] arr){
        String s = "";
        for(int i=0; i<arr.length; i++){
            s += arr[i]; 
        }
        int n = Integer.parseInt(s); 
        if(n==1 || n==0) return;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0) return;
        }
        set.add(n); 
    }
}