// 이전 풀이내용은 0825 소수 찾기 참고
import java.util.*;
class Solution {
  static ArrayList<Integer> list;
  static boolean [] visited;
  public int solution(String numbers) {
    int answer = 0;
    list = new ArrayList<>();
    visited = new boolean[numbers.length()];
    StringBuilder sb = new StringBuilder();
    per(numbers, sb);
    
    for(int i =0; i<list.size(); i++){
      int num = list.get(i); boolean isP = true;
      
      if(num == 0 || num == 1)
        continue;
      
      for(int j = 2; j<num/2+1; j++)
        if(num%j == 0){
          isP = false;
          break;
        }
      if(isP) answer++;
    }
    return answer;
  }
  
  public void per(String numbers, StringBuilder sb){
    if(sb.length()>0 && sb.length()<=numbers.length() && !list.contains(Integer.parseInt(sb.toString())))
      list.add(Integer.parseInt(sb.toString()));
    for(int i = 0; i<numbers.length(); i++)
      if(!visited[i]){
        visited[i]  = true;
        per(numbers, sb.append(numbers.charAt(i)));
        visited[i] = false; sb.delete(sb.length()-1, sb.length());
      }
  }
}

// 저번 거 안 봐서 기억 안 나는데... java에는 permutation 생성해주는 함수가 없어서 아마 비슷한 방식으로 풀었을 듯
