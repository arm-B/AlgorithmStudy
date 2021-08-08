class Solution {
  public int solution(int n) {
    int answer = 0;
    StringBuilder sb = new StringBuilder();
    
    while(n>0) {
      sb.append(Integer.toString(n%3));
      n /= 3;
    }
    
    for(int i = 0; i<sb.length(); i++)
      answer += (sb.charAt(sb.length()-1-i)-'0')* Math.pow(3, i);
    
    return answer;
  }
}
