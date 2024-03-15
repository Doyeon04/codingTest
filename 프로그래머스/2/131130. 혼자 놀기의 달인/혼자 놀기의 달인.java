import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visit = new boolean[cards.length];
        List<Integer> list = new ArrayList<>(); 
        for(int card : cards){
            int count=0; 
            card = card-1; 
            while(!visit[card]){
                visit[card] = true;
                count++; 
                card = cards[card]-1; 
            }
            list.add(count); 

        }
        if(list.size()==1) return 0; 
        Collections.sort(list);
        return list.get(list.size()-1) * list.get(list.size()-2);
    }
}