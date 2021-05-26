import java.util.*;
class Solution {
  public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> temp = new ArrayList<Integer>();
    int completes[] = new int[progresses.length];
    int max = 0, index=-1;
    
    for(int i = 0; i<progresses.length;i++) {
      completes[i] = calcDays(progresses[i], speeds[i]);
    }
    
    for(int i = 0; i<completes.length; i++) {
      if(completes[i]>max) {
        temp.add(1);
        max = completes[i];
        index++;
      }
			else
				temp.set(index, temp.get(index)+1);
    }
    
    int cnt = 0; 
    int answer[] = new int[temp.size()];
    for(int num : temp)
      answer[cnt++] = num;
    return answer;
  }
  
  static int calcDays(int progress, int speed) {
    int day = 0;
    while(progress<100) {
      progress += speed;
      day++;
    }
    return day;
  }
}
