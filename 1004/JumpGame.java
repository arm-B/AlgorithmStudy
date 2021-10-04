import java.util.*;
public class JumpGame {
  static int n;
  static int cache[][] = new int[100][100];
  static int board[][] = new int[100][100];
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    
    for(int i = 0; i<n; i++) {
      for(int j = 0 ; j<n; j++) {
        board[i][j] = sc.nextInt();
        cache[i][j] = -1;
      }
    }
    System.out.println(jumping(0,0)==1? "YES":"NO");
  }
  
  //책에 있는 코드 그대로 작성... ^~^
  public static int jumping(int y, int x) {
    if(y>=n || x >= n) //범위 벗어남
      return 0;			
    if(y == n-1 && x == n-1) //끝지점 도착
      return 1;
    if(cache[y][x] != -1)
      return cache[y][x];
    
    int jumpSize = board[y][x];
    
    return cache[y][x] = jumping(y+jumpSize, x) | jumping(y, x+jumpSize);
  }
}
