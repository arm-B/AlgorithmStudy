import java.util.*;
class Solution {
  public int[] solution(int n, String[] words) {
    int answer[] = new int[2];
    
    TreeSet<String> alreadyUsed = new TreeSet<>();
    alreadyUsed.add(words[0]);
    
    for(int i = 1; i<words.length; i++) {
      if(alreadyUsed.contains(words[i])) {
        answer[0] = checkNum((i+1)%n, n);
        answer[1] = (int)Math.ceil((float)(i+1)/n);
        break;
      }
      if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) {
        answer[0] = checkNum((i+1)%n, n);
        answer[1] = (int)Math.ceil((float)(i+1)/n);
        break;
      }
      alreadyUsed.add(words[i]);
    }
    return answer;
  }
  
  static public int checkNum(int n, int last) {
    if(n == 0)
      return last;
    else
      return n;
  }
}
