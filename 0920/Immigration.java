class Solution {
  public long solution(int n, int[] times) {
    long min = 1, mid = 0;
    long max = (long)times[times.length-1]*n;
    long answer = max;
    
    while(min<=max){
      long sum = 0;
      mid = (min+max)/2;
      
      for(long time:times)
        sum += mid / time;
      
      if(sum>=n){
        if(mid < answer)
          answer = mid;
        max = mid-1;
      }
      else
        min = mid+1;
    }
    return answer;
  }
}

// 실수 3연발
// while(min<max)
// int sum
// mid랑 answer 비교 안 해서 더 큰 놈도 answer에 넣어버리기
// 인간앍
