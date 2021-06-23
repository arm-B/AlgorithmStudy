class Solution {
  public int solution(int[] numbers, int target) {
    int answer = countTargetNum(numbers, target, numbers[0], 1) + countTargetNum(numbers, target, -numbers[0], 1);
    return answer;
  }
  static public int countTargetNum(int[] numbers, int target, int sum, int index) {
    if(index == numbers.length) {
      if(sum == target)
        return 1;
      else
        return 0;
    }
    int count = 0;
    count += countTargetNum(numbers, target, sum+numbers[index], index+1);
    count += countTargetNum(numbers, target, sum-numbers[index], index+1);
    return count;
  }
}
