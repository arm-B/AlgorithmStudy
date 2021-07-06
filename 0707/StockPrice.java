class Solution {
  public int[] solution(int[] prices) {
    int answer[] = new int[prices.length];
    
    for(int i = 0; i<prices.length; i++) {
      int cnt = 0;
      for(int j = i+1; j<prices.length; j++) {
        cnt++;
        if(prices[i]>prices[j])
          break;
      }
      answer[i] = cnt;
    }
    return answer;
  }
}
// 주어진 테케로 버그 못 잡겠어서 질문하기 들어갔는데 {1,2,3,2,3,1} > {5,4,1,2,1,0} 라는 예제보니까 딱 떠오르더라
// 원래 prices[i]>prices[j]일 때 cnt가 0일 때만 나오도록 했는데 그런 게 아니라 그냥 작아져도 +1을 해주는 거였음
// 그 문장 지우고 보니까 모든 곳에 cnt++이 있길래 추가할 때 검사하는 게 아니라 나올 때 조건 비교하도록 바꿨다 그러니 바로 성공....
