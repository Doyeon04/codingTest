import java.util.*; 
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int w : weights){
            List<Double> list = new ArrayList<>();
            list.add(w*1.0);
            list.add((w*2.0)/3);
            list.add((w*1.0)/2);
            list.add((w*3.0)/4);
            
            for(double i : list){
                if(map.containsKey(i)){
                    answer+=map.get(i);
                }
            }
            map.put((double)w, map.getOrDefault(w*1.0, 0)+1); 
        }
        return answer;
    }
}