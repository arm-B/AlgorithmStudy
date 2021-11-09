// 언제 푼 건지 못 찾겠어서 옛날 거 긁어오고 초기화함.
import java.util.*;
import java.lang.*;

class Solution {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
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

//ㅋ ㅋ.ㅋ.... deque로 했는데 이건 얘가 순서대로 정렬이 안돼서 자꾸 틀림.. 맞는 자리에 찾아 넣어줘야하는데 안 되네,,,
// priorityqueue는 숫자가 작은 순서대로(argument로 정해진 값을 주면 큰 순서대로도 가능) 우선순위를 주는 큐임... 그래서 peek하면 무조건 작은 애가 튀어나옴

import java.util.*;
class Solution {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> food = new PriorityQueue<>();
    for(int a : scoville)
      food.offer(a);
    while(food.peek()<=K){
      if(food.size() == 1){
        answer = -1;
        break;
      }
      int first = food.poll();
      int second = food.poll();
      food.offer(first + 2*second);
      answer++;
    }
    return answer;
  }
}

//처음에 deque가 잘못된지 모르고 while문을 고쳤었는데... 처음 while문도 잘 돌아간다
import java.util.*;
class Solution {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> food = new PriorityQueue<>();
    for(int a : scoville)
      food.offer(a);
    while(food.size()>=2){
      int first = food.poll();
      int second = food.poll();
      if(first >= K)
        break;
      food.offer(first + 2*second);
      answer++;
    }
    // food.peek() < K 하는 이유 > 처음에 들어온게 K = 7, scovilie = {1}이면 food.size()는 1이라 answer가 -1돼버리는 상황 생김.
    if(food.size() == 1 && food.peek() < K) answer = -1;
    return answer;
  }
}
/* 위에 거 효율성
테스트 1 〉	통과 (136.63ms, 66.1MB)
테스트 2 〉	통과 (281.44ms, 86.8MB)
테스트 3 〉	통과 (1970.32ms, 121MB)
테스트 4 〉	통과 (111.97ms, 63.7MB)
테스트 5 〉	통과 (1590.73ms, 127MB)
*/

/* 아래 거는
테스트 1 〉	통과 (148.11ms, 66.8MB)
테스트 2 〉	통과 (270.91ms, 86.6MB)
테스트 3 〉	통과 (1372.68ms, 122MB)
테스트 4 〉	통과 (236.21ms, 82MB)
테스트 5 〉	통과 (1603.20ms, 127MB)
*/
