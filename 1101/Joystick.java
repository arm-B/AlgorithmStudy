class Solution {
  public int solution(String name) {
    int answer = 0;
    int min = name.length()-1;
    
    for(int i = 0 ; i<name.length(); i++) {
      char c = name.charAt(i);
      int mov = (c - 'A' < 'Z' - c + 1) ? (c-'A') : ('Z' - c + 1);
      answer += mov;
      
      int next = i+1;
      while(next < name.length() && name.charAt(next) == 'A')
        next++;
      min = Math.min(min, (i*2) + name.length()-next);
      // BBBAAAAAABA 이 경우 한쪽으로 쭉가는 것보다 3번째 B까지 갔다가 뒤로 돌아가는 게 더 빠름 > 2*2 + 11-9 = 6
      // ì * 2 는 중간까지 왔다가 다시 뒤로 돌아갈 때의 조이스틱 이동 횟수이고, len - nextIndex 는 예시의 오른쪽에서 두번째의 B같은 애들까지의 위치
    }
    answer+=min;
    return answer;
  }
}
