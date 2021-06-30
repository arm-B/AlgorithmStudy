import java.util.*;
import java.util.Map.Entry;
class Solution {
  static HashMap<String, Integer> map;
  public String[] solution(String[] orders, int[] course) {
    ArrayList<String> tmp = new ArrayList<>();
    
    //들어온 주문을 순서대로 만약 ACDBE > ABCDE 이런식으로
    //그래서 XY, YX 이런식으로 뽑는 일 없이 오름차순으로 조합된 것만 셀 수 있음
		for(int i =0;i<orders.length;i++){
      char[] charArr = orders[i].toCharArray();
      Arrays.sort(charArr);
      orders[i] = String.valueOf(charArr);
    }
    
    //조합 방법따라 구하기
    for(int i = 0; i<course.length; i++){
      
      //조합의 수 카운트할 때 쓸 수 있음.
      //XY:1 이런식으로 나와서 value값 이용
      map = new HashMap<>();
      
      //구한 조합들 중 가장 많이 주문된 거
      int max = 0;
      
      //조합 구하는 탐색
      for(int j = 0; j<orders.length; j++) {
        StringBuilder sb = new StringBuilder();
        if(course[i]<=orders[j].length())
          combi(orders[j], sb, 0,0,course[i]);
      }
      
      //많이 주문된 횟수를 max로, 최소 두번 이상 주문됐거나 횟수가 일치한다면 추가
      for(Entry<String, Integer> entry : map.entrySet()) {
        max = Math.max(max, entry.getValue());
      }
      for(Entry<String,Integer> entry : map.entrySet()){
        if(max >=2 && entry.getValue() == max)
          tmp.add(entry.getKey());
      }
    }
    //arraylist to array, 이후 정렬까지
    String[] answer = new String[tmp.size()];
    for(int i = 0; i<answer.length;i++) {
      answer[i] = tmp.get(i);
    }
    Arrays.sort(answer);
    return answer;
  }
  
  public static void combi(String order, StringBuilder sb, int idx, int cnt, int r) {
    if(cnt == r) {
      //길이가 조합만큼이다 싶으면 카운트 추가, 만약에 map 안에 없는 key라면 만들고 1 추가
      map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+1);
      return;
    }
    for(int i = idx; i<order.length(); i++) {
      //순서대로 붙였다떼었다하는과정
      sb.append(order.charAt(i));
      combi(order, sb, i+1, cnt+1, r);
      sb.delete(cnt, cnt+1);
    }		
  }
}
