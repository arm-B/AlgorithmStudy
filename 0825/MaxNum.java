import java.util.*;
class Solution {
  static ArrayList<Long> list;
  static boolean[] visited;
  public String solution(int[] numbers) {
    String answer = "";
    list = new ArrayList<>();
    visited = new boolean[numbers.length];
    
    for(int i = 0; i<numbers.length; i++){
      ArrayList<Integer> num = new ArrayList<>();
      num.add(numbers[i]); visited[i] = true;
      makeNum(numbers, num, 1);
      visited[i] = false;
    }
    Collections.sort(list);
    answer = Long.toString(list.get(list.size()-1));
    return answer;
  }
  
  static void makeNum(int[] numbers, ArrayList<Integer> num, int count){
    if(count == numbers.length){
      StringBuilder sb = new StringBuilder();
      for(int a : num) sb.append(a);
      list.add(Long.parseLong(sb.toString()));
      return;
    }
    
    for(int i = 0 ; i<numbers.length; i++){
      if(!visited[i]){
        int size = (int)(Math.log10(numbers[i])+1);
        num.add(numbers[i]); visited[i] = true;
        makeNum(numbers,num, count+1);
        num.remove(num.size()-1); visited[i] = false;
      }
    }            
  }
}

// 테케는 다 돌아가는데 아무래도 모든 경우의 수 다 구하는 거라 runtime error가 남... 에휴
// 싹 지우고 다시 풀어야지

// String으로 바꿔서 내림차순 정렬하면 매우 쉬운 문제
// 소요시간 보고 기절하는 줄 알았다
import java.util.*;
class Solution {
  public String solution(int[] numbers) {
    String answer = "";
    ArrayList<String> list = new ArrayList<>();
    
    for(int a : numbers) list.add(Integer.toString(a));  
    Collections.sort(list, new Comparator<String>() {
      public int compare(String a, String b) {
        return (b+a).compareTo(a+b);
      }
    });
    
    for(String s : list) answer += s;
    if(list.get(0).equals("0")) answer = "0";
    return answer;
  }
}
