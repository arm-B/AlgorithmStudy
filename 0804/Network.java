import java.util.*;
class Solution {
  static boolean visit[];
  static int count;
  
  public int solution(int n, int[][] computers) {
    visit = new boolean[n];
    count = 0;
    isNet(computers, 0);
    return count;
  }
  
  public static void isNet(int[][] computers, int start) {
    for(int i = start; i<computers.length; i++) {
      if(!visit[i]) {
        count++; 
        Queue<Integer> queue = new LinkedList<Integer>();
        visit[i] = true;
        queue.add(i);
        while(queue.size() != 0) {
          int v = queue.poll();
          for(int j = 0; j<computers.length; j++) {
            if(computers[v][j] == 1 && !visit[j]) {
              visit[j] = true;
              queue.add(j);
            }
          }
        }
      }
    }
  }
} //괄호 봐라...
