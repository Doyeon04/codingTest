import java.util.*;
class Task implements Comparable<Task>{
    String name;
    int start;
    int time; 
    public Task(String name, int start, int time){
        this.name = name; 
        this.start = start;
        this.time = time; 
    }
    @Override
    public int compareTo(Task t){
        return this.start - t.start; 
    }
}
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Task> q = new PriorityQueue<>(); 
        
        for(String plan[] : plans){
            q.add(new Task(plan[0], changeToMin(plan[1]), Integer.parseInt(plan[2])));
        }
   
        Task t = q.poll();
        int now = t.start; 
        
        Stack<Task> stack = new Stack<>();
        int idx=0; 
        while(true){
            if(!q.isEmpty() && (now + t.time) > q.peek().start){ // 다음 과목이 현재 과목이 종료되기 전에 시작한다면
                stack.push(new Task(t.name, t.start, t.time - (q.peek().start-now))); // 현재 과제 멈추기
                now = q.peek().start;
                t = q.poll(); 
            }else{ // 과제 끝남
                answer[idx++] = t.name; 
                now += t.time; 
                
                if(!q.isEmpty() && now == q.peek().start){ // 현재 시간에 시작할 수 있는 새로운 과제가 있으면 시작
                    t = q.poll();
                }else if(!stack.isEmpty()){ // 잠시 멈춘 과제가 있다면 다시 시작
                    t = stack.pop();
                }else if(!q.isEmpty()){ // 멈춰둔 과제가 없고, 일정 시간 후에 시작해야 할 과제가 있다면 그 과제를 시작
                    t = q.poll();
                    now = t.start; 
                }else{ // 남아있는 과제가 없으면
                    break; 
                }
            }
        }
        
        return answer;
    }
    private int changeToMin(String s){
        String[] str = s.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]); 
    }
}


