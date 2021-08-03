class Solution {
  public int solution(int n) {
    int answer = 1+n;
    
    if(n == 0)
      answer = 0;
    else if(n == 1)
      answer = 1;
    else
      for(int i = 2; i <= n/2 + 1; i++)
        if(n%i == 0)
          answer += i;
    
    return answer;
  }
}
