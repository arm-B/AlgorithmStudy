import java.util.*;
class Solution {
  public int solution(int[] citations) {
    Arrays.sort(citations);
    int h = citations[citations.length/2];
    int answer = 0;
    
    while(true) {
      int count = 0;
      for(int i = 0; i<citations.length; i++)
        if(citations[i] >= h)
          count++;
      
      if(answer == h)
        break;
      else if(count >= h) {
        answer = h;
        h++;
      }
      else
        h--;
    }
    return answer;
  }
}

// 일단 정렬하고 가장 가능성 있는 중간에서부터 시작해서 인용횟수 넘는 게 인용횟수 이상이면 인용횟수를 하나 올려보고
// 못 넘으면 계속 내리는 걸로 해서 구현했다 내려가다가 딱 처음으로 됐을 때 하면 좋을 텐데 위에 한 번 다녀오는 게 아쉽긴 하다
// 방금 그렇게 해서 프로그래머스에서 돌려봤는데 시간차이가 별로 안 난다... 그냥 이대로 둬야지
