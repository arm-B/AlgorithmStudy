class Solution {
  public int solution(int n, int a, int b) {
    int answer = 1;
    int min, max;
    if(a>b) { min = b; max = a;}
    else { min = a; max = b;}
    while(min % 2 != 1 || min+1 != max){
      answer++;
      min = min/2 + min%2;
      max = max/2 + max%2;
    }
    return answer;
  }
}
