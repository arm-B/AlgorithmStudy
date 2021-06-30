import java.util.*;
class Solution {
  //앞으로 갈 방향 위, 오른쪽, 아래, 왼쪽
  static int[] dx = {0, 1, 0, -1};
  static int[] dy = {-1, 0, 1, 0};
  static boolean[][] visited;
  static int n;
  static int m;
  
  public int solution(int[][] maps) {
    n = maps.length;
    m = maps[0].length;
    visited = new boolean[n][m];
    int answer = bfs(0, 0, maps);
    return answer;
  }
  
  static public int bfs(int x, int y, int[][]maps) {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(x, y, 1));
    visited[x][y] = true;
    
    while(!q.isEmpty()) {
      Node node = q.poll();
      if(node.x == n-1 && node.y == m-1) return node.cost;
      
      for(int i = 0; i < 4; i++) {
        int nx = node.x + dx[i];
        int ny = node.y + dy[i];
        if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
          if(maps[nx][ny] == 1 && !visited[nx][ny]) {
            //게임맵 내부의 갈 수 있는 길이고, 아직 가지 않았다면
            visited[nx][ny] = true;
            q.offer(new Node(nx, ny, node.cost + 1));
          }
        }
      }   
    }
    return -1;
  }
  
  static public class Node{
    int x;
    int y;
    int cost;
    
    public Node(int x, int y, int cost) {
      this.x = x;
      this.y = y;
      this.cost = cost;
    }
  }
}
