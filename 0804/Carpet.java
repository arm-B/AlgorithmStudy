class Solution {
  public int[] solution(int brown, int yellow) {
    int r=0, c=0;
    int answer[] = new int[2];
    
    for(int i = 1; i<=yellow/2+1; i++) {
      if(yellow%i == 0) {
        r = i;
        c = yellow/i;
      }
      
      if(r>=c && 2*r+2*(c+2) == brown) {
        answer[0] = r+2;
        answer[1] = c+2;
        break;
      }
      else if(c>=r && 2*c+2*(r+2) == brown) {
        answer[0] = c+2;
        answer[1] = r+2;
        break;
      }
    }
    return answer;
  }
}
