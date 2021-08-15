import java.util.*;
class Solution {
  public String solution(int[][] scores) {
    StringBuilder answer = new StringBuilder();
    for(int i = 0; i<scores.length; i++) {
      ArrayList<Integer> score = new ArrayList<>();
      for(int j=0; j<scores[i].length; j++) {
        score.add(scores[j][i]);
      }
      
      int sum = 0;
      Collections.sort(score);
      if(score.get(0) == scores[i][i] && score.get(0) != score.get(1)) {
        score.remove(0);
      }
      else if(score.get(score.size()-1) == scores[i][i] && score.get(score.size()-1) != score.get(score.size()-2)) {
        score.remove(score.size()-1);
      }
      answer.append(checkGrade(score));				
		}
    return answer.toString();
  }
  
  static String checkGrade(ArrayList<Integer> score) {
    int sum = 0;
    for(int a : score) sum +=a;
    sum /= score.size();
    
    if(sum >= 90) {
      return "A";
    } else if (sum >= 80) {
      return "B";
    } else if (sum >= 70) {
      return "C";
    } else if (sum >= 50) {
      return "D";
    } else
      return "F";
  }
}
