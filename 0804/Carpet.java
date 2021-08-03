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

//아니 잠깐만...i가 작은 수부터 시작하니까 당연히 i가 작거나 같을 텐데 굳이 왜 비교문 넣음?
//그래서 고쳤습니다... 당연히 맞았습니다...

class Solution {
  public int[] solution(int brown, int yellow) {
    int r=0, c=0;
    int answer[] = new int[2];
    
    for(int i = 1; i<=yellow/2+1; i++) {
      if(yellow%i == 0) {   
        r = yellow/i;
        c = i;
        
        if(2*r+2*(c+2) == brown) {
          answer[0] = r+2;
          answer[1] = c+2;
          break;
        }
      }
    }
    return answer;
  }
}
