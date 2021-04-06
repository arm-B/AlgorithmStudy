import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;     //평균 소요 시간
        int current = 0;	  //끝나는 시간
        int count = 0;      //작업 횟수
        int idx = 0;        //현재 하고 있는 작업의 위치, jobs를 정렬해서 순서대로 사용하므로 가능
        int length = jobs.length;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        //jobs를 요청시간에 대해 오름차순으로 정렬
        //처리시간에 대해 오름차순으로 추가됨
        //잘은 모르겠지만 이차원 배열에 대해 정렬의 대상을 선정할 때 (o1, o2)->o1[i] - o2[i]로 해야하는 듯하다... 알 수 없는 자바의 문법
      
        while(count<length){ //주어진 개수만큼 작업을 모두 처리할 동안
        	while(idx<length  && jobs[idx][0] <= current) {
        		pq.add(jobs[idx++]);
        	}
          //큐에 현재 시간보다 먼저 요청된 것들을 추가한다.
          //앞의 조건 : idx는 작업 목록 jobs에서 어디까지 추가됐는지를 알려주므로, idx가 length를 넘어가면 모든 작업이 큐에 추가된 것이므로 더이상 큐에 추가할 필요가 없어진다.
          //뒤의 조건 : 아직 요청되지도 않은 것을 추가할 수 없으므로 현재 시간보다 먼저 요청된 것들만 추가한다. jobs가 요청시간대로 정렬되어있으므로 순서대로 추가해도 ok
          
        	if(pq.isEmpty()) {
        		current = jobs[idx][0];
        	}
          //큐가 비었다 : 지금 일하고 있는 애는 없지만 while문 내부인 것을 보아하니 작업은 남아있다.
          //다음 작업 시작시간으로 넘어가자.
          
        	else {
        		int[] tmp = pq.poll(); //가장 짧은 애
        		answer += current + tmp[1] - tmp[0];
        		current += tmp[1];
        		count++;
        	}
          //큐가 안 비어있다 : 당장 일해야할 게 있다. 그 중에서 가장 위에 있는 놈을 뽑아오자. min heap의 규칙대로 추가되었으니 있는 애들 중에 처리 시간이 가장 짧은 애이다.
          //모든 작업의 요청부터 수행까지 얼마나 걸렸는지를 계산하는 answer에 현재 작업을 위해 기다려온 시간과, 처리 시간을 추가해준다.
          //현재 시각 + 작업 시간 - 요청한 시각을 해주면 원하는 값을 구할 수 있다.
          //하나의 작업을 마쳤으니 현재 시간을 그만큼 지나게 만들고, count도 하나 올려준다.
        }
        answer = (int) Math.floor(answer/length);
        return answer;
    }
}
