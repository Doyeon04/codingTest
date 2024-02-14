import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>(); 
        
        for(int i=0; i<truck_weights.length; i++){
            truck.offer(truck_weights[i]); 
        }
        for(int i=0; i<bridge_length; i++){
            bridge.offer(0); 
        }
        
        int bridgeWeight=0; // 현재 다리의 무게 
        
        while(!bridge.isEmpty()){
            answer++;
            bridgeWeight-=bridge.poll(); // 현재 다리 무게에서 내려온 트럭 무게를 뺌
            if(!truck.isEmpty()){
                if(truck.peek() + bridgeWeight <= weight){ // 트럭을 추가할 수 있는지 
                    int currentTruck = truck.poll(); 
                    bridgeWeight += currentTruck; 
                    bridge.offer(currentTruck); // 다리에 트럭 추가
                }else{ // 트럭을 추가할 수 없으면
                    bridge.offer(0); 
                }
            }
        
        }
        return answer;
    }
}

