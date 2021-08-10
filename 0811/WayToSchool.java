class Solution {
  public int solution(int m, int n, int[][] puddles) {
    int INF = -1;
    int road[][] = new int[m][n];
    
    for(int i = 0; i<puddles.length; i++) road[puddles[i][0]-1][puddles[i][1]-1] = INF;
    road[0][0] = 1;
    
    for (int i = 1; i < m; i++) {
      if (road[i][0] == 0)
        road[i][0] = road[i - 1][0]%1000000007;
      else
        break;
    }
    for (int j = 1; j < n; j++) {
      if (road[0][j] == 0)
        road[0][j] = road[0][j-1]%1000000007;
      else
        break;
    }
    
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (road[i][j] == 0) {
          if(road[i-1][j] == INF)
            road[i][j] = road[i][j-1]%1000000007;
          else if(road[i][j-1] == INF)
            road[i][j] = road[i-1][j]%1000000007;
          else
            road[i][j] = (road[i-1][j]+road[i][j-1])%1000000007;
        }
      }
    }
    
    int answer = road[m-1][n-1]%1000000007;
    return answer;
  }
}

/*
처음에 저 모듈러 하나도 안 붙이고 해고 제출함 정확성은 100인데 효율성이 0점인 거야... 하... 아니 영록송 강의 보면서 따라적은 코드 보면서
이 조건에 맞게 바꾼 건데 동적프로그래밍이 아닐리는 없겠지... 근데 왜 이난리가 났지 하면서 질문하기 들어갔더니
어떤 분이 !!정확도 100인데 효율성 0 뜨시는 분 보세요!! 이래서 내 얘기네 하고 들어감
모듈러를... 행렬에 넣을 때마다 매번 다 넣어줘야 된다는 거임 그래서 하나 안 넣고 하나 빼고 이런식으로 해서 돌려봤는데 진짜 빼면 안 돌아감 wow
이유는 모르겠지만 일단 감사합니다... 혹시 이유를 아신다면 저에게 설명 좀 부탁드립니다... 왜 안 붙이면 효율성이 작살이 나는지...
*/
