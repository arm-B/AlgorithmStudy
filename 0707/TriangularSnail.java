class Solution {
  public int[] solution(int n) {
    int solution[][] = new int[n][n];
    int number = 1, max = 0, row = 0, col = 0;
    for(int i = 1; i<=n; i++) max += i;
    int answer[] = new int[max];
    
    solution[row][col] = number;
    while(number < max) {
      while(row+1<n&& number<max && solution[row+1][col]==0)
        solution[++row][col] = ++number;
      while(col+1<n && number < max && solution[row][col+1] == 0)
        solution[row][++col] = ++number;
      while(row-1>0 && col-1 > 0 && number<max && solution[row-1][col-1] == 0)
        solution[--row][--col] = ++number;
      
    }
    int index = 0;
    for(row = 0; row<n; row++) {
      for(col = 0; col<= row; col++) {
        answer[index++] = solution[row][col];
      }
    }
    return answer;
  }
}

// 숫자 넣는 거야 쉽지만 아래까지 내려갔을 때 어떻게 멈춰야할지 머리가 안 돌아갔다. (도대체 왜???????)
// 전에 컴알 수업에서 네모네모할 때는 left right 다 만들어줘서 했었던 게 기억나서 적용해보려다가 오히려 그걸로 했다간 더 머리가 아플 거 같아서 포기.
// 그래서 또 뒤져봤다... 하... 아니... 진짜 쏘 간단... 그냥 넣을 때마다 비교하면 되더라 효율성을 안 따지는 문제라^~^...
// 이건 컴알 네모네모처럼 지금 위치를 따지는 게 아니라 다음으로 갈 곳이 차있는지 안 차있는지를 보는 것 같다. 어차피 아래 오른쪽 대각선왼쪽위 방향대로 쭉 가는 건 고정이니까.
// 다음 위치를 비교하고 따지는 거라 첫 시작은 직접 넣어줘야 한다. 안 그러면 answer[0]의 값이 0이 된다.
// 문제 풀면 풀수록 자괴감만 느는데 괜찮나 이거
