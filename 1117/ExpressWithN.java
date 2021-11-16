import java.util.*;
class Solution {
  static int min;
  public int solution(int N, int number) {
    min = 9;
    dfs(N, number, 0, 0);
    if(min == 9) return -1;
    return min;
  }
  
  public void dfs(int N, int number, int count, int value){
    if(count > 8)
      return;
    
    if(value == number && count < min){
      min = count;
      return;
    }
    int nn = 0;
    for(int i = 0; i < 8-count ;i++){
      nn = nn * 10 + N; // nn = 5 -> 5*10+5 = 55 -> 55*10+5 = 555 ...
      dfs(N, number, count+1 + i, value + nn);
      dfs(N, number, count+1 + i, value - nn);
      dfs(N, number, count+1 + i, value * nn);
      dfs(N, number, count+1 + i, value / nn);
    }
  }
}
