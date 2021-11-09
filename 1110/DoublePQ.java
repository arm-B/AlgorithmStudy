import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;
        for(int i = 0; i<operations.length; i++){            
            st = new StringTokenizer(operations[i], " ");
            String type = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if(type.equals("I")){
                pq.offer(value);
            }
            else if (type.equals("D") && !pq.isEmpty()){
                if (value == -1){    //최솟값
                    pq.poll();
                }
                else if(value == 1){ //최댓값
                    while(!pq.isEmpty()){
                        maxpq.offer(pq.poll());
                    }
                    maxpq.poll();
                    while(!maxpq.isEmpty()){
                        pq.offer(maxpq.remove());
                    }
                }
            }
        }
        if(pq.size()>1){
            answer[1] = pq.poll();
            while(!pq.isEmpty()){
                maxpq.offer(pq.poll());
            }
            answer[0] = maxpq.poll();
        }
        else if(pq.size() == 1){
            answer[0] = answer[1] = pq.poll();
        }
        else
            answer[0] = answer[1] = 0;
        
        return answer;
    }
}

import java.util.*;
class Solution {
  public int[] solution(String[] operations) {
    int[] answer = new int[2];
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    for(int i = 0; i<operations.length; i++){
      StringTokenizer st = new StringTokenizer(operations[i]);
      String act = st.nextToken();
      int num = Integer.parseInt(st.nextToken());
      
      if(act.equals("I")){
        min.offer(num);
        max.offer(num);
      }
      if(act.equals("D") && !min.isEmpty()){
        if(num>0){
          max.clear();
          while(!min.isEmpty())
            max.offer(min.poll());
          max.poll();
          for(int a : max)
            min.offer(a);
        }
        else if(num<0){ 
          min.clear();
          while(!max.isEmpty())
            min.offer(max.poll());
          min.poll();;
          for(int b : min)
            max.offer(b);
        }
      }
    }
    if(!min.isEmpty()){
      answer[0] = max.peek();
      answer[1] = min.peek();
    }
    return answer;
  }
}
//저번에 했던 거랑 다르게 해보겠다고 min max 둘다 채웠는데... 굳이 이럴 필요는 없을 것 같음... 마지막 answer 뽑아내는 내용만 짧아지고 for문은 더 길어지고... 결국 쌤쌤
