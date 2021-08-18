// **
// 안해
// 동보민 자구 들을 때 봤던 아이스크림 가게 조금 변형한 거라 생각해서 그렇게 풀려고
// 고객 기준으로 시간 빌 때마다 넣고 빼고 해봤지만
// 응~ 안돼
// 왜 이분탐색이라는 건지... 일단 여기에서 막혔고 머리 더이상 안 돌아감 방금그곡에서 모든 힘 다 뺌 지금

// 구글링 최고
// https://iamheesoo.github.io/blog/algo-prog43238
// 위의 사이트를 보고 왔다
// '심사관들이 몇 명을 심사할 수 있는지 계산하여 n보다 크면 시간을 줄이고, n보다 작으면 시간을 늘린다'
// 라고하는데...
// ㅇ... 모르겠어요 일단 시간 answer로 차례차례 count하는 게 아니라는 건 알겠음

// 심사관 한 명이 검사할 수 있는 사람 수가 mid / times
// 그걸 다 더하면 있는 검사관들이 총 몇명의 사람을 검사했는지 알 수 있음 그게 sum
// sum 값이 n보다 크면 지금 시간이 널널하다는 뜻이니까 아래쪽으로 탐색 들어가고 같으면 더 최소로 찾으려고 또 내려가는 듯... 그렇게 범위 줄이는 거지 뭐...
// 아니면 시간 좀 더 있어야한다는 거니까 위쪽으로 탐색들어가고...
// 아 이거 주석 달면서 왜 이렇게 검사할 수 있는 사람을 세는지 이해했음...... 나는 그냥 바보였구요..~

class Solution {
  public long solution(int n, int[] times) {
    long min = 1, max = (long)times[times.length-1]*n;
    long mid = 0;
    long answer = max;
    
    while(min <= max){   
      long sum = 0;
      mid=(min+max)/2;
      for(int time:times){
        sum += mid / time;
      }          
      if(sum >= n){
        if(mid < answer){
          answer = mid;
        }
        max = mid - 1;
      }
      else
        min = mid + 1;
    }
    return answer;
  }
}
