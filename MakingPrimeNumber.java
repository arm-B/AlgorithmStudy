class Solution {
  static int answer;
  public int solution(int[] nums) {
    answer = 0;
    for(int i = 0; i<nums.length; i++)
      for(int j = i+1; j<nums.length; j++)
        for(int k = j+1; k<nums.length; k++) {
          isPN(nums[i]+nums[j]+nums[k]);
        }
    return answer;
  }
  
  static void isPN(int N) {
    for(int i = 2; i<N/2+1; i++) {
      if(N % i == 0)
        return;
    }
    answer++;
  }
}
