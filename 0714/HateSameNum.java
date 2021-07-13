import java.util.*;
public class Solution {
  public int[] solution(int []arr) {
    ArrayList<Integer> nums = new ArrayList<>();
    int check = -1;
    for(int i = 0; i<arr.length; i++) {
      if(check != arr[i]) {
        nums.add(arr[i]);
        check = arr[i];
      }		
    }
    
    int index = 0;
    int answer[] = new int[nums.size()];
    for(int k : nums) answer[index++] = k;
    return answer;
    
  }
}
