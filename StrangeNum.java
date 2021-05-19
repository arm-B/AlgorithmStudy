import java.util.*;
class Solution {
  public String solution(int n) {
	StringBuilder answer = new StringBuilder();
	Stack<Integer> stack = new Stack<>();
		
	while(n != 0) {
		n = getNum(n, stack);
	}
	while(!stack.isEmpty()) {
		answer.append(stack.pop());
	}
	return answer.toString();

  }
	
  public static int getNum(int n, Stack stack) {
	int q = n/3;
	int r = n%3;

	if(r == 0) {
		q--;
		stack.add("4");
	}else if(r == 1) {
		stack.add("1");
	}else if(r == 2) {
		stack.add("2");
	}
	return q;	
  }
}
