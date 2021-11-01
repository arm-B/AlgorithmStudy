import java.util.*;
class Solution {
  public int solution(int[] people, int limit) {
    int answer = 0;
    float half = limit / 2;
    int left = 0, right = people.length-1;
    int mid = (left + right) /2;
    Arrays.sort(people);
    while(left<=right){
      mid = (left + right) /2 ;
      if(people[mid] >= half)
        right = mid -1;
      else if(people[mid] < half)
        left = mid + 1;
    }
    while(people[mid+1]<=half)
      mid++;
    System.out.println(mid);
    answer += (mid+2)/2;
    answer += (people.length-(mid+1));
    return answer;
  }
}

// 개웃김 30점 나옴
// 사실 안 웃김

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;  
        int left = 2;
        for(int i = 0; i<people.length; i++){
            if(people[i] > limit/2)
                answer++;
            else{
                left--;
                if(left == 0){
                    answer++;
                    left = 2;
                }
            }
            
        }
        if (left < 2) answer++;
        return answer;
    }
}

// 얘도 30점임... 슬슬 뭐가 문제인가 싶음

// 다른 사람 풀이
// 둘이 합쳐 limit을 넘기 전까지는 혼자 타는 놈만 세다가, 둘이 합쳐 limit보다 작거나 같으면 두 명씩 없애는 방식
// ^~^... 한 달 쉬었다고 머리가 굳었다

import java.util.*;
class Solution {
  public int solution(int[] people, int limit) {
    int answer = 0;
    Arrays.sort(people);
    
    int right = people.length - 1;
    int left = 0;
    
    while (right >= left) {
      int weight = people[right--];
      if (weight + people[left] <= limit) {
        left++;
      }
      answer++;
    }
    return answer;
  }
}
