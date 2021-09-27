class Solution {
  public int solution(String[] user_id, String[] banned_id) {
    int answer = 1;
    for(int i=0;i<banned_id.length; i++){
      int cand = 0;
      String ban = banned_id[i];
      for(int j = 0; j<user_id.length; j++){
        boolean isSame = true;
        if(user_id[j].length() != ban.length())
          continue;
        else {
          for(int k = 0; k<user_id[j].length(); k++){
            if(ban.charAt(k) != '*')
              if(user_id[j].charAt(k) != ban.charAt(k)){
                isSame = false;
                break;
              }
          }
        }
        if(isSame) cand++;   
      }
      if(cand>=1) answer *= cand;
      else answer *= 1;
    } 
    return answer;
  }
}

// ㅏ 겹치는 경우 생각 안하고 짜버림
//  평소처럼 dfs를 하려고 찾아보다가... 정말 나는 생각도 못할 방법을 찾음

import java.util.*;
class Solution {
  String[] bnd;
  HashSet<Integer> set = new HashSet<>();
  public int solution(String[] user_id, String[] banned_id) {
    bnd = new String[banned_id.length];
    for(int i = 0; i<banned_id.length; i++)
      // *문자를 0~9, a~z의 문자 탐색이 가능하도록 정규표현식 \w로 변경
      bnd[i] = banned_id[i].replace("*", "[\\w]");
    findUser(0, user_id, 0);
    return set.size();
  }
  
  void findUser(int index, String[] user, int bit){
    if(index == bnd.length){
      set.add(bit);
      return;
    }
    for(int i=0; i<user.length; ++i) { 
      //검사할 자리로 이동, 걔랑 1이랑 앤드 연산을 하고 그 값이 1이 아니면>안 쓴 거
      //matches는 정규표현식을 받는 인자
      if((((bit>>i) & 1) != 1) && user[i].matches(bnd[index])){ 
        findUser(index+1, user, bit|1<<i);
        // i번재 bit를 1로 설정하고, 현재의 것과 or 연산을 해서 기존 사용중인 건 유지, 두 번은 사용 못 하게
        //해당 아이디 사용시 user의 index 위치에 있는 bit 값을 1로 변경 > 어떤 인덱스의 아이디를 선택했는지 기억
      } 
    }
  }
}
