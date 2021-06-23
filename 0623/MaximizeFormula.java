import java.util.*;
class Solution {
  static ArrayList<Long> operand;
  static ArrayList<Character> operator;
  static char check[] = {'-', '*', '+'};
  static List<Integer> position;
  public long solution(String expression) {
    operand = new ArrayList<>();
    operator = new ArrayList<>();
    String sb = "";
    int i = 0;
    long max = 0;
    
    while(i<expression.length()) {
      if(expression.charAt(i) != '-' && expression.charAt(i) != '*' && expression.charAt(i) != '+') {
        sb+=expression.charAt(i);
      }
      else {
        operand.add(Long.parseLong(sb));
        operator.add(expression.charAt(i));
        sb = "";
      }
      i++;
    }
    operand.add(Long.parseLong(sb));
    long answer = findCase();
    return answer;
  }
  static long findValue(int first, int second, int third) {
    ArrayList<Long> BUoperand = (ArrayList<Long>) operand.clone();
    ArrayList<Character> BUoperator = (ArrayList<Character>) operator.clone();
    int order[] =  {first, second, third};
    for(int i = 0; i<order.length; i++) {
      int j = 0;
      while(j < BUoperator.size()) {
        if(BUoperator.get(j) == check[order[i]]) {
          long a = BUoperand.remove(j);
          long b = BUoperand.remove(j);
          BUoperand.add(j, calculateValue(check[order[i]], a, b));
          BUoperator.remove(j);
        } else
          j++;
      }
    }
    long result = BUoperand.get(0);
    return result;
  }
  
  static long calculateValue(char operator, long a, long b) {
    if(operator == '*')
      return a*b;
    else if(operator == '+')
      return a+b;
    else
      return a-b;
  }
	
  static long findCase() {
    //전공생치고 정직한 탐색
    long max = 0, tmp;
    tmp = Math.abs(findValue(0, 1, 2));	max = max > tmp ? max : tmp;
    tmp = Math.abs(findValue(0, 2, 1));	max = max > tmp ? max : tmp;
    tmp = Math.abs(findValue(1, 2, 0));	max = max > tmp ? max : tmp;
    tmp = Math.abs(findValue(1, 0, 2));	max = max > tmp ? max : tmp;
    tmp = Math.abs(findValue(2, 0, 1));	max = max > tmp ? max : tmp;
    tmp = Math.abs(findValue(2, 1, 0));	max = max > tmp ? max : tmp;
    return max;
  }
}
