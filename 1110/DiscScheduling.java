import java.util.*;
class Solution {
  public int solution(int[][] jobs) {
    int answer = 0;     //평균 소요 시간
    int current = 0;	//끝나는 시간
    int count = 0;      //작업 횟수
    int idx = 0;        //현재 하고 있는 작업의 위치, jobs를 정렬할 것이기에 순서대로
    int length = jobs.length;
    Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); //들어온 순서에 따라 정렬
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //소요시간에 따라 정렬
    
    while(count<length){
      while(idx<length  && jobs[idx][0] <= current) {
        //현재 시간보다 늦게 들어오는 애를 먼저 넣을 수는 없음
        //cuurent 그 전에 이미 들어왔던 것중에 가장 짧은 거를 추가.
        pq.add(jobs[idx++]);
      }
      if(pq.isEmpty()) {
        current = jobs[idx][0];
        // 늦게 시작하는 애가 올때까지 대기해야함.
      }
      else {
        int[] tmp = pq.poll(); //가장 짧은 애
        //tmp[0]은 안 들어왔으니 기다리지도 않은 시간. 근데 current를 더해버리면 아예 0m부터 카운트되니까 빼줘야함.
        answer += current + (tmp[1] - tmp[0]);
        current += tmp[1];
        count++;
      }
    }
    answer = (int) Math.floor(answer/length);
    return answer;
  }
}
