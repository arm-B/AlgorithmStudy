class Solution {
  public String solution(String s) {
    StringBuilder sb = new StringBuilder();
    boolean isFE = true;
    
    for(int i = 0; i<s.length(); i++){
      if(s.charAt(i) == ' '){
        isFE = true;
        sb.append(' ');
        continue;
      }
      
      if(isFE) {
        sb.append(Character.toString(s.charAt(i)).toUpperCase());
        isFE = false;
      }
      else
        sb.append(Character.toString(s.charAt(i)).toLowerCase());
    }
    return sb.toString();
  }
}
