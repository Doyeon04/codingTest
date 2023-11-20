import java.util.*; 

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>(); 
        
       for(int i=0; i<players.length; i++){
        map.put(players[i], i); 
       }
        
        for(String player : callings){
            int playerRank = map.get(player); 
            String prevPlayerName = players[playerRank-1];
            
            map.put(player, playerRank-1);
            map.put(prevPlayerName, playerRank); 
            players[playerRank] = prevPlayerName;
            players[playerRank-1] = player;
        }
      
        return players;
    }
}