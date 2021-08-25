import java.util.*;
class Solution {
  public int[] solution(String msg) {
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<Integer> printStrings = new ArrayList<>();
    
    int count = 1;
    for(int i = 65; i<=90; i++)
      map.put(Character.toString((char)i), count++);
    
    int printIndex = -1;
    int addIndex = -1; 
    boolean finishUpdate = false;
    
    for(int i = 0; i<msg.length(); i++) {
      StringBuilder sb = new StringBuilder();
      int j = i+1;
      sb.append(msg.charAt(i));
      while(map.containsKey(sb.toString()) && j<msg.length() && i>=printIndex) {
        sb.append(msg.charAt(j++));
      }
      
      if(j<msg.length()) sb.deleteCharAt(sb.length()-1);
      if(i>=printIndex) {
        printStrings.add(map.get(sb.toString()));
        printIndex = i + sb.length();
      }
      
      j = i+1;
      sb.delete(0, sb.length()); sb.append(msg.charAt(i));
      while(!finishUpdate && map.containsKey(sb.toString()) && j<msg.length() && j>=addIndex){
        sb.append(msg.charAt(j++));
        if(!map.containsKey(sb.toString())) {
          if(j==msg.length()) finishUpdate = true;
          break;
        }
      }
      if(!map.containsKey(sb.toString())) {
        addIndex = i + sb.length();
        map.put(sb.toString(), count++);
      }
    }
    int[] answer = new int[printStrings.size()];
    for(int i = 0; i<printStrings.size(); i++) 
      answer[i] = printStrings.get(i);
    return answer;
  }
}

// 70점... 테케에서 nullpointexception이 떠서 까인 게 그 오류일 거 같긴 한데 뭔지를 모르겠다... 이말이죠 질문하기도 워낙 양이 적어서...
// 1,5,11,16,18,19
// 포기합니다 이게 3시간동안 달라붙어서 만든 꼬라지거든요^~^
