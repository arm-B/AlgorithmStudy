class Solution {
  public int solution(String name) {
    int answer = 0;
    int min = name.length()-1;
    
    for(int i = 0 ; i<name.length(); i++) {
      //위아래
      char c = name.charAt(i);
      //1 더하는 건 Z~A간 이동
      int mov = (c - 'A' < 'Z' - c + 1) ? (c-'A') : ('Z' - c + 1);
      answer += mov;
      
      //양옆
      int next = i+1;
      while(next < name.length() && name.charAt(next) == 'A')
        next++;
      // i*2는 중간까지 왔다가 다시 뒤로 돌아갈 때의 조이스틱 이동 횟수
      // 이게 더 빠른 애가 있다고... A가 많은 건 그런가봄
      // 현재 최소 거리와 (현재위치+돌아갈거리+끝위치)를 비교해서 최소값 찾기
      min = Math.min(min, (i*2) + name.length()-next);
    }
    
    //최소 양옆 이동거리 한 번만 더해준다
    answer+=min;
    
    return answer;
  }
}
