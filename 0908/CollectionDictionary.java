import java.util.*;
class Solution {
  static char[] alp = {'A', 'E', 'I', 'O', 'U'};
  static ArrayList<String> list;
  public int solution(String word) {
    list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    makeDic(sb, 0);
    Collections.sort(list);
    int answer = list.indexOf(word) + 1;
    return answer;
  }
  
  static void makeDic(StringBuilder sb, int index){
    if(index < 5)
      for(int i = 0; i<alp.length; i++){
        list.add(sb.append(alp[i]).toString());
        makeDic(sb, index+1);
        sb.deleteCharAt(sb.length()-1);
      }
  }
}

// 5자밖에 없어서 그냥 싹 만들고 찾는 식으로 했다.
