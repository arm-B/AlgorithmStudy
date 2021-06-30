import java.util.*;
class Solution {
  public String[] solution(String[] record) {
    List<String[]> list = new ArrayList<>();
    HashMap<String, String> map = new HashMap<String, String>();
    for(int i = 0; i<record.length;i++) {
      String[] str = record[i].split(" ");
      if(str.length == 3) {
        map.put(str[1], str[2]);
      }
      if (str[0].equals("Enter")) {
        String tmp[] = {str[1],"님이 들어왔습니다."};
        list.add(tmp);
      } else if (str[0].equals("Leave")) {
        String tmp[] = {str[1],"님이 나갔습니다."};
        list.add(tmp);
      }
    }
    
    String[] answer = new String[list.size()];
    
		for(int i = 0; i<answer.length;i++) {
      StringBuilder sb = new StringBuilder();
      answer[i] = map.get(list.get(i)[0])+list.get(i)[1];
    }
    return answer;
  }
}
