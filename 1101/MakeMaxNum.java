class Solution {
  public String solution(String number, int k) {
    StringBuilder answer = new StringBuilder();
    int pos = 0;
    for(int i = number.length()-k-1; i>=0; i--) {
      char max = '0';
      for(int j = pos; j < number.length()-i; j++) {
        if(number.charAt(j)>max) {
          max = number.charAt(j);
          pos = j+1;
        }
        if(max == '9') break;
      }
      answer.append(max);
    }
    return answer.toString();
  }
}
