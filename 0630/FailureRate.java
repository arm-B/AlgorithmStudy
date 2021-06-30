import java.util.*;
class Solution {
  public int[] solution(int N, int[] stages) {
    double failure[] = new double[N];
    int answer[] = new int[N];
    boolean visited[] = new boolean[N];
    int index = 0;
    int remained = stages.length;
    
		for(int i = 0; i<stages.length;i++) {
      for(int j = 0; j<N;j++)
        if(stages[i]-1==j)
          failure[j]+=1;
    }
    
		for(int i = 0; i<N;i++) {
      if(i>0)
        remained-=failure[i-1]*remained;
      failure[i]/=remained;
    }
    
		double tmp[] = failure.clone();
    Arrays.sort(failure);
    
		for(int i = N-1; i>=0;i--) {
      for(int j =0; j<N; j++) {
        if(tmp[j] == failure[i] && !visited[j]) {
          visited[j] = true;
          answer[index++] = j+1;
          break;
        }
      }
    }
    return answer;
  }
}

//이대로 하니까 오류가 발생... 정확도가 70... 모두 끝까지 못 도달해서 NaN이 나오는 경우를 생각해보라는데 테스트케이스 넣고 해봐도 잘 모르겠어서 그냥 다른 사람의 코드를 가져왔다.
//질문하기에서 봤던 사람도 Map을 써서 하던데.. 나만 배열을 고집해서 제대로 못 푼 건가 싶기도 하고...?? 내 코드의 문제점에대해 좀 더 생각해봐야할 것 같다.
//1단계 맵다...

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
 
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer,Double> map = new HashMap<>();
        //<stage,failureRate>
        
        for(int i=1; i<=N; i++) {
            int stage = i;
            int noClearPlayer = 0;
            int currentStagePlayer = 0;
            
            for(int j=0; j < stages.length; j++) {
                int player = stages[j];
                
                //현재 스테이지 클리어 못한사람
                if(stage == player) {
                    noClearPlayer++;
                }
                //현재 스테이지 도전자
                if(stage<=player) {
                    currentStagePlayer++;
                }
            }
            
            //스테이지에 도달한 유저가 없는 경우 실패율 = 0
            //실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수 (도전자수)
            double failureRate = 0;
            if(noClearPlayer!=0 && currentStagePlayer!=0) {
                failureRate = (double)noClearPlayer / (double)currentStagePlayer;
            }
            map.put(stage, failureRate);        
        }
        
        //value순 정렬하여 answer배열에 넣기
        for(int i=0; i<N; i++) {
            double max = -1;
            int maxKey = 0;
            for(Integer key : map.keySet()) {
                if(max < map.get(key)) {
                    max = map.get(key);
                    maxKey = key;
                }
            }
            answer[i] = maxKey;
            map.remove(maxKey);
        }
        return answer;
    }
}

출처: https://ivory-room.tistory.com/54 [개발로 자기개발]
