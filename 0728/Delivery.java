import java.util.*;
class Solution {
  static TreeSet<Integer> set;
  public int solution(int N, int[][] road, int K) {
    set = new TreeSet<>();
    set.add(1);
    
    for(int i = 0; i<road.length; i++) {
      if(road[i][0] == 1) {
        timeCheck(road, road[i][1], road[i][2], K);
      }
      else if(1 == road[i][1]) {
        timeCheck(road, road[i][0], road[i][2], K);
      }
    }
    
    int answer = set.size();
    return answer;
  }
  
  static public void timeCheck(int road[][], int end, int time, int limit) {
    if(time <limit) {
      set.add(end);
    } else if(time == limit) {
      set.add(end);
      return;
    }
    else if (time>limit)
      return;
    
    for(int i = 0; i<road.length; i++) {
      if(road[i][0] == end && road[i][1] != 1) {
        timeCheck(road, road[i][1], time+road[i][2], limit);
      }
      else if(end == road[i][1] && road[i][0] != 1) {
        timeCheck(road, road[i][0], time+road[i][2], limit);
      }
    }
  }
}
// 위의 코드로 하니까 17 23 24 27 31 32 시간 초과 떴다...
// 테케를 찾아 질문하기로...

