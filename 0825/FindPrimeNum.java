import java.util.*;
class Solution {
  static ArrayList<Integer> list;
  static boolean[] visited;
  static int answer;
  public int solution(String numbers) {
    int answer = 0;
    list = new ArrayList<>();
    visited = new boolean[numbers.length()];
    
    for(int i = 0; i<numbers.length(); i++)
      for(int j = 0; j<numbers.length(); j++) {
        StringBuffer sb = new StringBuffer();
        sb.append(numbers.charAt(i)); visited[i] = true;
        makeNum(numbers, sb, i, j+1, 1);
        visited[i] = false;
      }
    
    Collections.sort(list);
    int max = list.get(list.size()-1);
    
    boolean notPrime[] = new boolean[max+1];
    notPrime[0] = notPrime[1] = true;
    for(int i=2; i<=max/2; i++)
      for(int j=2; i*j<=max; j++)
        notPrime[i*j]= true;
    
    for(int a : list)
      if(!notPrime[a]) answer++;
        
    return answer;
  }
    
  static void makeNum(String numbers, StringBuffer num, int start, int limit, int count){
    if(count == limit){
      int tmp = Integer.parseInt(num.toString());
      if(!list.contains(tmp))
        list.add(tmp);
      return;
    }
    
    for(int i = 0; i<numbers.length(); i++){
      if(!visited[i]){
        num.append(numbers.charAt(i)); visited[i] = true;
        makeNum(numbers, num, i, limit, count+1);
        num.deleteCharAt(num.length()-1); visited[i] = false;
      }
    }
  }
}

// 처음에 별 생각 없이 visited 안 썼다가 147 같은 거 넣었는데 747 나오는 거 보고 정신 차림
// 고치니까 바로 돌아감... 난 바보야...
