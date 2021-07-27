class Solution {
  public String solution(String s, int n) {
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0 ;i<s.length(); i++) {
      //소문자, 더해도 범위 안
      if(s.charAt(i)+n <='z' && s.charAt(i)>='a') {
        sb.append((char)(s.charAt(i)+n));
      }
      //소문자, 더하면 범위 밖
      else if(s.charAt(i)+n >'z' && s.charAt(i)>='a') {
        int tmp = 'a'+s.charAt(i)+n-'z'-1;
        while(tmp>'z') tmp -= 26;
        sb.append((char)tmp);
      }
      //대문자, 더해도 범위 안
      else if(s.charAt(i)+n <='Z' && s.charAt(i)>='A') {
        sb.append((char)(s.charAt(i)+n));
      }
      //대문자, 더하면 범위 밖
      else if(s.charAt(i)+n > 'Z' && s.charAt(i)<='Z') {
        int tmp = 'A'+s.charAt(i)+n-'Z'-1;
        while(tmp>'Z') tmp -=26;
        sb.append((char)tmp);
      }
      //공백
      else
        sb.append(s.charAt(i));
    }
    String answer = sb.toString();
    return answer;
  }
}

// n 범위 생각 안하고 처리 안했다가 실패 폭탄 맞고 울었음
