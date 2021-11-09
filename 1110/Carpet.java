// 0804...였나 이쯤에 있음

class Solution {
  public int[] solution(int brown, int yellow) {
    int[] answer = new int[2];
    int r = 0, c = 0;
    for(int i = 1; i<=yellow/2+1; i++){
      if(yellow%i == 0){
        c = i; r = yellow/c;
        if(2*c+2*(r+2) == brown){
          answer[0] = r+2;
          answer[1] = c+2;
          break;
        }
      }
    }
    return answer;
  }
}
