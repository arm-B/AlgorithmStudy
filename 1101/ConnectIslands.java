import java.util.*;
class Solution {
  static int[] parent;
  public int solution(int n, int[][] costs) {
    int answer = 0;
    
    // 찾아보니 다들 Kruskal 알고리즘을 사용하는 것 같다.
    // 자구 배운지 1년 넘었고... 기억이 나지 않습니다.
    // 다른 사람 코드 보면서 이해하고, 크루스칼 복습 좀 해야할 듯...
    
    //가중치 기준 오름차순 정렬
    Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2]-c2[2]);
    
    parent = new int[n];
    
    for(int i = 0; i<n; i++){
      parent[i] = i;
    }
    
    for(int[] edge: costs){
      int from = edge[0];
      int to = edge[1];
      int cost = edge[2];
      
      int fromP = findP(from);
      int toP = findP(to);
      
      if(fromP == toP) continue;
      
      answer += cost;
      parent[toP] = fromP;
    }
    return answer;
  }
  
  private int findP(int node){
    if(parent[node] == node) return node;
    return parent[node] = findP(parent[node]);
  }
}
