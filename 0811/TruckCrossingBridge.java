import java.util.*;
class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Integer> bridge = new LinkedList<>();
    Queue<Integer> trucks = new LinkedList<>();
    for(int a : truck_weights) trucks.add(a);
    int answer = 0;
    int sum = 0;
    
    for(int i = 0; i<bridge_length; i++) bridge.add(0);
    while(!bridge.isEmpty()) {
      sum -= bridge.poll();
      
      if(trucks.isEmpty()) {
        answer +=bridge_length;
        break;
      }
      else {
        if(sum+trucks.peek()<= weight) {
          bridge.offer(trucks.peek());
          sum += trucks.poll();
        }
        else {
          bridge.offer(0);
        }
      }
      answer++;
    }
    return answer;
  }
}

/* 
처음에 코드를 짰는데 공개 테케는 잘 통과(^^)하는데 점수는 한자리수가 나와서 머리 부여잡고 있다가
갓문하기를 들어갔는데 진짜 큐로 트럭을 이동시키는... 거임...
처음에 풀 때 weight보다 작으면 싹다 큐에 넣고 한 번에 시간 더해야지ㅋㅋ 이렇게 생각했던 내가... 바보였던 거임...
>> 진짜로 트럭을 태우는 거임.... <<
이번주 너무 와장창이라 미치겠다 이러다 이퍼 통과할 수 있을까요...? 나는 2단계도 못 푸는데...?
*/
