import java.util.Arrays;
class Solution {
  public int solution(int[] d, int budget) {
    int answer = 0;
    int index = 0;
    
    Arrays.sort(d);
    while(budget>0 && index < d.length) {
      if(budget-d[index]>=0) {
        budget-=d[index++];
        answer++;
      }
      else
        break;
    }
    return answer;
  }
}
