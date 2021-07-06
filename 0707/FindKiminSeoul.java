class Solution {
  public String solution(String[] seoul) {
    String whereIsKim = "";
    
    for(int i = 0; i<seoul.length; i++) {
      if(seoul[i].equals("Kim"))
        whereIsKim = Integer.toString(i);
    }
    String answer = "김서방은 " + whereIsKim + "에 있다";
    return answer;
  }
}
