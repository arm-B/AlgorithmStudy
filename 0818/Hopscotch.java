//아니 이거 파일 만드려고 땅따먹기 영어로 검색했더니 eat the ground 나옴... 아니...
class Solution {
  static int answer;
  int solution(int[][] land) {
    answer = 0;
    goToNext(land, -1, 0, 0);
    return answer;
  }
  
  static void goToNext(int[][] land, int here, int score, int count){
    if(count == land.length) {
      if(score > answer)
        answer = score;
      return; 
    }
    int max = 0;
    for(int i = 0; i<land[0].length; i++){
      if(here != i && score + land[count][i] > max) {
        max = score + land[count][i];
        goToNext(land, i, max, count+1);
      }
    }
  }
}

// 시작은 가뿐하게 런타임에러로
// 하... dp 문제래 여기서 이마 탁침

import java.util.*;
class Solution {
  int solution(int[][] land) {
    int score[][] = new int[land.length][land[0].length];
    
    for(int i = 0; i<land.length; i++) {
      for(int j = 0; j<land[0].length; j++)
        score[i][j] = land[i][j];
    }
    
    for(int i = 1; i<land.length; i++) {
      for(int j = 0; j<land[i].length; j++) {
        for(int k =0 ; k<land[i].length; k++)
          if(j != k)
            score[i][j] = Math.max(score[i][j], land[i][j] + score[i-1][k]);
      }	
    }
    
    Arrays.sort(score[score.length-1]);
    int answer = score[score.length-1][3];
    
    return answer;
  }
}
