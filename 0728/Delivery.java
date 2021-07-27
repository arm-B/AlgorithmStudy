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
// 질문하기에... 천재가 있었다...
// 내 코드는 모든 경우의 수를 다 따지는 거라 시간이 많이 걸리는데
// 우선 어떤 점에 가는데 걸리는 시간을 저장하고 이 값보다 많이 걸리면 안 가고 적게 걸리면 가는 식으로 해보라는 것이다
// 이 코드 집어넣으니까 바로 성공 뜸... ^~^ 쏘해피

import java.util.*;
class Solution {
  static TreeSet<Integer> set;
  public int solution(int N, int[][] road, int K) {
    set = new TreeSet<>();
    set.add(1);
    
    for(int i = 0; i<road.length; i++) {
      if(road[i][0] == 1) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(road[i][1], map.getOrDefault(road[i][1], road[i][2]));
        timeCheck(road, road[i][1], road[i][2], map, K);
      }
      else if(1 == road[i][1]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(road[i][0], map.getOrDefault(road[i][0], road[i][2]));
        timeCheck(road, road[i][0], road[i][2], map, K);
      }
    }
    
    int answer = set.size();
    return answer;
  }
  
  static public void timeCheck(int road[][], int end, int time, HashMap map, int limit) {
    if(time <limit) {
      set.add(end);
    } else if(time == limit) {
      set.add(end);
      return;
    } else if (time>limit)
      return;
    
    for(int i = 0; i<road.length; i++) {
      if(road[i][0] == end && ((map.containsKey(road[i][1]) && (int)map.get(road[i][1]) > time+road[i][2]) || !map.containsKey(road[i][1]))) {
        map.put(road[i][1], time+road[i][2]);
        timeCheck(road, road[i][1], time+road[i][2], map, limit);
      }
      else if(end == road[i][1] && ((map.containsKey(road[i][0]) && (int)map.get(road[i][0]) > time+road[i][2]) || !map.containsKey(road[i][0]))) {
        map.put(road[i][0], time+road[i][2]);
        timeCheck(road, road[i][0], time+road[i][2], map, limit);
      }
    }
  }
}

// 구구절절 코드의 달인... 나도 깔끔하게 짜보고 싶다..
