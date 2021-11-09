// 이전에 풀었던 방식
import java.util.*;
class Solution {
  public int[] solution(int[] answers) {
    List<Integer> correct = new ArrayList<Integer>();
    int check1[] = {1, 2, 3, 4, 5};
    int check2[] = {2, 1, 2, 3, 2, 4, 2, 5};
    int check3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    for(int i = 0; i<3; i++) correct.add(0);
    for(int i =0; i<answers.length; i++) {
      if(answers[i] == check1[i%5])
        correct.set(0, correct.get(0)+1);
      if(answers[i] == check2[i%8])
        correct.set(1, correct.get(1)+1);
      if(answers[i] == check3[i%10])
        correct.set(2, correct.get(2)+1);		  
    }
    int max = Collections.max(correct);
    List<Integer> tmp = new ArrayList<Integer>();
    for(int i = 0; i<correct.size();i++)
      if(correct.get(i) == max)
        tmp.add(i+1);
    int[] answer = new int[tmp.size()]; 
    int cnt = 0; 
    for(int num : tmp)
      answer[cnt++] = num;
    return answer;
  }
}

// 새로 풀어봄
// 배열 길이로 나머지 구해야하는데 또또또 까먹고 싹다 %5해서 틀림
// 나도 어이가 없다...
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] fir = {1, 2, 3, 4, 5};
        int[] sec = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thi = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        ArrayList<Integer> answer = new ArrayList<>();
        int[] cnt = new int[3];
        
        for(int i = 0; i<answers.length; i++){
            if(answers[i] == fir[i%fir.length])
                cnt[0]++;
            if(answers[i] == sec[i%sec.length])
                cnt[1]++;
            if(answers[i] == thi[i%thi.length])
                cnt[2]++;
        }
        int max = (cnt[0]>cnt[1])&&(cnt[0]>cnt[2])?cnt[0]:(cnt[2]>cnt[1]?cnt[2]:cnt[1]);
        for(int i = 0; i<3; i++)
            if(cnt[i] == max)
                answer.add(i+1);
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
