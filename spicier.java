import java.util.*;
import java.lang.*;
//클래스 이름과 다르지만 편의상 파일 이름은 더 맵게로...ㅎㅎ
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //minheap
        for (int i = 0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }

        while(pq.peek()<=K){
            if(pq.size() == 1){
                answer = -1;
                break;
            }
            int minimum = pq.poll();
            int minimum2 = pq.poll();
            pq.offer(minimum + (minimum2*2));
            answer++;
        }        
        return answer;
    }  
}
