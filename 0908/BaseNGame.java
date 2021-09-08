import java.util.*;
class Solution {
  public String solution(int n, int t, int m, int p) {
    String answer = "";
    int count = 0, num = 0, now = 1;
    while(true){
      Deque<Integer> dq = new ArrayDeque<>();
      
      //진수 변환
      int z = num;
      while(true){
        dq.addLast(z%n);
        z /= n;
        if(z == 0) break;
      }
      
      //말할 문자 찾기
      while(!dq.isEmpty()){
        //순서 앞으로 돌리기
        if(now == m+1) now = 1;
        int tmp = dq.pollLast();
        
        if(now == p){
          if(tmp < 10){
            answer += Integer.toString(tmp);
          }
          else {
            char c = 'A';
            c += (tmp-10);
            answer += c;
          }
          count++;
        }
        now++;
        if(count == t) return answer;
      }
      num++;
    }
  }
}
