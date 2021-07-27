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
