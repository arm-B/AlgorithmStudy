//전에 문자열 압축하기처럼 풀었더니 답은 맞는데 효율성에서 2@@ms대 나와서 다 틀렸다.
//추가하면서 삭제하면 되는데, 그냥 다 추가하고 다시 돌면서 삭제하니까 더 오래걸린 것이다.
//서치했더니 stack으로 풀었다길래... 정신차리고 다시 프로그램을 작성했다... 난 바보다...
import java.util.*;
class Solution{
  public int solution(String s){
    Stack<Character> stc = new Stack<Character>();
    int answer = 0;
    for(int i = 0; i<s.length();i++) {
      if(!stc.isEmpty() && stc.peek() == s.charAt(i))
        stc.pop();
      else
        stc.add(s.charAt(i));
    }
    if(stc.isEmpty())
      answer = 1;
    else
      answer = 0;
    return answer;
  }
}
