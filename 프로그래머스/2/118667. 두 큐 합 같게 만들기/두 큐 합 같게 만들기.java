import java.util.*; 
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0; 
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1=0, sum2=0; 
        for(int i=0; i<queue1.length; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]); 
            sum1+=queue1[i];
            sum2+=queue2[i]; 
        }
        if((sum1+sum2) % 2 !=0) return -1; 
        while(sum1!=sum2){ // sum이 더 큰거에서 작은거로 
            if(q1.isEmpty() || q2.isEmpty()) return -1; 
           if(answer>queue1.length*2+1) return -1; 
            if(sum1>sum2){
                int out = q1.poll(); 
                q2.offer(out);
                sum1-=out;
                sum2+=out; 
            }else{
                int out = q2.poll(); 
                q1.offer(out);
                sum1+=out;
                sum2-=out; 
            }
            answer++; 
         
        }
        return answer;
    }
}
/*
구하고자 하는 각 큐의 합 = 두 큐의 원소합/2
15로 맞춰야 함 
queue1: 14
queue2: 16
큰거에서 작은거로 poll해서 push하면 
1: 3, 2, 7, 2, 4 = 18 
2: 6, 5, 1 = 12
또 큰거에서 작은거로
1: 2, 7, 2, 4 = 15 
2: 6, 5, 1, 3 = 15
...
한쪽이라도 큐가 비게되면 -1 
두큐의 원소합/2 소수점 나오면 -1
*/