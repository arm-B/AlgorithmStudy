import java.util.*;
class Solution {
  public int solution(String dartResult) {
    ArrayList<Integer> scores = new ArrayList<>();
    int score = 0;
    
    for(int i = 0; i<dartResult.length(); i++) {
      switch(dartResult.charAt(i)) {         
        case '0' :
          if(i-1>=0 && dartResult.charAt(i-1) == '1')
            score = 10;
          else{
            scores.add(score);
            score = 0;
          }
          break;
        case '*' :
          if(!scores.isEmpty())
            scores.set(scores.size()-1, scores.get(scores.size()-1)*2);
          score *= 2;
          break;
        case '#' :
          score = (-1) * score;
          break;
        case 'S' :
          break;
        case 'D' :
          score *= score;
          break;
        case 'T' :
          score = score * score * score;
          break;
        default :
          scores.add(score);
          score = dartResult.charAt(i)-'0';
          break;
      }
    }
    scores.add(score);
    int answer = 0;
    for(int a : scores) answer += a;
    return answer;
  }
}
