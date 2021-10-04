import java.util.*;
public class TrianglePath {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int tc = sc.nextInt();
    for(int i = 0 ; i<tc; i++) {
      int n = sc.nextInt();
      int tri[][] = new int[n][n];
      for(int r = 0; r<n; r++)
        for(int c = 0; c<r+1; c++)
          tri[r][c] = sc.nextInt();
      
      for(int r = 1; r<n; r++)
        for(int c = 0; c<n; c++) {
          if(c == 0)
            tri[r][c] += tri[r-1][c];
          else if (c == n-1)
            tri[r][c] += tri[r-1][c-1];
          else
            tri[r][c] += Math.max(tri[r-1][c], tri[r-1][c-1]);
        }
      
      int max = 0;
      for(int a : tri[n-1])
        if(a>max) max = a;
      System.out.println(max);
    }
  }
}
