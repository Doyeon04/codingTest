import java.util.*;
class Solution {
    static boolean[] visit; 
    static int count; 
    public int solution(int[] cards) {
        int answer = 0;
        List<Integer> list = new ArrayList<>(); 
        visit = new boolean[cards.length]; 
        for(int card : cards){
            count=0; 
            card = card-1; 
 
            if(!visit[card]){
                visit[card] = true; 
                dfs(card, cards); 
            }
            list.add(count); 
        }
        if(list.size()==1) return 0; 
        Collections.sort(list);
        return list.get(list.size()-1) * list.get(list.size()-2);
    }
    static void dfs(int idx, int[] cards){
        int nextIdx = cards[idx]-1;
        count++; 
        if(!visit[nextIdx]){
            dfs(nextIdx, cards);
            visit[nextIdx]=true; 
        }
    }
}