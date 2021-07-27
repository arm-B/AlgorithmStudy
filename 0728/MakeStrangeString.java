class Solution {
  public String solution(String s) {
    StringBuilder sb = new StringBuilder();
    int start = 0;
    for(int i = 0; i<s.length(); i++) {
      if(s.charAt(i) == ' ') {
        start = i;
        sb.append(' ');
        start++;
      }
      else {
        if((i-start)%2 == 0)
          sb.append(Character.toUpperCase(s.charAt(i)));
        else
          sb.append(Character.toLowerCase(s.charAt(i)));      
      }
    }
    String answer = sb.toString();
    return answer;
  }
}
