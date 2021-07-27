class Solution {
  public int[] solution(String[][] places) {
    int answer[] = new int [places.length];
    // (r1, c1) (r2, c2) > 맨해튼 거리  = |r1-r2|+|c1-c2|
    for(int i = 0; i<answer.length; i++) answer[i] = 1;
    
    for(int i = 0; i<places.length; i++) {
      for(int j = 0; j<places[i].length; j++) {
        for(int k = 0; k<places[i][j].length();k++)
          if(places[i][j].charAt(k) == 'P')
            if(!checkD(places, i, j, k)) {
              answer[i] = 0;
              break;
              //더 깔끔하게 바로 다음 i로 넘어가는 방법은 없을까... boolean 써서 k 빠져나오자마자 조건 확인하게 하면 가능할 거 같긴 함
            }
      }
    }
    return answer;
  } 
  public static boolean checkD(String[][] places, int room, int row, int col) {
    if(col+1 < 5) {
      if(places[room][row].charAt(col+1) == 'P')
        return false;
      else if(row+1 < 5 && places[room][row+1].charAt(col+1) == 'P') {
        if(places[room][row+1].charAt(col) != 'X' || places[room][row].charAt(col+1) != 'X')
          return false;
      }
    }
    if(col+2 <5) {
      if(places[room][row].charAt(col+2) == 'P')
        if(places[room][row].charAt(col+1) !='X')
          return false;
    }
    if(row+1 <5) {
      if(places[room][row+1].charAt(col) =='P')
        return false;
    }
    if(row+2 <5) {
      if(places[room][row+2].charAt(col) == 'P')
        if(places[room][row+1].charAt(col) !='X')
          return false;
    }
    return true;
  }
}

// 3 5 11 13 정확성 86... 자 어디서 잘못 됐을까요??
// 내 코드는 현재 위치를 P 이라고 했을 때 ! 자리를 검사하는건데

// P  !  !
// !  !
// !

// 이 경우 어떤 걸 못 잡냐면

// X  P
// P  X

// 그래서 col+1 검사할 때 아래만 검사하는 게 아니라 위쪽도 검사할 수 있게 추가해줬더니 바로 성공 귿.

class Solution {
  public int[] solution(String[][] places) {
    int answer[] = new int [places.length];
    // (r1, c1) (r2, c2) > 맨해튼 거리  = |r1-r2|+|c1-c2|
    for(int i = 0; i<answer.length; i++) answer[i] = 1;
    
    for(int i = 0; i<places.length; i++) {
      for(int j = 0; j<places[i].length; j++) {
        for(int k = 0; k<places[i][j].length();k++)
          if(places[i][j].charAt(k) == 'P')
            if(!checkD(places, i, j, k)) {
              answer[i] = 0;
              break;
            }
      }
    }
    return answer;
  }
  
  public static boolean checkD(String[][] places, int room, int row, int col) {
    if(col+1 < 5) {
      // P P 이면 ㅂㅂ
      if(places[room][row].charAt(col+1) == 'P')
        return false;
      
      // P X
      // X P 인지 확인 X 자리에 하나라도 X가 아닌 게 있으면 ㅂㅂ
      else if(row+1 < 5 && places[room][row+1].charAt(col+1) == 'P') {
        if(places[room][row+1].charAt(col) != 'X' || places[room][row].charAt(col+1) != 'X')
          return false;
      }
      
      // X P
      // P X 인지 확인 X 자리에 하나라도 X가 아닌 게 있으면 ㅂㅂ
      else if(row-1 >=0 && places[room][row-1].charAt(col+1) == 'P') {
        if(places[room][row-1].charAt(col) != 'X' || places[room][row].charAt(col+1) != 'X')
          return false;
      }
    }
    
    // P X P 인지 확인 P O P 같은 거면 ㅂㅂ
    if(col+2 <5) {
      if(places[room][row].charAt(col+2) == 'P')
        if(places[room][row].charAt(col+1) !='X')
          return false;
    } 
    
    // P
    // P 이면 ㅂㅂ
    if(row+1 <5) {
      if(places[room][row+1].charAt(col) =='P')
        return false;
    }
    
    // P           P
    // X           O
    // P 가 아니라 P 같은 거면 ㅂㅂ
    if(row+2 <5) {
      if(places[room][row+2].charAt(col) == 'P')
        if(places[room][row+1].charAt(col) !='X')
          return false;
    }  
    
    //위의 검증을 다 통과해야만 true를 가지고 가서 answer의 값을 1로 유지할 수 있음
    return true;
  }
}
