class Solution {
  public int solution(int m, int n, String[] board) {
    int answer = 0;
    
    boolean isPop = true;
    int game[][] = new int[m][n];
   
    for(int i = 0; i<m; i++)
      for(int j = 0; j<n; j++)
        game[i][j] = board[i].charAt(j);
    
    while(isPop) {
      int selected[][] = new int[m][n];
      isPop = false;
      int count = 0;
      for(int i = 0; i<m-1; i++) {
        for(int j = 0; j<n-1; j++) {
          if(game[i][j] != 0 && game[i][j] == game[i][j+1] && game[i][j+1] == game[i+1][j]
             && game[i+1][j] == game[i+1][j+1])
            selected[i][j] = selected[i][j+1] = selected[i+1][j] = selected[i+1][j+1] = 1;
        }
      }
      
      for(int i = m-1; i>=0; i--)
        for(int j = n-1; j>=0; j--) {
          if(selected[i][j] == 1) {
            answer++;
            isPop = true;
            int k = i;
            while(k>=0 && selected[k][j]>= 1) k--;
            if(k<0)
              game[i][j] = 0;
            else {
              game[i][j] = game[k][j];
              selected[k][j] = 2;
            }
          }
        }
    }
    return answer;
  }
}
// 첫번째 도전. 5,6,10번 테케에서 실패했다.. 이유가 뭘까... 그래서 질문하기 들어가 또 찾아봤다.
// 아... 덜 내렸네... 중간에 걸쳐 있네.... ㅇㅋㅇㅋ 다시 해본다
// 해냈다
// 하... 한 번에 없애고 터트리고 다 하려니까 내가 처음 짠 로직으로는 안 된 거였음 나 같은 초짜는 그냥 따로따로 하는 게 오류 없이 잘 된다.

import java.util.*;
class Solution {
  public int solution(int m, int n, String[] board) {
    int answer = 0;
    
    Queue<Integer> tmp = new LinkedList<>();
    
    boolean isPop = true;
    int game[][] = new int[m][n];
    
    for(int i = 0; i<m; i++)
      for(int j = 0; j<n; j++)
        game[i][j] = board[i].charAt(j);
    
    while(isPop) {
      int selected[][] = new int[m][n];
      isPop = false;
      for(int i = 0; i<m-1; i++) {
        for(int j = 0; j<n-1; j++) {
          if(game[i][j] != 0 && game[i][j] == game[i][j+1] && game[i][j+1] == game[i+1][j]
             && game[i+1][j] == game[i+1][j+1])
            selected[i][j] = selected[i][j+1] = selected[i+1][j] = selected[i+1][j+1] = 1;
        }
      }
      
      for(int i = m-1; i>=0; i--)
        for(int j = n-1; j>=0; j--) {
          if(selected[i][j] == 1) {
            isPop = true;
            game[i][j] = 0;
            answer++;
          }
        }
      
      for(int j = 0; j<n; j++) {
        int k = m-1;
        while(k>=0) {
          if(selected[k][j] != 1 && game[k][j] != 0)
            tmp.add(game[k][j]);
          k--;
        }
        k = m-1;
        while(!tmp.isEmpty()) {
          game[k--][j] = tmp.poll();
        }
        for(int l = k; l>=0; l--) {
          game[l][j] = 0; 
        }
      }		
    }
    return answer;
  }
}
