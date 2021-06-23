import java.util.*;
class Solution {
  public int[] solution(String s) {
    ArrayList<String> strs = new ArrayList<>();
    HashSet<Integer> set = new HashSet<>();
    int idx = 0;
    for(int i = 1; i<s.length(); i++) {
      if(s.charAt(i) == '{') {
        String tmp = "";
        while(s.charAt(i+1) != '}') {
          tmp += s.charAt(++i);
        }
        strs.add(tmp);				
      }
    }
    int answer[] = new int[strs.size()];
		
    strs.sort(new Comparator<String>(){
      public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
      }
    });
    int i = 0;
    for(String str : strs) {
      for(String num : str.split(",")) {
        int a = Integer.parseInt(num.trim());
        if(set.contains(a)) continue;
        else set.add(a);
        answer[i++] = a;
      }
    }
    return answer;
  }
}
