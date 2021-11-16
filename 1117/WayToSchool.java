// 옛날 거
class Solution {
  public int solution(int m, int n, int[][] puddles) {
    int INF = -1;
    int road[][] = new int[m][n];
    for(int i = 0; i<puddles.length; i++) {
      road[puddles[i][0]-1][puddles[i][1]-1] = INF;
    }
    
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


// 초기값 주는 거 말고 달라진 부분이 없는데
class Solution {
  public int solution(int m, int n, int[][] puddles) {
    int answer = 0;
    int puddle = -1;
    int map[][] = new int[m][n];
    
    for(int i = 0; i<puddles.length; i++)
      map[puddles[i][0]-1][puddles[i][1]-1] = puddle;
    
    int i = 0, j = 0;
    while(i<m && map[i][0] != puddle)
      map[i++][0] = 1;
    while(j<n && map[0][j] != puddle)
      map[0][j++] = 1;
    
    for(i = 1; i<m; i++){
      for(j = 1; j<n; j++){
        if(map[i][j] == 0){
          if(map[i-1][j] == puddle)
            map[i][j] = map[i][j-1]%1000000007;
          else if(map[i][j-1] == puddle)
            map[i][j] = map[i-1][j]%1000000007;
          else
            map[i][j] = (map[i-1][j]+map[i][j-1])%1000000007;
        }
      }
    }    
    return map[m-1][n-1]%1000000007;
  }
}
// 궁금한 점... 웅덩이가 현재 자리에서 위 아래에 둘다 있으면 어떻게 되는 거임...?? -1 % 1000000007 한 거 들어가게 되지 않나...?
// 처리를 안해줘도 정답이라고 떠서 의문이었는데 생각해보니 그 자리에 들어가는 값이 -1이 되니까 그 자리도 웅덩이로 처리하는 모양이다
// 처리한 것과 안한 것 나중에 전체 맵 찍어보면 처리한 건 0, 아닌 건 -1로 나올 텐데 최종 값에는 크게 영향 안 주나보다. 
