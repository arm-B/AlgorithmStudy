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
            System.out.print(type+' ');
            System.out.print(value);
            System.out.print("  ");
            System.out.println(type.equals("I"));
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
                        pq.offer(maxpq.poll());
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
      //answer[1]이 최소고 answer[0]이 최대구나...
      //다 풀어놓고 여기서 헤매고 있었구나...
        else if(pq.size() == 1){
            answer[0] = answer[1] = pq.poll();
        }
        else
            answer[0] = answer[1] = 0;
        
        return answer;
    }
}
